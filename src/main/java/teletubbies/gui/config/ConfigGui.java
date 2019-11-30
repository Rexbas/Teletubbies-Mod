package teletubbies.gui.config;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import teletubbies.Teletubbies;
import cpw.mods.fml.client.config.GuiConfig;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen screen) {
		super(screen, new ConfigElement(
				Teletubbies.config.getCategory(Configuration.CATEGORY_GENERAL))
				.getChildElements(), Teletubbies.MODID, false, true, GuiConfig
				.getAbridgedConfigPath(Teletubbies.config.toString()));
	}
}
