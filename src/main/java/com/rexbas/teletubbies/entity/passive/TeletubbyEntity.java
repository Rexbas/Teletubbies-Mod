package com.rexbas.teletubbies.entity.passive;

import com.rexbas.teletubbies.entity.ai.goal.WaterAvoidingRandomBouncingGoal;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.Arrays;

public abstract class TeletubbyEntity extends PathfinderMob {

	protected boolean hasTransferredToZombie = false;
	
	public TeletubbyEntity(EntityType<? extends PathfinderMob> type, Level world) {
		super(type, world);
		Arrays.fill(this.armorDropChances, 1.0F);
		Arrays.fill(this.handDropChances, 1.0F);
	}
	
	public static boolean canSpawn(EntityType<? extends TeletubbyEntity> entityType, ServerLevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource rand) {
		return true;
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new FloatGoal(this));
	    this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zombie.class, 8.0F, 0.5D, 0.5D));
		this.goalSelector.addGoal(2, new PanicGoal(this, 0.7F));
		this.goalSelector.addGoal(3, new TemptGoal(this, 0.45F, Ingredient.of(TeletubbiesItems.TOAST.get(), TeletubbiesItems.CUSTARD.get()), false));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomBouncingGoal(this, 0.45F));
		this.goalSelector.addGoal(5, new InteractGoal(this, Player.class, 10F, 0.9F));
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
	}
	
	public static Builder setCustomAttributes() {
		return NooNooEntity.createMobAttributes()
				.add(Attributes.MOVEMENT_SPEED, 0.5D)
				.add(Attributes.MAX_HEALTH, 25.0D);
	}
	
	@Override
	public boolean shouldDropExperience() {
		return super.shouldDropExperience() && !hasTransferredToZombie;
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
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		int i = this.random.nextInt(15);
		switch (i) {
			case 0 -> {
				ItemStack stack = new ItemStack(TeletubbiesItems.TUTU.get());
				int damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
				stack.setDamageValue(damage);
				this.setItemSlot(EquipmentSlot.LEGS, stack);
			}
			case 1 -> this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(TeletubbiesItems.CUSTARD.get()));
			case 2 -> this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(TeletubbiesItems.TOAST.get()));
		}
	}
	
	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
		spawnData = super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
		this.populateDefaultEquipmentSlots(world.getRandom(), difficulty);
		return spawnData;
	}

	public abstract EntityType<?> getZombie();
	
	public void transferToZombie() {
		Zombie zombie = (Zombie) this.getZombie().create(level());
		zombie.copyPosition(this);
		this.hasTransferredToZombie = true;
		this.remove(RemovalReason.KILLED);
		
		zombie.setBaby(false);
		zombie.setNoAi(this.isNoAi());
		if (this.hasCustomName()) {
			zombie.setCustomName(this.getCustomName());
			zombie.setCustomNameVisible(this.isCustomNameVisible());
		}

		level().addFreshEntity(zombie);
		level().levelEvent(null, 1026, zombie.blockPosition(), 0);
	}
}