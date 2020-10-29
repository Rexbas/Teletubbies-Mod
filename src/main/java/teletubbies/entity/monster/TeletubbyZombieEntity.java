package teletubbies.entity.monster;

import java.util.Arrays;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import teletubbies.init.TeletubbiesItems;

public class TeletubbyZombieEntity extends ZombieEntity {

	public TeletubbyZombieEntity(EntityType<? extends ZombieEntity> type, World world) {
		super(type, world);
		Arrays.fill(this.inventoryArmorDropChances, 1.0F);
		Arrays.fill(this.inventoryHandsDropChances, 1.0F);
	}
	
	@Override
	public boolean isChild() {
		return false;
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		int i = this.rand.nextInt(10);
		switch (i) {
		case 0:
			ItemStack stack = new ItemStack(TeletubbiesItems.TUTU.get());
			int damage = this.rand.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamage(damage);
			this.setItemStackToSlot(EquipmentSlotType.LEGS, stack);
			break;
		}
	}
}
