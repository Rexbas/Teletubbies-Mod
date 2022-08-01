package com.rexbas.teletubbies.entity.monster;

import java.util.Arrays;

import javax.annotation.Nullable;

import com.rexbas.bouncingballs.api.capability.BounceCapability;
import com.rexbas.bouncingballs.api.item.IBouncingBall;
import com.rexbas.teletubbies.init.TeletubbiesItems;

import net.minecraft.core.Direction;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;

public class TeletubbyZombieEntity extends Zombie {

	public TeletubbyZombieEntity(EntityType<? extends Zombie> type, Level level) {
		super(type, level);
		Arrays.fill(this.armorDropChances, 1.0F);
		Arrays.fill(this.handDropChances, 1.0F);
	}
	
	@Override
	public boolean isBaby() {
		return false;
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
		super.populateDefaultEquipmentSlots(difficulty);
		int i = this.random.nextInt(10);
		switch (i) {
		case 0:
			ItemStack stack = new ItemStack(TeletubbiesItems.TUTU.get());
			int damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamageValue(damage);
			this.setItemSlot(EquipmentSlot.LEGS, stack);
			break;
		}
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
}