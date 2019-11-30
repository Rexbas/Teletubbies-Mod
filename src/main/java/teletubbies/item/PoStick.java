package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class PoStick extends Item {

	private final String name = "postick";

	public PoStick () {
		this.maxStackSize = 64;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
