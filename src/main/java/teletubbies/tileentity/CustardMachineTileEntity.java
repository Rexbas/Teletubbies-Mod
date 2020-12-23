package teletubbies.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import teletubbies.block.CustardMachineBlock;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.init.TeletubbiesItems;
import teletubbies.init.TeletubbiesSounds;
import teletubbies.inventory.container.CustardMachineContainer;
import teletubbies.inventory.container.handler.CustardMachineItemHandler;
import teletubbies.util.Converter;

public class CustardMachineTileEntity extends TileEntity implements ITickableTileEntity, INamedContainerProvider {

	private static final int DURATION = (int) Converter.SecondsToTicks(3);
	private CustardMachineItemHandler inputHandler = new CustardMachineItemHandler(7);
	private CustardMachineItemHandler outputHandler = new CustardMachineItemHandler(5);
	private int processTime; // Counting down
	private boolean isProcessing;
	
	public CustardMachineTileEntity() {
		super(TeletubbiesBlocks.CUSTARD_MACHINE_TILE.get());
		this.processTime = 0;
		this.isProcessing = false;
	}
	
	@Override
	public Container createMenu(final int windowID, final PlayerInventory playerInv, final PlayerEntity playerIn) {
		return new CustardMachineContainer(windowID, playerInv, this);
	}

	@Override
	public void tick() {
		boolean dirty = false;

		if (!world.isRemote) {
			if (processTime > 0) {
				processTime--;
				if (processTime == 0) {
					for (int j = 0; j < 4; j++) {
						if (outputHandler.getStackInSlot(j).isEmpty()) {
							outputHandler.insertItem(j, new ItemStack(TeletubbiesItems.CUSTARD.get()), false);
							break;
						}	
					}
					outputHandler.insertItem(4, new ItemStack(Items.BUCKET), false);
					isProcessing = false;
					setLightState();
				}
				dirty = true;
			}
			if (canMakeCustard() && !isProcessing) {
				
				for (int i = 0; i < 4; i++) {
					if (inputHandler.getStackInSlot(i).getItem().equals(Items.MILK_BUCKET)) {
						inputHandler.extractItem(i, 1, false);
						break;
					}	
				}
				inputHandler.extractItem(4, 1, false);
				inputHandler.extractItem(5, 1, false);
				inputHandler.extractItem(6, 1, false);
				
				float pitch = CustardMachineBlock.isUnderwater(world, pos) ? 0.75F : 1F;
				world.playSound(null, pos, TeletubbiesSounds.MACHINE_CUSTARD.get(), SoundCategory.BLOCKS, 2, pitch);
				
				processTime = Math.toIntExact(DURATION);
				isProcessing = true;
				setLightState();
				
				dirty = true;
			}
		}
		
		if (dirty) {
			this.markDirty();
			this.world.notifyBlockUpdate(this.getPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
		}
	}
	
	private void setLightState() {
		if (this.getBlockState().getBlock() instanceof CustardMachineBlock) {
			BlockPos smallTowerPos = CustardMachineBlock.getSmallTowerPos(pos, this.getBlockState().get(CustardMachineBlock.FACING));
			BlockPos bigTowerPos = CustardMachineBlock.getBigTowerPos(pos, this.getBlockState().get(CustardMachineBlock.FACING));
			
			if (world.getBlockState(smallTowerPos).getBlock() instanceof CustardMachineBlock) {
				world.setBlockState(smallTowerPos, world.getBlockState(smallTowerPos).with(CustardMachineBlock.LIT, this.isProcessing));
			}
			if (world.getBlockState(bigTowerPos).getBlock() instanceof CustardMachineBlock) {
				world.setBlockState(bigTowerPos, world.getBlockState(bigTowerPos).with(CustardMachineBlock.LIT, this.isProcessing));
			}
		}
	}
	
	// returns true if the required items are available and the output slots are not filled, also consumes the imput items
	public boolean canMakeCustard() {
		for (int i = 0; i < 4; i++) {
			if (inputHandler.getStackInSlot(i).getItem().equals(Items.MILK_BUCKET)) {
				if (inputHandler.getStackInSlot(4).getItem().equals(Items.SUGAR)
						&& inputHandler.getStackInSlot(5).getItem().equals(Items.EGG)
						&& inputHandler.getStackInSlot(6).getItem().equals(TeletubbiesItems.BOWL.get())) {

					// All items available, check output
					if (outputHandler.getStackInSlot(4).getCount() < outputHandler.getStackInSlot(4).getMaxStackSize()) {
						for (int j = 0; j < 4; j++) {
							if (outputHandler.getStackInSlot(j).isEmpty()) {
								return true;
							}	
						}
					}
				}
			}
		}
		return false;
	}
	
	public float getProgress() {
		return 1f - ((float) this.processTime / DURATION);
	}
	
	public boolean isProcessing() {
		return this.isProcessing;
	}
	
	@Override
	public void read(BlockState state, CompoundNBT nbt) {
		super.read(state, nbt);
		this.inputHandler.deserializeNBT(nbt.getCompound("InventoryIn"));
		this.outputHandler.deserializeNBT(nbt.getCompound("InventoryOut"));
		this.processTime = nbt.getInt("processTime");
		this.isProcessing = nbt.getBoolean("isProcessing");
	}

	@Override
	public CompoundNBT write(CompoundNBT nbt) {
		super.write(nbt);
		nbt.put("InventoryIn", this.inputHandler.serializeNBT());
		nbt.put("InventoryOut", this.outputHandler.serializeNBT());
		nbt.putInt("processTime", this.processTime);
		nbt.putBoolean("isProcessing", this.isProcessing);
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
		this.read(world.getBlockState(pkt.getPos()), pkt.getNbtCompound());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbt = new CompoundNBT();
		this.write(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundNBT nbt) {
		this.read(state, nbt);
	}
	
	@Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			if (side == Direction.DOWN) {
				LazyOptional<IItemHandler> instance = LazyOptional.of(() -> outputHandler);
				return instance.cast();
			}
			else {
				LazyOptional<IItemHandler> instance = LazyOptional.of(() -> inputHandler);
				return instance.cast();
			}
		}
		return super.getCapability(cap, side);
	}

	@Override
	public ITextComponent getDisplayName() {
		return new TranslationTextComponent("block.teletubbies.custard_machine");
	}
}
