package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.block.ControlPanelBlock;
import com.rexbas.teletubbies.block.CustardMachineBlock;
import com.rexbas.teletubbies.block.FullGrassBlock;
import com.rexbas.teletubbies.block.ToastMachineBlock;
import com.rexbas.teletubbies.block.VoiceTrumpetBlock;
import com.rexbas.teletubbies.block.WindowBlock;
import com.rexbas.teletubbies.tileentity.ControlPanelTileEntity;
import com.rexbas.teletubbies.tileentity.CustardMachineSlaveTileEntity;
import com.rexbas.teletubbies.tileentity.CustardMachineTileEntity;
import com.rexbas.teletubbies.tileentity.ToastMachineTileEntity;
import com.rexbas.teletubbies.tileentity.VoiceTrumpetTileEntity;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
	public static final RegistryObject<TileEntityType<?>> CONTROL_PANEL_TILE = TILE_ENTITIES.register("control_panel_tile", () -> TileEntityType.Builder.of(ControlPanelTileEntity::new, VOICE_TRUMPET.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> VOICE_TRUMPET_TILE = TILE_ENTITIES.register("voice_trumpet_tile", () -> TileEntityType.Builder.of(VoiceTrumpetTileEntity::new, VOICE_TRUMPET.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> TOAST_MACHINE_TILE = TILE_ENTITIES.register("toast_machine_tile", () -> TileEntityType.Builder.of(ToastMachineTileEntity::new, TOAST_MACHINE.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> CUSTARD_MACHINE_TILE = TILE_ENTITIES.register("custard_machine_tile", () -> TileEntityType.Builder.of(CustardMachineTileEntity::new, CUSTARD_MACHINE.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> CUSTARD_MACHINE_SLAVE_TILE = TILE_ENTITIES.register("custard_machine_slave_tile", () -> TileEntityType.Builder.of(CustardMachineSlaveTileEntity::new, CUSTARD_MACHINE.get()).build(null));
}
