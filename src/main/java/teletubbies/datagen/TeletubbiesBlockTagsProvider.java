package teletubbies.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import teletubbies.Teletubbies;
import teletubbies.init.TeletubbiesBlocks;

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
