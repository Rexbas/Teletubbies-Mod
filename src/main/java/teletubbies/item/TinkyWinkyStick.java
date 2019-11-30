package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TinkyWinkyStick extends Item {

	public TinkyWinkyStick() {
		setMaxDamage(1);
		maxStackSize = 64;
		setUnlocalizedName("TinkyWinkyStick");
		setTextureName("teletubbies:TinkyWinkyStick");
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
