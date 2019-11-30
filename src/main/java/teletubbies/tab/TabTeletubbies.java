package teletubbies.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teletubbies.Teletubbies;

public class TabTeletubbies extends CreativeTabs {

	public TabTeletubbies(String name) {
		super(name);
	}

	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Teletubbies.poStick;
	}
}
