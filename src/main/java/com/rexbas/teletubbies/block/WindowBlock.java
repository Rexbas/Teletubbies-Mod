package com.rexbas.teletubbies.block;

import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
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
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class WindowBlock extends Block {
	public static final BooleanProperty X_AXIS = BooleanProperty.create("x_axis");
	public static final EnumProperty<WindowPart> PART = EnumProperty.create("part", WindowPart.class);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;	
	
	protected static final VoxelShape AABB_Z = box(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	protected static final VoxelShape AABB_X = TeletubbiesBlocks.voxelShapeRotateY(AABB_Z, Math.toRadians(90));
	
	public WindowBlock() {
		super(Properties.copy(Blocks.GLASS_PANE));
		
		this.registerDefaultState(this.stateDefinition.any().setValue(X_AXIS, false).setValue(PART, WindowPart.CENTER).setValue(WATERLOGGED, false));
	}
	
	@Override
    @Nullable
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, @Nullable Mob entity) {
        return BlockPathTypes.BLOCKED;
    }
	
	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		if (state.getValue(X_AXIS)) {
			return AABB_X;
		}
		return AABB_Z;
	}
	
	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if (placer != null) {
			Axis axis = placer.getDirection().getAxis();
			BlockPos ha = getHA(pos, axis);
			BlockPos hb = getHB(pos, axis);
			BlockPos sa = getSA(pos, axis);
			BlockPos sb = getSB(pos, axis);
		    FluidState haFluid = world.getFluidState(ha);
		    FluidState hbFluid = world.getFluidState(hb);
		    FluidState saFluid = world.getFluidState(sa);
		    FluidState sbFluid = world.getFluidState(sb);
		    FluidState vFluid = world.getFluidState(pos.above());
			world.setBlockAndUpdate(ha, state.setValue(PART, WindowPart.HORIZONTAL_A).setValue(WATERLOGGED, haFluid.getType() == Fluids.WATER));
		    world.setBlockAndUpdate(hb, state.setValue(PART, WindowPart.HORIZONTAL_B).setValue(WATERLOGGED, hbFluid.getType() == Fluids.WATER));
		    world.setBlockAndUpdate(sa, state.setValue(PART, WindowPart.SLANTED_A).setValue(WATERLOGGED, saFluid.getType() == Fluids.WATER));
		    world.setBlockAndUpdate(sb, state.setValue(PART, WindowPart.SLANTED_B).setValue(WATERLOGGED, sbFluid.getType() == Fluids.WATER));
		    world.setBlockAndUpdate(pos.above(), state.setValue(PART, WindowPart.VERTICAL).setValue(WATERLOGGED, vFluid.getType() == Fluids.WATER));
		}
	}
	
	@Override
	public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {	     
		Axis axis = state.getValue(X_AXIS) ? Axis.X : Axis.Z;
		
		BlockPos basePos = getCenterPos(pos, state.getValue(PART), axis);
		BlockState subblockState = world.getBlockState(basePos);
		if (subblockState.getBlock() == this && !pos.equals(basePos)) {
			removePart(world, basePos, subblockState);
		}
		
		BlockPos subblock = getHA(basePos, axis);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {	
			removePart(world, subblock, subblockState);
		}
		
		subblock = getHB(basePos, axis);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {
			removePart(world, subblock, subblockState);
		}
		
		subblock = basePos.above();
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {	
			removePart(world, subblock, subblockState);
		}
		
		subblock = getSA(basePos, axis);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {		
			removePart(world, subblock, subblockState);
		}
		
		subblock = getSB(basePos, axis);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {		
			removePart(world, subblock, subblockState);
		}	
		super.playerWillDestroy(world, pos, state, player);
	}
	
	@Override
    public void onBlockExploded(BlockState state, Level world, BlockPos pos, Explosion explosion) {
		Axis axis = state.getValue(X_AXIS) ? Axis.X : Axis.Z;
		
		BlockPos basePos = getCenterPos(pos, state.getValue(PART), axis);
		BlockState subblockState = world.getBlockState(basePos);
		if (subblockState.getBlock() == this && !pos.equals(basePos)) {
			removePart(world, basePos, subblockState);
		}
		
		BlockPos subblock = getHA(basePos, axis);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {	
			removePart(world, subblock, subblockState);
		}
		
		subblock = getHB(basePos, axis);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {
			removePart(world, subblock, subblockState);
		}
		
		subblock = basePos.above();
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {	
			removePart(world, subblock, subblockState);
		}
		
		subblock = getSA(basePos, axis);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {		
			removePart(world, subblock, subblockState);
		}
		
		subblock = getSB(basePos, axis);
		subblockState = world.getBlockState(subblock);
		if (subblockState.getBlock() == this && !pos.equals(subblock)) {		
			removePart(world, subblock, subblockState);
		}
		super.onBlockExploded(state, world, pos, explosion);
    }
	
	private void removePart(Level world, BlockPos pos, BlockState state) {
		FluidState fluidState = world.getFluidState(pos);
	    if (fluidState.getType() == Fluids.WATER) {
			world.setBlock(pos, fluidState.createLegacyBlock(), 35); 
	    }
	    else {
	    	world.setBlock(pos, Blocks.AIR.defaultBlockState(), 35);
	    }
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		Axis axis = context.getHorizontalDirection().getAxis();
		BlockPos pos = context.getClickedPos();
		BlockPos ha = getHA(pos, axis);
		BlockPos hb = getHB(pos, axis);
		BlockPos sa = getSA(pos, axis);
		BlockPos sb = getSB(pos, axis);
		BlockPos v = pos.above();
		if (pos.getY() < 255 &&
				ha.getY() < 255 && context.getLevel().getBlockState(ha).canBeReplaced(context) &&
				hb.getY() < 255 && context.getLevel().getBlockState(hb).canBeReplaced(context) &&
				sa.getY() < 255 && context.getLevel().getBlockState(sa).canBeReplaced(context) &&
				sb.getY() < 255 && context.getLevel().getBlockState(sb).canBeReplaced(context) &&
				v.getY() < 255 && context.getLevel().getBlockState(v).canBeReplaced(context)) {
			
		    FluidState fluidState = context.getLevel().getFluidState(pos);
			return this.defaultBlockState().setValue(X_AXIS, axis == Axis.X).setValue(PART, WindowPart.CENTER).setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER);
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
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(X_AXIS, PART, WATERLOGGED);
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rotation) {
		BlockState newState = state;

		// Fix the axis
		if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.COUNTERCLOCKWISE_90) {
			newState = newState.setValue(X_AXIS, !state.getValue(X_AXIS));
		}
		
		// Fix the A and B sides
		if (rotation == Rotation.CLOCKWISE_180) {
			return flipABSides(newState);
		}
		else if (rotation == Rotation.CLOCKWISE_90 && !newState.getValue(X_AXIS)) {
			return flipABSides(newState);
		}
		else if (rotation == Rotation.COUNTERCLOCKWISE_90 && newState.getValue(X_AXIS)) {
			return flipABSides(newState);
		}
		return newState;
	}
	
	private BlockState flipABSides(BlockState state) {
		BlockState newState = state;

		// Flip A and B side
		if (state.getValue(PART) == WindowPart.HORIZONTAL_A) {
			newState = newState.setValue(PART, WindowPart.HORIZONTAL_B);
		}
		if (state.getValue(PART) == WindowPart.SLANTED_A) {
			newState = newState.setValue(PART, WindowPart.SLANTED_B);
		}
		if (state.getValue(PART) == WindowPart.HORIZONTAL_B) {
			newState = newState.setValue(PART, WindowPart.HORIZONTAL_A);
		}
		if (state.getValue(PART) == WindowPart.SLANTED_B) {
			newState = newState.setValue(PART, WindowPart.SLANTED_A);
		}
		return newState;
	}
	
	private BlockPos getHA(BlockPos base, Axis axis) {
		if (axis == Axis.X) {
			return base.north();
		}
		return base.west();
	}
	
	private BlockPos getHB(BlockPos base, Axis axis) {
		if (axis == Axis.X) {
			return base.south();
		}
		return base.east();	
	}
	
	private BlockPos getSA(BlockPos base, Axis axis) {
		if (axis == Axis.X) {
			return base.north().above();
		}
		return base.west().above();
	}
	
	private BlockPos getSB(BlockPos base, Axis axis) {
		if (axis == Axis.X) {
			return base.south().above();
		}
		return base.east().above();
	}
	
	private BlockPos getCenterPos(BlockPos pos, WindowPart part, Axis axis) {
		if (part == WindowPart.CENTER) return pos;
		if (part == WindowPart.VERTICAL) return pos.below();
		switch (axis) {
		case Z:
			switch (part) {
			case HORIZONTAL_A:
				return pos.east();
			case HORIZONTAL_B:
				return pos.west();
			case SLANTED_A:
				return pos.east().below();
			case SLANTED_B:
				return pos.west().below();
			default:
				return null;
			}
		case X:
			switch (part) {
			case HORIZONTAL_A:
				return pos.south();
			case HORIZONTAL_B:
				return pos.north();
			case SLANTED_A:
				return pos.south().below();
			case SLANTED_B:
				return pos.north().below();
			default:
				return null;
			}
		default:
			return null;
		}
	}
}
