package teletubbies.tileentity;

import java.util.Random;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import teletubbies.block.VoiceTrumpetBlock;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.init.TeletubbiesSounds;
import teletubbies.util.Converter;

public class VoiceTrumpetTileEntity extends TileEntity implements ITickableTileEntity {
	private long delay;
	private static Random rand = new Random();

	public VoiceTrumpetTileEntity() {
		super(TeletubbiesBlocks.VOICE_TRUMPET_TILE.get());
		delay = Converter.SecondsToTicks(rand.nextInt(30));
	}

	@Override
	public void tick() {
		if (--delay <= 0) {
			float pitch = ((VoiceTrumpetBlock) this.getBlockState().getBlock()).isUnderwater(world, this.pos) ? 0.5F : 1F;
			world.playSound(null, pos, SoundList.MACHINE_VOICE_TRUMPET, SoundCategory.BLOCKS, 2, pitch);
			delay = rand.nextInt((int) ((Converter.SecondsToTicks(30) - Converter.SecondsToTicks(15)) + 1)) + Converter.SecondsToTicks(15);
		}
	}
}
