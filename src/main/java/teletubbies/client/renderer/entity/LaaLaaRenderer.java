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
import teletubbies.client.renderer.entity.model.LaaLaaModel;
import teletubbies.entity.passive.LaaLaaEntity;

@OnlyIn(Dist.CLIENT)
public class LaaLaaRenderer extends BipedRenderer<LaaLaaEntity, LaaLaaModel> {
	private static LaaLaaModel model = new LaaLaaModel();

	public LaaLaaRenderer(EntityRendererManager manager) {
		super(manager, model, 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<LaaLaaEntity>(0.5F), new BipedModel<LaaLaaEntity>(1.0F)));
	}

	@Override
	protected ResourceLocation getEntityTexture(LaaLaaEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/laalaa.png");
	}
	
	@Override
	public float prepareScale(LaaLaaEntity entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = 0.0565F;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}
	
	public static class RenderFactory implements IRenderFactory<LaaLaaEntity> {
		
		@Override
		public EntityRenderer<? super LaaLaaEntity> createRenderFor(EntityRendererManager manager) {
			return new LaaLaaRenderer(manager);
		}
	}
}
