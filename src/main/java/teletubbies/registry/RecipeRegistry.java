package teletubbies.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teletubbies.Teletubbies;

public class RecipeRegistry {

	public static void registerRecipes(){
		//TubbyCustard
	   	/*GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyCustard), new Object[]{
	   		" D ",
	   		" P ",
	   		" B ",
	   		'D', new ItemStack(Items.dye, 1, 9), 'P', Items.porkchop, 'B', Teletubbies.tubbyBowl
	   	});*/
	   	
	   	//TubbyToast
	   	/*GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyToast), new Object[]{
	   		"CCC",
	   		"SWS",
	   		"CSC",
	   		'C', new ItemStack(Items.dye, 1, 3), 'S', Items.sugar, 'W', Items.wheat
	   	});*/
	   	
	   	//TubbyBowl
		GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyBowl), new Object[]{
			"   ",
			"I I",
			" G ",
			'G', Blocks.glass, 'I', Items.iron_ingot
		});
	   	
		//TubbyToastMachine
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyToastMachine), new Object[]{
	   		"DDD",
	   		"ISI",
	   		"III",
	   		'D', Items.diamond, 'S', Teletubbies.tinkyWinkyStick, 'I', Items.iron_ingot
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyToastMachine), new Object[]{
	   		"DDD",
	   		"ISI",
	   		"III",
	   		'D', Items.diamond, 'S', Teletubbies.dipsyStick, 'I', Items.iron_ingot
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyToastMachine), new Object[]{
	   		"DDD",
	   		"ISI",
	   		"III",
	   		'D', Items.diamond, 'S', Teletubbies.laaLaaStick, 'I', Items.iron_ingot
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyToastMachine), new Object[]{
	   		"DDD",
	   		"ISI",
	   		"III",
	   		'D', Items.diamond, 'S', Teletubbies.poStick, 'I', Items.iron_ingot
	   	});
	   	
	   	//TubbyCustardMachine
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyCustardMachine), new Object[]{
	   		"I I",
	   		"ISI",
	   		"BBB",
	   		'B', new ItemStack(Blocks.wool, 1, 2), 'S', Teletubbies.tinkyWinkyStick, 'I', Items.iron_ingot
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyCustardMachine), new Object[]{
	   		"I I",
	   		"ISI",
	   		"BBB",
	   		'B', new ItemStack(Blocks.wool, 1, 2), 'S', Teletubbies.dipsyStick, 'I', Items.iron_ingot
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyCustardMachine), new Object[]{
	   		"I I",
	   		"ISI",
	   		"BBB",
	   		'B', new ItemStack(Blocks.wool, 1, 2), 'S', Teletubbies.laaLaaStick, 'I', Items.iron_ingot
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyCustardMachine), new Object[]{
	   		"I I",
	   		"ISI",
	   		"BBB",
	   		'B', new ItemStack(Blocks.wool, 1, 2), 'S', Teletubbies.poStick, 'I', Items.iron_ingot
	   	});
	   	
	   	//TubbySkirt
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbySkirt), new Object[]{
	   		"SSS",
	   		"WWW",
	   		"WWW",
	   		'W', new ItemStack(Blocks.wool, 1, 6), 'D', new ItemStack(Items.dye, 1, 9), 'S', Items.string
	   	});
	   	
	   	//DipsyHat
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.dipsyHat), new Object[]{
	   		"FCF",
	   		"CSC",
	   		"WWW",
	   		'W', new ItemStack(Blocks.wool, 1, 0), 'S', Teletubbies.dipsyStick, 'C', Items.coal, 'F', Items.feather
	   	});
	   	
	   	//TinkyWinkyBib
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tinkyWinkyBib), new Object[]{
	   		"IXI",
	   		"SSS",
	   		"SSS",
	   		'I', Items.iron_ingot, 'S', Teletubbies.tinkyWinkyStick, 'X', Items.string
	   	});
	   	
	   	//DipsyBib
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.dipsyBib), new Object[]{
	   		"IXI",
	   		"SSS",
	   		"SSS",
	   		'I', Items.iron_ingot, 'S', Teletubbies.dipsyStick, 'X', Items.string
	   	});
	   	
	   	//LaaLaaBib
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.laaLaaBib), new Object[]{
	   		"IXI",
	   		"SSS",
	   		"SSS",
	   		'I', Items.iron_ingot, 'S', Teletubbies.laaLaaStick, 'X', Items.string
	   	});
	   	
	   	//PoBib
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.poBib), new Object[]{
	   		"IXI",
	   		"SSS",
	   		"SSS",
	   		'I', Items.iron_ingot, 'S', Teletubbies.poStick, 'X', Items.string
	   	});
	   	
	   	//LaaLaaBall
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.laaLaaBall), new Object[]{
	   		"DBD",
	   		"BSB",
	   		"DBD",
	   		'D', new ItemStack(Items.dye, 1, 11), 'B', Items.slime_ball, 'S', Teletubbies.laaLaaStick
	   	});
	   	
	   	//TinkyWinkyBag
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tinkyWinkyBag), new Object[]{
	   		"LLL",
	   		"LSL",
	   		"LLL",
	   		'L', Items.leather, 'S', Teletubbies.tinkyWinkyStick
	   	});
	}
}
