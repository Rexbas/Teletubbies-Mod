package teletubbies.inventory.container.slot;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ToastMachineInputSlot extends SlotItemHandler {

	public ToastMachineInputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
    @Override
	public boolean isItemValid(@Nonnull ItemStack stack) {
    	return stack.getItem().equals(Items.WHEAT);
    }
}
