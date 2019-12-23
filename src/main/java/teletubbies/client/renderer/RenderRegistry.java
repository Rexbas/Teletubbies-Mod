package teletubbies.client.renderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import teletubbies.client.renderer.entity.DipsyRenderer;
import teletubbies.client.renderer.entity.DipsyZombieRenderer;
import teletubbies.client.renderer.entity.LaaLaaRenderer;
import teletubbies.client.renderer.entity.LaaLaaZombieRenderer;
import teletubbies.client.renderer.entity.PoRenderer;
import teletubbies.client.renderer.entity.PoScooterRenderer;
import teletubbies.client.renderer.entity.PoZombieRenderer;
import teletubbies.client.renderer.entity.TinkyWinkyRenderer;
import teletubbies.client.renderer.entity.TinkyWinkyZombieRenderer;
import teletubbies.entity.item.PoScooterEntity;
import teletubbies.entity.monster.DipsyZombieEntity;
import teletubbies.entity.monster.LaaLaaZombieEntity;
import teletubbies.entity.monster.PoZombieEntity;
import teletubbies.entity.monster.TinkyWinkyZombieEntity;
import teletubbies.entity.passive.DipsyEntity;
import teletubbies.entity.passive.LaaLaaEntity;
import teletubbies.entity.passive.PoEntity;
import teletubbies.entity.passive.TinkyWinkyEntity;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
	
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(TinkyWinkyEntity.class, new TinkyWinkyRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(DipsyEntity.class, new DipsyRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(LaaLaaEntity.class, new LaaLaaRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(PoEntity.class, new PoRenderer.RenderFactory());
		
		RenderingRegistry.registerEntityRenderingHandler(TinkyWinkyZombieEntity.class, new TinkyWinkyZombieRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(DipsyZombieEntity.class, new DipsyZombieRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(LaaLaaZombieEntity.class, new LaaLaaZombieRenderer.RenderFactory());
		RenderingRegistry.registerEntityRenderingHandler(PoZombieEntity.class, new PoZombieRenderer.RenderFactory());

		RenderingRegistry.registerEntityRenderingHandler(PoScooterEntity.class, new PoScooterRenderer.RenderFactory());
	}	
}
