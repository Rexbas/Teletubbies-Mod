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
import teletubbies.client.renderer.entity.model.PoZombieModel;
import teletubbies.entity.monster.PoZombieEntity;

@OnlyIn(Dist.CLIENT)
public class PoZombieRenderer extends BipedRenderer<PoZombieEntity, PoZombieModel> {
	private static PoZombieModel model = new PoZombieModel();
	
	public PoZombieRenderer(EntityRendererManager manager) {
		super(manager, model, 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<PoZombieEntity>(0.5F), new BipedModel<PoZombieEntity>(1.0F)));
	}

	@Override
	protected ResourceLocation getEntityTexture(PoZombieEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/po_zombie.png");
	}
	
	@Override
	public float prepareScale(PoZombieEntity entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = 0.0535F;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}
	
	public static class RenderFactory implements IRenderFactory<PoZombieEntity> {
		
		@Override
		public EntityRenderer<? super PoZombieEntity> createRenderFor(EntityRendererManager manager) {
			return new PoZombieRenderer(manager);
		}
	}
}
