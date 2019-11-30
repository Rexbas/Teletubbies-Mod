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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import teletubbies.item.TubbyBowl;


public class BlockTubbyCustardMachine extends Block implements ITileEntityProvider {

	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool RENDER = PropertyBool.create("render");
	
	protected static final AxisAlignedBB BOX = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 1.0, 1.0);
	
	private final String name = "TubbyCustardMachine";

	public BlockTubbyCustardMachine() {
        super(Material.GRASS);
        this.setCreativeTab(Teletubbies.tabTeletubbies);
        this.setUnlocalizedName(name);
        this.setHardness(0.5F);
        this.setResistance(10.0F);
        this.setDefaultState(this.getDefaultState().withProperty(RENDER, true));
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack itemstack) {
		super.onBlockPlacedBy(world, pos, state, player, itemstack);
	    int facing = player.getHorizontalFacing().getHorizontalIndex();
	    
		IBlockState state0 = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(RENDER, false);
		//IBlockState right_tower = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(RENDER, false);
		//IBlockState noTower = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(RENDER, false);

		BlockPos pos0 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
		BlockPos pos1 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
		BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ());
		BlockPos pos3 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ());
		
		BlockPos pos4 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
		BlockPos pos5 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
		BlockPos pos6 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1);
		BlockPos pos7 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1);
	    
	    if(facing == 0 || facing == 2) {
	    	if(facing == 0) {
	    		world.setBlockState(pos0, state0);
	    		world.setBlockState(pos1, state0);
	    		world.setBlockState(pos2, state0); //RightTower
	    		world.setBlockState(pos3, state0); //LeftTower
	    	}
	    	else {
	    		world.setBlockState(pos0, state0);
	    		world.setBlockState(pos1, state0);
	    		world.setBlockState(pos2, state0); //LeftTower
	    		world.setBlockState(pos3, state0); //RightTower
	    	}
	    	
    		TileEntityTubbyCustardMachine te1 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos0);
    		TileEntityTubbyCustardMachine te2 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos1);
    		TileEntityTubbyCustardMachine te3 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos2);
    		TileEntityTubbyCustardMachine te4 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos3);
    		
    		te1.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false, facing);
    		te2.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false, facing);
    		te3.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false, facing);
    		te4.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false, facing);
	    }
	    if(facing == 1 || facing == 3) {
	    	if(facing == 1) {
	    		world.setBlockState(pos4, state0);
	    		world.setBlockState(pos5, state0);
	    		world.setBlockState(pos6, state0); //RightTower
	    		world.setBlockState(pos7, state0); //LeftTower
	    	}
	    	else {
	    		world.setBlockState(pos4, state0);
	    		world.setBlockState(pos5, state0);
	    		world.setBlockState(pos6, state0); //LeftTower
	    		world.setBlockState(pos7, state0); //RightTower
	    	}
    		
    		TileEntityTubbyCustardMachine te1 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos4);
    		TileEntityTubbyCustardMachine te2 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos5);
    		TileEntityTubbyCustardMachine te3 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos6);
    		TileEntityTubbyCustardMachine te4 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos7);
    		
    		te1.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false, facing);
    		te2.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false, facing);
    		te3.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false, facing);
    		te4.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false, facing);
	    }
	    
	    TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine)world.getTileEntity(pos);
		te.setMasterData(pos.getX(), pos.getY(), pos.getZ(), true, facing);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine) world.getTileEntity(pos);
        if(te == null || (player.isSneaking() && player.getHeldItemMainhand() != null)) return false;
	
        if(player.getHeldItemMainhand() != null && !world.isRemote) {
    		if(player.getHeldItemMainhand().getItem() instanceof TubbyBowl) {
    			int slot = player.inventory.currentItem;
    			int size = player.inventory.getStackInSlot(slot).stackSize;
    			ItemStack stack0 = player.inventory.getStackInSlot(slot);
    			ItemStack custard = new ItemStack(Teletubbies.tubbyCustard, 1);
    			
    			if(size == 1) {
    				player.inventory.setInventorySlotContents(slot, custard);
    				return false;
    			}
    			
    			if(player.inventory.getFirstEmptyStack() > -1) {
    				--stack0.stackSize;
    				player.inventory.addItemStackToInventory(custard);
    				return false;
    			}
    		}
    		else if(world.isRemote){
    			TextComponentString msg = new TextComponentString(I18n.translateToLocal("teletubbies.TubbyCustardMachine.message"));
    			player.addChatMessage(msg);
    		}
        }
		else if(world.isRemote){
			TextComponentString msg = new TextComponentString(I18n.translateToLocal("teletubbies.TubbyCustardMachine.message"));
			player.addChatMessage(msg);
		}
		return true;
	}
		
	@Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine)world.getTileEntity(pos);
		this.removeStructure(world, te.getMasterX(), te.getMasterY(), te.getMasterZ());
	}
	
	public void removeStructure(World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		BlockPos pos0 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
		BlockPos pos1 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
		BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ());
		BlockPos pos3 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ());
		
		BlockPos pos4 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
		BlockPos pos5 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
		BlockPos pos6 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1);
		BlockPos pos7 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1);
		TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine) world.getTileEntity(pos);
		if(te.masterFacing() == 0 || te.masterFacing() == 2) {
			world.destroyBlock(pos0, false);
			world.destroyBlock(pos1, false);
			world.destroyBlock(pos2, false);
			world.destroyBlock(pos3, false);
		}
		if(te.masterFacing() == 1 || te.masterFacing() == 3) {
			world.destroyBlock(pos4, false);
			world.destroyBlock(pos5, false);
			world.destroyBlock(pos6, false);
			world.destroyBlock(pos7, false);
		}
	
		world.destroyBlock(pos, false);
	}
	
	@Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return this.BOX;
	}
	
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
    	return new TileEntityTubbyCustardMachine();
    }
    
	@Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {FACING, RENDER});
    }
		
	@Override
    public IBlockState getStateFromMeta(int meta) {
		int facing = meta;
		IBlockState state;
		if(meta > 3) {
			facing -= 4;
			state = this.getDefaultState().withProperty(RENDER, false);
		}
		else {
			state = this.getDefaultState().withProperty(RENDER, true);
		}
		EnumFacing enumfacing = EnumFacing.getHorizontal(facing);
		return state.withProperty(FACING, enumfacing);
    }

	@Override
    public int getMetaFromState(IBlockState state) {		
		int meta = state.getValue(FACING).getHorizontalIndex();
		if(!state.getValue(RENDER)) {
			meta += 4;
		}
		return meta;
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