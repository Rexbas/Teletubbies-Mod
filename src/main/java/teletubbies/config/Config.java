package teletubbies.config;

import java.io.File;

import org.apache.commons.lang3.tuple.Pair;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Config {
	
	public static class Common {		
		// Entities
		public final ForgeConfigSpec.IntValue TINKYWINKY_WEIGHT;
		public final ForgeConfigSpec.IntValue DIPSY_WEIGHT;
		public final ForgeConfigSpec.IntValue LAALAA_WEIGHT;
		public final ForgeConfigSpec.IntValue PO_WEIGHT;

		public final ForgeConfigSpec.IntValue NOONOO_WEIGHT;

		public final ForgeConfigSpec.IntValue MIMI_WEIGHT;
		public final ForgeConfigSpec.IntValue DAADAA_WEIGHT;
		public final ForgeConfigSpec.IntValue PING_WEIGHT;
		public final ForgeConfigSpec.IntValue BA_WEIGHT;
		public final ForgeConfigSpec.IntValue RURU_WEIGHT;
		public final ForgeConfigSpec.IntValue NIN_WEIGHT;
		public final ForgeConfigSpec.IntValue DUGGLEDEE_WEIGHT;
		public final ForgeConfigSpec.IntValue UMPIEPUMPIE_WEIGHT;

		public final ForgeConfigSpec.IntValue TINKYWINKY_ZOMBIE_WEIGHT;
		public final ForgeConfigSpec.IntValue DIPSY_ZOMBIE_WEIGHT;
		public final ForgeConfigSpec.IntValue LAALAA_ZOMBIE_WEIGHT;
		public  final ForgeConfigSpec.IntValue PO_ZOMBIE_WEIGHT;
		
		public final ForgeConfigSpec.IntValue TRANSFORMATION_PROBABILITY;
		
		// Food
		public final ForgeConfigSpec.IntValue CUSTARD_HUNGER;
		public final ForgeConfigSpec.DoubleValue CUSTARD_SATURATION;
		public final ForgeConfigSpec.IntValue TOAST_HUNGER;
		public final ForgeConfigSpec.DoubleValue TOAST_SATURATION;
		
		// WorldGen
		public final ForgeConfigSpec.IntValue VOICE_TRUMPET_SPAWNRATE;
		public final ForgeConfigSpec.IntValue DOME_MIN_CHUNKS;
		public final ForgeConfigSpec.IntValue DOME_MAX_CHUNKS;
		public final ForgeConfigSpec.BooleanValue INVASIVE_GRASS;
		
		public Common(ForgeConfigSpec.Builder builder) {			
			builder.push("Entities");
			TINKYWINKY_WEIGHT = builder.defineInRange("tinkywinky_weight", 20, 1, 1000000);
			DIPSY_WEIGHT = builder.defineInRange("dipsy_weight", 20, 1, 1000000);
			LAALAA_WEIGHT = builder.defineInRange("laalaa_weight", 20, 1, 1000000);
			PO_WEIGHT = builder.defineInRange("po_weight", 20, 1, 1000000);
			
			NOONOO_WEIGHT = builder.defineInRange("noonoo_weight", 20, 1, 1000000);
			
			MIMI_WEIGHT = builder.defineInRange("mimi_weight", 5, 1, 1000000);		
			DAADAA_WEIGHT = builder.defineInRange("daadaa_weight", 5, 1, 1000000);		
			PING_WEIGHT = builder.defineInRange("ping_weight", 5, 1, 1000000);		
			BA_WEIGHT = builder.defineInRange("ba_weight", 5, 1, 1000000);		
			RURU_WEIGHT = builder.defineInRange("ruru_weight", 5, 1, 1000000);	
			NIN_WEIGHT = builder.defineInRange("nin_weight", 5, 1, 1000000);		
			DUGGLEDEE_WEIGHT = builder.defineInRange("duggledee_weight", 5, 1, 1000000);
			UMPIEPUMPIE_WEIGHT = builder.defineInRange("umpiepumpie_weight", 5, 1, 1000000);
			
			TINKYWINKY_ZOMBIE_WEIGHT = builder.defineInRange("tinkywinky_zombie_weight", 100, 1, 1000000);
			DIPSY_ZOMBIE_WEIGHT = builder.defineInRange("dipsy_zombie_weight", 100, 1, 1000000);
			LAALAA_ZOMBIE_WEIGHT = builder.defineInRange("laalaa_zombie_weight", 100, 1, 1000000);
			PO_ZOMBIE_WEIGHT = builder.defineInRange("po_zombie_weight", 100, 1, 1000000);
			
			TRANSFORMATION_PROBABILITY = builder.comment("Chance of Teletubby transforming into zombie Teletubby")
					.defineInRange("transformation_probability", 25, 1, 100);
			
			builder.pop();
			
			builder.push("Food");
			CUSTARD_HUNGER = builder.defineInRange("custard_hunger", 5, 1, 100);
			CUSTARD_SATURATION = builder.defineInRange("custard_saturation", 1.5d, 1.0d, 100.0d);
			TOAST_HUNGER = builder.defineInRange("toast_hunger", 2, 1, 100);
			TOAST_SATURATION = builder.defineInRange("toast_saturation", 1.0d, 1.0d, 100.0d);
			builder.pop();
			
			builder.push("WorldGen");
			VOICE_TRUMPET_SPAWNRATE = builder.comment("Voice Trumpet Spawnrate (%)")
					.defineInRange("probability", 10, 0, 100);
			
			DOME_MIN_CHUNKS = builder.comment("Min chunks between domes")
					.defineInRange("min", 10, 1, 1000);
			
			DOME_MAX_CHUNKS = builder.comment("Max chunks between domes")
					.defineInRange("max", 25, 1, 1000);
			
			INVASIVE_GRASS = builder.comment("Whether or not the full grass block should turn vanilla grass into full grass (like how dirt turns into grass)")
					.define("invasive_grass", true);

			builder.pop();
		}
	}
	
	public static class Client {
		// Rendering
		public final ForgeConfigSpec.BooleanValue REPLACE_SUN;

		public Client(ForgeConfigSpec.Builder builder) {
			builder.push("Rendering");
			REPLACE_SUN = builder.define("replace_sun", true);			
			builder.pop();
		}
	}
	
	public static final ForgeConfigSpec COMMON_SPEC;
	public static final ForgeConfigSpec CLIENT_SPEC;
	public static final Common COMMON;
	public static final Client CLIENT;
	
	static {
		final Pair<Common, ForgeConfigSpec> specPairCommon = new ForgeConfigSpec.Builder().configure(Common::new);
		COMMON_SPEC = specPairCommon.getRight();
		COMMON = specPairCommon.getLeft();
		
		final Pair<Client, ForgeConfigSpec> specPairClient = new ForgeConfigSpec.Builder().configure(Client::new);
		CLIENT_SPEC = specPairClient.getRight();
		CLIENT = specPairClient.getLeft();
	}
	
	public static void loadConfig(ForgeConfigSpec config, String path) {
		final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
		file.load();
		config.setConfig(file);
	}
}
