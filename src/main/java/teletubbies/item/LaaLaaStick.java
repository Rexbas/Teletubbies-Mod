package teletubbies.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class LaaLaaStick extends Item {

	public LaaLaaStick() {
		setMaxDamage(1);
		maxStackSize = 64;
		setUnlocalizedName("LaaLaaStick");
		setTextureName("teletubbies:LaaLaaStick");
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
}
