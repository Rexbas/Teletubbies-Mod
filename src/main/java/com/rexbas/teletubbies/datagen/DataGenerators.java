package com.rexbas.teletubbies.datagen;

import com.rexbas.teletubbies.Teletubbies;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator gen = event.getGenerator();
		ExistingFileHelper fileHelper = event.getExistingFileHelper();

        gen.addProvider(event.includeClient(), new TeletubbiesItemModelProvider(gen, fileHelper));
		gen.addProvider(event.includeServer(), new TeletubbiesBlockTagsProvider(gen, fileHelper));
	}
}