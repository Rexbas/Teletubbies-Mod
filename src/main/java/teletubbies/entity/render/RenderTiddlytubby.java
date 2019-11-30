package teletubbies.entity.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import teletubbies.entity.baby.EntityTiddlytubby;
import teletubbies.entity.model.ModelTiddlytubby;

public class RenderTiddlytubby extends RenderLiving<EntityTiddlytubby> {
	
	String name;

	public RenderTiddlytubby(RenderManager rendermanager, float shadowsize, String name) {
		super(rendermanager, new ModelTiddlytubby(), shadowsize);
		this.name = name;
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTiddlytubby entity) {
		return new ResourceLocation("teletubbies:textures/entity/" + name + ".png");
	}
}
