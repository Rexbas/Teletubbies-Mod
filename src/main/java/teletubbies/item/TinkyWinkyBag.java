package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TinkyWinkyBag extends Item {

	private final String name = "TinkyWinkyBag";
	
	public TinkyWinkyBag() {
		maxStackSize = 1;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}