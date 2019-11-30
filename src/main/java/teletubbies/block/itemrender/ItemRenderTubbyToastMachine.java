package teletubbies.block.itemrender;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import teletubbies.block.model.ModelTubbyToastMachine;


public class ItemRenderTubbyToastMachine implements IItemRenderer{

    ResourceLocation textures = (new ResourceLocation("teletubbies:textures/blocks/TubbyToastMachine.png"));
	TileEntitySpecialRenderer render;
	private TileEntity te;
	protected ModelTubbyToastMachine model;
	
	public ItemRenderTubbyToastMachine(TileEntitySpecialRenderer render, TileEntity entity){
		this.te = entity;
		this.render = render;
		model = new ModelTubbyToastMachine();
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type){
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper){
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data){		
		if(type == IItemRenderer.ItemRenderType.ENTITY){
			if(RenderItem.renderInFrame){
		    	GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, 0.5F, 0.0F);
		        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		        GL11.glPushMatrix(); 
		        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		        GL11.glPushMatrix(); 
		        GL11.glRotatef(270, 0.0F, 1.0F, 0.0F);
		        GL11.glPushMatrix(); 
		        this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.051F);        
		        GL11.glPopMatrix();            
		        GL11.glPopMatrix();  
		        GL11.glPopMatrix();
		        GL11.glPopMatrix();
			}
			else{
		    	GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, 0.5F, 0.0F);
		        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		        GL11.glPushMatrix(); 
		        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		        GL11.glPushMatrix(); 
		        this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.051F);        
		        GL11.glPopMatrix();            
		        GL11.glPopMatrix();  
		        GL11.glPopMatrix();
			}
		}
		if(type == IItemRenderer.ItemRenderType.EQUIPPED){
	    	GL11.glPushMatrix();
			GL11.glTranslatef(0.5F, 1.0F, 0.5F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
	        GL11.glPushMatrix(); 
	        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
	        GL11.glPushMatrix(); 
	        this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.051F);        
	        GL11.glPopMatrix();            
	        GL11.glPopMatrix();  
	        GL11.glPopMatrix();
		}
		if(type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.FIRST_PERSON_MAP){
	    	GL11.glPushMatrix();
			GL11.glTranslatef(0.5F, 1.0F, 0.5F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
	        GL11.glPushMatrix(); 
	        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
	        GL11.glPushMatrix();
	        GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
	        GL11.glPushMatrix(); 
	        this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.051F);        
	        GL11.glPopMatrix();            
	        GL11.glPopMatrix();  
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
		}
		if(type == IItemRenderer.ItemRenderType.INVENTORY){
	    	GL11.glPushMatrix();
			GL11.glTranslatef(-0.5F, -0.15F, -0.5F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
	        GL11.glPushMatrix();         
	        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F); 
	        GL11.glPushMatrix();
	        this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.051F);        
	        GL11.glPopMatrix();            
	        GL11.glPopMatrix();  
	        GL11.glPopMatrix();
		}
	}
}