package teletubbies.entity.monster;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import teletubbies.init.TeletubbiesItems;

public class PoZombieEntity extends TeletubbyZombieEntity {

	public PoZombieEntity(EntityType<? extends ZombieEntity> type, World world) {
		super(type, world);
	}
	
	@Override
	protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		super.setEquipmentBasedOnDifficulty(difficulty);
		int i = this.rand.nextInt(10);
		ItemStack stack = null;
		int damage = 0;
		switch (i) {
		case 0:
			stack = new ItemStack(TeletubbiesItems.PO_BIB.get());
			damage = this.rand.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamage(damage);
			this.setItemStackToSlot(EquipmentSlotType.CHEST, stack);
			break;
		case 1:
			stack = new ItemStack(TeletubbiesItems.PO_HELMET.get());
			damage = this.rand.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamage(damage);
			this.setItemStackToSlot(EquipmentSlotType.HEAD, stack);
			break;
		}

		if (this.rand.nextInt(20) == 0) {
			this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(TeletubbiesItems.PO_SCOOTER.get()));
		}
	}
}
