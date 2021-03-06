package teletubbies.init;

import java.util.HashMap;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome.Category;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;
import teletubbies.config.Config;
import teletubbies.world.gen.feature.TeletubbiesConfiguredFeatures;
import teletubbies.world.gen.feature.VoiceTrumpetFeature;
import teletubbies.world.gen.feature.structure.DomePieces;
import teletubbies.world.gen.feature.structure.DomeStructure;
import teletubbies.world.gen.feature.structure.TeletubbiesConfiguredStructures;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesWorldGen {
	// Features
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Teletubbies.MODID);

	public static final RegistryObject<Feature<NoFeatureConfig>> VOICE_TRUMPET_FEATURE = FEATURES.register("voice_trumpet", () -> new VoiceTrumpetFeature(NoFeatureConfig.CODEC));
	
	// Structures --------------------------------------------------------------------------------------------------------------------------------------------------------------
	public static final DeferredRegister<Structure<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Teletubbies.MODID);
		
	public static final RegistryObject<Structure<NoFeatureConfig>> DOME_STRUCTURE = STRUCTURES.register("dome", () -> new DomeStructure(NoFeatureConfig.CODEC));
	public static final IStructurePieceType DOME_PIECE = DomePieces.Piece::new;
	
	// https://github.com/TelepathicGrunt/StructureTutorialMod/blob/c919931014ba7515981f2516892489953e718f56/src/main/java/com/telepathicgrunt/structuretutorial/STStructures.java
	public static <F extends Structure<?>> void registerStructure(F structure, StructureSeparationSettings separation, boolean transformSurroundingLand) {
        Structure.NAME_STRUCTURE_BIMAP.put(structure.getRegistryName().toString(), structure);
        
        if (transformSurroundingLand) {
            Structure.field_236384_t_ =
                    ImmutableList.<Structure<?>>builder()
                    .addAll(Structure.field_236384_t_)
                    .add(structure)
                    .build();
        }

        DimensionStructuresSettings.field_236191_b_ =
                ImmutableMap.<Structure<?>, StructureSeparationSettings>builder()
                        .putAll(DimensionStructuresSettings.field_236191_b_)
                        .put(structure, separation)
                        .build();
    }
	
	static void registerStructurePiece(IStructurePieceType piece, ResourceLocation resourceLocation) {
        Registry.register(Registry.STRUCTURE_PIECE, resourceLocation, piece);
    }
	
	@SubscribeEvent
	public static void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			TeletubbiesConfiguredFeatures.registerConfiguredFeatures();
			registerStructure(DOME_STRUCTURE.get(), new StructureSeparationSettings(Config.COMMON.DOME_MAX_CHUNKS.get(), Config.COMMON.DOME_MIN_CHUNKS.get(), 8351309), false);
	    	registerStructurePiece(DOME_PIECE, new ResourceLocation(Teletubbies.MODID, "dome_piece"));
	    	TeletubbiesConfiguredStructures.registerConfiguredStructures();
		});
	}
	
	@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
	static class Events {
    	@SubscribeEvent
        public static void biomeLoading(final BiomeLoadingEvent event) {
    		if (event.getCategory() == Category.PLAINS) {
    			event.getGeneration().withFeature(Decoration.LOCAL_MODIFICATIONS, TeletubbiesConfiguredFeatures.VOICE_TRUMPET_CONFIGURED_FEATURE);
    			
    			event.getGeneration().withStructure(TeletubbiesConfiguredStructures.DOME_CONFIGURED_STRUCTURE);
    		}
        }
    	
		@SubscribeEvent(priority = EventPriority.HIGH)
		public static void addDimensionalSpacing(final WorldEvent.Load event) {
			if (event.getWorld() instanceof ServerWorld) {
				ServerWorld serverWorld = (ServerWorld) event.getWorld();

				if (serverWorld.getChunkProvider().getChunkGenerator() instanceof FlatChunkGenerator
						&& serverWorld.getDimensionKey().equals(World.OVERWORLD)) {
					return;
				}

				Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkProvider().generator.func_235957_b_().func_236195_a_());
				tempMap.put(DOME_STRUCTURE.get(), DimensionStructuresSettings.field_236191_b_.get(DOME_STRUCTURE.get()));
				serverWorld.getChunkProvider().generator.func_235957_b_().field_236193_d_ = tempMap;
			}
		}
	}
}
