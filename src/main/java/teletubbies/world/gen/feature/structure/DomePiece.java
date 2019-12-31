package teletubbies.world.gen.feature.structure;

import java.util.Random;

import net.minecraft.block.Blocks;
import net.minecraft.nbt.CompoundNBT;
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
import teletubbies.Teletubbies;
import teletubbies.world.gen.WorldGenList;

public class DomePiece extends ScatteredStructurePiece {
	
	private TemplateManager manager;
	private final static int BASE_HEIGHT = 70;
	
	public DomePiece(TemplateManager manager, SharedSeedRandom rand, int x, int z) {
		super(WorldGenList.DOME_PIECE, rand, x, BASE_HEIGHT, z, 16, 15, 16);
		this.manager = manager;
		// TODO dimensions in super call
	}

	public DomePiece(TemplateManager manager, CompoundNBT nbt) {
		super(WorldGenList.DOME_PIECE, nbt);
		this.manager = manager;
	}

	@Override
	public boolean addComponentParts(IWorld world, Random rand, MutableBoundingBox bb, ChunkPos chunk) {
		this.fillWithBlocks(world, bb, 0, -4, 0, this.width - 1, 0, this.depth - 1, Blocks.SANDSTONE.getDefaultState(), Blocks.SANDSTONE.getDefaultState(), false);
		Template template = manager.getTemplate(new ResourceLocation(Teletubbies.MODID, "test"));
		if (template != null) {
		
			System.out.println(chunk);
			BlockPos cp = chunk.asBlockPos();
			BlockPos pos = new BlockPos(cp.getX(), BASE_HEIGHT, cp.getZ());
			BlockPos p2 = new BlockPos(bb.minX, BASE_HEIGHT, bb.minZ);
			
			System.out.println("cp: "+ cp);
			System.out.println("pos: " + pos);
			System.out.println("p2: " + p2);

			if (chunk.asBlockPos().getX() == bb.minX && chunk.asBlockPos().getZ() == bb.minZ) {
				template.addBlocksToWorld(world, p2, new PlacementSettings());
			}
			return true;
		}
		return false;
	}
}