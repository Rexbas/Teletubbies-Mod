package teletubbies.registry;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.TeletubbiesItems;
import teletubbies.armor.ArmorSimple;
import teletubbies.item.Custard;
import teletubbies.item.LaaLaaBall;
import teletubbies.item.TinkyWinkyBag;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {

	@SubscribeEvent
	public static void registerItemsEvent(final RegistryEvent.Register<Item> event) {
		Teletubbies.foodCustard= (new Food.Builder()).hunger(4).saturation(5).build();
		Teletubbies.foodToast= (new Food.Builder()).hunger(2).saturation(5).fastToEat().build();

		event.getRegistry().registerAll(
				// Items
				TeletubbiesItems.tinkywinkyStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "tinkywinkystick"), 
				TeletubbiesItems.dipsyStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "dipsystick"),
				TeletubbiesItems.laalaaStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "laalaastick"),
				TeletubbiesItems.poStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "postick"),
				TeletubbiesItems.tinkywinkyBag = new TinkyWinkyBag(),
				TeletubbiesItems.laalaaBall = new LaaLaaBall(),
				TeletubbiesItems.toast = new Item(new Item.Properties().group(Teletubbies.itemGroup).food(Teletubbies.foodToast)).setRegistryName(Teletubbies.MODID, "toast"),
				TeletubbiesItems.custard = new Custard(),
				TeletubbiesItems.bowl = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "bowl"),
				
				// Armor
				/*registry.register(Teletubbies.tubbyTutu);
		    	ForgeRegistries.ITEMS.register(Teletubbies.dipsyHat);
		    	ForgeRegistries.ITEMS.register(Teletubbies.nooNooEyes);*/
				TeletubbiesItems.tinkywinkyBib = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "tinkywinkybib"),
				TeletubbiesItems.dipsyBib = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "dipsybib"),
				TeletubbiesItems.laalaaBib = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "laalaabib"),
				TeletubbiesItems.poBib = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "pobib"),
				TeletubbiesItems.poHelmet = new ArmorSimple(ArmorMaterial.IRON, EquipmentSlotType.HEAD, "pohelmet")
		);
	}
}