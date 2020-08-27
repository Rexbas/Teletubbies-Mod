package teletubbies.client.audio;

import net.minecraft.client.audio.TickableSound;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.item.PoScooterEntity;

@OnlyIn(Dist.CLIENT)
public class PoScooterTickableSound extends TickableSound {
	private final PoScooterEntity scooter;

	public PoScooterTickableSound(PoScooterEntity scooter) {
		super(SoundList.ENTITY_SCOOTER, SoundCategory.NEUTRAL);
		this.scooter = scooter;
		repeat = true;
		repeatDelay = 0;
		volume = Float.MIN_VALUE;
	}

	@Override
	public void tick() {
		if (!scooter.isAlive()) {
			this.finishPlaying();
			repeat = true;
		}
		else {
			x = (float) scooter.getPosX();
			y = (float) scooter.getPosY();
			z = (float) scooter.getPosZ();
			if(((float)scooter.prevPosX != x || (float)scooter.prevPosZ != z) && scooter.isBeingRidden()) {
				volume = 1.0F;
			}
			else {
				volume = 0.0F;
			}
		}		
	}
}