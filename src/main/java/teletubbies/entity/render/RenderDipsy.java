package teletubbies.entity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class RenderDipsy extends RenderLiving {

	public RenderDipsy(ModelBase par1ModelBase, float par2) {
		super(Minecraft.getMinecraft().getRenderManager(), par1ModelBase, par2);

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("teletubbies:textures/mob/Dipsy.png");
	}
}
