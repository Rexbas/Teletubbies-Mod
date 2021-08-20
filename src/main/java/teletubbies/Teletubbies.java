package teletubbies;

import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import teletubbies.capabilities.IJumpCapability;
import teletubbies.client.gui.screen.inventory.ControlPanelScreen;
import teletubbies.client.gui.screen.inventory.CustardMachineScreen;
import teletubbies.client.gui.screen.inventory.TinkyWinkyBagScreen;
import teletubbies.client.gui.screen.inventory.ToastMachineScreen;
import teletubbies.config.Config;
import teletubbies.data.BlockTagProvider;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.init.TeletubbiesContainers;
import teletubbies.init.TeletubbiesEntityTypes;
import teletubbies.init.TeletubbiesItems;
import teletubbies.init.TeletubbiesSounds;
import teletubbies.init.TeletubbiesWorldGen;
import teletubbies.itemgroup.ItemGroupTeletubbies;

@Mod(Teletubbies.MODID)
public class Teletubbies {
    public static final String MODID = "teletubbies";
	
	public static final CreativeModeTab ITEMGROUP = new ItemGroupTeletubbies(MODID);

	public Teletubbies() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);		
		
		TeletubbiesBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		TeletubbiesBlocks.BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
		TeletubbiesEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		TeletubbiesItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		TeletubbiesSounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
		TeletubbiesWorldGen.FEATURES.register(FMLJavaModLoadingContext.get().getModEventBus());
		TeletubbiesWorldGen.STRUCTURES.register(FMLJavaModLoadingContext.get().getModEventBus());
		TeletubbiesContainers.CONTAINER_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

		Config.loadConfig(Config.COMMON_SPEC, FMLPaths.CONFIGDIR.get().resolve("teletubbies-common.toml").toString());
		Config.loadConfig(Config.CLIENT_SPEC, FMLPaths.CONFIGDIR.get().resolve("teletubbies-client.toml").toString());
	}

	private void setup(final FMLCommonSetupEvent event) {		
		CapabilityManager.INSTANCE.register(IJumpCapability.class);
	}

	private void setupClient(final FMLClientSetupEvent event) {
		ItemBlockRenderTypes.setRenderLayer(TeletubbiesBlocks.WINDOW.get(), RenderType.translucent());
		MenuScreens.register(TeletubbiesContainers.TINKYWINKY_BAG_CONTAINER.get(), TinkyWinkyBagScreen::new);
		MenuScreens.register(TeletubbiesContainers.CONTROL_PANEL_CONTAINER.get(), ControlPanelScreen::new);
		MenuScreens.register(TeletubbiesContainers.TOAST_MACHINE_CONTAINER.get(), ToastMachineScreen::new);
		MenuScreens.register(TeletubbiesContainers.CUSTARD_MACHINE_CONTAINER.get(), CustardMachineScreen::new);
	}
}
