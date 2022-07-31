package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.config.Config;
import com.rexbas.teletubbies.entity.PoScooterEntity;
import com.rexbas.teletubbies.entity.baby.TiddlytubbyEntity;
import com.rexbas.teletubbies.entity.monster.DipsyZombieEntity;
import com.rexbas.teletubbies.entity.monster.LaaLaaZombieEntity;
import com.rexbas.teletubbies.entity.monster.PoZombieEntity;
import com.rexbas.teletubbies.entity.monster.TinkyWinkyZombieEntity;
import com.rexbas.teletubbies.entity.passive.DipsyEntity;
import com.rexbas.teletubbies.entity.passive.LaaLaaEntity;
import com.rexbas.teletubbies.entity.passive.NooNooEntity;
import com.rexbas.teletubbies.entity.passive.PoEntity;
import com.rexbas.teletubbies.entity.passive.TeletubbyEntity;
import com.rexbas.teletubbies.entity.passive.TinkyWinkyEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityType.IFactory;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Teletubbies.MODID);

    // Entity Types    
    public static final RegistryObject<EntityType<TinkyWinkyEntity>> TINKYWINKY = ENTITY_TYPES.register("tinkywinky", () -> createEntity("tinkywinky", TinkyWinkyEntity::new, EntityClassification.CREATURE, 0.6F, 1.9F));
    public static final RegistryObject<EntityType<DipsyEntity>> DIPSY = ENTITY_TYPES.register("dipsy", () -> createEntity("dipsy", DipsyEntity::new, EntityClassification.CREATURE, 0.6F, 1.8F));
    public static final RegistryObject<EntityType<LaaLaaEntity>> LAALAA = ENTITY_TYPES.register("laalaa", () -> createEntity("laalaa", LaaLaaEntity::new, EntityClassification.CREATURE, 0.6F, 1.7F));
    public static final RegistryObject<EntityType<PoEntity>> PO = ENTITY_TYPES.register("po", () -> createEntity("po", PoEntity::new, EntityClassification.CREATURE, 0.6F, 1.6F));
    public static final RegistryObject<EntityType<NooNooEntity>> NOONOO = ENTITY_TYPES.register("noonoo", () -> createEntity("noonoo", NooNooEntity::new, EntityClassification.CREATURE, 1.0F, 1.0F));
    public static final RegistryObject<EntityType<TiddlytubbyEntity>> MIMI = ENTITY_TYPES.register("mimi", () -> createEntity("mimi", TiddlytubbyEntity::new, EntityClassification.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<TiddlytubbyEntity>> DAADAA = ENTITY_TYPES.register("daadaa", () -> createEntity("daadaa", TiddlytubbyEntity::new, EntityClassification.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<TiddlytubbyEntity>> PING = ENTITY_TYPES.register("ping", () -> createEntity("ping", TiddlytubbyEntity::new, EntityClassification.CREATURE, 0.5F, 0.8F));   
    public static final RegistryObject<EntityType<TiddlytubbyEntity>> BA = ENTITY_TYPES.register("ba", () -> createEntity("ba", TiddlytubbyEntity::new, EntityClassification.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<TiddlytubbyEntity>> RURU = ENTITY_TYPES.register("ruru", () -> createEntity("ruru", TiddlytubbyEntity::new, EntityClassification.CREATURE, 0.5F, 0.8F)); 
    public static final RegistryObject<EntityType<TiddlytubbyEntity>> NIN = ENTITY_TYPES.register("nin", () -> createEntity("nin", TiddlytubbyEntity::new, EntityClassification.CREATURE, 0.5F, 0.8F));  
    public static final RegistryObject<EntityType<TiddlytubbyEntity>> DUGGLEDEE = ENTITY_TYPES.register("duggledee", () -> createEntity("duggledee", TiddlytubbyEntity::new, EntityClassification.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<TiddlytubbyEntity>> UMPIEPUMPIE = ENTITY_TYPES.register("umpiepumpie", () -> createEntity("umpiepumpie", TiddlytubbyEntity::new, EntityClassification.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<TinkyWinkyZombieEntity>> TINKYWINKY_ZOMBIE = ENTITY_TYPES.register("tinkywinky_zombie", () -> createEntity("tinkywinky_zombie", TinkyWinkyZombieEntity::new, EntityClassification.MONSTER, 0.6F, 1.9F));   
    public static final RegistryObject<EntityType<DipsyZombieEntity>> DIPSY_ZOMBIE = ENTITY_TYPES.register("dipsy_zombie", () -> createEntity("dipsy_zombie", DipsyZombieEntity::new, EntityClassification.MONSTER, 0.6F, 1.8F));
    public static final RegistryObject<EntityType<LaaLaaZombieEntity>> LAALAA_ZOMBIE = ENTITY_TYPES.register("laalaa_zombie", () -> createEntity("laalaa_zombie", LaaLaaZombieEntity::new, EntityClassification.MONSTER, 0.6F, 1.7F));
    public static final RegistryObject<EntityType<PoZombieEntity>> PO_ZOMBIE = ENTITY_TYPES.register("po_zombie", () -> createEntity("po_zombie", PoZombieEntity::new, EntityClassification.MONSTER, 0.6F, 1.6F));
    
    public static final RegistryObject<EntityType<PoScooterEntity>> PO_SCOOTER = ENTITY_TYPES.register("po_scooter",
            () -> EntityType.Builder.<PoScooterEntity>of(PoScooterEntity::new, EntityClassification.MISC)
                    .sized(1.15F, 0.3F)
                    .setCustomClientFactory((entity, world) -> new PoScooterEntity(world))
                    .build(new ResourceLocation(Teletubbies.MODID, "po_scooter").toString()));
    
    private static <T extends MobEntity> EntityType<T> createEntity(String name, IFactory<T> factory, EntityClassification category, float width, float height) {
    	return EntityType.Builder.of(factory, category)
        		.sized(width, height)
        		.build(new ResourceLocation(Teletubbies.MODID, name).toString());
    }
	
	@SubscribeEvent
	public static void registerPlacement(final RegistryEvent.Register<EntityType<?>> event) {
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.TINKYWINKY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TeletubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.DIPSY.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TeletubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.LAALAA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TeletubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.PO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TeletubbyEntity::canSpawn);

		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.NOONOO.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, NooNooEntity::canSpawn);		

		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.MIMI.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.DAADAA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.PING.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.BA.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.RURU.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.NIN.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.DUGGLEDEE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.UMPIEPUMPIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
		EntitySpawnPlacementRegistry.register(TeletubbiesEntityTypes.PO_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::checkMonsterSpawnRules);
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void setAtributes(final EntityAttributeCreationEvent event) {		
        event.put(TeletubbiesEntityTypes.TINKYWINKY.get(), NooNooEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.DIPSY.get(), NooNooEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.LAALAA.get(), NooNooEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.PO.get(), NooNooEntity.setCustomAttributes().build());

        event.put(TeletubbiesEntityTypes.NOONOO.get(), NooNooEntity.setCustomAttributes().build());
        
        event.put(TeletubbiesEntityTypes.MIMI.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.DAADAA.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.PING.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.BA.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.RURU.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.NIN.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.DUGGLEDEE.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.UMPIEPUMPIE.get(), TiddlytubbyEntity.setCustomAttributes().build());

        event.put(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), ZombieEntity.createAttributes().build());
        event.put(TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), ZombieEntity.createAttributes().build());
        event.put(TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), ZombieEntity.createAttributes().build());
        event.put(TeletubbiesEntityTypes.PO_ZOMBIE.get(), ZombieEntity.createAttributes().build());
	}
	
	@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
	static class EntitySpawns {
		
		private static void registerWorldSpawns(BiomeLoadingEvent event, EntityType<?> entity, EntityClassification classification, IntValue weight, Category...categories) {		
			for (Category category : categories) {
				if (event.getCategory() == category) {
					event.getSpawns().addSpawn(classification, new Spawners(entity, weight.get(), 1, 1));
				}
			}		
		}
		
		@SubscribeEvent
		public static void createEntitySpawns(BiomeLoadingEvent event) {		
			registerWorldSpawns(event, TeletubbiesEntityTypes.TINKYWINKY.get(), EntityClassification.CREATURE, Config.COMMON.TINKYWINKY_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.DIPSY.get(), EntityClassification.CREATURE, Config.COMMON.DIPSY_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.LAALAA.get(), EntityClassification.CREATURE, Config.COMMON.LAALAA_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.PO.get(), EntityClassification.CREATURE, Config.COMMON.PO_WEIGHT, Category.PLAINS);
			
			registerWorldSpawns(event, TeletubbiesEntityTypes.NOONOO.get(), EntityClassification.CREATURE, Config.COMMON.NOONOO_WEIGHT, Category.PLAINS);
			
			registerWorldSpawns(event, TeletubbiesEntityTypes.MIMI.get(), EntityClassification.CREATURE, Config.COMMON.MIMI_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.DAADAA.get(), EntityClassification.CREATURE, Config.COMMON.DAADAA_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.PING.get(), EntityClassification.CREATURE, Config.COMMON.PING_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.BA.get(), EntityClassification.CREATURE, Config.COMMON.BA_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.RURU.get(), EntityClassification.CREATURE, Config.COMMON.RURU_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.NIN.get(), EntityClassification.CREATURE, Config.COMMON.NIN_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.DUGGLEDEE.get(), EntityClassification.CREATURE, Config.COMMON.DUGGLEDEE_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.UMPIEPUMPIE.get(), EntityClassification.CREATURE, Config.COMMON.UMPIEPUMPIE_WEIGHT, Category.PLAINS);

			registerWorldSpawns(event, TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), EntityClassification.MONSTER, Config.COMMON.TINKYWINKY_ZOMBIE_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), EntityClassification.MONSTER, Config.COMMON.DIPSY_ZOMBIE_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), EntityClassification.MONSTER, Config.COMMON.LAALAA_ZOMBIE_WEIGHT, Category.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.PO_ZOMBIE.get(), EntityClassification.MONSTER, Config.COMMON.PO_ZOMBIE_WEIGHT, Category.PLAINS);
		}
	}
}
