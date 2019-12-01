package teletubbies.registry;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.TeletubbiesItems;
import teletubbies.item.LaaLaaBall;
import teletubbies.item.TinkyWinkyBag;
import teletubbies.item.Custard;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {

	@SubscribeEvent
	public static void registerItemsEvent(final RegistryEvent.Register<Item> event) {
		Teletubbies.foodCustard= (new Food.Builder()).hunger(4).saturation(5).build();
		Teletubbies.foodToast= (new Food.Builder()).hunger(2).saturation(5).fastToEat().build();

		event.getRegistry().registerAll(
				// Items
				TeletubbiesItems.tinkyWinkyStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "tinkywinkystick"), 
				TeletubbiesItems.dipsyStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "dipsystick"),
				TeletubbiesItems.laaLaaStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "laalaastick"),
				TeletubbiesItems.poStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "postick"),
				TeletubbiesItems.tinkyWinkyBag = new TinkyWinkyBag(),
				TeletubbiesItems.laaLaaBall = new LaaLaaBall(),
				TeletubbiesItems.toast = new Item(new Item.Properties().group(Teletubbies.itemGroup).food(Teletubbies.foodToast)).setRegistryName(Teletubbies.MODID, "toast"),
				TeletubbiesItems.custard = new Custard(),
				TeletubbiesItems.bowl = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "bowl")
				
				// Armor

    	//registry.register(Teletubbies.tubbyTutu);
    	/*ForgeRegistries.ITEMS.register(Teletubbies.dipsyHat);
    	ForgeRegistries.ITEMS.register(Teletubbies.nooNooEyes);
    	ForgeRegistries.ITEMS.register(Teletubbies.tinkyWinkyBib);
    	ForgeRegistries.ITEMS.register(Teletubbies.dipsyBib);
    	ForgeRegistries.ITEMS.register(Teletubbies.laaLaaBib);
    	ForgeRegistries.ITEMS.register(Teletubbies.poBib);
    	ForgeRegistries.ITEMS.register(Teletubbies.poHelmet);*/
				
		);
	}
}