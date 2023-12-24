package com.rexbas.teletubbies.block.entity;

import com.rexbas.teletubbies.block.CustardMachineBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import com.rexbas.teletubbies.init.TeletubbiesSounds;
import com.rexbas.teletubbies.inventory.container.CustardMachineContainer;
import com.rexbas.teletubbies.inventory.container.handler.CustardMachineItemHandler;
import com.rexbas.teletubbies.inventory.container.slot.SpecificItemSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CustardMachineBlockEntity extends BlockEntity implements MenuProvider {

	private static final int DURATION = (int) TeletubbiesBlocks.secondsToTicks(3);
	private final CustardMachineItemHandler inputHandler = new CustardMachineItemHandler(7);
	private final CustardMachineItemHandler outputHandler = new CustardMachineItemHandler(5);
	private int processTime; // Counting down
	private boolean isProcessing;
	private boolean isHoldingBucket;
	
	public CustardMachineBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.CUSTARD_MACHINE_BLOCK_ENTITY.get(), pos, state);
		this.processTime = 0;
		this.isProcessing = false;
	}
	
	@Override
	public AbstractContainerMenu createMenu(final int windowID, final Inventory playerInv, final Player player) {
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
					if (isHoldingBucket)
						outputHandler.insertItem(4, new ItemStack(Items.BUCKET), false);
					isProcessing = false;
					setLightState();
				}
				dirty = true;
			}
			if (canMakeCustard() && !isProcessing) {
				
				for (int i = 0; i < 4; i++) {
					ItemStack inputItem = inputHandler.getStackInSlot(i);
					if (inputItem.is(SpecificItemSlot.MILK)) {
						isHoldingBucket = inputItem.is(Items.MILK_BUCKET);
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
			this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_CLIENTS);
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
			if (inputHandler.getStackInSlot(i).is(SpecificItemSlot.MILK)) {
				if (inputHandler.getStackInSlot(4).is(SpecificItemSlot.SUGAR)
						&& inputHandler.getStackInSlot(5).is(SpecificItemSlot.EGG)
						&& inputHandler.getStackInSlot(6).is(SpecificItemSlot.BOWL)) {

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

	public IItemHandler getItemHandler(@Nullable Direction side) {
		if (side == Direction.DOWN) {
			return this.outputHandler;
		}
		return this.inputHandler;
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
	public void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		nbt.put("InventoryIn", this.inputHandler.serializeNBT());
		nbt.put("InventoryOut", this.outputHandler.serializeNBT());
		nbt.putInt("processTime", this.processTime);
		nbt.putBoolean("isProcessing", this.isProcessing);
	}
	
	@Nullable
	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		this.load(pkt.getTag());
	}

	@Override
	public @NotNull CompoundTag getUpdateTag() {
		CompoundTag nbt = new CompoundTag();
		this.saveAdditional(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(CompoundTag nbt) {
		this.load(nbt);
	}

	@Override
	public @NotNull Component getDisplayName() {
		return Component.translatable("block.teletubbies.custard_machine");
	}
}