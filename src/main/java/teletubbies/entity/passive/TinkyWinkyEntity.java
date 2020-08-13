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
import teletubbies.client.audio.SoundList;
import teletubbies.entity.EntityList;
import teletubbies.inventory.container.TinkyWinkyBagItemHandler;
import teletubbies.item.ItemList;
import teletubbies.item.TinkyWinkyBagItem;

public class TinkyWinkyEntity extends TeletubbyEntity {
	
	public TinkyWinkyEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return SoundList.ENTITY_TINKYWINKY_VOICE;
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		int i = this.rand.nextInt(10);
		switch (i) {
		case 0:
			ItemStack stack = new ItemStack(ItemList.TINKYWINKY_BIB);
			int damage = this.rand.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamage(damage);
			this.setItemStackToSlot(EquipmentSlotType.CHEST, stack);
			break;
		case 1:
			ItemStack bag = new ItemStack(ItemList.TINKYWINKY_BAG);
			
			TinkyWinkyBagItemHandler handler = (TinkyWinkyBagItemHandler) bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
			LootContext.Builder builder = new LootContext.Builder((ServerWorld) world);
			LootTable table = ServerLifecycleHooks.getCurrentServer().getLootTableManager().getLootTableFromLocation(TinkyWinkyBagItem.LOOTTABLE);
			LootContext context = builder.withParameter(LootParameters.field_237457_g_, this.getPositionVec()).withParameter(LootParameters.THIS_ENTITY, this).build(LootParameterSets.GIFT);

			handler.fillInventory(table, context);
			
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, bag);
			break;
		}
	}

	@Override
	public EntityType<?> getZombie() {
		return EntityList.TINKYWINKY_ZOMBIE;
	}
}
