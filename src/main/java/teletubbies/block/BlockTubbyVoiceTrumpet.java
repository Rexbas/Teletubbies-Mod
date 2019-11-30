package teletubbies.block;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.block.properties.PropertyPosition;
import teletubbies.block.tileentity.TileEntityTubbyVoiceTrumpet;

public class BlockTubbyVoiceTrumpet extends BlockContainer {
	
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum POSITION = PropertyEnum.create("position", PropertyPosition.class);
	private final String name = "TubbyVoiceTrumpet";

	public BlockTubbyVoiceTrumpet() {
        super(Material.grass);
        this.setCreativeTab(Teletubbies.tabTeletubbies);
        this.setUnlocalizedName(name);
        this.setHardness(0.5F);
        this.setResistance(10.0F);
        this.setDefaultState(this.getDefaultState().withProperty(POSITION, PropertyPosition.BOTTOM));
	}
	
	@Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
		BlockPos pos0 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
    	if(world.isAirBlock(pos0)) return true;
    	else return false;
    }
	
	@Override
    public IBlockState onBlockPlaced(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
    	switch(placer.getHorizontalFacing()) {
    	case SOUTH:
    		meta = 0;
    		break;
    	case WEST:
    		meta = 1;
    		break;
    	case NORTH:
    		meta = 2;
    		break;
    	case EAST:
    		meta = 3;
    		break;
		default:
			meta = 2;
    	}
    	return this.getStateFromMeta(meta);
    }
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack itemstack) {
		super.onBlockPlacedBy(world, pos, state, player, itemstack);
	    int facing = player.getHorizontalFacing().getHorizontalIndex();
		
		BlockPos pos0 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		IBlockState state0 = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(POSITION, PropertyPosition.TOP);
	    
		world.setBlockState(pos0, state0);
		TileEntityTubbyVoiceTrumpet te1 = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(pos0);
		TileEntityTubbyVoiceTrumpet te2 = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(pos);

		te1.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, false);
		te2.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, true);
	}
	
	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityTubbyVoiceTrumpet te = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(pos);
		this.removeStructure(world, te.getMasterX(), te.getMasterY(), te.getMasterZ());
	}
	
	public void removeStructure(World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		BlockPos pos0 = new BlockPos(x, y + 1, z);
		TileEntityTubbyVoiceTrumpet te = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(pos);
		if(te.getMasterDirection() == null) {
			
		}
    	
		world.destroyBlock(pos0, false);
	
		world.destroyBlock(pos, false);
	}
	
	@Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, BlockPos pos) {
		TileEntityTubbyVoiceTrumpet te = (TileEntityTubbyVoiceTrumpet) world.getTileEntity(pos);
    	while(te.isMaster() == null) {
    		NBTTagCompound data = new NBTTagCompound();
    		te.readFromNBT(data);
    	}
    	
		if(te.isMaster()) {
	        this.setBlockBounds(0.3F, 0.0F, 0.3F, 0.7F, 1.5F, 0.7F);
		}
		else {
	        this.setBlockBounds(0.3F, -1.0F, 0.3F, 0.7F, 0.5F, 0.7F);
		}
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBox(World world, BlockPos pos, IBlockState state) {
		BlockPos pos0 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
		if(world.getBlockState(pos0).getBlock() != state.getBlock()) {
			return AxisAlignedBB.fromBounds((double)pos.getX() + 0.3F, (double)pos.getY() + 0.0F, (double)pos.getZ() + 0.3F, (double)pos.getX() + 0.7F, (double)pos.getY() + 1.5F, (double)pos.getZ() + 0.7F);
		}
		else if(world.getBlockState(pos0).getBlock() == state.getBlock()) {
			return AxisAlignedBB.fromBounds((double)pos.getX() + 0.3F, (double)pos.getY() - 1.0F, (double)pos.getZ() + 0.3F, (double)pos.getX() + 0.7F, (double)pos.getY() + 0.5F, (double)pos.getZ() + 0.7F);
		}
		else {
			System.out.println("[Teletubbies Mod] Error, Please report this!");
			return null;
		}
    }
	
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
    	return new TileEntityTubbyVoiceTrumpet();
    }
    
    @Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[]{FACING, POSITION});
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getHorizontal(meta);
		if(meta < 4) {
			return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(POSITION, PropertyPosition.BOTTOM);
		}
		else {
			return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(POSITION, PropertyPosition.TOP);
		}
    }

	@Override
    public int getMetaFromState(IBlockState state) {
		if(((PropertyPosition) state.getValue(POSITION)).getID() == 0) {
	        return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
		}
		else {
	        return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex() + 4;
		}
    }

    @Override
    public int getRenderType() {
    	return 3;
    }
    
    @Override
    public int quantityDropped(Random rand) {
    	return 1;
    }

    @Override
    public boolean isOpaqueCube() {
    	return false;
    }
    
    @Override
    public boolean isBlockNormalCube() {
        return false;
    }
    
    @Override
    public boolean isFullCube() {
        return false;
    }
}