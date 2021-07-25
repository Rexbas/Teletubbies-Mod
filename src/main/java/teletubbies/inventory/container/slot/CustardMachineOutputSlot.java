package teletubbies.inventory.container.slot;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class CustardMachineOutputSlot extends SlotItemHandler {

	public CustardMachineOutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
		super(itemHandler, index, xPosition, yPosition);
	}
	
	public boolean mayPlace(ItemStack stack) {
		return false;
	}
}
