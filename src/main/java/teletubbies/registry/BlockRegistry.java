package teletubbies.registry;

import net.minecraftforge.fml.common.registry.GameRegistry;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import teletubbies.block.tileentity.TileEntityTubbyToastMachine;
import teletubbies.block.tileentity.TubbyTileEntity;
import teletubbies.item.ItemBlockTubbyCustardMachine;

public class BlockRegistry {

	public static void registerBlocks() {	
    	GameRegistry.registerBlock(Teletubbies.tubbyVoiceTrumpet, "TubbyVoiceTrumpet");
    	GameRegistry.registerTileEntity(TubbyTileEntity.class, "TubbyVoiceTrumpet");
    	
    	GameRegistry.registerBlock(Teletubbies.tubbyToastMachine, "TubbyToastMachine");
    	GameRegistry.registerTileEntity(TileEntityTubbyToastMachine.class, "TubbyToastMachine");
    	
    	GameRegistry.registerBlock(Teletubbies.tubbyCustardMachine, ItemBlockTubbyCustardMachine.class, "TubbyCustardMachine");
    	GameRegistry.registerTileEntity(TileEntityTubbyCustardMachine.class, "TubbyCustardMachine");
   	}
}
