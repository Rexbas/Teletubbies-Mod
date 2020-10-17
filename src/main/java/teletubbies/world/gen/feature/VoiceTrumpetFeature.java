package teletubbies.world.gen.feature;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import teletubbies.block.BlockList;
import teletubbies.block.VoiceTrumpetBlock;
import teletubbies.config.WorldGenConfig;

public class VoiceTrumpetFeature extends Feature<NoFeatureConfig> {

	public VoiceTrumpetFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}

	@Override
	public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		if (rand.nextInt(100) < WorldGenConfig.VOICE_TRUMPET_SPAWNRATE.get()) {
			BlockState blockstate = BlockList.VOICE_TRUMPET.getDefaultState();
			
			if (world.getBlockState(pos.down()).getBlock() instanceof GrassBlock && world.getBlockState(pos.up()).getBlock() instanceof AirBlock) {
				Direction facing = getRandomHorizontalDirection(rand);
				
				world.setBlockState(pos, blockstate.with(VoiceTrumpetBlock.FACING, facing).with(VoiceTrumpetBlock.BOTTOM, true), 0);
				world.setBlockState(pos.up(), blockstate.with(VoiceTrumpetBlock.FACING, facing).with(VoiceTrumpetBlock.BOTTOM, false), 0);
				return true;
			}	
		}
		return false;
	}
	
	private Direction getRandomHorizontalDirection(Random rand) {
		return Direction.values()[rand.nextInt(4) + 2];
	}
}