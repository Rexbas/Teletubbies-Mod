package teletubbies.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teletubbies.Teletubbies;

public class SoundRegistry {

	public static void registerSoundEvents() {
		Teletubbies.sound_TinkyWinky_Living = registerSoundEvent("mob.tinkywinky.say");
		Teletubbies.sound_Dipsy_Living = registerSoundEvent("mob.dipsy.say");
		Teletubbies.sound_LaaLaa_Living = registerSoundEvent("mob.laalaa.say");
		Teletubbies.sound_Po_Living = registerSoundEvent("mob.po.say");
		Teletubbies.sound_NooNoo_Living1 = registerSoundEvent("mob.noonoo.say1");
		Teletubbies.sound_NooNoo_Living2 = registerSoundEvent("mob.noonoo.say2");
		Teletubbies.sound_NooNoo_Hurt = registerSoundEvent("mob.noonoo.hurt");
		Teletubbies.sound_NooNoo_Dead = registerSoundEvent("mob.noonoo.dead");
		Teletubbies.sound_Ball_Bounce = registerSoundEvent("ball.bounce");
		Teletubbies.sound_TubbyToast = registerSoundEvent("machine.tubbytoast");
	}
	
	private static SoundEvent registerSoundEvent(String soundName) {
		ResourceLocation soundID = new ResourceLocation(Teletubbies.MODID, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
}
