package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.worldgen.feature.VoiceTrumpetFeature;
import com.rexbas.teletubbies.worldgen.structure.DomeStructure;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class TeletubbiesWorldGen {

    // https://github.com/TelepathicGrunt/StructureTutorialMod/blob/1.19.0-Forge-Jigsaw/src/main/java/com/telepathicgrunt/structuretutorial/STStructures.java
	
    // Structures
	public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES = DeferredRegister.create(Registries.STRUCTURE_TYPE, Teletubbies.MODID);
	public static final RegistryObject<StructureType<DomeStructure>> DOME_STRUCTURE = STRUCTURE_TYPES.register("dome_structure", () -> () -> DomeStructure.CODEC);
	
	// Features
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, Teletubbies.MODID);
	public static final RegistryObject<VoiceTrumpetFeature> VOICE_TRUMPET_FEATURE = FEATURES.register("voice_trumpet_feature", () -> new VoiceTrumpetFeature());	
}