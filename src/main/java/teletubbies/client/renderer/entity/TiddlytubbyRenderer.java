package teletubbies.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.entity.model.TiddlytubbyModel;
import teletubbies.entity.baby.TiddlytubbyEntity;

public class TiddlytubbyRenderer extends MobRenderer<TiddlytubbyEntity, TiddlytubbyModel<TiddlytubbyEntity>> {
	private final String name;

	public TiddlytubbyRenderer(EntityRendererManager manager, String name) {
		super(manager, new TiddlytubbyModel<>(), 0.3F);
		this.name = name;
	}

	@Override
	public ResourceLocation getEntityTexture(TiddlytubbyEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/" + name + ".png");
	}
	
	public static class RenderFactory implements IRenderFactory<TiddlytubbyEntity> {
		private final String name;
		
		public RenderFactory(String name) {
			this.name = name;
		}
		
		@Override
		public EntityRenderer<? super TiddlytubbyEntity> createRenderFor(EntityRendererManager manager) {
			return new TiddlytubbyRenderer(manager, name);
		}
	}
}
