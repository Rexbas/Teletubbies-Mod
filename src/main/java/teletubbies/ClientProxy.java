package teletubbies;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teletubbies.entity.model.ModelDipsy;
import teletubbies.entity.model.ModelLaaLaa;
import teletubbies.entity.model.ModelNooNoo;
import teletubbies.entity.model.ModelPo;
import teletubbies.entity.model.ModelTinkyWinky;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;
import teletubbies.entity.passive.EntityDipsy;
import teletubbies.entity.passive.EntityLaaLaa;
import teletubbies.entity.passive.EntityNooNoo;
import teletubbies.entity.passive.EntityPo;
import teletubbies.entity.passive.EntityTinkyWinky;
import teletubbies.entity.render.RenderDipsy;
import teletubbies.entity.render.RenderLaaLaa;
import teletubbies.entity.render.RenderNooNoo;
import teletubbies.entity.render.RenderPo;
import teletubbies.entity.render.RenderTinkyWinky;
import teletubbies.entity.render.RenderZombieDipsy;
import teletubbies.entity.render.RenderZombieLaaLaa;
import teletubbies.entity.render.RenderZombiePo;
import teletubbies.entity.render.RenderZombieTinkyWinky;
import teletubbies.updatechecker.UpdateChecker;

public class ClientProxy extends CommonProxy {
		
	@SideOnly(Side.CLIENT)
	@Override
	public void registerRenders() {
		//Mobs
		RenderingRegistry.registerEntityRenderingHandler(EntityTinkyWinky.class, new RenderTinkyWinky(new ModelTinkyWinky(false), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityDipsy.class, new RenderDipsy(new ModelDipsy(false), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityLaaLaa.class, new RenderLaaLaa(new ModelLaaLaa(false), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityPo.class, new RenderPo(new ModelPo(false), 0));

		RenderingRegistry.registerEntityRenderingHandler(EntityNooNoo.class, new RenderNooNoo(new ModelNooNoo(), 0));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieTinkyWinky.class, new RenderZombieTinkyWinky(new ModelTinkyWinky(true), 0));		
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieDipsy.class, new RenderZombieDipsy(new ModelDipsy(true), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieLaaLaa.class, new RenderZombieLaaLaa(new ModelLaaLaa(true), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombiePo.class, new RenderZombiePo(new ModelPo(true), 0));
		
		//Armor
		registerItem(Teletubbies.tubbySkirt);
		registerItem(Teletubbies.dipsyHat);
		registerItem(Teletubbies.tinkyWinkyBib);
		registerItem(Teletubbies.dipsyBib);
		registerItem(Teletubbies.laaLaaBib);
		registerItem(Teletubbies.poBib);
		registerItem(Teletubbies.nooNooEyes);
		
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
		registerBlock(Teletubbies.tubbyVoiceTrumpet);
		registerBlock(Teletubbies.tubbyToastMachine);
		registerBlock(Teletubbies.tubbyCustardMachine);
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerUpdateChecker(){
		Teletubbies.updateChecker = new UpdateChecker();
		Thread updateCheckThread = new Thread(Teletubbies.updateChecker, "Teletubbies Update Checker");
		updateCheckThread.start();
	}
	
	public void registerItem(Item i){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(i, 0, new ModelResourceLocation(Teletubbies.MODID + ":" + i.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public void registerBlock(Block b){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(Item.getItemFromBlock(b), 0, new ModelResourceLocation(Teletubbies.MODID + ":" + b.getUnlocalizedName().substring(5), "inventory"));
	}
}
