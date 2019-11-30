package teletubbies.block;

import java.util.Random;

import javax.annotation.Nullable;

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
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyToastMachine;

public class BlockTubbyToastMachine extends Block implements ITileEntityProvider {
	
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool RENDER = PropertyBool.create("render");
	
	protected static final AxisAlignedBB TOP = new AxisAlignedBB(0.0, -1.0, 0.0, 1.0, 0.5, 1.0);
	protected static final AxisAlignedBB BOTTOM = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.5, 1.0);
	
	private final String name = "TubbyToastMachine";
	
	public BlockTubbyToastMachine() {
        super(Material.GRASS);
        this.setCreativeTab(Teletubbies.tabTeletubbies);
        this.setUnlocalizedName(name);
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
	    
		BlockPos pos0 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		IBlockState state0 = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(RENDER, false);

		world.setBlockState(pos0, state0);
		TileEntityTubbyToastMachine te1 = (TileEntityTubbyToastMachine) world.getTileEntity(pos0);
		TileEntityTubbyToastMachine te2 = (TileEntityTubbyToastMachine) world.getTileEntity(pos);

		te1.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false);
		te2.setMasterData(pos.getX(), pos.getY(), pos.getZ(), true);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityTubbyToastMachine te = (TileEntityTubbyToastMachine) world.getTileEntity(pos);		
		
        if(te == null || (player.isSneaking() && player.getHeldItemMainhand() != null)) return false;
        
        if(!world.isRemote) {
            TileEntityTubbyToastMachine tem = (TileEntityTubbyToastMachine) world.getTileEntity(new BlockPos(te.getMasterX(), te.getMasterY(), te.getMasterZ()));

            if(tem.canDrop()) {
                dropItemStack(new ItemStack(Teletubbies.tubbyToast, 1), world, te.getMasterX(), te.getMasterY(), te.getMasterZ(), player);
        		world.playSound(null, pos, Teletubbies.sound_TubbyToast, SoundCategory.NEUTRAL, 1, 1);
        		tem.resetDropTicker();
            }
        }

		return true;
	}
	
	public void dropItemStack(ItemStack itemstack, World world, int x, int y, int z, EntityPlayer player) {
    	if(!world.isRemote) {
    		Random rand = new Random();
        	EntityItem entityItem = new EntityItem(world, x + 0.5, y + 1.6, z + 0.5, itemstack);
            
        	float f2 = 0.3F;
            entityItem.motionX = (double)(-MathHelper.sin(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * f2);
            entityItem.motionY = (double)(-MathHelper.sin(player.rotationPitch / 180.0F * (float)Math.PI) * f2 + 0.1F) + 0.2;
            entityItem.motionZ = (double)(MathHelper.cos(player.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(player.rotationPitch / 180.0F * (float)Math.PI) * f2);
            float f3 = rand.nextFloat() * (float)Math.PI * 2.0F;
            f2 = 0.02F * rand.nextFloat();
            entityItem.motionX += Math.cos((double)f3) * (double)f2;
            entityItem.motionY += (double)((rand.nextFloat() - rand.nextFloat()) * 0.1F) + 0.1;
            entityItem.motionZ += Math.sin((double)f3) * (double)f2;
            entityItem.motionX *= - 1;
            entityItem.motionZ *= - 1;

        	world.spawnEntityInWorld(entityItem);
    	}
	}
	
	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityTubbyToastMachine te = (TileEntityTubbyToastMachine) world.getTileEntity(pos);
		this.removeStructure(world, te.getMasterX(), te.getMasterY(), te.getMasterZ());
	}
	
	public void removeStructure(World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		BlockPos pos0 = new BlockPos(x, y + 1, z);
		TileEntityTubbyToastMachine te = (TileEntityTubbyToastMachine) world.getTileEntity(pos);
    	
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
        return new TileEntityTubbyToastMachine();
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
}