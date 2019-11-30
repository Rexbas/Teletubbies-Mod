package teletubbies.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import teletubbies.container.ContainerTinkyWinkyBag;
import teletubbies.inventory.InventoryTinkyWinkyBag;
import teletubbies.item.TinkyWinkyBag;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0) {
		    if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof TinkyWinkyBag &&
				player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof TinkyWinkyBag) {
		    	ItemStack bag = (ItemStack) player.getHeldItemMainhand();
		    	System.out.println("First Codition");
				return new ContainerTinkyWinkyBag(player.inventory, new InventoryTinkyWinkyBag(54, bag));
		    }
		    else if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof TinkyWinkyBag) {
		    	ItemStack bag = (ItemStack) player.getHeldItemMainhand();
		    	System.out.println("Second Condition");

				return new ContainerTinkyWinkyBag(player.inventory, new InventoryTinkyWinkyBag(54, bag));
		    }
		    else if(player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof TinkyWinkyBag) {
		    	ItemStack bag = (ItemStack) player.getHeldItemOffhand();
		    	System.out.println("Third condition");

				return new ContainerTinkyWinkyBag(player.inventory, new InventoryTinkyWinkyBag(54, bag));
		    }
		}
		/*if(ID == 1) {
			ITeletubbies_CAP capability = player.getCapability(Teletubbies.Teletubbies_CAP, player.getHorizontalFacing());
			EntityNooNoo nooNoo = capability.interactedNooNoo();
			//capability.setInteractedNooNoo(null);
			return new ContainerNooNoo(player, nooNoo);
		}*/
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0) {
		    if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof TinkyWinkyBag &&
				player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof TinkyWinkyBag) {
		    	ItemStack bag = (ItemStack) player.getHeldItemMainhand();
		    	System.out.println("First Codition");
				return new GuiTinkyWinkyBag(player.inventory, new InventoryTinkyWinkyBag(54, bag));
		    }
		    else if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof TinkyWinkyBag) {
		    	ItemStack bag = (ItemStack) player.getHeldItemMainhand();
		    	System.out.println("Second Condition");
				return new GuiTinkyWinkyBag(player.inventory, new InventoryTinkyWinkyBag(54, bag));
		    }
		    else if(player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof TinkyWinkyBag) {
		    	ItemStack bag = (ItemStack) player.getHeldItemOffhand();
		    	System.out.println("Third condition");
				return new GuiTinkyWinkyBag(player.inventory, new InventoryTinkyWinkyBag(54, bag));
		    }
		}
		/*if(ID == 1) {
			ITeletubbies_CAP capability = player.getCapability(Teletubbies.Teletubbies_CAP, player.getHorizontalFacing());
			EntityNooNoo nooNoo = capability.interactedNooNoo();
			//capability.setInteractedNooNoo(null);
			return new GuiNooNoo(player, nooNoo);
		}*/
		return null;
	}
}