package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class TinkyWinkyStick extends Item {

	private final String name = "tinkywinkystick";

	public TinkyWinkyStick () {
		this.maxStackSize = 64;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
