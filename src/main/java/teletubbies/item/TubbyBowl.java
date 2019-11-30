package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TubbyBowl extends Item {

	private final String name = "tubbybowl";
	
	public TubbyBowl() {
		maxStackSize = 64;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
