package teletubbies.registry;

import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;

public class SoundRegistry {

	public static void registerSoundEvents() {
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_TinkyWinky_Living);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_Dipsy_Living);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_LaaLaa_Living);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_Po_Living);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_NooNoo_Living1);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_NooNoo_Living2);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_NooNoo_Hurt);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_NooNoo_Dead);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_DaaDaa_Living);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_MiMi_Living);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_Ball_Bounce);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_PoScooter);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_TubbyVoiceTrumpet);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_TubbyToast);
		ForgeRegistries.SOUND_EVENTS.register(Teletubbies.sound_TubbyCustard);
	}
}
