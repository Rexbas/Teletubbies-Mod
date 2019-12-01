package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TinkyWinkyBag extends Item {
	
	public TinkyWinkyBag() {
		super(new Item.Properties()
				.maxStackSize(1)
				.group(Teletubbies.itemGroup));

		this.setRegistryName(Teletubbies.MODID, "tinkywinkybag");
	}
}