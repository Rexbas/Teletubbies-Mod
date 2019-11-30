package teletubbies.sounds;

import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.ResourceLocation;
import teletubbies.block.tileentity.TileEntityTubbyWindMill;

public class SpinSound extends PositionedSound implements ITickableSound{
	
	private TileEntityTubbyWindMill te;
	protected boolean donePlaying = false;
	
	public SpinSound(ResourceLocation path, TileEntityTubbyWindMill te, float volume, float pitch){
		super(path);
		this.repeat = true;
		this.volume = volume;
		this.field_147663_c = pitch;
		this.xPosF = te.getTopX();
		this.yPosF = te.getTopY();
		this.zPosF = te.getTopZ();
		this.te = te;
	}

	public SpinSound(String path, TileEntityTubbyWindMill te, float volume, float pitch){
		this(new ResourceLocation(path), te, volume, pitch);
	}

	@Override
	public void update(){
		if(te.isInvalid() || !te.isActivated()){
			donePlaying = true;
			te.setIsPlayingSound(false);
		}
	}

	@Override
	public boolean isDonePlaying(){
		return donePlaying;
	}
}
