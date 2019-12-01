package teletubbies.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import teletubbies.Teletubbies;

public class Sound extends SoundEvent {

	public Sound(String name) {
		super(new ResourceLocation(Teletubbies.MODID, name));
		this.setRegistryName(Teletubbies.MODID, name);
	}
}
