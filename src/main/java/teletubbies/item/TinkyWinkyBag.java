package teletubbies.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class TinkyWinkyBag extends Item {

	private final String name = "TinkyWinkyBag";
	
	public TinkyWinkyBag() {
		maxStackSize = 1;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
		player.openGui(Teletubbies.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
        return new ActionResult(EnumActionResult.SUCCESS, itemStack);
	}
}