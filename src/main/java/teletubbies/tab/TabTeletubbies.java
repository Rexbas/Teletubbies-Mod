package teletubbies.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import teletubbies.Teletubbies;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabTeletubbies extends CreativeTabs {

	public TabTeletubbies(int id, String unlocalizedName) {
		super(id, unlocalizedName);
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Teletubbies.poStick;
	}
}
