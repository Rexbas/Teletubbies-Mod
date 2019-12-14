package teletubbies.lists;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.blocks.CustardMachine;
import teletubbies.blocks.ToastMachine;
import teletubbies.blocks.VoiceTrumpet;
import teletubbies.tileentities.CustardMachineTile;
import teletubbies.tileentities.ToastMachineTile;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockList {	
	public static final Block VOICE_TRUMPET = new VoiceTrumpet();
	public static final Block TOAST_MACHINE = new ToastMachine();
	public static final Block CUSTARD_MACHINE = new CustardMachine();
	
	public static final TileEntityType<?> TOAST_MACHINE_TILE = TileEntityType.Builder.create(ToastMachineTile::new, BlockList.TOAST_MACHINE).build(null).setRegistryName(Teletubbies.MODID, "toast_machine_tile");
	public static final TileEntityType<?> CUSTARD_MACHINE_TILE = TileEntityType.Builder.create(CustardMachineTile::new, BlockList.CUSTARD_MACHINE).build(null).setRegistryName(Teletubbies.MODID, "custard_machine_tile");
	
	@SubscribeEvent
	public static void registerBlocksEvent(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				VOICE_TRUMPET, TOAST_MACHINE, CUSTARD_MACHINE
		);
	}
	
	@SubscribeEvent
	public static void registerTilesEvent(final RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().registerAll(
				TOAST_MACHINE_TILE, CUSTARD_MACHINE_TILE				
		);
	}
}
