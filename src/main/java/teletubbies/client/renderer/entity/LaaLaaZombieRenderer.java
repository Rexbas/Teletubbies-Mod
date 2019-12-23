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
import teletubbies.client.renderer.entity.model.LaaLaaZombieModel;
import teletubbies.entity.monster.LaaLaaZombieEntity;

@OnlyIn(Dist.CLIENT)
public class LaaLaaZombieRenderer extends BipedRenderer<LaaLaaZombieEntity, LaaLaaZombieModel> {
	private static LaaLaaZombieModel model = new LaaLaaZombieModel();
	
	public LaaLaaZombieRenderer(EntityRendererManager manager) {
		super(manager, model, 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<LaaLaaZombieEntity>(0.5F), new BipedModel<LaaLaaZombieEntity>(1.0F)));
	}

	@Override
	protected ResourceLocation getEntityTexture(LaaLaaZombieEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/laalaa_zombie.png");
	}
	
	@Override
	public float prepareScale(LaaLaaZombieEntity entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = 0.0565F;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}
	
	public static class RenderFactory implements IRenderFactory<LaaLaaZombieEntity> {
		
		@Override
		public EntityRenderer<? super LaaLaaZombieEntity> createRenderFor(EntityRendererManager manager) {
			return new LaaLaaZombieRenderer(manager);
		}
	}
}
