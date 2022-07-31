package com.rexbas.teletubbies.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

<<<<<<<< HEAD:src/main/java/com/rexbas/teletubbies/tileentity/ControlPanelBlockEntity.java
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
========
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.inventory.container.ControlPanelContainer;
import com.rexbas.teletubbies.inventory.container.handler.ControlPanelItemHandler;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/tileentity/ControlPanelTileEntity.java
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ControlPanelBlockEntity extends BlockEntity implements MenuProvider {

	private ControlPanelItemHandler inputHandler = new ControlPanelItemHandler();
	
	public ControlPanelBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.CONTROL_PANEL_BLOCK_ENTITY.get(), pos, state);
	}

	@Override
	public AbstractContainerMenu createMenu(final int windowID, final Inventory playerInv, final Player playerIn) {
		return new ControlPanelContainer(windowID, playerInv, this);
	}
	
	@Override
	public void load(CompoundTag nbt) {
		super.load(nbt);
		this.inputHandler.deserializeNBT(nbt.getCompound("InventoryIn"));
	}

	@Override
	public CompoundTag save(CompoundTag nbt) {
		super.save(nbt);
		nbt.put("InventoryIn", this.inputHandler.serializeNBT());
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
			// Can empty any ItemHandlers (Bags)
			if (side == Direction.DOWN) {
				if (inputHandler.getStackInSlot(0).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent()) {
					LazyOptional<IItemHandler> bagHandler = inputHandler.getStackInSlot(0).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
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
	public Component getDisplayName() {
		return new TranslatableComponent("block.teletubbies.control_panel");
	}
}
