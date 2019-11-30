package teletubbies;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import teletubbies.block.itemrender.ItemRenderTubbyCustardMachine;
import teletubbies.block.itemrender.ItemRenderTubbyToastMachine;
import teletubbies.block.itemrender.ItemRenderTubbyVoiceTrumpet;
import teletubbies.block.itemrender.ItemRenderTubbyWindMill;
import teletubbies.block.render.RenderTubbyCustardMachine;
import teletubbies.block.render.RenderTubbyToastMachine;
import teletubbies.block.render.RenderTubbyVoiceTrumpet;
import teletubbies.block.render.RenderTubbyWindMill;
import teletubbies.block.tileentity.TileEntityTubbyCustardMachine;
import teletubbies.block.tileentity.TileEntityTubbyToastMachine;
import teletubbies.block.tileentity.TileEntityTubbyVoiceTrumpet;
import teletubbies.block.tileentity.TileEntityTubbyWindMill;
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
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy{
		
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
		
		//TileEntity Blocks
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTubbyVoiceTrumpet.class, new RenderTubbyVoiceTrumpet());        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTubbyToastMachine.class, new RenderTubbyToastMachine());        
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTubbyCustardMachine.class, new RenderTubbyCustardMachine());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTubbyWindMill.class, new RenderTubbyWindMill());

        
        //ItemRenders
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Teletubbies.tubbyVoiceTrumpet), new ItemRenderTubbyVoiceTrumpet(new RenderTubbyVoiceTrumpet(), new TileEntityTubbyVoiceTrumpet()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Teletubbies.tubbyToastMachine), new ItemRenderTubbyToastMachine(new RenderTubbyToastMachine(), new TileEntityTubbyToastMachine()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Teletubbies.tubbyCustardMachine), new ItemRenderTubbyCustardMachine(new RenderTubbyCustardMachine(), new TileEntityTubbyCustardMachine()));
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Teletubbies.tubbyWindMill), new ItemRenderTubbyWindMill(new RenderTubbyWindMill(), new TileEntityTubbyWindMill()));
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerUpdateChecker() {
		Teletubbies.updateChecker = new UpdateChecker();
		Thread updateCheckThread = new Thread(Teletubbies.updateChecker, "Teletubbies Update Checker");
		updateCheckThread.start();
	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
}
