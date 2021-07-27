package teletubbies.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
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

public class CustardMachineBlockEntity extends BlockEntity implements MenuProvider {

	private static final int DURATION = (int) Converter.SecondsToTicks(3);
	private CustardMachineItemHandler inputHandler = new CustardMachineItemHandler(7);
	private CustardMachineItemHandler outputHandler = new CustardMachineItemHandler(5);
	private int processTime; // Counting down
	private boolean isProcessing;
	
	public CustardMachineBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.CUSTARD_MACHINE_BLOCK_ENTITY.get(), pos, state);
		this.processTime = 0;
		this.isProcessing = false;
	}
	
	@Override
	public AbstractContainerMenu createMenu(final int windowID, final Inventory playerInv, final Player playerIn) {
		return new CustardMachineContainer(windowID, playerInv, this);
	}

	public void commonTick() {
		boolean dirty = false;

		if (!level.isClientSide) {
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
				
				float pitch = CustardMachineBlock.isUnderwater(level, worldPosition) ? 0.75F : 1F;
				level.playSound(null, worldPosition, TeletubbiesSounds.MACHINE_CUSTARD.get(), SoundSource.BLOCKS, 2, pitch);
				
				processTime = Math.toIntExact(DURATION);
				isProcessing = true;
				setLightState();
				
				dirty = true;
			}
		}
		
		if (dirty) {
			this.setChanged();
			this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
		}
	}
	
	private void setLightState() {
		if (this.getBlockState().getBlock() instanceof CustardMachineBlock) {
			BlockPos smallTowerPos = CustardMachineBlock.getSmallTowerPos(worldPosition, this.getBlockState().getValue(CustardMachineBlock.FACING));
			BlockPos bigTowerPos = CustardMachineBlock.getBigTowerPos(worldPosition, this.getBlockState().getValue(CustardMachineBlock.FACING));
			
			if (level.getBlockState(smallTowerPos).getBlock() instanceof CustardMachineBlock) {
				level.setBlockAndUpdate(smallTowerPos, level.getBlockState(smallTowerPos).setValue(CustardMachineBlock.LIT, this.isProcessing));
			}
			if (level.getBlockState(bigTowerPos).getBlock() instanceof CustardMachineBlock) {
				level.setBlockAndUpdate(bigTowerPos, level.getBlockState(bigTowerPos).setValue(CustardMachineBlock.LIT, this.isProcessing));
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
	public void load(CompoundTag nbt) {
		super.load(nbt);
		this.inputHandler.deserializeNBT(nbt.getCompound("InventoryIn"));
		this.outputHandler.deserializeNBT(nbt.getCompound("InventoryOut"));
		this.processTime = nbt.getInt("processTime");
		this.isProcessing = nbt.getBoolean("isProcessing");
	}

	@Override
	public CompoundTag save(CompoundTag nbt) {
		super.save(nbt);
		nbt.put("InventoryIn", this.inputHandler.serializeNBT());
		nbt.put("InventoryOut", this.outputHandler.serializeNBT());
		nbt.putInt("processTime", this.processTime);
		nbt.putBoolean("isProcessing", this.isProcessing);
		return nbt;
	}
	
	@Nullable
	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		CompoundTag nbt = new CompoundTag();
		this.save(nbt);
		return new ClientboundBlockEntityDataPacket(this.worldPosition, 0, nbt);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		this.load(pkt.getTag());
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag nbt = new CompoundTag();
		this.save(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag nbt) {
		this.load(nbt);
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
	public Component getDisplayName() {
		return new TranslatableComponent("block.teletubbies.custard_machine");
	}
}
