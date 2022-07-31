package com.rexbas.teletubbies.entity.baby;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.Level;

public class BaEntity extends TiddlytubbyEntity {

	public BaEntity(EntityType<? extends PathfinderMob> type, Level world) {
		super(type, world);
	}
}
