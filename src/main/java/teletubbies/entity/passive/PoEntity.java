package teletubbies.entity.passive;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import teletubbies.init.TeletubbiesEntityTypes;
import teletubbies.init.TeletubbiesItems;
import teletubbies.init.TeletubbiesSounds;

public class PoEntity extends TeletubbyEntity {

	public PoEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return TeletubbiesSounds.ENTITY_PO_VOICE.get();
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

	@Override
	public EntityType<?> getZombie() {
		return TeletubbiesEntityTypes.PO_ZOMBIE.get();
	}
}
