package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class DipsyStick extends Item {

	public DipsyStick() {
		setMaxDamage(1);
		maxStackSize = 64;
		setUnlocalizedName("DipsyStick");
		setTextureName("teletubbies:DipsyStick");
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
