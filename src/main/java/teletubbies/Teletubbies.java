package teletubbies;

import net.minecraft.item.Food;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import teletubbies.capability.IJumpCapability;
import teletubbies.capability.JumpCapability;
import teletubbies.capability.JumpStorage;
import teletubbies.itemgroup.TeletubbiesItemGroup;
import teletubbies.registry.SoundRegistry;

@Mod(Teletubbies.MODID)
public class Teletubbies {
    public static Teletubbies instance;
	
    public static final String MODID = "teletubbies";
	
	/*@CapabilityInject(IJumpCapability.class)
	public static final Capability<IJumpCapability> Teletubbies_CAP = null;*/
	
	public static TeletubbiesEventHandler teletubbiesEventHandler = new TeletubbiesEventHandler();
		
	public static ItemGroup itemGroup = new TeletubbiesItemGroup("teletubbies");
	public static Food foodCustard;
	public static Food foodToast;
    
	//public static Item tubbyTutu = new ArmorTubbyTutu(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST);
	/*public static Item dipsyHat = new ArmorDipsyHat(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD);
	public static Item nooNooEyes = new ArmorNooNooEyes(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.HEAD);
	public static Item tinkyWinkyBib = new ArmorTinkyWinkyBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
	public static Item dipsyBib = new ArmorDipsyBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
	public static Item laaLaaBib = new ArmorLaaLaaBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
	public static Item poBib = new ArmorPoBib(ArmorMaterial.LEATHER, 0, EntityEquipmentSlot.CHEST);
	public static Item poHelmet = new ArmorPoHelmet(ArmorMaterial.IRON, 0, EntityEquipmentSlot.HEAD);*/
		
	/*public static Block tubbyVoiceTrumpet = new BlockTubbyVoiceTrumpet();
	public static Block tubbyToastMachine = new BlockTubbyToastMachine();
	public static Block tubbyCustardMachine = new BlockTubbyCustardMachine();*/
	
	/*public static ItemBlock tubbyVoiceTrumpetIB = (ItemBlock) new ItemBlock(tubbyVoiceTrumpet).setRegistryName("tubbyvoicetrumpet");
	public static ItemBlock tubbyToastMachineIB = (ItemBlock) new ItemBlock(tubbyToastMachine).setRegistryName("tubbytoastmachine");
	public static ItemBlock tubbyCustardMachineIB = (ItemBlock) new ItemBlockTubbyCustardMachine(tubbyCustardMachine).setRegistryName("tubbycustardmachine");*/
	
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
	
	public Teletubbies() {
		instance = this;

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		
		MinecraftForge.EVENT_BUS.register(instance);
    	MinecraftForge.EVENT_BUS.register(teletubbiesEventHandler);
    	//MinecraftForge.EVENT_BUS.register(new ClientProxy());
	}
	
	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
    	SoundRegistry.registerSoundEvents();
	}
	
    public void setup(final FMLCommonSetupEvent event) {
    	 CapabilityManager.INSTANCE.register(IJumpCapability.class, new JumpStorage(), JumpCapability::new);

    	//BlockRegistry.registerBlocks();
    	//BlockRegistry.registerTileEntities();
    	//MobRegistry.registerMobs();
    	    	
    	/*EntityRegistry.registerModEntity(new ResourceLocation(Teletubbies.MODID + ":PoScooter"), EntityPoScooter.class, "poscooter", 17, Teletubbies.MODID, 40, 1, true);

    	commonProxy.registerRenders();
    	commonProxy.registerMobRenders();
    	    	
    	GameRegistry.registerWorldGenerator(new GenTubbyDomeStructure(), 1000);
    	GameRegistry.registerWorldGenerator(new GenTubbyVoiceTrumpet(), 1000);*/
    }
}
