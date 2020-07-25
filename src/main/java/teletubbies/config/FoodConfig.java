package teletubbies.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class FoodConfig {

	public static final String CATEGORY_FOOD = "food";
	public static ForgeConfigSpec.IntValue CUSTARD_HUNGER;
	public static ForgeConfigSpec.DoubleValue CUSTARD_SATURATION;
	public static ForgeConfigSpec.IntValue TOAST_HUNGER;
	public static ForgeConfigSpec.DoubleValue TOAST_SATURATION;
	
	public static void init(ForgeConfigSpec.Builder server) {
		server.comment("Food settings").push(CATEGORY_FOOD);
		CUSTARD_HUNGER = server.defineInRange("custard_hunger", 4, 1, 100);
		CUSTARD_SATURATION = server.defineInRange("custard_saturation", 1.0d, 1.0d, 100.0d);
		TOAST_HUNGER = server.defineInRange("toast_hunger", 2, 1, 100);
		TOAST_SATURATION = server.defineInRange("toast_saturation", 1.0d, 1.0d, 100.0d);
		server.pop();
	}
}
