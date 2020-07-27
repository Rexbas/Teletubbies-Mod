package teletubbies;

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
import teletubbies.block.BlockList;
import teletubbies.client.renderer.RenderRegistry;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpCapability;
import teletubbies.common.capabilities.JumpStorage;
import teletubbies.config.Config;
import teletubbies.entity.EntityList;
import teletubbies.itemgroup.ItemGroupTeletubbies;

@Mod(Teletubbies.MODID)
public class Teletubbies {
    public static final String MODID = "teletubbies";
	
	public static ItemGroup ITEMGROUP = new ItemGroupTeletubbies(MODID);

	public Teletubbies() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.SERVER_CONFIG);

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);

		Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve("teletubbies-server.toml").toString());
	}

	public void setup(final FMLCommonSetupEvent event) {
		EntityList.setAttributes();
		CapabilityManager.INSTANCE.register(IJumpCapability.class, new JumpStorage(), JumpCapability::new);
	}

	public void setupClient(final FMLClientSetupEvent event) {
		RenderRegistry.registryEntityRenders();
		RenderTypeLookup.setRenderLayer(BlockList.WINDOW, RenderType.getTranslucent());
		//ScreenManager.registerFactory(ContainerList.TINKYWINKY_BAG_CONTAINER, TinkyWinkyBagScreen::new);
	}
}
