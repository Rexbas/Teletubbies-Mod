package com.rexbas.teletubbies.worldgen.feature;

import com.rexbas.teletubbies.block.VoiceTrumpetBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;

import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class VoiceTrumpetFeature extends Feature<NoneFeatureConfiguration> {

	// For JSON files:
	// https://misode.github.io/worldgen/
	
	public VoiceTrumpetFeature() {
		super(NoneFeatureConfiguration.CODEC);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
		BlockState blockstate = TeletubbiesBlocks.VOICE_TRUMPET.get().defaultBlockState();
		Direction facing = getRandomHorizontalDirection(ctx.random());
		
		ctx.level().setBlock(ctx.origin(), blockstate.setValue(VoiceTrumpetBlock.FACING, facing).setValue(VoiceTrumpetBlock.BOTTOM, true), 0);
		ctx.level().setBlock(ctx.origin().above(), blockstate.setValue(VoiceTrumpetBlock.FACING, facing).setValue(VoiceTrumpetBlock.BOTTOM, false), 0);
		return true;
	}
	
	private Direction getRandomHorizontalDirection(RandomSource random) {
		return Direction.values()[random.nextInt(4) + 2];
	}
}