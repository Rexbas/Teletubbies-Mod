package teletubbies.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import teletubbies.lists.ItemList;

public class TeletubbiesItemGroup extends ItemGroup {

	public TeletubbiesItemGroup(String name) {
		super(name);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemList.poStick);
	}
}
