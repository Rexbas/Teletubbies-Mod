package teletubbies;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teletubbies.armor.ArmorDipsyBib;
import teletubbies.armor.ArmorDipsyHat;
import teletubbies.armor.ArmorLaaLaaBib;
import teletubbies.armor.ArmorNooNooEyes;
import teletubbies.armor.ArmorPoBib;
import teletubbies.armor.ArmorPoHelmet;
import teletubbies.armor.ArmorTinkyWinkyBib;
import teletubbies.armor.ArmorTubbySkirt;
import teletubbies.block.BlockTubbyCustardMachine;
import teletubbies.block.BlockTubbyToastMachine;
import teletubbies.block.BlockTubbyVoiceTrumpet;
import teletubbies.capability.ITeletubbies_CAP;
import teletubbies.capability.Teletubbies_CAPProvider;
import teletubbies.capability.Teletubbies_CAPStorage;
import teletubbies.configuration.ConfigurationHandler;
import teletubbies.gui.GuiHandler;
import teletubbies.item.DipsyStick;
import teletubbies.item.ItemBlockTubbyCustardMachine;
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
import teletubbies.registry.SoundRegistry;
import teletubbies.tab.TabTeletubbies;
import teletubbies.updatechecker.UpdateChecker;
import teletubbies.vehicle.EntityPoScooter;
import teletubbies.vehicle.ItemPoScooter;
import teletubbies.world.structure.GenTubbyDomeStructure;
import teletubbies.world.structure.GenTubbyVoiceTrumpet;

@Mod(modid = Teletubbies.MODID, name = Teletubbies.NAME, version = Teletubbies.MODVERSION, guiFactory = "teletubbies.gui.GuiFactory")
public class Teletubbies {
	
    public static final String MODID = "teletubbies";
    public static final String NAME = "Teletubbies";
    public static final String MODVERSION = "1.5.0.5";
	public static final String MCVERSION = "1.12"; //For update file
	
	/* TODO FUTURE
	 * !2015 Textures
	 * !Block 2015 models
	 * WINDMILL
	 * NOONOO SUCKSUCK + Translation name + custom player.openGui
	 * Tinky winky bag fix
	 * sun
	 * 
	 */
    
	public static Configuration config;
	
	@CapabilityInject(ITeletubbies_CAP.class)
	public static final Capability<ITeletubbies_CAP> Teletubbies_CAP = null;
	
	public static TeletubbiesEventHandler teletubbiesEventHandler = new TeletubbiesEventHandler();
		
	public static CreativeTabs tabTeletubbies = new TabTeletubbies("teletubbies");
    
