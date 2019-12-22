package teletubbies.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public class PoEntity extends TeletubbyEntity {

	public PoEntity(EntityType<? extends CreatureEntity> type, World world) {
		super(type, world);
	}
}
