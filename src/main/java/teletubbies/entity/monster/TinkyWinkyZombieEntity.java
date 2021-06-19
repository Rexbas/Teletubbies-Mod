package teletubbies.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.init.TeletubbiesItems;
import teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import teletubbies.item.TinkyWinkyBagItem;

public class TinkyWinkyZombieEntity extends TeletubbyZombieEntity {

	public TinkyWinkyZombieEntity(EntityType<? extends ZombieEntity> type, World world) {
		super(type, world);
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		int i = this.rand.nextInt(10);
		switch (i) {
		case 0:
			ItemStack stack = new ItemStack(TeletubbiesItems.TINKYWINKY_BIB.get());
			int damage = this.rand.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamage(damage);
			this.setItemStackToSlot(EquipmentSlotType.CHEST, stack);
			break;
		case 1:
			ItemStack bag = new ItemStack(TeletubbiesItems.TINKYWINKY_BAG.get());
			
			TinkyWinkyBagItemHandler handler = (TinkyWinkyBagItemHandler) bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
			LootContext.Builder builder = new LootContext.Builder((ServerWorld) world);
			LootTable table = ServerLifecycleHooks.getCurrentServer().getLootTableManager().getLootTableFromLocation(TinkyWinkyBagItem.LOOTTABLE);
			LootContext context = builder.withParameter(LootParameters.ORIGIN, this.getPositionVec()).withParameter(LootParameters.THIS_ENTITY, this).build(LootParameterSets.GIFT);

			handler.fillInventory(table, context);
			
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, bag);
			break;
		}
	}
}
