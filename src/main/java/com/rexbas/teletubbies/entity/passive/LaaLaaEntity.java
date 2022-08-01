package com.rexbas.teletubbies.entity.passive;

import com.rexbas.teletubbies.init.TeletubbiesEntityTypes;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import com.rexbas.teletubbies.init.TeletubbiesSounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LaaLaaEntity extends TeletubbyEntity {

	public LaaLaaEntity(EntityType<? extends PathfinderMob> type, Level world) {
		super(type, world);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return TeletubbiesSounds.ENTITY_LAALAA_VOICE.get();
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		super.populateDefaultEquipmentSlots(random, difficulty);
		int i = this.random.nextInt(10);
		switch (i) {
		case 0:
			ItemStack stack = new ItemStack(TeletubbiesItems.LAALAA_BIB.get());
			int damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamageValue(damage);
			this.setItemSlot(EquipmentSlot.CHEST, stack);
			break;
		case 1:
			this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(TeletubbiesItems.LAALAA_BALL.get()));
			break;
		}
	}

	@Override
	public EntityType<?> getZombie() {
		return TeletubbiesEntityTypes.LAALAA_ZOMBIE.get();
	}
}