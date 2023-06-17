package com.rexbas.teletubbies.inventory.container.handler;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

public class ControlPanelItemHandler extends ItemStackHandler {

	public ControlPanelItemHandler() {
		super(1);
	}
	
	@Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return stack.getCapability(ForgeCapabilities.ITEM_HANDLER).isPresent();
    }
}
