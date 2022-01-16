package teletubbies.entity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderZombieDipsy extends RenderLiving {

	public RenderZombieDipsy(ModelBase model, float par2) {
		super(Minecraft.getMinecraft().getRenderManager(), model, par2);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("teletubbies:textures/mob/ZombieDipsy.png");
	}
}