package teletubbies.lists;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.armor.ArmorSimple;
import teletubbies.items.Custard;
import teletubbies.items.LaaLaaBall;
import teletubbies.items.TinkyWinkyBag;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemList {
	// Blocks
	public static final Item VOICE_TRUMPET = new BlockItem(BlockList.VOICE_TRUMPET, new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName(BlockList.VOICE_TRUMPET.getRegistryName());
	public static final Item TOAST_MACHINE = new BlockItem(BlockList.TOAST_MACHINE, new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName(BlockList.TOAST_MACHINE.getRegistryName());
	public static final Item CUSTARD_MACHINE = new BlockItem(BlockList.CUSTARD_MACHINE, new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName(BlockList.CUSTARD_MACHINE.getRegistryName());
	
	// Items
	public static final Item TINKYWINKY_STICK = new Item(new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName(Teletubbies.MODID, "tinkywinky_stick");
	public static final Item DIPSY_STICK = new Item(new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName(Teletubbies.MODID, "dipsy_stick");
	public static final Item LAALAA_STICK = new Item(new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName(Teletubbies.MODID, "laalaa_stick");
    public static final Item PO_STICK = new Item(new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName(Teletubbies.MODID, "po_stick");
	public static final Item TINKYWINKY_BAG = new TinkyWinkyBag();
	public static final Item LAALAA_BALL = new LaaLaaBall();
	public static final Item BOWL = new Item(new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName(Teletubbies.MODID, "bowl");
	public static final Item CUSTARD = new Custard();
	public static final Item TOAST = new Item(new Item.Properties().group(Teletubbies.ITEMGROUP).food(Teletubbies.TOAST_FOOD)).setRegistryName(Teletubbies.MODID, "toast");
	//public static final Item poScooter = new ItemPoScooter();
	
	// Armor
	public static final Item TINKYWINKY_BIB = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "tinkywinky_bib");
	public static final Item DIPSY_BIB = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "dipsy_bib");
	public static final Item LAALAA_BIB = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "laalaa_bib");
	public static final Item PO_BIB = new ArmorSimple(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, "po_bib");
	public static final Item PO_HELMET = new ArmorSimple(ArmorMaterial.IRON, EquipmentSlotType.HEAD, "po_helmet");
	
	// SpawnEggs
	public static final Item TINKYWINKY_SPAWN_EGG = new SpawnEggItem(EntityList.TINKYWINKY, 0x7E2CD3, 0xFFC9AD, new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName("tinkywinky_spawn_egg");
	public static final Item DIPSY_SPAWN_EGG = new SpawnEggItem(EntityList.DIPSY, 0x84CA32, 0xB38A4E, new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName("dipsy_spawn_egg");	
	public static final Item LAALAA_SPAWN_EGG = new SpawnEggItem(EntityList.LAALAA, 0xDED32C, 0xFFC9AD, new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName("laalaa_spawn_egg");
	public static final Item PO_SPAWN_EGG = new SpawnEggItem(EntityList.PO, 0xD62828, 0xFFC9AD, new Item.Properties().group(Teletubbies.ITEMGROUP)).setRegistryName("po_spawn_egg");

	@SubscribeEvent
	public static void registerItemsEvent(final RegistryEvent.Register<Item> event) {
		Teletubbies.CUSTARD_FOOD= (new Food.Builder()).hunger(4).saturation(5).build();
		Teletubbies.TOAST_FOOD= (new Food.Builder()).hunger(2).saturation(5).fastToEat().build();
		
		event.getRegistry().registerAll(			
				VOICE_TRUMPET, TOAST_MACHINE, CUSTARD_MACHINE,
				
				TINKYWINKY_STICK, DIPSY_STICK, LAALAA_STICK, PO_STICK, TINKYWINKY_BAG, LAALAA_BALL,
				BOWL, CUSTARD, TOAST,
				
				TINKYWINKY_BIB, DIPSY_BIB, LAALAA_BIB, PO_BIB, PO_HELMET,
				
				TINKYWINKY_SPAWN_EGG, DIPSY_SPAWN_EGG, LAALAA_SPAWN_EGG, PO_SPAWN_EGG
				
		);
	}
}
