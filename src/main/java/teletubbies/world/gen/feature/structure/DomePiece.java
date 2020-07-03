package teletubbies.world.gen.feature.structure;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.ScatteredStructurePiece;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import teletubbies.Teletubbies;
import teletubbies.block.BlockList;
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
	public boolean create(IWorld world, ChunkGenerator<?> gen, Random rand, MutableBoundingBox bb, ChunkPos chunk) {
		for (int k1 = 0; k1 < this.width; ++k1) {
			for (int j = 0; j < this.depth; ++j) {
				this.replaceLiquidDownwards(world, BlockList.FULL_GRASS.getDefaultState(), k1, this.height, j, bb);
			}
		}
				
		MutableBoundingBox fullBB = this.getBoundingBox();
		Template template = manager.getTemplate(new ResourceLocation(Teletubbies.MODID, "dome"));
		if (template != null && chunk.x * 16 == fullBB.minX && chunk.z * 16 == fullBB.minZ) {
			template.addBlocksToWorldChunk(world, new BlockPos(bb.minX, this.spawnHeight, bb.minZ), new PlacementSettings());
		}
		return true;
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
	
	protected void replaceLiquidDownwards(IWorld worldIn, BlockState blockstateIn, int x, int y, int z, MutableBoundingBox boundingboxIn) {
		int i = this.getXWithOffset(x, z);
		int j = this.getYWithOffset(y);
		int k = this.getZWithOffset(x, z);
		if (boundingboxIn.isVecInside(new BlockPos(i, j, k))) {
			while (worldIn.getBlockState(new BlockPos(i, j, k)).getMaterial().isLiquid() && j > 1) {
				worldIn.setBlockState(new BlockPos(i, j, k), blockstateIn, 2);
				--j;
			}
		}
	}
}