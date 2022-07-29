package com.rexbas.teletubbies.entity.baby;

import com.rexbas.teletubbies.init.TeletubbiesSounds;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class DaaDaaEntity extends TiddlytubbyEntity {

	public DaaDaaEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
	
	@Override
    public SoundEvent getAmbientSound() {
		return TeletubbiesSounds.ENTITY_DAADAA_VOICE.get();
    }
}
