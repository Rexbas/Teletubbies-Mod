package teletubbies.init;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
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
import teletubbies.entity.item.PoScooterEntity;
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
import teletubbies.item.ModSpawnEggItem;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, Teletubbies.MODID);

    // Entity Types
    public static final RegistryObject<EntityType<TinkyWinkyEntity>> TINKYWINKY = ENTITY_TYPES.register("tinkywinky",
            () -> EntityType.Builder.of(TinkyWinkyEntity::new, EntityClassification.CREATURE)
                    .sized(0.6F, 1.9F)
                    .build(new ResourceLocation(Teletubbies.MODID, "tinkywinky").toString()));

    public static final RegistryObject<EntityType<DipsyEntity>> DIPSY = ENTITY_TYPES.register("dipsy",
            () -> EntityType.Builder.of(DipsyEntity::new, EntityClassification.CREATURE)
                    .sized(0.6F, 1.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "dipsy").toString()));
    
    public static final RegistryObject<EntityType<LaaLaaEntity>> LAALAA = ENTITY_TYPES.register("laalaa",
            () -> EntityType.Builder.of(LaaLaaEntity::new, EntityClassification.CREATURE)
                    .sized(0.6F, 1.7F)
                    .build(new ResourceLocation(Teletubbies.MODID, "laalaa").toString()));
    
    public static final RegistryObject<EntityType<PoEntity>> PO = ENTITY_TYPES.register("po",
            () -> EntityType.Builder.of(PoEntity::new, EntityClassification.CREATURE)
                    .sized(0.6F, 1.6F)
                    .build(new ResourceLocation(Teletubbies.MODID, "po").toString()));
    
    public static final RegistryObject<EntityType<NooNooEntity>> NOONOO = ENTITY_TYPES.register("noonoo",
            () -> EntityType.Builder.of(NooNooEntity::new, EntityClassification.CREATURE)
                    .sized(1.0F, 1.0F)
                    .build(new ResourceLocation(Teletubbies.MODID, "noonoo").toString()));
    
    public static final RegistryObject<EntityType<MiMiEntity>> MIMI = ENTITY_TYPES.register("mimi",
            () -> EntityType.Builder.of(MiMiEntity::new, EntityClassification.CREATURE)
                    .sized(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "mimi").toString()));
    
    public static final RegistryObject<EntityType<DaaDaaEntity>> DAADAA = ENTITY_TYPES.register("daadaa",
            () -> EntityType.Builder.of(DaaDaaEntity::new, EntityClassification.CREATURE)
                    .sized(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "daadaa").toString()));
    
    public static final RegistryObject<EntityType<PingEntity>> PING = ENTITY_TYPES.register("ping",
            () -> EntityType.Builder.of(PingEntity::new, EntityClassification.CREATURE)
                    .sized(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "ping").toString()));
    
    public static final RegistryObject<EntityType<BaEntity>> BA = ENTITY_TYPES.register("ba",
            () -> EntityType.Builder.of(BaEntity::new, EntityClassification.CREATURE)
                    .sized(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "ba").toString()));
    
    public static final RegistryObject<EntityType<RuRuEntity>> RURU = ENTITY_TYPES.register("ruru",
            () -> EntityType.Builder.of(RuRuEntity::new, EntityClassification.CREATURE)
                    .sized(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "ruru").toString()));
    
    public static final RegistryObject<EntityType<NinEntity>> NIN = ENTITY_TYPES.register("nin",
            () -> EntityType.Builder.of(NinEntity::new, EntityClassification.CREATURE)
                    .sized(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "nin").toString()));
    
    public static final RegistryObject<EntityType<DuggleDeeEntity>> DUGGLEDEE = ENTITY_TYPES.register("duggledee",
            () -> EntityType.Builder.of(DuggleDeeEntity::new, EntityClassification.CREATURE)
                    .sized(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "duggledee").toString()));
    
    public static final RegistryObject<EntityType<UmpiePumpieEntity>> UMPIEPUMPIE = ENTITY_TYPES.register("umpiepumpie",
            () -> EntityType.Builder.of(UmpiePumpieEntity::new, EntityClassification.CREATURE)
                    .sized(0.5F, 0.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "umpiepumpie").toString()));
    
    public static final RegistryObject<EntityType<TinkyWinkyZombieEntity>> TINKYWINKY_ZOMBIE = ENTITY_TYPES.register("tinkywinky_zombie",
            () -> EntityType.Builder.of(TinkyWinkyZombieEntity::new, EntityClassification.MONSTER)
                    .sized(0.6F, 1.9F)
                    .build(new ResourceLocation(Teletubbies.MODID, "tinkywinky_zombie").toString()));
    
    public static final RegistryObject<EntityType<DipsyZombieEntity>> DIPSY_ZOMBIE = ENTITY_TYPES.register("dipsy_zombie",
            () -> EntityType.Builder.of(DipsyZombieEntity::new, EntityClassification.MONSTER)
                    .sized(0.6F, 1.8F)
                    .build(new ResourceLocation(Teletubbies.MODID, "dipsy_zombie").toString()));
    
    public static final RegistryObject<EntityType<LaaLaaZombieEntity>> LAALAA_ZOMBIE = ENTITY_TYPES.register("laalaa_zombie",
            () -> EntityType.Builder.of(LaaLaaZombieEntity::new, EntityClassification.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(new ResourceLocation(Teletubbies.MODID, "laalaa_zombie").toString()));
    
    public static final RegistryObject<EntityType<PoZombieEntity>> PO_ZOMBIE = ENTITY_TYPES.register("po_zombie",
            () -> EntityType.Builder.of(PoZombieEntity::new, EntityClassification.MONSTER)
                    .sized(0.6F, 1.6F)
                    .build(new ResourceLocation(Teletubbies.MODID, "po_zombie").toString()));
    
    public static final RegistryObject<EntityType<PoScooterEntity>> PO_SCOOTER = ENTITY_TYPES.register("po_scooter",
            () -> EntityType.Builder.<PoScooterEntity>of(PoScooterEntity::new, EntityClassification.MISC)
                    .sized(1.15F, 0.3F)
                    .setCustomClientFactory((entity, world) -> new PoScooterEntity(world))
                    .build(new ResourceLocation(Teletubbies.MODID, "po_scooter").toString()));
	
	@SubscribeEvent
	public static void registerSpawnEggAndPlacement(final RegistryEvent.Register<EntityType<?>> event) {
		ModSpawnEggItem.initSpawnEggs();
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
	public static void setAtributes(final RegistryEvent.Register<EntityType<?>> event) {
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.TINKYWINKY.get(), CreatureEntity.createMobAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.DIPSY.get(), CreatureEntity.createMobAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.LAALAA.get(), CreatureEntity.createMobAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.PO.get(), CreatureEntity.createMobAttributes().build());

        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.NOONOO.get(), NooNooEntity.setCustomAttributes().build());
        
    	GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.MIMI.get(), TiddlytubbyEntity.setCustomAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.DAADAA.get(), TiddlytubbyEntity.setCustomAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.PING.get(), TiddlytubbyEntity.setCustomAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.BA.get(), TiddlytubbyEntity.setCustomAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.RURU.get(), TiddlytubbyEntity.setCustomAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.NIN.get(), TiddlytubbyEntity.setCustomAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.DUGGLEDEE.get(), TiddlytubbyEntity.setCustomAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.UMPIEPUMPIE.get(), TiddlytubbyEntity.setCustomAttributes().build());
       
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), ZombieEntity.createAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), ZombieEntity.createAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), ZombieEntity.createAttributes().build());
        GlobalEntityTypeAttributes.put(TeletubbiesEntityTypes.PO_ZOMBIE.get(), ZombieEntity.createAttributes().build());
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
