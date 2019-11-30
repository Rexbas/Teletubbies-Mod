package teletubbies.block.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TubbyTileEntity extends TileEntity {

	protected int[] masterPos = new int[3];
	protected Boolean isMaster = null;
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setIntArray("masterPos", masterPos);
        data.setBoolean("isMaster", isMaster);
        return data;
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        masterPos = data.getIntArray("masterPos");
        isMaster = data.getBoolean("isMaster");
    }
 
    public int getMasterX() {
        return masterPos[0];
    }
 
    public int getMasterY() {
        return masterPos[1];
    }
 
    public int getMasterZ() {
        return masterPos[2];
    }
    
    public Boolean isMaster() {
    	return isMaster;
    }
    
    public void setMasterData(int x, int y, int z, boolean ismaster) {
        masterPos[0] = x;
        masterPos[1] = y;
        masterPos[2] = z;
    	isMaster = ismaster;
    }
    
    @Override
    public NBTTagCompound getUpdateTag() {
        return new NBTTagCompound();
    }
    
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new SPacketUpdateTileEntity(pos, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        readFromNBT(packet.getNbtCompound());
    }
}
