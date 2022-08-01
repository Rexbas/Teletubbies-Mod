package com.rexbas.teletubbies.entity.passive;

import java.util.Random;

import com.rexbas.teletubbies.init.TeletubbiesSounds;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.InteractGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class NooNooEntity extends PathfinderMob {

	public NooNooEntity(EntityType<? extends PathfinderMob> type, Level world) {
		super(type, world);
	}
	
	public static boolean canSpawn(EntityType<NooNooEntity> entityType, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
		return true;
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new WaterAvoidingRandomStrollGoal(this, 0.3F));
		this.goalSelector.addGoal(1, new InteractGoal(this, Player.class, 10F, 0.9F));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
	}
	
	public static Builder setCustomAttributes() {
		return NooNooEntity.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.5D)
				.add(Attributes.MAX_HEALTH, 25.0D);
	}
	
	@Override
	public int getMaxSpawnClusterSize() {
		return 1;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}
	
	@Override
    public SoundEvent getAmbientSound() {
		return this.random.nextInt(2) == 0 ? TeletubbiesSounds.ENTITY_NOONOO_AMBIENT1.get() : TeletubbiesSounds.ENTITY_NOONOO_AMBIENT2.get();
    }
	
	@Override
	public SoundEvent getHurtSound(DamageSource damageSourceIn) {
		return TeletubbiesSounds.ENTITY_NOONOO_HURT.get();
	}

	@Override
	public SoundEvent getDeathSound() {
		return TeletubbiesSounds.ENTITY_NOONOO_DEATH.get();
	}
}