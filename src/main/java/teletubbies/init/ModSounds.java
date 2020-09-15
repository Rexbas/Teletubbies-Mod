package teletubbies.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSounds {
	
	public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Teletubbies.MODID);
	
	public static final RegistryObject<SoundEvent> ENTITY_TINKYWINKY_VOICE = SOUNDS.register("entity.tinkywinky.voice",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.tinkywinky.voice")));
	
	public static final RegistryObject<SoundEvent> ENTITY_DIPSY_VOICE = SOUNDS.register("entity.dipsy.voice",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.dipsy.voice")));
	
	public static final RegistryObject<SoundEvent> ENTITY_LAALAA_VOICE = SOUNDS.register("entity.laalaa.voice",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.laalaa.voice")));
	
	public static final RegistryObject<SoundEvent> ENTITY_PO_VOICE = SOUNDS.register("entity.po.voice",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.po.voice")));
	
	public static final RegistryObject<SoundEvent> ENTITY_NOONOO_AMBIENT1 = SOUNDS.register("entity.noonoo.ambient1",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.noonoo.ambient1")));
	
	public static final RegistryObject<SoundEvent> ENTITY_NOONOO_AMBIENT2 = SOUNDS.register("entity.noonoo.ambient2",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.noonoo.ambient2")));
	
	public static final RegistryObject<SoundEvent> ENTITY_NOONOO_HURT = SOUNDS.register("entity.noonoo.hurt",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.noonoo.hurt")));
	
	public static final RegistryObject<SoundEvent> ENTITY_NOONOO_DEATH = SOUNDS.register("entity.noonoo.death",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.noonoo.death")));
	
	public static final RegistryObject<SoundEvent> ENTITY_MIMI_VOICE = SOUNDS.register("entity.mimi.voice",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.mimi.voice")));
	
	public static final RegistryObject<SoundEvent> ENTITY_DAADAA_VOICE = SOUNDS.register("entity.daadaa.voice",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.daadaa.voice")));
	
	public static final RegistryObject<SoundEvent> BALL_BOUNCE = SOUNDS.register("ball.bounce",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "ball.bounce")));
	
	public static final RegistryObject<SoundEvent> ENTITY_SCOOTER = SOUNDS.register("entity.scooter",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "entity.scooter")));
	
	public static final RegistryObject<SoundEvent> MACHINE_VOICE_TRUMPET = SOUNDS.register("machine.voice_trumpet",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "machine.voice_trumpet")));
	
	public static final RegistryObject<SoundEvent> MACHINE_TOAST = SOUNDS.register("machine.toast",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "machine.toast")));
	
	public static final RegistryObject<SoundEvent> MACHINE_CUSTARD = SOUNDS.register("machine.custard",
			() -> new SoundEvent(new ResourceLocation(Teletubbies.MODID, "machine.custard")));
}
	
