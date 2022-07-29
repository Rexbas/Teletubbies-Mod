package com.rexbas.teletubbies.client.audio;

import com.rexbas.teletubbies.entity.item.PoScooterEntity;
import com.rexbas.teletubbies.init.TeletubbiesSounds;

import net.minecraft.client.audio.TickableSound;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PoScooterTickableSound extends TickableSound {
	private final PoScooterEntity scooter;

	public PoScooterTickableSound(PoScooterEntity scooter) {
		super(TeletubbiesSounds.ENTITY_SCOOTER.get(), SoundCategory.NEUTRAL);
		this.scooter = scooter;
		looping = true;
		delay = 0;
		volume = Float.MIN_VALUE;
	}

	@Override
	public void tick() {
		if (!scooter.isAlive()) {
			this.stop();
			looping = true;
		}
		else {
			x = (float) scooter.getX();
			y = (float) scooter.getY();
			z = (float) scooter.getZ();
			if(((float)scooter.xo != x || (float)scooter.zo != z) && scooter.isVehicle()) {
				volume = 1.0F;
			}
			else {
				volume = 0.0F;
			}
		}		
	}
}