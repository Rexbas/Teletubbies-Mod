package com.rexbas.teletubbies.entity.passive;

import java.util.Arrays;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.InteractGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import teletubbies.init.TeletubbiesItems;

public abstract class TeletubbyEntity extends PathfinderMob {

	protected boolean hasTransferredToZombie = false;
	
	public TeletubbyEntity(EntityType<? extends PathfinderMob> type, Level world) {
		super(type, world);
		Arrays.fill(this.armorDropChances, 1.0F);
		Arrays.fill(this.handDropChances, 1.0F);
	}
	
	public static boolean canSpawn(EntityType<? extends TeletubbyEntity> entityType, LevelAccessor world, MobSpawnType reason, BlockPos pos, Random rand) {
		return true;
	}
	
	@Override
	protected void registerGoals() {
		this.goalSelector.addGoal(0, new SwimGoal(this));
	    this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, ZombieEntity.class, 8.0F, 0.5D, 0.5D));
		this.goalSelector.addGoal(2, new PanicGoal(this, 0.7F));
		this.goalSelector.addGoal(3, new TemptGoal(this, 0.45F, false, Ingredient.of(TeletubbiesItems.TOAST.get(), TeletubbiesItems.CUSTARD.get())));
		this.goalSelector.addGoal(4, new WaterAvoidingRandomBouncingGoal(this, 0.45F));
		this.goalSelector.addGoal(5, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 10F, 0.9F));
		this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
	}
	
	@Override
	protected boolean shouldDropExperience() {
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
	protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
		int i = this.random.nextInt(15);
		switch (i) {
		case 0:
			ItemStack stack = new ItemStack(TeletubbiesItems.TUTU.get());
			int damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamageValue(damage);
			this.setItemSlot(EquipmentSlot.LEGS, stack);
			break;
		case 1:
			this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(TeletubbiesItems.CUSTARD.get()));
			break;
		case 2:
			this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(TeletubbiesItems.TOAST.get()));
			break;
		}
	}
	
	@Override
	@Nullable
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
		spawnData = super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
		this.populateDefaultEquipmentSlots(difficulty);
		return spawnData;
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
		if (this.isAlive() && capability == BounceCapability.BOUNCE_CAPABILITY) {
			IBouncingBall ball = null;
			if (this.getOffhandItem().getItem() instanceof IBouncingBall) {
				ball = (IBouncingBall) this.getOffhandItem().getItem();
			}
			else if (this.getMainHandItem().getItem() instanceof IBouncingBall) {
				ball = (IBouncingBall) this.getMainHandItem().getItem();
			}
			
			// For Teletubbies only if they have a ball in their hands
			if (ball != null) {
				return super.getCapability(capability, facing);
			}
			return LazyOptional.empty();
		}
		return super.getCapability(capability, facing);
	}
	
	public abstract EntityType<?> getZombie();
	
	public void transferToZombie() {
		Zombie zombie = (Zombie) this.getZombie().create(level);
		zombie.copyPosition(this);
		this.hasTransferredToZombie = true;
		this.remove(RemovalReason.KILLED);
		
		zombie.setBaby(false);
		zombie.setNoAi(this.isNoAi());
		if (this.hasCustomName()) {
			zombie.setCustomName(this.getCustomName());
			zombie.setCustomNameVisible(this.isCustomNameVisible());
		}

		level.addFreshEntity(zombie);
		level.levelEvent(null, 1026, zombie.blockPosition(), 0);
	}
}