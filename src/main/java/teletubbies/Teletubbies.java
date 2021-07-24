package teletubbies;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import teletubbies.client.gui.screen.inventory.ControlPanelScreen;
import teletubbies.client.gui.screen.inventory.CustardMachineScreen;
import teletubbies.client.gui.screen.inventory.TinkyWinkyBagScreen;
import teletubbies.client.gui.screen.inventory.ToastMachineScreen;
import teletubbies.client.renderer.RenderRegistry;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpCapability;
import teletubbies.common.capabilities.JumpStorage;
import teletubbies.config.Config;
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
	
	public static final ItemGroup ITEMGROUP = new ItemGroupTeletubbies(MODID);

	public Teletubbies() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
		

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);

		TeletubbiesBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		TeletubbiesBlocks.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
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
		CapabilityManager.INSTANCE.register(IJumpCapability.class, new JumpStorage(), JumpCapability::new);
	}

	private void setupClient(final FMLClientSetupEvent event) {
		RenderRegistry.registryEntityRenders();
		RenderTypeLookup.setRenderLayer(TeletubbiesBlocks.WINDOW.get(), RenderType.translucent());
		ScreenManager.register(TeletubbiesContainers.TINKYWINKY_BAG_CONTAINER.get(), TinkyWinkyBagScreen::new);
		ScreenManager.register(TeletubbiesContainers.CONTROL_PANEL_CONTAINER.get(), ControlPanelScreen::new);
		ScreenManager.register(TeletubbiesContainers.TOAST_MACHINE_CONTAINER.get(), ToastMachineScreen::new);
		ScreenManager.register(TeletubbiesContainers.CUSTARD_MACHINE_CONTAINER.get(), CustardMachineScreen::new);
	}
}
