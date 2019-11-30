package teletubbies.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderZombieTinkyWinky extends RenderLiving {

	public RenderZombieTinkyWinky(ModelBase model, float par2) {
		super(model, par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("teletubbies:textures/mob/ZombieTinkyWinky.png");
	}
}