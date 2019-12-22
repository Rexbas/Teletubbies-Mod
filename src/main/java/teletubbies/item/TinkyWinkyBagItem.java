package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TinkyWinkyBagItem extends Item {
	
	public TinkyWinkyBagItem() {
		super(new Item.Properties()
				.maxStackSize(1)
				.group(Teletubbies.ITEMGROUP));

		this.setRegistryName(Teletubbies.MODID, "tinkywinky_bag");
	}
}