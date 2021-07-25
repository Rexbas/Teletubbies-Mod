package teletubbies.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;
import teletubbies.item.CustardItem;
import teletubbies.item.LaaLaaBallItem;
import teletubbies.item.TinkyWinkyBagItem;
import teletubbies.item.ToastItem;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Teletubbies.MODID);
	
	// Blocks
	/*public static final RegistryObject<Item> FULL_GRASS = ITEMS.register("full_grass", () -> new BlockItem(TeletubbiesBlocks.FULL_GRASS.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> CONTROL_PANEL = ITEMS.register("control_panel", () -> new BlockItem(TeletubbiesBlocks.CONTROL_PANEL.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> VOICE_TRUMPET = ITEMS.register("voice_trumpet", () -> new BlockItem(TeletubbiesBlocks.VOICE_TRUMPET.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> TOAST_MACHINE = ITEMS.register("toast_machine", () -> new BlockItem(TeletubbiesBlocks.TOAST_MACHINE.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> CUSTARD_MACHINE = ITEMS.register("custard_machine", () -> new BlockItem(TeletubbiesBlocks.CUSTARD_MACHINE.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> WINDOW = ITEMS.register("window", () -> new BlockItem(TeletubbiesBlocks.WINDOW.get(), new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	 */
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
	//public static final RegistryObject<Item> PO_SCOOTER = ITEMS.register("po_scooter", PoScooterItem::new);
	
	// Armor
	/*public static final RegistryObject<Item> TUTU = ITEMS.register("tutu", TutuItem::new);
	public static final RegistryObject<Item> NOONOO_EYES = ITEMS.register("noonoo_eyes", NooNooEyesItem::new);
	public static final RegistryObject<Item> DIPSY_HAT = ITEMS.register("dipsy_hat", DipsyHatItem::new);
	public static final RegistryObject<Item> TINKYWINKY_BIB = ITEMS.register("tinkywinky_bib", () -> new SimpleArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST));
	public static final RegistryObject<Item> DIPSY_BIB = ITEMS.register("dipsy_bib", () -> new SimpleArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST));
	public static final RegistryObject<Item> LAALAA_BIB = ITEMS.register("laalaa_bib", () -> new SimpleArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST));
	public static final RegistryObject<Item> PO_BIB = ITEMS.register("po_bib", () -> new SimpleArmorItem(ArmorMaterials.LEATHER, EquipmentSlot.CHEST));
	public static final RegistryObject<Item> PO_HELMET = ITEMS.register("po_helmet", () -> new SimpleArmorItem(ArmorMaterials.IRON, EquipmentSlot.HEAD));
	*/
	// Spawn eggs
	/*public static final RegistryObject<Item> TINKYWINKY_SPAWN_EGG = ITEMS.register("tinkywinky_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.TINKYWINKY, 0x7E2CD3, 0xFFC9AD, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> DIPSY_SPAWN_EGG = ITEMS.register("dipsy_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.DIPSY, 0x84CA32, 0xFFC9AD, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> LAALAA_SPAWN_EGG = ITEMS.register("laalaa_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.LAALAA, 0xDED32C, 0xFFC9AD, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> PO_SPAWN_EGG = ITEMS.register("po_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.PO, 0xD62828, 0xFFC9AD, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> NOONOO_SPAWN_EGG = ITEMS.register("noonoo_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.NOONOO, 0x0099FF, 0xE166CC, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> MIMI_SPAWN_EGG = ITEMS.register("mimi_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.MIMI, 0x1591B4, 0xC8946A, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> DAADAA_SPAWN_EGG = ITEMS.register("daadaa_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.DAADAA, 0x53AC09, 0xC8946A, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> PING_SPAWN_EGG = ITEMS.register("ping_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.PING, 0xC6419E, 0xC8946A, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> BA_SPAWN_EGG = ITEMS.register("ba_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.BA, 0x062C5E, 0xC8946A, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> RURU_SPAWN_EGG = ITEMS.register("ruru_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.RURU, 0xDA7123, 0xC8946A, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> NIN_SPAWN_EGG = ITEMS.register("nin_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.NIN, 0x9F286E, 0xC8946A, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> DUGGLEDEE_SPAWN_EGG = ITEMS.register("duggledee_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.DUGGLEDEE, 0xB4213E, 0xC8946A, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> UMPIEPUMPIE_SPAWN_EGG = ITEMS.register("umpiepumpie_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.UMPIEPUMPIE, 0xD8BF29, 0xC8946A, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> TINKYWINKY_ZOMBIE_SPAWN_EGG = ITEMS.register("tinkywinky_zombie_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE, 0x7E2CD3, 0x660000, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> DIPSY_ZOMBIE_SPAWN_EGG = ITEMS.register("dipsy_zombie_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.DIPSY_ZOMBIE, 0x84CA32, 0x660000, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> LAALAA_ZOMBIE_SPAWN_EGG = ITEMS.register("laalaa_zombie_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.LAALAA_ZOMBIE, 0xDED32C, 0x660000, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	public static final RegistryObject<Item> PO_ZOMBIE_SPAWN_EGG = ITEMS.register("po_zombie_spawn_egg", () -> new ModSpawnEggItem(TeletubbiesEntityTypes.PO_ZOMBIE, 0xD62828, 0x660000, new Item.Properties().tab(Teletubbies.ITEMGROUP)));
	*/
}
