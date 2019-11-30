package teletubbies.entity.monster;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityZombieDipsy extends EntityZombieTeletubby {

	public EntityZombieDipsy(World world) {
        super(world);
	}
	
	@Override
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
		int rand0 = new Random().nextInt(10) + 1;
		int rand1 = new Random().nextInt(10) + 1;
		if(rand0 == 1) {
	        this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(Teletubbies.dipsyHat));
		}
		if(rand1 == 1) {
	        this.setItemStackToSlot(EntityEquipmentSlot.CHEST, new ItemStack(Teletubbies.dipsyBib));
		}
	}

	@Override
	public void setSize() {
        this.setSize(0.6F, 1.9F);
	}
	
	@Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return null;
    }
	    
	@Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
		this.entityDropItem(new ItemStack(Teletubbies.dipsyStick), 0.0F);
		this.entityDropItem(new ItemStack(Items.ROTTEN_FLESH), 0.0F);
	}
}
