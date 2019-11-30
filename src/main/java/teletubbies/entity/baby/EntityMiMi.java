package teletubbies.entity.baby;

import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityMiMi extends EntityTiddlytubby {

	public EntityMiMi(World world) {
		super(world);
	}
	
	@Override
    public SoundEvent getAmbientSound() {
		return Teletubbies.sound_MiMi_Living;
    }

	@Override
	public SoundEvent getHurtSound() {
		return Teletubbies.sound_MiMi_Living;
	}

	@Override
	public SoundEvent getDeathSound() {
		return Teletubbies.sound_MiMi_Living;
	}
}
