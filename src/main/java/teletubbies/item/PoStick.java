package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class PoStick extends Item {

	private final String name = "PoStick";

	public PoStick() {
		setMaxDamage(1);
		maxStackSize = 64;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
