package teletubbies.inventory.container.handler;

import javax.annotation.Nonnull;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ControlPanelItemHandler extends ItemStackHandler {

	public ControlPanelItemHandler() {
		super(1);
	}
	
	@Override
    public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
        return stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent();
    }
}
