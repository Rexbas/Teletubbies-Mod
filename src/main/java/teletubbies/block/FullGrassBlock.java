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
	
	// Need to compare with GrassBlock
	@Override
	public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
		this.tick(state, world, pos, rand);
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		if (!worldIn.isClientSide) {
			if (!worldIn.isAreaLoaded(pos, 3)) return; 
			if (canBeGrass(state, worldIn, pos)) {
				if (worldIn.getMaxLocalRawBrightness(pos.above()) >= 9) {
					BlockState blockstate = this.defaultBlockState();

					for (int i = 0; i < 4; ++i) {
						BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
						if (worldIn.getBlockState(blockpos).getBlock() == Blocks.DIRT && canPropagate(blockstate, worldIn, blockpos)) {
							worldIn.setBlockAndUpdate(blockpos, blockstate);
						}
					}
				}
			}
		}
	}
	
	private static boolean canBeGrass(BlockState p_220257_0_, IWorldReader p_220257_1_, BlockPos p_220257_2_) {
		BlockPos blockpos = p_220257_2_.above();
		BlockState blockstate = p_220257_1_.getBlockState(blockpos);
		if (blockstate.getBlock() == Blocks.SNOW && blockstate.getValue(SnowBlock.LAYERS) == 1) {
			return true;
		} else {
			int i = LightEngine.getLightBlockInto(p_220257_1_, p_220257_0_, p_220257_2_, blockstate, blockpos, Direction.UP,
					blockstate.getLightBlock(p_220257_1_, blockpos));
			return i < p_220257_1_.getMaxLightLevel();
		}
	}

	private static boolean canPropagate(BlockState p_220256_0_, IWorldReader p_220256_1_, BlockPos p_220256_2_) {
		BlockPos blockpos = p_220256_2_.above();
		return canBeGrass(p_220256_0_, p_220256_1_, p_220256_2_) && !p_220256_1_.getFluidState(blockpos).is(FluidTags.WATER);
	}
}
