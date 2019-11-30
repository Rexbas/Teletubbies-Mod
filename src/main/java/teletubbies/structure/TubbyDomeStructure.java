package teletubbies.structure;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import teletubbies.block.tileentity.TileEntityTubbyToastMachine;

public class TubbyDomeStructure extends WorldGenerator {
	
	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		this.partOne(world, rand, pos);
		this.partTwo(world, rand, pos);
		this.partThree(world, rand, pos);
		
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
				
		BlockPos[] groundBlocks = {
				new BlockPos(i + 10, j + 0, k + 0),
				new BlockPos(i + 11, j + 0, k + 0),
				new BlockPos(i + 12, j + 0, k + 0),
				new BlockPos(i + 13, j + 0, k + 0),
				new BlockPos(i + 14, j + 0, k + 0),
				new BlockPos(i + 15, j + 0, k + 0),
				new BlockPos(i + 16, j + 0, k + 0),
				new BlockPos(i + 17, j + 0, k + 0),
				new BlockPos(i + 18, j + 0, k + 0),
				new BlockPos(i + 7, j + 0, k + 1),
				new BlockPos(i + 8, j + 0, k + 1),
				new BlockPos(i + 9, j + 0, k + 1),
				new BlockPos(i + 10, j + 0, k + 1),
				new BlockPos(i + 11, j + 0, k + 1),
				new BlockPos(i + 12, j + 0, k + 1),
				new BlockPos(i + 13, j + 0, k + 1),
				new BlockPos(i + 14, j + 0, k + 1),
				new BlockPos(i + 15, j + 0, k + 1),
				new BlockPos(i + 16, j + 0, k + 1),
				new BlockPos(i + 17, j + 0, k + 1),
				new BlockPos(i + 18, j + 0, k + 1),
				new BlockPos(i + 19, j + 0, k + 1),
				new BlockPos(i + 20, j + 0, k + 1),
				new BlockPos(i + 21, j + 0, k + 1),
				new BlockPos(i + 5, j + 0, k + 2),
				new BlockPos(i + 6, j + 0, k + 2),
				new BlockPos(i + 7, j + 0, k + 2),
				new BlockPos(i + 8, j + 0, k + 2),
				new BlockPos(i + 9, j + 0, k + 2),
				new BlockPos(i + 10, j + 0, k + 2),
				new BlockPos(i + 11, j + 0, k + 2),
				new BlockPos(i + 12, j + 0, k + 2),
				new BlockPos(i + 13, j + 0, k + 2),
				new BlockPos(i + 14, j + 0, k + 2),
				new BlockPos(i + 15, j + 0, k + 2),
				new BlockPos(i + 16, j + 0, k + 2),
				new BlockPos(i + 17, j + 0, k + 2),
				new BlockPos(i + 18, j + 0, k + 2),
				new BlockPos(i + 19, j + 0, k + 2),
				new BlockPos(i + 20, j + 0, k + 2),
				new BlockPos(i + 21, j + 0, k + 2),
				new BlockPos(i + 22, j + 0, k + 2),
				new BlockPos(i + 23, j + 0, k + 2),
				new BlockPos(i + 4, j + 0, k + 3),
				new BlockPos(i + 5, j + 0, k + 3),
				new BlockPos(i + 6, j + 0, k + 3),
				new BlockPos(i + 7, j + 0, k + 3),
				new BlockPos(i + 8, j + 0, k + 3),
				new BlockPos(i + 9, j + 0, k + 3),
				new BlockPos(i + 10, j + 0, k + 3),
				new BlockPos(i + 11, j + 0, k + 3),
				new BlockPos(i + 12, j + 0, k + 3),
				new BlockPos(i + 13, j + 0, k + 3),
				new BlockPos(i + 14, j + 0, k + 3),
				new BlockPos(i + 15, j + 0, k + 3),
				new BlockPos(i + 16, j + 0, k + 3),
				new BlockPos(i + 17, j + 0, k + 3),
				new BlockPos(i + 18, j + 0, k + 3),
				new BlockPos(i + 19, j + 0, k + 3),
				new BlockPos(i + 20, j + 0, k + 3),
				new BlockPos(i + 21, j + 0, k + 3),
				new BlockPos(i + 22, j + 0, k + 3),
				new BlockPos(i + 23, j + 0, k + 3),
				new BlockPos(i + 24, j + 0, k + 3),
				new BlockPos(i + 3, j + 0, k + 4),
				new BlockPos(i + 4, j + 0, k + 4),
				new BlockPos(i + 5, j + 0, k + 4),
				new BlockPos(i + 6, j + 0, k + 4),
				new BlockPos(i + 7, j + 0, k + 4),
				new BlockPos(i + 8, j + 0, k + 4),
				new BlockPos(i + 9, j + 0, k + 4),
				new BlockPos(i + 10, j + 0, k + 4),
				new BlockPos(i + 11, j + 0, k + 4),
				new BlockPos(i + 12, j + 0, k + 4),
				new BlockPos(i + 13, j + 0, k + 4),
				new BlockPos(i + 14, j + 0, k + 4),
				new BlockPos(i + 15, j + 0, k + 4),
				new BlockPos(i + 16, j + 0, k + 4),
				new BlockPos(i + 17, j + 0, k + 4),
				new BlockPos(i + 18, j + 0, k + 4),
				new BlockPos(i + 19, j + 0, k + 4),
				new BlockPos(i + 20, j + 0, k + 4),
				new BlockPos(i + 21, j + 0, k + 4),
				new BlockPos(i + 22, j + 0, k + 4),
				new BlockPos(i + 23, j + 0, k + 4),
				new BlockPos(i + 24, j + 0, k + 4),
				new BlockPos(i + 25, j + 0, k + 4),
				new BlockPos(i + 3, j + 0, k + 5),
				new BlockPos(i + 4, j + 0, k + 5),
				new BlockPos(i + 5, j + 0, k + 5),
				new BlockPos(i + 6, j + 0, k + 5),
				new BlockPos(i + 7, j + 0, k + 5),
				new BlockPos(i + 8, j + 0, k + 5),
				new BlockPos(i + 9, j + 0, k + 5),
				new BlockPos(i + 10, j + 0, k + 5),
				new BlockPos(i + 11, j + 0, k + 5),
				new BlockPos(i + 12, j + 0, k + 5),
				new BlockPos(i + 13, j + 0, k + 5),
				new BlockPos(i + 14, j + 0, k + 5),
				new BlockPos(i + 15, j + 0, k + 5),
				new BlockPos(i + 16, j + 0, k + 5),
				new BlockPos(i + 17, j + 0, k + 5),
				new BlockPos(i + 18, j + 0, k + 5),
				new BlockPos(i + 19, j + 0, k + 5),
				new BlockPos(i + 20, j + 0, k + 5),
				new BlockPos(i + 21, j + 0, k + 5),
				new BlockPos(i + 22, j + 0, k + 5),
				new BlockPos(i + 23, j + 0, k + 5),
				new BlockPos(i + 24, j + 0, k + 5),
				new BlockPos(i + 25, j + 0, k + 5),
				new BlockPos(i + 2, j + 0, k + 6),
				new BlockPos(i + 3, j + 0, k + 6),
				new BlockPos(i + 4, j + 0, k + 6),
				new BlockPos(i + 5, j + 0, k + 6),
				new BlockPos(i + 6, j + 0, k + 6),
				new BlockPos(i + 7, j + 0, k + 6),
				new BlockPos(i + 8, j + 0, k + 6),
				new BlockPos(i + 9, j + 0, k + 6),
				new BlockPos(i + 10, j + 0, k + 6),
				new BlockPos(i + 11, j + 0, k + 6),
				new BlockPos(i + 12, j + 0, k + 6),
				new BlockPos(i + 13, j + 0, k + 6),
				new BlockPos(i + 14, j + 0, k + 6),
				new BlockPos(i + 15, j + 0, k + 6),
				new BlockPos(i + 16, j + 0, k + 6),
				new BlockPos(i + 17, j + 0, k + 6),
				new BlockPos(i + 18, j + 0, k + 6),
				new BlockPos(i + 19, j + 0, k + 6),
				new BlockPos(i + 20, j + 0, k + 6),
				new BlockPos(i + 21, j + 0, k + 6),
				new BlockPos(i + 22, j + 0, k + 6),
				new BlockPos(i + 23, j + 0, k + 6),
				new BlockPos(i + 24, j + 0, k + 6),
				new BlockPos(i + 25, j + 0, k + 6),
				new BlockPos(i + 26, j + 0, k + 6),
				new BlockPos(i + 2, j + 0, k + 7),
				new BlockPos(i + 3, j + 0, k + 7),
				new BlockPos(i + 4, j + 0, k + 7),
				new BlockPos(i + 5, j + 0, k + 7),
				new BlockPos(i + 6, j + 0, k + 7),
				new BlockPos(i + 7, j + 0, k + 7),
				new BlockPos(i + 8, j + 0, k + 7),
				new BlockPos(i + 9, j + 0, k + 7),
				new BlockPos(i + 10, j + 0, k + 7),
				new BlockPos(i + 11, j + 0, k + 7),
				new BlockPos(i + 12, j + 0, k + 7),
				new BlockPos(i + 13, j + 0, k + 7),
				new BlockPos(i + 14, j + 0, k + 7),
				new BlockPos(i + 15, j + 0, k + 7),
				new BlockPos(i + 16, j + 0, k + 7),
				new BlockPos(i + 17, j + 0, k + 7),
				new BlockPos(i + 18, j + 0, k + 7),
				new BlockPos(i + 19, j + 0, k + 7),
				new BlockPos(i + 20, j + 0, k + 7),
				new BlockPos(i + 21, j + 0, k + 7),
				new BlockPos(i + 22, j + 0, k + 7),
				new BlockPos(i + 23, j + 0, k + 7),
				new BlockPos(i + 24, j + 0, k + 7),
				new BlockPos(i + 25, j + 0, k + 7),
				new BlockPos(i + 26, j + 0, k + 7),
				new BlockPos(i + 2, j + 0, k + 8),
				new BlockPos(i + 3, j + 0, k + 8),
				new BlockPos(i + 4, j + 0, k + 8),
				new BlockPos(i + 5, j + 0, k + 8),
				new BlockPos(i + 6, j + 0, k + 8),
				new BlockPos(i + 7, j + 0, k + 8),
				new BlockPos(i + 8, j + 0, k + 8),
				new BlockPos(i + 9, j + 0, k + 8),
				new BlockPos(i + 10, j + 0, k + 8),
				new BlockPos(i + 11, j + 0, k + 8),
				new BlockPos(i + 12, j + 0, k + 8),
				new BlockPos(i + 13, j + 0, k + 8),
				new BlockPos(i + 14, j + 0, k + 8),
				new BlockPos(i + 15, j + 0, k + 8),
				new BlockPos(i + 16, j + 0, k + 8),
				new BlockPos(i + 17, j + 0, k + 8),
				new BlockPos(i + 18, j + 0, k + 8),
				new BlockPos(i + 19, j + 0, k + 8),
				new BlockPos(i + 20, j + 0, k + 8),
				new BlockPos(i + 21, j + 0, k + 8),
				new BlockPos(i + 22, j + 0, k + 8),
				new BlockPos(i + 23, j + 0, k + 8),
				new BlockPos(i + 24, j + 0, k + 8),
				new BlockPos(i + 25, j + 0, k + 8),
				new BlockPos(i + 26, j + 0, k + 8),
				new BlockPos(i + 1, j + 0, k + 9),
				new BlockPos(i + 2, j + 0, k + 9),
				new BlockPos(i + 3, j + 0, k + 9),
				new BlockPos(i + 4, j + 0, k + 9),
				new BlockPos(i + 5, j + 0, k + 9),
				new BlockPos(i + 6, j + 0, k + 9),
				new BlockPos(i + 7, j + 0, k + 9),
				new BlockPos(i + 8, j + 0, k + 9),
				new BlockPos(i + 9, j + 0, k + 9),
				new BlockPos(i + 10, j + 0, k + 9),
				new BlockPos(i + 11, j + 0, k + 9),
				new BlockPos(i + 12, j + 0, k + 9),
				new BlockPos(i + 13, j + 0, k + 9),
				new BlockPos(i + 14, j + 0, k + 9),
				new BlockPos(i + 15, j + 0, k + 9),
				new BlockPos(i + 16, j + 0, k + 9),
				new BlockPos(i + 17, j + 0, k + 9),
				new BlockPos(i + 18, j + 0, k + 9),
				new BlockPos(i + 19, j + 0, k + 9),
				new BlockPos(i + 20, j + 0, k + 9),
				new BlockPos(i + 21, j + 0, k + 9),
				new BlockPos(i + 22, j + 0, k + 9),
				new BlockPos(i + 23, j + 0, k + 9),
				new BlockPos(i + 24, j + 0, k + 9),
				new BlockPos(i + 25, j + 0, k + 9),
				new BlockPos(i + 26, j + 0, k + 9),
				new BlockPos(i + 27, j + 0, k + 9),
				new BlockPos(i + 1, j + 0, k + 10),
				new BlockPos(i + 2, j + 0, k + 10),
				new BlockPos(i + 3, j + 0, k + 10),
				new BlockPos(i + 4, j + 0, k + 10),
				new BlockPos(i + 5, j + 0, k + 10),
				new BlockPos(i + 6, j + 0, k + 10),
				new BlockPos(i + 7, j + 0, k + 10),
				new BlockPos(i + 8, j + 0, k + 10),
				new BlockPos(i + 9, j + 0, k + 10),
				new BlockPos(i + 10, j + 0, k + 10),
				new BlockPos(i + 11, j + 0, k + 10),
				new BlockPos(i + 12, j + 0, k + 10),
				new BlockPos(i + 13, j + 0, k + 10),
				new BlockPos(i + 14, j + 0, k + 10),
				new BlockPos(i + 15, j + 0, k + 10),
				new BlockPos(i + 16, j + 0, k + 10),
				new BlockPos(i + 17, j + 0, k + 10),
				new BlockPos(i + 18, j + 0, k + 10),
				new BlockPos(i + 19, j + 0, k + 10),
				new BlockPos(i + 20, j + 0, k + 10),
				new BlockPos(i + 21, j + 0, k + 10),
				new BlockPos(i + 22, j + 0, k + 10),
				new BlockPos(i + 23, j + 0, k + 10),
				new BlockPos(i + 24, j + 0, k + 10),
				new BlockPos(i + 25, j + 0, k + 10),
				new BlockPos(i + 26, j + 0, k + 10),
				new BlockPos(i + 27, j + 0, k + 10),
				new BlockPos(i + 1, j + 0, k + 11),
				new BlockPos(i + 2, j + 0, k + 11),
				new BlockPos(i + 3, j + 0, k + 11),
				new BlockPos(i + 4, j + 0, k + 11),
				new BlockPos(i + 5, j + 0, k + 11),
				new BlockPos(i + 6, j + 0, k + 11),
				new BlockPos(i + 7, j + 0, k + 11),
				new BlockPos(i + 8, j + 0, k + 11),
				new BlockPos(i + 9, j + 0, k + 11),
				new BlockPos(i + 10, j + 0, k + 11),
				new BlockPos(i + 11, j + 0, k + 11),
				new BlockPos(i + 12, j + 0, k + 11),
				new BlockPos(i + 13, j + 0, k + 11),
				new BlockPos(i + 14, j + 0, k + 11),
				new BlockPos(i + 15, j + 0, k + 11),
				new BlockPos(i + 16, j + 0, k + 11),
				new BlockPos(i + 17, j + 0, k + 11),
				new BlockPos(i + 18, j + 0, k + 11),
				new BlockPos(i + 19, j + 0, k + 11),
				new BlockPos(i + 20, j + 0, k + 11),
				new BlockPos(i + 21, j + 0, k + 11),
				new BlockPos(i + 22, j + 0, k + 11),
				new BlockPos(i + 23, j + 0, k + 11),
				new BlockPos(i + 24, j + 0, k + 11),
				new BlockPos(i + 25, j + 0, k + 11),
				new BlockPos(i + 26, j + 0, k + 11),
				new BlockPos(i + 27, j + 0, k + 11),
				new BlockPos(i + 0, j + 0, k + 12),
				new BlockPos(i + 1, j + 0, k + 12),
				new BlockPos(i + 2, j + 0, k + 12),
				new BlockPos(i + 3, j + 0, k + 12),
				new BlockPos(i + 4, j + 0, k + 12),
				new BlockPos(i + 5, j + 0, k + 12),
				new BlockPos(i + 6, j + 0, k + 12),
				new BlockPos(i + 7, j + 0, k + 12),
				new BlockPos(i + 8, j + 0, k + 12),
				new BlockPos(i + 9, j + 0, k + 12),
				new BlockPos(i + 10, j + 0, k + 12),
				new BlockPos(i + 11, j + 0, k + 12),
				new BlockPos(i + 12, j + 0, k + 12),
				new BlockPos(i + 13, j + 0, k + 12),
				new BlockPos(i + 14, j + 0, k + 12),
				new BlockPos(i + 15, j + 0, k + 12),
				new BlockPos(i + 16, j + 0, k + 12),
				new BlockPos(i + 17, j + 0, k + 12),
				new BlockPos(i + 18, j + 0, k + 12),
				new BlockPos(i + 19, j + 0, k + 12),
				new BlockPos(i + 20, j + 0, k + 12),
				new BlockPos(i + 21, j + 0, k + 12),
				new BlockPos(i + 22, j + 0, k + 12),
				new BlockPos(i + 23, j + 0, k + 12),
				new BlockPos(i + 24, j + 0, k + 12),
				new BlockPos(i + 25, j + 0, k + 12),
				new BlockPos(i + 26, j + 0, k + 12),
				new BlockPos(i + 27, j + 0, k + 12),
				new BlockPos(i + 28, j + 0, k + 12),
				new BlockPos(i + 0, j + 0, k + 13),
				new BlockPos(i + 1, j + 0, k + 13),
				new BlockPos(i + 2, j + 0, k + 13),
				new BlockPos(i + 3, j + 0, k + 13),
				new BlockPos(i + 4, j + 0, k + 13),
				new BlockPos(i + 5, j + 0, k + 13),
				new BlockPos(i + 6, j + 0, k + 13),
				new BlockPos(i + 7, j + 0, k + 13),
				new BlockPos(i + 8, j + 0, k + 13),
				new BlockPos(i + 9, j + 0, k + 13),
				new BlockPos(i + 10, j + 0, k + 13),
				new BlockPos(i + 11, j + 0, k + 13),
				new BlockPos(i + 12, j + 0, k + 13),
				new BlockPos(i + 13, j + 0, k + 13),
				new BlockPos(i + 14, j + 0, k + 13),
				new BlockPos(i + 15, j + 0, k + 13),
				new BlockPos(i + 16, j + 0, k + 13),
				new BlockPos(i + 17, j + 0, k + 13),
				new BlockPos(i + 18, j + 0, k + 13),
				new BlockPos(i + 19, j + 0, k + 13),
				new BlockPos(i + 20, j + 0, k + 13),
				new BlockPos(i + 21, j + 0, k + 13),
				new BlockPos(i + 22, j + 0, k + 13),
				new BlockPos(i + 23, j + 0, k + 13),
				new BlockPos(i + 24, j + 0, k + 13),
				new BlockPos(i + 25, j + 0, k + 13),
				new BlockPos(i + 26, j + 0, k + 13),
				new BlockPos(i + 27, j + 0, k + 13),
				new BlockPos(i + 28, j + 0, k + 13),
				new BlockPos(i + 0, j + 0, k + 14),
				new BlockPos(i + 1, j + 0, k + 14),
				new BlockPos(i + 2, j + 0, k + 14),
				new BlockPos(i + 3, j + 0, k + 14),
				new BlockPos(i + 4, j + 0, k + 14),
				new BlockPos(i + 5, j + 0, k + 14),
				new BlockPos(i + 6, j + 0, k + 14),
				new BlockPos(i + 7, j + 0, k + 14),
				new BlockPos(i + 8, j + 0, k + 14),
				new BlockPos(i + 9, j + 0, k + 14),
				new BlockPos(i + 10, j + 0, k + 14),
				new BlockPos(i + 11, j + 0, k + 14),
				new BlockPos(i + 12, j + 0, k + 14),
				new BlockPos(i + 13, j + 0, k + 14),
				new BlockPos(i + 14, j + 0, k + 14),
				new BlockPos(i + 15, j + 0, k + 14),
				new BlockPos(i + 16, j + 0, k + 14),
				new BlockPos(i + 17, j + 0, k + 14),
				new BlockPos(i + 18, j + 0, k + 14),
				new BlockPos(i + 19, j + 0, k + 14),
				new BlockPos(i + 20, j + 0, k + 14),
				new BlockPos(i + 21, j + 0, k + 14),
				new BlockPos(i + 22, j + 0, k + 14),
				new BlockPos(i + 23, j + 0, k + 14),
				new BlockPos(i + 24, j + 0, k + 14),
				new BlockPos(i + 25, j + 0, k + 14),
				new BlockPos(i + 26, j + 0, k + 14),
				new BlockPos(i + 27, j + 0, k + 14),
				new BlockPos(i + 28, j + 0, k + 14),
				new BlockPos(i + 1, j + 0, k + 15),
				new BlockPos(i + 2, j + 0, k + 15),
				new BlockPos(i + 3, j + 0, k + 15),
				new BlockPos(i + 4, j + 0, k + 15),
				new BlockPos(i + 5, j + 0, k + 15),
				new BlockPos(i + 6, j + 0, k + 15),
				new BlockPos(i + 7, j + 0, k + 15),
				new BlockPos(i + 8, j + 0, k + 15),
				new BlockPos(i + 9, j + 0, k + 15),
				new BlockPos(i + 10, j + 0, k + 15),
				new BlockPos(i + 11, j + 0, k + 15),
				new BlockPos(i + 12, j + 0, k + 15),
				new BlockPos(i + 13, j + 0, k + 15),
				new BlockPos(i + 14, j + 0, k + 15),
				new BlockPos(i + 15, j + 0, k + 15),
				new BlockPos(i + 16, j + 0, k + 15),
				new BlockPos(i + 17, j + 0, k + 15),
				new BlockPos(i + 18, j + 0, k + 15),
				new BlockPos(i + 19, j + 0, k + 15),
				new BlockPos(i + 20, j + 0, k + 15),
				new BlockPos(i + 21, j + 0, k + 15),
				new BlockPos(i + 22, j + 0, k + 15),
				new BlockPos(i + 23, j + 0, k + 15),
				new BlockPos(i + 24, j + 0, k + 15),
				new BlockPos(i + 25, j + 0, k + 15),
				new BlockPos(i + 26, j + 0, k + 15),
				new BlockPos(i + 27, j + 0, k + 15),
				new BlockPos(i + 1, j + 0, k + 16),
				new BlockPos(i + 2, j + 0, k + 16),
				new BlockPos(i + 3, j + 0, k + 16),
				new BlockPos(i + 4, j + 0, k + 16),
				new BlockPos(i + 5, j + 0, k + 16),
				new BlockPos(i + 6, j + 0, k + 16),
				new BlockPos(i + 7, j + 0, k + 16),
				new BlockPos(i + 8, j + 0, k + 16),
				new BlockPos(i + 9, j + 0, k + 16),
				new BlockPos(i + 10, j + 0, k + 16),
				new BlockPos(i + 11, j + 0, k + 16),
				new BlockPos(i + 12, j + 0, k + 16),
				new BlockPos(i + 13, j + 0, k + 16),
				new BlockPos(i + 14, j + 0, k + 16),
				new BlockPos(i + 15, j + 0, k + 16),
				new BlockPos(i + 16, j + 0, k + 16),
				new BlockPos(i + 17, j + 0, k + 16),
				new BlockPos(i + 18, j + 0, k + 16),
				new BlockPos(i + 19, j + 0, k + 16),
				new BlockPos(i + 20, j + 0, k + 16),
				new BlockPos(i + 21, j + 0, k + 16),
				new BlockPos(i + 22, j + 0, k + 16),
				new BlockPos(i + 23, j + 0, k + 16),
				new BlockPos(i + 24, j + 0, k + 16),
				new BlockPos(i + 25, j + 0, k + 16),
				new BlockPos(i + 26, j + 0, k + 16),
				new BlockPos(i + 27, j + 0, k + 16),
				new BlockPos(i + 1, j + 0, k + 17),
				new BlockPos(i + 2, j + 0, k + 17),
				new BlockPos(i + 3, j + 0, k + 17),
				new BlockPos(i + 4, j + 0, k + 17),
				new BlockPos(i + 5, j + 0, k + 17),
				new BlockPos(i + 6, j + 0, k + 17),
				new BlockPos(i + 7, j + 0, k + 17),
				new BlockPos(i + 8, j + 0, k + 17),
				new BlockPos(i + 9, j + 0, k + 17),
				new BlockPos(i + 10, j + 0, k + 17),
				new BlockPos(i + 11, j + 0, k + 17),
				new BlockPos(i + 12, j + 0, k + 17),
				new BlockPos(i + 13, j + 0, k + 17),
				new BlockPos(i + 14, j + 0, k + 17),
				new BlockPos(i + 15, j + 0, k + 17),
				new BlockPos(i + 16, j + 0, k + 17),
				new BlockPos(i + 17, j + 0, k + 17),
				new BlockPos(i + 18, j + 0, k + 17),
				new BlockPos(i + 19, j + 0, k + 17),
				new BlockPos(i + 20, j + 0, k + 17),
				new BlockPos(i + 21, j + 0, k + 17),
				new BlockPos(i + 22, j + 0, k + 17),
				new BlockPos(i + 23, j + 0, k + 17),
				new BlockPos(i + 24, j + 0, k + 17),
				new BlockPos(i + 25, j + 0, k + 17),
				new BlockPos(i + 26, j + 0, k + 17),
				new BlockPos(i + 27, j + 0, k + 17),
				new BlockPos(i + 2, j + 0, k + 18),
				new BlockPos(i + 3, j + 0, k + 18),
				new BlockPos(i + 4, j + 0, k + 18),
				new BlockPos(i + 5, j + 0, k + 18),
				new BlockPos(i + 6, j + 0, k + 18),
				new BlockPos(i + 7, j + 0, k + 18),
				new BlockPos(i + 8, j + 0, k + 18),
				new BlockPos(i + 9, j + 0, k + 18),
				new BlockPos(i + 10, j + 0, k + 18),
				new BlockPos(i + 11, j + 0, k + 18),
				new BlockPos(i + 12, j + 0, k + 18),
				new BlockPos(i + 13, j + 0, k + 18),
				new BlockPos(i + 14, j + 0, k + 18),
				new BlockPos(i + 15, j + 0, k + 18),
				new BlockPos(i + 16, j + 0, k + 18),
				new BlockPos(i + 17, j + 0, k + 18),
				new BlockPos(i + 18, j + 0, k + 18),
				new BlockPos(i + 19, j + 0, k + 18),
				new BlockPos(i + 20, j + 0, k + 18),
				new BlockPos(i + 21, j + 0, k + 18),
				new BlockPos(i + 22, j + 0, k + 18),
				new BlockPos(i + 23, j + 0, k + 18),
				new BlockPos(i + 24, j + 0, k + 18),
				new BlockPos(i + 25, j + 0, k + 18),
				new BlockPos(i + 26, j + 0, k + 18),
				new BlockPos(i + 2, j + 0, k + 19),
				new BlockPos(i + 3, j + 0, k + 19),
				new BlockPos(i + 4, j + 0, k + 19),
				new BlockPos(i + 5, j + 0, k + 19),
				new BlockPos(i + 6, j + 0, k + 19),
				new BlockPos(i + 7, j + 0, k + 19),
				new BlockPos(i + 8, j + 0, k + 19),
				new BlockPos(i + 9, j + 0, k + 19),
				new BlockPos(i + 10, j + 0, k + 19),
				new BlockPos(i + 11, j + 0, k + 19),
				new BlockPos(i + 12, j + 0, k + 19),
				new BlockPos(i + 13, j + 0, k + 19),
				new BlockPos(i + 14, j + 0, k + 19),
				new BlockPos(i + 15, j + 0, k + 19),
				new BlockPos(i + 16, j + 0, k + 19),
				new BlockPos(i + 17, j + 0, k + 19),
				new BlockPos(i + 18, j + 0, k + 19),
				new BlockPos(i + 19, j + 0, k + 19),
				new BlockPos(i + 20, j + 0, k + 19),
				new BlockPos(i + 21, j + 0, k + 19),
				new BlockPos(i + 22, j + 0, k + 19),
				new BlockPos(i + 23, j + 0, k + 19),
				new BlockPos(i + 24, j + 0, k + 19),
				new BlockPos(i + 25, j + 0, k + 19),
				new BlockPos(i + 26, j + 0, k + 19),
				new BlockPos(i + 2, j + 0, k + 20),
				new BlockPos(i + 3, j + 0, k + 20),
				new BlockPos(i + 4, j + 0, k + 20),
				new BlockPos(i + 5, j + 0, k + 20),
				new BlockPos(i + 6, j + 0, k + 20),
				new BlockPos(i + 7, j + 0, k + 20),
				new BlockPos(i + 8, j + 0, k + 20),
				new BlockPos(i + 9, j + 0, k + 20),
				new BlockPos(i + 10, j + 0, k + 20),
				new BlockPos(i + 11, j + 0, k + 20),
				new BlockPos(i + 12, j + 0, k + 20),
				new BlockPos(i + 13, j + 0, k + 20),
				new BlockPos(i + 14, j + 0, k + 20),
				new BlockPos(i + 15, j + 0, k + 20),
				new BlockPos(i + 16, j + 0, k + 20),
				new BlockPos(i + 17, j + 0, k + 20),
				new BlockPos(i + 18, j + 0, k + 20),
				new BlockPos(i + 19, j + 0, k + 20),
				new BlockPos(i + 20, j + 0, k + 20),
				new BlockPos(i + 21, j + 0, k + 20),
				new BlockPos(i + 22, j + 0, k + 20),
				new BlockPos(i + 23, j + 0, k + 20),
				new BlockPos(i + 24, j + 0, k + 20),
				new BlockPos(i + 25, j + 0, k + 20),
				new BlockPos(i + 26, j + 0, k + 20),
				new BlockPos(i + 3, j + 0, k + 21),
				new BlockPos(i + 4, j + 0, k + 21),
				new BlockPos(i + 5, j + 0, k + 21),
				new BlockPos(i + 6, j + 0, k + 21),
				new BlockPos(i + 7, j + 0, k + 21),
				new BlockPos(i + 8, j + 0, k + 21),
				new BlockPos(i + 9, j + 0, k + 21),
				new BlockPos(i + 10, j + 0, k + 21),
				new BlockPos(i + 11, j + 0, k + 21),
				new BlockPos(i + 12, j + 0, k + 21),
				new BlockPos(i + 13, j + 0, k + 21),
				new BlockPos(i + 14, j + 0, k + 21),
				new BlockPos(i + 15, j + 0, k + 21),
				new BlockPos(i + 16, j + 0, k + 21),
				new BlockPos(i + 17, j + 0, k + 21),
				new BlockPos(i + 18, j + 0, k + 21),
				new BlockPos(i + 19, j + 0, k + 21),
				new BlockPos(i + 20, j + 0, k + 21),
				new BlockPos(i + 21, j + 0, k + 21),
				new BlockPos(i + 22, j + 0, k + 21),
				new BlockPos(i + 23, j + 0, k + 21),
				new BlockPos(i + 24, j + 0, k + 21),
				new BlockPos(i + 25, j + 0, k + 21),
				new BlockPos(i + 3, j + 0, k + 22),
				new BlockPos(i + 4, j + 0, k + 22),
				new BlockPos(i + 5, j + 0, k + 22),
				new BlockPos(i + 6, j + 0, k + 22),
				new BlockPos(i + 7, j + 0, k + 22),
				new BlockPos(i + 8, j + 0, k + 22),
				new BlockPos(i + 9, j + 0, k + 22),
				new BlockPos(i + 10, j + 0, k + 22),
				new BlockPos(i + 11, j + 0, k + 22),
				new BlockPos(i + 12, j + 0, k + 22),
				new BlockPos(i + 13, j + 0, k + 22),
				new BlockPos(i + 14, j + 0, k + 22),
				new BlockPos(i + 15, j + 0, k + 22),
				new BlockPos(i + 16, j + 0, k + 22),
				new BlockPos(i + 17, j + 0, k + 22),
				new BlockPos(i + 18, j + 0, k + 22),
				new BlockPos(i + 19, j + 0, k + 22),
				new BlockPos(i + 20, j + 0, k + 22),
				new BlockPos(i + 21, j + 0, k + 22),
				new BlockPos(i + 22, j + 0, k + 22),
				new BlockPos(i + 23, j + 0, k + 22),
				new BlockPos(i + 24, j + 0, k + 22),
				new BlockPos(i + 25, j + 0, k + 22),
				new BlockPos(i + 4, j + 0, k + 23),
				new BlockPos(i + 5, j + 0, k + 23),
				new BlockPos(i + 6, j + 0, k + 23),
				new BlockPos(i + 7, j + 0, k + 23),
				new BlockPos(i + 8, j + 0, k + 23),
				new BlockPos(i + 9, j + 0, k + 23),
				new BlockPos(i + 10, j + 0, k + 23),
				new BlockPos(i + 11, j + 0, k + 23),
				new BlockPos(i + 12, j + 0, k + 23),
				new BlockPos(i + 13, j + 0, k + 23),
				new BlockPos(i + 14, j + 0, k + 23),
				new BlockPos(i + 15, j + 0, k + 23),
				new BlockPos(i + 16, j + 0, k + 23),
				new BlockPos(i + 17, j + 0, k + 23),
				new BlockPos(i + 18, j + 0, k + 23),
				new BlockPos(i + 19, j + 0, k + 23),
				new BlockPos(i + 20, j + 0, k + 23),
				new BlockPos(i + 21, j + 0, k + 23),
				new BlockPos(i + 22, j + 0, k + 23),
				new BlockPos(i + 23, j + 0, k + 23),
				new BlockPos(i + 24, j + 0, k + 23),
				new BlockPos(i + 5, j + 0, k + 24),
				new BlockPos(i + 6, j + 0, k + 24),
				new BlockPos(i + 7, j + 0, k + 24),
				new BlockPos(i + 8, j + 0, k + 24),
				new BlockPos(i + 9, j + 0, k + 24),
				new BlockPos(i + 10, j + 0, k + 24),
				new BlockPos(i + 11, j + 0, k + 24),
				new BlockPos(i + 12, j + 0, k + 24),
				new BlockPos(i + 13, j + 0, k + 24),
				new BlockPos(i + 14, j + 0, k + 24),
				new BlockPos(i + 15, j + 0, k + 24),
				new BlockPos(i + 16, j + 0, k + 24),
				new BlockPos(i + 17, j + 0, k + 24),
				new BlockPos(i + 18, j + 0, k + 24),
				new BlockPos(i + 19, j + 0, k + 24),
				new BlockPos(i + 20, j + 0, k + 24),
				new BlockPos(i + 21, j + 0, k + 24),
				new BlockPos(i + 22, j + 0, k + 24),
				new BlockPos(i + 23, j + 0, k + 24),
				new BlockPos(i + 7, j + 0, k + 25),
				new BlockPos(i + 8, j + 0, k + 25),
				new BlockPos(i + 9, j + 0, k + 25),
				new BlockPos(i + 10, j + 0, k + 25),
				new BlockPos(i + 11, j + 0, k + 25),
				new BlockPos(i + 12, j + 0, k + 25),
				new BlockPos(i + 13, j + 0, k + 25),
				new BlockPos(i + 14, j + 0, k + 25),
				new BlockPos(i + 15, j + 0, k + 25),
				new BlockPos(i + 16, j + 0, k + 25),
				new BlockPos(i + 17, j + 0, k + 25),
				new BlockPos(i + 18, j + 0, k + 25),
				new BlockPos(i + 19, j + 0, k + 25),
				new BlockPos(i + 20, j + 0, k + 25),
				new BlockPos(i + 21, j + 0, k + 25),
				new BlockPos(i + 11, j + 0, k + 26),
				new BlockPos(i + 12, j + 0, k + 26),
				new BlockPos(i + 13, j + 0, k + 26),
				new BlockPos(i + 14, j + 0, k + 26),
				new BlockPos(i + 15, j + 0, k + 26),
				new BlockPos(i + 16, j + 0, k + 26),
				new BlockPos(i + 17, j + 0, k + 26),
				new BlockPos(i + 12, j + 0, k + 27),
				new BlockPos(i + 13, j + 0, k + 27),
				new BlockPos(i + 14, j + 0, k + 27),
				new BlockPos(i + 15, j + 0, k + 27),
				new BlockPos(i + 16, j + 0, k + 27)};
		
