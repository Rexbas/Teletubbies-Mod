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
import teletubbies.client.renderer.entity.model.DipsyZombieModel;
import teletubbies.entity.monster.DipsyZombieEntity;

@OnlyIn(Dist.CLIENT)
public class DipsyZombieRenderer extends BipedRenderer<DipsyZombieEntity, DipsyZombieModel> {
	private static DipsyZombieModel model = new DipsyZombieModel();
	
	public DipsyZombieRenderer(EntityRendererManager manager) {
		super(manager, model, 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<DipsyZombieEntity>(0.5F), new BipedModel<DipsyZombieEntity>(1.0F)));
	}

	@Override
	protected ResourceLocation getEntityTexture(DipsyZombieEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/dipsy_zombie.png");
	}
	
	@Override
	public float prepareScale(DipsyZombieEntity entity, float partialTicks) {   
		GlStateManager.enableRescaleNormal();      
		GlStateManager.scalef(-1.0F, -1.0F, 1.0F);
		this.preRenderCallback(entity, partialTicks);
		float f = 0.0595F;
		GlStateManager.translatef(0.0F, -f * 24, 0.0F);
		return f;
	}
	
	public static class RenderFactory implements IRenderFactory<DipsyZombieEntity> {
		
		@Override
		public EntityRenderer<? super DipsyZombieEntity> createRenderFor(EntityRendererManager manager) {
			return new DipsyZombieRenderer(manager);
		}
	}
}
