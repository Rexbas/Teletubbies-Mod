package teletubbies.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import teletubbies.entity.model.ModelNooNoo;
import teletubbies.entity.passive.EntityNooNoo;

public class RenderNooNoo extends RenderLiving<EntityNooNoo> {

	public RenderNooNoo(RenderManager rendermanager, float shadowsize) {
		super(rendermanager, new ModelNooNoo(), shadowsize);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityNooNoo entity) {
		return new ResourceLocation("teletubbies:textures/entity/NooNoo.png");
	}
}