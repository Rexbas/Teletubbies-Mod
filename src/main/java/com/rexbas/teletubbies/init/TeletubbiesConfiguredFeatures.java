package com.rexbas.teletubbies.init;

import java.util.List;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.config.Config;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class TeletubbiesConfiguredFeatures {    
    
	// https://github.com/TelepathicGrunt/RepurposedStructures/blob/1.18.2/src/main/java/com/telepathicgrunt/repurposedstructures/modinit/RSConfiguredFeatures.java
	
    public static ConfiguredFeature<?, ?> VOICE_TRUMPET_CONFIGURED_FEATURE = new ConfiguredFeature<>(TeletubbiesFeatures.VOICE_TRUMPET_FEATURE.get(), FeatureConfiguration.NONE);

    public static PlacedFeature VOICE_TRUMPET_PLACED_FEATURE = new PlacedFeature(Holder.direct(VOICE_TRUMPET_CONFIGURED_FEATURE),
    		List.of(RarityFilter.onAverageOnceEvery(Config.COMMON.VOICE_TRUMPET_CHANCE.get())));
    
    public static void registerConfiguredFeatures() {
        Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;
        Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "voice_trumpet"), VOICE_TRUMPET_CONFIGURED_FEATURE);
    }
    
    public static void registerPlacedFeatures() {
        Registry<PlacedFeature> registry = BuiltinRegistries.PLACED_FEATURE;
        Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "voice_trumpet"), VOICE_TRUMPET_PLACED_FEATURE);
    }
}