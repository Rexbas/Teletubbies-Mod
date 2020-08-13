package teletubbies.client.renderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import teletubbies.client.renderer.entity.NooNooRenderer;
import teletubbies.client.renderer.entity.PoScooterRenderer;
import teletubbies.client.renderer.entity.TeletubbyRenderer;
import teletubbies.client.renderer.entity.TiddlytubbyRenderer;
import teletubbies.client.renderer.entity.model.DipsyModel;
import teletubbies.client.renderer.entity.model.DipsyZombieModel;
import teletubbies.client.renderer.entity.model.LaaLaaModel;
import teletubbies.client.renderer.entity.model.LaaLaaZombieModel;
import teletubbies.client.renderer.entity.model.PoModel;
import teletubbies.client.renderer.entity.model.PoZombieModel;
import teletubbies.client.renderer.entity.model.TinkyWinkyModel;
import teletubbies.client.renderer.entity.model.TinkyWinkyZombieModel;
import teletubbies.init.ModEntityTypes;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
	
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TINKYWINKY.get(), new TeletubbyRenderer.RenderFactory<>("tinkywinky", 0.95F, new TinkyWinkyModel()));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DIPSY.get(), new TeletubbyRenderer.RenderFactory<>("dipsy", 0.9F, new DipsyModel()));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LAALAA.get(), new TeletubbyRenderer.RenderFactory<>("laalaa", 0.85F, new LaaLaaModel()));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PO.get(), new TeletubbyRenderer.RenderFactory<>("po", 0.8F, new PoModel()));
				
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.NOONOO.get(), new NooNooRenderer.RenderFactory());

		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.MIMI.get(), new TiddlytubbyRenderer.RenderFactory("mimi"));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DAADAA.get(), new TiddlytubbyRenderer.RenderFactory("daadaa"));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PING.get(), new TiddlytubbyRenderer.RenderFactory("ping"));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BA.get(), new TiddlytubbyRenderer.RenderFactory("ba"));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.RURU.get(), new TiddlytubbyRenderer.RenderFactory("ruru"));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.NIN.get(), new TiddlytubbyRenderer.RenderFactory("nin"));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DUGGLEDEE.get(), new TiddlytubbyRenderer.RenderFactory("duggledee"));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.UMPIEPUMPIE.get(), new TiddlytubbyRenderer.RenderFactory("umpiepumpie"));

		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.TINKYWINKY_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>("tinkywinky_zombie", 0.95F, new TinkyWinkyZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.DIPSY_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>("dipsy_zombie", 0.9F, new DipsyZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.LAALAA_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>("laalaa_zombie", 0.85F, new LaaLaaZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PO_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>("po_zombie", 0.8F, new PoZombieModel()));

		RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PO_SCOOTER.get(), new PoScooterRenderer.RenderFactory());
	}	
}
