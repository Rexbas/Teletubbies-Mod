package teletubbies.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teletubbies.Teletubbies;

public class RecipeRegistry {

	public static void registerRecipes () {	   	
	   	//TubbyBowl
		GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyBowl), new Object[]{
			"   ",
			"I I",
			" G ",
			'G', Blocks.GLASS, 'I', Items.IRON_INGOT
		});
	   	
		//TubbyToastMachine
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyToastMachine), new Object[]{
	   		"DDD",
	   		"ISI",
	   		"III",
	   		'D', Items.DIAMOND, 'S', Teletubbies.tinkyWinkyStick, 'I', Items.IRON_INGOT
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyToastMachine), new Object[]{
	   		"DDD",
	   		"ISI",
	   		"III",
	   		'D', Items.DIAMOND, 'S', Teletubbies.dipsyStick, 'I', Items.IRON_INGOT
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyToastMachine), new Object[]{
	   		"DDD",
	   		"ISI",
	   		"III",
	   		'D', Items.DIAMOND, 'S', Teletubbies.laaLaaStick, 'I', Items.IRON_INGOT
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyToastMachine), new Object[]{
	   		"DDD",
	   		"ISI",
	   		"III",
	   		'D', Items.DIAMOND, 'S', Teletubbies.poStick, 'I', Items.IRON_INGOT
	   	});
	   	
	   	//TubbyCustardMachine
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyCustardMachine), new Object[]{
	   		"I I",
	   		"ISI",
	   		"BBB",
	   		'B', new ItemStack(Blocks.WOOL, 1, 2), 'S', Teletubbies.tinkyWinkyStick, 'I', Items.IRON_INGOT
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyCustardMachine), new Object[]{
	   		"I I",
	   		"ISI",
	   		"BBB",
	   		'B', new ItemStack(Blocks.WOOL, 1, 2), 'S', Teletubbies.dipsyStick, 'I', Items.IRON_INGOT
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyCustardMachine), new Object[]{
	   		"I I",
	   		"ISI",
	   		"BBB",
	   		'B', new ItemStack(Blocks.WOOL, 1, 2), 'S', Teletubbies.laaLaaStick, 'I', Items.IRON_INGOT
	   	});
	   	
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyCustardMachine), new Object[]{
	   		"I I",
	   		"ISI",
	   		"BBB",
	   		'B', new ItemStack(Blocks.WOOL, 1, 2), 'S', Teletubbies.poStick, 'I', Items.IRON_INGOT
	   	});
	   	
	   	//TubbySkirt
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tubbyTutu), new Object[]{
	   		"SSS",
	   		"WWW",
	   		"WWW",
	   		'W', new ItemStack(Blocks.WOOL, 1, 6), 'S', Items.STRING
	   	});
	   	
	   	//DipsyHat
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.dipsyHat), new Object[]{
	   		"FCF",
	   		"CSC",
	   		"WWW",
	   		'W', new ItemStack(Blocks.WOOL, 1, 0), 'S', Teletubbies.dipsyStick, 'C', Items.COAL, 'F', Items.FEATHER
	   	});
	   	
	   	//TinkyWinkyBib
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tinkyWinkyBib), new Object[]{
	   		"IXI",
	   		"SSS",
	   		"SSS",
	   		'I', Items.IRON_INGOT, 'S', Teletubbies.tinkyWinkyStick, 'X', Items.STRING
	   	});
	   	
	   	//DipsyBib
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.dipsyBib), new Object[]{
	   		"IXI",
	   		"SSS",
	   		"SSS",
	   		'I', Items.IRON_INGOT, 'S', Teletubbies.dipsyStick, 'X', Items.STRING
	   	});
	   	
	   	//LaaLaaBib
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.laaLaaBib), new Object[]{
	   		"IXI",
	   		"SSS",
	   		"SSS",
	   		'I', Items.IRON_INGOT, 'S', Teletubbies.laaLaaStick, 'X', Items.STRING
	   	});
	   	
	   	//PoBib
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.poBib), new Object[]{
	   		"IXI",
	   		"SSS",
	   		"SSS",
	   		'I', Items.IRON_INGOT, 'S', Teletubbies.poStick, 'X', Items.STRING
	   	});
	   	
	   	//PoHelmet
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.poHelmet), new Object[]{
	   		" S ",
	   		"ISI",
	   		"III",
	   		'I', Items.IRON_INGOT, 'S', Teletubbies.poStick
	   	});
	   	
	   	//LaaLaaBall
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.laaLaaBall), new Object[]{
	   		"DBD",
	   		"BSB",
	   		"DBD",
	   		'D', new ItemStack(Items.DYE, 1, 11), 'B', Items.SLIME_BALL, 'S', Teletubbies.laaLaaStick
	   	});
	   	
	   	//TinkyWinkyBag
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.tinkyWinkyBag), new Object[]{
	   		"LLL",
	   		"LSL",
	   		"LLL",
	   		'L', Items.LEATHER, 'S', Teletubbies.tinkyWinkyStick
	   	});
	   	
	   	//PoScooter
	   	GameRegistry.addRecipe(new ItemStack(Teletubbies.poScooter), new Object[]{
	   		"S  ",
	   		"III",
	   		"B B",
	   		'I', Items.IRON_INGOT, 'S', Teletubbies.poStick, 'B', Items.CLAY_BALL
	   	});
	}
}
