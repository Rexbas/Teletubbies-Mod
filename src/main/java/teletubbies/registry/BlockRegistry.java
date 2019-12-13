package teletubbies.registry;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.blocks.CustardMachine;
import teletubbies.blocks.ToastMachine;
import teletubbies.blocks.VoiceTrumpet;
import teletubbies.lists.BlockList;
import teletubbies.tileentities.CustardMachineTile;
import teletubbies.tileentities.ToastMachineTile;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {
	
	@SubscribeEvent
	public static void registerBlocksEvent(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				BlockList.voiceTrumpet = new VoiceTrumpet(),
				BlockList.toastMachine = new ToastMachine(),
				BlockList.custardMachine = new CustardMachine()
		);
	}
	
	@SubscribeEvent
	public static void registerTilesEvent(final RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().registerAll(
				BlockList.toastMachineTile = TileEntityType.Builder.create(ToastMachineTile::new, BlockList.toastMachine).build(null).setRegistryName(Teletubbies.MODID, "toastmachinetile"),
				BlockList.custardMachineTile = TileEntityType.Builder.create(CustardMachineTile::new, BlockList.custardMachine).build(null).setRegistryName(Teletubbies.MODID, "custardmachinetile")
		);
	}
}
