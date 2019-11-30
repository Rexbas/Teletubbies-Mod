package teletubbies;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teletubbies.entity.baby.EntityBa;
import teletubbies.entity.baby.EntityDaaDaa;
import teletubbies.entity.baby.EntityDuggleDee;
import teletubbies.entity.baby.EntityMiMi;
import teletubbies.entity.baby.EntityNin;
import teletubbies.entity.baby.EntityPing;
import teletubbies.entity.baby.EntityRuRu;
import teletubbies.entity.baby.EntityUmpiePumpie;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;
import teletubbies.entity.passive.EntityDipsy;
import teletubbies.entity.passive.EntityLaaLaa;
import teletubbies.entity.passive.EntityNooNoo;
import teletubbies.entity.passive.EntityPo;
import teletubbies.entity.passive.EntityTinkyWinky;
import teletubbies.entity.render.RenderFactory;
import teletubbies.sounds.MovingSoundPoScooter;
import teletubbies.vehicle.EntityPoScooter;

public class ClientProxy extends CommonProxy {
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerRenders() {
		//Armor
		registerItem(Teletubbies.tubbyTutu);
		registerItem(Teletubbies.dipsyHat);
		registerItem(Teletubbies.nooNooEyes);
		registerItem(Teletubbies.tinkyWinkyBib);
		registerItem(Teletubbies.dipsyBib);
		registerItem(Teletubbies.poBib);
		registerItem(Teletubbies.poScooter);
		registerItem(Teletubbies.laaLaaBib);
		registerItem(Teletubbies.poHelmet);
		
		//Items
		registerItem(Teletubbies.tinkyWinkyStick);
		registerItem(Teletubbies.dipsyStick);
		registerItem(Teletubbies.laaLaaStick);
		registerItem(Teletubbies.poStick);
		registerItem(Teletubbies.tinkyWinkyBag);
		registerItem(Teletubbies.laaLaaBall);
		registerItem(Teletubbies.tubbyCustard);
		registerItem(Teletubbies.tubbyToast);
		registerItem(Teletubbies.tubbyBowl);
		
		//Blocks		
		registerItem(Teletubbies.tubbyVoiceTrumpetIB);
		registerItem(Teletubbies.tubbyToastMachineIB);
		registerItem(Teletubbies.tubbyCustardMachineIB);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerMobRenders() {
		//Teletubbies
		RenderingRegistry.registerEntityRenderingHandler(EntityTinkyWinky.class, new RenderFactory(0));
		RenderingRegistry.registerEntityRenderingHandler(EntityDipsy.class, new RenderFactory(1));
		RenderingRegistry.registerEntityRenderingHandler(EntityLaaLaa.class, new RenderFactory(2));
		RenderingRegistry.registerEntityRenderingHandler(EntityPo.class, new RenderFactory(3));
		RenderingRegistry.registerEntityRenderingHandler(EntityNooNoo.class, new RenderFactory(4));
		
		//Zombies Teletubbies
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieTinkyWinky.class, new RenderFactory(5));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieDipsy.class, new RenderFactory(6));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieLaaLaa.class, new RenderFactory(7));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombiePo.class, new RenderFactory(8));
		
		//Tiddlytubbies
		RenderingRegistry.registerEntityRenderingHandler(EntityMiMi.class, new RenderFactory(9));
		RenderingRegistry.registerEntityRenderingHandler(EntityDaaDaa.class, new RenderFactory(10));
		RenderingRegistry.registerEntityRenderingHandler(EntityPing.class, new RenderFactory(11));
		RenderingRegistry.registerEntityRenderingHandler(EntityBa.class, new RenderFactory(12));
		RenderingRegistry.registerEntityRenderingHandler(EntityRuRu.class, new RenderFactory(13));
		RenderingRegistry.registerEntityRenderingHandler(EntityNin.class, new RenderFactory(14));
		RenderingRegistry.registerEntityRenderingHandler(EntityDuggleDee.class, new RenderFactory(15));
		RenderingRegistry.registerEntityRenderingHandler(EntityUmpiePumpie.class, new RenderFactory(16));
		
		//PoScooter
		RenderingRegistry.registerEntityRenderingHandler(EntityPoScooter.class, new RenderFactory(17));
	}
	
	@SideOnly(Side.CLIENT)
	public void registerItem(Item i) {
		ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName(), "inventory"));
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void joinClientWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof EntityPoScooter) {
			Minecraft.getMinecraft().getSoundHandler().playSound(new MovingSoundPoScooter((EntityPoScooter) event.getEntity()));
		}
	}
}
