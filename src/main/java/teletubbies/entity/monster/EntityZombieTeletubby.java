package teletubbies.entity.monster;

import java.util.Random;

import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.entity.passive.EntityDipsy;
import teletubbies.entity.passive.EntityLaaLaa;
import teletubbies.entity.passive.EntityPo;
import teletubbies.entity.passive.EntityTinkyWinky;

public class EntityZombieTeletubby extends EntityZombie {
	
	public EntityZombieTeletubby (World world) {
        super(world);
		this.setSize();
	}
	
	@Override
    protected void applyEntityAI () {
		super.applyEntityAI();
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPo.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLaaLaa.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityDipsy.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityTinkyWinky.class, true));
    }
	
	@Override
    protected void dropEquipment (boolean wasRecentlyHit, int lootingModifier) {
        for(EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
        	if(this.getItemStackFromSlot(slot) != null) {
            	ItemStack stack = this.getItemStackFromSlot(slot);
            	if(stack.getMaxDamage() > 0) {
                	int maxDamage = stack.getMaxDamage();
                	int doDamage = new Random().nextInt(maxDamage);
                	stack.setItemDamage(doDamage);
            	}
            	this.entityDropItem(stack, 0.0F);
        	}
        }
	}
	
	public void setSize () {
		
	}
	
	@Override
    public boolean isChild() {
        return false;
    }
}
