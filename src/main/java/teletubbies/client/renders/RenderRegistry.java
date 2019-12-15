package teletubbies.client.renders;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import teletubbies.entities.Dipsy;
import teletubbies.entities.LaaLaa;
import teletubbies.entities.Po;
import teletubbies.entities.TinkyWinky;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
	
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(TinkyWinky.class, new TinkyWinkyRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(Dipsy.class, new DipsyRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(LaaLaa.class, new LaaLaaRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(Po.class, new PoRenderer.RenderFactory());
	}
}
