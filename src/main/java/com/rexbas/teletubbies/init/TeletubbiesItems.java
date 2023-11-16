package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.item.*;
import com.rexbas.teletubbies.item.armor.DipsyHatItem;
import com.rexbas.teletubbies.item.armor.NooNooEyesItem;
import com.rexbas.teletubbies.item.armor.SimpleArmorItem;
import com.rexbas.teletubbies.item.armor.TutuItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;

public class TeletubbiesItems {
	
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Teletubbies.MODID);
	public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Teletubbies.MODID);
	
	// Blocks
	public static final RegistryObject<Item> FULL_GRASS = ITEMS.register("full_grass", () -> new BlockItem(TeletubbiesBlocks.FULL_GRASS.get(), new Item.Properties()));
	public static final RegistryObject<Item> CONTROL_PANEL = ITEMS.register("control_panel", () -> new BlockItem(TeletubbiesBlocks.CONTROL_PANEL.get(), new Item.Properties()));
	public static final RegistryObject<Item> VOICE_TRUMPET = ITEMS.register("voice_trumpet", () -> new BlockItem(TeletubbiesBlocks.VOICE_TRUMPET.get(), new Item.Properties()));
	public static final RegistryObject<Item> TOAST_MACHINE = ITEMS.register("toast_machine", () -> new BlockItem(TeletubbiesBlocks.TOAST_MACHINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> CUSTARD_MACHINE = ITEMS.register("custard_machine", () -> new BlockItem(TeletubbiesBlocks.CUSTARD_MACHINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> WINDOW = ITEMS.register("window", () -> new BlockItem(TeletubbiesBlocks.WINDOW.get(), new Item.Properties()));

	// Items
	public static final RegistryObject<Item> TINKYWINKY_ANTENNA = ITEMS.register("tinkywinky_antenna", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> DIPSY_ANTENNA = ITEMS.register("dipsy_antenna", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> LAALAA_ANTENNA = ITEMS.register("laalaa_antenna", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> PO_ANTENNA = ITEMS.register("po_antenna", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> TINKYWINKY_BAG = ITEMS.register("tinkywinky_bag", TinkyWinkyBagItem::new);
	public static final RegistryObject<Item> LAALAA_BALL = ITEMS.register("laalaa_ball", LaaLaaBall::new);
	public static final RegistryObject<Item> BOWL = ITEMS.register("bowl", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CUSTARD = ITEMS.register("custard", CustardItem::new);
	public static final RegistryObject<Item> TOAST = ITEMS.register("toast", ToastItem::new);
	
	// Vehicle
	public static final RegistryObject<Item> PO_SCOOTER = ITEMS.register("po_scooter", PoScooterItem::new);
	
	// Armor
	public static final RegistryObject<Item> TUTU = ITEMS.register("tutu", TutuItem::new);
	public static final RegistryObject<Item> NOONOO_EYES = ITEMS.register("noonoo_eyes", NooNooEyesItem::new);
	public static final RegistryObject<Item> DIPSY_HAT = ITEMS.register("dipsy_hat", DipsyHatItem::new);
	public static final RegistryObject<Item> TINKYWINKY_BIB = ITEMS.register("tinkywinky_bib", () -> new SimpleArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> DIPSY_BIB = ITEMS.register("dipsy_bib", () -> new SimpleArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> LAALAA_BIB = ITEMS.register("laalaa_bib", () -> new SimpleArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> PO_BIB = ITEMS.register("po_bib", () -> new SimpleArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.CHESTPLATE));
	public static final RegistryObject<Item> PO_HELMET = ITEMS.register("po_helmet", () -> new SimpleArmorItem(ArmorMaterials.IRON, ArmorItem.Type.HELMET));
	
	// Spawn Eggs
	public static final RegistryObject<Item> TINKYWINKY_SPAWN_EGG = ITEMS.register("tinkywinky_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.TINKYWINKY, 0x7E2CD3, 0xFFC9AD, (new Item.Properties())));
	public static final RegistryObject<Item> DIPSY_SPAWN_EGG = ITEMS.register("dipsy_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.DIPSY, 0x84CA32, 0xFFC9AD, (new Item.Properties())));
	public static final RegistryObject<Item> LAALAA_SPAWN_EGG = ITEMS.register("laalaa_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.LAALAA, 0xDED32C, 0xFFC9AD, (new Item.Properties())));
	public static final RegistryObject<Item> PO_SPAWN_EGG = ITEMS.register("po_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.PO, 0xD62828, 0xFFC9AD, (new Item.Properties())));
	public static final RegistryObject<Item> NOONOO_SPAWN_EGG = ITEMS.register("noonoo_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.NOONOO, 0x0099FF, 0xE166CC, (new Item.Properties())));
	public static final RegistryObject<Item> MIMI_SPAWN_EGG = ITEMS.register("mimi_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.MIMI, 0x1591B4, 0xC8946A, (new Item.Properties())));
	public static final RegistryObject<Item> DAADAA_SPAWN_EGG = ITEMS.register("daadaa_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.DAADAA, 0x53AC09, 0xC8946A, (new Item.Properties())));
	public static final RegistryObject<Item> PING_SPAWN_EGG = ITEMS.register("ping_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.PING, 0xC6419E, 0xC8946A, (new Item.Properties())));
	public static final RegistryObject<Item> BA_SPAWN_EGG = ITEMS.register("ba_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.BA, 0x062C5E, 0xC8946A, (new Item.Properties())));
	public static final RegistryObject<Item> RURU_SPAWN_EGG = ITEMS.register("ruru_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.RURU, 0xDA7123, 0xC8946A, (new Item.Properties())));
	public static final RegistryObject<Item> NIN_SPAWN_EGG = ITEMS.register("nin_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.NIN, 0x9F286E, 0xC8946A, (new Item.Properties())));
	public static final RegistryObject<Item> DUGGLEDEE_SPAWN_EGG = ITEMS.register("duggledee_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.DUGGLEDEE, 0xB4213E, 0xC8946A, (new Item.Properties())));
	public static final RegistryObject<Item> UMPIEPUMPIE_SPAWN_EGG = ITEMS.register("umpiepumpie_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.UMPIEPUMPIE, 0xD8BF29, 0xC8946A, (new Item.Properties())));
	public static final RegistryObject<Item> TINKYWINKY_ZOMBIE_SPAWN_EGG = ITEMS.register("tinkywinky_zombie_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE, 0x7E2CD3, 0x660000, (new Item.Properties())));
	public static final RegistryObject<Item> DIPSY_ZOMBIE_SPAWN_EGG = ITEMS.register("dipsy_zombie_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.DIPSY_ZOMBIE, 0x84CA32, 0x660000, (new Item.Properties())));
	public static final RegistryObject<Item> LAALAA_ZOMBIE_SPAWN_EGG = ITEMS.register("laalaa_zombie_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.LAALAA_ZOMBIE, 0xDED32C, 0x660000, (new Item.Properties())));
	public static final RegistryObject<Item> PO_ZOMBIE_SPAWN_EGG = ITEMS.register("po_zombie_spawn_egg", () -> new DeferredSpawnEggItem(TeletubbiesEntityTypes.PO_ZOMBIE, 0xD62828, 0x660000, (new Item.Properties())));

	public static RegistryObject<CreativeModeTab> TAB = CREATIVE_TABS.register("teletubbies_tab",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("item_group." + Teletubbies.MODID))
					.icon(() -> new ItemStack(PO_ANTENNA.get()))
					.displayItems((params, output) -> {
						output.accept(FULL_GRASS.get());
						output.accept(CONTROL_PANEL.get());
						output.accept(VOICE_TRUMPET.get());
						output.accept(TOAST_MACHINE.get());
						output.accept(CUSTARD_MACHINE.get());
						output.accept(WINDOW.get());

						output.accept(TINKYWINKY_ANTENNA.get());
						output.accept(DIPSY_ANTENNA.get());
						output.accept(LAALAA_ANTENNA.get());
						output.accept(PO_ANTENNA.get());
						output.accept(TINKYWINKY_BAG.get());
						output.accept(LAALAA_BALL.get());
						output.accept(BOWL.get());
						output.accept(CUSTARD.get());
						output.accept(TOAST.get());

						output.accept(PO_SCOOTER.get());

						output.accept(TUTU.get());
						output.accept(NOONOO_EYES.get());
						output.accept(DIPSY_HAT.get());
						output.accept(TINKYWINKY_BIB.get());
						output.accept(DIPSY_BIB.get());
						output.accept(LAALAA_BIB.get());
						output.accept(PO_BIB.get());
						output.accept(PO_HELMET.get());

						output.accept(TINKYWINKY_SPAWN_EGG.get());
						output.accept(DIPSY_SPAWN_EGG.get());
						output.accept(LAALAA_SPAWN_EGG.get());
						output.accept(PO_SPAWN_EGG.get());
						output.accept(NOONOO_SPAWN_EGG.get());
						output.accept(MIMI_SPAWN_EGG.get());
						output.accept(DAADAA_SPAWN_EGG.get());
						output.accept(PING_SPAWN_EGG.get());
						output.accept(BA_SPAWN_EGG.get());
						output.accept(RURU_SPAWN_EGG.get());
						output.accept(NIN_SPAWN_EGG.get());
						output.accept(DUGGLEDEE_SPAWN_EGG.get());
						output.accept(UMPIEPUMPIE_SPAWN_EGG.get());
						output.accept(TINKYWINKY_ZOMBIE_SPAWN_EGG.get());
						output.accept(DIPSY_ZOMBIE_SPAWN_EGG.get());
						output.accept(LAALAA_ZOMBIE_SPAWN_EGG.get());
						output.accept(PO_ZOMBIE_SPAWN_EGG.get());
					})
					.build());

}