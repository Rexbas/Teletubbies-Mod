package teletubbies;

import net.minecraft.item.Food;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import teletubbies.client.renderer.RenderRegistry;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpCapability;
import teletubbies.common.capabilities.JumpStorage;
import teletubbies.itemgroup.ItemGroupTeletubbies;

@Mod(Teletubbies.MODID)
public class Teletubbies {
    public static Teletubbies instance;
	
    public static final String MODID = "teletubbies";
	
	public static TeletubbiesEventHandler EVENT_HANDLER = new TeletubbiesEventHandler();
		
	public static ItemGroup ITEMGROUP = new ItemGroupTeletubbies(MODID);
	public static Food CUSTARD_FOOD;
	public static Food TOAST_FOOD;
	
	public Teletubbies() {
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);

		MinecraftForge.EVENT_BUS.register(instance);
    	MinecraftForge.EVENT_BUS.register(EVENT_HANDLER);
	}
	
	public void setup(final FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(IJumpCapability.class, new JumpStorage(), JumpCapability::new);
	}
    
	public void setupClient(final FMLClientSetupEvent event) {
		RenderRegistry.registryEntityRenders();
	}
}
