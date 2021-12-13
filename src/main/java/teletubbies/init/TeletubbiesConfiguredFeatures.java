package teletubbies.init;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import teletubbies.Teletubbies;
import teletubbies.config.Config;

public class TeletubbiesConfiguredFeatures {    
    
	// https://github.com/TelepathicGrunt/RepurposedStructures/blob/1.18/src/main/java/com/telepathicgrunt/repurposedstructures/modinit/RSConfiguredFeatures.java
	
    public static ConfiguredFeature<?, ?> VOICE_TRUMPET_CONFIGURED_FEATURE = TeletubbiesFeatures.VOICE_TRUMPET_FEATURE.get()
            .configured(FeatureConfiguration.NONE);

    public static PlacedFeature VOICE_TRUMPET_PLACED_FEATURE = VOICE_TRUMPET_CONFIGURED_FEATURE.placed(
            RarityFilter.onAverageOnceEvery(Config.COMMON.VOICE_TRUMPET_CHANCE.get()));
    
    public static void registerConfiguredFeatures() {
        Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;
        Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "voice_trumpet"), VOICE_TRUMPET_CONFIGURED_FEATURE);
    }
    
    public static void registerPlacedFeatures() {
        Registry<PlacedFeature> registry = BuiltinRegistries.PLACED_FEATURE;
        Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "voice_trumpet"), VOICE_TRUMPET_PLACED_FEATURE);
    }
}
