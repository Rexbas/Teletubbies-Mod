package com.rexbas.teletubbies.inventory.container.slot;

import javax.annotation.Nonnull;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.SlotItemHandler;

public class ItemHandlerSlot extends SlotItemHandler {
	
	public ItemHandlerSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
    @Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
    	return stack.getCapability(Capabilities.ITEM_HANDLER).isPresent();
    }
}
