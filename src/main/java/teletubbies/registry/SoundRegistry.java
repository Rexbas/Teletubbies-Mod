package teletubbies.registry;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.TeletubbiesSounds;
import teletubbies.sound.Sound;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SoundRegistry {

	@SubscribeEvent
	public static void registerSoundsEvent(final RegistryEvent.Register<SoundEvent> event) {
		event.getRegistry().registerAll(
				TeletubbiesSounds.tinkywinky = new Sound("mob.tinkywinky"),
				TeletubbiesSounds.dipsy = new Sound("mob.dipsy"),
				TeletubbiesSounds.laalaa = new Sound("mob.laalaa"),
				TeletubbiesSounds.po = new Sound("mob.po"),
				TeletubbiesSounds.noonoo_living1 = new Sound("mob.noonoo_living1"),
				TeletubbiesSounds.noonoo_living2 = new Sound("mob.noonoo_living2"),
				TeletubbiesSounds.noonoo_hurt = new Sound("mob.noonoo_hurt"),
				TeletubbiesSounds.noonoo_dead = new Sound("mob.noonoo_dead"),
				TeletubbiesSounds.daadaa = new Sound("mob.daadaa"),
				TeletubbiesSounds.mimi = new Sound("mob.mimi"),
				TeletubbiesSounds.bounce = new Sound("ball.bounce"),
				TeletubbiesSounds.scooter = new Sound("machine.scooter"),
				TeletubbiesSounds.voiceTrumpet = new Sound("machine.voicetrumpet"),
				TeletubbiesSounds.toast = new Sound("machine.toast"),
				TeletubbiesSounds.custard = new Sound("machine.custard")
				);

	}
}
