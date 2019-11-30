package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TinkyWinkyBag extends Item {

	private final String name = "tinkywinkybag";
	
	public TinkyWinkyBag() {
		maxStackSize = 1;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}