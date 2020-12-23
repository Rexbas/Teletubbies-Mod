package teletubbies.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import teletubbies.block.BlockList;
import teletubbies.block.ToastMachineBlock;
import teletubbies.client.audio.SoundList;
import teletubbies.inventory.container.ToastMachineContainer;
import teletubbies.inventory.container.handler.ToastMachineItemHandler;
import teletubbies.item.ItemList;
import teletubbies.util.Converter;
import teletubbies.util.RandomHelper;

public class ToastMachineTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	private static final long TICKS_PER_BAR = Converter.SecondsToTicks(1.2D / 4.0D);
	private ToastMachineItemHandler handler = new ToastMachineItemHandler();
	private int progress; // [0, 4] -> 4 is cooldown
	private int tickCounter;
    private byte powerList;
	
	public ToastMachineTileEntity() {
		super(BlockList.TOAST_MACHINE_TILE);
		this.progress = 0;
		this.tickCounter = 0;
		this.powerList = 0;
	}
	
	@Override
	public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
		return new ToastMachineContainer(windowID, playerInv, this);
	}

	@Override
	public void tick() {	
		boolean dirty = false;

		if (!world.isRemote) {
			if (this.isPowered()) {
				if (handler.getStackInSlot(0).getItem().equals(Items.WHEAT)) {
					this.tickCounter++;
					
					if (tickCounter >= TICKS_PER_BAR) {
						this.progress++;
						
						if (this.progress == 3) {
							dropToast();
							handler.extractItem(0, 1, false);
						}
						else if (this.progress >= 4) {
							this.progress = 0;
						}
						
						this.setProgressInLightState();
						dirty = true;
						tickCounter = 0;
					}
				}
				else {
					this.progress = 0;
					this.setProgressInLightState();
					dirty = true;
				}
			}
			else {
				this.progress = 0;
				this.setProgressInLightState();
				dirty = true;
			}
		}
		
		if (dirty) {
			this.markDirty();
			this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
		}
	}
	
	private void setProgressInLightState() {
		BlockState bottomState = world.getBlockState(pos);
		BlockState topState = world.getBlockState(pos.up());
		
		if (this.progress >= 0 && this.progress < 4) {
			if (bottomState.getBlock() instanceof ToastMachineBlock) {
				world.setBlockState(pos, bottomState.with(ToastMachineBlock.LIT, this.progress));
			}
			if (topState.getBlock() instanceof ToastMachineBlock) {
				world.setBlockState(pos.up(), topState.with(ToastMachineBlock.LIT, this.progress));
			}
		}
		else {
			if (bottomState.getBlock() instanceof ToastMachineBlock) {
				world.setBlockState(pos, bottomState.with(ToastMachineBlock.LIT, 0));
			}
			if (topState.getBlock() instanceof ToastMachineBlock) {
				world.setBlockState(pos.up(), topState.with(ToastMachineBlock.LIT, 0));
			}
		}
	}
	
	public int getProgress() {
		return this.progress;
	}
	
	public void dropToast() {
		if (!world.isRemote) {
        	ItemEntity item = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.6, pos.getZ() + 0.5, new ItemStack(ItemList.TOAST));
        	
        	double motionX, motionY, motionZ;
        	
        	PlayerEntity player = world.getClosestPlayer(item.posX, item.posY, item.posZ, 5.5, false);
        	if (player != null) {
        		Vec3d v = new Vec3d(player.posX - item.posX, player.posY - item.posY, player.posZ - item.posZ);
        		v = v.scale(0.05);
        		motionX = v.getX();
        		motionZ = v.getZ();
        	}
        	else {
        		motionX = RandomHelper.getRandomNumber(-0.25, 0.25);
        		motionZ = RandomHelper.getRandomNumber(-0.25, 0.25);
        	}
        	
            motionY = RandomHelper.getRandomNumber(0.45, 0.6);

        	item.setMotion(motionX, motionY, motionZ);
        	world.addEntity(item);

        	float soundPitch = ToastMachineBlock.isUnderwater(world, pos) ? 0.5F : 1F;
			world.playSound(null, pos, SoundList.MACHINE_TOAST, SoundCategory.BLOCKS, 2, soundPitch);
    	}
	}
	
	public void setPowered(BlockState state) {
		if (state.get(ToastMachineBlock.BOTTOM)) {
			this.powerList |= 1 << 0;
		}
		else {
			this.powerList |= 1 << 1;
		}
	}
	
	public void setUnPowered(BlockState state) {
		if (state.get(ToastMachineBlock.BOTTOM)) {
			this.powerList &= ~(1 << 0);
		}
		else {
			this.powerList &= ~(1 << 1);
		}
	}
	
	public boolean isPowered() {
		return this.powerList != 0;
	}
	
	@Override
	public void read(CompoundNBT nbt) {
		super.read(nbt);
		this.handler.deserializeNBT(nbt.getCompound("Inventory"));
		this.progress = nbt.getInt("progress");
		this.tickCounter = nbt.getInt("tickCounter");
		this.powerList = nbt.getByte("powerList");
	}

	@Override
	public CompoundNBT write(CompoundNBT nbt) {
		super.write(nbt);
		nbt.put("Inventory", this.handler.serializeNBT());
		nbt.putInt("progress", this.progress);
		nbt.putInt("tickCounter", this.tickCounter);
		nbt.putByte("powerList", this.powerList);
		return nbt;
	}
	
	@Nullable
	@Override
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbt = new CompoundNBT();
		this.write(nbt);
		return new SUpdateTileEntityPacket(this.pos, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.read(pkt.getNbtCompound());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbt = new CompoundNBT();
		this.write(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundNBT nbt) {
		this.read(nbt);
	}
	
	@Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY && side != Direction.DOWN) {
			LazyOptional<IItemHandler> instance = LazyOptional.of(() -> handler);
			return instance.cast();
		}
		return super.getCapability(cap, side);
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("block.teletubbies.toast_machine");
	}
}
