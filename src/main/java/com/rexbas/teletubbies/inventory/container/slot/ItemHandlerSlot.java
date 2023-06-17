package com.rexbas.teletubbies.inventory.container.slot;

import javax.annotation.Nonnull;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ItemHandlerSlot extends SlotItemHandler {
	
	public ItemHandlerSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
    @Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
    	return stack.getCapability(ForgeCapabilities.ITEM_HANDLER).isPresent();
    }
}
