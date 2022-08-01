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
import com.rexbas.teletubbies.block.entity.ControlPanelBlockEntity;
import com.rexbas.teletubbies.block.entity.CustardMachineBlockEntity;
import com.rexbas.teletubbies.block.entity.CustardMachineSlaveBlockEntity;
import com.rexbas.teletubbies.block.entity.ToastMachineBlockEntity;
import com.rexbas.teletubbies.block.entity.VoiceTrumpetBlockEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TeletubbiesBlocks {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Teletubbies.MODID);
	public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Teletubbies.MODID);

	// Blocks
	public static final RegistryObject<Block> FULL_GRASS = BLOCKS.register("full_grass", FullGrassBlock::new);
	public static final RegistryObject<Block> CONTROL_PANEL = BLOCKS.register("control_panel", ControlPanelBlock::new);
	public static final RegistryObject<Block> VOICE_TRUMPET = BLOCKS.register("voice_trumpet", VoiceTrumpetBlock::new);
	public static final RegistryObject<Block> TOAST_MACHINE = BLOCKS.register("toast_machine", ToastMachineBlock::new);
	public static final RegistryObject<Block> CUSTARD_MACHINE = BLOCKS.register("custard_machine", CustardMachineBlock::new);
	public static final RegistryObject<Block> WINDOW = BLOCKS.register("window", WindowBlock::new);

	// Block Entities
	public static final RegistryObject<BlockEntityType<?>> CONTROL_PANEL_BLOCK_ENTITY = BLOCK_ENTITIES.register("control_panel_tile", () -> BlockEntityType.Builder.of(ControlPanelBlockEntity::new, CONTROL_PANEL.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> VOICE_TRUMPET_BLOCK_ENTITY = BLOCK_ENTITIES.register("voice_trumpet_tile", () -> BlockEntityType.Builder.of(VoiceTrumpetBlockEntity::new, VOICE_TRUMPET.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> TOAST_MACHINE_BLOCK_ENTITY = BLOCK_ENTITIES.register("toast_machine_tile", () -> BlockEntityType.Builder.of(ToastMachineBlockEntity::new, TOAST_MACHINE.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> CUSTARD_MACHINE_BLOCK_ENTITY = BLOCK_ENTITIES.register("custard_machine_tile", () -> BlockEntityType.Builder.of(CustardMachineBlockEntity::new, CUSTARD_MACHINE.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> CUSTARD_MACHINE_SLAVE_BLOCK_ENTITY = BLOCK_ENTITIES.register("custard_machine_slave_tile", () -> BlockEntityType.Builder.of(CustardMachineSlaveBlockEntity::new, CUSTARD_MACHINE.get()).build(null));
	
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