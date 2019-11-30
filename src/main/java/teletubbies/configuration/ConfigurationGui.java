package teletubbies.configuration;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import teletubbies.Teletubbies;

public class ConfigurationGui extends GuiConfig {
	
	public ConfigurationGui(GuiScreen screen) {
		super(screen, getList(), Teletubbies.MODID, false, true, GuiConfig.getAbridgedConfigPath(Teletubbies.config.toString()));
	}
	
	private static List<IConfigElement> getList() {
		List<IConfigElement> l = new ArrayList<IConfigElement>();
		l.addAll(new ConfigElement(Teletubbies.config.getCategory(ConfigurationHandler.CATEGORY_UPDATES)).getChildElements());
		l.addAll(new ConfigElement(Teletubbies.config.getCategory(ConfigurationHandler.CATEGORY_TEXTURES)).getChildElements());
		return l;
	}
}
