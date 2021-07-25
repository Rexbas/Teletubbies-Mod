package teletubbies.tileentity;

import java.util.Random;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.TickableBlockEntity;
import teletubbies.block.VoiceTrumpetBlock;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.init.TeletubbiesSounds;
import teletubbies.util.Converter;

public class VoiceTrumpetTileEntity extends BlockEntity implements TickableBlockEntity {
	private long delay;
	private static Random rand = new Random();

	public VoiceTrumpetTileEntity() {
		super(TeletubbiesBlocks.VOICE_TRUMPET_TILE.get());
		delay = Converter.SecondsToTicks(rand.nextInt(30));
	}

	@Override
	public void tick() {
		if (--delay <= 0) {
			float pitch = ((VoiceTrumpetBlock) this.getBlockState().getBlock()).isUnderwater(level, this.worldPosition) ? 0.5F : 1F;
			level.playSound(null, worldPosition, TeletubbiesSounds.MACHINE_VOICE_TRUMPET.get(), SoundSource.BLOCKS, 2, pitch);
			delay = rand.nextInt((int) ((Converter.SecondsToTicks(30) - Converter.SecondsToTicks(15)) + 1)) + Converter.SecondsToTicks(15);
		}
	}
}
