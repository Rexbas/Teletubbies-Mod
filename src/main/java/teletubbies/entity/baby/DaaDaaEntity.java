package teletubbies.entity.baby;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import teletubbies.init.TeletubbiesSounds;

public class DaaDaaEntity extends TiddlytubbyEntity {

	public DaaDaaEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
	
	@Override
    public SoundEvent getAmbientSound() {
		return TeletubbiesSounds.ENTITY_DAADAA_VOICE.get();
    }
}
