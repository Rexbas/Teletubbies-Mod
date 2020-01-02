package teletubbies.world.gen.feature.structure;

import java.util.Random;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTables;
import teletubbies.Teletubbies;
import teletubbies.world.gen.WorldGenList;

public class DomePiece extends ScatteredStructurePiece {
	
	private TemplateManager manager;
	private int spawnHeight = -1;
	
	public DomePiece(TemplateManager manager, SharedSeedRandom rand, int x, int z, int sizeX, int sizeY, int sizeZ) {
		super(WorldGenList.DOME_PIECE, rand, x, 0, z, sizeX, sizeY, sizeZ);
		this.manager = manager;
	}

	public DomePiece(TemplateManager manager, CompoundNBT nbt) {
		super(WorldGenList.DOME_PIECE, nbt);
		this.manager = manager;
	}

	@Override
	public boolean addComponentParts(IWorld world, Random rand, MutableBoundingBox bb, ChunkPos chunk) {
		String path = "dome_";
		MutableBoundingBox fullBB = this.getBoundingBox();
		if (bb.minX == fullBB.minX && bb.minZ == fullBB.minZ) {
			path += "tinkywinky";
		} else if (bb.minX == fullBB.minX + 16 && bb.minZ == fullBB.minZ) {
			path += "dipsy";
		}
		else if (bb.minX == fullBB.minX && bb.minZ == fullBB.minZ + 16) {
			path += "po";
		}
		else if (bb.minX == fullBB.minX + 16 && bb.minZ == fullBB.minZ + 16) {
			path += "laalaa";
		}
		
		Template template = manager.getTemplate(new ResourceLocation(Teletubbies.MODID, path));
		if (template != null) {
			template.addBlocksToWorldChunk(world, new BlockPos(bb.minX, this.spawnHeight, bb.minZ), new PlacementSettings());
		 	this.generateChest(world, bb, rand, 4, 2, 13, LootTables.CHESTS_DESERT_PYRAMID);
			return true;
		}
		return false;
	}
	
	public int getSpawnHeight() {
		return this.spawnHeight;
	}
	
	public void setSpawnHeight(int height) {
		this.spawnHeight = height - 3;
		MutableBoundingBox bb = this.getBoundingBox();
		if (this.getCoordBaseMode().getAxis() == Direction.Axis.Z) {
			this.boundingBox = new MutableBoundingBox(bb.minX, spawnHeight, bb.minZ, bb.minX + this.width - 1, spawnHeight + this.height - 1, bb.minZ + this.depth - 1);
		} else {
			this.boundingBox = new MutableBoundingBox(bb.minX, spawnHeight, bb.minZ, bb.minX + this.depth - 1, spawnHeight + this.height - 1, bb.minZ + this.width - 1);
		}
	}
}