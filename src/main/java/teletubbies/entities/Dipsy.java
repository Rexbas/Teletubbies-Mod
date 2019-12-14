package teletubbies.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import teletubbies.lists.EntityList;

public class Dipsy extends Teletubby {

	@SuppressWarnings("unchecked")
	public Dipsy(EntityType<? extends CreatureEntity> type, World world) {
		super((EntityType<? extends CreatureEntity>) EntityList.DIPSY, world);
	}
}
