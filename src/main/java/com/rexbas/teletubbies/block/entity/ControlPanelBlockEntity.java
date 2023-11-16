package com.rexbas.teletubbies.block.entity;

import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.inventory.container.ControlPanelContainer;
import com.rexbas.teletubbies.inventory.container.handler.ControlPanelItemHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ControlPanelBlockEntity extends BlockEntity implements MenuProvider {

	private final ControlPanelItemHandler inputHandler = new ControlPanelItemHandler();
	
	public ControlPanelBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.CONTROL_PANEL_BLOCK_ENTITY.get(), pos, state);
	}

	@Override
	public AbstractContainerMenu createMenu(final int windowID, final Inventory playerInv, final Player player) {
		return new ControlPanelContainer(windowID, playerInv, this);
	}
	
	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		this.inputHandler.deserializeNBT(nbt.getCompound("InventoryIn"));
	}

	@Override
	public void saveAdditional(CompoundTag nbt) {
		super.saveAdditional(nbt);
		nbt.put("InventoryIn", this.inputHandler.serializeNBT());
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
    public <T> @NotNull LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == Capabilities.ITEM_HANDLER) {
			// Can empty any ItemHandlers (Bags)
			if (side == Direction.DOWN) {
				if (inputHandler.getStackInSlot(0).getCapability(Capabilities.ITEM_HANDLER).isPresent()) {
					LazyOptional<IItemHandler> bagHandler = inputHandler.getStackInSlot(0).getCapability(Capabilities.ITEM_HANDLER);
					return bagHandler.cast();
				}
			}
			else {
				LazyOptional<IItemHandler> instance = LazyOptional.of(() -> inputHandler);
				return instance.cast();
			}
		}
		return super.getCapability(cap, side);
	}

	@Override
	public @NotNull Component getDisplayName() {
		return Component.translatable("block.teletubbies.control_panel");
	}
}