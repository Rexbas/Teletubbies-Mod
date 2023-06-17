package com.rexbas.teletubbies.block.entity;

import java.util.Random;

import com.rexbas.teletubbies.block.VoiceTrumpetBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.init.TeletubbiesSounds;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VoiceTrumpetBlockEntity extends BlockEntity {
	private long delay;
	private static final Random rand = new Random();

	public VoiceTrumpetBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.VOICE_TRUMPET_BLOCK_ENTITY.get(), pos, state);
		delay = TeletubbiesBlocks.secondsToTicks(rand.nextInt(30));
	}

	public void serverTick() {
		if (--delay <= 0) {
			float pitch = ((VoiceTrumpetBlock) this.getBlockState().getBlock()).isUnderwater(level, this.worldPosition) ? 0.5F : 1F;
			level.playSound(null, worldPosition, TeletubbiesSounds.MACHINE_VOICE_TRUMPET.get(), SoundSource.BLOCKS, 2, pitch);
			delay = rand.nextInt((int) ((TeletubbiesBlocks.secondsToTicks(30) - TeletubbiesBlocks.secondsToTicks(15)) + 1)) + TeletubbiesBlocks.secondsToTicks(15);
		}
	}
}