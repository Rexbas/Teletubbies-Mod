package teletubbies.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.entity.model.PoModel;
import teletubbies.entity.passive.PoEntity;

@OnlyIn(Dist.CLIENT)
public class PoRenderer extends BipedRenderer<PoEntity, PoModel> {
	private static PoModel model = new PoModel();

	public PoRenderer(EntityRendererManager manager) {
		super(manager, model, 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<PoEntity>(0.5F), new BipedModel<PoEntity>(1.0F)));
	}

	@Override
	protected ResourceLocation getEntityTexture(PoEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/po.png");
	}
	
	@Override
	public float prepareScale(PoEntity entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = 0.0535F;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}

	public static class RenderFactory implements IRenderFactory<PoEntity> {
		
		@Override
		public EntityRenderer<? super PoEntity> createRenderFor(EntityRendererManager manager) {
			return new PoRenderer(manager);
		}
	}
}
