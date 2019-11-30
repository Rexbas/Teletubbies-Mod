package teletubbies.entity.passive;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityNooNoo extends EntityAnimal {
	
	public EntityNooNoo(World world) {
		super(world);
		this.setSize(1.0F, 1.0F);
		this.tasks.addTask(1, new EntityAIWander(this, 0.45F));
		this.tasks.addTask(2, new EntityAIWatchClosest(this,EntityPlayer.class, 10.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10D);
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
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		this.entityDropItem(new ItemStack(Teletubbies.nooNooEyes), 0.0F);
	}

	@Override
    public SoundEvent getAmbientSound() {
		Random r = new Random();
		int number = r.nextInt(2);
		if(number == 0) return Teletubbies.sound_NooNoo_Living1;
		else return Teletubbies.sound_NooNoo_Living2;
    }

	@Override
	public SoundEvent getHurtSound(DamageSource source) {
		return Teletubbies.sound_NooNoo_Hurt;
	}

	@Override
	public SoundEvent getDeathSound() {
		return Teletubbies.sound_NooNoo_Dead;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
}