package com.rexbas.teletubbies.tileentity;

import java.util.Random;

import com.rexbas.teletubbies.block.VoiceTrumpetBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.init.TeletubbiesSounds;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;

public class VoiceTrumpetTileEntity extends TileEntity implements ITickableTileEntity {
	private long delay;
	private static Random rand = new Random();

	public VoiceTrumpetTileEntity() {
		super(TeletubbiesBlocks.VOICE_TRUMPET_TILE.get());
		delay = TeletubbiesBlocks.secondsToTicks(rand.nextInt(30));
	}

	@Override
	public void tick() {
		if (--delay <= 0) {
			float pitch = ((VoiceTrumpetBlock) this.getBlockState().getBlock()).isUnderwater(level, this.worldPosition) ? 0.5F : 1F;
			level.playSound(null, worldPosition, TeletubbiesSounds.MACHINE_VOICE_TRUMPET.get(), SoundCategory.BLOCKS, 2, pitch);
			delay = rand.nextInt((int) ((TeletubbiesBlocks.secondsToTicks(30) - TeletubbiesBlocks.secondsToTicks(15)) + 1)) + TeletubbiesBlocks.secondsToTicks(15);
		}
	}
}