package teletubbies.entity.baby;

import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityDaaDaa extends EntityTiddlytubby {

	public EntityDaaDaa(World world) {
		super(world);
	}
	
	@Override
    public SoundEvent getAmbientSound() {
		return Teletubbies.sound_DaaDaa_Living;
    }

	@Override
	public SoundEvent getHurtSound() {
		return Teletubbies.sound_DaaDaa_Living;
	}

	@Override
	public SoundEvent getDeathSound() {
		return Teletubbies.sound_DaaDaa_Living;
	}
}
