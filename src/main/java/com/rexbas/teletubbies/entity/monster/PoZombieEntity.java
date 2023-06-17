package com.rexbas.teletubbies.entity.monster;

import com.rexbas.teletubbies.init.TeletubbiesItems;

import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PoZombieEntity extends TeletubbyZombieEntity {

	public PoZombieEntity(EntityType<? extends Zombie> type, Level world) {
		super(type, world);
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
		super.populateDefaultEquipmentSlots(random, difficulty);
		int i = this.random.nextInt(10);
		ItemStack stack;
		int damage;
		switch (i) {
			case 0 -> {
				stack = new ItemStack(TeletubbiesItems.PO_BIB.get());
				damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
				stack.setDamageValue(damage);
				this.setItemSlot(EquipmentSlot.CHEST, stack);
			}
			case 1 -> {
				stack = new ItemStack(TeletubbiesItems.PO_HELMET.get());
				damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
				stack.setDamageValue(damage);
				this.setItemSlot(EquipmentSlot.HEAD, stack);
			}
		}

		if (this.random.nextInt(20) == 0) {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(TeletubbiesItems.PO_SCOOTER.get()));
		}
	}
}
