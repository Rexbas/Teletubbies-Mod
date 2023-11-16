package com.rexbas.teletubbies.inventory.container.slot;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class CustardMachineOutputSlot extends SlotItemHandler {

	public CustardMachineOutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
	public boolean mayPlace(ItemStack stack) {
		return false;
	}
}
