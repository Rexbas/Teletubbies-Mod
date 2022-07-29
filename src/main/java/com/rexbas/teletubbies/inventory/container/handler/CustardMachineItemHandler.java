package com.rexbas.teletubbies.inventory.container.handler;

import javax.annotation.Nonnull;

import com.rexbas.teletubbies.init.TeletubbiesItems;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
	            return stack.getItem().equals(Items.MILK_BUCKET);
	        case 4:
	            return stack.getItem().equals(Items.SUGAR);
	        case 5:
	            return stack.getItem().equals(Items.EGG);
	        case 6:
	            return stack.getItem().equals(TeletubbiesItems.BOWL.get());
	        }
    	}
    	else if (this.stacks.size() == 5) {
    		switch (slot) {
	        case 0:
	        case 1:
	        case 2:
	        case 3:
	            return stack.getItem().equals(TeletubbiesItems.CUSTARD.get());
	        case 4:
	            return stack.getItem().equals(Items.BUCKET);
	        }
    	}
    		
        return false;
    }
}
