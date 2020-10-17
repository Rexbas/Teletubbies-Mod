package teletubbies.world.gen;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;
import teletubbies.util.RegisterHelper;
import teletubbies.world.gen.feature.VoiceTrumpetFeature;
import teletubbies.world.gen.feature.structure.DomePieces;
import teletubbies.world.gen.feature.structure.DomeStructure;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldGenList {
	// Features
	public static final Feature<NoFeatureConfig> VOICE_TRUMPET_FEATURE = new VoiceTrumpetFeature(NoFeatureConfig::deserialize);
	
	// Structures --------------------------------------------------------------------------------------------------------------------------------------------------------------	
	public static final Structure<NoFeatureConfig> DOME_STRUCTURE = new DomeStructure(NoFeatureConfig::deserialize);
	public static final IStructurePieceType DOME_PIECE = DomePieces.Piece::new;
	
	@SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
    	RegisterHelper.register(event.getRegistry(), VOICE_TRUMPET_FEATURE, "voice_trumpet");
    	RegisterHelper.register(event.getRegistry(), DOME_STRUCTURE, "dome");
    	registerStructurePiece(DOME_PIECE, new ResourceLocation(Teletubbies.MODID, "dome_piece"));
    }
	
	static void registerStructurePiece(IStructurePieceType piece, ResourceLocation resourceLocation) {
        Registry.register(Registry.STRUCTURE_PIECE, resourceLocation, piece);
    }
	
	@SubscribeEvent
	public static void setup(final FMLCommonSetupEvent event) {
		for (Biome biome : ForgeRegistries.BIOMES) {
			if (biome.getCategory() == Category.PLAINS) {
				biome.addFeature(Decoration.LOCAL_MODIFICATIONS, Biome.createDecoratedFeature(VOICE_TRUMPET_FEATURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP, new FrequencyConfig(1)));
				
				biome.addStructure(DOME_STRUCTURE, IFeatureConfig.NO_FEATURE_CONFIG);
				biome.addFeature(Decoration.SURFACE_STRUCTURES, Biome.createDecoratedFeature(DOME_STRUCTURE, IFeatureConfig.NO_FEATURE_CONFIG, Placement.NOPE, IPlacementConfig.NO_PLACEMENT_CONFIG));
			}
		}
	}
	
}
