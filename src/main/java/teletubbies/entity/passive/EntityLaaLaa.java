package teletubbies.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;
import teletubbies.gui.config.ConfigurationHandler;

public class EntityLaaLaa extends EntityTeletubby {
	
	public static boolean transferredToZombie = false;

	public EntityLaaLaa(World world) {
		super(world);
	}
	
	@Override
	public void setSize() {
        this.setSize(0.6F, 1.8F);
	}

	protected void dropFewItems(boolean var1, int var2) {
		if(transferredToZombie){
			//This drops nothing if Entity Transferred to Zombie
		}
		else{
			this.entityDropItem(new ItemStack(Teletubbies.laaLaaStick), 0.0F);
		}
	}

	protected String getLivingSound() {
		return "teletubbies:mob.laalaa.say";
	}

	protected String getHurtSound() {
		return "teletubbies:mob.laalaa.say";
	}

	protected String getDeathSound() {
		return "teletubbies:mob.laalaa.say";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return new EntityLaaLaa(this.worldObj);
	}
}