package teletubbies.gui.config;

import teletubbies.Teletubbies;
import cpw.mods.fml.common.FMLCommonHandler;

public class TeletubbiesConfigurationHandler {
	
	public static boolean showUpdateCheck;
	public static final boolean UPDATECHECKER_DEFAULT = true;
	public static final String UPDATECHECKER_NAME = "Enable the Teletubbies Update Checker";
	
	public static boolean enableZombies;
	public static final boolean ZOMBIES_DEFAULT = true;
	public static final String ZOMBIES_NAME = "Enable Teletubby Zombies";

	public static boolean zombiesAttacksTeletubbies;
	public static final boolean ZOMBIES_ATTACKS_TELETUBBIES_DEFAULT = true;
	public static final String ZOMBIES_ATTACKS_TELETUBBIES_NAME = "Enable Zombies to attack Teletubbies";
	
	public static void syncConfig(){
		FMLCommonHandler.instance().bus().register(Teletubbies.instance);
		
		final String CONFIG = Teletubbies.config.CATEGORY_GENERAL;
		Teletubbies.config.addCustomCategoryComment(CONFIG, "Teletubbies Options");
		
		showUpdateCheck = Teletubbies.config.get(CONFIG, UPDATECHECKER_NAME, UPDATECHECKER_DEFAULT).getBoolean(UPDATECHECKER_DEFAULT);
		if(Teletubbies.config.hasChanged()){
			Teletubbies.config.save();
		}
		
		enableZombies = Teletubbies.config.get(CONFIG, ZOMBIES_NAME, ZOMBIES_DEFAULT).getBoolean(ZOMBIES_DEFAULT);
		if(Teletubbies.config.hasChanged()){
			Teletubbies.config.save();
		}
		
		zombiesAttacksTeletubbies = Teletubbies.config.get(CONFIG, ZOMBIES_ATTACKS_TELETUBBIES_NAME, ZOMBIES_ATTACKS_TELETUBBIES_DEFAULT).getBoolean(ZOMBIES_ATTACKS_TELETUBBIES_DEFAULT);
		if(Teletubbies.config.hasChanged()){
			Teletubbies.config.save();
		}
	}
}
