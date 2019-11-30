package teletubbies.item;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import teletubbies.Teletubbies;

public class TubbyToast extends ItemFood {

	private final String name = "TubbyToast";
	
	public TubbyToast(int hunger, float saturation, boolean isWolfFood) {
		super(hunger, saturation, isWolfFood);
		maxStackSize = 64;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.EAT;
	}
}
