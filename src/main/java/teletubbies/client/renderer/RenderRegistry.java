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
import teletubbies.entity.baby.BaEntity;
import teletubbies.entity.baby.DaaDaaEntity;
import teletubbies.entity.baby.DuggleDeeEntity;
import teletubbies.entity.baby.MiMiEntity;
import teletubbies.entity.baby.NinEntity;
import teletubbies.entity.baby.PingEntity;
import teletubbies.entity.baby.RuRuEntity;
import teletubbies.entity.baby.UmpiePumpieEntity;
import teletubbies.entity.item.PoScooterEntity;
import teletubbies.entity.monster.DipsyZombieEntity;
import teletubbies.entity.monster.LaaLaaZombieEntity;
import teletubbies.entity.monster.PoZombieEntity;
import teletubbies.entity.monster.TinkyWinkyZombieEntity;
import teletubbies.entity.passive.DipsyEntity;
import teletubbies.entity.passive.LaaLaaEntity;
import teletubbies.entity.passive.NooNooEntity;
import teletubbies.entity.passive.PoEntity;
import teletubbies.entity.passive.TinkyWinkyEntity;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
	
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(TinkyWinkyEntity.class, new TeletubbyRenderer.RenderFactory<>("tinkywinky", 0.0625F, new TinkyWinkyModel()));
		RenderingRegistry.registerEntityRenderingHandler(DipsyEntity.class, new TeletubbyRenderer.RenderFactory<>("dipsy", 0.0595F, new DipsyModel()));
		RenderingRegistry.registerEntityRenderingHandler(LaaLaaEntity.class, new TeletubbyRenderer.RenderFactory<>("laalaa", 0.0565F, new LaaLaaModel()));
		RenderingRegistry.registerEntityRenderingHandler(PoEntity.class, new TeletubbyRenderer.RenderFactory<>("po", 0.0535F, new PoModel()));
				
		RenderingRegistry.registerEntityRenderingHandler(NooNooEntity.class, new NooNooRenderer.RenderFactory());

		RenderingRegistry.registerEntityRenderingHandler(MiMiEntity.class, new TiddlytubbyRenderer.RenderFactory("mimi"));
		RenderingRegistry.registerEntityRenderingHandler(DaaDaaEntity.class, new TiddlytubbyRenderer.RenderFactory("daadaa"));
		RenderingRegistry.registerEntityRenderingHandler(PingEntity.class, new TiddlytubbyRenderer.RenderFactory("ping"));
		RenderingRegistry.registerEntityRenderingHandler(BaEntity.class, new TiddlytubbyRenderer.RenderFactory("ba"));
		RenderingRegistry.registerEntityRenderingHandler(RuRuEntity.class, new TiddlytubbyRenderer.RenderFactory("ruru"));
		RenderingRegistry.registerEntityRenderingHandler(NinEntity.class, new TiddlytubbyRenderer.RenderFactory("nin"));
		RenderingRegistry.registerEntityRenderingHandler(DuggleDeeEntity.class, new TiddlytubbyRenderer.RenderFactory("duggledee"));
		RenderingRegistry.registerEntityRenderingHandler(UmpiePumpieEntity.class, new TiddlytubbyRenderer.RenderFactory("umpiepumpie"));

		RenderingRegistry.registerEntityRenderingHandler(TinkyWinkyZombieEntity.class, new TeletubbyRenderer.RenderFactory<>("tinkywinky_zombie", 0.0625F, new TinkyWinkyZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(DipsyZombieEntity.class, new TeletubbyRenderer.RenderFactory<>("dipsy_zombie", 0.0595F, new DipsyZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(LaaLaaZombieEntity.class, new TeletubbyRenderer.RenderFactory<>("laalaa_zombie", 0.0625F, new LaaLaaZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(PoZombieEntity.class, new TeletubbyRenderer.RenderFactory<>("po_zombie", 0.0535F, new PoZombieModel()));

		RenderingRegistry.registerEntityRenderingHandler(PoScooterEntity.class, new PoScooterRenderer.RenderFactory());
	}	
}
