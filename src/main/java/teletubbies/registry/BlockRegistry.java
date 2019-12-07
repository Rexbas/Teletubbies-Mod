package teletubbies.registry;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.blocks.VoiceTrumpet;
import teletubbies.lists.BlockList;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {
	
	@SubscribeEvent
	public static void registerBlocksEvent(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				BlockList.voiceTrumpet = new VoiceTrumpet(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.5f, 10.0f))
		);
	}
}
