package teletubbies.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyVoiceTrumpet;
import teletubbies.block.tileentity.TubbyTileEntity;

public class BlockTubbyVoiceTrumpet extends Block implements ITileEntityProvider {
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool RENDER = PropertyBool.create("render");
	
	protected static final AxisAlignedBB TOP = new AxisAlignedBB(0.3, -1.0, 0.3, 0.7, 0.5, 0.7);
	protected static final AxisAlignedBB BOTTOM = new AxisAlignedBB(0.3, 0.0, 0.3, 0.7, 1.5, 0.7);
	
	private final String name = "tubbyvoicetrumpet";

	public BlockTubbyVoiceTrumpet() {
        super(Material.GRASS);
        this.setCreativeTab(Teletubbies.tabTeletubbies);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.setHardness(0.5F);
        this.setResistance(10.0F);
        this.setDefaultState(this.getDefaultState().withProperty(RENDER, true));
	}
	
	@Override
    public boolean canPlaceBlockAt(World world, BlockPos pos) {
		BlockPos pos0 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
    	if(world.isAirBlock(pos0)) return true;
    	else return false;
    }
	
	@Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
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
		
		BlockPos pos0 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		IBlockState state0 = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(RENDER, false);
	    
		world.setBlockState(pos0, state0);
		TubbyTileEntity te1 = (TubbyTileEntity) world.getTileEntity(pos0);
		TubbyTileEntity te2 = (TubbyTileEntity) world.getTileEntity(pos);

		te1.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false);
		te2.setMasterData(pos.getX(), pos.getY(), pos.getZ(), true);
	}
	
	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TubbyTileEntity te = (TubbyTileEntity) world.getTileEntity(pos);
		this.removeStructure(world, te.getMasterX(), te.getMasterY(), te.getMasterZ());
	}
	
	public void removeStructure(World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		BlockPos pos0 = new BlockPos(x, y + 1, z);
		TubbyTileEntity te = (TubbyTileEntity) world.getTileEntity(pos);    	
		world.destroyBlock(pos0, false);
	
		world.destroyBlock(pos, false);
	}
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		if(!state.getValue(RENDER)) {
			return this.TOP;
		}
		else return this.BOTTOM;
	}
	
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
    	return new TileEntityTubbyVoiceTrumpet();
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING, RENDER});
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta) {
		EnumFacing enumfacing = EnumFacing.getHorizontal(meta);
		if(meta < 4) {
			return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(RENDER, true);
		}
		else {
			return this.getDefaultState().withProperty(FACING, enumfacing).withProperty(RENDER, false);
		}
    }

	@Override
    public int getMetaFromState(IBlockState state) {
		if(state.getValue(RENDER)) {
	        return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
		}
		else {
	        return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex() + 4;
		}
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
    	if(state.getValue(RENDER)) {
    		return EnumBlockRenderType.MODEL;
    	}
    	else return EnumBlockRenderType.INVISIBLE;
    }
    
    @Override
    public int quantityDropped(Random rand) {
    	return 1;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
    	return false;
    }
    
    @Override
    public boolean isBlockNormalCube(IBlockState state) {
        return false;
    }
    
    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }
}