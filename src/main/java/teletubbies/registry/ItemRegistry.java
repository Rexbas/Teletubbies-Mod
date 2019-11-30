package teletubbies.registry;

import net.minecraftforge.fml.common.registry.GameRegistry;
import teletubbies.Teletubbies;

public class ItemRegistry {

	public static void registerItems(){
    	GameRegistry.registerItem(Teletubbies.tinkyWinkyStick, "TinkyWinkyStick");
    	GameRegistry.registerItem(Teletubbies.dipsyStick, "DipsyStick");
    	GameRegistry.registerItem(Teletubbies.laaLaaStick, "LaaLaaStick");
    	GameRegistry.registerItem(Teletubbies.poStick, "PoStick");
    	GameRegistry.registerItem(Teletubbies.tinkyWinkyBag, "TinkyWinkyBag"); 
    	GameRegistry.registerItem(Teletubbies.laaLaaBall, "LaaLaaBall"); 
    	GameRegistry.registerItem(Teletubbies.tubbyCustard, "TubbyCustard");
    	GameRegistry.registerItem(Teletubbies.tubbyToast, "TubbyToast");
    	GameRegistry.registerItem(Teletubbies.tubbyBowl, "TubbyBowl"); 
	}
}
