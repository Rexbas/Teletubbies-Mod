package teletubbies.util;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlocksUtil {
	public static boolean isBlockSurrounded(World world, BlockPos pos) {
		if (world.getBlockState(pos.up()).getBlock() == Blocks.AIR) {
			return false;
		}
		if (world.getBlockState(pos.down()).getBlock() == Blocks.AIR) {
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
