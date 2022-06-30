package teletubbies.client.audio;

import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.vehicle.PoScooterEntity;
import teletubbies.init.TeletubbiesSounds;

@OnlyIn(Dist.CLIENT)
public class PoScooterTickableSound extends AbstractTickableSoundInstance {
	private final PoScooterEntity scooter;

	public PoScooterTickableSound(PoScooterEntity scooter, RandomSource random) {
		super(TeletubbiesSounds.ENTITY_SCOOTER.get(), SoundSource.NEUTRAL, random);
		this.scooter = scooter;
		looping = true;
		delay = 0;
		volume = Float.MIN_VALUE;
	}

	@Override
	public void tick() {
		if (!scooter.isAlive()) {
			this.stop();
			looping = true;
		}
		else {
			x = (float) scooter.getX();
			y = (float) scooter.getY();
			z = (float) scooter.getZ();
			if(((float)scooter.xo != x || (float)scooter.zo != z) && scooter.isVehicle()) {
				volume = 1.0F;
			}
			else {
				volume = 0.0F;
			}
		}		
	}
}