package teletubbies.block;

import ibxm.Player;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyWindMill;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTubbyWindMill extends BlockContainer{

	public BlockTubbyWindMill() {
        super(Material.grass);
        this.setCreativeTab(Teletubbies.tabTeletubbies);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.setBlockName("TubbyWindMill");
        this.setBlockTextureName("teletubbies:TubbyWindMill");
        this.setHardness(0.5F);
        this.setResistance(10.0F);
	}
	
	@Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
    	if(world.isAirBlock(x, y + 1, z) &&
    			world.isAirBlock(x, y + 2, z) &&
    			world.isAirBlock(x, y + 3, z) &&
    			world.isAirBlock(x, y + 4, z) &&
    			world.isAirBlock(x, y + 5, z)){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack itemstack) {
		super.onBlockPlacedBy(world, x, y, z, player, itemstack);
	    int direction = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		world.setBlock(x, y + 1, z, Teletubbies.tubbyWindMill);
		world.setBlock(x, y + 2, z, Teletubbies.tubbyWindMill);
		world.setBlock(x, y + 3, z, Teletubbies.tubbyWindMill);
		world.setBlock(x, y + 4, z, Teletubbies.tubbyWindMill);

		TileEntityTubbyWindMill te1 = (TileEntityTubbyWindMill) world.getTileEntity(x, y, z);
		TileEntityTubbyWindMill te2 = (TileEntityTubbyWindMill) world.getTileEntity(x, y + 1, z);
		TileEntityTubbyWindMill te3 = (TileEntityTubbyWindMill) world.getTileEntity(x, y + 2, z);
		TileEntityTubbyWindMill te4 = (TileEntityTubbyWindMill) world.getTileEntity(x, y + 3, z);
		TileEntityTubbyWindMill te5 = (TileEntityTubbyWindMill) world.getTileEntity(x, y + 4, z);
		
		te1.setMasterData(x, y, z, direction, true);
		te1.setTopData(x, y + 4, z, false);
		
		te2.setMasterData(x, y, z, direction, false);
		te2.setTopData(x, y + 4, z, false);
		
		te3.setMasterData(x, y, z, direction, false);
		te3.setTopData(x, y + 4, z, false);
		
		te4.setMasterData(x, y, z, direction, false);
		te4.setTopData(x, y + 4, z, false);
		
		te5.setMasterData(x, y, z, direction, false);
		te5.setTopData(x, y + 4, z, true);

		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	}

	/*@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		TileEntityTubbyWindMill te = (TileEntityTubbyWindMill) world.getTileEntity(x, y, z);
		TileEntityTubbyWindMill teMaster = (TileEntityTubbyWindMill) world.getTileEntity(te.getMasterX(), te.getMasterY(), te.getMasterZ());
		System.out.println(te.isActivated());
        if(te == null || player.isSneaking()){  
        	return false;
        }
		if(!te.isActivated()){
			teMaster.setIsActivated(true);
			return true;
		}
		if(te.isActivated()){
			teMaster.setIsActivated(false);
			return true;
		}		
		return true;
	}*/

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_){
		TileEntityTubbyWindMill te = (TileEntityTubbyWindMill) world.getTileEntity(x, y, z);
		this.removeStructure(world, te.getMasterX(), te.getMasterY(), te.getMasterZ());
	}
	
	public void removeStructure(World world, int x, int y, int z){
		TileEntityTubbyWindMill te = (TileEntityTubbyWindMill) world.getTileEntity(x, y, z);
		if(te.getMasterDirection() == null){
			
		}

		world.setBlockToAir(x, y + 1, z);
    	world.setBlockToAir(x, y + 2, z);
    	world.setBlockToAir(x, y + 3, z);
    	world.setBlockToAir(x, y + 4, z);
	
		world.setBlockToAir(x, y, z);
	}
	
	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		TileEntityTubbyWindMill te = (TileEntityTubbyWindMill) world.getTileEntity(x, y, z);
    	while(te.isTop() == null){
    		NBTTagCompound data = new NBTTagCompound();
    		te.readFromNBT(data);
    	}
    	
		if(te.isTop()){
	        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}
		else{
	        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.0F, 0.7F);
		}
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {        
		if(world.getBlock(x, y - 1, z) instanceof BlockTubbyWindMill &&
				world.getBlock(x, y - 2, z) instanceof BlockTubbyWindMill &&
				world.getBlock(x, y - 3, z) instanceof BlockTubbyWindMill &&
				world.getBlock(x, y - 4, z) instanceof BlockTubbyWindMill){
			return AxisAlignedBB.getBoundingBox((double)x + 0.0F, (double)y + 0.0F, (double)z + 0.0F, (double)x + 1.0F, (double)y + 1.0F, (double)z + 1.0F);
		}
		else{
			return AxisAlignedBB.getBoundingBox((double)x + 0.3F, (double)y + 0.0F, (double)z + 0.3F, (double)x + 0.7F, (double)y + 1.0F, (double)z + 0.7F);
		}
    }
	
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
    	return new TileEntityTubbyWindMill();
    }

    @Override
    public int getRenderType() {
    	return -1;
    }
    
    public int quantityDropped(Random par1Random){
    	return 1;
    }

    @Override
    public boolean isOpaqueCube() {
    	return false;
    }

    public boolean renderAsNormalBlock() {
    	return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister reg){
    	this.blockIcon = reg.registerIcon("teletubbies:icon_TubbyWindMill");
    }
}
