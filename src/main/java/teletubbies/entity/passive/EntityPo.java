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
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import teletubbies.Teletubbies;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;
import teletubbies.gui.config.ConfigurationHandler;

public class EntityPo extends EntityTeletubby {
	
	public static boolean transferredToZombie = false;

	public EntityPo(World world) {
		super(world);
	}
	
	@Override
	public void setSize() {
		this.setSize(0.6F, 1.7F);
	}

	protected void dropFewItems(boolean var1, int var2) {
		if(transferredToZombie){
			//This drops nothing if Entity Transferred to Zombie
		}
		else{
			this.entityDropItem(new ItemStack(Teletubbies.poStick), 0.0F);
		}
	}

	protected String getLivingSound() {
		return "teletubbies:mob.po.say";
	}

	protected String getHurtSound() {
		return "teletubbies:mob.po.say";
	}

	protected String getDeathSound() {
		return "teletubbies:mob.po.say";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return new EntityPo(this.worldObj);
	}
}