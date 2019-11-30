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
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.capability.ITeletubbies_CAP;

public class EntityNooNoo extends EntityAnimal {

	//public InventoryNooNoo inventory = new InventoryNooNoo(this);
	
	public EntityNooNoo(World world) {
		super(world);
		this.setSize(1.0F, 1.0F);
		//this.tasks.addTask(0, new AISuckItems(this, 20, 5, 20));
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
	public SoundEvent getHurtSound() {
		return Teletubbies.sound_NooNoo_Hurt;
	}

	@Override
	public SoundEvent getDeathSound() {
		return Teletubbies.sound_NooNoo_Dead;
	}
	
	@Override
    public boolean processInteract(EntityPlayer player, EnumHand hand, ItemStack stack) {
		if(player.isSneaking()) return false;
		ITeletubbies_CAP capability = player.getCapability(Teletubbies.Teletubbies_CAP, player.getHorizontalFacing());
		capability.setInteractedNooNoo(this);
		player.openGui(Teletubbies.instance, 1, this.worldObj, (int) this.posX, (int) this.posY, (int) this.posZ);
        return false;
    }
	
	/*@Override
    public void onDeath(DamageSource cause) {
		super.onDeath(cause);
		if(!this.worldObj.isRemote) this.inventory.dropAllItems();
	}

    @Override
    public void onLivingUpdate() {
    	super.onLivingUpdate();
        if(!this.worldObj.isRemote && !this.dead && this.worldObj.getGameRules().getBoolean("mobGriefing") && this.inventory.getFirstEmptyStack() != - 1) {
            for(EntityItem entityitem : this.worldObj.getEntitiesWithinAABB(EntityItem.class, this.getEntityBoundingBox().expand(1.0D, 1.0D, 1.0D))) {
                if(!entityitem.isDead && entityitem.getEntityItem() != null && !entityitem.cannotPickup()) {
                	this.inventory.addItemStackToInventory(entityitem.getEntityItem());
                    EntityTracker entitytracker = ((WorldServer)this.worldObj).getEntityTracker();
                    entitytracker.sendToAllTrackingEntity(entityitem, new SPacketCollectItem(entityitem.getEntityId(), this.getEntityId()));
                    entityitem.setDead();
                }
            }
        }
    }
	
    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
    	super.writeEntityToNBT(compound);
        compound.setTag("Inventory", this.inventory.writeToNBT(new NBTTagList()));
    }
    
    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
    	super.readEntityFromNBT(compound);
        NBTTagList nbttaglist = compound.getTagList("Inventory", 10);
    	this.inventory.readFromNBT(nbttaglist);
    }*/

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return null;
	}
}