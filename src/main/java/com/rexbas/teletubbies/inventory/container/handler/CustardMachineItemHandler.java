package com.rexbas.teletubbies.inventory.container.handler;

import javax.annotation.Nonnull;

import com.rexbas.teletubbies.init.TeletubbiesItems;
import com.rexbas.teletubbies.inventory.container.slot.SpecificItemSlot;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.ItemStackHandler;

public class CustardMachineItemHandler extends ItemStackHandler {
	
	public CustardMachineItemHandler(int size) {
		super(size);
	}
	
    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
    	if (this.stacks.size() == 7) {
	        switch (slot) {
	        case 0:
	        case 1:
	        case 2:
	        case 3:
	            return stack.is(SpecificItemSlot.MILK);
	        case 4:
	            return stack.is(SpecificItemSlot.SUGAR);
	        case 5:
	            return stack.is(SpecificItemSlot.EGG);
	        case 6:
	            return stack.is(SpecificItemSlot.BOWL);
	        }
    	}
    	else if (this.stacks.size() == 5) {
    		switch (slot) {
	        case 0:
	        case 1:
	        case 2:
	        case 3:
	            return stack.is(TeletubbiesItems.CUSTARD.get());
	        case 4:
	            return stack.is(Items.BUCKET);
	        }
    	}
    		
        return false;
    }
}