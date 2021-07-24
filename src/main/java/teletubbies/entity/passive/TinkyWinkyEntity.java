package teletubbies.entity.passive;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.init.TeletubbiesEntityTypes;
import teletubbies.init.TeletubbiesItems;
import teletubbies.init.TeletubbiesSounds;
import teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import teletubbies.item.TinkyWinkyBagItem;

public class TinkyWinkyEntity extends TeletubbyEntity {
	
	public TinkyWinkyEntity(EntityType<? extends CreatureEntity> type, World world) {
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
			this.setItemSlot(EquipmentSlotType.CHEST, stack);
			break;
		case 1:
			ItemStack bag = new ItemStack(TeletubbiesItems.TINKYWINKY_BAG.get());
			
			TinkyWinkyBagItemHandler handler = (TinkyWinkyBagItemHandler) bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
			LootContext.Builder builder = new LootContext.Builder((ServerWorld) level);
			LootTable table = ServerLifecycleHooks.getCurrentServer().getLootTables().get(TinkyWinkyBagItem.LOOTTABLE);
			LootContext context = builder.withParameter(LootParameters.ORIGIN, this.position()).withParameter(LootParameters.THIS_ENTITY, this).create(LootParameterSets.GIFT);

			handler.fillInventory(table, context);
			
			this.setItemSlot(EquipmentSlotType.MAINHAND, bag);
			break;
		}
	}

	@Override
	public EntityType<?> getZombie() {
		return TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get();
	}
}
