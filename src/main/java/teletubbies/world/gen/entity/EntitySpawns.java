package teletubbies.world.gen.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.biome.MobSpawnInfo.Spawners;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.config.EntityConfig;
import teletubbies.init.ModEntityTypes;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
public class EntitySpawns {
	
	private static void registerWorldSpawns(BiomeLoadingEvent event, EntityType<?> entity, EntityClassification classification, IntValue weight, Category...categories) {		
		for (Category category : categories) {
			if (event.getCategory() == category) {
				event.getSpawns().withSpawner(classification, new Spawners(entity, weight.get(), 1, 1));
			}
		}		
	}
	
	@SubscribeEvent
	public static void createEntitySpawns(BiomeLoadingEvent event) {		
		registerWorldSpawns(event, ModEntityTypes.TINKYWINKY.get(), EntityClassification.CREATURE, EntityConfig.TINKYWINKY_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.DIPSY.get(), EntityClassification.CREATURE, EntityConfig.DIPSY_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.LAALAA.get(), EntityClassification.CREATURE, EntityConfig.LAALAA_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.PO.get(), EntityClassification.CREATURE, EntityConfig.PO_WEIGHT, Category.PLAINS);
		
		registerWorldSpawns(event, ModEntityTypes.NOONOO.get(), EntityClassification.CREATURE, EntityConfig.NOONOO_WEIGHT, Category.PLAINS);
		
		registerWorldSpawns(event, ModEntityTypes.MIMI.get(), EntityClassification.CREATURE, EntityConfig.MIMI_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.DAADAA.get(), EntityClassification.CREATURE, EntityConfig.DAADAA_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.PING.get(), EntityClassification.CREATURE, EntityConfig.PING_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.BA.get(), EntityClassification.CREATURE, EntityConfig.BA_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.RURU.get(), EntityClassification.CREATURE, EntityConfig.RURU_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.NIN.get(), EntityClassification.CREATURE, EntityConfig.NIN_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.DUGGLEDEE.get(), EntityClassification.CREATURE, EntityConfig.DUGGLEDEE_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.UMPIEPUMPIE.get(), EntityClassification.CREATURE, EntityConfig.UMPIEPUMPIE_WEIGHT, Category.PLAINS);

		registerWorldSpawns(event, ModEntityTypes.TINKYWINKY_ZOMBIE.get(), EntityClassification.MONSTER, EntityConfig.TINKYWINKY_ZOMBIE_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.DIPSY_ZOMBIE.get(), EntityClassification.MONSTER, EntityConfig.DIPSY_ZOMBIE_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.LAALAA_ZOMBIE.get(), EntityClassification.MONSTER, EntityConfig.LAALAA_ZOMBIE_WEIGHT, Category.PLAINS);
		registerWorldSpawns(event, ModEntityTypes.PO_ZOMBIE.get(), EntityClassification.MONSTER, EntityConfig.PO_ZOMBIE_WEIGHT, Category.PLAINS);
	}
}
