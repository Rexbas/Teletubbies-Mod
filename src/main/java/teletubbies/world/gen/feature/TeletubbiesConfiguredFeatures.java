package teletubbies.world.gen.feature;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.ChanceDecoratorConfiguration;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import teletubbies.Teletubbies;
import teletubbies.config.Config;
import teletubbies.init.TeletubbiesWorldGen;

public class TeletubbiesConfiguredFeatures {
	public static final ConfiguredFeature<?, ?> VOICE_TRUMPET_CONFIGURED_FEATURE = TeletubbiesWorldGen.VOICE_TRUMPET_FEATURE.get()
		.configured(FeatureConfiguration.NONE)
		.decorated(FeatureDecorator.CHANCE.configured(new ChanceDecoratorConfiguration(Config.COMMON.VOICE_TRUMPET_CHANCE.get())));
	
	public static void registerConfiguredFeatures() {	
		Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;
		Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "voice_trumpet_configured_feature"), VOICE_TRUMPET_CONFIGURED_FEATURE);
	}
}
