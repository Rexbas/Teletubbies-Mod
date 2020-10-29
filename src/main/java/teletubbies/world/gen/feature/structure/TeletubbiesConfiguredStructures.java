package teletubbies.world.gen.feature.structure;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import teletubbies.Teletubbies;
import teletubbies.init.TeletubbiesWorldGen;

public class TeletubbiesConfiguredStructures {
	public static final StructureFeature<?, ?> DOME_CONFIGURED_STRUCTURE = TeletubbiesWorldGen.DOME_STRUCTURE.get().withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG);

	public static void registerConfiguredStructures() {
	    Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
	    Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "dome_configured_structure"), DOME_CONFIGURED_STRUCTURE);
	    FlatGenerationSettings.STRUCTURES.put(TeletubbiesWorldGen.DOME_STRUCTURE.get(), DOME_CONFIGURED_STRUCTURE);
	}
}
