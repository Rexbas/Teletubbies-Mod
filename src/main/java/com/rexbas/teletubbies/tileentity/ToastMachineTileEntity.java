package com.rexbas.teletubbies.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.rexbas.teletubbies.block.ToastMachineBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import com.rexbas.teletubbies.init.TeletubbiesSounds;
import com.rexbas.teletubbies.inventory.container.ToastMachineContainer;
import com.rexbas.teletubbies.inventory.container.handler.ToastMachineItemHandler;
import com.rexbas.teletubbies.util.Converter;
import com.rexbas.teletubbies.util.RandomHelper;

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
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ToastMachineTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	private static final long TICKS_PER_BAR = Converter.SecondsToTicks(1.2D / 4.0D);
	private ToastMachineItemHandler handler = new ToastMachineItemHandler();
	private int progress; // [0, 4] -> 4 is cooldown
	private int tickCounter;
    private byte powerList;
	
	public ToastMachineTileEntity() {
		super(TeletubbiesBlocks.TOAST_MACHINE_TILE.get());
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

		if (!level.isClientSide) {
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
			this.setChanged();
			this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
		}
	}
	
	private void setProgressInLightState() {
		BlockState bottomState = level.getBlockState(worldPosition);
		BlockState topState = level.getBlockState(worldPosition.above());
		
		if (this.progress >= 0 && this.progress < 4) {
			if (bottomState.getBlock() instanceof ToastMachineBlock) {
				level.setBlockAndUpdate(worldPosition, bottomState.setValue(ToastMachineBlock.LIT, this.progress));
			}
			if (topState.getBlock() instanceof ToastMachineBlock) {
				level.setBlockAndUpdate(worldPosition.above(), topState.setValue(ToastMachineBlock.LIT, this.progress));
			}
		}
		else {
			if (bottomState.getBlock() instanceof ToastMachineBlock) {
				level.setBlockAndUpdate(worldPosition, bottomState.setValue(ToastMachineBlock.LIT, 0));
			}
			if (topState.getBlock() instanceof ToastMachineBlock) {
				level.setBlockAndUpdate(worldPosition.above(), topState.setValue(ToastMachineBlock.LIT, 0));
			}
		}
	}
	
	public int getProgress() {
		return this.progress;
	}
	
	public void dropToast() {
		if (!level.isClientSide) {
        	ItemEntity item = new ItemEntity(level, worldPosition.getX() + 0.5, worldPosition.getY() + 1.6, worldPosition.getZ() + 0.5, new ItemStack(TeletubbiesItems.TOAST.get()));
        	
        	double motionX, motionY, motionZ;
        	
        	PlayerEntity player = level.getNearestPlayer(item.getX(), item.getY(), item.getZ(), 5.5, false);
        	if (player != null) {
        		Vector3d v = new Vector3d(player.getX() - item.getX(), player.getY() - item.getY(), player.getZ() - item.getZ());
        		v = v.scale(0.05);
        		motionX = v.x();
        		motionZ = v.z();
        	}
        	else {
        		motionX = RandomHelper.getRandomNumber(-0.25, 0.25);
        		motionZ = RandomHelper.getRandomNumber(-0.25, 0.25);
        	}
        	
            motionY = RandomHelper.getRandomNumber(0.45, 0.6);

        	item.setDeltaMovement(motionX, motionY, motionZ);
        	level.addFreshEntity(item);

        	float soundPitch = ToastMachineBlock.isUnderwater(level, worldPosition) ? 0.5F : 1F;
			level.playSound(null, worldPosition, TeletubbiesSounds.MACHINE_TOAST.get(), SoundCategory.BLOCKS, 2, soundPitch);
    	}
	}
	
	public void setPowered(BlockState state) {
		if (state.getValue(ToastMachineBlock.BOTTOM)) {
			this.powerList |= 1 << 0;
		}
		else {
			this.powerList |= 1 << 1;
		}
	}
	
	public void setUnPowered(BlockState state) {
		if (state.getValue(ToastMachineBlock.BOTTOM)) {
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
	public void load(BlockState state, CompoundNBT nbt) {
		super.load(state, nbt);
		this.handler.deserializeNBT(nbt.getCompound("Inventory"));
		this.progress = nbt.getInt("progress");
		this.tickCounter = nbt.getInt("tickCounter");
		this.powerList = nbt.getByte("powerList");
	}

	@Override
	public CompoundNBT save(CompoundNBT nbt) {
		super.save(nbt);
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
		this.save(nbt);
		return new SUpdateTileEntityPacket(this.worldPosition, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		this.load(level.getBlockState(pkt.getPos()), pkt.getTag());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbt = new CompoundNBT();
		this.save(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT nbt) {
		this.load(state, nbt);
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
