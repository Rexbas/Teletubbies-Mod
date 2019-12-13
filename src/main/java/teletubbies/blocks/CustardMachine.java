package teletubbies.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import teletubbies.Teletubbies;
import teletubbies.lists.ItemList;
import teletubbies.lists.SoundList;
import teletubbies.tileentities.CustardMachineTile;
import teletubbies.util.VoxelShapeRotation;

public class CustardMachine extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final EnumProperty<CustardMachinePart> PART = EnumProperty.create("part", CustardMachinePart.class);
		
	protected static final VoxelShape SMALLTOWER_AABB_NORTH = VoxelShapes.or(
			makeCuboidShape(7.0D, 0.0D, 5.0D, 13.0D, 3.0D, 11.0D), 
			makeCuboidShape(8.0D, 3.0D, 6.0D, 12.0D, 10.0D, 10.0D), 
			makeCuboidShape(7.0D, 10.0D, 5.0D, 13.0D, 11.0D, 11.0D), 
			makeCuboidShape(8.0D, 11.0D, 6.0D, 12.0D, 13.0D, 10.0D),
			makeCuboidShape(9.0D, 13.0D, 7.0D, 11.0D, 14.0D, 9.0D))
			.simplify();
	
	protected static final VoxelShape BIGTOWER_AABB_NORTH = VoxelShapes.or(
			makeCuboidShape(3.0D, 0.0D, 5.0D, 9.0D, 3.0D, 11.0D), 
			makeCuboidShape(4.0D, 3.0D, 6.0D, 8.0D, 12.0D, 10.0D), 
			makeCuboidShape(3.0D, 12.0D, 5.0D, 9.0D, 13.0D, 11.0D), 
			makeCuboidShape(4.0D, 13.0D, 6.0D, 8.0D, 15.0D, 10.0D),
			makeCuboidShape(5.0D, 15.0D, 7.0D, 7.0D, 16.0D, 9.0D),
			makeCuboidShape(7.0D, 0.0D, 2.0D, 12.0D, 3.0D, 5.0D))
			.simplify();
	
	protected static final VoxelShape SMALLTOWER_AABB_EAST = VoxelShapeRotation.rotateY(SMALLTOWER_AABB_NORTH, Math.toRadians(270));
	protected static final VoxelShape SMALLTOWER_AABB_SOUTH = VoxelShapeRotation.rotateY(SMALLTOWER_AABB_NORTH, Math.toRadians(180));
	protected static final VoxelShape SMALLTOWER_AABB_WEST = VoxelShapeRotation.rotateY(SMALLTOWER_AABB_NORTH, Math.toRadians(90));
	protected static final VoxelShape BIGTOWER_AABB_EAST = VoxelShapeRotation.rotateY(BIGTOWER_AABB_NORTH, Math.toRadians(270));
	protected static final VoxelShape BIGTOWER_AABB_SOUTH = VoxelShapeRotation.rotateY(BIGTOWER_AABB_NORTH, Math.toRadians(180));
	protected static final VoxelShape BIGTOWER_AABB_WEST = VoxelShapeRotation.rotateY(BIGTOWER_AABB_NORTH, Math.toRadians(90));
		
	public CustardMachine() {
		super(Properties.create(Material.IRON)
				.hardnessAndResistance(3.0f, 5.0f)
				.harvestTool(ToolType.PICKAXE));

		this.setRegistryName(Teletubbies.MODID, "custardmachine");
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(PART, CustardMachinePart.BASE));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		if (state.get(PART) == CustardMachinePart.BASE || state.get(PART) == CustardMachinePart.BIGBASE || state.get(PART) == CustardMachinePart.SMALLBASE) {
			return VoxelShapes.fullCube();
		}
		if (state.get(PART) == CustardMachinePart.SMALL) {
			switch(state.get(FACING)) {
			case NORTH:
				return SMALLTOWER_AABB_NORTH;
			case EAST:
				return SMALLTOWER_AABB_EAST;
			case SOUTH:
				return SMALLTOWER_AABB_SOUTH;
			case WEST:
				return SMALLTOWER_AABB_WEST;
			default:
				return SMALLTOWER_AABB_NORTH;
			}
		}
		switch(state.get(FACING)) {
		case NORTH:
			return BIGTOWER_AABB_NORTH;
		case EAST:
			return BIGTOWER_AABB_EAST;
		case SOUTH:
			return BIGTOWER_AABB_SOUTH;
		case WEST:
			return BIGTOWER_AABB_WEST;
		default:
			return BIGTOWER_AABB_NORTH;
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if (placer != null) {
			BlockPos smallbasePos = getSmallTowerBasePos(pos, placer.getHorizontalFacing());
			BlockPos bigbasePos = getBigTowerBasePos(pos, placer.getHorizontalFacing());
			BlockPos smallPos = getSmallTowerPos(pos, placer.getHorizontalFacing());
			BlockPos bigPos = getBigTowerPos(pos, placer.getHorizontalFacing());
			world.setBlockState(smallbasePos, state.with(FACING, placer.getHorizontalFacing()).with(PART, CustardMachinePart.SMALLBASE));
		    world.setBlockState(bigbasePos, state.with(FACING, placer.getHorizontalFacing()).with(PART, CustardMachinePart.BIGBASE));
		    world.setBlockState(smallPos, state.with(FACING, placer.getHorizontalFacing()).with(PART, CustardMachinePart.SMALL));
		    world.setBlockState(bigPos, state.with(FACING, placer.getHorizontalFacing()).with(PART, CustardMachinePart.BIG));
		}
	}
	
	@Override
	public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {
		Direction facing = state.get(FACING);
		
		BlockPos basePos = getBasePos(pos, state.get(PART), facing);
		BlockState subblockState = world.getBlockState(basePos);
		if (subblockState.getBlock() == this && !pos.equals(basePos)) {	
			world.setBlockState(basePos, Blocks.AIR.getDefaultState(), 35);		      
		}
		
		BlockPos subblock = getSmallTowerBasePos(basePos, facing);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {	
			world.setBlockState(subblock, Blocks.AIR.getDefaultState(), 35);		      
		}
		
		subblock = getBigTowerBasePos(basePos, facing);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {
			world.setBlockState(subblock, Blocks.AIR.getDefaultState(), 35);		      
		}
		
		subblock = getSmallTowerPos(basePos, facing);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {	
			world.setBlockState(subblock, Blocks.AIR.getDefaultState(), 35);		      
		}
		
		subblock = getBigTowerPos(basePos, facing);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {		
			world.setBlockState(subblock, Blocks.AIR.getDefaultState(), 35);		      
		}		      
		super.onBlockHarvested(world, pos, state, player);
	}
	
	@Override
    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
		Direction facing = state.get(FACING);
		
		BlockPos basePos = getBasePos(pos, state.get(PART), facing);
		BlockState subblockState = world.getBlockState(basePos);
		if (subblockState.getBlock() == this && !pos.equals(basePos)) {		      
			world.setBlockState(basePos, Blocks.AIR.getDefaultState(), 35);		      
		}
		
		BlockPos subblock = getSmallTowerBasePos(basePos, facing);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {		      
			world.setBlockState(subblock, Blocks.AIR.getDefaultState(), 35);		      
		}
		
		subblock = getBigTowerBasePos(basePos, facing);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {		      
			world.setBlockState(subblock, Blocks.AIR.getDefaultState(), 35);		      
		}
		
		subblock = getSmallTowerPos(basePos, facing);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {		      
			world.setBlockState(subblock, Blocks.AIR.getDefaultState(), 35);		      
		}
		
		subblock = getBigTowerPos(basePos, facing);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {		      
			world.setBlockState(subblock, Blocks.AIR.getDefaultState(), 35);		      
		}
		super.onBlockExploded(state, world, pos, explosion);
    }
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos pos = context.getPos();
		BlockPos smallbasePos = getSmallTowerBasePos(pos, context.getPlacementHorizontalFacing());
		BlockPos bigbasePos = getBigTowerBasePos(pos, context.getPlacementHorizontalFacing());
		BlockPos smallPos = getSmallTowerPos(pos, context.getPlacementHorizontalFacing());
		BlockPos bigPos = getBigTowerPos(pos, context.getPlacementHorizontalFacing());
		if (pos.getY() < 255 &&
				smallbasePos.getY() < 255 && context.getWorld().getBlockState(smallbasePos).isReplaceable(context) &&
				bigbasePos.getY() < 255 && context.getWorld().getBlockState(bigbasePos).isReplaceable(context) &&
				smallPos.getY() < 255 && context.getWorld().getBlockState(smallPos).isReplaceable(context) &&
				bigPos.getY() < 255 && context.getWorld().getBlockState(bigPos).isReplaceable(context)) {
			
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing()).with(PART, CustardMachinePart.BASE);
		}
		return null;
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, PART);
	}
	
	@Override
	public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {		
		if (player.getHeldItemMainhand() != null) {
			if (player.getHeldItemMainhand().getItem() == ItemList.bowl) {
				BlockPos tilePos = getBasePos(pos, state.get(PART), state.get(FACING));
				CustardMachineTile t = (CustardMachineTile) world.getTileEntity(tilePos);
				
				int slot = player.inventory.currentItem;
				ItemStack stack = player.inventory.getStackInSlot(slot);
				
				if (t.canDrop()) {
					stack.setCount(stack.getCount() - 1);
					world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundList.custard, SoundCategory.AMBIENT, 1, 1, false);
					t.reset();
				}
			}
			else {
				if (world.isRemote) {
					ITextComponent msg = new StringTextComponent("\u00A77").appendSibling(new TranslationTextComponent("teletubbies.custardmachine.message"));
					player.sendMessage(msg);
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return (state.get(PART) == CustardMachinePart.BASE);
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		if (state.get(PART) == CustardMachinePart.BASE) {
			return new CustardMachineTile();
		}
		return null;
	}
	
	private BlockPos getSmallTowerBasePos(BlockPos base, Direction facing) {
		switch (facing) {
		case NORTH:
			return base.east();
		case EAST:
			return base.south();
		case SOUTH:
			return base.west();
		case WEST:
			return base.north();
		default:
			return base.east();		
		}	
	}
	
	private BlockPos getBigTowerBasePos(BlockPos base, Direction facing) {
		switch (facing) {
		case NORTH:
			return base.west();
		case EAST:
			return base.north();
		case SOUTH:
			return base.east();
		case WEST:
			return base.south();
		default:
			return base.west();		
		}	
	}
	
	private BlockPos getSmallTowerPos(BlockPos base, Direction facing) {
		switch (facing) {
		case NORTH:
			return base.east().up();
		case EAST:
			return base.south().up();
		case SOUTH:
			return base.west().up();
		case WEST:
			return base.north().up();
		default:
			return base.east().up();		
		}	
	}
	
	private BlockPos getBigTowerPos(BlockPos base, Direction facing) {
		switch (facing) {
		case NORTH:
			return base.west().up();
		case EAST:
			return base.north().up();
		case SOUTH:
			return base.east().up();
		case WEST:
			return base.south().up();
		default:
			return base.west().up();		
		}	
	}
	
	private BlockPos getBasePos(BlockPos pos, CustardMachinePart part, Direction facing) {
		if (part == CustardMachinePart.BASE) return pos;
		switch (facing) {
		case NORTH:
			switch (part) {
			case BIG:
				return pos.east().down();
			case BIGBASE:
				return pos.east();
			case SMALL:
				return pos.west().down();
			case SMALLBASE:
				return pos.west();
			default:
				return null;
			}
		case EAST:
			switch (part) {
			case BIG:
				return pos.south().down();
			case BIGBASE:
				return pos.south();
			case SMALL:
				return pos.north().down();
			case SMALLBASE:
				return pos.north();
			default:
				return null;
			}
		case SOUTH:
			switch (part) {
			case BIG:
				return pos.west().down();
			case BIGBASE:
				return pos.west();
			case SMALL:
				return pos.east().down();
			case SMALLBASE:
				return pos.east();
			default:
				return null;
			}
		case WEST:
			switch (part) {
			case BIG:
				return pos.north().down();
			case BIGBASE:
				return pos.north();
			case SMALL:
				return pos.south().down();
			case SMALLBASE:
				return pos.south();
			default:
				return null;
			}
		default:
			return null;
		}
	}
}
