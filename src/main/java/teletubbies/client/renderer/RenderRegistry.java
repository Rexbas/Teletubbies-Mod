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
import teletubbies.entity.EntityList;
import teletubbies.entity.passive.PoEntity;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
	
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityList.TINKYWINKY, new TeletubbyRenderer.RenderFactory<>("tinkywinky", new TinkyWinkyModel()));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.DIPSY, new TeletubbyRenderer.RenderFactory<>("dipsy", new DipsyModel()));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.LAALAA, new TeletubbyRenderer.RenderFactory<>("laalaa", new LaaLaaModel()));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.PO, new TeletubbyRenderer.RenderFactory<PoEntity, PoModel>("po", new PoModel()));
				
		RenderingRegistry.registerEntityRenderingHandler(EntityList.NOONOO, new NooNooRenderer.RenderFactory());

		RenderingRegistry.registerEntityRenderingHandler(EntityList.MIMI, new TiddlytubbyRenderer.RenderFactory("mimi"));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.DAADAA, new TiddlytubbyRenderer.RenderFactory("daadaa"));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.PING, new TiddlytubbyRenderer.RenderFactory("ping"));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.BA, new TiddlytubbyRenderer.RenderFactory("ba"));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.RURU, new TiddlytubbyRenderer.RenderFactory("ruru"));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.NIN, new TiddlytubbyRenderer.RenderFactory("nin"));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.DUGGLEDEE, new TiddlytubbyRenderer.RenderFactory("duggledee"));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.UMPIEPUMPIE, new TiddlytubbyRenderer.RenderFactory("umpiepumpie"));

		RenderingRegistry.registerEntityRenderingHandler(EntityList.TINKYWINKY_ZOMBIE, new TeletubbyRenderer.RenderFactory<>("tinkywinky_zombie", new TinkyWinkyZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.DIPSY_ZOMBIE, new TeletubbyRenderer.RenderFactory<>("dipsy_zombie", new DipsyZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.LAALAA_ZOMBIE, new TeletubbyRenderer.RenderFactory<>("laalaa_zombie", new LaaLaaZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(EntityList.PO_ZOMBIE, new TeletubbyRenderer.RenderFactory<>("po_zombie", new PoZombieModel()));

		RenderingRegistry.registerEntityRenderingHandler(EntityList.PO_SCOOTER, new PoScooterRenderer.RenderFactory());
	}	
}
