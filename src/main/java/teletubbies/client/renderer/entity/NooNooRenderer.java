package teletubbies.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.entity.model.NooNooModel;
import teletubbies.entity.passive.NooNooEntity;

public class NooNooRenderer extends MobRenderer<NooNooEntity, NooNooModel> {

	public NooNooRenderer(EntityRendererManager manager) {
		super(manager, new NooNooModel(), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(NooNooEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/noonoo.png");
	}
	
	public static class RenderFactory implements IRenderFactory<NooNooEntity> {
				
		@Override
		public EntityRenderer<? super NooNooEntity> createRenderFor(EntityRendererManager manager) {
			return new NooNooRenderer(manager);
		}
	}
}
