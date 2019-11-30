package teletubbies.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNooNoo extends RenderLiving {

	public RenderNooNoo(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);

	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("teletubbies:textures/mob/NooNoo.png");
	}
}