package com.rexbas.teletubbies.client.renderer;

import com.rexbas.teletubbies.client.renderer.entity.NooNooRenderer;
import com.rexbas.teletubbies.client.renderer.entity.PoScooterRenderer;
import com.rexbas.teletubbies.client.renderer.entity.TeletubbyRenderer;
import com.rexbas.teletubbies.client.renderer.entity.TiddlytubbyRenderer;
import com.rexbas.teletubbies.client.renderer.entity.model.DipsyModel;
import com.rexbas.teletubbies.client.renderer.entity.model.DipsyZombieModel;
import com.rexbas.teletubbies.client.renderer.entity.model.LaaLaaModel;
import com.rexbas.teletubbies.client.renderer.entity.model.LaaLaaZombieModel;
import com.rexbas.teletubbies.client.renderer.entity.model.PoModel;
import com.rexbas.teletubbies.client.renderer.entity.model.PoZombieModel;
import com.rexbas.teletubbies.client.renderer.entity.model.TinkyWinkyModel;
import com.rexbas.teletubbies.client.renderer.entity.model.TinkyWinkyZombieModel;
import com.rexbas.teletubbies.init.TeletubbiesEntityTypes;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {
	
	public static void registryEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.TINKYWINKY.get(), new TeletubbyRenderer.RenderFactory<>("tinkywinky", 0.95F, new TinkyWinkyModel()));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.DIPSY.get(), new TeletubbyRenderer.RenderFactory<>("dipsy", 0.9F, new DipsyModel()));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.LAALAA.get(), new TeletubbyRenderer.RenderFactory<>("laalaa", 0.85F, new LaaLaaModel()));
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.PO.get(), new TeletubbyRenderer.RenderFactory<>("po", 0.8F, new PoModel()));
				
		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.NOONOO.get(), new NooNooRenderer.RenderFactory());

		RenderingRegistry.registerEntityRenderingHandler(TeletubbiesEntityTypes.MIMI.get(), new TiddlytubbyRenderer.RenderFactory("mimi"));
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
	}	
}
