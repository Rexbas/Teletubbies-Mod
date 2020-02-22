package teletubbies;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.Food;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import teletubbies.block.BlockList;
import teletubbies.client.gui.screen.inventory.TinkyWinkyBagScreen;
import teletubbies.client.renderer.RenderRegistry;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpCapability;
import teletubbies.common.capabilities.JumpStorage;
import teletubbies.inventory.container.ContainerList;
import teletubbies.itemgroup.ItemGroupTeletubbies;

@Mod(Teletubbies.MODID)
public class Teletubbies {
    public static final String MODID = "teletubbies";
	
	public static ItemGroup ITEMGROUP = new ItemGroupTeletubbies(MODID);
	public static Food CUSTARD_FOOD;
	public static Food TOAST_FOOD;
		
	public Teletubbies() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);
	}
	
	public void setup(final FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(IJumpCapability.class, new JumpStorage(), JumpCapability::new);
	}
    
	public void setupClient(final FMLClientSetupEvent event) {
		RenderRegistry.registryEntityRenders();
		RenderTypeLookup.setRenderLayer(BlockList.WINDOW, RenderType.getTranslucent());
        ScreenManager.registerFactory(ContainerList.TINKYWINKY_BAG_CONTAINER, TinkyWinkyBagScreen::new);
	}
}
