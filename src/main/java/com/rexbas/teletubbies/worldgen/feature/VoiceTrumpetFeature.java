<<<<<<<< HEAD:src/main/java/teletubbies/worldgen/feature/VoiceTrumpetFeature.java
package teletubbies.worldgen.feature;
========
package com.rexbas.teletubbies.worldgen.feature;
>>>>>>>> origin/1.17:src/main/java/com/rexbas/teletubbies/worldgen/feature/VoiceTrumpetFeature.java

import java.util.Random;

import com.mojang.serialization.Codec;
import com.rexbas.teletubbies.block.VoiceTrumpetBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class VoiceTrumpetFeature extends Feature<NoneFeatureConfiguration> {

	public VoiceTrumpetFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> ctx) {
		int x = ctx.random().nextInt(16);
		int z = ctx.random().nextInt(16);
		BlockPos pos = ctx.level().getHeightmapPos(Heightmap.Types.WORLD_SURFACE, new BlockPos(ctx.origin().getX() + x, 0, ctx.origin().getZ() + z));
		BlockState blockstate = TeletubbiesBlocks.VOICE_TRUMPET.get().defaultBlockState();
		
		if (ctx.level().getBlockState(pos.below()).getBlock() instanceof GrassBlock && ctx.level().getBlockState(pos.above()).getBlock() instanceof AirBlock) {
			Direction facing = getRandomHorizontalDirection(ctx.random());
			
			ctx.level().setBlock(pos, blockstate.setValue(VoiceTrumpetBlock.FACING, facing).setValue(VoiceTrumpetBlock.BOTTOM, true), 0);
			ctx.level().setBlock(pos.above(), blockstate.setValue(VoiceTrumpetBlock.FACING, facing).setValue(VoiceTrumpetBlock.BOTTOM, false), 0);
			return true;
		}	
		return false;
	}
	
	private Direction getRandomHorizontalDirection(Random rand) {
		return Direction.values()[rand.nextInt(4) + 2];
	}
}