package teletubbies.block.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityTubbyVoiceTrumpet extends TileEntity{

	private int[] masterPos = new int[3];
	private Integer masterDirection = null;
	private Boolean isMaster = null;
	
	@Override
    public AxisAlignedBB getRenderBoundingBox(){
        AxisAlignedBB bb = INFINITE_EXTENT_AABB;
    	while(this.isMaster() == null){
    		NBTTagCompound data = new NBTTagCompound();
    		this.readFromNBT(data);
    	}
    	
    	if(this.isMaster()){
            bb = AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 2, zCoord + 1);
    	}
		return bb;
    }
	
    @Override
    public void writeToNBT(NBTTagCompound data){
        super.writeToNBT(data);
        data.setIntArray("masterPos", masterPos);
        data.setInteger("masterDirection", masterDirection);
        data.setBoolean("isMaster", isMaster);
    }

    @Override
    public void readFromNBT(NBTTagCompound data){
        super.readFromNBT(data);
        masterPos = data.getIntArray("masterPos");
        masterDirection = data.getInteger("masterDirection");
        isMaster = data.getBoolean("isMaster");
    }
 
    public int getMasterX(){
        return masterPos[0];
    }
 
    public int getMasterY(){
        return masterPos[1];
    }
 
    public int getMasterZ(){
        return masterPos[2];
    }
    
    public Integer getMasterDirection(){
    	return masterDirection;
    }
    
    public Boolean isMaster(){
    	return isMaster;
    }
    
    public void setMasterData(int x, int y, int z, int masterdirection, boolean ismaster){
        masterPos[0] = x;
        masterPos[1] = y;
        masterPos[2] = z;
        masterDirection = masterdirection;
    	isMaster = ismaster;
    }
    
    @Override
    public Packet getDescriptionPacket(){
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet){
        readFromNBT(packet.func_148857_g());
    }
}
