package teletubbies.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import teletubbies.init.TeletubbiesItems;

public class ItemGroupTeletubbies extends ItemGroup {

	public ItemGroupTeletubbies(String name) {
		super(name);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(TeletubbiesItems.PO_STICK.get());
	}
}
