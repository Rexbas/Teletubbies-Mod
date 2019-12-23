package teletubbies.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.entity.item.PoScooterEntity;
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
	
	public static final EntityType<?> PO_SCOOTER = EntityType.Builder.create(PoScooterEntity::new, EntityClassification.MISC).size(1.15F, 0.3F).setCustomClientFactory((entity, world) -> new PoScooterEntity(world)).build(Teletubbies.MODID + ":po_scooter").setRegistryName(Teletubbies.MODID, "po_scooter");
	
	@SubscribeEvent
	public static void registerEntityEvent(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(
				TINKYWINKY, DIPSY, LAALAA, PO,
				PO_SCOOTER
		);
		
		registerWorldSpawns(TINKYWINKY, EntityClassification.CREATURE, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(DIPSY, EntityClassification.CREATURE, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(LAALAA, EntityClassification.CREATURE, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		registerWorldSpawns(PO, EntityClassification.CREATURE, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);

	}

	private static void registerWorldSpawns(EntityType<?> entity, EntityClassification classification, Biome...biomes) {
		for (Biome b : biomes) {
			b.getSpawns(classification).add(new SpawnListEntry(entity, 100, 1, 1));
		}
	}
}
