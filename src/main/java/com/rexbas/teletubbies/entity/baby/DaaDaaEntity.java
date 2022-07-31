package com.rexbas.teletubbies.entity.baby;

import com.rexbas.teletubbies.init.TeletubbiesSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;
import teletubbies.init.TeletubbiesSounds;

public class DaaDaaEntity extends TiddlytubbyEntity {

	public DaaDaaEntity(EntityType<? extends PathfinderMob> type, Level world) {
		super(type, world);
	}
	
	@Override
    public SoundEvent getAmbientSound() {
		return TeletubbiesSounds.ENTITY_DAADAA_VOICE.get();
    }
}
