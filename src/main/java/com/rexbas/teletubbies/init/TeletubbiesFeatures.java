package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.config.Config;
import com.rexbas.teletubbies.worldgen.feature.VoiceTrumpetFeature;

import net.minecraft.core.Holder;
import net.minecraft.world.level.biome.Biome.BiomeCategory;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Teletubbies.MODID);

	public static final RegistryObject<Feature<NoneFeatureConfiguration>> VOICE_TRUMPET_FEATURE = FEATURES.register("voice_trumpet", () -> new VoiceTrumpetFeature(NoneFeatureConfiguration.CODEC));
	
	@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
	private static class ForgeBusEvents {
		
		@SubscribeEvent
		public static void biomeLoading(final BiomeLoadingEvent event) {
			if (event.getCategory() == BiomeCategory.PLAINS) {
				if (Config.COMMON.VOICE_TRUMPET_CHANCE.get() != 0)
					event.getGeneration().getFeatures(Decoration.LOCAL_MODIFICATIONS).add(Holder.direct(TeletubbiesConfiguredFeatures.VOICE_TRUMPET_PLACED_FEATURE));
			}
		}
	}
}