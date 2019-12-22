package teletubbies.client.renderer.entity;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.entity.model.DipsyModel;
import teletubbies.entity.DipsyEntity;

@OnlyIn(Dist.CLIENT)
public class DipsyRenderer extends LivingRenderer<DipsyEntity, DipsyModel> {
	private static DipsyModel model = new DipsyModel();
	
	public DipsyRenderer(EntityRendererManager manager) {
		super(manager, model, 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(DipsyEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/dipsy.png");
	}
	
	@Override
	public float prepareScale(DipsyEntity entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = 0.0600F;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}

	public static class RenderFactory implements IRenderFactory<DipsyEntity> {
		
		@Override
		public EntityRenderer<? super DipsyEntity> createRenderFor(EntityRendererManager manager) {
			return new DipsyRenderer(manager);
		}
	}
}
