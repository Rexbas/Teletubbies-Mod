package com.rexbas.teletubbies.init;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.config.Config;
import com.rexbas.teletubbies.worldgen.feature.TeletubbiesConfiguredFeatures;
import com.rexbas.teletubbies.worldgen.feature.VoiceTrumpetFeature;
import com.rexbas.teletubbies.worldgen.feature.structure.DomePieces;
import com.rexbas.teletubbies.worldgen.feature.structure.DomeStructure;
import com.rexbas.teletubbies.worldgen.feature.structure.TeletubbiesConfiguredStructures;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.StructurePieceType;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesWorldGen {
	// Features
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Teletubbies.MODID);

	public static final RegistryObject<Feature<NoneFeatureConfiguration>> VOICE_TRUMPET_FEATURE = FEATURES.register("voice_trumpet", () -> new VoiceTrumpetFeature(NoneFeatureConfiguration.CODEC));
	
	// Structures --------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Teletubbies.MODID);
		
	public static final RegistryObject<StructureFeature<NoneFeatureConfiguration>> DOME_STRUCTURE = STRUCTURES.register("dome", () -> new DomeStructure(NoneFeatureConfiguration.CODEC));
	public static final StructurePieceType DOME_PIECE = DomePieces.Piece::new;
	
	// https://github.com/TelepathicGrunt/StructureTutorialMod/blob/c919931014ba7515981f2516892489953e718f56/src/main/java/com/telepathicgrunt/structuretutorial/STStructures.java
	public static <F extends StructureFeature<?>> void registerStructure(F structure, StructureFeatureConfiguration separation, boolean transformSurroundingLand) {
        StructureFeature.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);
        
        if (transformSurroundingLand) {
            StructureFeature.NOISE_AFFECTING_FEATURES =
                    ImmutableList.<StructureFeature<?>>builder()
                    .addAll(StructureFeature.NOISE_AFFECTING_FEATURES)
                    .add(structure)
                    .build();
        }

        StructureSettings.DEFAULTS =
                ImmutableMap.<StructureFeature<?>, StructureFeatureConfiguration>builder()
                        .putAll(StructureSettings.DEFAULTS)
                        .put(structure, separation)
                        .build();
    }
	
	static void registerStructurePiece(StructurePieceType piece, ResourceLocation resourceLocation) {
        Registry.register(Registry.STRUCTURE_PIECE, resourceLocation, piece);
    }
	
	@SubscribeEvent
	public static void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TeletubbiesConfiguredFeatures.registerConfiguredFeatures();
			registerStructure(DOME_STRUCTURE.get(), new StructureFeatureConfiguration(Config.COMMON.DOME_MAX_CHUNKS.get(), Config.COMMON.DOME_MIN_CHUNKS.get(), 8351309), false);
	    	registerStructurePiece(DOME_PIECE, new ResourceLocation(Teletubbies.MODID, "dome_piece"));
	    	TeletubbiesConfiguredStructures.registerConfiguredStructures();
		});
	}
	
	@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
	static class Events {
    	@SubscribeEvent
        public static void biomeLoading(final BiomeLoadingEvent event) {
    		if (event.getCategory() == BiomeCategory.PLAINS) {
    			if (Config.COMMON.VOICE_TRUMPET_CHANCE.get() != 0)
    				event.getGeneration().addFeature(Decoration.LOCAL_MODIFICATIONS, TeletubbiesConfiguredFeatures.VOICE_TRUMPET_CONFIGURED_FEATURE);
    			
    			event.getGeneration().addStructureStart(TeletubbiesConfiguredStructures.DOME_CONFIGURED_STRUCTURE);
    		}
        }
    	
		@SubscribeEvent(priority = EventPriority.HIGH)
		public static void addDimensionalSpacing(final WorldEvent.Load event) {
			if (event.getWorld() instanceof ServerLevel) {
				ServerLevel serverWorld = (ServerLevel) event.getWorld();

				if (serverWorld.getChunkSource().getGenerator() instanceof FlatLevelSource
						&& serverWorld.dimension().equals(Level.OVERWORLD)) {
					return;
				}

				Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
				tempMap.put(DOME_STRUCTURE.get(), StructureSettings.DEFAULTS.get(DOME_STRUCTURE.get()));
				serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
			}
		}
	}
}
