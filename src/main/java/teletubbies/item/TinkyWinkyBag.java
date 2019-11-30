package teletubbies.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class TinkyWinkyBag extends Item {

	public TinkyWinkyBag() {
		maxStackSize = 1;
		setUnlocalizedName("TinkyWinkyBag");
		setTextureName("teletubbies:TinkyWinkyBag");
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		player.openGui(Teletubbies.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		return itemstack;
	}
}