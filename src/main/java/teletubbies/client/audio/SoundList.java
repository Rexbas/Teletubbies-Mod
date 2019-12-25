package teletubbies.client.audio;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundList {
	public static final SoundEvent ENTITY_TINKYWINKY_VOICE = new Sound("entity.tinkywinky.voice");
	public static final SoundEvent ENTITY_DIPSY_VOICE = new Sound("entity.dipsy.voice");
	public static final SoundEvent ENTITY_LAALAA_VOICE = new Sound("entity.laalaa.voice");
	public static final SoundEvent ENTITY_PO_VOICE = new Sound("entity.po.voice");
	public static final SoundEvent ENTITY_NOONOO_AMBIENT1 = new Sound("entity.noonoo.ambient1");
	public static final SoundEvent ENTITY_NOONOO_AMBIENT2 = new Sound("entity.noonoo.ambient2");
	public static final SoundEvent ENTITY_NOONOO_HURT = new Sound("entity.noonoo.hurt");
	public static final SoundEvent ENTITY_NOONOO_DEATH = new Sound("entity.noonoo.death");
	public static final SoundEvent ENTITY_MIMI_VOICE = new Sound("entity.mimi.voice");
	public static final SoundEvent ENTITY_DAADAA_VOICE = new Sound("entity.daadaa.voice");
	public static final SoundEvent BALL_BOUNCE = new Sound("ball.bounce");
	public static final SoundEvent ENTITY_SCOOTER = new Sound("entity.scooter");
	public static final SoundEvent MACHINE_VOICE_TRUMPET = new Sound("machine.voice_trumpet");
	public static final SoundEvent MACHINE_TOAST = new Sound("machine.toast");
	public static final SoundEvent MACHINE_CUSTARD = new Sound("machine.custard");
	
	@SubscribeEvent
	public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {	
		event.getRegistry().registerAll(
				ENTITY_TINKYWINKY_VOICE, ENTITY_DIPSY_VOICE, ENTITY_LAALAA_VOICE, ENTITY_PO_VOICE,
				ENTITY_NOONOO_AMBIENT1, ENTITY_NOONOO_AMBIENT2, ENTITY_NOONOO_HURT, ENTITY_NOONOO_DEATH,
				ENTITY_MIMI_VOICE, ENTITY_DAADAA_VOICE, BALL_BOUNCE, ENTITY_SCOOTER,
				MACHINE_VOICE_TRUMPET, MACHINE_TOAST, MACHINE_CUSTARD		
		);
	}
}
