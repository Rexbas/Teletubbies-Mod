package com.rexbas.teletubbies.block;

import javax.annotation.Nullable;

import com.rexbas.teletubbies.tileentity.VoiceTrumpetTileEntity;
import com.rexbas.teletubbies.util.VoxelShapeRotation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNodeType;
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

public class VoiceTrumpetBlock extends Block implements IWaterLoggable {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
		
	protected static final VoxelShape TOP_AABB_NORTH = VoxelShapes.or(
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
	public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, @Nullable MobEntity entity) {
        return PathNodeType.BLOCKED;
    }
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
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
	public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if (placer != null) {
		    FluidState fluidState = world.getFluidState(pos.above());
		    world.setBlockAndUpdate(pos.above(), state.setValue(BOTTOM, false).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER));
		}
	}
	
	@Override
	public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {	     
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
    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
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
	public BlockState getStateForPlacement(BlockItemUseContext context) {
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
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, IWorld world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.getLiquidTicks().scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}
	
	@Override
	protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, BOTTOM, WATERLOGGED);
	}
	
	public boolean isUnderwater(World world, BlockPos pos) {
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
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		if (state.getValue(BOTTOM)) {
			return new VoiceTrumpetTileEntity();
		}
		return null;
	}
}
