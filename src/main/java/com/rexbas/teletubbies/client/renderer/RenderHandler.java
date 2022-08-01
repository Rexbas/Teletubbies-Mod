package com.rexbas.teletubbies.client.renderer;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.entity.NooNooRenderer;
import com.rexbas.teletubbies.client.renderer.entity.PoScooterRenderer;
import com.rexbas.teletubbies.client.renderer.entity.TeletubbyRenderer;
import com.rexbas.teletubbies.client.renderer.entity.TiddlytubbyRenderer;
import com.rexbas.teletubbies.client.renderer.item.model.DipsyHatModel;
import com.rexbas.teletubbies.client.renderer.item.model.NooNooEyesModel;
import com.rexbas.teletubbies.client.renderer.item.model.TutuModel;
import com.rexbas.teletubbies.client.renderer.model.DipsyModel;
import com.rexbas.teletubbies.client.renderer.model.LaaLaaModel;
import com.rexbas.teletubbies.client.renderer.model.NooNooModel;
import com.rexbas.teletubbies.client.renderer.model.PoModel;
import com.rexbas.teletubbies.client.renderer.model.PoScooterModel;
import com.rexbas.teletubbies.client.renderer.model.TiddlytubbyModel;
import com.rexbas.teletubbies.client.renderer.model.TinkyWinkyModel;
import com.rexbas.teletubbies.init.TeletubbiesEntityTypes;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
    public static final ModelLayerLocation DIPSY_HAT_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "dipsy_hat"), "dipsy_hat");
    public static final ModelLayerLocation TUTU_LAYER = new ModelLayerLocation(new ResourceLocation(Teletubbies.MODID, "tutu"), "tutu");
    	
    @SubscribeEvent
    public static void registerEntityRenders(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(TeletubbiesEntityTypes.TINKYWINKY.get(), (ctx) -> {
			return new TeletubbyRenderer<>(ctx, 0.95F, new TinkyWinkyModel<>(ctx.bakeLayer(TINKYWINKY_LAYER), false), new ResourceLocation(Teletubbies.MODID, "textures/entity/tinkywinky.png"));
		});
		event.registerEntityRenderer(TeletubbiesEntityTypes.DIPSY.get(), (ctx) -> {
			return new TeletubbyRenderer<>(ctx, 0.9F, new DipsyModel<>(ctx.bakeLayer(DIPSY_LAYER), false), new ResourceLocation(Teletubbies.MODID, "textures/entity/dipsy.png"));
		});
		event.registerEntityRenderer(TeletubbiesEntityTypes.LAALAA.get(), (ctx) -> {
			return new TeletubbyRenderer<>(ctx, 0.85F, new LaaLaaModel<>(ctx.bakeLayer(LAALAA_LAYER), false), new ResourceLocation(Teletubbies.MODID, "textures/entity/laalaa.png"));
		});
		event.registerEntityRenderer(TeletubbiesEntityTypes.PO.get(), (ctx) -> {
			return new TeletubbyRenderer<>(ctx, 0.8F, new PoModel<>(ctx.bakeLayer(PO_LAYER), false), new ResourceLocation(Teletubbies.MODID, "textures/entity/po.png"));
		});

        event.registerEntityRenderer(TeletubbiesEntityTypes.NOONOO.get(), NooNooRenderer::new);
        
        event.registerEntityRenderer(TeletubbiesEntityTypes.MIMI.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "mimi");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.DAADAA.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "daadaa");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.PING.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "ping");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.BA.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "ba");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.RURU.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "ruru");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.NIN.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "nin");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.DUGGLEDEE.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "duggledee");});
        event.registerEntityRenderer(TeletubbiesEntityTypes.UMPIEPUMPIE.get(), (ctx) -> {return new TiddlytubbyRenderer(ctx, "umpiepumpie");});

		event.registerEntityRenderer(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), (ctx) -> {
			return new TeletubbyRenderer<>(ctx, 0.95F, new TinkyWinkyModel<>(ctx.bakeLayer(TINKYWINKY_LAYER), true), new ResourceLocation(Teletubbies.MODID, "textures/entity/tinkywinky_zombie.png"));
		});
		event.registerEntityRenderer(TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), (ctx) -> {
			return new TeletubbyRenderer<>(ctx, 0.9F, new DipsyModel<>(ctx.bakeLayer(DIPSY_LAYER), true), new ResourceLocation(Teletubbies.MODID, "textures/entity/dipsy_zombie.png"));
		});
		event.registerEntityRenderer(TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), (ctx) -> {
			return new TeletubbyRenderer<>(ctx, 0.85F, new LaaLaaModel<>(ctx.bakeLayer(LAALAA_LAYER), true), new ResourceLocation(Teletubbies.MODID, "textures/entity/laalaa_zombie.png"));
		});
		event.registerEntityRenderer(TeletubbiesEntityTypes.PO_ZOMBIE.get(), (ctx) -> {
			return new TeletubbyRenderer<>(ctx, 0.8F, new PoModel<>(ctx.bakeLayer(PO_LAYER), true), new ResourceLocation(Teletubbies.MODID, "textures/entity/po_zombie.png"));
		});

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
        event.registerLayerDefinition(DIPSY_HAT_LAYER, DipsyHatModel::createBodyLayer);
        event.registerLayerDefinition(TUTU_LAYER, TutuModel::createBodyLayer);
    }
}