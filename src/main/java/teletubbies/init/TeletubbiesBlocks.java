package teletubbies.init;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;
import teletubbies.block.ControlPanelBlock;
import teletubbies.block.CustardMachineBlock;
import teletubbies.block.FullGrassBlock;
import teletubbies.block.ToastMachineBlock;
import teletubbies.block.VoiceTrumpetBlock;
import teletubbies.block.WindowBlock;
import teletubbies.tileentity.ControlPanelTileEntity;
import teletubbies.tileentity.CustardMachineSlaveTileEntity;
import teletubbies.tileentity.CustardMachineTileEntity;
import teletubbies.tileentity.ToastMachineTileEntity;
import teletubbies.tileentity.VoiceTrumpetTileEntity;

public class TeletubbiesBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Teletubbies.MODID);
	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Teletubbies.MODID);

	// Blocks
	public static final RegistryObject<Block> FULL_GRASS = BLOCKS.register("full_grass", FullGrassBlock::new);
	public static final RegistryObject<Block> CONTROL_PANEL = BLOCKS.register("control_panel", ControlPanelBlock::new);
	public static final RegistryObject<Block> VOICE_TRUMPET = BLOCKS.register("voice_trumpet", VoiceTrumpetBlock::new);
	public static final RegistryObject<Block> TOAST_MACHINE = BLOCKS.register("toast_machine", ToastMachineBlock::new);
	public static final RegistryObject<Block> CUSTARD_MACHINE = BLOCKS.register("custard_machine", CustardMachineBlock::new);
	public static final RegistryObject<Block> WINDOW = BLOCKS.register("window", WindowBlock::new);

	// Tile Entities
	public static final RegistryObject<TileEntityType<?>> CONTROL_PANEL_TILE = TILE_ENTITIES.register("control_panel_tile", () -> TileEntityType.Builder.create(ControlPanelTileEntity::new, VOICE_TRUMPET.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> VOICE_TRUMPET_TILE = TILE_ENTITIES.register("voice_trumpet_tile", () -> TileEntityType.Builder.create(VoiceTrumpetTileEntity::new, VOICE_TRUMPET.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> TOAST_MACHINE_TILE = TILE_ENTITIES.register("toast_machine_tile", () -> TileEntityType.Builder.create(ToastMachineTileEntity::new, TOAST_MACHINE.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> CUSTARD_MACHINE_TILE = TILE_ENTITIES.register("custard_machine_tile", () -> TileEntityType.Builder.create(CustardMachineTileEntity::new, CUSTARD_MACHINE.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> CUSTARD_MACHINE_SLAVE_TILE = TILE_ENTITIES.register("custard_machine_slave_tile", () -> TileEntityType.Builder.create(CustardMachineSlaveTileEntity::new, CUSTARD_MACHINE.get()).build(null));
}
