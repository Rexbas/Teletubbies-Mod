package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class PoStick extends Item {

	public PoStick() {
		setMaxDamage(1);
		maxStackSize = 64;
		setUnlocalizedName("PoStick");
		setTextureName("teletubbies:PoStick");
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
