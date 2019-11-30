package teletubbies.item;

import net.minecraft.item.Item;
import teletubbies.Teletubbies;

public class LaaLaaStick extends Item {

	private final String name = "laalaastick";
	
	public LaaLaaStick () {
		this.maxStackSize = 64;
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
