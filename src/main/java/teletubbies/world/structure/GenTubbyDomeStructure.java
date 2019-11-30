package teletubbies.world.structure;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class GenTubbyDomeStructure implements IWorldGenerator {

	private int progress = 0;
	//(i + 14, j + 1, k + 13) iron block 
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if(world.provider.getDimension() == 0) {
			this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	private boolean generateSurface(World world, Random rand, int x, int z) {
		int xCoord = x + rand.nextInt(16);
		int yCoord = world.getHeight();
		int zCoord = z + rand.nextInt(16);
		
		BlockPos pos = new BlockPos(xCoord, yCoord, zCoord);
		while(world.getBlockState(pos).getBlock() instanceof BlockAir) {
			yCoord -= 1;
			if (yCoord <= 0) {
				return false;
			}
			pos = new BlockPos(xCoord, yCoord, zCoord);
		}
		
		if(progress < 1000) {
			progress += 1;
			return false;
		}
				
		if(!(world.getBiome(pos) instanceof BiomePlains)) {
			return false;
		}
		
		BlockPos[] checkPosArr = {new BlockPos(xCoord + 14, yCoord + 0, zCoord + 13), 
				new BlockPos(xCoord + 19, yCoord + 0, zCoord + 13),
				new BlockPos(xCoord + 9, yCoord + 0, zCoord + 13),
				new BlockPos(xCoord + 14, yCoord + 0, zCoord + 8),
				new BlockPos(xCoord + 14, yCoord + 0, zCoord + 18)};
		
		for(BlockPos check : checkPosArr) {
			Block block = world.getBlockState(check).getBlock();
			if(!(block instanceof BlockGrass) || block instanceof BlockBush || block instanceof BlockLiquid) {
				return false;
			}
		}
		
		new TubbyDomeStructure().generate(world, rand, new BlockPos(xCoord, yCoord, zCoord));
		progress = 0;
		removeItems(world, new BlockPos(xCoord + 14, yCoord + 1, zCoord + 13));
		return true;
	}
	
	public static void removeItems(World world, BlockPos pos/*IronBlock*/) {
		List<EntityItem> list = world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(pos).expand(12.0, 4.0, 12.0));
        for(EntityItem i : list) {
        	i.setDead();
        }
	}
}
