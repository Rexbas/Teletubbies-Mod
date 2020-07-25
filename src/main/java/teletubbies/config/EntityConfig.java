package teletubbies.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class EntityConfig {
	
	public static final String CATEGORY_ENTITIES_FRIENDLY = "friendly entities";
	public static final String CATEGORY_ENTITIES_HOSTILE = "hostile entities";
	
	public static ForgeConfigSpec.IntValue TINKYWINKY_WEIGHT;
	public static ForgeConfigSpec.IntValue DIPSY_WEIGHT;
	public static ForgeConfigSpec.IntValue LAALAA_WEIGHT;
	public static ForgeConfigSpec.IntValue PO_WEIGHT;

	public static ForgeConfigSpec.IntValue NOONOO_WEIGHT;

	public static ForgeConfigSpec.IntValue MIMI_WEIGHT;
	public static ForgeConfigSpec.IntValue DAADAA_WEIGHT;
	public static ForgeConfigSpec.IntValue PING_WEIGHT;
	public static ForgeConfigSpec.IntValue BA_WEIGHT;
	public static ForgeConfigSpec.IntValue RURU_WEIGHT;
	public static ForgeConfigSpec.IntValue NIN_WEIGHT;
	public static ForgeConfigSpec.IntValue DUGGLEDEE_WEIGHT;
	public static ForgeConfigSpec.IntValue UMPIEPUMPIE_WEIGHT;

	public static ForgeConfigSpec.IntValue TINKYWINKY_ZOMBIE_WEIGHT;
	public static ForgeConfigSpec.IntValue DIPSY_ZOMBIE_WEIGHT;
	public static ForgeConfigSpec.IntValue LAALAA_ZOMBIE_WEIGHT;
	public static ForgeConfigSpec.IntValue PO_ZOMBIE_WEIGHT;

	public static void init(ForgeConfigSpec.Builder server) {
		server.comment("Friendly Entity settings").push(CATEGORY_ENTITIES_FRIENDLY);
		TINKYWINKY_WEIGHT = server.defineInRange("tinkywinky_weight", 20, 1, 1000000);		
		DIPSY_WEIGHT = server.defineInRange("dipsy_weight", 20, 1, 1000000);
		LAALAA_WEIGHT = server.defineInRange("laalaa_weight", 20, 1, 1000000);
		PO_WEIGHT = server.defineInRange("po_weight", 20, 1, 1000000);
		
		NOONOO_WEIGHT = server.defineInRange("noonoo_weight", 20, 1, 1000000);
		
		MIMI_WEIGHT = server.defineInRange("mimi_weight", 5, 1, 1000000);		
		DAADAA_WEIGHT = server.defineInRange("daadaa_weight", 5, 1, 1000000);		
		PING_WEIGHT = server.defineInRange("ping_weight", 5, 1, 1000000);		
		BA_WEIGHT = server.defineInRange("ba_weight", 5, 1, 1000000);		
		RURU_WEIGHT = server.defineInRange("ruru_weight", 5, 1, 1000000);	
		NIN_WEIGHT = server.defineInRange("nin_weight", 5, 1, 1000000);		
		DUGGLEDEE_WEIGHT = server.defineInRange("duggledee_weight", 5, 1, 1000000);
		UMPIEPUMPIE_WEIGHT = server.defineInRange("umpiepumpie_weight", 5, 1, 1000000);
		server.pop();
		
		server.comment("Hostile Entity settings").push(CATEGORY_ENTITIES_HOSTILE);
		TINKYWINKY_ZOMBIE_WEIGHT = server.defineInRange("tinkywinky_zombie_weight", 100, 1, 1000000);
		DIPSY_ZOMBIE_WEIGHT = server.defineInRange("dipsy_zombie_weight", 100, 1, 1000000);
		LAALAA_ZOMBIE_WEIGHT = server.defineInRange("laalaa_zombie_weight", 100, 1, 1000000);
		PO_ZOMBIE_WEIGHT = server.defineInRange("po_zombie_weight", 100, 1, 1000000);
		server.pop();
	}
}
