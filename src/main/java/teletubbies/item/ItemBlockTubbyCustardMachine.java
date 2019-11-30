package teletubbies.item;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemBlockTubbyCustardMachine extends ItemBlock {

	public ItemBlockTubbyCustardMachine(Block block) {
		super(block);
	}
	
	@Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState) {
	    int facing = player.getHorizontalFacing().getHorizontalIndex();
	    
		IBlockState state0 = block.getStateFromMeta(facing + 4); //+ 4 because center bottom is meta 4-7 
		BlockPos pos0 = new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ());
		BlockPos pos1 = new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ());
		BlockPos pos2 = new BlockPos(pos.getX() - 1, pos.getY() + 1, pos.getZ());
		BlockPos pos3 = new BlockPos(pos.getX() + 1, pos.getY() + 1, pos.getZ());
		
		BlockPos pos4 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1);
		BlockPos pos5 = new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1);
		BlockPos pos6 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() - 1);
		BlockPos pos7 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ() + 1);

		if((facing == 0 || facing == 2) &&
				(!world.isAirBlock(pos0) ||
				!world.isAirBlock(pos1) ||
				!world.isAirBlock(pos2) ||
				!world.isAirBlock(pos3))) {
			return false;
		}
		if((facing == 1 || facing == 3) &&
				(!world.isAirBlock(pos4) ||
				!world.isAirBlock(pos5) ||
				!world.isAirBlock(pos6) ||
				!world.isAirBlock(pos7))) {
			return false;
		}
		
		if(!world.setBlockState(pos, state0)) {
			return false;      
		}
       
		block.onBlockPlacedBy(world, pos, newState, player, stack);
		return true;
    }
}
