package teletubbies.registry;

import net.minecraftforge.fml.common.registry.ForgeRegistries;
import teletubbies.Teletubbies;

public class ArmorRegistry {

	public static void registerArmor() {
		ForgeRegistries.ITEMS.register(Teletubbies.tubbySkirt);
    	ForgeRegistries.ITEMS.register(Teletubbies.dipsyHat);
    	ForgeRegistries.ITEMS.register(Teletubbies.nooNooEyes);
    	ForgeRegistries.ITEMS.register(Teletubbies.tinkyWinkyBib);
    	ForgeRegistries.ITEMS.register(Teletubbies.dipsyBib);
    	ForgeRegistries.ITEMS.register(Teletubbies.laaLaaBib);
    	ForgeRegistries.ITEMS.register(Teletubbies.poBib);
    	ForgeRegistries.ITEMS.register(Teletubbies.poHelmet);
	}
}
