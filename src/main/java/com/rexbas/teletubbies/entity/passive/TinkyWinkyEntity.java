package com.rexbas.teletubbies.entity.passive;

import com.rexbas.teletubbies.init.TeletubbiesEntityTypes;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import com.rexbas.teletubbies.init.TeletubbiesSounds;
import com.rexbas.teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import com.rexbas.teletubbies.item.TinkyWinkyBagItem;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.server.ServerLifecycleHooks;

public class TinkyWinkyEntity extends TeletubbyEntity {
	
	public TinkyWinkyEntity(EntityType<? extends PathfinderMob> type, Level world) {
		super(type, world);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return TeletubbiesSounds.ENTITY_TINKYWINKY_VOICE.get();
	}
	
	@Override
	protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
		super.populateDefaultEquipmentSlots(difficulty);
		int i = this.random.nextInt(10);
		switch (i) {
		case 0:
			ItemStack stack = new ItemStack(TeletubbiesItems.TINKYWINKY_BIB.get());
			int damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamageValue(damage);
			this.setItemSlot(EquipmentSlot.CHEST, stack);
			break;
		case 1:
			ItemStack bag = new ItemStack(TeletubbiesItems.TINKYWINKY_BAG.get());
			
			TinkyWinkyBagItemHandler handler = (TinkyWinkyBagItemHandler) bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
			LootContext.Builder builder = new LootContext.Builder((ServerLevel) level);
			LootTable table = ServerLifecycleHooks.getCurrentServer().getLootTables().get(TinkyWinkyBagItem.LOOTTABLE);
			LootContext context = builder.withParameter(LootContextParams.ORIGIN, this.position()).withParameter(LootContextParams.THIS_ENTITY, this).create(LootContextParamSets.GIFT);

			handler.fillInventory(table, context);
			
			this.setItemSlot(EquipmentSlot.MAINHAND, bag);
			break;
		}
	}

	@Override
	public EntityType<?> getZombie() {
		return TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get();
	}
}