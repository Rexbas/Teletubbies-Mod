package com.rexbas.teletubbies.entity.monster;

import com.rexbas.teletubbies.init.TeletubbiesItems;

import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import teletubbies.init.TeletubbiesItems;

public class LaaLaaZombieEntity extends TeletubbyZombieEntity {

	public LaaLaaZombieEntity(EntityType<? extends Zombie> type, Level world) {
		super(type, world);
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
		super.populateDefaultEquipmentSlots(difficulty);
		int i = this.random.nextInt(10);
		switch (i) {
		case 0:
			ItemStack stack = new ItemStack(TeletubbiesItems.LAALAA_BIB.get());
			int damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamageValue(damage);
			this.setItemSlot(EquipmentSlot.CHEST, stack);
			break;
		case 1:
			this.setItemSlot(EquipmentSlotType.OFFHAND, new ItemStack(TeletubbiesItems.LAALAA_BALL.get()));
			break;
		}
	}
}