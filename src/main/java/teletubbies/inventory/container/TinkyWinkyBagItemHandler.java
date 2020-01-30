package teletubbies.inventory.container;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.items.ItemStackHandler;

public class TinkyWinkyBagItemHandler extends ItemStackHandler {
	
	private ItemStack stack;
	
	public TinkyWinkyBagItemHandler(ItemStack stack) {
		super(27);
		this.stack = stack;
	}
	
    @Override
    protected void onContentsChanged(int slot) {
        super.onContentsChanged(slot);
        save();
    }
    
    public void save() {
        CompoundNBT nbt = stack.getOrCreateTag();
        nbt.put("Inventory", serializeNBT());
    }
    
    public void load() {
        CompoundNBT nbt = stack.getOrCreateTag();
        if (nbt.contains("Inventory")) {
            deserializeNBT(nbt.getCompound("Inventory"));
        }
    }
}
