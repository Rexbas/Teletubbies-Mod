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
import teletubbies.client.gui.screen.inventory.TinkyWinkyBagScreen;
import teletubbies.client.renderer.RenderRegistry;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpCapability;
import teletubbies.common.capabilities.JumpStorage;
import teletubbies.config.Config;
import teletubbies.init.ModBlocks;
import teletubbies.init.ModEntityTypes;
import teletubbies.init.ModItems;
import teletubbies.init.ModSounds;
import teletubbies.inventory.container.ContainerList;
import teletubbies.itemgroup.ItemGroupTeletubbies;

@Mod(Teletubbies.MODID)
public class Teletubbies {
    public static final String MODID = "teletubbies";
	
	public static final ItemGroup ITEMGROUP = new ItemGroupTeletubbies(MODID);

	public Teletubbies() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);

		ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModBlocks.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ModSounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());

		Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("teletubbies-server.toml").toString());
	}

	private void setup(final FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(IJumpCapability.class, new JumpStorage(), JumpCapability::new);
	}

	private void setupClient(final FMLClientSetupEvent event) {
		RenderRegistry.registryEntityRenders();
		RenderTypeLookup.setRenderLayer(ModBlocks.WINDOW.get(), RenderType.getTranslucent());
		ScreenManager.registerFactory(ContainerList.TINKYWINKY_BAG_CONTAINER, TinkyWinkyBagScreen::new);
	}
}
