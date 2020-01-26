package teletubbies.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.util.VoxelShapeRotation;

public class WindowBlock extends Block {
	public static final BooleanProperty X_AXIS = BooleanProperty.create("x_axis");
	public static final EnumProperty<WindowPart> PART = EnumProperty.create("part", WindowPart.class);
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;	
	
	protected static final VoxelShape AABB_Z = makeCuboidShape(0.0D, 0.0D, 7.0D, 16.0D, 16.0D, 9.0D);
	protected static final VoxelShape AABB_X = VoxelShapeRotation.rotateY(AABB_Z, Math.toRadians(90));
	
	public WindowBlock() {
		super(Properties.create(Material.GLASS)
				.hardnessAndResistance(0.3F)
				.sound(SoundType.GLASS));
		
		this.setRegistryName(Teletubbies.MODID, "window");
		this.setDefaultState(this.stateContainer.getBaseState().with(X_AXIS, false).with(PART, WindowPart.CENTER).with(WATERLOGGED, false));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		if (state.get(X_AXIS)) {
			return AABB_X;
		}
		return AABB_Z;
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
		if (placer != null) {
			Axis axis = placer.getHorizontalFacing().getAxis();
			BlockPos ha = getHA(pos, axis);
			BlockPos hb = getHB(pos, axis);
			BlockPos sa = getSA(pos, axis);
			BlockPos sb = getSB(pos, axis);
		    IFluidState haFluid = world.getFluidState(ha);
		    IFluidState hbFluid = world.getFluidState(hb);
		    IFluidState saFluid = world.getFluidState(sa);
		    IFluidState sbFluid = world.getFluidState(sb);
		    IFluidState vFluid = world.getFluidState(pos.up());
			world.setBlockState(ha, state.with(PART, WindowPart.HORIZONTAL_A).with(WATERLOGGED, haFluid.getFluid() == Fluids.WATER));
		    world.setBlockState(hb, state.with(PART, WindowPart.HORIZONTAL_B).with(WATERLOGGED, hbFluid.getFluid() == Fluids.WATER));
		    world.setBlockState(sa, state.with(PART, WindowPart.SLANTED_A).with(WATERLOGGED, saFluid.getFluid() == Fluids.WATER));
		    world.setBlockState(sb, state.with(PART, WindowPart.SLANTED_B).with(WATERLOGGED, sbFluid.getFluid() == Fluids.WATER));
		    world.setBlockState(pos.up(), state.with(PART, WindowPart.VERTICAL).with(WATERLOGGED, vFluid.getFluid() == Fluids.WATER));
		}
	}
	
	@Override
	public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {	     
		Axis axis = state.get(X_AXIS) ? Axis.X : Axis.Z;
		
		BlockPos basePos = getCenterPos(pos, state.get(PART), axis);
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
		
		subblock = basePos.up();
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
		super.onBlockHarvested(world, pos, state, player);
	}
	
	@Override
    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
		Axis axis = state.get(X_AXIS) ? Axis.X : Axis.Z;
		
		BlockPos basePos = getCenterPos(pos, state.get(PART), axis);
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
		
		subblock = basePos.up();
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
	
	private void removePart(World world, BlockPos pos, BlockState state) {
		IFluidState fluidState = world.getFluidState(pos);
	    if (fluidState.getFluid() == Fluids.WATER) {
			world.setBlockState(pos, fluidState.getBlockState(), 35); 
	    }
	    else {
	    	world.setBlockState(pos, Blocks.AIR.getDefaultState(), 35);
	    }
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		Axis axis = context.getPlacementHorizontalFacing().getAxis();
		BlockPos pos = context.getPos();
		BlockPos ha = getHA(pos, axis);
		BlockPos hb = getHB(pos, axis);
		BlockPos sa = getSA(pos, axis);
		BlockPos sb = getSB(pos, axis);
		BlockPos v = pos.up();
		if (pos.getY() < 255 &&
				ha.getY() < 255 && context.getWorld().getBlockState(ha).isReplaceable(context) &&
				hb.getY() < 255 && context.getWorld().getBlockState(hb).isReplaceable(context) &&
				sa.getY() < 255 && context.getWorld().getBlockState(sa).isReplaceable(context) &&
				sb.getY() < 255 && context.getWorld().getBlockState(sb).isReplaceable(context) &&
				v.getY() < 255 && context.getWorld().getBlockState(v).isReplaceable(context)) {
			
		    IFluidState fluidState = context.getWorld().getFluidState(pos);
			return this.getDefaultState().with(X_AXIS, axis == Axis.X).with(PART, WindowPart.CENTER).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
		}
		return null;
	}
	
	@Override
	public IFluidState getFluidState(BlockState state) {
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
		builder.add(X_AXIS, PART, WATERLOGGED);
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
			return base.north().up();
		}
		return base.west().up();
	}
	
	private BlockPos getSB(BlockPos base, Axis axis) {
		if (axis == Axis.X) {
			return base.south().up();
		}
		return base.east().up();
	}
	
	private BlockPos getCenterPos(BlockPos pos, WindowPart part, Axis axis) {
		if (part == WindowPart.CENTER) return pos;
		if (part == WindowPart.VERTICAL) return pos.down();
		switch (axis) {
		case Z:
			switch (part) {
			case HORIZONTAL_A:
				return pos.east();
			case HORIZONTAL_B:
				return pos.west();
			case SLANTED_A:
				return pos.east().down();
			case SLANTED_B:
				return pos.west().down();
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
				return pos.south().down();
			case SLANTED_B:
				return pos.north().down();
			default:
				return null;
			}
		default:
			return null;
		}
	}
}
