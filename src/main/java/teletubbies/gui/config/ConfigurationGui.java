package teletubbies.gui.config;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import teletubbies.Teletubbies;

public class ConfigurationGui extends GuiConfig {

	public ConfigurationGui(GuiScreen screen) {
		super(screen, new ConfigElement(
				Teletubbies.config.getCategory(Configuration.CATEGORY_GENERAL))
				.getChildElements(), Teletubbies.MODID, false, true, GuiConfig
				.getAbridgedConfigPath(Teletubbies.config.toString()));
	}
}
