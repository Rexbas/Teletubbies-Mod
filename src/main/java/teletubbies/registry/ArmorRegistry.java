package teletubbies.registry;

import net.minecraftforge.fml.common.registry.GameRegistry;
import teletubbies.Teletubbies;
import teletubbies.armor.ArmorDipsyBib;
import teletubbies.armor.ArmorDipsyHat;
import teletubbies.armor.ArmorLaaLaaBib;
import teletubbies.armor.ArmorNooNooEyes;
import teletubbies.armor.ArmorPoBib;
import teletubbies.armor.ArmorTinkyWinkyBib;
import teletubbies.armor.ArmorTubbySkirt;

public class ArmorRegistry {

	public static void registerArmor(){
		Teletubbies.tubbySkirt = new ArmorTubbySkirt(Teletubbies.tubbyMaterial, Teletubbies.commonProxy.addArmor("ArmorTubbySkirt"), 1);
    	GameRegistry.registerItem(Teletubbies.tubbySkirt, "TubbySkirt");
		
		Teletubbies.dipsyHat = new ArmorDipsyHat(Teletubbies.tubbyMaterial, Teletubbies.commonProxy.addArmor("ArmorDipsyHat"), 0);
    	GameRegistry.registerItem(Teletubbies.dipsyHat, "DipsyHat");
    	
    	Teletubbies.tinkyWinkyBib = new ArmorTinkyWinkyBib(Teletubbies.tubbyMaterial, Teletubbies.commonProxy.addArmor("ArmorTinkyWinkyBib"), 1);
    	GameRegistry.registerItem(Teletubbies.tinkyWinkyBib, "TinkyWinkyBib");
    	
    	Teletubbies.dipsyBib = new ArmorDipsyBib(Teletubbies.tubbyMaterial, Teletubbies.commonProxy.addArmor("ArmorDipsyBib"), 1);
    	GameRegistry.registerItem(Teletubbies.dipsyBib, "DipsyBib");
    	
    	Teletubbies.laaLaaBib = new ArmorLaaLaaBib(Teletubbies.tubbyMaterial, Teletubbies.commonProxy.addArmor("ArmorLaaLaaBib"), 1);
    	GameRegistry.registerItem(Teletubbies.laaLaaBib, "LaaLaaBib");
    	
    	Teletubbies.poBib = new ArmorPoBib(Teletubbies.tubbyMaterial, Teletubbies.commonProxy.addArmor("ArmorPoBib"), 1);
    	GameRegistry.registerItem(Teletubbies.poBib, "PoBib");
    	
    	Teletubbies.nooNooEyes = new ArmorNooNooEyes(Teletubbies.tubbyMaterial, Teletubbies.commonProxy.addArmor("ArmorNooNooEyes"), 0);
    	GameRegistry.registerItem(Teletubbies.nooNooEyes, "NooNooEyes");
	}
}
