package teletubbies.inventory.container.handler;

import javax.annotation.Nonnull;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.items.ItemStackHandler;

public class ToastMachineItemHandler extends ItemStackHandler {

	public ToastMachineItemHandler() {
		super(1);
	}
	
    @Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return stack.getItem().equals(Items.WHEAT);
    }
}
