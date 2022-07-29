package com.rexbas.teletubbies.inventory.container;

import java.util.Objects;

import com.rexbas.teletubbies.init.TeletubbiesContainers;
import com.rexbas.teletubbies.inventory.container.handler.ToastMachineItemHandler;
import com.rexbas.teletubbies.inventory.container.slot.SpecificItemSlot;
import com.rexbas.teletubbies.tileentity.ToastMachineTileEntity;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.CapabilityItemHandler;

public class ToastMachineContainer extends Container {
	
	private final PlayerInventory playerInventory;
	private final ToastMachineTileEntity tileentity;
	
	// Client Constructor
	public ToastMachineContainer(final int id, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(id, playerInventory, getTileEntity(playerInventory, data));
	}

	// Server Constructor
	public ToastMachineContainer(int id, PlayerInventory playerInventory, ToastMachineTileEntity te) {
		super(TeletubbiesContainers.TOAST_MACHINE_CONTAINER.get(), id);
		
		this.playerInventory = playerInventory;
		this.tileentity = te;
		
		ToastMachineItemHandler handler = (ToastMachineItemHandler) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
		
		addMachineSlots(handler);
		addPlayerSlots();
	}
	
	private void addMachineSlots(ToastMachineItemHandler handler) {
		this.addSlot(new SpecificItemSlot(handler, 0, 61, 37, Items.WHEAT));
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
	public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);

		if (slot != null && slot.hasItem()) {
			int slotcount = slots.size() - playerIn.inventory.items.size();
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < slotcount) {
				if (!this.moveItemStackTo(itemstack1, slotcount, this.slots.size(), true))
					return ItemStack.EMPTY;
			} else if (!this.moveItemStackTo(itemstack1, 0, slotcount, false)) {
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty())
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
		}
		return itemstack;
	}

	@Override
	public boolean stillValid(PlayerEntity playerIn) {
		return true;
	}
	
	// https://github.com/DaRealTurtyWurty/1.15-Tut-Mod/blob/master/src/main/java/com/turtywurty/tutorialmod/container/ExampleFurnaceContainer.java
	private static ToastMachineTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof ToastMachineTileEntity) {
			return (ToastMachineTileEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}
	
	public ToastMachineTileEntity getTileEntity() {
		return this.tileentity;
	}
}
