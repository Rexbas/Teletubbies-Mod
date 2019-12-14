package teletubbies.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import teletubbies.lists.EntityList;

public class TinkyWinky extends CreatureEntity {

	@SuppressWarnings("unchecked")
	public TinkyWinky(EntityType<? extends CreatureEntity> type, World world) {
		super((EntityType<? extends CreatureEntity>) EntityList.TINKYWINKY, world);
	}
}
