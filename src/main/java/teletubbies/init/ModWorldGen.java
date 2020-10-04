package teletubbies.init;

import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.placement.NoPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;
import teletubbies.world.gen.feature.VoiceTrumpetFeature;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModWorldGen {

	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Teletubbies.MODID);

	public static final RegistryObject<Feature<NoFeatureConfig>> VOICE_TRUMPET_FEATURE = FEATURES.register("voice_trumpet", 
			() -> new VoiceTrumpetFeature(NoFeatureConfig.field_236558_a_));

	
	@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
	static class LoadBiomes {
		@SubscribeEvent
		public static void loadingBiome(final BiomeLoadingEvent event) {
			if (event.getCategory() == Category.PLAINS) {
				event.getGeneration().withFeature(Decoration.LOCAL_MODIFICATIONS, VOICE_TRUMPET_FEATURE.get()
						.withConfiguration(new NoFeatureConfig())
						.withPlacement(Placement.field_242906_k.configure(new NoPlacementConfig()))).build();
			}
		}
	}
}
