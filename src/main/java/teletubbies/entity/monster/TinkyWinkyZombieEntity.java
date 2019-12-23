package teletubbies.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import teletubbies.item.ItemList;

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
			ItemStack stack = new ItemStack(ItemList.TINKYWINKY_BIB);
			int damage = this.rand.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamage(damage);
			this.setItemStackToSlot(EquipmentSlotType.CHEST, stack);
			break;
		case 1:
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(ItemList.TINKYWINKY_BAG));
			break;
		}
	}
}
