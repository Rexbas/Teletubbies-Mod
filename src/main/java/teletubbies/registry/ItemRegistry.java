package teletubbies.registry;

import net.minecraftforge.fml.common.registry.ForgeRegistries;
import teletubbies.Teletubbies;

public class ItemRegistry {

	public static void registerItems(){
		ForgeRegistries.ITEMS.register(Teletubbies.tinkyWinkyStick);
    	ForgeRegistries.ITEMS.register(Teletubbies.dipsyStick);
    	ForgeRegistries.ITEMS.register(Teletubbies.laaLaaStick);
    	ForgeRegistries.ITEMS.register(Teletubbies.poStick);
    	ForgeRegistries.ITEMS.register(Teletubbies.tinkyWinkyBag); 
    	ForgeRegistries.ITEMS.register(Teletubbies.laaLaaBall); 
    	ForgeRegistries.ITEMS.register(Teletubbies.tubbyCustard);
    	ForgeRegistries.ITEMS.register(Teletubbies.tubbyToast);
    	ForgeRegistries.ITEMS.register(Teletubbies.tubbyBowl);
    	ForgeRegistries.ITEMS.register(Teletubbies.poScooter);
	}
}
