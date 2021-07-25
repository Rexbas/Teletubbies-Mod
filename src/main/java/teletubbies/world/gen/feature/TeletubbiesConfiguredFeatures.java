package teletubbies.world.gen.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import teletubbies.Teletubbies;
import teletubbies.init.TeletubbiesWorldGen;

public class TeletubbiesConfiguredFeatures {
	public static final ConfiguredFeature<?, ?> VOICE_TRUMPET_CONFIGURED_FEATURE = TeletubbiesWorldGen.VOICE_TRUMPET_FEATURE.get()
		.configured(FeatureConfiguration.NONE)
		.decorated(FeatureDecorator.HEIGHTMAP_WORLD_SURFACE.configured(new NoneDecoratorConfiguration()));
	
	public static void registerConfiguredFeatures() {	
		Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;
		Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "voice_trumpet_configured_feature"), VOICE_TRUMPET_CONFIGURED_FEATURE);
	}
}
