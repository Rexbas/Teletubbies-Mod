package teletubbies.init;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fmllegacy.RegistryObject;
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
	public static final DeferredRegister<BlockEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Teletubbies.MODID);

	// Blocks
	public static final RegistryObject<Block> FULL_GRASS = BLOCKS.register("full_grass", FullGrassBlock::new);
	public static final RegistryObject<Block> CONTROL_PANEL = BLOCKS.register("control_panel", ControlPanelBlock::new);
	public static final RegistryObject<Block> VOICE_TRUMPET = BLOCKS.register("voice_trumpet", VoiceTrumpetBlock::new);
	public static final RegistryObject<Block> TOAST_MACHINE = BLOCKS.register("toast_machine", ToastMachineBlock::new);
	public static final RegistryObject<Block> CUSTARD_MACHINE = BLOCKS.register("custard_machine", CustardMachineBlock::new);
	public static final RegistryObject<Block> WINDOW = BLOCKS.register("window", WindowBlock::new);

	// Tile Entities
	public static final RegistryObject<BlockEntityType<?>> CONTROL_PANEL_TILE = TILE_ENTITIES.register("control_panel_tile", () -> BlockEntityType.Builder.of(ControlPanelTileEntity::new, VOICE_TRUMPET.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> VOICE_TRUMPET_TILE = TILE_ENTITIES.register("voice_trumpet_tile", () -> BlockEntityType.Builder.of(VoiceTrumpetTileEntity::new, VOICE_TRUMPET.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> TOAST_MACHINE_TILE = TILE_ENTITIES.register("toast_machine_tile", () -> BlockEntityType.Builder.of(ToastMachineTileEntity::new, TOAST_MACHINE.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> CUSTARD_MACHINE_TILE = TILE_ENTITIES.register("custard_machine_tile", () -> BlockEntityType.Builder.of(CustardMachineTileEntity::new, CUSTARD_MACHINE.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> CUSTARD_MACHINE_SLAVE_TILE = TILE_ENTITIES.register("custard_machine_slave_tile", () -> BlockEntityType.Builder.of(CustardMachineSlaveTileEntity::new, CUSTARD_MACHINE.get()).build(null));
}
