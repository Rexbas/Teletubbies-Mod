package teletubbies.block.tileentity;

import ibxm.Player;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import teletubbies.sounds.SpinSound;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityTubbyWindMill extends TileEntity{

	private int[] masterPos = new int[3];
	private int[] topPos = new int[3];
	private Integer masterDirection = null;
	private Boolean isMaster = null;
	private Boolean isTop = null;
	private boolean isActivated = false;
	boolean isPlayingSound = false;
	private float rotationAngle = 0;
	private float soundTimer = 0;
	
	@Override
    public AxisAlignedBB getRenderBoundingBox(){
        AxisAlignedBB bb = INFINITE_EXTENT_AABB;
    	while(this.isMaster() == null){
    		NBTTagCompound data = new NBTTagCompound();
    		this.readFromNBT(data);
    	}
    	
    	if(this.isMaster()){
            bb = AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 5, zCoord + 1);
    	}
		return bb;
    }
	
	public void updateEntity(){
		Side side = FMLCommonHandler.instance().getEffectiveSide();
		/*if(isActivated()){
			rotationAngle += 20.0F;
		}
		else{
			rotationAngle += 10.0F;
		}*/
		rotationAngle += 10.0F;
		if(rotationAngle >= 360){
			rotationAngle = 0;
		}
		
		/*if(!isPlayingSound && isActivated() && isTop()){
			isPlayingSound = true;
			if(side == side.CLIENT){
				playSound();
			}
		}*/

		/*if(isActivated() && isTop()){			
			if(getMasterDirection() == 0){
				worldObj.spawnParticle("mobSpell", xCoord + 0.5, yCoord + 1.75, zCoord, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1.75, yCoord + 0.5, zCoord, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord - 0.75, yCoord + 0.5, zCoord, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 0.5, yCoord - 0.75, zCoord, 1.0D, 0.5D, 0.7D);
				
				worldObj.spawnParticle("mobSpell", xCoord + 1.35, yCoord + 1.35, zCoord, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord - 0.35, yCoord + 1.35, zCoord, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1.35, yCoord - 0.35, zCoord, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord - 0.35, yCoord - 0.35, zCoord, 1.0D, 0.5D, 0.7D);
			}
			if(getMasterDirection() == 2){
				worldObj.spawnParticle("mobSpell", xCoord + 0.5, yCoord + 1.75, zCoord + 1, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1.75, yCoord + 0.5, zCoord + 1, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord - 0.75, yCoord + 0.5, zCoord + 1, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 0.5, yCoord - 0.75, zCoord + 1, 1.0D, 0.5D, 0.7D);
				
				worldObj.spawnParticle("mobSpell", xCoord + 1.35, yCoord + 1.35, zCoord + 1, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord - 0.35, yCoord + 1.35, zCoord + 1, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1.35, yCoord - 0.35, zCoord + 1, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord - 0.35, yCoord - 0.35, zCoord + 1, 1.0D, 0.5D, 0.7D);
			}
			if(getMasterDirection() == 1){
				worldObj.spawnParticle("mobSpell", xCoord + 1, yCoord + 1.75, zCoord + 0.5, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1, yCoord + 0.5, zCoord + 1.75, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1, yCoord + 0.5, zCoord - 0.75, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1, yCoord - 0.75, zCoord + 0.5, 1.0D, 0.5D, 0.7D);
				
				worldObj.spawnParticle("mobSpell", xCoord + 1, yCoord + 1.35, zCoord + 1.35, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1, yCoord + 1.35, zCoord - 0.35, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1, yCoord - 0.35, zCoord + 1.35, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord + 1, yCoord - 0.35, zCoord - 0.35, 1.0D, 0.5D, 0.7D);
			}
			if(getMasterDirection() == 3){
				worldObj.spawnParticle("mobSpell", xCoord, yCoord + 1.75, zCoord + 0.5, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord, yCoord + 0.5, zCoord + 1.75, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord, yCoord + 0.5, zCoord - 0.75, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord, yCoord - 0.75, zCoord + 0.5, 1.0D, 0.5D, 0.7D);
				
				worldObj.spawnParticle("mobSpell", xCoord, yCoord + 1.35, zCoord + 1.35, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord, yCoord + 1.35, zCoord - 0.35, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord, yCoord - 0.35, zCoord + 1.35, 1.0D, 0.5D, 0.7D);
				worldObj.spawnParticle("mobSpell", xCoord, yCoord - 0.35, zCoord - 0.35, 1.0D, 0.5D, 0.7D);
			}	
		}*/
	}
	
	@SideOnly(Side.CLIENT)
	public void playSound(){
    	TileEntityTubbyWindMill te = (TileEntityTubbyWindMill) worldObj.getTileEntity(xCoord, yCoord, zCoord);
		ISound spin = new SpinSound("teletubbies:windmill.spin", te, 1, 1);
		Minecraft.getMinecraft().getSoundHandler().playSound(spin);
	}
	
    @Override
    public void writeToNBT(NBTTagCompound data){
        super.writeToNBT(data);
        data.setIntArray("masterPos", masterPos);
        data.setIntArray("topPos", topPos);
        data.setInteger("masterDirection", masterDirection);
        data.setBoolean("isMaster", isMaster);
        data.setBoolean("isTop", isTop);
        data.setBoolean("isActivated", isActivated);
        data.setBoolean("isPlayingSound", isPlayingSound);
        data.setFloat("rotationAngle", rotationAngle);
        data.setFloat("soundTimer", soundTimer);
    }

    @Override
    public void readFromNBT(NBTTagCompound data){
        super.readFromNBT(data);
        masterPos = data.getIntArray("masterPos");
        topPos = data.getIntArray("topPos");
        masterDirection = data.getInteger("masterDirection");
        isMaster = data.getBoolean("isMaster");
        isTop = data.getBoolean("isTop");
        isActivated = data.getBoolean("isActivated");
        isPlayingSound = data.getBoolean("isPlayingSound");
        rotationAngle = data.getFloat("rotationAngle");
        soundTimer = data.getFloat("soundTimer");
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
    
    public int getTopX(){
    	return topPos[0];
    }
    
    public int getTopY(){
    	return topPos[1];
    }
    
    public int getTopZ(){
    	return topPos[2];
    }
    
    public Integer getMasterDirection(){
    	return masterDirection;
    }
    
    public Boolean isMaster(){
    	return isMaster;
    }
    
    public Boolean isTop(){
    	return isTop;
    }
    
    public boolean isActivated(){
    	TileEntityTubbyWindMill master = (TileEntityTubbyWindMill) worldObj.getTileEntity(this.getMasterX(), this.getMasterY(), this.getMasterZ());
    	if(master == null){
    		return false;
    	}
    	if(isMaster()){
    		return isActivated;
    	}
    	else if(master.isActivated()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public boolean isPlayingSound(){
    	TileEntityTubbyWindMill master = (TileEntityTubbyWindMill) worldObj.getTileEntity(this.getMasterX(), this.getMasterY(), this.getMasterZ());
    	if(master == null){
    		return false;
    	}
    	if(isMaster()){
    		return isPlayingSound;
    	}
    	else if(master.isPlayingSound()){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public float rotationAngle(){
    	return rotationAngle;
    }
    
    public void setMasterData(int x, int y, int z, int masterdirection, boolean ismaster){
        masterPos[0] = x;
        masterPos[1] = y;
        masterPos[2] = z;
        masterDirection = masterdirection;
    	isMaster = ismaster;
    }
    
    public void setTopData(int x, int y, int z, boolean istop){
    	topPos[0] = x;
    	topPos[1] = y;
    	topPos[2] = z;
    	isTop = istop;
    }
    
    public void setIsActivated(boolean activated){
    	isActivated = activated;
    }
    
    public void setIsPlayingSound(boolean isplayingsound){
    	isPlayingSound = isplayingsound;
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