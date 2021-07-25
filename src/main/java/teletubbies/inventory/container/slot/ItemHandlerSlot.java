package teletubbies.inventory.container.slot;

import javax.annotation.Nonnull;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ItemHandlerSlot extends SlotItemHandler {
	
	public ItemHandlerSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
    @Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
    	return stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent();
    }
}
