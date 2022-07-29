package com.rexbas.teletubbies.worldgen.feature;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.init.TeletubbiesWorldGen;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;

public class TeletubbiesConfiguredFeatures {
	public static final ConfiguredFeature<?, ?> VOICE_TRUMPET_CONFIGURED_FEATURE = TeletubbiesWorldGen.VOICE_TRUMPET_FEATURE.get()
		.configured(IFeatureConfig.NONE)
		.decorated(Placement.HEIGHTMAP_WORLD_SURFACE.configured(new NoPlacementConfig()));
	
	public static void registerConfiguredFeatures() {	
		Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;
		Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "voice_trumpet_configured_feature"), VOICE_TRUMPET_CONFIGURED_FEATURE);
	}
}
