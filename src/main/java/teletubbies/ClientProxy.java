package teletubbies;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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

public class ClientProxy extends CommonProxy {
		
	@SideOnly(Side.CLIENT)
	@Override
	public void registerRenders() {
	
		//Armor
		registerItem(Teletubbies.tubbySkirt);
		registerItem(Teletubbies.dipsyHat);
		registerItem(Teletubbies.nooNooEyes);
		registerItem(Teletubbies.tinkyWinkyBib);
		registerItem(Teletubbies.dipsyBib);
		registerItem(Teletubbies.laaLaaBib);
		registerItem(Teletubbies.poBib);
		
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
	public void registerMobRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTinkyWinky.class, new RenderFactory(0));
		RenderingRegistry.registerEntityRenderingHandler(EntityDipsy.class, new RenderFactory(1));
		RenderingRegistry.registerEntityRenderingHandler(EntityLaaLaa.class, new RenderFactory(2));
		RenderingRegistry.registerEntityRenderingHandler(EntityPo.class, new RenderFactory(3));
		RenderingRegistry.registerEntityRenderingHandler(EntityNooNoo.class, new RenderFactory(4));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieTinkyWinky.class, new RenderFactory(5));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieDipsy.class, new RenderFactory(6));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieLaaLaa.class, new RenderFactory(7));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombiePo.class, new RenderFactory(8));

	}
	
	public void registerItem(Item i) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(i, 0, new ModelResourceLocation(Teletubbies.MODID + ":" + i.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public void registerBlock(Block b) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(Item.getItemFromBlock(b), 0, new ModelResourceLocation(Teletubbies.MODID + ":" + b.getUnlocalizedName().substring(5), "inventory"));
	}
}
