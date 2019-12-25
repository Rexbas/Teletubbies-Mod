package teletubbies.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.entity.model.TeletubbyModel;

@OnlyIn(Dist.CLIENT)
public class TeletubbyRenderer<T extends CreatureEntity, M extends TeletubbyModel<T>> extends BipedRenderer<T, M> {	
	private final String name;
	private float scale;
	
	public TeletubbyRenderer(EntityRendererManager manager, String name, float scale, M model) {
		super(manager, null, 0.5F);
		this.name = name;
		this.scale = scale;
		this.entityModel = model;
		this.addLayer(new BipedArmorLayer<T, M, BipedModel<T>>(this, new BipedModel<>(0.5F), new BipedModel<>(1.0F)));
	}

	@Override
	protected ResourceLocation getEntityTexture(T entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/" + name + ".png");
	}
	
	@Override
	public float prepareScale(T entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = this.scale;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}

	public static class RenderFactory<T extends CreatureEntity, M extends TeletubbyModel<T>> implements IRenderFactory<T> {
		private final String name;
		private final float scale;
		private final M model;
		
		public RenderFactory(String name, float scale, M model) {
			this.name = name;
			this.scale = scale;
			this.model = model;
		}
		
		@Override
		public EntityRenderer<? super T> createRenderFor(EntityRendererManager manager) {
			return new TeletubbyRenderer<>(manager, name, scale, model);
		}
	}
}
