package teletubbies.inventory.container.slot;

import javax.annotation.Nonnull;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import teletubbies.item.TinkyWinkyBagItem;

public class TinkyWinkyBagSlot extends SlotItemHandler {

	public TinkyWinkyBagSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(@Nonnull ItemStack stack) {
		if (stack.getItem() instanceof TinkyWinkyBagItem) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.WHITE_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.ORANGE_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.MAGENTA_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.LIGHT_BLUE_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.YELLOW_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.LIME_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.PINK_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.GRAY_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.LIGHT_GRAY_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.CYAN_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.PURPLE_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.BLUE_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.BROWN_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.GREEN_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.RED_SHULKER_BOX))) {
			return false;
		}
		if (stack.getItem().equals(Item.BLOCK_TO_ITEM.get(Blocks.BLACK_SHULKER_BOX))) {
			return false;
		}
		
		if (stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent())
            return false;
		
		if (stack.hasTag()) {
            CompoundNBT tag = stack.getTag();
            if (tag.contains("Items") || tag.contains("Inventory")) {
            	return false;
            }
        }
		return super.isItemValid(stack);
	}
	
	@Override
	public void onSlotChanged() {
		super.onSlotChanged();
		if (getItemHandler() instanceof TinkyWinkyBagItemHandler) {
			((TinkyWinkyBagItemHandler) getItemHandler()).save();
		}
	}
}
