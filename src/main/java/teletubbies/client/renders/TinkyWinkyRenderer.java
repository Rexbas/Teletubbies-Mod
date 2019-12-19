package teletubbies.client.renders;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import teletubbies.Teletubbies;
import teletubbies.client.models.entity.TinkyWinkyModel;
import teletubbies.entities.TinkyWinky;

@OnlyIn(Dist.CLIENT)
public class TinkyWinkyRenderer extends LivingRenderer<TinkyWinky, TinkyWinkyModel> {

	public TinkyWinkyRenderer(EntityRendererManager manager) {
		super(manager, new TinkyWinkyModel(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(TinkyWinky entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/tinkywinky.png");
	}
	
	public static class RenderFactory implements IRenderFactory<TinkyWinky> {
		
		@Override
		public EntityRenderer<? super TinkyWinky> createRenderFor(EntityRendererManager manager) {
			return new TinkyWinkyRenderer(manager);
		}
	}
}