		for(BlockPos pos1 : groundBlocks) {
			int x = pos1.getX();
			int y = pos1.getY() - 1;
			int z = pos1.getZ();
			
			BlockPos scanPos = new BlockPos(x, y, z);
			Block block = world.getBlockState(scanPos).getBlock();
			
			while(block instanceof BlockAir || block instanceof BlockBush || block instanceof BlockLiquid) {
				IBlockState state = Blocks.DIRT.getDefaultState();
				world.setBlockState(scanPos, state);
				y -=1; 
				scanPos = new BlockPos(x, y, z);
				block = world.getBlockState(scanPos).getBlock();
			}
		}

		return true;
	}
	
	
	private void partOne(World world, Random rand, BlockPos pos) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 27, j + 0, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 27, j + 0, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 27, j + 0, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 27, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 28, j + 0, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 27, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 28, j + 0, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 0, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 27, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 28, j + 0, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 27, j + 0, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 27, j + 0, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 27, j + 0, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 26, j + 0, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 25, j + 0, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 0, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 0, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 0, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 0, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 26), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 26), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 0, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 0, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 0, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 0, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 0, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 0, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 0), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);

		world.setBlockState(new BlockPos(i + 14, j + 1, k + 4), Teletubbies.tubbyCustardMachine.getStateFromMeta(2), 3);
		TileEntityTubbyCustardMachine te0 = (TileEntityTubbyCustardMachine) world.getTileEntity(new BlockPos(i + 14, j + 1, k + 4));
		te0.setMasterData(i + 14, j + 1, k + 4, true, EnumFacing.NORTH.getHorizontalIndex());
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 4), Teletubbies.tubbyCustardMachine.getStateFromMeta(6), 3);
		TileEntityTubbyCustardMachine te1 = (TileEntityTubbyCustardMachine) world.getTileEntity(new BlockPos(i + 13, j + 1, k + 4));
		te1.setMasterData(i + 14, j + 1, k + 4, false, EnumFacing.NORTH.getHorizontalIndex());
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 4), Teletubbies.tubbyCustardMachine.getStateFromMeta(6), 3);
		TileEntityTubbyCustardMachine te2 = (TileEntityTubbyCustardMachine) world.getTileEntity(new BlockPos(i + 15, j + 1, k + 4));
		te2.setMasterData(i + 14, j + 1, k + 4, false, EnumFacing.NORTH.getHorizontalIndex());
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 4), Teletubbies.tubbyCustardMachine.getStateFromMeta(6), 3);
		TileEntityTubbyCustardMachine te3 = (TileEntityTubbyCustardMachine) world.getTileEntity(new BlockPos(i + 13, j + 2, k + 4));
		te3.setMasterData(i + 14, j + 1, k + 4, false, EnumFacing.NORTH.getHorizontalIndex());
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 4), Teletubbies.tubbyCustardMachine.getStateFromMeta(6), 3);
		TileEntityTubbyCustardMachine te4 = (TileEntityTubbyCustardMachine) world.getTileEntity(new BlockPos(i + 15, j + 2, k + 4));
		te4.setMasterData(i + 14, j + 1, k + 4, false, EnumFacing.NORTH.getHorizontalIndex());
		
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 9), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 9), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 9), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 9), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 9), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 1, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 10), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 10), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 10), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 10), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 10), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 10), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 10), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 1, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 11), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 11), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 11), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 11), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 11), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 11), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 11), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 11), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 11), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 1, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 12), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 12), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 12), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 12), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 12), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 12), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 12), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 12), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 12), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 1, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 28, j + 1, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 13), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 13), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 13), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 13), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 13), Block.getBlockById(42).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 13), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 13), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 13), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 13), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 1, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 28, j + 1, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 0, j + 1, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 14), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 14), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 14), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 14), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 14), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 14), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 14), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 14), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 14), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 1, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 28, j + 1, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 15), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 15), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 15), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 15), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 15), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 15), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 15), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 15), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 1, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 16), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 16), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 16), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 16), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 16), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 16), Block.getBlockById(43).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 16), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 1, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 1, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 17), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 17), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 17), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 17), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 17), Block.getBlockById(44).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 17), Block.getBlockById(35).getStateFromMeta(11), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 17), Block.getBlockById(35).getStateFromMeta(11), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 1, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 19), Block.getBlockById(35).getStateFromMeta(11), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 19), Block.getBlockById(35).getStateFromMeta(11), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 1, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 26, j + 1, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);

		world.setBlockState(new BlockPos(i + 6, j + 1, k + 21), Teletubbies.tubbyToastMachine.getStateFromMeta(1), 3);
		TileEntityTubbyToastMachine te5 = (TileEntityTubbyToastMachine) world.getTileEntity(new BlockPos(i + 6, j + 1, k + 21));
		te5.setMasterData(i + 6, j + 1, k + 21, true);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 21), Teletubbies.tubbyToastMachine.getStateFromMeta(5), 3);
		TileEntityTubbyToastMachine te6 = (TileEntityTubbyToastMachine) world.getTileEntity(new BlockPos(i + 6, j + 2, k + 21));
		te6.setMasterData(i + 6, j + 1, k + 21, false);
		
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 1, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 22), Block.getBlockById(35).getStateFromMeta(11), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 22), Block.getBlockById(35).getStateFromMeta(11), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 25, j + 1, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 1, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 23), Block.getBlockById(35).getStateFromMeta(11), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 23), Block.getBlockById(35).getStateFromMeta(11), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 24, j + 1, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 24), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 24), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 24), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 1, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 25), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 25), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 25), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 1, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 1, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 26), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 26), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 26), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 1, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 1, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 1, k + 27), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 1, k + 27), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 1, k + 27), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 1, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 1), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 1), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 1), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 3), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 3), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 4), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 4), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 2, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 2, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 2, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 12), Block.getBlockById(151).getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 12), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 12), Block.getBlockById(151).getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 2, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 2, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 2, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 2, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 1, j + 2, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 14), Block.getBlockById(151).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 14), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 14), Block.getBlockById(151).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 2, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 27, j + 2, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 15), Block.getBlockById(171).getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 15), Block.getBlockById(171).getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 15), Block.getBlockById(171).getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 2, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 2, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 2, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 17), Block.getBlockById(171).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 17), Block.getBlockById(171).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 2, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 19), Block.getBlockById(171).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 19), Block.getBlockById(171).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 2, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 2, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
	}
	
	private void partTwo(World world, Random rand, BlockPos pos) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 2, k + 22), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 22), Block.getBlockById(171).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 22), Block.getBlockById(171).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 2, k + 22), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 2, k + 23), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 2, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 23), Block.getBlockById(171).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 23), Block.getBlockById(171).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 2, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 2, k + 23), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 24), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 24), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 24), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 24), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 24), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 2, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 2, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 2, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 25), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 25), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 25), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 25), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 25), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 2, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 2, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 2, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 26), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 26), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 26), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 2, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 2, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 2, k + 27), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 2, k + 27), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 2, k + 27), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 2, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 1), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 1), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 1), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 1), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 2), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 2), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 2), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 3), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 3), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 4), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 4), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 9), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 9), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 3, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 3, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 11), Block.getBlockById(76).getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 3, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 12), Block.getBlockById(69).getStateFromMeta(4), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 3, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 13), Block.getBlockById(69).getStateFromMeta(2), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 13), Block.getBlockById(69).getStateFromMeta(1), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 3, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 14), Block.getBlockById(69).getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 3, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 15), Block.getBlockById(171).getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 15), Block.getBlockById(76).getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 3, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 3, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 2, j + 3, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 17), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 17), Block.getBlockById(89).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 26, j + 3, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 3, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 3, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 3, k + 22), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 3, k + 22), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 3, k + 23), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 3, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 3, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 3, k + 23), Block.getBlockById(95).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 24), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 24), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 24), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 3, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 3, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 3, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 25), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 25), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 25), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 3, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 3, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 26), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 26), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 26), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 3, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 3, k + 27), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 3, k + 27), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 3, k + 27), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 3, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 1), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 2), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 3), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 3), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 4), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 5), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 4, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 4, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 4, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 4, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 4, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 4, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 15), Block.getBlockById(171).getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 15), Block.getBlockById(171).getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 4, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 4, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 3, j + 4, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 25, j + 4, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 21), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 4, j + 4, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 24, j + 4, k + 22), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 5, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 6, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 7, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 23), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 23, j + 4, k + 23), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 4, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 4, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 4, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 4, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 4, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 4, k + 24), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 25), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 26), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 4, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 4, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 4, k + 27), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 3), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 4), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 5), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 5, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 5, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 5, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 5, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 5, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 14), Block.getBlockById(171).getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 14), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 5, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 15), Block.getBlockById(171).getStateFromMeta(6), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 15), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 5, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 5, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 4, j + 5, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 24, j + 5, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 5, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 21), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 5, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 5, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 5, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 5, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 5, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 22), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 5, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 5, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 5, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 5, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 5, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 5, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 5, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 5, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 5, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 5, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 5, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 5, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 5, k + 23), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 4), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 5), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 6), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 6), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 7), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 7), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 8), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 8), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 6, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
	}
	
	private void partThree(World world, Random rand, BlockPos pos) {
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 6, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 6, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 6, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 6, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 6, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 6, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 6, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 13), Block.getBlockById(65).getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 13), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 6, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 6, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 6, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 6, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 6, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 6, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 6, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 5, j + 6, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 23, j + 6, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 18), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 18), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 19), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 19), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 6, j + 6, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 20), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 20), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 22, j + 6, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 6, k + 21), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 6, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 6, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 6, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 6, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 6, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 6, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 6, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 6, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 6, k + 22), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 6), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 7), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 8), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 9), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 7, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 7, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 10), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 10), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 7, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 7, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 11), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 11), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 7, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 7, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 12), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 12), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 7, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 13), Block.getBlockById(65).getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 7, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 7, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 14), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 7, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 7, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 15), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 7, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 7, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 16), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 16), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 7, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 7, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(9), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 17), Block.getBlockById(0).getStateFromMeta(0), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 21, j + 7, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 18), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 8, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 9, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 19, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 20, j + 7, k + 19), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 7, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 7, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 7, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 7, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 7, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 7, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 7, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 7, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 7, k + 20), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 8, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 8, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 8, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 8, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 8, k + 9), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 8, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 8, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 8, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 8, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 8, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 8, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 8, k + 10), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 8, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 8, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 8, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 8, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 8, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 8, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 8, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 8, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 8, k + 11), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 8, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 8, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 8, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 8, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 8, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 8, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 8, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 8, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 8, k + 12), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 8, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 8, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 8, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 8, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 8, k + 13), Block.getBlockById(65).getStateFromMeta(3), 3);
		world.setBlockState(new BlockPos(i + 15, j + 8, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 8, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 8, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 8, k + 13), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 8, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 8, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 8, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 8, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 8, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 8, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 8, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 8, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 8, k + 14), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 10, j + 8, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 8, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 8, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 8, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 8, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 8, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 8, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 8, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 18, j + 8, k + 15), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 11, j + 8, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 8, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 8, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 8, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 8, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 8, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 17, j + 8, k + 16), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 12, j + 8, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 13, j + 8, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 14, j + 8, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 15, j + 8, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
		world.setBlockState(new BlockPos(i + 16, j + 8, k + 17), Block.getBlockById(159).getStateFromMeta(5), 3);
	}
}
