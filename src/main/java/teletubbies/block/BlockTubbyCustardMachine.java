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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.block.properties.PropertyTubbyCustardMachine;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import teletubbies.item.TubbyBowl;


public class BlockTubbyCustardMachine extends BlockContainer {

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public static final PropertyEnum POSITION = PropertyEnum.create("position", PropertyTubbyCustardMachine.class);
	private final String name = "TubbyCustardMachine";

	public BlockTubbyCustardMachine() {
        super(Material.grass);
        this.setCreativeTab(Teletubbies.tabTeletubbies);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        this.setUnlocalizedName(name);
        this.setHardness(0.5F);
        this.setResistance(10.0F);
        this.setDefaultState(this.getDefaultState().withProperty(POSITION, PropertyTubbyCustardMachine.BOTTOM_CENTER));
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack itemstack) {
		super.onBlockPlacedBy(world, pos, state, player, itemstack);
	    int facing = player.getHorizontalFacing().getHorizontalIndex();
	    
		IBlockState state0 = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(POSITION, PropertyTubbyCustardMachine.BOTTOM_LEFT);
		
		IBlockState bottom_left = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(POSITION, PropertyTubbyCustardMachine.BOTTOM_LEFT);
		IBlockState bottom_center = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(POSITION, PropertyTubbyCustardMachine.BOTTOM_CENTER);
		IBlockState bottom_right = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(POSITION, PropertyTubbyCustardMachine.BOTTOM_RIGHT);
		IBlockState top_left = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(POSITION, PropertyTubbyCustardMachine.TOP_LEFT);
		IBlockState top_right = this.getDefaultState().withProperty(FACING, player.getHorizontalFacing()).withProperty(POSITION, PropertyTubbyCustardMachine.TOP_RIGHT);
		
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
	    		world.setBlockState(pos0, bottom_right);
	    		world.setBlockState(pos1, bottom_left);
	    		world.setBlockState(pos2, top_right);
	    		world.setBlockState(pos3, top_left);
	    	}
	    	else {
	    		world.setBlockState(pos0, bottom_left);
	    		world.setBlockState(pos1, bottom_right);
	    		world.setBlockState(pos2, top_left);
	    		world.setBlockState(pos3, top_right);
	    	}
	    	
    		TileEntityTubbyCustardMachine te1 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos0);
    		TileEntityTubbyCustardMachine te2 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos1);
    		TileEntityTubbyCustardMachine te3 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos2);
    		TileEntityTubbyCustardMachine te4 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos3);
    		
    		te1.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, false);
    		te2.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, false);
    		te3.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, false);
    		te4.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, false);
	    }
	    if(facing == 1 || facing == 3) {
	    	if(facing == 1) {
	    		world.setBlockState(pos4, bottom_right);
	    		world.setBlockState(pos5, bottom_left);
	    		world.setBlockState(pos6, top_right);
	    		world.setBlockState(pos7, top_left);
	    	}
	    	else {
	    		world.setBlockState(pos4, bottom_left);
	    		world.setBlockState(pos5, bottom_right);
	    		world.setBlockState(pos6, top_left);
	    		world.setBlockState(pos7, top_right);
	    	}
    		
    		TileEntityTubbyCustardMachine te1 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos4);
    		TileEntityTubbyCustardMachine te2 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos5);
    		TileEntityTubbyCustardMachine te3 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos6);
    		TileEntityTubbyCustardMachine te4 = (TileEntityTubbyCustardMachine) world.getTileEntity(pos7);
    		
    		te1.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, false);
    		te2.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, false);
    		te3.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, false);
    		te4.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, false);
	    }
	    
	    TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine)world.getTileEntity(pos);
		te.setMasterData(pos.getX(), pos.getY(), pos.getZ(), facing, true);
	}
	
	@Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityTubbyCustardMachine te = (TileEntityTubbyCustardMachine) world.getTileEntity(pos);
        if(te == null || (player.isSneaking() && player.getHeldItem() != null)) return false;
	
        if(player.getHeldItem() != null) {
    		if(player.getHeldItem().getItem() instanceof TubbyBowl) {
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
    			ChatComponentText msg = new ChatComponentText(StatCollector.translateToLocal("teletubbies.TubbyCustardMachine.message"));
    			player.addChatMessage(msg);
    		}
        }
		else if(world.isRemote){
			ChatComponentText msg = new ChatComponentText(StatCollector.translateToLocal("teletubbies.TubbyCustardMachine.message"));
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
		if(te.getMasterDirection() == null) {
			
		}
		if(te.getMasterDirection() == 0 || te.getMasterDirection() == 2) {
			world.destroyBlock(pos0, false);
			world.destroyBlock(pos1, false);
			world.destroyBlock(pos2, false);
			world.destroyBlock(pos3, false);
		}
		if(te.getMasterDirection() == 1 || te.getMasterDirection() == 3) {
			world.destroyBlock(pos4, false);
			world.destroyBlock(pos5, false);
			world.destroyBlock(pos6, false);
			world.destroyBlock(pos7, false);
		}
	
		world.destroyBlock(pos, false);
	}
	
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
    	return new TileEntityTubbyCustardMachine();
    }
    
	@Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[]{FACING, POSITION});
    }
	
	@Override
    public IBlockState getStateFromMeta(int meta) {
		int facing = meta;
		IBlockState state;
		if(meta > 15) {
			facing -= 16;
			state = this.getDefaultState().withProperty(POSITION, PropertyTubbyCustardMachine.TOP_RIGHT);
		}
		else if(meta > 11) {
			facing -= 12;
			state = this.getDefaultState().withProperty(POSITION, PropertyTubbyCustardMachine.TOP_LEFT);
		}
		else if(meta > 7) {
			facing -= 8;
			state = this.getDefaultState().withProperty(POSITION, PropertyTubbyCustardMachine.BOTTOM_RIGHT);
		}
		else if(meta > 3) {
			facing -= 4;
			state = this.getDefaultState().withProperty(POSITION, PropertyTubbyCustardMachine.BOTTOM_CENTER);
		}
		else {
			state = this.getDefaultState().withProperty(POSITION, PropertyTubbyCustardMachine.BOTTOM_LEFT);
		}
		EnumFacing enumfacing = EnumFacing.getHorizontal(facing);
		return state.withProperty(FACING, enumfacing);
    }

	@Override
    public int getMetaFromState(IBlockState state) {		
		switch(((PropertyTubbyCustardMachine) state.getValue(POSITION)).getID()) {
		case 0:
			return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
		case 1:
			return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex() + 4;
		case 2:
			return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex() + 8;
		case 3:
			return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex() + 12;
		case 4:
			return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex() + 16;
		default:
			return ((EnumFacing) state.getValue(FACING)).getHorizontalIndex();
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
}