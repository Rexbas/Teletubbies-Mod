package com.rexbas.teletubbies.config;

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
		public final ForgeConfigSpec.IntValue TRANSFORMATION_PROBABILITY;
		
		// Food
		public final ForgeConfigSpec.IntValue CUSTARD_HUNGER;
		public final ForgeConfigSpec.DoubleValue CUSTARD_SATURATION;
		public final ForgeConfigSpec.IntValue TOAST_HUNGER;
		public final ForgeConfigSpec.DoubleValue TOAST_SATURATION;
		
		// WorldGen
		public final ForgeConfigSpec.BooleanValue INVASIVE_GRASS;
		
		public Common(ForgeConfigSpec.Builder builder) {			
			builder.push("Entities");
			
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
