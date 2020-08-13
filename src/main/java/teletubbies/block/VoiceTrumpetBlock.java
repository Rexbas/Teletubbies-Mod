package teletubbies.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import teletubbies.tileentity.VoiceTrumpetTileEntity;
import teletubbies.util.VoxelShapeRotation;

public class VoiceTrumpetBlock extends Block implements IWaterLoggable {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
		
	protected static final VoxelShape TOP_AABB_NORTH = VoxelShapes.or(
			makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D), 
			makeCuboidShape(6.0D, 2.0D, 7.0D, 10.0D, 3.0D, 11.0D), 
			makeCuboidShape(5.0D, 3.0D, 7.0D, 6.0D, 7.0D, 11.0D), 
			makeCuboidShape(10.0D, 3.0D, 7.0D, 11.0D, 7.0D, 11.0D), 
			makeCuboidShape(6.0D, 7.0D, 7.0D, 10.0D, 8.0D, 11.0D),
			makeCuboidShape(6.0D, 3.0D, 6.0D, 10.0D, 7.0D, 7.0D),
			makeCuboidShape(6.0D, 3.0D, 9.0D, 10.0D, 7.0D, 10.0D))
			.simplify();
	
	protected static final VoxelShape TOP_AABB_EAST = VoxelShapeRotation.rotateY(TOP_AABB_NORTH, Math.toRadians(270));
	protected static final VoxelShape TOP_AABB_SOUTH = VoxelShapeRotation.rotateY(TOP_AABB_NORTH, Math.toRadians(180));
	protected static final VoxelShape TOP_AABB_WEST = VoxelShapeRotation.rotateY(TOP_AABB_NORTH, Math.toRadians(90));
	
	protected static final VoxelShape BOTTOM_AABB = Block.makeCuboidShape(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
	
	public VoiceTrumpetBlock() {
		super(Properties.create(Material.IRON)
				.hardnessAndResistance(3.0f, 5.0f)
				.harvestLevel(1)
				.harvestTool(ToolType.PICKAXE));

		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(BOTTOM, true).with(WATERLOGGED, false));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		if (state.get(BOTTOM)) {
			return BOTTOM_AABB;
		}
		switch(state.get(FACING)) {
		case NORTH:
			return TOP_AABB_NORTH;
		case EAST:
			return TOP_AABB_EAST;
		case SOUTH:
			return TOP_AABB_SOUTH;
		case WEST:
			return TOP_AABB_WEST;
		default:
			return TOP_AABB_NORTH;
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if (placer != null) {
		    FluidState fluidState = world.getFluidState(pos.up());
		    world.setBlockState(pos.up(), state.with(BOTTOM, false).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER));
		}
	}
	
	@Override
	public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {	     
		BlockPos other = state.get(BOTTOM) ? pos.up() : pos.down();	     
		BlockState otherState = world.getBlockState(other);	      
		if (otherState.getBlock() == this) {
			FluidState fluidState = world.getFluidState(other);
		    if (fluidState.getFluid() == Fluids.WATER) {
				world.setBlockState(other, fluidState.getBlockState(), 35); 
		    }
		    else {
		    	world.setBlockState(other, Blocks.AIR.getDefaultState(), 35);
		    }
		}		      
		super.onBlockHarvested(world, pos, state, player);
	}
	
	@Override
    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
		BlockPos other = state.get(BOTTOM) ? pos.up() : pos.down();	     
		BlockState otherState = world.getBlockState(other);	      
		if (otherState.getBlock() == this) {		      
			FluidState fluidState = world.getFluidState(other);
		    if (fluidState.getFluid() == Fluids.WATER) {
				world.setBlockState(other, fluidState.getBlockState(), 35); 
		    }
		    else {
		    	world.setBlockState(other, Blocks.AIR.getDefaultState(), 35);
		    }   
		}		
		super.onBlockExploded(state, world, pos, explosion);
    }
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos pos = context.getPos();
		if (pos.getY() < 255 && context.getWorld().getBlockState(pos.up()).isReplaceable(context)) {
		    FluidState fluidState = context.getWorld().getFluidState(pos);
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing()).with(BOTTOM, true).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
		}
		return null;
	}
	
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
	}
	
	@Override
	public BlockState updatePostPlacement(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
		if (state.get(WATERLOGGED)) {
			world.getPendingFluidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
		}
		return super.updatePostPlacement(state, facing, facingState, world, currentPos, facingPos);
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, BOTTOM, WATERLOGGED);
	}
	
	public boolean isUnderwater(World world, BlockPos pos) {
		BlockPos tilePos = world.getBlockState(pos).get(BOTTOM) ? pos : pos.down();
		if (world.getBlockState(tilePos).get(WATERLOGGED) && world.getBlockState(tilePos.up()).get(WATERLOGGED)) return true;
		return false;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return state.get(BOTTOM);
	}
	
	@Nullable
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		if (state.get(BOTTOM)) {
			return new VoiceTrumpetTileEntity();
		}
		return null;
	}
}
