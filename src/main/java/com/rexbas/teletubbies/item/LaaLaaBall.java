package com.rexbas.teletubbies.item;

import com.rexbas.bouncingballs.api.item.BouncingBall;
import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import com.rexbas.teletubbies.init.TeletubbiesSounds;

import net.minecraft.item.Item;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.SoundEvent;

public class LaaLaaBall extends BouncingBall {

	public LaaLaaBall() {
		super(new Item.Properties().tab(Teletubbies.TAB), new BouncingBall.Properties(1f, 1f, 10f, 0)
				.recipeItem(TeletubbiesItems.LAALAA_ANTENNA.get())
				.addFluid(FluidTags.WATER));
	}
	
	@Override
	public SoundEvent getBounceSound() {
		return TeletubbiesSounds.BALL_BOUNCE.get();
	}
}