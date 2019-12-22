package teletubbies.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import teletubbies.item.ItemList;

public class ItemGroupTeletubbies extends ItemGroup {

	public ItemGroupTeletubbies(String name) {
		super(name);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.PO_STICK);
	}
}
