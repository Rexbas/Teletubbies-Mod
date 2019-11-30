package teletubbies.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemBlockTubbyCustardMachine extends ItemBlock{

	public ItemBlockTubbyCustardMachine(Block block) {
		super(block);
	}
	
	@Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata){
	    int direction = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if((direction == 0 || direction == 2) &&
				(!world.isAirBlock(x - 1, y, z) ||
				!world.isAirBlock(x + 1, y, z) ||
				!world.isAirBlock(x - 1, y + 1, z) ||
				!world.isAirBlock(x + 1, y + 1, z))){
			return false;
		}
		if((direction == 1 || direction == 3) &&
				(!world.isAirBlock(x, y, z - 1) ||
				!world.isAirBlock(x, y, z + 1) ||
				!world.isAirBlock(x, y + 1, z - 1) ||
				!world.isAirBlock(x, y + 1, z + 1))){
			return false;
		}
      
		if (!world.setBlock(x, y, z, field_150939_a, metadata, 3)){      		      
			return false;      
		}
       
		if (world.getBlock(x, y, z) == field_150939_a){		      
			field_150939_a.onBlockPlacedBy(world, x, y, z, player, stack);        
			field_150939_a.onPostBlockPlaced(world, x, y, z, metadata);       
		}
		return true;
    }
}
