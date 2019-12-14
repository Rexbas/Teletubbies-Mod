package teletubbies.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class Teletubby extends CreatureEntity {

	protected Teletubby(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}

}
