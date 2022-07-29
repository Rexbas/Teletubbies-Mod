package com.rexbas.teletubbies.item;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.config.Config;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class ToastItem extends Item {
	
	private static final Food TOAST_FOOD = new Food.Builder()
			.nutrition(Config.COMMON.TOAST_HUNGER.get())
			.saturationMod(Config.COMMON.TOAST_SATURATION.get().floatValue())
			.fast()
			.build();

	public ToastItem() {
		super(new Item.Properties()
				.food(TOAST_FOOD)
				.tab(Teletubbies.ITEMGROUP));
	}
}
