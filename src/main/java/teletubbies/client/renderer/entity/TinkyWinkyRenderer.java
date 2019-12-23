package teletubbies.client.renderer.entity;

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
import teletubbies.client.renderer.entity.model.TinkyWinkyModel;
import teletubbies.entity.passive.TinkyWinkyEntity;

@OnlyIn(Dist.CLIENT)
public class TinkyWinkyRenderer extends BipedRenderer<TinkyWinkyEntity, TinkyWinkyModel> {
	private static TinkyWinkyModel model = new TinkyWinkyModel();
	
	public TinkyWinkyRenderer(EntityRendererManager manager) {
		super(manager, model, 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<TinkyWinkyEntity>(0.5F), new BipedModel<TinkyWinkyEntity>(1.0F)));
	}

	@Override
	protected ResourceLocation getEntityTexture(TinkyWinkyEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/tinkywinky.png");
	}
	
	public static class RenderFactory implements IRenderFactory<TinkyWinkyEntity> {
		
		@Override
		public EntityRenderer<? super TinkyWinkyEntity> createRenderFor(EntityRendererManager manager) {
			return new TinkyWinkyRenderer(manager);
		}
	}
}
