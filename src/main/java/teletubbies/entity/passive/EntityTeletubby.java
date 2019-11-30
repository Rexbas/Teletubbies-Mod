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
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;
import teletubbies.gui.config.ConfigurationHandler;

public class EntityTeletubby extends EntityAnimal{

	public EntityTeletubby(World world) {
		super(world);

		this.experienceValue = 0;
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 0.55F));
		this.tasks.addTask(2, new EntityAITempt(this, 0.45F, Teletubbies.tubbyToast, false));
		this.tasks.addTask(2, new EntityAITempt(this, 0.45F, Teletubbies.tubbyCustard, false));
		this.tasks.addTask(3, new EntityAIWander(this, 0.45F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.isImmuneToFire = false;
		if(ConfigurationHandler.zombiesAttacksTeletubbies) {
			this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombiePo.class, 10.0F, 0.55F, 0.55F));
			this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombieLaaLaa.class, 10.0F, 0.55F, 0.55F));
			this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombieDipsy.class, 10.0F, 0.55F, 0.55F));
			this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombieTinkyWinky.class, 6.0F, 0.55F, 0.55F));
			this.tasks.addTask(6, new EntityAIAvoidEntity(this, EntityZombie.class, 10.0F, 0.55F, 0.55F));
		}
		
		addRandomArmor();
		setSize();
	}
	
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.6D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10D);
		if (this.getEntityAttribute(SharedMonsterAttributes.attackDamage) != null)
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1D);
	}
	
	protected void addRandomArmor() {

	}
	
	public void setSize() {
		
	}
	
	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		return 1;
	}
			
	public void onStruckByLightning(EntityLightningBolt entityLightningBolt) {
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;
		Entity entity = this;
	}

	protected void fall(float l) {
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;
		super.fall(l, l);
		Entity entity = this;
	}

	public void onCriticalHit(Entity entity2) {
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;
		Entity entity = this;
	}

	public void onKillEntity(EntityLiving entityLiving) {
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;
		Entity entity = this;
	}

	public boolean interact(EntityPlayer entity2) {
		int i = (int) this.posX;
		int j = (int) this.posY;
		int k = (int) this.posZ;
		Entity entity = this;
		return true;
	}
	
	
	
	/*@Override
	public boolean getCanSpawnHere() {
	Chunk chunk = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
		
	if (this.worldObj.getWorldInfo().getTerrainType() == WorldType.FLAT) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));
		if (this.rand.nextInt(10) == 0 && chunk.getRandomWithSeed(987234911L).nextInt(10) == 0 && this.posY < 40.0D) {
			return super.getCanSpawnHere();
		}
	}
	else
	{
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        return this.worldObj.getBlock(i, j - 1, k) == Blocks.grass && this.worldObj.getFullBlockLightValue(i, j, k) > 8 && super.getCanSpawnHere();
	}
		return false;
	}*/

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return this;
	}
}
