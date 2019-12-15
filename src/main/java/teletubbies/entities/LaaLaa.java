package teletubbies.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;
import teletubbies.lists.EntityList;

public class LaaLaa extends Teletubby {

	@SuppressWarnings("unchecked")
	public LaaLaa(EntityType<? extends CreatureEntity> type, World world) {
		super((EntityType<? extends CreatureEntity>) EntityList.LAALAA, world);
	}
}
