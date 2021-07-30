package teletubbies.client.renderer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.entity.NooNooRenderer;
import teletubbies.client.renderer.entity.TeletubbyRenderer;
import teletubbies.client.renderer.entity.model.NooNooModel;
import teletubbies.client.renderer.entity.model.TinkyWinkyModel;
import teletubbies.init.TeletubbiesEntityTypes;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RenderHandler {
	
    public static final ModelLayerLocation TINKYWINKY_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "tinkywinky"), "tinkywinky");
    public static final ModelLayerLocation NOONOO_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "noonoo"), "noonoo");
	
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TeletubbiesEntityTypes.TINKYWINKY.get(), (ctx) -> {return new TeletubbyRenderer<>(ctx, "tinkywinky", 0.95F, new TinkyWinkyModel(ctx.bakeLayer(TINKYWINKY_LAYER)));});
        event.registerEntityRenderer(TeletubbiesEntityTypes.NOONOO.get(), NooNooRenderer::new);
    }
    
    
    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(NOONOO_LAYER, NooNooModel::createBodyLayer);
        event.registerLayerDefinition(TINKYWINKY_LAYER, TinkyWinkyModel::createBodyLayer);
    }
    
	/*public static void registryEntityRenders() {
		/*RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.TINKYWINKY.get(), new TeletubbyRenderer.RenderFactory<>("tinkywinky", 0.95F, new TinkyWinkyModel()));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.DIPSY.get(), new TeletubbyRenderer.RenderFactory<>("dipsy", 0.9F, new DipsyModel()));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.LAALAA.get(), new TeletubbyRenderer.RenderFactory<>("laalaa", 0.85F, new LaaLaaModel()));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.PO.get(), new TeletubbyRenderer.RenderFactory<>("po", 0.8F, new PoModel()));*/
				
		//RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.NOONOO.get(), new NooNooRenderer.RenderFactory());

		/*RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.MIMI.get(), new TiddlytubbyRenderer.RenderFactory("mimi"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.DAADAA.get(), new TiddlytubbyRenderer.RenderFactory("daadaa"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.PING.get(), new TiddlytubbyRenderer.RenderFactory("ping"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.BA.get(), new TiddlytubbyRenderer.RenderFactory("ba"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.RURU.get(), new TiddlytubbyRenderer.RenderFactory("ruru"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.NIN.get(), new TiddlytubbyRenderer.RenderFactory("nin"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.DUGGLEDEE.get(), new TiddlytubbyRenderer.RenderFactory("duggledee"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.UMPIEPUMPIE.get(), new TiddlytubbyRenderer.RenderFactory("umpiepumpie"));

		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>("tinkywinky_zombie", 0.95F, new TinkyWinkyZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>("dipsy_zombie", 0.9F, new DipsyZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>("laalaa_zombie", 0.85F, new LaaLaaZombieModel()));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.PO_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>("po_zombie", 0.8F, new PoZombieModel()));

		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.PO_SCOOTER.get(), new PoScooterRenderer.RenderFactory());
	}*/
}
