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
import teletubbies.client.renderer.entity.model.TinkyWinkyZombieModel;
import teletubbies.entity.monster.TinkyWinkyZombieEntity;

@OnlyIn(Dist.CLIENT)
public class TinkyWinkyZombieRenderer extends BipedRenderer<TinkyWinkyZombieEntity, TinkyWinkyZombieModel> {
	private static TinkyWinkyZombieModel model = new TinkyWinkyZombieModel();
	
	public TinkyWinkyZombieRenderer(EntityRendererManager manager) {
		super(manager, model, 0.5F);
	    this.addLayer(new BipedArmorLayer<>(this, new BipedModel<TinkyWinkyZombieEntity>(0.5F), new BipedModel<TinkyWinkyZombieEntity>(1.0F)));
	}

	@Override
	protected ResourceLocation getEntityTexture(TinkyWinkyZombieEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/tinkywinky_zombie.png");
	}
	
	public static class RenderFactory implements IRenderFactory<TinkyWinkyZombieEntity> {
		
		@Override
		public EntityRenderer<? super TinkyWinkyZombieEntity> createRenderFor(EntityRendererManager manager) {
			return new TinkyWinkyZombieRenderer(manager);
		}
	}
}
