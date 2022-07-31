package com.rexbas.teletubbies.client.renderer;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.entity.NooNooRenderer;
import com.rexbas.teletubbies.client.renderer.entity.PoScooterRenderer;
import com.rexbas.teletubbies.client.renderer.entity.TeletubbyRenderer;
import com.rexbas.teletubbies.client.renderer.entity.TiddlytubbyRenderer;
import com.rexbas.teletubbies.client.renderer.model.DipsyModel;
import com.rexbas.teletubbies.client.renderer.model.LaaLaaModel;
import com.rexbas.teletubbies.client.renderer.model.PoModel;
import com.rexbas.teletubbies.client.renderer.model.TinkyWinkyModel;
import com.rexbas.teletubbies.entity.monster.DipsyZombieEntity;
import com.rexbas.teletubbies.entity.monster.LaaLaaZombieEntity;
import com.rexbas.teletubbies.entity.monster.PoZombieEntity;
import com.rexbas.teletubbies.entity.monster.TinkyWinkyZombieEntity;
import com.rexbas.teletubbies.entity.passive.DipsyEntity;
import com.rexbas.teletubbies.entity.passive.LaaLaaEntity;
import com.rexbas.teletubbies.entity.passive.PoEntity;
import com.rexbas.teletubbies.entity.passive.TinkyWinkyEntity;
import com.rexbas.teletubbies.init.TeletubbiesEntityTypes;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
	
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.TINKYWINKY.get(), new TeletubbyRenderer.RenderFactory<>(0.95F, new TinkyWinkyModel<TinkyWinkyEntity>(false), new ResourceLocation(Teletubbies.MODID, "textures/entity/tinkywinky.png")));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.DIPSY.get(), new TeletubbyRenderer.RenderFactory<>(0.9F, new DipsyModel<DipsyEntity>(false), new ResourceLocation(Teletubbies.MODID, "textures/entity/dipsy.png")));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.LAALAA.get(), new TeletubbyRenderer.RenderFactory<>(0.85F, new LaaLaaModel<LaaLaaEntity>(false), new ResourceLocation(Teletubbies.MODID, "textures/entity/laalaa.png")));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.PO.get(), new TeletubbyRenderer.RenderFactory<>(0.8F, new PoModel<PoEntity>(false), new ResourceLocation(Teletubbies.MODID, "textures/entity/po.png")));
				
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.NOONOO.get(), new NooNooRenderer.RenderFactory());

		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.MIMI.get(), new TiddlytubbyRenderer.RenderFactory("mimi"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.DAADAA.get(), new TiddlytubbyRenderer.RenderFactory("daadaa"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.PING.get(), new TiddlytubbyRenderer.RenderFactory("ping"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.BA.get(), new TiddlytubbyRenderer.RenderFactory("ba"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.RURU.get(), new TiddlytubbyRenderer.RenderFactory("ruru"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.NIN.get(), new TiddlytubbyRenderer.RenderFactory("nin"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.DUGGLEDEE.get(), new TiddlytubbyRenderer.RenderFactory("duggledee"));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.UMPIEPUMPIE.get(), new TiddlytubbyRenderer.RenderFactory("umpiepumpie"));

		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.TINKYWINKY_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>(0.95F, new TinkyWinkyModel<TinkyWinkyZombieEntity>(true), new ResourceLocation(Teletubbies.MODID, "textures/entity/tinkywinky_zombie.png")));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.DIPSY_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>(0.9F, new DipsyModel<DipsyZombieEntity>(true), new ResourceLocation(Teletubbies.MODID, "textures/entity/dipsy_zombie.png")));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.LAALAA_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>(0.85F, new LaaLaaModel<LaaLaaZombieEntity>(true), new ResourceLocation(Teletubbies.MODID, "textures/entity/laalaa_zombie.png")));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.PO_ZOMBIE.get(), new TeletubbyRenderer.RenderFactory<>(0.8F, new PoModel<PoZombieEntity>(true), new ResourceLocation(Teletubbies.MODID, "textures/entity/po_zombie.png")));
		
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.PO_SCOOTER.get(), new PoScooterRenderer.RenderFactory());
	}	
}