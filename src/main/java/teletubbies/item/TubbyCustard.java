package teletubbies.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class TubbyCustard extends ItemFood {

	private final String name = "TubbyCustard";
	
	public TubbyCustard(int hunger, float saturation, boolean isWolfFood) {
		super(hunger, saturation, isWolfFood);
		maxStackSize = 1;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack) {
		return EnumAction.DRINK;
	}

	@Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entity) {
		super.onItemUseFinish(stack, world, entity);
		return new ItemStack(Teletubbies.tubbyBowl);
	}
}
