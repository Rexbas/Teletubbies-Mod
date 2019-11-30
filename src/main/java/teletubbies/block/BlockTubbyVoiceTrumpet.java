package teletubbies.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import teletubbies.block.tileentity.TileEntityTubbyVoiceTrumpet;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTubbyVoiceTrumpet extends BlockContainer{
	
	public BlockTubbyVoiceTrumpet() {
        super(Material.grass);
        this.setCreativeTab(Teletubbies.tabTeletubbies);
        this.setBlockName("TubbyVoiceTrumpet");
        this.setBlockTextureName("teletubbies:TubbyVoiceTrumpet");
        this.setHardness(0.5F);
        this.setResistance(10.0F);
	}
	
	@Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
    	if(world.isAirBlock(x, y + 1, z)){
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
		
		world.setBlock(x, y + 1, z, Teletubbies.tubbyVoiceTrumpet);
		TileEntityTubbyVoiceTrumpet te1 = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(x, y + 1, z);
		TileEntityTubbyVoiceTrumpet te2 = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(x, y, z);

		te1.setMasterData(x, y, z, direction, false);
		te2.setMasterData(x, y, z, direction, true);
		
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_){
		TileEntityTubbyVoiceTrumpet te = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(x, y, z);
		this.removeStructure(world, te.getMasterX(), te.getMasterY(), te.getMasterZ());
	}
	
	public void removeStructure(World world, int x, int y, int z){
		TileEntityTubbyVoiceTrumpet te = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(x, y, z);
		if(te.getMasterDirection() == null){
			
		}
    	
    	world.setBlockToAir(x, y + 1, z);
	
		world.setBlockToAir(x, y, z);
	}
	
	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		TileEntityTubbyVoiceTrumpet te = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(x, y, z);
    	while(te.isMaster() == null){
    		NBTTagCompound data = new NBTTagCompound();
    		te.readFromNBT(data);
    	}
    	
		if(te.isMaster()){
	        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.5F, 0.7F);
		}
		else{
	        this.setBlockBounds(0.3F, -1.0F, 0.3F, 0.7F, 0.5F, 0.7F);
		}
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {        
		if(!(world.getBlock(x, y - 1, z) instanceof BlockTubbyVoiceTrumpet)){
			return AxisAlignedBB.getBoundingBox((double)x + 0.3F, (double)y + 0.0F, (double)z + 0.3F, (double)x + 0.7F, (double)y + 1.5F, (double)z + 0.7F);
		}
		else if(world.getBlock(x, y - 1, z) instanceof BlockTubbyVoiceTrumpet){
			return AxisAlignedBB.getBoundingBox((double)x + 0.3F, (double)y - 1.0F, (double)z + 0.3F, (double)x + 0.7F, (double)y + 0.5F, (double)z + 0.7F);
		}
		else{
			System.out.println("[Teletubbies Mod] Error, Please report this!");
			return null;
		}
    }
	
    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
    	return new TileEntityTubbyVoiceTrumpet();
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
    @Override
    public void registerBlockIcons(IIconRegister reg){
    	this.blockIcon = reg.registerIcon("teletubbies:icon_TubbyVoiceTrumpet");
    }
}