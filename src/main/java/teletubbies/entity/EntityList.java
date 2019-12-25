package teletubbies.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
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
import teletubbies.entity.passive.PoEntity;
import teletubbies.entity.passive.TinkyWinkyEntity;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityList {
	public static final EntityType<?> TINKYWINKY = EntityType.Builder.create(TinkyWinkyEntity::new, EntityClassification.CREATURE).size(0.6F, 2.0F).build(Teletubbies.MODID + ":tinkywinky").setRegistryName(Teletubbies.MODID, "tinkywinky");
	public static final EntityType<?> DIPSY = EntityType.Builder.create(DipsyEntity::new, EntityClassification.CREATURE).size(0.6F, 1.9F).build(Teletubbies.MODID + ":dipsy").setRegistryName(Teletubbies.MODID, "dipsy");
	public static final EntityType<?> LAALAA = EntityType.Builder.create(LaaLaaEntity::new, EntityClassification.CREATURE).size(0.6F, 1.8F).build(Teletubbies.MODID + ":laalaa").setRegistryName(Teletubbies.MODID, "laalaa");	
	public static final EntityType<?> PO = EntityType.Builder.create(PoEntity::new, EntityClassification.CREATURE).size(0.6F, 1.7F).build(Teletubbies.MODID + ":po").setRegistryName(Teletubbies.MODID, "po");

	public static final EntityType<?> MIMI = createTiddlytubby(MiMiEntity::new, "mimi");
	public static final EntityType<?> DAADAA = createTiddlytubby(DaaDaaEntity::new, "daadaa");
	public static final EntityType<?> PING = createTiddlytubby(PingEntity::new, "ping");
	public static final EntityType<?> BA = createTiddlytubby(BaEntity::new, "ba");
	public static final EntityType<?> RURU = createTiddlytubby(RuRuEntity::new, "ruru");
	public static final EntityType<?> NIN = createTiddlytubby(NinEntity::new, "nin");
	public static final EntityType<?> DUGGLEDEE = createTiddlytubby(DuggleDeeEntity::new, "duggledee");
	public static final EntityType<?> UMPIEPUMPIE = createTiddlytubby(UmpiePumpieEntity::new, "umpiepumpie");

	public static final EntityType<TinkyWinkyZombieEntity> TINKYWINKY_ZOMBIE = (EntityType<TinkyWinkyZombieEntity>) EntityType.Builder.create(TinkyWinkyZombieEntity::new, EntityClassification.MONSTER).size(0.6F, 2.0F).build(Teletubbies.MODID + ":tinkywinky_zombie").setRegistryName(Teletubbies.MODID, "tinkywinky_zombie");
	public static final EntityType<DipsyZombieEntity> DIPSY_ZOMBIE = (EntityType<DipsyZombieEntity>) EntityType.Builder.create(DipsyZombieEntity::new, EntityClassification.MONSTER).size(0.6F, 1.9F).build(Teletubbies.MODID + ":dipsy_zombie").setRegistryName(Teletubbies.MODID, "dipsy_zombie");
	public static final EntityType<LaaLaaZombieEntity> LAALAA_ZOMBIE = (EntityType<LaaLaaZombieEntity>) EntityType.Builder.create(LaaLaaZombieEntity::new, EntityClassification.MONSTER).size(0.6F, 1.8F).build(Teletubbies.MODID + ":laalaa_zombie").setRegistryName(Teletubbies.MODID, "laalaa_zombie");
	public static final EntityType<PoZombieEntity> PO_ZOMBIE = (EntityType<PoZombieEntity>) EntityType.Builder.create(PoZombieEntity::new, EntityClassification.MONSTER).size(0.6F, 1.7F).build(Teletubbies.MODID + ":po_zombie").setRegistryName(Teletubbies.MODID, "po_zombie");

	public static final EntityType<?> PO_SCOOTER = EntityType.Builder.create(PoScooterEntity::new, EntityClassification.MISC).size(1.15F, 0.3F).setCustomClientFactory((entity, world) -> new PoScooterEntity(world)).build(Teletubbies.MODID + ":po_scooter").setRegistryName(Teletubbies.MODID, "po_scooter");
	
	@SubscribeEvent
	public static void registerEntityEvent(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(
				TINKYWINKY, DIPSY, LAALAA, PO,
				MIMI, DAADAA, PING, BA, RURU, NIN, DUGGLEDEE, UMPIEPUMPIE,
				TINKYWINKY_ZOMBIE, DIPSY_ZOMBIE, LAALAA_ZOMBIE, PO_ZOMBIE,
				PO_SCOOTER
		);
		
		registerWorldSpawns(TINKYWINKY, EntityClassification.CREATURE, 20, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(DIPSY, EntityClassification.CREATURE, 20, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(LAALAA, EntityClassification.CREATURE, 20, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(PO, EntityClassification.CREATURE, 20, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		
		registerWorldSpawns(MIMI, EntityClassification.CREATURE, 5, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(DAADAA, EntityClassification.CREATURE, 5, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(PING, EntityClassification.CREATURE, 5, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(BA, EntityClassification.CREATURE, 5, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(RURU, EntityClassification.CREATURE, 5, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(NIN, EntityClassification.CREATURE, 5, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(DUGGLEDEE, EntityClassification.CREATURE, 5, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(UMPIEPUMPIE, EntityClassification.CREATURE, 5, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);

		registerZombieWorldSpawns(TINKYWINKY_ZOMBIE, EntityClassification.MONSTER, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerZombieWorldSpawns(DIPSY_ZOMBIE, EntityClassification.MONSTER, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerZombieWorldSpawns(LAALAA_ZOMBIE, EntityClassification.MONSTER, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerZombieWorldSpawns(PO_ZOMBIE, EntityClassification.MONSTER, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
	}
	
	private static <T extends TiddlytubbyEntity> EntityType<?> createTiddlytubby(EntityType.IFactory<T> factory, String name) {
		return EntityType.Builder.create(factory, EntityClassification.CREATURE).size(0.5F, 0.8F).build(Teletubbies.MODID + ":" + name).setRegistryName(Teletubbies.MODID, name);
	}

	private static void registerWorldSpawns(EntityType<?> entity, EntityClassification classification, int weight, Biome...biomes) {
		for (Biome b : biomes) {
			b.getSpawns(classification).add(new SpawnListEntry(entity, weight, 1, 1));
		}
	}
	
	private static void registerZombieWorldSpawns(EntityType<? extends ZombieEntity> entity, EntityClassification classification, Biome...biomes) {
		registerWorldSpawns(entity, classification, 100, biomes);
		EntitySpawnPlacementRegistry.register(entity, EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::func_223325_c);
	}
}
