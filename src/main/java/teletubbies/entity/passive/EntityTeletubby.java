package teletubbies.entity.passive;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;

public class EntityTeletubby extends EntityAnimal {

	public EntityTeletubby(World world) {
		super(world);
		this.addArmor();
		//this.setCanPickUpLoot(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 0.55F));
		this.tasks.addTask(2, new EntityAITempt(this, 0.45F, Teletubbies.tubbyToast, false));
		this.tasks.addTask(2, new EntityAITempt(this, 0.45F, Teletubbies.tubbyCustard, false));
		this.tasks.addTask(3, new EntityAIWander(this, 0.45F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombiePo.class, 10.0F, 0.55F, 0.55F));
		this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombieLaaLaa.class, 10.0F, 0.55F, 0.55F));
		this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombieDipsy.class, 10.0F, 0.55F, 0.55F));
		this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombieTinkyWinky.class, 6.0F, 0.55F, 0.55F));
		this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombie.class, 10.0F, 0.55F, 0.55F));
		this.setSize();
	}
	
	@Override
	public void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(2.0D);
	}
	
	@Override
    protected void dropEquipment(boolean wasRecentlyHit, int lootingModifier) {
        for(EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
        	if(this.getItemStackFromSlot(slot) != null) {
            	ItemStack stack = this.getItemStackFromSlot(slot);
            	if(stack.getMaxDamage() > 0) {
                	int maxDamage = stack.getMaxDamage();
                	int doDamage = new Random().nextInt(maxDamage - 10);
                	stack.setItemDamage(doDamage);
            	}
            	this.entityDropItem(stack, 0.0F);
        	}
        }
	}
	
	public void addArmor() {
		
	}
	
	public void setSize() {
		
	}
	
	@Override
	public boolean isAIDisabled() {
		return false;
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return this;
	}
}
