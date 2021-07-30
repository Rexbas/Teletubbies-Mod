package teletubbies.client.renderer;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.entity.NooNooRenderer;
import teletubbies.client.renderer.entity.PoScooterRenderer;
import teletubbies.client.renderer.entity.TeletubbyRenderer;
import teletubbies.client.renderer.entity.TiddlytubbyRenderer;
import teletubbies.client.renderer.entity.model.DipsyModel;
import teletubbies.client.renderer.entity.model.LaaLaaModel;
import teletubbies.client.renderer.entity.model.NooNooModel;
import teletubbies.client.renderer.entity.model.PoModel;
import teletubbies.client.renderer.entity.model.PoScooterModel;
import teletubbies.client.renderer.entity.model.TiddlytubbyModel;
import teletubbies.client.renderer.entity.model.TinkyWinkyModel;
import teletubbies.client.renderer.item.model.NooNooEyesModel;
import teletubbies.init.TeletubbiesEntityTypes;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RenderHandler {
	
    public static final ModelLayerLocation TINKYWINKY_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "tinkywinky"), "tinkywinky");
    public static final ModelLayerLocation DIPSY_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "dipsy"), "dipsy");
    public static final ModelLayerLocation LAALAA_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "laalaa"), "laalaa");
    public static final ModelLayerLocation PO_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "po"), "po");
    public static final ModelLayerLocation NOONOO_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "noonoo"), "noonoo");
    public static final ModelLayerLocation TIDDLYTUBBY_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "tiddlytubby"), "tiddlytubby");
    
    public static final ModelLayerLocation PO_SCOOTER_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "scooter"), "scooter");
    
    public static final ModelLayerLocation NOONOO_EYES_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "noonoo_eyes"), "noonoo_eyes");
	
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(TeletubbiesEntityTypes.TINKYWINKY.get(), (ctx) -> {return new TeletubbyRenderer<>(ctx, "tinkywinky", 0.95F, new TinkyWinkyModel<>(ctx.bakeLayer(TINKYWINKY_LAYER)));});
        event.registerEntityRenderer(TeletubbiesEntityTypes.DIPSY.get(), (ctx) -> {return new TeletubbyRenderer<>(ctx, "dipsy", 0.9F, new DipsyModel<>(ctx.bakeLayer(DIPSY_LAYER)));});
        event.registerEntityRenderer(TeletubbiesEntityTypes.LAALAA.get(), (ctx) -> {return new TeletubbyRenderer<>(ctx, "laalaa", 0.85F, new LaaLaaModel<>(ctx.bakeLayer(LAALAA_LAYER)));});
        event.registerEntityRenderer(TeletubbiesEntityTypes.PO.get(), (ctx) -> {return new TeletubbyRenderer<>(ctx, "po", 0.8F, new PoModel<>(ctx.bakeLayer(PO_LAYER)));});

        event.registerEntityRenderer(TeletubbiesEntityTypes.NOONOO.get(), NooNooRenderer::new);
        
        event.registerEntityRenderer(TeletubbiesEntityTypes.MIMI.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "mimi");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.DAADAA.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "daadaa");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.PING.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "ping");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.BA.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "ba");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.RURU.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "ruru");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.NIN.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "nin");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.DUGGLEDEE.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "duggledee");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.UMPIEPUMPIE.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "umpiepumpie");});

        event.registerEntityRenderer(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), (ctx) -> {return new TeletubbyRenderer<>(ctx, "tinkywinky_zombie", 0.95F, new TinkyWinkyModel<>(ctx.bakeLayer(TINKYWINKY_LAYER), true));});
        event.registerEntityRenderer(TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), (ctx) -> {return new TeletubbyRenderer<>(ctx, "dipsy_zombie", 0.9F, new DipsyModel<>(ctx.bakeLayer(DIPSY_LAYER), true));});
        event.registerEntityRenderer(TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), (ctx) -> {return new TeletubbyRenderer<>(ctx, "laalaa_zombie", 0.85F, new LaaLaaModel<>(ctx.bakeLayer(LAALAA_LAYER), true));});
        event.registerEntityRenderer(TeletubbiesEntityTypes.PO_ZOMBIE.get(), (ctx) -> {return new TeletubbyRenderer<>(ctx, "po_zombie", 0.8F, new PoModel<>(ctx.bakeLayer(PO_LAYER), true));});
        
        event.registerEntityRenderer(TeletubbiesEntityTypes.PO_SCOOTER.get(), PoScooterRenderer::new);
    }
    
    
    @SubscribeEvent
    public static void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TINKYWINKY_LAYER, TinkyWinkyModel::createBodyLayer);
        event.registerLayerDefinition(DIPSY_LAYER, DipsyModel::createBodyLayer);
        event.registerLayerDefinition(LAALAA_LAYER, LaaLaaModel::createBodyLayer);
        event.registerLayerDefinition(PO_LAYER, PoModel::createBodyLayer);
        event.registerLayerDefinition(NOONOO_LAYER, NooNooModel::createBodyLayer);
        event.registerLayerDefinition(TIDDLYTUBBY_LAYER, TiddlytubbyModel::createBodyLayer);
        
        event.registerLayerDefinition(PO_SCOOTER_LAYER, PoScooterModel::createBodyLayer);
        
        event.registerLayerDefinition(NOONOO_EYES_LAYER, NooNooEyesModel::createBodyLayer);
    }
}
