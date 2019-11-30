package teletubbies.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityTinkyWinky extends EntityTeletubby {
	
	public static boolean transferredToZombie = false;

	public EntityTinkyWinky(World world) {
		super(world);
	}
	
	@Override
	public void setSize(){
        this.setSize(0.6F, 2.0F);
	}

	protected void dropFewItems(boolean var1, int var2) {
		if(transferredToZombie == true){
			//This drops nothing if Entity Transferred to Zombie
		}
		else{
			this.entityDropItem(new ItemStack(Teletubbies.tinkyWinkyStick), 0.0F);
		}
	}

	protected String getLivingSound() {
		return "teletubbies:mob.tinkywinky.say";
	}

	protected String getHurtSound() {
		return "teletubbies:mob.tinkywinky.say";
	}

	protected String getDeathSound() {
		return "teletubbies:mob.tinkywinky.say";
	}

	public String getEntityName() {
		return "TinkyWinky";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return new EntityTinkyWinky(this.worldObj);
	}
}