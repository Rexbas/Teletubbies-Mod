package com.rexbas.teletubbies.inventory.container.handler;

import javax.annotation.Nonnull;

import com.rexbas.teletubbies.inventory.container.slot.SpecificItemSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class ToastMachineItemHandler extends ItemStackHandler {

	public ToastMachineItemHandler() {
		super(1);
	}
	
    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return stack.is(SpecificItemSlot.GRAIN);
    }
}
