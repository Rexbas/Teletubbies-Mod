package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class DipsyStick extends Item {

	private final String name = "dipsystick";
	
	public DipsyStick () {
		this.maxStackSize = 64;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
