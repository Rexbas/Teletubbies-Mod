package com.rexbas.teletubbies.tileentity;

import java.util.Random;

<<<<<<<< HEAD:src/main/java/com/rexbas/teletubbies/tileentity/VoiceTrumpetBlockEntity.java
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import teletubbies.block.VoiceTrumpetBlock;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.init.TeletubbiesSounds;
import teletubbies.util.Converter;
========
import com.rexbas.teletubbies.block.VoiceTrumpetBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.init.TeletubbiesSounds;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/tileentity/VoiceTrumpetTileEntity.java

public class VoiceTrumpetBlockEntity extends BlockEntity {
	private long delay;
	private static Random rand = new Random();

<<<<<<<< HEAD:src/main/java/com/rexbas/teletubbies/tileentity/VoiceTrumpetBlockEntity.java
	public VoiceTrumpetBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.VOICE_TRUMPET_BLOCK_ENTITY.get(), pos, state);
		delay = Converter.SecondsToTicks(rand.nextInt(30));
========
	public VoiceTrumpetTileEntity() {
		super(TeletubbiesBlocks.VOICE_TRUMPET_TILE.get());
		delay = TeletubbiesBlocks.secondsToTicks(rand.nextInt(30));
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/tileentity/VoiceTrumpetTileEntity.java
	}

	public void serverTick() {
		if (--delay <= 0) {
			float pitch = ((VoiceTrumpetBlock) this.getBlockState().getBlock()).isUnderwater(level, this.worldPosition) ? 0.5F : 1F;
<<<<<<<< HEAD:src/main/java/com/rexbas/teletubbies/tileentity/VoiceTrumpetBlockEntity.java
			level.playSound(null, worldPosition, TeletubbiesSounds.MACHINE_VOICE_TRUMPET.get(), SoundSource.BLOCKS, 2, pitch);
			delay = rand.nextInt((int) ((Converter.SecondsToTicks(30) - Converter.SecondsToTicks(15)) + 1)) + Converter.SecondsToTicks(15);
========
			level.playSound(null, worldPosition, TeletubbiesSounds.MACHINE_VOICE_TRUMPET.get(), SoundCategory.BLOCKS, 2, pitch);
			delay = rand.nextInt((int) ((TeletubbiesBlocks.secondsToTicks(30) - TeletubbiesBlocks.secondsToTicks(15)) + 1)) + TeletubbiesBlocks.secondsToTicks(15);
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/tileentity/VoiceTrumpetTileEntity.java
		}
	}
}