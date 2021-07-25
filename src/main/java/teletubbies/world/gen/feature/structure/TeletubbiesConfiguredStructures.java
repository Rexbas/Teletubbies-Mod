package teletubbies.world.gen.feature.structure;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.flat.FlatLevelGeneratorSettings;
import teletubbies.Teletubbies;
import teletubbies.init.TeletubbiesWorldGen;

public class TeletubbiesConfiguredStructures {
	public static final ConfiguredStructureFeature<?, ?> DOME_CONFIGURED_STRUCTURE = TeletubbiesWorldGen.DOME_STRUCTURE.get().configured(FeatureConfiguration.NONE);

	public static void registerConfiguredStructures() {
	    Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
	    Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "dome_configured_structure"), DOME_CONFIGURED_STRUCTURE);
	    FlatLevelGeneratorSettings.STRUCTURE_FEATURES.put(TeletubbiesWorldGen.DOME_STRUCTURE.get(), DOME_CONFIGURED_STRUCTURE);
	}
}
