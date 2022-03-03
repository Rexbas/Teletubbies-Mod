package teletubbies.blockentity;

import java.util.Random;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import teletubbies.block.VoiceTrumpetBlock;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.init.TeletubbiesSounds;
import teletubbies.util.Converter;

public class VoiceTrumpetBlockEntity extends BlockEntity {
	private long delay;
	private static Random rand = new Random();

	public VoiceTrumpetBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.VOICE_TRUMPET_BLOCK_ENTITY.get(), pos, state);
		delay = Converter.SecondsToTicks(rand.nextInt(30));
	}

	public void serverTick() {
		if (--delay <= 0) {
			float pitch = ((VoiceTrumpetBlock) this.getBlockState().getBlock()).isUnderwater(level, this.worldPosition) ? 0.5F : 1F;
			level.playSound(null, worldPosition, TeletubbiesSounds.MACHINE_VOICE_TRUMPET.get(), SoundSource.BLOCKS, 2, pitch);
			delay = rand.nextInt((int) ((Converter.SecondsToTicks(30) - Converter.SecondsToTicks(15)) + 1)) + Converter.SecondsToTicks(15);
		}
	}
}
