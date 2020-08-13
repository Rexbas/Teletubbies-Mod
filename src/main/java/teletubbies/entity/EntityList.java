package teletubbies.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.entity.baby.TiddlytubbyEntity;
import teletubbies.entity.passive.NooNooEntity;
import teletubbies.init.ModEntityTypes;
import teletubbies.item.ModSpawnEggItem;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityList {
	

	private static void registerWorldSpawns(EntityType<?> entity, EntityClassification classification, IntValue weight, Biome...biomes) {
		for (Biome b : biomes) {
			b.func_242433_b().func_242559_a(classification).add(new Spawners(entity, weight.get(), 1, 1));
		}
	}
	
	private static void registerZombieWorldSpawns(EntityType<? extends ZombieEntity> entity, EntityClassification classification, IntValue weight, Biome...biomes) {
		registerWorldSpawns(entity, classification, weight, biomes);
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawnInLight);
	}
	

}
