package teletubbies.inventory.container.slot;

import javax.annotation.Nonnull;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SpecificItemSlot extends SlotItemHandler {

	private final Item item;
	
	public SpecificItemSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, Item item) {
		super(itemHandler, index, xPosition, yPosition);
		this.item = item;
	}
	
    @Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
    	return stack.getItem().equals(item);
    }
}
