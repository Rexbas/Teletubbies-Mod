package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TubbyBowl extends Item {

	private final String name = "TubbyBowl";
	
	public TubbyBowl() {
		maxStackSize = 64;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