	public static Item tubbySkirt = new ArmorTubbySkirt(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
	public static Item dipsyHat = new ArmorDipsyHat(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD);
	public static Item nooNooEyes = new ArmorNooNooEyes(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD);
	public static Item tinkyWinkyBib = new ArmorTinkyWinkyBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
	public static Item dipsyBib = new ArmorDipsyBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
	public static Item laaLaaBib = new ArmorLaaLaaBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
	public static Item poBib = new ArmorPoBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
	public static Item poHelmet = new ArmorPoHelmet(ArmorMaterial.IRON, 0, EntityEquipmentSlot.HEAD);
	
	public static Item tinkyWinkyStick = new TinkyWinkyStick();
	public static Item dipsyStick = new DipsyStick();
	public static Item laaLaaStick = new LaaLaaStick();
    public static Item poStick = new PoStick();
	public static Item tinkyWinkyBag = new TinkyWinkyBag();
	public static Item laaLaaBall = new LaaLaaBall();
	public static Item tubbyCustard = new TubbyCustard(4, 5, false);
	public static Item tubbyToast = new TubbyToast(2, 5, false);
	public static Item tubbyBowl = new TubbyBowl();
	public static Item poScooter = new ItemPoScooter();
		
	public static Block tubbyVoiceTrumpet = new BlockTubbyVoiceTrumpet();
	public static Block tubbyToastMachine = new BlockTubbyToastMachine();
	public static Block tubbyCustardMachine = new BlockTubbyCustardMachine();
	
	public static ItemBlock tubbyVoiceTrumpetIB = (ItemBlock) new ItemBlock(tubbyVoiceTrumpet).setRegistryName("tubbyvoicetrumpet");
	public static ItemBlock tubbyToastMachineIB = (ItemBlock) new ItemBlock(tubbyToastMachine).setRegistryName("tubbytoastmachine");
	public static ItemBlock tubbyCustardMachineIB = (ItemBlock) new ItemBlockTubbyCustardMachine(tubbyCustardMachine).setRegistryName("tubbycustardmachine");
	
	public static SoundEvent sound_TinkyWinky_Living = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.tinkywinky.say")).setRegistryName("mob.tinkywinky.say");
	public static SoundEvent sound_Dipsy_Living = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.dipsy.say")).setRegistryName("mob.dipsy.say");
	public static SoundEvent sound_LaaLaa_Living = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.laalaa.say")).setRegistryName("mob.laalaa.say");
	public static SoundEvent sound_Po_Living = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.po.say")).setRegistryName("mob.po.say");
	public static SoundEvent sound_NooNoo_Living1 = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.noonoo.say1")).setRegistryName("mob.noonoo.say1");
	public static SoundEvent sound_NooNoo_Living2 = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.noonoo.say2")).setRegistryName("mob.noonoo.say2");
	public static SoundEvent sound_NooNoo_Hurt = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.noonoo.hurt")).setRegistryName("mob.noonoo.hurt");
	public static SoundEvent sound_NooNoo_Dead = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.noonoo.dead")).setRegistryName("mob.noonoo.dead");
	public static SoundEvent sound_DaaDaa_Living = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.daadaa.say")).setRegistryName("mob.daadaa.say");
	public static SoundEvent sound_MiMi_Living = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":mob.mimi.say")).setRegistryName("mob.mimi.say");
	public static SoundEvent sound_Ball_Bounce = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":ball.bounce")).setRegistryName("ball.bounce");
	public static SoundEvent sound_PoScooter = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":machine.scooter")).setRegistryName("machine.scooter");
	public static SoundEvent sound_TubbyVoiceTrumpet = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":machine.tubbyvoicetrumpet")).setRegistryName("machine.tubbyvoicetrumpet");
	public static SoundEvent sound_TubbyToast = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":machine.tubbytoast")).setRegistryName("machine.tubbytoast");
	public static SoundEvent sound_TubbyCustard = new SoundEvent(new ResourceLocation(Teletubbies.MODID + ":machine.tubbycustard")).setRegistryName("machine.tubbycustard");
				
    @SidedProxy(clientSide="teletubbies.ClientProxy", serverSide="teletubbies.CommonProxy")
    public static CommonProxy commonProxy;
    public static ClientProxy clientProxy;
    
    @Instance(MODID)
    public static Teletubbies instance;
	public static UpdateChecker updateChecker;
	public static boolean haveWarnedVersionOutOfDate = false;
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	SoundRegistry.registerSoundEvents();
    }
     
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	commonProxy.registerUpdateChecker();
    }
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    	config = new Configuration(event.getSuggestedConfigurationFile());
    	ConfigurationHandler.syncConfig();
    	
    	MinecraftForge.EVENT_BUS.register(instance);
    	MinecraftForge.EVENT_BUS.register(teletubbiesEventHandler);
    	MinecraftForge.EVENT_BUS.register(new ClientProxy());
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(MODID, new GuiHandler());
    	
    	CapabilityManager.INSTANCE.register(ITeletubbies_CAP.class, new Teletubbies_CAPStorage(), Teletubbies_CAPProvider.class);

    	BlockRegistry.registerBlocks();
    	BlockRegistry.registerTileEntities();
    	ItemRegistry.registerItems();
    	MobRegistry.registerMobs();
    	ArmorRegistry.registerArmor();
    	    	
    	EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":PoScooter"), EntityPoScooter.class, "poscooter", 17, Teletubbies.MODID, 40, 1, true);

    	commonProxy.registerRenders();
    	commonProxy.registerMobRenders();
    	    	
    	GameRegistry.registerWorldGenerator(new GenTubbyDomeStructure(), 1000);
    	GameRegistry.registerWorldGenerator(new GenTubbyVoiceTrumpet(), 1000);
    }
}
