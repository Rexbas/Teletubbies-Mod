package com.rexbas.teletubbies.datagen;

import java.util.concurrent.CompletableFuture;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class TeletubbiesBlockTagsProvider extends BlockTagsProvider {

	public TeletubbiesBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, Teletubbies.MODID, existingFileHelper);
	}

	@Override
	protected void addTags(Provider provider) {
		this.tag(BlockTags.DIRT).add(TeletubbiesBlocks.FULL_GRASS.get());
		this.tag(BlockTags.VALID_SPAWN).add(TeletubbiesBlocks.FULL_GRASS.get());
		this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(TeletubbiesBlocks.FULL_GRASS.get());
		
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
				TeletubbiesBlocks.CONTROL_PANEL.get(),
				TeletubbiesBlocks.VOICE_TRUMPET.get(),
				TeletubbiesBlocks.TOAST_MACHINE.get(),
				TeletubbiesBlocks.CUSTARD_MACHINE.get());
		
		this.tag(BlockTags.NEEDS_STONE_TOOL).add(
				TeletubbiesBlocks.CONTROL_PANEL.get(),
				TeletubbiesBlocks.VOICE_TRUMPET.get(),
				TeletubbiesBlocks.TOAST_MACHINE.get(),
				TeletubbiesBlocks.CUSTARD_MACHINE.get());
	}
}