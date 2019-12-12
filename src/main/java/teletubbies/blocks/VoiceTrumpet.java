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
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import teletubbies.Teletubbies;
import teletubbies.util.VoxelShapeRotation;

public class VoiceTrumpet extends Block {
	public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
	public static final BooleanProperty BOTTOM = BlockStateProperties.BOTTOM;
		
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
	
	public VoiceTrumpet() {
		super(Properties.create(Material.IRON)
				.hardnessAndResistance(3.0f, 5.0f)
				.harvestLevel(1)
				.harvestTool(ToolType.PICKAXE));
		
		this.setRegistryName(Teletubbies.MODID, "voicetrumpet");
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH).with(BlockStateProperties.BOTTOM, true));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
		boolean isBottom = state.get(BOTTOM);
		if (isBottom) {
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
		    world.setBlockState(pos.up(), state.with(FACING, placer.getHorizontalFacing()).with(BOTTOM, false));
		}
	}
	
	@Override
	public void onBlockHarvested(World world, BlockPos pos, BlockState state, PlayerEntity player) {	     
		BlockPos other = state.get(BOTTOM) ? pos.up() : pos.down();	     
		BlockState otherState = world.getBlockState(other);	      
		if (otherState.getBlock() == this) {		      
			world.setBlockState(other, Blocks.AIR.getDefaultState(), 35);		      
		}		      
		super.onBlockHarvested(world, pos, state, player);
	}
	
	@Override
    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
		BlockPos other = state.get(BOTTOM) ? pos.up() : pos.down();	     
		BlockState otherState = world.getBlockState(other);	      
		if (otherState.getBlock() == this) {		      
			world.setBlockState(other, Blocks.AIR.getDefaultState(), 35);		      
		}		
		super.onBlockExploded(state, world, pos, explosion);
    }
	
	@Nullable
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		BlockPos pos = context.getPos();
		if (pos.getY() < 255 && context.getWorld().getBlockState(pos.up()).isReplaceable(context)) {
			return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing()).with(BOTTOM, true);
		}
		return null;
	}
	
	@Override
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		builder.add(FACING, BOTTOM);
	}
}
