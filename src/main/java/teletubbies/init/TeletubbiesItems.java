package teletubbies.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;
import teletubbies.item.CustardItem;
import teletubbies.item.LaaLaaBallItem;
import teletubbies.item.PoScooterItem;
import teletubbies.item.TinkyWinkyBagItem;
import teletubbies.item.ToastItem;
import teletubbies.item.armor.DipsyHatItem;
import teletubbies.item.armor.NooNooEyesItem;
import teletubbies.item.armor.SimpleArmorItem;
import teletubbies.item.armor.TutuItem;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Teletubbies.MODID);
	
	// Blocks
	public static final RegistryObject<Item> FULL_GRASS = ITEMS.register("full_grass", () -> new BlockItem(TeletubbiesBlocks.FULL_GRASS.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> CONTROL_PANEL = ITEMS.register("control_panel", () -> new BlockItem(TeletubbiesBlocks.CONTROL_PANEL.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> VOICE_TRUMPET = ITEMS.register("voice_trumpet", () -> new BlockItem(TeletubbiesBlocks.VOICE_TRUMPET.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> TOAST_MACHINE = ITEMS.register("toast_machine", () -> new BlockItem(TeletubbiesBlocks.TOAST_MACHINE.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> CUSTARD_MACHINE = ITEMS.register("custard_machine", () -> new BlockItem(TeletubbiesBlocks.CUSTARD_MACHINE.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> WINDOW = ITEMS.register("window", () -> new BlockItem(TeletubbiesBlocks.WINDOW.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));

	// Items
	public static final RegistryObject<Item> TINKYWINKY_STICK = ITEMS.register("tinkywinky_stick", () -> new Item(new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> DIPSY_STICK = ITEMS.register("dipsy_stick", () -> new Item(new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> LAALAA_STICK = ITEMS.register("laalaa_stick", () -> new Item(new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> PO_STICK = ITEMS.register("po_stick", () -> new Item(new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> TINKYWINKY_BAG = ITEMS.register("tinkywinky_bag", TinkyWinkyBagItem::new);
	public static final RegistryObject<Item> LAALAA_BALL = ITEMS.register("laalaa_ball", LaaLaaBallItem::new);
	public static final RegistryObject<Item> BOWL = ITEMS.register("bowl", () -> new Item(new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> CUSTARD = ITEMS.register("custard", CustardItem::new);
	public static final RegistryObject<Item> TOAST = ITEMS.register("toast", ToastItem::new);
	
	// Vehicle
	public static final RegistryObject<Item> PO_SCOOTER = ITEMS.register("po_scooter", PoScooterItem::new);
	
	// Armor
	public static final RegistryObject<Item> TUTU = ITEMS.register("tutu", TutuItem::new);
	public static final RegistryObject<Item> NOONOO_EYES = ITEMS.register("noonoo_eyes", NooNooEyesItem::new);
	public static final RegistryObject<Item> DIPSY_HAT = ITEMS.register("dipsy_hat", DipsyHatItem::new);
	public static final RegistryObject<Item> TINKYWINKY_BIB = ITEMS.register("tinkywinky_bib", () -> new SimpleArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> DIPSY_BIB = ITEMS.register("dipsy_bib", () -> new SimpleArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> LAALAA_BIB = ITEMS.register("laalaa_bib", () -> new SimpleArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> PO_BIB = ITEMS.register("po_bib", () -> new SimpleArmorItem(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST));
	public static final RegistryObject<Item> PO_HELMET = ITEMS.register("po_helmet", () -> new SimpleArmorItem(ArmorMaterial.IRON, EquipmentSlotType.HEAD));
}
