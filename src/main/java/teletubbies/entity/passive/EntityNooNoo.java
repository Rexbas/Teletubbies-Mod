package teletubbies.entity.passive;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import teletubbies.Teletubbies;

public class EntityNooNoo extends EntityAnimal {

	public EntityNooNoo(World world) {
		super(world);
		experienceValue = 0;
		this.isImmuneToFire = false;
		addRandomArmor();

		this.setSize(1.0F, 1.0F);
		this.preventEntitySpawning = true;
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(0, new EntityAIWander(this, 0.45F));
		this.tasks.addTask(1, new EntityAIWatchClosest(this,
				EntityPlayer.class, 10.0F));
		this.tasks.addTask(2, new EntityAILookIdle(this));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
				.setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
				.setBaseValue(10D);
		if (this.getEntityAttribute(SharedMonsterAttributes.attackDamage) != null)
			this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
					.setBaseValue(1D);
	}

	protected void addRandomArmor() {

	}

	public boolean isAIEnabled() {
		return true;
	}
	
	@Override
	public int getMaxSpawnedInChunk(){
		return 1;
	}

	protected void dropFewItems(boolean var1, int var2) {
		this.entityDropItem(new ItemStack(Teletubbies.nooNooEyes), 0.0F);
	}

	protected String getLivingSound() {
		return "teletubbies:mob.noonoo.say";
	}

	protected String getHurtSound() {
		return "teletubbies:mob.noonoo.hurt";
	}

	protected String getDeathSound() {
		return "teletubbies:mob.noonoo.dead";
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
		super.fall(l);
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

	public String getEntityName() {
		return "NooNoo";
	}

	@Override
	public EntityAgeable createChild(EntityAgeable entity) {
		return new EntityNooNoo(this.worldObj);
	}
}
