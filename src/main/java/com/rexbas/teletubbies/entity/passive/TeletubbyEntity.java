package com.rexbas.teletubbies.entity.passive;

import java.util.Arrays;
import java.util.Random;

import javax.annotation.Nullable;

import com.rexbas.teletubbies.entity.ai.goal.WaterAvoidingRandomBouncingGoal;
import com.rexbas.teletubbies.init.TeletubbiesItems;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public abstract class TeletubbyEntity extends CreatureEntity {

	protected boolean hasTransferredToZombie = false;
	
	public TeletubbyEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
		Arrays.fill(this.armorDropChances, 1.0F);
		Arrays.fill(this.handDropChances, 1.0F);
	}
	
	public static boolean canSpawn(EntityType<? extends TeletubbyEntity> entityType, IWorld world, SpawnReason reason, BlockPos pos, Random rand) {
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
			this.setItemSlot(EquipmentSlotType.LEGS, stack);
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
	public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData spawnData, @Nullable CompoundNBT dataTag) {
		spawnData = super.finalizeSpawn(world, difficulty, reason, spawnData, dataTag);
		this.populateDefaultEquipmentSlots(difficulty);
		return spawnData;
	}
	
	public abstract EntityType<?> getZombie();
	
	public void transferToZombie() {
		ZombieEntity zombie = (ZombieEntity) this.getZombie().create(level);
		zombie.copyPosition(this);
		this.hasTransferredToZombie = true;
		this.remove();
		
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