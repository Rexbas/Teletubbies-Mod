package teletubbies.registry;

import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import teletubbies.block.tileentity.TileEntityTubbyToastMachine;
import teletubbies.block.tileentity.TileEntityTubbyVoiceTrumpet;
import teletubbies.block.tileentity.TileEntityTubbyWindMill;
import teletubbies.item.ItemBlockTubbyCustardMachine;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegistry {

	public static void registerBlocks(){	
    	GameRegistry.registerBlock(Teletubbies.tubbyVoiceTrumpet, "TubbyVoiceTrumpet");
    	GameRegistry.registerTileEntity(TileEntityTubbyVoiceTrumpet.class, "TubbyVoiceTrumpet");
    	
    	GameRegistry.registerBlock(Teletubbies.tubbyToastMachine, "TubbyToastMachine");
    	GameRegistry.registerTileEntity(TileEntityTubbyToastMachine.class, "TubbyToastMachine");
    	
    	GameRegistry.registerBlock(Teletubbies.tubbyCustardMachine, ItemBlockTubbyCustardMachine.class, "TubbyCustardMachine");
    	GameRegistry.registerTileEntity(TileEntityTubbyCustardMachine.class, "TubbyCustardMachine");
    	
    	GameRegistry.registerBlock(Teletubbies.tubbyWindMill, "TubbyWindMill");
    	GameRegistry.registerTileEntity(TileEntityTubbyWindMill.class, "TubbyWindMill");
   	}
}
