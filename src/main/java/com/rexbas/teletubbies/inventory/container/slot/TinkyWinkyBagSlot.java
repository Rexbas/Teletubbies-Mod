package com.rexbas.teletubbies.inventory.container.slot;

import javax.annotation.Nonnull;

import com.rexbas.teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import com.rexbas.teletubbies.item.TinkyWinkyBagItem;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class TinkyWinkyBagSlot extends SlotItemHandler {

	public TinkyWinkyBagSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
	@Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
		if (stack.getItem() instanceof TinkyWinkyBagItem) {
			return false;
		}
		
		if (stack.getItem() instanceof BlockItem) {
			if (((BlockItem) stack.getItem()).getBlock().defaultBlockState().is(BlockTags.SHULKER_BOXES)) {
				return false;
			}
		}
		
		if (stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent())
            return false;
		
		if (stack.hasTag()) {
            CompoundTag tag = stack.getTag();
            if (tag.contains("Items") || tag.contains("Inventory")) {
            	return false;
            }
        }
		return super.mayPlace(stack);
	}
	
	@Override
	public void setChanged() {
		super.setChanged();
		if (getItemHandler() instanceof TinkyWinkyBagItemHandler) {
			((TinkyWinkyBagItemHandler) getItemHandler()).save();
		}
	}
}