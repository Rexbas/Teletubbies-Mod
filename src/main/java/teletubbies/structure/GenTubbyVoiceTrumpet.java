package teletubbies.structure;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockGrass;
import net.minecraft.block.BlockLiquid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TubbyTileEntity;

public class GenTubbyVoiceTrumpet implements IWorldGenerator {

	private int progress = 0;
	
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
			yCoord -=1;
			if (yCoord <= 0) {
				return false;
			}
			pos = new BlockPos(xCoord, yCoord, zCoord);
		}
		
		if(progress < 50) {
			progress += 1;
			return false;
		}
		
		Block block = world.getBlockState(pos).getBlock();
		
		if(!(world.getBiomeGenForCoords(pos) instanceof BiomePlains)) {
			return false;
		}
		
		if(!(block instanceof BlockGrass) || block instanceof BlockBush || block instanceof BlockLiquid) {
			return false;
		}
		
		pos = new BlockPos(xCoord, yCoord + 1, zCoord);
		BlockPos pos0 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		int i = new Random().nextInt(4);
		world.setBlockState(pos, Teletubbies.tubbyVoiceTrumpet.getStateFromMeta(i));
		world.setBlockState(pos0, Teletubbies.tubbyVoiceTrumpet.getStateFromMeta(i + 4));
		
		TubbyTileEntity te0 = (TubbyTileEntity) world.getTileEntity(pos);
		te0.setMasterData(pos.getX(), pos.getY(), pos.getZ(), true);
		
		TubbyTileEntity te1 = (TubbyTileEntity) world.getTileEntity(pos0);
		te1.setMasterData(pos.getX(), pos.getY(), pos.getZ(), false);
		progress = 0;
		return true;
	}
}
