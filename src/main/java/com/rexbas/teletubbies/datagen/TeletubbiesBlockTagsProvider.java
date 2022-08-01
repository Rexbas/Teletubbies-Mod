<<<<<<<< HEAD:src/main/java/teletubbies/datagen/TeletubbiesBlockTagsProvider.java
package teletubbies.datagen;
========
package com.rexbas.teletubbies.datagen;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
>>>>>>>> origin/1.18:src/main/java/com/rexbas/teletubbies/datagen/TeletubbiesBlockTagsProvider.java

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class TeletubbiesBlockTagsProvider extends BlockTagsProvider {

	public TeletubbiesBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Teletubbies.MODID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
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