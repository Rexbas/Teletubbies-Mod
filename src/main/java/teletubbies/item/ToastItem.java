package teletubbies.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import teletubbies.Teletubbies;
import teletubbies.config.FoodConfig;

public class ToastItem extends Item {
	
	private static final Food TOAST_FOOD = new Food.Builder()
			.hunger(FoodConfig.TOAST_HUNGER.get())
			.saturation(FoodConfig.TOAST_SATURATION.get().floatValue())
			.fastToEat()
			.build();

	public ToastItem() {
		super(new Item.Properties()
				.food(TOAST_FOOD)
				.maxStackSize(1)
				.group(Teletubbies.ITEMGROUP));
	}
}
