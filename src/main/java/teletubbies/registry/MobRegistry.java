package teletubbies.registry;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import teletubbies.Teletubbies;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;
import teletubbies.entity.passive.EntityDipsy;
import teletubbies.entity.passive.EntityLaaLaa;
import teletubbies.entity.passive.EntityNooNoo;
import teletubbies.entity.passive.EntityPo;
import teletubbies.entity.passive.EntityTinkyWinky;

public class MobRegistry {

	public static void registerMobs() {
		EntityRegistry.registerModEntity(EntityTinkyWinky.class, "TinkyWinky", 0, Teletubbies.MODID, 64, 3, true, 0x9900FF, 0xCC99FF);
		EntityRegistry.addSpawn(EntityTinkyWinky.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
		
		EntityRegistry.registerModEntity(EntityDipsy.class, "Dipsy", 1, Teletubbies.MODID, 64, 3, true, 0x00FF00, 0xCCFFCC);
		EntityRegistry.addSpawn(EntityDipsy.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));

		EntityRegistry.registerModEntity(EntityLaaLaa.class, "LaaLaa", 2, Teletubbies.MODID, 64, 3, true, 0xFFFF00, 0xFFFFCC);
		EntityRegistry.addSpawn(EntityLaaLaa.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));

		EntityRegistry.registerModEntity(EntityPo.class, "Po", 3, Teletubbies.MODID, 64, 3, true, 0xFF0000, 0xFFCCCC);
		EntityRegistry.addSpawn(EntityPo.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));

		EntityRegistry.registerModEntity(EntityNooNoo.class, "NooNoo", 4, Teletubbies.MODID, 64, 3, true, 0x0099FF, 0xE166CC);
		EntityRegistry.addSpawn(EntityNooNoo.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));

		EntityRegistry.registerModEntity(EntityZombieTinkyWinky.class, "ZombieTinkyWinky", 5, Teletubbies.MODID, 64, 3, true, 0x9900FF, 0x660000);
		EntityRegistry.addSpawn(EntityZombieTinkyWinky.class, 25, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(1));

		EntityRegistry.registerModEntity(EntityZombieDipsy.class, "ZombieDipsy", 6, Teletubbies.MODID, 64, 3, true, 0x00FF00, 0x660000);
		EntityRegistry.addSpawn(EntityZombieDipsy.class, 25, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(1));

		EntityRegistry.registerModEntity(EntityZombieLaaLaa.class, "ZombieLaaLaa", 7, Teletubbies.MODID, 64, 3, true, 0xFFFF00, 0x660000);
		EntityRegistry.addSpawn(EntityZombieLaaLaa.class, 25, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(1));

		EntityRegistry.registerModEntity(EntityZombiePo.class, "ZombiePo", 8, Teletubbies.MODID, 64, 3, true, 0xFF0000, 0x660000);
		EntityRegistry.addSpawn(EntityZombiePo.class, 25, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(1));
	}
}
