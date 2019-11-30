package teletubbies.configuration;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import teletubbies.Teletubbies;

public class ConfigurationHandler {
	
	public static final String CATEGORY_UPDATES = "updates";
	public static final String CATEGORY_TEXTURES = "textures";
		
	public static boolean showUpdateCheck;
	public static final boolean UPDATECHECKER_DEFAULT = true;
	public static final String UPDATECHECKER_NAME = "Enable Teletubbies update checker";
	
	public static boolean use2015;
	public static final boolean TELETUBBIES_2015_DEFAULT = false;
	public static final String TELETUBBIES_2015_NAME = "Use Teletubbies 2015 textures (if available)";
	
	public static void syncConfig() {
		Teletubbies.config.addCustomCategoryComment(CATEGORY_UPDATES, "Teletubbies Configuration");
		Teletubbies.config.addCustomCategoryComment(CATEGORY_TEXTURES, "2015 Teletubbies");
		
		showUpdateCheck = Teletubbies.config.get(CATEGORY_UPDATES, UPDATECHECKER_NAME, UPDATECHECKER_DEFAULT).getBoolean(UPDATECHECKER_DEFAULT);
		use2015 = Teletubbies.config.get(CATEGORY_TEXTURES, TELETUBBIES_2015_NAME, TELETUBBIES_2015_DEFAULT).getBoolean(TELETUBBIES_2015_DEFAULT);
		if(Teletubbies.config.hasChanged()) {
			Teletubbies.config.save();
		}
		if(Teletubbies.config.getCategory(CATEGORY_TEXTURES).hasChanged() && FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			try {
				throw new ReloadTexturesAndConfigException();
			} catch (ReloadTexturesAndConfigException e) {
				e.printStackTrace();
				FMLCommonHandler.instance().exitJava(0, false);
			}
		}
	}
}

class ReloadTexturesAndConfigException extends Exception {
	
	private static String message = "\nIf this is the first time you run the Teletubbies Mod then ignore this and restart Minecraft.\n"
						+ "If you changed Teletubbies Mod configuration then you need to restart Minecraft to see the results.\n";
	
	public ReloadTexturesAndConfigException () {
		super (message);		
		JOptionPane jop = new JOptionPane(message, JOptionPane.WARNING_MESSAGE);
		JDialog dlog = jop.createDialog(null, "Teletubbies Mod Configuration");
		dlog.setAlwaysOnTop(true);
		dlog.setVisible(true);
		
	}
}
