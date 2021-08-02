package teletubbies.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.MushroomBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.MobEntity;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.lighting.LightEngine;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;

public class FullGrassBlock extends GrassBlock {
	
	public FullGrassBlock() {
		super(Properties.of(Material.GRASS)
				.randomTicks()
				.strength(0.6F)
				.sound(SoundType.GRASS));
	}
	
	@Override
    @Nullable
	public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, @Nullable MobEntity entity) {
        return PathNodeType.BLOCKED;
    }
	
	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
		if (plantable instanceof TallFlowerBlock ||
				plantable instanceof FlowerBlock ||
				plantable instanceof MushroomBlock ||
				plantable instanceof SaplingBlock ||
				plantable instanceof SeaPickleBlock ||
				plantable instanceof SweetBerryBushBlock ||
				plantable instanceof TallGrassBlock) {
			return true;
		}
		return false;
	}
	
	private static boolean canBeGrass(BlockState state, IWorldReader world, BlockPos pos) {
		BlockState aboveState = world.getBlockState(pos.above());
		if (aboveState.is(Blocks.SNOW) && aboveState.getValue(SnowBlock.LAYERS) == 1) {
			return true;
		} else if (aboveState.getFluidState().getAmount() == 8) {
			return false;
		} else {
			BlockState northState = world.getBlockState(pos.north());
			BlockState eastState = world.getBlockState(pos.east());
			BlockState southState = world.getBlockState(pos.south());
			BlockState westState = world.getBlockState(pos.west());
			BlockState belowState = world.getBlockState(pos.below());
			
			int aboveLevel = LightEngine.getLightBlockInto(world, state, pos, aboveState, pos.above(), Direction.UP, aboveState.getLightBlock(world, pos.above()));
			int northLevel = LightEngine.getLightBlockInto(world, state, pos, northState, pos.north(), Direction.NORTH, northState.getLightBlock(world, pos.north()));
			int eastLevel = LightEngine.getLightBlockInto(world, state, pos, eastState, pos.east(), Direction.EAST, eastState.getLightBlock(world, pos.east()));
			int southLevel = LightEngine.getLightBlockInto(world, state, pos, southState, pos.south(), Direction.SOUTH, southState.getLightBlock(world, pos.south()));
			int westLevel = LightEngine.getLightBlockInto(world, state, pos, westState, pos.west(), Direction.WEST, westState.getLightBlock(world, pos.west()));
			int belowLevel = LightEngine.getLightBlockInto(world, state, pos, belowState, pos.below(), Direction.DOWN, belowState.getLightBlock(world, pos.below()));

			return aboveLevel < world.getMaxLightLevel() || northLevel < world.getMaxLightLevel() || eastLevel < world.getMaxLightLevel() ||
					southLevel < world.getMaxLightLevel() || westLevel < world.getMaxLightLevel() || belowLevel < world.getMaxLightLevel();
		}
	}

	private static boolean canPropagate(BlockState state, IWorldReader world, BlockPos pos) {
		return canBeGrass(state, world, pos) && !world.getFluidState(pos.above()).is(FluidTags.WATER);
	}
	
	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		if (!canBeGrass(state, world, pos)) {
			if (!world.isAreaLoaded(pos, 3))
				return; // Forge: prevent loading unloaded chunks when checking neighbor's light and
						// spreading
			world.setBlockAndUpdate(pos, Blocks.DIRT.defaultBlockState());
		} else {
			BlockState blockstate = this.defaultBlockState();

			for (int i = 0; i < 4; ++i) {
				BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
				if (world.getBlockState(blockpos).is(Blocks.DIRT) && canPropagate(blockstate, world, blockpos)) {
					world.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, Boolean.valueOf(world.getBlockState(blockpos.above()).is(Blocks.SNOW))));
				}
			}
		}
	}
}
