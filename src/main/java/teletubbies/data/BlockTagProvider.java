package teletubbies.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import teletubbies.Teletubbies;
import teletubbies.init.TeletubbiesBlocks;

public class BlockTagProvider extends BlockTagsProvider {

	public BlockTagProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Teletubbies.MODID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {		
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TeletubbiesBlocks.CONTROL_PANEL.get());
		this.tag(BlockTags.NEEDS_STONE_TOOL).add(TeletubbiesBlocks.CONTROL_PANEL.get());

		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TeletubbiesBlocks.VOICE_TRUMPET.get());
		this.tag(BlockTags.NEEDS_STONE_TOOL).add(TeletubbiesBlocks.VOICE_TRUMPET.get());
		
		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TeletubbiesBlocks.TOAST_MACHINE.get());
		this.tag(BlockTags.NEEDS_STONE_TOOL).add(TeletubbiesBlocks.TOAST_MACHINE.get());

		this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(TeletubbiesBlocks.CUSTARD_MACHINE.get());
		this.tag(BlockTags.NEEDS_STONE_TOOL).add(TeletubbiesBlocks.CUSTARD_MACHINE.get());
	}
}
