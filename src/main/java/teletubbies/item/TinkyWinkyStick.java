package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TinkyWinkyStick extends Item {

	private final String name = "TinkyWinkyStick";

	public TinkyWinkyStick() {
		setMaxDamage(1);
		maxStackSize = 64;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
