package com.rexbas.teletubbies.entity.baby;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.InteractGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import teletubbies.init.TeletubbiesItems;
import teletubbies.init.TeletubbiesSounds;

public class TiddlytubbyEntity extends PathfinderMob {
	
	public TiddlytubbyEntity(EntityType<? extends PathfinderMob> type, Level world) {
		super(type, world);
	}
	
	public static boolean canSpawn(EntityType<? extends TiddlytubbyEntity> entityType, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource rand) {
		return true;
	}
	
	@Override
	protected void registerGoals() {
	    this.goalSelector.addGoal(0, new AvoidEntityGoal<>(this, Zombie.class, 8.0F, 0.5D, 0.5D));
		this.goalSelector.addGoal(1, new PanicGoal(this, 0.55F));
		this.goalSelector.addGoal(2, new TemptGoal(this, 0.45F, Ingredient.of(TeletubbiesItems.TOAST.get(), TeletubbiesItems.CUSTARD.get()), false));
		this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.3F));
		this.goalSelector.addGoal(4, new InteractGoal(this, Player.class, 10F, 0.9F));
		this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
	}
	
	public static Builder setCustomAttributes() {
		return TiddlytubbyEntity.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.5D)
				.add(Attributes.MAX_HEALTH, 10.0D);
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
		return this.random.nextInt(2) == 0 ? TeletubbiesSounds.ENTITY_DAADAA_VOICE.get() : TeletubbiesSounds.ENTITY_MIMI_VOICE.get();
    }
}