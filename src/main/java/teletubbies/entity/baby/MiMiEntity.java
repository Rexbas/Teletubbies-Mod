package teletubbies.entity.baby;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import teletubbies.client.audio.SoundList;

public class MiMiEntity extends TiddlytubbyEntity {

	public MiMiEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
	
	@Override
    public SoundEvent getAmbientSound() {
		return SoundList.mimi;
    }
}
