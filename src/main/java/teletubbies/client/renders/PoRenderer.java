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
import teletubbies.client.models.entity.PoModel;
import teletubbies.entities.Po;

@OnlyIn(Dist.CLIENT)
public class PoRenderer extends LivingRenderer<Po, PoModel> {

	public PoRenderer(EntityRendererManager manager) {
		super(manager, new PoModel(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Po entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/po.png");
	}
	
	@Override
	public float prepareScale(Po entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = 0.0550F;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}

	
	public static class RenderFactory implements IRenderFactory<Po> {
		
		@Override
		public EntityRenderer<? super Po> createRenderFor(EntityRendererManager manager) {
			return new PoRenderer(manager);
		}
	}
}
