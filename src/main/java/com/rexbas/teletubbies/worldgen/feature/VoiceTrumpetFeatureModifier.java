package com.rexbas.teletubbies.worldgen.feature;

import com.mojang.serialization.Codec;
import com.rexbas.teletubbies.config.Config;
import com.rexbas.teletubbies.init.TeletubbiesConfiguredFeatures;
import com.rexbas.teletubbies.init.TeletubbiesFeatures;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo.BiomeInfo.Builder;

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