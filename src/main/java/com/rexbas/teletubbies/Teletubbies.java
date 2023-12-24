package com.rexbas.teletubbies;

import com.rexbas.teletubbies.client.gui.screen.inventory.ControlPanelScreen;
import com.rexbas.teletubbies.client.gui.screen.inventory.CustardMachineScreen;
import com.rexbas.teletubbies.client.gui.screen.inventory.TinkyWinkyBagScreen;
import com.rexbas.teletubbies.client.gui.screen.inventory.ToastMachineScreen;
import com.rexbas.teletubbies.config.Config;
import com.rexbas.teletubbies.init.*;
import net.minecraft.client.gui.screens.MenuScreens;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLPaths;

@Mod(Teletubbies.MODID)
public class Teletubbies {
    public static final String MODID = "teletubbies";
	
	public Teletubbies(IEventBus modEventBus) {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_SPEC);
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
		
		modEventBus.addListener(this::setup);
		modEventBus.addListener(this::setupClient);
		
		TeletubbiesBlocks.BLOCKS.register(modEventBus);
		TeletubbiesBlocks.BLOCK_ENTITIES.register(modEventBus);
		TeletubbiesEntityTypes.ENTITY_TYPES.register(modEventBus);
		TeletubbiesItems.ITEMS.register(modEventBus);
		TeletubbiesItems.CREATIVE_TABS.register(modEventBus);
		TeletubbiesSounds.SOUNDS.register(modEventBus);
		TeletubbiesWorldGen.STRUCTURE_TYPES.register(modEventBus);
		TeletubbiesWorldGen.FEATURES.register(modEventBus);
		TeletubbiesContainers.CONTAINER_TYPES.register(modEventBus);

		Config.loadConfig(Config.COMMON_SPEC, FMLPaths.CONFIGDIR.get().resolve("teletubbies-common.toml").toString());
		Config.loadConfig(Config.CLIENT_SPEC, FMLPaths.CONFIGDIR.get().resolve("teletubbies-client.toml").toString());
	}
	
	private void setup(final FMLCommonSetupEvent event) {
		event.enqueueWork(TeletubbiesEntityTypes::registerPlacement);
	}

	private void setupClient(final FMLClientSetupEvent event) {
		MenuScreens.register(TeletubbiesContainers.TINKYWINKY_BAG_CONTAINER.get(), TinkyWinkyBagScreen::new);
		MenuScreens.register(TeletubbiesContainers.CONTROL_PANEL_CONTAINER.get(), ControlPanelScreen::new);
		MenuScreens.register(TeletubbiesContainers.TOAST_MACHINE_CONTAINER.get(), ToastMachineScreen::new);
		MenuScreens.register(TeletubbiesContainers.CUSTARD_MACHINE_CONTAINER.get(), CustardMachineScreen::new);
	}
}