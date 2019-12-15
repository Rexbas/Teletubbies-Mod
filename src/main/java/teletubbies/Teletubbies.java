package teletubbies;

import net.minecraft.item.Food;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import teletubbies.capability.IJumpCapability;
import teletubbies.capability.JumpCapability;
import teletubbies.capability.JumpStorage;
import teletubbies.client.renders.RenderRegistry;
import teletubbies.itemgroup.TeletubbiesItemGroup;

@Mod(Teletubbies.MODID)
public class Teletubbies {
    public static Teletubbies instance;
	
    public static final String MODID = "teletubbies";
	
	public static TeletubbiesEventHandler teletubbiesEventHandler = new TeletubbiesEventHandler();
		
	public static ItemGroup ITEMGROUP = new TeletubbiesItemGroup(MODID);
	public static Food CUSTARD_FOOD;
	public static Food TOAST_FOOD;
	
	public Teletubbies() {
		instance = this;

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setupClient);

		
		MinecraftForge.EVENT_BUS.register(instance);
    	MinecraftForge.EVENT_BUS.register(teletubbiesEventHandler);
	}
	
    public void setup(final FMLCommonSetupEvent event) {
    	 CapabilityManager.INSTANCE.register(IJumpCapability.class, new JumpStorage(), JumpCapability::new);
    	    	
    	/*EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":PoScooter"), EntityPoScooter.class, "poscooter", 17, Teletubbies.MODID, 40, 1, true);
    	    	
    	GameRegistry.registerWorldGenerator(new GenTubbyDomeStructure(), 1000);
    	GameRegistry.registerWorldGenerator(new GenTubbyVoiceTrumpet(), 1000);*/
    }
    
    public void setupClient(final FMLClientSetupEvent event) {
    	RenderRegistry.registryEntityRenders();
    }
}
