package teletubbies.init;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.PlainVillagePools;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.JigsawConfiguration;
import teletubbies.Teletubbies;

public class TeletubbiesConfiguredStructures {

    public static final ConfiguredStructureFeature<?, ?> DOME_CONFIGURED_STRUCTURE = TeletubbiesStructures.DOME_STRUCTURE_FEATURE.get()
    		.configured(new JigsawConfiguration(() -> PlainVillagePools.START, 0));

    public static void registerConfiguredStructures() {
        Registry<ConfiguredStructureFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(Teletubbies.MODID, "dome_configured_structure"), DOME_CONFIGURED_STRUCTURE);
    }
}
