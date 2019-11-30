package teletubbies.entity.passive;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityLaaLaa extends EntityTeletubby {
	
	public static boolean transferredToZombie = false;

	public EntityLaaLaa(World world) {
		super(world);
	}
	
	@Override
	public void addArmor() {
		int rand0 = new Random().nextInt(10) + 1;
		int rand1 = new Random().nextInt(10) + 1;
		if(rand0 == 1) {
	        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Teletubbies.laaLaaBall));
		}
		if(rand1 == 1) {
	        this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Teletubbies.laaLaaBib));
		}
	}
	
	@Override
	public void setSize() {
        this.setSize(0.6F, 1.8F);
	}

	@Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		if(transferredToZombie){
			//This drops nothing if Entity Transferred to Zombie
		}
		else{
			this.entityDropItem(new ItemStack(Teletubbies.laaLaaStick), 0.0F);
		}
	}

	@Override
    public SoundEvent getAmbientSound() {
        return Teletubbies.sound_LaaLaa_Living;
    }

	@Override
	public SoundEvent getHurtSound() {
		return Teletubbies.sound_LaaLaa_Living;
	}

	@Override
	public SoundEvent getDeathSound() {
		return Teletubbies.sound_LaaLaa_Living;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return new EntityLaaLaa(this.worldObj);
	}
}