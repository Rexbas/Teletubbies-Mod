package teletubbies.entity.passive;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import teletubbies.init.TeletubbiesEntityTypes;
import teletubbies.init.TeletubbiesItems;
import teletubbies.init.TeletubbiesSounds;

public class PoEntity extends TeletubbyEntity {

	public PoEntity(EntityType<? extends PathfinderMob> type, Level world) {
		super(type, world);
	}
	
	@Override
	protected SoundEvent getAmbientSound() {
		return TeletubbiesSounds.ENTITY_PO_VOICE.get();
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
			this.setItemSlot(EquipmentSlot.CHEST, stack);
			break;
		case 1:
			stack = new ItemStack(TeletubbiesItems.PO_HELMET.get());
			damage = this.random.nextInt(stack.getMaxDamage() - 5 + 1) + 5;
			stack.setDamageValue(damage);
			this.setItemSlot(EquipmentSlot.HEAD, stack);
			break;
		}
		
		if (this.random.nextInt(20) == 0) {
			this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(TeletubbiesItems.PO_SCOOTER.get()));
		}
	}

	@Override
	public EntityType<?> getZombie() {
		return TeletubbiesEntityTypes.PO_ZOMBIE.get();
	}
}
