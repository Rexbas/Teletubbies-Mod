package teletubbies.init;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import teletubbies.Teletubbies;
import teletubbies.config.WorldGenConfig;
import teletubbies.util.RegisterHelper;
import teletubbies.world.gen.feature.VoiceTrumpetFeature;
import teletubbies.world.gen.feature.structure.DomePieces;
import teletubbies.world.gen.feature.structure.DomeStructure;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModWorldGen {
	// Features
	public static final Feature<NoFeatureConfig> VOICE_TRUMPET_FEATURE = new VoiceTrumpetFeature(NoFeatureConfig.field_236558_a_);
	
	@SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
    	IForgeRegistry<Feature<?>> featureRegistry = event.getRegistry();
    	registerFeature(featureRegistry, VOICE_TRUMPET_FEATURE, new ResourceLocation(Teletubbies.MODID, "voice_trumpet"));
    }
	
    // https://github.com/TelepathicGrunt/RepurposedStructures/blob/1.16/src/main/java/com/telepathicgrunt/repurposedstructures/RSFeatures.java
    public static <F extends Feature<?>> void registerFeature(IForgeRegistry<Feature<?>> registry, F feature, ResourceLocation resourceLocation) {
        feature.setRegistryName(resourceLocation);
        registry.register(feature);

        // Have to do this as Minecraft will otherwise think the feature isn't registered.
        // Hopefully this means people can make custom ConfiguredFeatures by datapack with the feature.
        Registry.register(Registry.FEATURE, resourceLocation, feature);
    }
    	
	public static final ConfiguredFeature<?, ?> VOICE_TRUMPET_CONFIGURED_FEATURE = VOICE_TRUMPET_FEATURE
			.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
			.withPlacement(Placement.field_242906_k.configure(new NoPlacementConfig()));
	
	
	public static void registerConfiguredFeatures() {	
		Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
		Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "voice_trumpet_configured_feature"), VOICE_TRUMPET_CONFIGURED_FEATURE);
	}
	
	// Structures --------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public static final Structure<NoFeatureConfig> DOME_STRUCTURE = new DomeStructure(NoFeatureConfig.field_236558_a_);
	public static final IStructurePieceType DOME_PIECE = DomePieces.Piece::new;

	@SubscribeEvent
    public static void registerStructures(RegistryEvent.Register<Structure<?>> event) {
    	RegisterHelper.register(event.getRegistry(), DOME_STRUCTURE, "dome");

    	registerStructure(DOME_STRUCTURE, new StructureSeparationSettings(WorldGenConfig.DOME_MAX_CHUNKS.get(), WorldGenConfig.DOME_MIN_CHUNKS.get(), 8351309), false);
    	registerStructurePiece(DOME_PIECE, new ResourceLocation(Teletubbies.MODID, "dome_piece"));
    	registerConfiguredStructures();
    }
	
	// https://github.com/TelepathicGrunt/StructureTutorialMod/blob/c919931014ba7515981f2516892489953e718f56/src/main/java/com/telepathicgrunt/structuretutorial/STStructures.java
	public static <F extends Structure<?>> void registerStructure(F structure, StructureSeparationSettings separation, boolean transformSurroundingLand) {
        Structure.field_236365_a_.put(structure.getRegistryName().toString(), structure);
        
        if (transformSurroundingLand) {
            Structure.field_236384_t_ =
                    ImmutableList.<Structure<?>>builder()
                    .addAll(Structure.field_236384_t_)
                    .add(structure)
                    .build();
        }

        DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, separation)
                        .build();
    }

	
	static void registerStructurePiece(IStructurePieceType piece, ResourceLocation resourceLocation) {
        Registry.register(Registry.STRUCTURE_PIECE, resourceLocation, piece);
    }
	
	public static final StructureFeature<?, ?> DOME_CONFIGURED_STRUCTURE = DOME_STRUCTURE.func_236391_a_(IFeatureConfig.NO_FEATURE_CONFIG);
	
	public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "dome_configured_structure"), DOME_CONFIGURED_STRUCTURE);
        FlatGenerationSettings.STRUCTURES.put(DOME_STRUCTURE, DOME_CONFIGURED_STRUCTURE);
    }
	
	@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
	static class Events {
    	@SubscribeEvent
        public static void biomeLoading(final BiomeLoadingEvent event) {
    		if (event.getCategory() == Category.PLAINS) {
    			event.getGeneration().withFeature(Decoration.LOCAL_MODIFICATIONS, VOICE_TRUMPET_CONFIGURED_FEATURE);
    			
    			event.getGeneration().withStructure(DOME_CONFIGURED_STRUCTURE);
    		}
        }
    	
		@SubscribeEvent(priority = EventPriority.HIGH)
		public static void addDimensionalSpacing(final WorldEvent.Load event) {
			if (event.getWorld() instanceof ServerWorld) {
				ServerWorld serverWorld = (ServerWorld) event.getWorld();

				if (serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator
						&& serverWorld.getDimensionKey().equals(World.OVERWORLD)) {
					return;
				}

				Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
				tempMap.put(DOME_STRUCTURE, DimensionStructuresSettings.field_236191_b_.get(DOME_STRUCTURE));
				serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
			}
		}
	} 
}
