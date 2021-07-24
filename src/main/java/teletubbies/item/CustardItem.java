package teletubbies.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.config.Config;
import teletubbies.init.TeletubbiesItems;

public class CustardItem extends Item {
	
	private static final Food CUSTARD_FOOD = new Food.Builder()
			.nutrition(Config.COMMON.CUSTARD_HUNGER.get())
			.saturationMod(Config.COMMON.CUSTARD_SATURATION.get().floatValue())
			.build();
	
	public CustardItem() {
		super(new Item.Properties()
				.food(CUSTARD_FOOD)
				.stacksTo(1)
				.tab(Teletubbies.ITEMGROUP));
	}
	
	@Override
	public UseAction getUseAnimation(ItemStack stack) {
		return UseAction.DRINK;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
		super.finishUsingItem(stack, world, entity);
		return new ItemStack(TeletubbiesItems.BOWL.get());
	}
}
