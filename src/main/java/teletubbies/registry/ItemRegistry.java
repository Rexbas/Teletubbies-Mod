package teletubbies.registry;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.armor.ArmorSimple;
import teletubbies.item.Custard;
import teletubbies.item.LaaLaaBall;
import teletubbies.item.TinkyWinkyBag;
import teletubbies.lists.BlockList;
import teletubbies.lists.ItemList;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemRegistry {

	@SubscribeEvent
	public static void registerItemsEvent(final RegistryEvent.Register<Item> event) {
		Teletubbies.foodCustard= (new Food.Builder()).hunger(4).saturation(5).build();
		Teletubbies.foodToast= (new Food.Builder()).hunger(2).saturation(5).fastToEat().build();

		event.getRegistry().registerAll(
				// Blocks
				ItemList.voiceTrumpet = new BlockItem(BlockList.voiceTrumpet, new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(BlockList.voiceTrumpet.getRegistryName()),
				
				// Items
				ItemList.tinkywinkyStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "tinkywinkystick"), 
				ItemList.dipsyStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "dipsystick"),
				ItemList.laalaaStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "laalaastick"),
				ItemList.poStick = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "postick"),
				ItemList.tinkywinkyBag = new TinkyWinkyBag(),
				ItemList.laalaaBall = new LaaLaaBall(),
				ItemList.toast = new Item(new Item.Properties().group(Teletubbies.itemGroup).food(Teletubbies.foodToast)).setRegistryName(Teletubbies.MODID, "toast"),
				ItemList.custard = new Custard(),
				ItemList.bowl = new Item(new Item.Properties().group(Teletubbies.itemGroup)).setRegistryName(Teletubbies.MODID, "bowl"),
				
				// Armor
				/*registry.register(Teletubbies.tubbyTutu);
		    	ForgeRegistries.ITEMS.register(Teletubbies.dipsyHat);
		    	ForgeRegistries.ITEMS.register(Teletubbies.nooNooEyes);*/
				ItemList.tinkywinkyBib = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "tinkywinkybib"),
				ItemList.dipsyBib = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "dipsybib"),
				ItemList.laalaaBib = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "laalaabib"),
				ItemList.poBib = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "pobib"),
				ItemList.poHelmet = new ArmorSimple(ArmorMaterial.IRON, EquipmentSlotType.HEAD, "pohelmet")
		);
	}
}