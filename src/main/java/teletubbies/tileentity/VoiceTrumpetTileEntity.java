package teletubbies.tileentity;

import java.util.Random;

import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import teletubbies.block.BlockList;
import teletubbies.client.audio.SoundList;
import teletubbies.util.Converter;

public class VoiceTrumpetTileEntity extends TileEntity implements ITickableTileEntity {
	private long delay;
	private static Random rand = new Random();

	public VoiceTrumpetTileEntity() {
		super(BlockList.VOICE_TRUMPET_TILE);
		delay = Converter.SecondsToTicks(rand.nextInt(20));
	}

	@Override
	public void tick() {
		if (--delay <= 0) {
			world.playSound(null, pos, SoundList.voiceTrumpet, SoundCategory.AMBIENT, 1, 1);
			delay = rand.nextInt((int) ((Converter.SecondsToTicks(20) - Converter.SecondsToTicks(10)) + 1)) + Converter.SecondsToTicks(10);
		}
	}
}
