package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.worldgen.structure.DomeStructure;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TeletubbiesStructures {

    // https://github.com/TelepathicGrunt/StructureTutorialMod/blob/1.19.0-Forge-Jigsaw/src/main/java/com/telepathicgrunt/structuretutorial/STStructures.java

	public static final DeferredRegister<StructureType<?>> STRUCTURES = DeferredRegister.create(Registry.STRUCTURE_TYPE_REGISTRY, Teletubbies.MODID);

    public static final RegistryObject<StructureType<DomeStructure>> DOME_STRUCTURE = STRUCTURES.register("dome_structure", () -> () -> DomeStructure.CODEC);
}