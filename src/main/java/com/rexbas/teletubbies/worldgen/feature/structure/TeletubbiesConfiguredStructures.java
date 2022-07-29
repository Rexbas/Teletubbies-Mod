package com.rexbas.teletubbies.worldgen.feature.structure;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.init.TeletubbiesWorldGen;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class TeletubbiesConfiguredStructures {
	public static final StructureFeature<?, ?> DOME_CONFIGURED_STRUCTURE = TeletubbiesWorldGen.DOME_STRUCTURE.get().configured(IFeatureConfig.NONE);

	public static void registerConfiguredStructures() {
	    Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
	    Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "dome_configured_structure"), DOME_CONFIGURED_STRUCTURE);
	    FlatGenerationSettings.STRUCTURE_FEATURES.put(TeletubbiesWorldGen.DOME_STRUCTURE.get(), DOME_CONFIGURED_STRUCTURE);
	}
}