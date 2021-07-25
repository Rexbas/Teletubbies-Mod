package teletubbies.inventory.container.handler;

import javax.annotation.Nonnull;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
