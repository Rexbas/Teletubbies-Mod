package teletubbies.registry;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.lists.SoundList;
import teletubbies.sound.Sound;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundRegistry {

	@SubscribeEvent
	public static void registerSoundsEvent(final RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(
				SoundList.tinkywinky = new Sound("mob.tinkywinky"),
				SoundList.dipsy = new Sound("mob.dipsy"),
				SoundList.laalaa = new Sound("mob.laalaa"),
				SoundList.po = new Sound("mob.po"),
				SoundList.noonoo_living1 = new Sound("mob.noonoo_living1"),
				SoundList.noonoo_living2 = new Sound("mob.noonoo_living2"),
				SoundList.noonoo_hurt = new Sound("mob.noonoo_hurt"),
				SoundList.noonoo_dead = new Sound("mob.noonoo_dead"),
				SoundList.daadaa = new Sound("mob.daadaa"),
				SoundList.mimi = new Sound("mob.mimi"),
				SoundList.bounce = new Sound("ball.bounce"),
				SoundList.scooter = new Sound("machine.scooter"),
				SoundList.voiceTrumpet = new Sound("machine.voicetrumpet"),
				SoundList.toast = new Sound("machine.toast"),
				SoundList.custard = new Sound("machine.custard")
				);

	}
}
