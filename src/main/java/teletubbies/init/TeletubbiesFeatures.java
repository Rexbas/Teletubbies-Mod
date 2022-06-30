package teletubbies.init;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import teletubbies.Teletubbies;
import teletubbies.worldgen.feature.VoiceTrumpetFeature;
import teletubbies.worldgen.feature.VoiceTrumpetFeatureModifier;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesFeatures {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Teletubbies.MODID);
	public static final RegistryObject<Feature<NoneFeatureConfiguration>> VOICE_TRUMPET_FEATURE = FEATURES.register("voice_trumpet", () -> new VoiceTrumpetFeature(NoneFeatureConfiguration.CODEC));
	
	public static final DeferredRegister<Codec<? extends BiomeModifier>> BIOME_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, Teletubbies.MODID);
    public static final RegistryObject<Codec<VoiceTrumpetFeatureModifier>> VOICE_TRUMPET_BIOME_MODIFIER = BIOME_MODIFIER_SERIALIZERS.register("voice_trumpet_biome_modifier", () ->
    RecordCodecBuilder.create(builder -> builder.group(
	        Biome.LIST_CODEC.fieldOf("biomes").forGetter(VoiceTrumpetFeatureModifier::biomes)).apply(builder, VoiceTrumpetFeatureModifier::new)));
}
