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
import teletubbies.client.models.DipsyModel;
import teletubbies.entities.Dipsy;

@OnlyIn(Dist.CLIENT)
public class DipsyRenderer extends LivingRenderer<Dipsy, DipsyModel> {

	public DipsyRenderer(EntityRendererManager manager) {
		super(manager, new DipsyModel(), 0.9f);
	}

	@Override
	protected ResourceLocation getEntityTexture(Dipsy entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/dipsy.png");
	}
	
	@Override
	public float prepareScale(Dipsy entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = 0.0600F;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}

	
	public static class RenderFactory implements IRenderFactory<Dipsy> {
		
		@Override
		public EntityRenderer<? super Dipsy> createRenderFor(EntityRendererManager manager) {
			return new DipsyRenderer(manager);
		}
	}
}
