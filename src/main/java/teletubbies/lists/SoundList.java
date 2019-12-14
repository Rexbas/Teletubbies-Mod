package teletubbies.lists;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.sound.Sound;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundList {
	public static final SoundEvent tinkywinky = new Sound("mob.tinkywinky");
	public static final SoundEvent dipsy = new Sound("mob.dipsy");
	public static final SoundEvent laalaa = new Sound("mob.laalaa");
	public static final SoundEvent po = new Sound("mob.po");
	public static final SoundEvent noonoo_living1 = new Sound("mob.noonoo_living1");
	public static final SoundEvent noonoo_living2 = new Sound("mob.noonoo_living2");
	public static final SoundEvent noonoo_hurt = new Sound("mob.noonoo_hurt");
	public static final SoundEvent noonoo_dead = new Sound("mob.noonoo_dead");
	public static final SoundEvent daadaa = new Sound("mob.daadaa");
	public static final SoundEvent mimi = new Sound("mob.mimi");
	public static final SoundEvent bounce = new Sound("ball.bounce");
	public static final SoundEvent scooter = new Sound("machine.scooter");
	public static final SoundEvent voiceTrumpet = new Sound("machine.voicetrumpet");
	public static final SoundEvent toast = new Sound("machine.toast");
	public static final SoundEvent custard = new Sound("machine.custard");
	
	@SubscribeEvent
	public static void registerSounds(final RegistryEvent.Register<SoundEvent> event) {		
		event.getRegistry().registerAll(
				tinkywinky, dipsy, laalaa, po,
				noonoo_living1, noonoo_living2, noonoo_hurt, noonoo_dead,
				daadaa, mimi, bounce, scooter, voiceTrumpet, toast, custard		
		);
	}
}
