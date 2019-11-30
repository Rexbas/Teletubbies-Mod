package teletubbies.entity.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityZombieLaaLaa extends EntityZombieTeletubby {

	public EntityZombieLaaLaa(World world) {
        super(world);
	}
	
	@Override
	public void setSize() {
        this.setSize(0.6F, 1.8F);
	}
	    
	protected void dropFewItems(boolean var1, int var2) {
		this.entityDropItem(new ItemStack(Teletubbies.laaLaaStick), 0.0F);
		this.entityDropItem(new ItemStack(Items.rotten_flesh), 0.0F);
	}
}