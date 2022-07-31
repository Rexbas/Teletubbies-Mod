package com.rexbas.teletubbies.init;

import java.util.ArrayList;
import java.util.List;

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
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.World;
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
	public static final RegistryObject<TileEntityType<?>> CONTROL_PANEL_TILE = TILE_ENTITIES.register("control_panel_tile", () -> TileEntityType.Builder.of(ControlPanelTileEntity::new, CONTROL_PANEL.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> VOICE_TRUMPET_TILE = TILE_ENTITIES.register("voice_trumpet_tile", () -> TileEntityType.Builder.of(VoiceTrumpetTileEntity::new, VOICE_TRUMPET.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> TOAST_MACHINE_TILE = TILE_ENTITIES.register("toast_machine_tile", () -> TileEntityType.Builder.of(ToastMachineTileEntity::new, TOAST_MACHINE.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> CUSTARD_MACHINE_TILE = TILE_ENTITIES.register("custard_machine_tile", () -> TileEntityType.Builder.of(CustardMachineTileEntity::new, CUSTARD_MACHINE.get()).build(null));
	public static final RegistryObject<TileEntityType<?>> CUSTARD_MACHINE_SLAVE_TILE = TILE_ENTITIES.register("custard_machine_slave_tile", () -> TileEntityType.Builder.of(CustardMachineSlaveTileEntity::new, CUSTARD_MACHINE.get()).build(null));
	
	// General help functions
	
	/**
	 * Rotates a VoxelShape around the center of the block around the y-axis.
	 * formula: (rotmat dot (vector - [8, 0, 8])) + [8, 0, 8]
	 */
	public static VoxelShape voxelShapeRotateY(final VoxelShape shape, double a) {
		List<AxisAlignedBB> bbList = shape.toAabbs();
		List<VoxelShape> shapeList = new ArrayList<>();

		for (AxisAlignedBB aabb : bbList) {
			double minX = Math.cos(a) * (aabb.minX - .5) + Math.sin(a) * (aabb.minZ - .5) + .5;
			double minZ = -Math.sin(a) * (aabb.minX - .5) + Math.cos(a) * (aabb.minZ - .5) + .5;
			double maxX = Math.cos(a) * (aabb.maxX - .5) + Math.sin(a) * (aabb.maxZ - .5) + .5;
			double maxZ = -Math.sin(a) * (aabb.maxX - .5) + Math.cos(a) * (aabb.maxZ - .5) + .5;
			shapeList.add(VoxelShapes.box(minX, aabb.minY, minZ, maxX, aabb.maxY, maxZ));
		}

		VoxelShape newShape = shapeList.get(0);
		for (int i = 1; i < shapeList.size(); i++) {
			newShape = VoxelShapes.joinUnoptimized(newShape, shapeList.get(i), IBooleanFunction.OR);
		}
		newShape.optimize();

		return newShape;
	}
	
	public static long secondsToTicks(double seconds) {
		return Math.round(seconds * 20);
	}
	
	public static boolean isBlockSurrounded(World world, BlockPos pos) {
		if (world.getBlockState(pos.above()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (world.getBlockState(pos.below()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (world.getBlockState(pos.north()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (world.getBlockState(pos.east()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (world.getBlockState(pos.south()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (world.getBlockState(pos.west()).getBlock() == Blocks.AIR) {
			return false;
		}
		return true;
	}
}