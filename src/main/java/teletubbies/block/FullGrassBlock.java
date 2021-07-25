package teletubbies.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.MushroomBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SeaPickleBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.TallFlowerBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LayerLightEngine;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
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
	public BlockPathTypes getAiPathNodeType(BlockState state, BlockGetter world, BlockPos pos, @Nullable Mob entity) {
        return BlockPathTypes.BLOCKED;
    }
	
	@Override
	public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
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
	public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random rand) {
		this.tick(state, world, pos, rand);
	}
	
	@Override
	public void tick(BlockState state, ServerLevel worldIn, BlockPos pos, Random random) {
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
	
	private static boolean canBeGrass(BlockState p_220257_0_, LevelReader p_220257_1_, BlockPos p_220257_2_) {
		BlockPos blockpos = p_220257_2_.above();
		BlockState blockstate = p_220257_1_.getBlockState(blockpos);
		if (blockstate.getBlock() == Blocks.SNOW && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
			return true;
		} else {
			int i = LayerLightEngine.getLightBlockInto(p_220257_1_, p_220257_0_, p_220257_2_, blockstate, blockpos, Direction.UP,
					blockstate.getLightBlock(p_220257_1_, blockpos));
			return i < p_220257_1_.getMaxLightLevel();
		}
	}

	private static boolean canPropagate(BlockState p_220256_0_, LevelReader p_220256_1_, BlockPos p_220256_2_) {
		BlockPos blockpos = p_220256_2_.above();
		return canBeGrass(p_220256_0_, p_220256_1_, p_220256_2_) && !p_220256_1_.getFluidState(blockpos).is(FluidTags.WATER);
	}
}
