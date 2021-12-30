package teletubbies.init;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import teletubbies.Teletubbies;
import teletubbies.config.Config;
import teletubbies.worldgen.structure.DomeStructure;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesStructures {

	public static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Teletubbies.MODID);

    public static final RegistryObject<StructureFeature<JigsawConfiguration>> DOME_STRUCTURE_FEATURE = STRUCTURES.register("dome", () -> (new DomeStructure(JigsawConfiguration.CODEC)));

    // https://github.com/TelepathicGrunt/StructureTutorialMod/blob/1.18.x-Forge-Jigsaw/src/main/java/com/telepathicgrunt/structuretutorial/STStructures.java
    public static void setupStructures() {
		setupMapSpacingAndLand(DOME_STRUCTURE_FEATURE.get(), new StructureFeatureConfiguration(
				Config.COMMON.DOME_MAX_CHUNKS.get(), Config.COMMON.DOME_MIN_CHUNKS.get(), 8351309), true);
    }

	public static <F extends StructureFeature<?>> void setupMapSpacingAndLand(F structure,
			StructureFeatureConfiguration structureFeatureConfiguration, boolean transformSurroundingLand) {

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
                        .put(structure, structureFeatureConfiguration)
                        .build();

        BuiltinRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
            Map<StructureFeature<?>, StructureFeatureConfiguration> structureMap = settings.getValue().structureSettings().structureConfig();

            if (structureMap instanceof ImmutableMap) {
                Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(structureMap);
                tempMap.put(structure, structureFeatureConfiguration);
                settings.getValue().structureSettings().structureConfig = tempMap;
            }
            else {
                structureMap.put(structure, structureFeatureConfiguration);
            }
        });
    }
    
    @Mod.EventBusSubscriber(modid = Teletubbies.MODID)
	private static class ForgeBusEvents {
		
    	// https://github.com/TelepathicGrunt/StructureTutorialMod/blob/1.18.x-Forge-Jigsaw/src/main/java/com/telepathicgrunt/structuretutorial/StructureTutorialMain.java
        private static Method GETCODEC_METHOD;
    	@SubscribeEvent(priority = EventPriority.HIGH)
    	public static void addDimensionalSpacing(final WorldEvent.Load event) {
    		if (event.getWorld() instanceof ServerLevel serverLevel) {

                ChunkGenerator chunkGenerator = serverLevel.getChunkSource().getGenerator();
                if (chunkGenerator instanceof FlatLevelSource && serverLevel.dimension().equals(Level.OVERWORLD)) {
                    return;
                }
                StructureSettings worldStructureConfig = chunkGenerator.getSettings();

                // Create a mutable map we will use for easier adding to biomes
                HashMap<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> structureToMultiMap = new HashMap<>();

                // Add the resourcekey of all biomes that this Configured Structure can spawn in.
                for (Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : serverLevel.registryAccess().ownedRegistryOrThrow(Registry.BIOME_REGISTRY).entrySet()) {
                    // Only Plains biomes
                    Biome.BiomeCategory biomeCategory = biomeEntry.getValue().getBiomeCategory();
                    if(biomeCategory == Biome.BiomeCategory.PLAINS) {
                        associateBiomeToConfiguredStructure(structureToMultiMap, TeletubbiesConfiguredStructures.DOME_CONFIGURED_STRUCTURE, biomeEntry.getKey());
                    }
                }

                // Grab the map that holds what ConfigureStructures a structure has and what biomes it can spawn in.
                // Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
                ImmutableMap.Builder<StructureFeature<?>, ImmutableMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> tempStructureToMultiMap = ImmutableMap.builder();
                worldStructureConfig.configuredStructures.entrySet().stream().filter(entry -> !structureToMultiMap.containsKey(entry.getKey())).forEach(tempStructureToMultiMap::put);

                // Add our structures to the structure map/multimap and set the world to use this combined map/multimap.
                structureToMultiMap.forEach((key, value) -> tempStructureToMultiMap.put(key, ImmutableMultimap.copyOf(value)));

                // Requires AccessTransformer  (see resources/META-INF/accesstransformer.cfg)
                worldStructureConfig.configuredStructures = tempStructureToMultiMap.build();

                Map<StructureFeature<?>, StructureFeatureConfiguration> tempMap = new HashMap<>(worldStructureConfig.structureConfig());
                tempMap.putIfAbsent(TeletubbiesStructures.DOME_STRUCTURE_FEATURE.get(), StructureSettings.DEFAULTS.get(TeletubbiesStructures.DOME_STRUCTURE_FEATURE.get()));
                worldStructureConfig.structureConfig = tempMap;
    		}
    	}
    	
        private static void associateBiomeToConfiguredStructure(Map<StructureFeature<?>, HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>>> STStructureToMultiMap, ConfiguredStructureFeature<?, ?> configuredStructureFeature, ResourceKey<Biome> biomeRegistryKey) {
            STStructureToMultiMap.putIfAbsent(configuredStructureFeature.feature, HashMultimap.create());
            HashMultimap<ConfiguredStructureFeature<?, ?>, ResourceKey<Biome>> configuredStructureToBiomeMultiMap = STStructureToMultiMap.get(configuredStructureFeature.feature);
            if(!configuredStructureToBiomeMultiMap.containsValue(biomeRegistryKey)) {
            	configuredStructureToBiomeMultiMap.put(configuredStructureFeature, biomeRegistryKey);
            }
        }
	}
}
