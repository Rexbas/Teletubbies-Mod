package teletubbies.blocks;

import net.minecraft.block.Block;
import teletubbies.Teletubbies;

public class VoiceTrumpet extends Block {
	
	public VoiceTrumpet(Properties properties) {
		super(properties);
		this.setRegistryName(Teletubbies.MODID, "voicetrumpet");
	}
}
