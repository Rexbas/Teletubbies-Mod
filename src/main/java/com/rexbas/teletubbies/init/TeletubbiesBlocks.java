package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.block.*;
import com.rexbas.teletubbies.block.entity.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class TeletubbiesBlocks {

	public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Teletubbies.MODID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Teletubbies.MODID);

	// Blocks
	public static final Supplier<Block> FULL_GRASS = BLOCKS.register("full_grass", FullGrassBlock::new);
	public static final Supplier<Block> CONTROL_PANEL = BLOCKS.register("control_panel", ControlPanelBlock::new);
	public static final Supplier<Block> VOICE_TRUMPET = BLOCKS.register("voice_trumpet", VoiceTrumpetBlock::new);
	public static final Supplier<Block> TOAST_MACHINE = BLOCKS.register("toast_machine", ToastMachineBlock::new);
	public static final Supplier<Block> CUSTARD_MACHINE = BLOCKS.register("custard_machine", CustardMachineBlock::new);
	public static final Supplier<Block> WINDOW = BLOCKS.register("window", WindowBlock::new);

	// Block Entities
	public static final Supplier<BlockEntityType<?>> CONTROL_PANEL_BLOCK_ENTITY = BLOCK_ENTITIES.register("control_panel_tile", () -> BlockEntityType.Builder.of(ControlPanelBlockEntity::new, CONTROL_PANEL.get()).build(null));
	public static final Supplier<BlockEntityType<?>> VOICE_TRUMPET_BLOCK_ENTITY = BLOCK_ENTITIES.register("voice_trumpet_tile", () -> BlockEntityType.Builder.of(VoiceTrumpetBlockEntity::new, VOICE_TRUMPET.get()).build(null));
	public static final Supplier<BlockEntityType<?>> TOAST_MACHINE_BLOCK_ENTITY = BLOCK_ENTITIES.register("toast_machine_tile", () -> BlockEntityType.Builder.of(ToastMachineBlockEntity::new, TOAST_MACHINE.get()).build(null));
	public static final Supplier<BlockEntityType<?>> CUSTARD_MACHINE_BLOCK_ENTITY = BLOCK_ENTITIES.register("custard_machine_tile", () -> BlockEntityType.Builder.of(CustardMachineBlockEntity::new, CUSTARD_MACHINE.get()).build(null));
	public static final Supplier<BlockEntityType<?>> CUSTARD_MACHINE_SLAVE_BLOCK_ENTITY = BLOCK_ENTITIES.register("custard_machine_slave_tile", () -> BlockEntityType.Builder.of(CustardMachineSlaveBlockEntity::new, CUSTARD_MACHINE.get()).build(null));
	
	// General help functions
	
	/**
	 * Rotates a VoxelShape around the center of the block around the y-axis.
	 * formula: (rotmat dot (vector - [8, 0, 8])) + [8, 0, 8]
	 */
	public static VoxelShape voxelShapeRotateY(final VoxelShape shape, double a) {
		List<AABB> bbList = shape.toAabbs();
		List<VoxelShape> shapeList = new ArrayList<>();

		for (AABB aabb : bbList) {
			double x1 = Math.cos(a) * (aabb.minX - .5) + Math.sin(a) * (aabb.minZ - .5) + .5;
			double z1 = -Math.sin(a) * (aabb.minX - .5) + Math.cos(a) * (aabb.minZ - .5) + .5;
			double x2 = Math.cos(a) * (aabb.maxX - .5) + Math.sin(a) * (aabb.maxZ - .5) + .5;
			double z2 = -Math.sin(a) * (aabb.maxX - .5) + Math.cos(a) * (aabb.maxZ - .5) + .5;

			shapeList.add(Shapes.box(Math.min(x1, x2), aabb.minY, Math.min(z1, z2), Math.max(x1, x2), aabb.maxY, Math.max(z1, z2)));
		}

		VoxelShape newShape = shapeList.get(0);
		for (int i = 1; i < shapeList.size(); i++) {
			newShape = Shapes.joinUnoptimized(newShape, shapeList.get(i), BooleanOp.OR);
		}
		newShape.optimize();

		return newShape;
	}
	
	public static long secondsToTicks(double seconds) {
		return Math.round(seconds * 20);
	}
	
	public static boolean isBlockSurrounded(Level level, BlockPos pos) {
		if (level.getBlockState(pos.above()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (level.getBlockState(pos.below()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (level.getBlockState(pos.north()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (level.getBlockState(pos.east()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (level.getBlockState(pos.south()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (level.getBlockState(pos.west()).getBlock() == Blocks.AIR) {
			return false;
		}
		return true;
	}
}