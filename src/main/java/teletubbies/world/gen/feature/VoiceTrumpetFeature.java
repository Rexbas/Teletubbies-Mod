package teletubbies.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import teletubbies.block.VoiceTrumpetBlock;
import teletubbies.config.Config;
import teletubbies.init.TeletubbiesBlocks;

public class VoiceTrumpetFeature extends Feature<NoneFeatureConfiguration> {

	public VoiceTrumpetFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
		if (rand.nextInt(100) < Config.COMMON.VOICE_TRUMPET_SPAWNRATE.get()) {
			BlockState blockstate = TeletubbiesBlocks.VOICE_TRUMPET.get().defaultBlockState();
			
			if (world.getBlockState(pos.below()).getBlock() instanceof GrassBlock && world.getBlockState(pos.above()).getBlock() instanceof AirBlock) {
				Direction facing = getRandomHorizontalDirection(rand);
				
				world.setBlock(pos, blockstate.setValue(VoiceTrumpetBlock.FACING, facing).setValue(VoiceTrumpetBlock.BOTTOM, true), 0);
				world.setBlock(pos.above(), blockstate.setValue(VoiceTrumpetBlock.FACING, facing).setValue(VoiceTrumpetBlock.BOTTOM, false), 0);
				return true;
			}	
		}
		return false;
	}
	
	private Direction getRandomHorizontalDirection(Random rand) {
		return Direction.values()[rand.nextInt(4) + 2];
	}
}