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
		this.repeat = true;
		this.repeatDelay = 0;
	}

	@Override
	public void tick() {
		if (this.scooter.removed) {
			this.donePlaying = true;
		}
		else {
			this.x = (float) this.scooter.posX;
			this.y = (float) this.scooter.posY;
			this.z = (float) this.scooter.posZ;			
			
			if((this.scooter.prevPosX != this.scooter.posX || this.scooter.prevPosZ != this.scooter.posZ) && this.scooter.isBeingRidden()) {
				this.volume = 1f;
			}
			else {
				this.volume = 0.0F;
			}
		}		
	}
}