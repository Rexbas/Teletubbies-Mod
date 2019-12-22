package teletubbies.client.renderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import teletubbies.client.renderer.entity.DipsyRenderer;
import teletubbies.client.renderer.entity.LaaLaaRenderer;
import teletubbies.client.renderer.entity.PoRenderer;
import teletubbies.client.renderer.entity.PoScooterRenderer;
import teletubbies.client.renderer.entity.TinkyWinkyRenderer;
import teletubbies.entity.DipsyEntity;
import teletubbies.entity.LaaLaaEntity;
import teletubbies.entity.PoEntity;
import teletubbies.entity.TinkyWinkyEntity;
import teletubbies.entity.item.PoScooterEntity;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
	
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(TinkyWinkyEntity.class, new TinkyWinkyRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(DipsyEntity.class, new DipsyRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(LaaLaaEntity.class, new LaaLaaRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(PoEntity.class, new PoRenderer.RenderFactory());
		
		RenderingRegistry.registerEntityRenderingHandler(PoScooterEntity.class, new PoScooterRenderer.RenderFactory());
	}	
}
