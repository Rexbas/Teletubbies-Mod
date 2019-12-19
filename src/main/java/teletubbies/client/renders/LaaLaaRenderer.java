package teletubbies.client.renders;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import teletubbies.Teletubbies;
import teletubbies.client.models.entity.LaaLaaModel;
import teletubbies.entities.LaaLaa;

@OnlyIn(Dist.CLIENT)
public class LaaLaaRenderer extends LivingRenderer<LaaLaa, LaaLaaModel> {

	public LaaLaaRenderer(EntityRendererManager manager) {
		super(manager, new LaaLaaModel(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(LaaLaa entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/laalaa.png");
	}
	
	@Override
	public float prepareScale(LaaLaa entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = 0.0575F;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}

	
	public static class RenderFactory implements IRenderFactory<LaaLaa> {
		
		@Override
		public EntityRenderer<? super LaaLaa> createRenderFor(EntityRendererManager manager) {
			return new LaaLaaRenderer(manager);
		}
	}
}
