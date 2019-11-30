package teletubbies;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import teletubbies.block.BlockTubbyCustardMachine;
import teletubbies.block.BlockTubbyToastMachine;
import teletubbies.block.BlockTubbyVoiceTrumpet;
import teletubbies.gui.GuiHandler;
import teletubbies.gui.config.ConfigurationHandler;
import teletubbies.item.DipsyStick;
import teletubbies.item.LaaLaaBall;
import teletubbies.item.LaaLaaStick;
import teletubbies.item.PoStick;
import teletubbies.item.TinkyWinkyBag;
import teletubbies.item.TinkyWinkyStick;
import teletubbies.item.TubbyBowl;
import teletubbies.item.TubbyCustard;
import teletubbies.item.TubbyToast;
import teletubbies.registry.ArmorRegistry;
import teletubbies.registry.BlockRegistry;
import teletubbies.registry.ItemRegistry;
import teletubbies.registry.MobRegistry;
import teletubbies.registry.RecipeRegistry;
import teletubbies.tab.TabTeletubbies;
import teletubbies.updatechecker.UpdateChecker;

@Mod(modid = Teletubbies.MODID, name = Teletubbies.NAME, version = Teletubbies.MODVERSION, guiFactory = "teletubbies.gui.GuiFactory")
public class Teletubbies
{
    public static final String MODID = "teletubbies";
    public static final String NAME = "Teletubbies";
    public static final String MODVERSION = "0.5.5";
	public static final String MCVERSION = "1.8.9";
    
	public static Configuration config;
	
	public static TeletubbiesEventHandler teletubbiesEventHandler = new TeletubbiesEventHandler();
	
	public static CreativeTabs tabTeletubbies = new TabTeletubbies(CreativeTabs.getNextID(), "Teletubbies");
    
	public static ArmorMaterial tubbyMaterial = EnumHelper.addArmorMaterial("TubbyMaterial", "TubbyMaterial", 5, new int[]{1, 3, 2, 1}, 15);

	public static Item tubbySkirt;
	public static Item dipsyHat;
	public static Item tinkyWinkyBib;
	public static Item dipsyBib;
	public static Item laaLaaBib;
	public static Item poBib;
	public static Item nooNooEyes;
	
	public static Item tinkyWinkyStick = new TinkyWinkyStick();
	public static Item dipsyStick = new DipsyStick();
	public static Item laaLaaStick = new LaaLaaStick();
    public static Item poStick = new PoStick();
	public static Item tinkyWinkyBag = new TinkyWinkyBag();
	public static Item laaLaaBall = new LaaLaaBall();
	public static Item tubbyCustard = new TubbyCustard(4, 5, false);
	public static Item tubbyToast = new TubbyToast(2, 5, false);
	public static Item tubbyBowl = new TubbyBowl();
	
	public static Block tubbyVoiceTrumpet = new BlockTubbyVoiceTrumpet();
	public static Block tubbyToastMachine = new BlockTubbyToastMachine();
	public static Block tubbyCustardMachine = new BlockTubbyCustardMachine();
		
    @SidedProxy(clientSide="teletubbies.ClientProxy", serverSide="teletubbies.CommonProxy")
    public static CommonProxy commonProxy;
    public static ClientProxy clientProxy;
    
    @Instance(MODID)
    public static Teletubbies instance;
	public static UpdateChecker updateChecker;
	public static boolean haveWarnedVersionOutOfDate = false;
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	RecipeRegistry.registerRecipes();
    }
     
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	commonProxy.registerRenders();
    	commonProxy.registerUpdateChecker();
    }
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	config = new Configuration(event.getSuggestedConfigurationFile());
    	ConfigurationHandler.syncConfig();
    	
    	MinecraftForge.EVENT_BUS.register(instance);
    	MinecraftForge.EVENT_BUS.register(teletubbiesEventHandler);
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(MODID, new GuiHandler());  
    	    	
    	BlockRegistry.registerBlocks();
    	ItemRegistry.registerItems();
    	ArmorRegistry.registerArmor();
    	MobRegistry.registerMobs();
    }
}
