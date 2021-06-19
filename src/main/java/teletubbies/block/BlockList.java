package teletubbies.block;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;
import teletubbies.Teletubbies;
import teletubbies.tileentity.ControlPanelTileEntity;
import teletubbies.tileentity.CustardMachineSlaveTileEntity;
import teletubbies.tileentity.CustardMachineTileEntity;
import teletubbies.tileentity.ToastMachineTileEntity;
import teletubbies.tileentity.VoiceTrumpetTileEntity;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Teletubbies.MODID)
public class BlockList {
	public static final Block FULL_GRASS = null;
	public static final Block CONTROL_PANEL = new ControlPanelBlock();
	public static final Block VOICE_TRUMPET = new VoiceTrumpetBlock();
	public static final Block TOAST_MACHINE = new ToastMachineBlock();
	public static final Block CUSTARD_MACHINE = new CustardMachineBlock();
	public static final Block WINDOW = new WindowBlock();
	
	public static final TileEntityType<?> CONTROL_PANEL_TILE = TileEntityType.Builder.create(ControlPanelTileEntity::new, BlockList.CONTROL_PANEL).build(null).setRegistryName(Teletubbies.MODID, "control_panel_tile");
	public static final TileEntityType<?> VOICE_TRUMPET_TILE = TileEntityType.Builder.create(VoiceTrumpetTileEntity::new, BlockList.VOICE_TRUMPET).build(null).setRegistryName(Teletubbies.MODID, "voice_trumpet_tile");
	public static final TileEntityType<?> TOAST_MACHINE_TILE = TileEntityType.Builder.create(ToastMachineTileEntity::new, BlockList.TOAST_MACHINE).build(null).setRegistryName(Teletubbies.MODID, "toast_machine_tile");
	public static final TileEntityType<?> CUSTARD_MACHINE_TILE = TileEntityType.Builder.create(CustardMachineTileEntity::new, BlockList.CUSTARD_MACHINE).build(null).setRegistryName(Teletubbies.MODID, "custard_machine_tile");
	public static final TileEntityType<?> CUSTARD_MACHINE_SLAVE_TILE = TileEntityType.Builder.create(CustardMachineSlaveTileEntity::new, BlockList.CUSTARD_MACHINE).build(null).setRegistryName(Teletubbies.MODID, "custard_machine_slave_tile");

	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				new FullGrassBlock(),
				CONTROL_PANEL,
				VOICE_TRUMPET,
				TOAST_MACHINE,
				CUSTARD_MACHINE,
				WINDOW				
		);
	}
	
	@SubscribeEvent
	public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
		event.getRegistry().registerAll(
				CONTROL_PANEL_TILE, VOICE_TRUMPET_TILE, TOAST_MACHINE_TILE, CUSTARD_MACHINE_TILE, CUSTARD_MACHINE_SLAVE_TILE			
		);
	}
}
