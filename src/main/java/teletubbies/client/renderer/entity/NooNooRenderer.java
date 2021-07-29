package teletubbies.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.RenderHandler;
import teletubbies.client.renderer.entity.model.NooNooModel;
import teletubbies.entity.passive.NooNooEntity;

public class NooNooRenderer extends MobRenderer<NooNooEntity, NooNooModel> {

	public NooNooRenderer(Context ctx) {
		super(ctx, new NooNooModel(ctx.bakeLayer(RenderHandler.NOONOO_LAYER)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(NooNooEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/noonoo.png");
	}
}
