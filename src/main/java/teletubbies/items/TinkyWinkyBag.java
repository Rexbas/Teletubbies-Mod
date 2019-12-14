package teletubbies.items;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TinkyWinkyBag extends Item {
	
	public TinkyWinkyBag() {
		super(new Item.Properties()
				.maxStackSize(1)
				.group(Teletubbies.ITEMGROUP));

		this.setRegistryName(Teletubbies.MODID, "tinkywinky_bag");
	}
}