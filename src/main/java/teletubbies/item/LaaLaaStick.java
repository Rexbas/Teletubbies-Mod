package teletubbies.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class LaaLaaStick extends Item {

	private final String name = "LaaLaaStick";
	
	public LaaLaaStick() {
		setMaxDamage(1);
		maxStackSize = 64;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
