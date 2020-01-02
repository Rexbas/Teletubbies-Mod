package teletubbies.world.gen;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.world.gen.feature.VoiceTrumpetFeature;
import teletubbies.world.gen.feature.structure.DomePiece;
import teletubbies.world.gen.feature.structure.DomeStructure;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldGenList {

	public static final Feature<NoFeatureConfig> VOICE_TRUMPET_FEATURE = registerFeature(new VoiceTrumpetFeature(NoFeatureConfig::deserialize), "voice_trumpet");
	public static final Structure<NoFeatureConfig> DOME_STRUCTURE = registerStructure(new DomeStructure(NoFeatureConfig::deserialize), "dome");
	
	public static final IStructurePieceType DOME_PIECE = Registry.register(Registry.STRUCTURE_PIECE, Teletubbies.MODID + ":dome_piece", DomePiece::new);
	
	@SubscribeEvent
	public static void registerFeatures(final RegistryEvent.Register<Feature<?>> event) {
		addFeature(Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(VOICE_TRUMPET_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.FOREST_ROCK, new FrequencyConfig(2)), Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
				
		addStructure(DOME_STRUCTURE, IFeatureConfig.NO_FEATURE_CONFIG, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
	    addFeature(Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(DOME_STRUCTURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG), Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
	    
		event.getRegistry().registerAll(
				VOICE_TRUMPET_FEATURE, DOME_STRUCTURE
		);
	}

	private static <T extends IFeatureConfig> Feature<T> registerFeature(Feature<T> feature, String registryName) {
		feature.setRegistryName(registryName);
		return feature;
	}
	
	private static <T extends IFeatureConfig> Structure<T> registerStructure(Structure<T> structure, String registryName) {
		structure.setRegistryName(registryName);
		return structure;
	}
	
	private static void addFeature(Decoration decorationStage, ConfiguredFeature<?> config, Biome...biomes) {
		for (Biome b : biomes) {
			b.addFeature(decorationStage, config);
		}
	}
	
	private static void addStructure(Structure<NoFeatureConfig> structure, NoFeatureConfig config, Biome...biomes) {
		for (Biome b : biomes) {
			b.addStructure(structure, config);
		}
	}
}
