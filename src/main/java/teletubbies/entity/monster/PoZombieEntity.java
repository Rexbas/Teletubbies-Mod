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
	protected void populateDefaultEquipmentSlots(DifficultyInstance difficulty) {
		super.populateDefaultEquipmentSlots(difficulty);
		int i = this.random.nextInt(10);
		ItemStack stack = null;
		int damage = 0;
		switch (i) {
		case 0:
			stack = new ItemStack(TeletubbiesItems.PO_BIB.get());
			damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamageValue(damage);
			this.setItemSlot(EquipmentSlotType.CHEST, stack);
			break;
		case 1:
			stack = new ItemStack(TeletubbiesItems.PO_HELMET.get());
			damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamageValue(damage);
			this.setItemSlot(EquipmentSlotType.HEAD, stack);
			break;
		}

		if (this.random.nextInt(20) == 0) {
			this.setItemSlot(EquipmentSlotType.MAINHAND, new ItemStack(TeletubbiesItems.PO_SCOOTER.get()));
		}
	}
}
