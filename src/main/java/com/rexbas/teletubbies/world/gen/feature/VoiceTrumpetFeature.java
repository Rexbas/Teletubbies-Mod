package com.rexbas.teletubbies.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.rexbas.teletubbies.block.VoiceTrumpetBlock;
import com.rexbas.teletubbies.config.Config;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;

import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.GrassBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class VoiceTrumpetFeature extends Feature<NoFeatureConfig> {

	public VoiceTrumpetFeature(Codec<NoFeatureConfig> codec) {
		super(codec);
	}

	@Override
	public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
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