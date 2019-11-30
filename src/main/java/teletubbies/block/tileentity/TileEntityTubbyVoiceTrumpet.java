package teletubbies.block.tileentity;

import java.util.Random;

import net.minecraft.util.ITickable;
import net.minecraft.util.SoundCategory;
import teletubbies.Teletubbies;

public class TileEntityTubbyVoiceTrumpet extends TubbyTileEntity implements ITickable {
	
	private int delay;
	
	public TileEntityTubbyVoiceTrumpet() {
		super();
		this.delay = new Random().nextInt((600 - 450) + 1) + 450;
	}

	@Override
	public void update() {
		if(this.isMaster()) {
			delay--;

			if(delay <= 0) {
				this.world.playSound(null, this.pos, Teletubbies.sound_TubbyVoiceTrumpet, SoundCategory.NEUTRAL, 1, 1);
				this.delay = new Random().nextInt((600 - 450) + 1) + 450;
			}
		}
	}
}
