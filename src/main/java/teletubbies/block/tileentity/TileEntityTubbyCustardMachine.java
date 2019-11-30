package teletubbies.block.tileentity;

import net.minecraft.nbt.NBTTagCompound;

public class TileEntityTubbyCustardMachine extends TubbyTileEntity {

	private Boolean isTower = false;
	private Integer masterFacing = null;
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data){
        super.writeToNBT(data);
        data.setBoolean("isTower", isTower);
        data.setInteger("masterFacing", masterFacing);
        return data;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound data){
        super.readFromNBT(data);
        isTower = data.getBoolean("isTower");
        masterFacing = data.getInteger("masterFacing");
    }
    
    public Boolean isTower() {
    	return isTower;
    }
    
    public Integer masterFacing() {
    	return this.masterFacing;
    }
    
    public void setIsTower(boolean isTower) {
    	this.isTower = isTower;
    }
    
    public void setMasterData(int x, int y, int z, boolean ismaster, int facing) {
    	this.masterFacing = facing;
    	super.setMasterData(x, y, z, ismaster);
    }
}
