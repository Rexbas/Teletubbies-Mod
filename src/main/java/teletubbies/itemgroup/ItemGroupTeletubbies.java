package teletubbies.itemgroup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import teletubbies.init.TeletubbiesItems;

public class ItemGroupTeletubbies extends CreativeModeTab {

	public ItemGroupTeletubbies(String name) {
		super(name);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(TeletubbiesItems.PO_STICK.get());
	}
}
