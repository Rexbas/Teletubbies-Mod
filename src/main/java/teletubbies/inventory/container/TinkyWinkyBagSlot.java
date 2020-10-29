package teletubbies.inventory.container;

import javax.annotation.Nonnull;

import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
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
		
		if (stack.getItem() instanceof BlockItem) {
			if (((BlockItem) stack.getItem()).getBlock().isIn(BlockTags.SHULKER_BOXES)) {
				return false;
			}
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
