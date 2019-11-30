package teletubbies.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class TubbyCustard extends ItemFood {

	public TubbyCustard(int hunger, float saturation, boolean isWolfFood) {
		super(hunger, saturation, isWolfFood);
		maxStackSize = 1;
		setUnlocalizedName("TubbyCustard");
		setTextureName("teletubbies:TubbyCustard");
		setCreativeTab(Teletubbies.tabTeletubbies);
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.drink;
	}

	public ItemStack onEaten(ItemStack par1ItemStack, World par2World,
			EntityPlayer par3EntityPlayer) {
		super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
		return new ItemStack(Teletubbies.tubbyBowl);

	}
}
