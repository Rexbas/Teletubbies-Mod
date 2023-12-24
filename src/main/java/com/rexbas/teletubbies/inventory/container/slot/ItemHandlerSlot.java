package com.rexbas.teletubbies.inventory.container.slot;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class ItemHandlerSlot extends SlotItemHandler {
	
	public ItemHandlerSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
    @Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
    	return stack.getCapability(Capabilities.ItemHandler.ITEM) != null;
    }
}
