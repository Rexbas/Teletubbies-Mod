package teletubbies.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class WorldGenConfig {

	public static final String CATEGORY_WORLDGEN = "worldgen";
	public static ForgeConfigSpec.IntValue VOICE_TRUMPET_PROBABILITY;
	
	public static void init(ForgeConfigSpec.Builder server) {
		server.comment("World Gen settings").push(CATEGORY_WORLDGEN);		
		VOICE_TRUMPET_PROBABILITY = server.comment("Voice Trumpet Probability (%) to reduce chance of actual placement")
				.defineInRange("probability", 10, 0, 100);
		server.pop();
	}
}
