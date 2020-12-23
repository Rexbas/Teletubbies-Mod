package teletubbies.item;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import teletubbies.Teletubbies;
import teletubbies.config.Config;

public class ToastItem extends Item {
	
	private static final Food TOAST_FOOD = new Food.Builder()
			.hunger(Config.COMMON.TOAST_HUNGER.get())
			.saturation(Config.COMMON.TOAST_SATURATION.get().floatValue())
			.fastToEat()
			.build();

	public ToastItem() {
		super(new Item.Properties()
				.food(TOAST_FOOD)
				.group(Teletubbies.ITEMGROUP));
	}
}
