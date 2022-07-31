package com.rexbas.teletubbies.inventory.container;

import com.rexbas.teletubbies.init.TeletubbiesContainers;
import com.rexbas.teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import com.rexbas.teletubbies.inventory.container.slot.TinkyWinkyBagSlot;
import com.rexbas.teletubbies.item.TinkyWinkyBagItem;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.CapabilityItemHandler;

// https://github.com/Flanks255/simplybackpacks/tree/master/src/main/java/com/flanks255/simplybackpacks

public class TinkyWinkyBagContainer extends Container {
	public final int numRows = 6;
	private final PlayerInventory playerInventory;
	public ItemStack bag;
	
	public TinkyWinkyBagContainer(final int id, final PlayerInventory playerInventory, PacketBuffer data) {
		this(id, playerInventory,
				playerInventory.player.getMainHandItem().getItem() instanceof TinkyWinkyBagItem
						? playerInventory.player.getMainHandItem()
						: playerInventory.player.getOffhandItem());
    }

	public TinkyWinkyBagContainer(int id, PlayerInventory playerInventory, ItemStack bag) {
		super(TeletubbiesContainers.TINKYWINKY_BAG_CONTAINER.get(), id);
		this.playerInventory = playerInventory;
		this.bag = bag;
		
		TinkyWinkyBagItemHandler handler = (TinkyWinkyBagItemHandler) bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
        handler.load();

		addBagSlots(handler);
		addPlayerSlots();
	}
	
	private void addBagSlots(TinkyWinkyBagItemHandler handler) {
		for (int j = 0; j < this.numRows; ++j) {
			for (int k = 0; k < 9; ++k) {
				this.addSlot(new TinkyWinkyBagSlot(handler, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}
	}
	
	private void addPlayerSlots() {
		int i = (this.numRows - 4) * 18;

		for (int l = 0; l < 3; ++l) {
			for (int j1 = 0; j1 < 9; ++j1) {
				this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
			}
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + i));
		}
	}

	@Override
	public ItemStack quickMoveStack(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);

		if (slot != null && slot.hasItem()) {
			int bagslotcount = slots.size() - playerIn.inventory.items.size();
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < bagslotcount) {
				if (!this.moveItemStackTo(itemstack1, bagslotcount, this.slots.size(), true))
					return ItemStack.EMPTY;
			} else if (!this.moveItemStackTo(itemstack1, 0, bagslotcount, false)) {
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
		return !bag.isEmpty();
	}

	@Override
	public ItemStack clicked(int slot, int dragType, ClickType clickTypeIn, PlayerEntity player) {
		if (slot >= 0) {
			if (getSlot(slot).getItem().getItem() instanceof TinkyWinkyBagItem)
				return ItemStack.EMPTY;
		}
		if (clickTypeIn == ClickType.SWAP)
			return ItemStack.EMPTY;

		if (slot >= 0)
			getSlot(slot).container.setChanged();
		return super.clicked(slot, dragType, clickTypeIn, player);
	}
}