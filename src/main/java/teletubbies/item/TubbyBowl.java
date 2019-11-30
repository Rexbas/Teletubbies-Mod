package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TubbyBowl extends Item {

	public TubbyBowl() {
		maxStackSize = 64;
		setUnlocalizedName("TubbyBowl");
		setTextureName("teletubbies:TubbyBowl");
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
