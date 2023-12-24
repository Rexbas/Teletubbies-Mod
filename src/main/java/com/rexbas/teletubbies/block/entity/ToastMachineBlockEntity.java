package com.rexbas.teletubbies.block.entity;

import com.rexbas.teletubbies.block.ToastMachineBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import com.rexbas.teletubbies.init.TeletubbiesSounds;
import com.rexbas.teletubbies.inventory.container.ToastMachineContainer;
import com.rexbas.teletubbies.inventory.container.handler.ToastMachineItemHandler;
import com.rexbas.teletubbies.inventory.container.slot.SpecificItemSlot;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ToastMachineBlockEntity extends BlockEntity implements MenuProvider {

	private static final long TICKS_PER_BAR = TeletubbiesBlocks.secondsToTicks(1.2D / 4.0D);
	private final ToastMachineItemHandler handler = new ToastMachineItemHandler();
	private int progress; // [0, 4] -> 4 is cooldown
	private int tickCounter;
    private byte powerList;
	
	public ToastMachineBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.TOAST_MACHINE_BLOCK_ENTITY.get(), pos, state);
		this.progress = 0;
		this.tickCounter = 0;
		this.powerList = 0;
	}
	
	@Override
	public AbstractContainerMenu createMenu(final int windowID, final Inventory playerInv, final Player playerIn) {
		return new ToastMachineContainer(windowID, playerInv, this);
	}

	public void commonTick() {	
		boolean dirty = false;

		if (!level.isClientSide) {
			if (this.isPowered()) {
				if (handler.getStackInSlot(0).is(SpecificItemSlot.GRAIN)) {
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
			this.level.sendBlockUpdated(this.getBlockPos(), this.getBlockState(), this.getBlockState(), Block.UPDATE_CLIENTS);
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
        	
        	Player player = level.getNearestPlayer(item.getX(), item.getY(), item.getZ(), 5.5, false);
        	if (player != null) {
        		Vec3 v = new Vec3(player.getX() - item.getX(), player.getY() - item.getY(), player.getZ() - item.getZ());
        		v = v.scale(0.05);
        		motionX = v.x();
        		motionZ = v.z();
        	}
        	else {
        		motionX = getRandomNumber(-0.25, 0.25);
        		motionZ = getRandomNumber(-0.25, 0.25);
        	}
        	
            motionY = getRandomNumber(0.45, 0.6);

        	item.setDeltaMovement(motionX, motionY, motionZ);
        	level.addFreshEntity(item);

        	float soundPitch = ToastMachineBlock.isUnderwater(level, worldPosition) ? 0.5F : 1F;
			level.playSound(null, worldPosition, TeletubbiesSounds.MACHINE_TOAST.get(), SoundSource.BLOCKS, 2, soundPitch);
    	}
	}
	
	public static double getRandomNumber(double min, double max) {
	    return Math.random() * (max - min) + min;
	}
	
	public void setPowered(BlockState state) {
		if (state.getValue(ToastMachineBlock.BOTTOM)) {
			this.powerList |= 1;
		}
		else {
			this.powerList |= 1 << 1;
		}
	}
	
	public void setUnPowered(BlockState state) {
		if (state.getValue(ToastMachineBlock.BOTTOM)) {
			this.powerList &= ~(1);
		}
		else {
			this.powerList &= ~(1 << 1);
		}
	}
	
	public boolean isPowered() {
		return this.powerList != 0;
	}

	public IItemHandler getItemHandler(@Nullable Direction side) {
		if (side != Direction.DOWN) {
			return this.handler;
		}
		return null;
	}

	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		this.handler.deserializeNBT(nbt.getCompound("Inventory"));
		this.progress = nbt.getInt("progress");
		this.tickCounter = nbt.getInt("tickCounter");
		this.powerList = nbt.getByte("powerList");
	}

	@Override
	public void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		nbt.put("Inventory", this.handler.serializeNBT());
		nbt.putInt("progress", this.progress);
		nbt.putInt("tickCounter", this.tickCounter);
		nbt.putByte("powerList", this.powerList);
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
		return Component.translatable("block.teletubbies.toast_machine");
	}
}