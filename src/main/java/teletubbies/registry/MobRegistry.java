package teletubbies.registry;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import teletubbies.Teletubbies;
import teletubbies.configuration.ConfigurationHandler;
import teletubbies.entity.baby.EntityBa;
import teletubbies.entity.baby.EntityDaaDaa;
import teletubbies.entity.baby.EntityDuggleDee;
import teletubbies.entity.baby.EntityMiMi;
import teletubbies.entity.baby.EntityNin;
import teletubbies.entity.baby.EntityPing;
import teletubbies.entity.baby.EntityRuRu;
import teletubbies.entity.baby.EntityUmpiePumpie;
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
		//Teletubbies
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":TinkyWinky"), EntityTinkyWinky.class, "tinkywinky", 0, Teletubbies.MODID, 64, 3, true, 0x7E2CD3, 0xFFC9AD);
		EntityRegistry.addSpawn(EntityTinkyWinky.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
		
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":Dipsy"), EntityDipsy.class, "dipsy", 1, Teletubbies.MODID, 64, 3, true, 0x84CA32, 0xB38A4E);
		EntityRegistry.addSpawn(EntityDipsy.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));

		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":LaaLaa"), EntityLaaLaa.class, "laalaa", 2, Teletubbies.MODID, 64, 3, true, 0xDED32C, 0xFFC9AD);
		EntityRegistry.addSpawn(EntityLaaLaa.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));

		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":Po"), EntityPo.class, "po", 3, Teletubbies.MODID, 64, 3, true, 0xD62828, 0xFFC9AD);
		EntityRegistry.addSpawn(EntityPo.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));

		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":NooNoo"), EntityNooNoo.class, "noonoo", 4, Teletubbies.MODID, 64, 3, true, ConfigurationHandler.use2015 ? 0xFF7B00 : 0x0099FF, 0xE166CC);
		EntityRegistry.addSpawn(EntityNooNoo.class, 20, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));		
		
		//Zombie Teletubbies
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":ZombieTinkyWinky"), EntityZombieTinkyWinky.class, "zombietinkywinky", 5, Teletubbies.MODID, 64, 3, true, 0x7E2CD3, 0x660000);
		EntityRegistry.addSpawn(EntityZombieTinkyWinky.class, 25, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(1));

		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":ZombieDipsy"), EntityZombieDipsy.class, "zombiedipsy", 6, Teletubbies.MODID, 64, 3, true, 0x84CA32, 0x660000);
		EntityRegistry.addSpawn(EntityZombieDipsy.class, 25, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(1));

		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":ZombieLaaLaa"), EntityZombieLaaLaa.class, "zombielaalaa", 7, Teletubbies.MODID, 64, 3, true, 0xDED32C, 0x660000);
		EntityRegistry.addSpawn(EntityZombieLaaLaa.class, 25, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(1));

		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":ZombiePo"), EntityZombiePo.class, "zombiepo", 8, Teletubbies.MODID, 64, 3, true, 0xD62828, 0x660000);
		EntityRegistry.addSpawn(EntityZombiePo.class, 25, 1, 1, EnumCreatureType.MONSTER, Biome.getBiome(1));
		
		//Tiddlytubbies
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":MiMi"), EntityMiMi.class, "mimi", 9, Teletubbies.MODID, 64, 3, true, 0x1591B4, 0xC8946A);
		EntityRegistry.addSpawn(EntityMiMi.class, 10, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
		
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":DaaDaa"), EntityDaaDaa.class, "daadaa", 10, Teletubbies.MODID, 64, 3, true, 0x53AC09, 0xC8946A);
		EntityRegistry.addSpawn(EntityDaaDaa.class, 10, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
		
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":Ping"), EntityPing.class, "ping", 11, Teletubbies.MODID, 64, 3, true, 0xC6419E, 0xC8946A);
		EntityRegistry.addSpawn(EntityPing.class, 10, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
		
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":Ba"), EntityBa.class, "ba", 12, Teletubbies.MODID, 64, 3, true, 0x062C5E, 0xC8946A);
		EntityRegistry.addSpawn(EntityBa.class, 10, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
		
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":RuRu"), EntityRuRu.class, "ruru", 13, Teletubbies.MODID, 64, 3, true, 0xDA7123, 0xC8946A);
		EntityRegistry.addSpawn(EntityRuRu.class, 10, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
		
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":Nin"), EntityNin.class, "nin", 14, Teletubbies.MODID, 64, 3, true, 0x9F286E, 0xC8946A);
		EntityRegistry.addSpawn(EntityNin.class, 10, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
		
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":DuggleDee"), EntityDuggleDee.class, "duggledee", 15, Teletubbies.MODID, 64, 3, true, 0xB4213E, 0xC8946A);
		EntityRegistry.addSpawn(EntityDuggleDee.class, 10, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
		
		EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":UmpiePumpie"), EntityUmpiePumpie.class, "umpiepumpie", 16, Teletubbies.MODID, 64, 3, true, 0xD8BF29, 0xC8946A);
		EntityRegistry.addSpawn(EntityUmpiePumpie.class, 10, 1, 1, EnumCreatureType.CREATURE, Biome.getBiome(1));
	}
}
