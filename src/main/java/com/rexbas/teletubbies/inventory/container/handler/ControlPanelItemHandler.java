package com.rexbas.teletubbies.inventory.container.handler;

import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.items.ItemStackHandler;
import javax.annotation.Nonnull;

public class ControlPanelItemHandler extends ItemStackHandler {

	public ControlPanelItemHandler() {
		super(1);
	}
	
	@Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return stack.getCapability(Capabilities.ITEM_HANDLER).isPresent();
    }
}
