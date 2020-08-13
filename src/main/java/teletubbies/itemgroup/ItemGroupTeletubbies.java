package teletubbies.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import teletubbies.init.ModItems;

public class ItemGroupTeletubbies extends ItemGroup {

	public ItemGroupTeletubbies(String name) {
		super(name);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ModItems.PO_STICK.get());
	}
}
