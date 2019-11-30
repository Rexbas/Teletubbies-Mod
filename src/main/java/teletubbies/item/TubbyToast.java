package teletubbies.item;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import teletubbies.Teletubbies;

public class TubbyToast extends ItemFood {

	public TubbyToast(int hunger, float saturation, boolean isWolfFood) {
		super(hunger, saturation, isWolfFood);
		maxStackSize = 64;
		setUnlocalizedName("TubbyToast");
		setTextureName("teletubbies:TubbyToast");
		setCreativeTab(Teletubbies.tabTeletubbies);
	}

	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.eat;
	}
}
