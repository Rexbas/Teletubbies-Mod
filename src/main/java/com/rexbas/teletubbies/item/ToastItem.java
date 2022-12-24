package com.rexbas.teletubbies.item;

import com.rexbas.teletubbies.config.Config;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

public class ToastItem extends Item {
	
	private static final FoodProperties TOAST_FOOD = new FoodProperties.Builder()
			.nutrition(Config.COMMON.TOAST_HUNGER.get())
			.saturationMod(Config.COMMON.TOAST_SATURATION.get().floatValue())
			.fast()
			.build();

	public ToastItem() {
		super(new Item.Properties().food(TOAST_FOOD));
	}
}