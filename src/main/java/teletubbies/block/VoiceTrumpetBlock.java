package teletubbies.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolType;
import teletubbies.tileentity.VoiceTrumpetTileEntity;
import teletubbies.util.VoxelShapeRotation;

public class VoiceTrumpetBlock extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
		
	protected static final VoxelShape TOP_AABB_NORTH = Shapes.or(
			box(7.0D, 0.0D, 7.0D, 9.0D, 2.0D, 9.0D), 
			box(6.0D, 2.0D, 7.0D, 10.0D, 3.0D, 11.0D), 
			box(5.0D, 3.0D, 7.0D, 6.0D, 7.0D, 11.0D), 
			box(10.0D, 3.0D, 7.0D, 11.0D, 7.0D, 11.0D), 
			box(6.0D, 7.0D, 7.0D, 10.0D, 8.0D, 11.0D),
			box(6.0D, 3.0D, 6.0D, 10.0D, 7.0D, 7.0D),
			box(6.0D, 3.0D, 9.0D, 10.0D, 7.0D, 10.0D))
			.optimize();
	
	protected static final VoxelShape TOP_AABB_EAST = VoxelShapeRotation.rotateY(TOP_AABB_NORTH, Math.toRadians(270));
	protected static final VoxelShape TOP_AABB_SOUTH = VoxelShapeRotation.rotateY(TOP_AABB_NORTH, Math.toRadians(180));
	protected static final VoxelShape TOP_AABB_WEST = VoxelShapeRotation.rotateY(TOP_AABB_NORTH, Math.toRadians(90));
	
	protected static final VoxelShape BOTTOM_AABB = Block.box(7.0D, 0.0D, 7.0D, 9.0D, 16.0D, 9.0D);
	
	public VoiceTrumpetBlock() {
		super(Properties.of(Material.METAL)
				.strength(3.0f, 5.0f)
				.harvestLevel(1)
				.harvestTool(ToolType.PICKAXE));

		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(BOTTOM, true).setValue(WATERLOGGED, false));
	}
	
	@Override
    @Nullable
	public BlockPathTypes getAiPathNodeType(BlockState state, BlockGetter world, BlockPos pos, @Nullable Mob entity) {
        return BlockPathTypes.BLOCKED;
    }
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(BOTTOM)) {
			return BOTTOM_AABB;
		}
		switch(state.getValue(FACING)) {
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
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if (placer != null) {
		    FluidState fluidState = world.getFluidState(pos.above());
		    world.setBlockAndUpdate(pos.above(), state.setValue(BOTTOM, false).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER));
		}
	}
	
	@Override
	public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {	     
		BlockPos other = state.getValue(BOTTOM) ? pos.above() : pos.below();	     
		BlockState otherState = world.getBlockState(other);	      
		if (otherState.getBlock() == this) {
			FluidState fluidState = world.getFluidState(other);
		    if (fluidState.getType() == Fluids.WATER) {
				world.setBlock(other, fluidState.createLegacyBlock(), 35); 
		    }
		    else {
		    	world.setBlock(other, Blocks.AIR.defaultBlockState(), 35);
		    }
		}		      
		super.playerWillDestroy(world, pos, state, player);
	}
	
	@Override
    public void onBlockExploded(BlockState state, Level world, BlockPos pos, Explosion explosion) {
		BlockPos other = state.getValue(BOTTOM) ? pos.above() : pos.below();	     
		BlockState otherState = world.getBlockState(other);	      
		if (otherState.getBlock() == this) {		      
			FluidState fluidState = world.getFluidState(other);
		    if (fluidState.getType() == Fluids.WATER) {
				world.setBlock(other, fluidState.createLegacyBlock(), 35); 
		    }
		    else {
		    	world.setBlock(other, Blocks.AIR.defaultBlockState(), 35);
		    }   
		}		
		super.onBlockExploded(state, world, pos, explosion);
    }
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		BlockPos pos = context.getClickedPos();
		if (pos.getY() < 255 && context.getLevel().getBlockState(pos.above()).canBeReplaced(context)) {
		    FluidState fluidState = context.getLevel().getFluidState(pos);
			return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection()).setValue(BOTTOM, true).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
		}
		return null;
	}
	
	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}
	
	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, BOTTOM, WATERLOGGED);
	}
	
	public boolean isUnderwater(Level world, BlockPos pos) {
		BlockPos tilePos = world.getBlockState(pos).getValue(BOTTOM) ? pos : pos.below();
		if (world.getBlockState(tilePos).getValue(WATERLOGGED) && world.getBlockState(tilePos.above()).getValue(WATERLOGGED)) return true;
		return false;
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return state.getValue(BOTTOM);
	}
	
	@Nullable
	@Override
	public BlockEntity createTileEntity(BlockState state, BlockGetter world) {
		if (state.getValue(BOTTOM)) {
			return new VoiceTrumpetTileEntity();
		}
		return null;
	}
}
