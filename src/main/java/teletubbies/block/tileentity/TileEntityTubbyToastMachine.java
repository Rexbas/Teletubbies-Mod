package teletubbies.block.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;

public class TileEntityTubbyToastMachine extends TubbyTileEntity implements ITickable {
	
	private int ticks = 20;

	@Override
	public void update() {
		if(ticks < 20) ticks++;
	}
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("ticks", ticks);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        ticks = data.getInteger("ticks");
    }
    
    public boolean canDrop() {
    	if(ticks >= 20) return true;
    	return false;
    }
    
    public void resetDropTicker() {
    	this.ticks = 0;
    }
}
