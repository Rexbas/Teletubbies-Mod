package teletubbies.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import teletubbies.Teletubbies;
import teletubbies.config.Config;

public class CustardItem extends BowlFoodItem {
	
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
}
