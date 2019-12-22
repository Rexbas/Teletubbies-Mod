package teletubbies.world.gen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.world.gen.feature.VoiceTrumpetFeature;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldGenList {

	public static final Feature<NoFeatureConfig> VOICE_TRUMPET_FEATURE = registerFeature(new VoiceTrumpetFeature(NoFeatureConfig::deserialize), "voice_trumpet");
	
	@SubscribeEvent
	public static void registerFeatures(final RegistryEvent.Register<Feature<?>> event) {
		addFeature(Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(VOICE_TRUMPET_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.FOREST_ROCK, new FrequencyConfig(2)), Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS);
		
		event.getRegistry().registerAll(
				VOICE_TRUMPET_FEATURE
		);
	}
	
	private static <T extends IFeatureConfig> Feature<T> registerFeature(Feature<T> feature, String registryName) {
		feature.setRegistryName(registryName);
		return feature;
	}
	
	private static void addFeature(GenerationStage.Decoration decorationStage, ConfiguredFeature<?> feature, Biome...biomes) {
		for (Biome b : biomes) {
			b.addFeature(decorationStage, feature);
		}
	}
}
