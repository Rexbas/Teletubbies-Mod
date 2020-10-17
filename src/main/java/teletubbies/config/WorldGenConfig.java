package teletubbies.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class WorldGenConfig {

	public static final String CATEGORY_WORLDGEN = "worldgen";
	public static ForgeConfigSpec.IntValue VOICE_TRUMPET_FREQUENCY;
	public static ForgeConfigSpec.IntValue VOICE_TRUMPET_PROBABILITY;
	public static ForgeConfigSpec.IntValue DOME_MIN_CHUNKS;
	public static ForgeConfigSpec.IntValue DOME_MAX_CHUNKS;
	
	public static void init(ForgeConfigSpec.Builder server) {
		server.comment("World Gen settings").push(CATEGORY_WORLDGEN);
		VOICE_TRUMPET_FREQUENCY = server.comment("Voice Trumpet Frequency for Placement")
				.defineInRange("frequency", 2, 2, 1000);
		
		VOICE_TRUMPET_PROBABILITY = server.comment("Voice Trumpet Probability (%) to reduce chance of actual placement")
				.defineInRange("probability", 30, 1, 100);
		
		DOME_MIN_CHUNKS = server.comment("Min chunks between domes")
				.defineInRange("min", 10, 1, 1000);
		
		DOME_MAX_CHUNKS = server.comment("Max chunks between domes")
				.defineInRange("max", 25, 1, 1000);
		server.pop();
	}
}
