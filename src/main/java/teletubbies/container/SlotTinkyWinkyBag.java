package teletubbies.container;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import teletubbies.item.TinkyWinkyBag;

public class SlotTinkyWinkyBag extends Slot{

	public SlotTinkyWinkyBag(IInventory inv, int index, int x, int y) {
		super(inv, index, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack stack) {
		return !(stack.getItem() instanceof TinkyWinkyBag);
	}
}