package teletubbies.registry;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor.ArmorMaterial;
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
		Teletubbies.tubbySkirt = new ArmorTubbySkirt(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
    	GameRegistry.registerItem(Teletubbies.tubbySkirt, "TubbySkirt");
		
		Teletubbies.dipsyHat = new ArmorDipsyHat(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD);
    	GameRegistry.registerItem(Teletubbies.dipsyHat, "DipsyHat");
    	
    	Teletubbies.nooNooEyes = new ArmorNooNooEyes(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD);
    	GameRegistry.registerItem(Teletubbies.nooNooEyes, "NooNooEyes");
    	
    	Teletubbies.tinkyWinkyBib = new ArmorTinkyWinkyBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
    	GameRegistry.registerItem(Teletubbies.tinkyWinkyBib, "TinkyWinkyBib");
    	
    	Teletubbies.dipsyBib = new ArmorDipsyBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
    	GameRegistry.registerItem(Teletubbies.dipsyBib, "DipsyBib");
    	
    	Teletubbies.laaLaaBib = new ArmorLaaLaaBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
    	GameRegistry.registerItem(Teletubbies.laaLaaBib, "LaaLaaBib");
    	
    	Teletubbies.poBib = new ArmorPoBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
    	GameRegistry.registerItem(Teletubbies.poBib, "PoBib");
	}
}
