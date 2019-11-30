package teletubbies.block.tileentity;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.MathHelper;
import teletubbies.Teletubbies;

public class TileEntityTubbyCustardMachine extends TubbyTileEntity implements ITickable {

	private boolean isTower = false;
	private int masterFacing = 0;
	private int ticks = 80;
	
	private EntityPlayer player = null;
	
	@Override
	public void update() {
		if(ticks < 80) ticks++;
		if(ticks == 60 && player != null) this.dropCustard(new ItemStack(Teletubbies.tubbyCustard, 1), player);
	}
	
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound data){
        super.writeToNBT(data);
        data.setBoolean("isTower", isTower);
        data.setInteger("masterFacing", masterFacing);
        data.setInteger("ticks", ticks);
        return data;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound data){
        super.readFromNBT(data);
        isTower = data.getBoolean("isTower");
        masterFacing = data.getInteger("masterFacing");
        ticks = data.getInteger("ticks");
    }
    
	private void dropCustard(ItemStack itemstack, EntityPlayer player) {
    	if(!world.isRemote) {
    		Random rand = new Random();
        	EntityItem entityItem = new EntityItem(world, this.getMasterX() + 0.5, this.getMasterY() + 1.6, this.getMasterZ() + 0.5, itemstack);
            
        	float f2 = 0.3F;
            entityItem.motionX = (double)(-MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * f2);
            entityItem.motionY = (double)(-MathHelper.sin(player.rotationPitch / 180.0F * (float)Math.PI) * f2 + 0.1F) + 0.1;
            entityItem.motionZ = (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * f2);
            float f3 = rand.nextFloat() * (float)Math.PI * 2.0F;
            f2 = 0.02F * rand.nextFloat();
            entityItem.motionX += Math.cos((double)f3) * (double)f2;
            entityItem.motionY += (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F);
            entityItem.motionZ += Math.sin((double)f3) * (double)f2;
            entityItem.motionX *= - 1;
            entityItem.motionZ *= - 1;

        	world.spawnEntity(entityItem);
        	this.setPlayer(null);
    	}
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
    
    public boolean canDrop() {
    	if(ticks >= 80) return true;
    	return false;
    }
    
    public void resetDropTicker() {
    	this.ticks = 0;
    }
    
	public void setPlayer(EntityPlayer player) {
		this.player = player;
	}
}
