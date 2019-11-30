package teletubbies.sounds;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teletubbies.Teletubbies;
import teletubbies.vehicle.EntityPoScooter;

@SideOnly(Side.CLIENT)
public class MovingSoundPoScooter extends MovingSound {
	private final EntityPoScooter scooter;

	public MovingSoundPoScooter(EntityPoScooter scooter) {
		super(Teletubbies.sound_PoScooter, SoundCategory.NEUTRAL);
		this.scooter = scooter;
		this.repeat = true;
		this.repeatDelay = 0;
	}

	public void update() {
		if (this.scooter.isDead) {
			this.donePlaying = true;
		}
		else {
			this.xPosF = (float) this.scooter.posX;
			this.yPosF = (float) this.scooter.posY;
			this.zPosF = (float) this.scooter.posZ;			
			
			if((this.scooter.prevPosX != this.scooter.posX || this.scooter.prevPosZ != this.scooter.posZ) && this.scooter.isBeingRidden()) {
				this.volume = 1f;
			}
			else {
				this.volume = 0.0F;
			}
		}
	}
}