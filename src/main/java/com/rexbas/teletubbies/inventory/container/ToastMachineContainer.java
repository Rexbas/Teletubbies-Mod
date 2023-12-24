package com.rexbas.teletubbies.inventory.container;

import com.rexbas.teletubbies.block.entity.ToastMachineBlockEntity;
import com.rexbas.teletubbies.init.TeletubbiesContainers;
import com.rexbas.teletubbies.inventory.container.handler.ToastMachineItemHandler;
import com.rexbas.teletubbies.inventory.container.slot.SpecificItemSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class ToastMachineContainer extends AbstractContainerMenu {
	
	private final Inventory playerInventory;
	private final ToastMachineBlockEntity blockentity;
	
	// Client Constructor
	public ToastMachineContainer(final int id, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(id, playerInventory, getBlockEntity(playerInventory, data));
	}

	// Server Constructor
	public ToastMachineContainer(int id, Inventory playerInventory, ToastMachineBlockEntity be) {
		super(TeletubbiesContainers.TOAST_MACHINE_CONTAINER.get(), id);
		
		this.playerInventory = playerInventory;
		this.blockentity = be;

		ToastMachineItemHandler handler = (ToastMachineItemHandler) be.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, be.getBlockPos(), null);
		if (handler != null) {
			addMachineSlots(handler);
		}

		addPlayerSlots();
	}
	
	private void addMachineSlots(ToastMachineItemHandler handler) {
		this.addSlot(new SpecificItemSlot(handler, 0, 61, 37, SpecificItemSlot.GRAIN));
	}
	
	private void addPlayerSlots() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}
	
	@Override
	public @NotNull ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);

		if (slot.hasItem()) {
			
			IItemHandler handler = this.blockentity.getLevel().getCapability(Capabilities.ItemHandler.BLOCK, this.blockentity.getBlockPos(), null);
			if (handler != null) {
				ItemStack slotStack = slot.getItem();
				itemstack = slotStack.copy();
				if (index < handler.getSlots()) {
					if (!this.moveItemStackTo(slotStack, handler.getSlots(), this.slots.size(), true)) {
						return ItemStack.EMPTY;
					}
				}
				else if (!this.moveItemStackTo(slotStack, 0, handler.getSlots(), false)) {
					return ItemStack.EMPTY;
				}

				if (slotStack.isEmpty())
					slot.set(ItemStack.EMPTY);
				else
					slot.setChanged();
			}
		}
		return itemstack;
	}

	@Override
	public boolean stillValid(Player playerIn) {
		return true;
	}
	
	// https://github.com/DaRealTurtyWurty/1.15-Tut-Mod/blob/master/src/main/java/com/turtywurty/tutorialmod/container/ExampleFurnaceContainer.java
	private static ToastMachineBlockEntity getBlockEntity(final Inventory playerInv, final FriendlyByteBuf data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final BlockEntity tileAtPos = playerInv.player.level().getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof ToastMachineBlockEntity) {
			return (ToastMachineBlockEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}
	
	public ToastMachineBlockEntity getBlockEntity() {
		return this.blockentity;
	}
}