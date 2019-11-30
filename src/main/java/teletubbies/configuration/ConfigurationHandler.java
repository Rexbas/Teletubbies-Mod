package teletubbies.configuration;

import teletubbies.Teletubbies;

public class ConfigurationHandler {
	
	public static boolean showUpdateCheck;
	public static final boolean UPDATECHECKER_DEFAULT = true;
	public static final String UPDATECHECKER_NAME = "Enable Teletubbies update checker";
	
	public static void syncConfig(){
		final String CONFIG = Teletubbies.config.CATEGORY_GENERAL;
		Teletubbies.config.addCustomCategoryComment(CONFIG, "Teletubbies Configuration");
		
		showUpdateCheck = Teletubbies.config.get(CONFIG, UPDATECHECKER_NAME, UPDATECHECKER_DEFAULT).getBoolean(UPDATECHECKER_DEFAULT);
		if(Teletubbies.config.hasChanged()){
			Teletubbies.config.save();
		}
	}
}
