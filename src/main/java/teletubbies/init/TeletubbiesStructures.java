package teletubbies.init;

import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import teletubbies.Teletubbies;
import teletubbies.worldgen.structure.DomeStructure;

public class TeletubbiesStructures {

    // https://github.com/TelepathicGrunt/StructureTutorialMod/blob/1.18.2-Forge-Jigsaw/src/main/java/com/telepathicgrunt/structuretutorial/STStructures.java

	public static final DeferredRegister<StructureFeature<?>> STRUCTURES = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Teletubbies.MODID);

    public static final RegistryObject<StructureFeature<?>> DOME_STRUCTURE_FEATURE = STRUCTURES.register("dome_structure", DomeStructure::new);
}
