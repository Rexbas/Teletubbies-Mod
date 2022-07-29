package com.rexbas.teletubbies.util;

import com.rexbas.teletubbies.Teletubbies;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegisterHelper {
    public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey) {
        entry.setRegistryName(new ResourceLocation(Teletubbies.MODID, registryKey));
        registry.register(entry);
        return entry;
    }
}
