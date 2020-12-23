package teletubbies.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import teletubbies.block.VoiceTrumpetBlock;
import teletubbies.config.Config;
import teletubbies.init.TeletubbiesBlocks;

public class VoiceTrumpetFeature extends Feature<NoFeatureConfig> {

	public VoiceTrumpetFeature(Codec<NoFeatureConfig> codec) {
		super(codec);
	}

	@Override
	public boolean generate(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		if (rand.nextInt(100) < WorldGenConfig.VOICE_TRUMPET_SPAWNRATE.get()) {
			BlockState blockstate = TeletubbiesBlocks.VOICE_TRUMPET.get().getDefaultState();
			
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