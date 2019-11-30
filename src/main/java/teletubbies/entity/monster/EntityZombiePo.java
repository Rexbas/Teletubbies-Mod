package teletubbies.entity.monster;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityZombiePo extends EntityZombieTeletubby {

	public EntityZombiePo(World world) {
        super(world);
	}
	
	@Override
	public void setSize() {
        this.setSize(0.6F, 1.7F);
	}
	    
	protected void dropFewItems(boolean var1, int var2) {
		this.entityDropItem(new ItemStack(Teletubbies.poStick), 0.0F);
		this.entityDropItem(new ItemStack(Items.rotten_flesh), 0.0F);
	}
}