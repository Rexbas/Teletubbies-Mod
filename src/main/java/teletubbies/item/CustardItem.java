package teletubbies.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import teletubbies.Teletubbies;
import teletubbies.config.Config;
import teletubbies.init.TeletubbiesItems;

public class CustardItem extends Item {
	
	private static final FoodProperties CUSTARD_FOOD = new FoodProperties.Builder()
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
	public UseAnim getUseAnimation(ItemStack stack) {
		return UseAnim.DRINK;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
		super.finishUsingItem(stack, world, entity);
		return new ItemStack(TeletubbiesItems.BOWL.get());
	}
}
