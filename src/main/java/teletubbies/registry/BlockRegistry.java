package teletubbies.registry;

import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teletubbies.Teletubbies;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import teletubbies.block.tileentity.TileEntityTubbyToastMachine;
import teletubbies.block.tileentity.TileEntityTubbyVoiceTrumpet;

public class BlockRegistry {
	
	public static void registerBlocks() {
    	ForgeRegistries.ITEMS.register(Teletubbies.tubbyVoiceTrumpetIB);
    	ForgeRegistries.BLOCKS.register(Teletubbies.tubbyVoiceTrumpet);
    	
    	ForgeRegistries.ITEMS.register(Teletubbies.tubbyToastMachineIB);
    	ForgeRegistries.BLOCKS.register(Teletubbies.tubbyToastMachine);
    	
    	ForgeRegistries.ITEMS.register(Teletubbies.tubbyCustardMachineIB);
    	ForgeRegistries.BLOCKS.register(Teletubbies.tubbyCustardMachine);
   	}
	
	public static void registerTileEntities() {
    	GameRegistry.registerTileEntity(TileEntityTubbyVoiceTrumpet.class, "tileentitytubbyvoicetrumpet");
    	GameRegistry.registerTileEntity(TileEntityTubbyToastMachine.class, "tileentitytubbytoastmachine");
    	GameRegistry.registerTileEntity(TileEntityTubbyCustardMachine.class, "tileentitytubbycustardmachine");
	}
}
