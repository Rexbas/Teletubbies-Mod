package teletubbies.world.gen.entity;

import java.util.HashMap;
import java.util.List;

import com.google.common.collect.ImmutableMap;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import teletubbies.Teletubbies;
import teletubbies.init.ModEntityTypes;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntitySpawns {
	
	@SafeVarargs
	private static void registerWorldSpawns(EntityType<?> entity, EntityClassification classification, IntValue weight, RegistryKey<Biome>...biomes) {		
		/*for (RegistryKey<Biome> b : biomes) {
			ForgeRegistries.BIOMES.getValue(b.getRegistryName()).func_242433_b().func_242559_a(classification).add(new Spawners(entity, weight.get(), 1, 1));
		}*/
		
		//MobSpawnInfo s = WorldGenRegistries.field_243657_i.getValueForKey(Biomes.PLAINS).func_242433_b();
	}
	
	/*private static void registerZombieWorldSpawns(EntityType<? extends ZombieEntity> entity, EntityClassification classification, IntValue weight, Biome...biomes) {
		//registerWorldSpawns(entity, classification, weight, biomes);
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
	}*/
	
	@SubscribeEvent
	public static void createEntitySpawns(FMLLoadCompleteEvent event) {
		System.out.println("Magic3");
		System.out.println(WorldGenRegistries.field_243657_i);
		for (Biome b : WorldGenRegistries.field_243657_i) {
			System.out.println("MAGIC");
			System.out.println(b.toString() + "   " + b.getRegistryName().toString());
			if (b.getCategory() == Category.PLAINS) {
				MobSpawnInfo s = b.func_242433_b();
				b.func_242433_b();
				List<Spawners> sd = MobSpawnInfo.field_242551_b.func_242559_a(EntityClassification.CREATURE);
				System.out.println(sd.size());
				System.out.println(ModEntityTypes.TINKYWINKY.get());
				Spawners spawner = new Spawners(ModEntityTypes.TINKYWINKY.get(), 1, 1, 1);
				sd.add(spawner);
			}
		}
		//MobSpawnInfo s = WorldGenRegistries.field_243657_i.getValueForKey(Biomes.PLAINS).func_242433_b();
		//registerWorldSpawns(ModEntityTypes.TINKYWINKY.get(), EntityClassification.CREATURE, EntityConfig.TINKYWINKY_WEIGHT, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		//registerWorldSpawns(ModEntityTypes.DIPSY.get(), EntityClassification.CREATURE, EntityConfig.DIPSY_WEIGHT, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		//registerWorldSpawns(ModEntityTypes.LAALAA.get(), EntityClassification.CREATURE, EntityConfig.LAALAA_WEIGHT, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		//registerWorldSpawns(ModEntityTypes.PO.get(), EntityClassification.CREATURE, EntityConfig.PO_WEIGHT, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
	}
}
