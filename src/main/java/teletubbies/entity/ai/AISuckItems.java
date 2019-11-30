package teletubbies.entity.ai;

import java.util.List;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;
import teletubbies.entity.passive.EntityNooNoo;

public class AISuckItems extends EntityAIBase {
	
	private EntityNooNoo nooNoo;
	private World world;
	private int xRange;
	private int yRange;
	private int zRange;
	
	public AISuckItems(EntityNooNoo nooNoo, int xRange, int yRange, int zRange) {
		this.setMutexBits(1);
		this.nooNoo = nooNoo;
		this.world = nooNoo.worldObj;
		this.xRange = xRange;
		this.yRange = yRange;
		this.zRange = zRange;
	}

	@Override
	public boolean shouldExecute() {
		/*if(this.nooNoo.inventory.getFirstEmptyStack() == - 1) {
			return false;
		}*/
		return true;
	}
	
	@Override
	public void updateTask() {	
        List list = world.getEntitiesWithinAABB(EntityItem.class, nooNoo.getEntityBoundingBox().expand(xRange, yRange, zRange));
        if(list.size() > 0) {
        	EntityItem entityitem = (EntityItem) list.get(0);
        	nooNoo.getNavigator().tryMoveToXYZ(entityitem.posX, entityitem.posY, entityitem.posZ, 0.5D);
        }
	}
}
