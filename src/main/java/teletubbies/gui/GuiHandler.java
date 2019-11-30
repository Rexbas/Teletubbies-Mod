package teletubbies.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import teletubbies.Teletubbies;
import teletubbies.container.ContainerTinkyWinkyBag;
import teletubbies.inventory.InventoryTinkyWinkyBag;

public class GuiHandler implements IGuiHandler {
    
	@Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));		
		switch(ID) {
	    case 0:
			if(player.getHeldItem().getItem() == Teletubbies.tinkyWinkyBag) {
				return new ContainerTinkyWinkyBag(player.inventory, new InventoryTinkyWinkyBag(player.getHeldItem(), 54));
			}
	    }
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {	
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));   
        switch(ID){
        case 0:
    		if(player.getHeldItem().getItem() == Teletubbies.tinkyWinkyBag){
    			return new GuiTinkyWinkyBag(player.inventory, new InventoryTinkyWinkyBag(player.getHeldItem(), 54));
    		}
        }
        return null;
	}
}