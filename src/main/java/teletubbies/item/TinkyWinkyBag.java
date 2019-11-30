package teletubbies.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class TinkyWinkyBag extends Item {

	private final String name = "TinkyWinkyBag";
	
	public TinkyWinkyBag() {
		maxStackSize = 1;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		player.openGui(Teletubbies.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		return itemstack;
	}
}