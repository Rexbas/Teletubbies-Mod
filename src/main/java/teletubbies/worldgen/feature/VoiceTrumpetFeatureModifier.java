package teletubbies.worldgen.feature;

import com.mojang.serialization.Codec;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;
import teletubbies.config.Config;
import teletubbies.init.TeletubbiesConfiguredFeatures;
import teletubbies.init.TeletubbiesFeatures;

public record VoiceTrumpetFeatureModifier(HolderSet<Biome> biomes) implements BiomeModifier {

	@Override
	public void modify(Holder<Biome> biome, Phase phase, Builder builder) {
		if (phase == Phase.ADD && this.biomes.contains(biome) && Config.COMMON.VOICE_TRUMPET_CHANCE.get() != 0) {
			BiomeGenerationSettingsBuilder generationSettings = builder.getGenerationSettings();
			generationSettings.addFeature(Decoration.LOCAL_MODIFICATIONS, Holder.direct(TeletubbiesConfiguredFeatures.VOICE_TRUMPET_PLACED_FEATURE));
		}
	}

	@Override
	public Codec<? extends BiomeModifier> codec() {
		return TeletubbiesFeatures.VOICE_TRUMPET_BIOME_MODIFIER.get();
	}
}