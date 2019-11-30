package teletubbies;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teletubbies.block.BlockTubbyCustardMachine;
import teletubbies.block.BlockTubbyToastMachine;
import teletubbies.block.BlockTubbyVoiceTrumpet;
import teletubbies.capability.ITeletubbies_CAP;
import teletubbies.capability.Teletubbies_CAPProvider;
import teletubbies.capability.Teletubbies_CAPStorage;
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
import teletubbies.registry.SoundRegistry;
import teletubbies.structure.GenTubbyDomeStructure;
import teletubbies.structure.GenTubbyVoiceTrumpet;
import teletubbies.tab.TabTeletubbies;

@Mod(modid = Teletubbies.MODID, name = Teletubbies.MODNAME, version = "@{version}", updateJSON = "https://raw.githubusercontent.com/Rexbas/Teletubbies-Mod/update/update.json")
public class Teletubbies
{
    public static final String MODID = "teletubbies";
    public static final String MODNAME = "Teletubbies";
    	
	@CapabilityInject(ITeletubbies_CAP.class)
	public static final Capability<ITeletubbies_CAP> Teletubbies_CAP = null;
	
	public static TeletubbiesEventHandler teletubbiesEventHandler = new TeletubbiesEventHandler();
	
	public static CreativeTabs tabTeletubbies = new TabTeletubbies("Teletubbies");
    
	public static Item tubbySkirt;
	public static Item dipsyHat;
	public static Item nooNooEyes;
	public static Item tinkyWinkyBib;
	public static Item dipsyBib;
	public static Item laaLaaBib;
	public static Item poBib;
	
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
	
	public static SoundEvent sound_TinkyWinky_Living;
	public static SoundEvent sound_Dipsy_Living;
	public static SoundEvent sound_LaaLaa_Living;
	public static SoundEvent sound_Po_Living;
	public static SoundEvent sound_NooNoo_Living1;
	public static SoundEvent sound_NooNoo_Living2;
	public static SoundEvent sound_NooNoo_Hurt;
	public static SoundEvent sound_NooNoo_Dead;
	public static SoundEvent sound_Ball_Bounce;
	public static SoundEvent sound_TubbyToast;
				
    @SidedProxy(clientSide="teletubbies.ClientProxy", serverSide="teletubbies.CommonProxy")
    public static CommonProxy commonProxy;
    public static ClientProxy clientProxy;
    
    @Instance(MODID)
    public static Teletubbies instance;
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	RecipeRegistry.registerRecipes();
    	SoundRegistry.registerSoundEvents();
    }
     
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	commonProxy.registerRenders();
    	commonProxy.registerUpdateChecker();
    }
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	commonProxy.registerMobRenders();
    	
    	MinecraftForge.EVENT_BUS.register(instance);
    	MinecraftForge.EVENT_BUS.register(teletubbiesEventHandler);
    	    	
    	CapabilityManager.INSTANCE.register(ITeletubbies_CAP.class, new Teletubbies_CAPStorage(), Teletubbies_CAPProvider.class);

    	BlockRegistry.registerBlocks();
    	ItemRegistry.registerItems();
    	MobRegistry.registerMobs();
    	ArmorRegistry.registerArmor();
    	
    	GameRegistry.registerWorldGenerator(new GenTubbyDomeStructure(), 1000);
    	GameRegistry.registerWorldGenerator(new GenTubbyVoiceTrumpet(), 1000);
    }
}
