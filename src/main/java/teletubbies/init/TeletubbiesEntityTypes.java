package teletubbies.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import teletubbies.Teletubbies;
import teletubbies.config.Config;
import teletubbies.entity.baby.BaEntity;
import teletubbies.entity.baby.DaaDaaEntity;
import teletubbies.entity.baby.DuggleDeeEntity;
import teletubbies.entity.baby.MiMiEntity;
import teletubbies.entity.baby.NinEntity;
import teletubbies.entity.baby.PingEntity;
import teletubbies.entity.baby.RuRuEntity;
import teletubbies.entity.baby.TiddlytubbyEntity;
import teletubbies.entity.baby.UmpiePumpieEntity;
import teletubbies.entity.monster.DipsyZombieEntity;
import teletubbies.entity.monster.LaaLaaZombieEntity;
import teletubbies.entity.monster.PoZombieEntity;
import teletubbies.entity.monster.TinkyWinkyZombieEntity;
import teletubbies.entity.passive.DipsyEntity;
import teletubbies.entity.passive.LaaLaaEntity;
import teletubbies.entity.passive.NooNooEntity;
import teletubbies.entity.passive.PoEntity;
import teletubbies.entity.passive.TeletubbyEntity;
import teletubbies.entity.passive.TinkyWinkyEntity;
import teletubbies.entity.vehicle.PoScooterEntity;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Teletubbies.MODID);

    // Entity Types    
    public static final RegistryObject<EntityType<TinkyWinkyEntity>> TINKYWINKY = ENTITY_TYPES.register("tinkywinky", () -> createEntity("tinkywinky", TinkyWinkyEntity::new, MobCategory.CREATURE, 0.6F, 1.9F));
    public static final RegistryObject<EntityType<DipsyEntity>> DIPSY = ENTITY_TYPES.register("dipsy", () -> createEntity("dipsy", DipsyEntity::new, MobCategory.CREATURE, 0.6F, 1.8F));
    public static final RegistryObject<EntityType<LaaLaaEntity>> LAALAA = ENTITY_TYPES.register("laalaa", () -> createEntity("laalaa", LaaLaaEntity::new, MobCategory.CREATURE, 0.6F, 1.7F));
    public static final RegistryObject<EntityType<PoEntity>> PO = ENTITY_TYPES.register("po", () -> createEntity("po", PoEntity::new, MobCategory.CREATURE, 0.6F, 1.6F));
    public static final RegistryObject<EntityType<NooNooEntity>> NOONOO = ENTITY_TYPES.register("noonoo", () -> createEntity("noonoo", NooNooEntity::new, MobCategory.CREATURE, 1.0F, 1.0F));
    public static final RegistryObject<EntityType<MiMiEntity>> MIMI = ENTITY_TYPES.register("mimi", () -> createEntity("mimi", MiMiEntity::new, MobCategory.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<DaaDaaEntity>> DAADAA = ENTITY_TYPES.register("daadaa", () -> createEntity("daadaa", DaaDaaEntity::new, MobCategory.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<PingEntity>> PING = ENTITY_TYPES.register("ping", () -> createEntity("ping", PingEntity::new, MobCategory.CREATURE, 0.5F, 0.8F));   
    public static final RegistryObject<EntityType<BaEntity>> BA = ENTITY_TYPES.register("ba", () -> createEntity("ba", BaEntity::new, MobCategory.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<RuRuEntity>> RURU = ENTITY_TYPES.register("ruru", () -> createEntity("ruru", RuRuEntity::new, MobCategory.CREATURE, 0.5F, 0.8F)); 
    public static final RegistryObject<EntityType<NinEntity>> NIN = ENTITY_TYPES.register("nin", () -> createEntity("nin", NinEntity::new, MobCategory.CREATURE, 0.5F, 0.8F));  
    public static final RegistryObject<EntityType<DuggleDeeEntity>> DUGGLEDEE = ENTITY_TYPES.register("duggledee", () -> createEntity("duggledee", DuggleDeeEntity::new, MobCategory.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<UmpiePumpieEntity>> UMPIEPUMPIE = ENTITY_TYPES.register("umpiepumpie", () -> createEntity("umpiepumpie", UmpiePumpieEntity::new, MobCategory.CREATURE, 0.5F, 0.8F));
    public static final RegistryObject<EntityType<TinkyWinkyZombieEntity>> TINKYWINKY_ZOMBIE = ENTITY_TYPES.register("tinkywinky_zombie", () -> createEntity("tinkywinky_zombie", TinkyWinkyZombieEntity::new, MobCategory.MONSTER, 0.6F, 1.9F));   
    public static final RegistryObject<EntityType<DipsyZombieEntity>> DIPSY_ZOMBIE = ENTITY_TYPES.register("dipsy_zombie", () -> createEntity("dipsy_zombie", DipsyZombieEntity::new, MobCategory.MONSTER, 0.6F, 1.8F));
    public static final RegistryObject<EntityType<LaaLaaZombieEntity>> LAALAA_ZOMBIE = ENTITY_TYPES.register("laalaa_zombie", () -> createEntity("laalaa_zombie", LaaLaaZombieEntity::new, MobCategory.MONSTER, 0.6F, 1.7F));
    public static final RegistryObject<EntityType<PoZombieEntity>> PO_ZOMBIE = ENTITY_TYPES.register("po_zombie", () -> createEntity("po_zombie", PoZombieEntity::new, MobCategory.MONSTER, 0.6F, 1.6F));
    
    public static final RegistryObject<EntityType<PoScooterEntity>> PO_SCOOTER = ENTITY_TYPES.register("po_scooter",
            () -> EntityType.Builder.<PoScooterEntity>of(PoScooterEntity::new, MobCategory.MISC)
                    .sized(1.15F, 0.3F)
                    .setCustomClientFactory((entity, world) -> new PoScooterEntity(world))
                    .build(new ResourceLocation(Teletubbies.MODID, "po_scooter").toString()));
    
    private static <T extends PathfinderMob> EntityType<T> createEntity(String name, EntityType.EntityFactory<T> factory, MobCategory category, float width, float height) {
        return EntityType.Builder.of(factory, category)
        		.sized(width, height)
        		.build(new ResourceLocation(Teletubbies.MODID, name).toString());
    }
	
	@SubscribeEvent
	public static void registerPlacement(final RegistryEvent.Register<EntityType<?>> event) {
		SpawnPlacements.register(TeletubbiesEntityTypes.TINKYWINKY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TeletubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.DIPSY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TeletubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.LAALAA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TeletubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.PO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TeletubbyEntity::canSpawn);		

		SpawnPlacements.register(TeletubbiesEntityTypes.NOONOO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, NooNooEntity::canSpawn);
		
		SpawnPlacements.register(TeletubbiesEntityTypes.MIMI.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.DAADAA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.PING.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.BA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.RURU.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.NIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.DUGGLEDEE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		SpawnPlacements.register(TeletubbiesEntityTypes.UMPIEPUMPIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TiddlytubbyEntity::canSpawn);
		
		SpawnPlacements.register(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
		SpawnPlacements.register(TeletubbiesEntityTypes.PO_ZOMBIE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMonsterSpawnRules);
	}
	
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void setAtributes(final EntityAttributeCreationEvent event) {
        event.put(TeletubbiesEntityTypes.TINKYWINKY.get(), TeletubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.DIPSY.get(), TeletubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.LAALAA.get(), TeletubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.PO.get(), TeletubbyEntity.setCustomAttributes().build());

        event.put(TeletubbiesEntityTypes.NOONOO.get(), NooNooEntity.setCustomAttributes().build());
        
        event.put(TeletubbiesEntityTypes.MIMI.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.DAADAA.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.PING.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.BA.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.RURU.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.NIN.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.DUGGLEDEE.get(), TiddlytubbyEntity.setCustomAttributes().build());
        event.put(TeletubbiesEntityTypes.UMPIEPUMPIE.get(), TiddlytubbyEntity.setCustomAttributes().build());

        event.put(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), Zombie.createAttributes().build());
        event.put(TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), Zombie.createAttributes().build());
        event.put(TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), Zombie.createAttributes().build());
        event.put(TeletubbiesEntityTypes.PO_ZOMBIE.get(), Zombie.createAttributes().build());
	}
	
	@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
	static class EntitySpawns {
		
		private static void registerWorldSpawns(BiomeLoadingEvent event, EntityType<?> entity, MobCategory classification, IntValue weight, BiomeCategory...categories) {		
			for (BiomeCategory category : categories) {
				if (event.getCategory() == category) {
					event.getSpawns().addSpawn(classification, new SpawnerData(entity, weight.get(), 1, 1));
				}
			}		
		}
		
		@SubscribeEvent
		public static void createEntitySpawns(BiomeLoadingEvent event) {		
			registerWorldSpawns(event, TeletubbiesEntityTypes.TINKYWINKY.get(), MobCategory.CREATURE, Config.COMMON.TINKYWINKY_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.DIPSY.get(), MobCategory.CREATURE, Config.COMMON.DIPSY_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.LAALAA.get(), MobCategory.CREATURE, Config.COMMON.LAALAA_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.PO.get(), MobCategory.CREATURE, Config.COMMON.PO_WEIGHT, BiomeCategory.PLAINS);
			
			registerWorldSpawns(event, TeletubbiesEntityTypes.NOONOO.get(), MobCategory.CREATURE, Config.COMMON.NOONOO_WEIGHT, BiomeCategory.PLAINS);
			
			registerWorldSpawns(event, TeletubbiesEntityTypes.MIMI.get(), MobCategory.CREATURE, Config.COMMON.MIMI_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.DAADAA.get(), MobCategory.CREATURE, Config.COMMON.DAADAA_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.PING.get(), MobCategory.CREATURE, Config.COMMON.PING_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.BA.get(), MobCategory.CREATURE, Config.COMMON.BA_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.RURU.get(), MobCategory.CREATURE, Config.COMMON.RURU_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.NIN.get(), MobCategory.CREATURE, Config.COMMON.NIN_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.DUGGLEDEE.get(), MobCategory.CREATURE, Config.COMMON.DUGGLEDEE_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.UMPIEPUMPIE.get(), MobCategory.CREATURE, Config.COMMON.UMPIEPUMPIE_WEIGHT, BiomeCategory.PLAINS);

			registerWorldSpawns(event, TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), MobCategory.MONSTER, Config.COMMON.TINKYWINKY_ZOMBIE_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), MobCategory.MONSTER, Config.COMMON.DIPSY_ZOMBIE_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), MobCategory.MONSTER, Config.COMMON.LAALAA_ZOMBIE_WEIGHT, BiomeCategory.PLAINS);
			registerWorldSpawns(event, TeletubbiesEntityTypes.PO_ZOMBIE.get(), MobCategory.MONSTER, Config.COMMON.PO_ZOMBIE_WEIGHT, BiomeCategory.PLAINS);
		}
	}
}
