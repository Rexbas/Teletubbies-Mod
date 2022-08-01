package com.rexbas.teletubbies.block;

import java.util.Random;

import javax.annotation.Nullable;

import com.rexbas.teletubbies.config.Config;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LayerLightEngine;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;

public class FullGrassBlock extends GrassBlock {
	
	public FullGrassBlock() {
		super(Properties.copy(Blocks.GRASS_BLOCK));
	}
	
	@Override
    @Nullable
	public BlockPathTypes getAiPathNodeType(BlockState state, BlockGetter world, BlockPos pos, @Nullable Mob entity) {
        return BlockPathTypes.BLOCKED;
    }
	
	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
	    PlantType type = plantable.getPlantType(world, pos.relative(facing));
		
		if (PlantType.PLAINS.equals(type)) {
			return true;
		} else if (PlantType.BEACH.equals(type)) {
			boolean isBeach = true;
			boolean hasWater = false;
			for (Direction face : Direction.Plane.HORIZONTAL) {
				BlockState blockState = world.getBlockState(pos.relative(face));
				FluidState fluidState = world.getFluidState(pos.relative(face));
				hasWater |= blockState.is(Blocks.FROSTED_ICE);
				hasWater |= fluidState.is(FluidTags.WATER);
				if (hasWater)
					break; // No point continuing.
			}
			return isBeach && hasWater;
		}
		return false;
	}
	
	@Nullable
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolAction) {
		if (toolAction == ToolActions.SHOVEL_FLATTEN) return Blocks.DIRT_PATH.defaultBlockState();
        return null;
    }
		
	private static boolean canBeGrass(BlockState state, BlockGetter world, BlockPos pos) {
		BlockState aboveState = world.getBlockState(pos.above());
		if (aboveState.is(Blocks.SNOW) && aboveState.getValue(SnowLayerBlock.LAYERS) == 1) {
			return true;
		} else if (aboveState.getFluidState().getAmount() == 8) {
			return false;
		} else {
			BlockState northState = world.getBlockState(pos.north());
			BlockState eastState = world.getBlockState(pos.east());
			BlockState southState = world.getBlockState(pos.south());
			BlockState westState = world.getBlockState(pos.west());
			BlockState belowState = world.getBlockState(pos.below());
			
			int aboveLevel = LayerLightEngine.getLightBlockInto(world, state, pos, aboveState, pos.above(), Direction.UP, aboveState.getLightBlock(world, pos.above()));
			int northLevel = LayerLightEngine.getLightBlockInto(world, state, pos, northState, pos.north(), Direction.NORTH, northState.getLightBlock(world, pos.north()));
			int eastLevel = LayerLightEngine.getLightBlockInto(world, state, pos, eastState, pos.east(), Direction.EAST, eastState.getLightBlock(world, pos.east()));
			int southLevel = LayerLightEngine.getLightBlockInto(world, state, pos, southState, pos.south(), Direction.SOUTH, southState.getLightBlock(world, pos.south()));
			int westLevel = LayerLightEngine.getLightBlockInto(world, state, pos, westState, pos.west(), Direction.WEST, westState.getLightBlock(world, pos.west()));
			int belowLevel = LayerLightEngine.getLightBlockInto(world, state, pos, belowState, pos.below(), Direction.DOWN, belowState.getLightBlock(world, pos.below()));

			return aboveLevel < world.getMaxLightLevel() || northLevel < world.getMaxLightLevel() || eastLevel < world.getMaxLightLevel() ||
					southLevel < world.getMaxLightLevel() || westLevel < world.getMaxLightLevel() || belowLevel < world.getMaxLightLevel();
		}
	}

	private static boolean canPropagate(BlockState state, BlockGetter world, BlockPos pos) {
		return canBeGrass(state, world, pos) && !world.getFluidState(pos.above()).is(FluidTags.WATER);
	}
	
	@Override
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
		if (!canBeGrass(state, world, pos)) {
			if (!world.isAreaLoaded(pos, 3))
				return; // Forge: prevent loading unloaded chunks when checking neighbor's light and
						// spreading
			world.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
		} else {
			BlockState blockstate = this.defaultBlockState();

			for (int i = 0; i < 4; ++i) {
				BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(3) - 1, rand.nextInt(3) - 1);
				if (canPropagate(blockstate, world, blockpos)) {
					if (world.getBlockState(blockpos).is(Blocks.DIRT)) {
						world.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, Boolean.valueOf(world.getBlockState(blockpos.above()).is(Blocks.SNOW))));
					}
					else if (Config.COMMON.INVASIVE_GRASS.get() && world.getBlockState(blockpos).is(Blocks.GRASS_BLOCK)) {
						world.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, Boolean.valueOf(world.getBlockState(blockpos.above()).is(Blocks.SNOW))));
					}
				}
			}
		}
	}
}