package teletubbies.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyVoiceTrumpet;
import teletubbies.block.tileentity.TileEntityTubbyToastMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTubbyToastMachine extends BlockContainer{
	
	public BlockTubbyToastMachine() {
        super(Material.grass);
        this.setCreativeTab(Teletubbies.tabTeletubbies);
        this.setBlockName("TubbyToastMachine");
        this.setBlockTextureName("teletubbies:TubbyToastMachine");
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
		
		world.setBlock(x, y + 1, z, Teletubbies.tubbyToastMachine);
		TileEntityTubbyToastMachine te1 = (TileEntityTubbyToastMachine) world.getTileEntity(x, y + 1, z);
		TileEntityTubbyToastMachine te2 = (TileEntityTubbyToastMachine) world.getTileEntity(x, y, z);

		te1.setMasterData(x, y, z, direction, false);
		te2.setMasterData(x, y, z, direction, true);
		
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		TileEntityTubbyToastMachine te = (TileEntityTubbyToastMachine) world.getTileEntity(x, y, z);
        if(te == null || player.isSneaking()) {  
        	return false;
        }
        
        dropItemStack(new ItemStack(Teletubbies.tubbyToast, 1), world, te.getMasterX(), te.getMasterY(), te.getMasterZ());
		return true;
	}
	
	public static void dropItemStack(ItemStack itemstack, World world, int x, int y, int z) {
    	if(!world.isRemote){
        	EntityItem entityitem = new EntityItem(world, x, y, z, itemstack);
        	entityitem.posX = x;
        	entityitem.posY = y + 1;
        	entityitem.posZ = z;
        	world.spawnEntityInWorld(entityitem);
    	}
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int p_149749_6_){
		TileEntityTubbyToastMachine te = (TileEntityTubbyToastMachine) world.getTileEntity(x, y, z);
		this.removeStructure(world, te.getMasterX(), te.getMasterY(), te.getMasterZ());
	}
	
	public void removeStructure(World world, int x, int y, int z){
		TileEntityTubbyToastMachine te = (TileEntityTubbyToastMachine) world.getTileEntity(x, y, z);
		if(te.getMasterDirection() == null){
			
		}
    	
    	world.setBlockToAir(x, y + 1, z);
	
		world.setBlockToAir(x, y, z);
	}
	
	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		TileEntityTubbyToastMachine te = (TileEntityTubbyToastMachine) world.getTileEntity(x, y, z);
    	while(te.isMaster() == null){
    		NBTTagCompound data = new NBTTagCompound();
    		te.readFromNBT(data);
    	}
    	
		if(te.isMaster()){
	        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);
		}
		else{
	        this.setBlockBounds(0.0F, -1.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {        
		if(!(world.getBlock(x, y - 1, z) instanceof BlockTubbyToastMachine)){
			return AxisAlignedBB.getBoundingBox((double)x + 0.0F, (double)y + 0.0F, (double)z + 0.0F, (double)x + 1.0F, (double)y + 1.5F, (double)z + 1.0F);
		}
		else if(world.getBlock(x, y - 1, z) instanceof BlockTubbyToastMachine){
			return AxisAlignedBB.getBoundingBox((double)x + 0.0F, (double)y - 1.0F, (double)z + 0.0F, (double)x + 1.0F, (double)y + 0.5F, (double)z + 1.0F);
		}
		else{
			System.out.println("[Teletubbies Mod] Error, Please report this!");
			return null;
		}
    }

	@Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
    	return new TileEntityTubbyToastMachine();
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
    	this.blockIcon = reg.registerIcon("teletubbies:icon_TubbyToastMachine");
    }
}