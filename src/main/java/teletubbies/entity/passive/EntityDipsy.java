package teletubbies.entity.passive;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityDipsy extends EntityTeletubby {
	
	public static boolean transferredToZombie = false;

	public EntityDipsy(World world) {
		super(world);
	}
	
	@Override
	public void addArmor() {
		int rand0 = new Random().nextInt(10) + 1;
		int rand1 = new Random().nextInt(20) + 1;
		if(rand0 == 1) {
	        this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Teletubbies.dipsyHat));
		}
		if(rand1 == 1) {
	        this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Teletubbies.dipsyBib));
		}
		else if(rand1 == 2) {
	        this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Teletubbies.tubbySkirt));
		}
		this.shouldAddArmor = false;
	}
	
	@Override
	public void setSize() {
        this.setSize(0.6F, 1.9F);
	}

	@Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if(transferredToZombie) {
			//This drops nothing if Entity Transferred to Zombie
		}
		else {
			this.entityDropItem(new ItemStack(Teletubbies.dipsyStick), 0.0F);
		}
	}

	@Override
    public SoundEvent getAmbientSound() {
        return Teletubbies.sound_Dipsy_Living;
    }

	@Override
	public SoundEvent getHurtSound() {
		return Teletubbies.sound_Dipsy_Living;
	}

	@Override
	public SoundEvent getDeathSound() {
		return Teletubbies.sound_Dipsy_Living;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return null;
	}
}