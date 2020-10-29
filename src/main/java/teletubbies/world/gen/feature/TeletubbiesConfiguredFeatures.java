package teletubbies.world.gen.feature;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import teletubbies.Teletubbies;
import teletubbies.init.TeletubbiesWorldGen;

public class TeletubbiesConfiguredFeatures {
	public static final ConfiguredFeature<?, ?> VOICE_TRUMPET_CONFIGURED_FEATURE = TeletubbiesWorldGen.VOICE_TRUMPET_FEATURE.get()
		.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
		.withPlacement(Placement.HEIGHTMAP_WORLD_SURFACE.configure(new NoPlacementConfig()));
	
	public static void registerConfiguredFeatures() {	
		Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
		Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "voice_trumpet_configured_feature"), VOICE_TRUMPET_CONFIGURED_FEATURE);
	}
}
