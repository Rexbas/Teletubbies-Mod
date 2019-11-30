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

import teletubbies.block.model.ModelTubbyWindMillPole;
import teletubbies.block.model.ModelTubbyWindMillRotor;
import teletubbies.block.tileentity.TileEntityTubbyWindMill;


public class ItemRenderTubbyWindMill implements IItemRenderer{

    ResourceLocation textures = (new ResourceLocation("teletubbies:textures/blocks/TubbyWindMill.png"));
	TileEntitySpecialRenderer render;
	private TileEntity te;
	protected ModelTubbyWindMillPole modelPole;
	protected ModelTubbyWindMillRotor modelRotor;
	
	public ItemRenderTubbyWindMill(TileEntitySpecialRenderer render, TileEntity entity){
		this.te = (TileEntityTubbyWindMill) entity;
		this.render = render;
		modelPole = new ModelTubbyWindMillPole();
		modelRotor = new ModelTubbyWindMillRotor();
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
		    	//Pole
				GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, -0.25F, 0.0F);
		        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		        GL11.glPushMatrix(); 
		        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		        GL11.glPushMatrix(); 
		        GL11.glRotatef(270, 0.0F, 1.0F, 0.0F);
		        GL11.glPushMatrix(); 
		        this.modelPole.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
		        GL11.glPopMatrix();            
		        GL11.glPopMatrix();  
		        GL11.glPopMatrix();
		        GL11.glPopMatrix();
		        
		        //Rotor
		    	GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, 0.775F, 0.0F);
		        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		        GL11.glPushMatrix();         
		        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F); 
		        GL11.glPushMatrix();
		        GL11.glRotatef(270, 0.0F, 1.0F, 0.0F);
		        GL11.glPushMatrix();
		        GL11.glRotatef(45, 0.0F, 0.0F, 1.0F); 
		        GL11.glPushMatrix();
		        this.modelRotor.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
		        GL11.glPopMatrix();            
		        GL11.glPopMatrix(); 
		        GL11.glPopMatrix();  
		        GL11.glPopMatrix();
		        GL11.glPopMatrix();
			}
			else{
				//Pole
		    	GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, -0.25F, 0.0F);
		        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		        GL11.glPushMatrix(); 
		        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
		        GL11.glPushMatrix(); 
		        this.modelPole.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
		        GL11.glPopMatrix();            
		        GL11.glPopMatrix();  
		        GL11.glPopMatrix();
		        
		        //Rotor
		    	GL11.glPushMatrix();
				GL11.glTranslatef(0.0F, 0.775F, 0.0F);
		        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		        GL11.glPushMatrix();         
		        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F); 
		        GL11.glPushMatrix();
		        GL11.glRotatef(45, 0.0F, 0.0F, 1.0F); 
		        GL11.glPushMatrix();
		        this.modelRotor.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
		        GL11.glPopMatrix();            
		        GL11.glPopMatrix(); 
		        GL11.glPopMatrix();  
		        GL11.glPopMatrix();
			}
		}
		if(type == IItemRenderer.ItemRenderType.EQUIPPED){
			//Pole
	    	GL11.glPushMatrix();
			GL11.glTranslatef(0.75F, 0.7F, 0.75F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
	        GL11.glPushMatrix(); 
	        GL11.glRotatef(90, 1.0F, 0.0F, 0.0F);
	        GL11.glPushMatrix();
	        GL11.glRotatef(-45, 0.0F, 0.0F, 1.0F);
	        GL11.glPushMatrix();
	        GL11.glRotatef(45, 1.0F, 0.0F, 0.0F);
	        GL11.glPushMatrix();
	        GL11.glRotatef(45, 0.0F, 1.0F, 0.0F);
	        GL11.glPushMatrix();
	        this.modelPole.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
	        GL11.glPopMatrix();            
	        GL11.glPopMatrix();  
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
	        
	        //Rotor
	    	GL11.glPushMatrix();
			GL11.glTranslatef(0.25F, 1.425F, 0.25F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
	        GL11.glPushMatrix();         
	        GL11.glRotatef(90, 1.0F, 0.0F, 0.0F); 
	        GL11.glPushMatrix();
	        GL11.glRotatef(-45, 0.0F, 0.0F, 1.0F);
	        GL11.glPushMatrix();
	        GL11.glRotatef(45, 1.0F, 0.0F, 0.0F);
	        GL11.glPushMatrix();
	        GL11.glRotatef(45, 0.0F, 1.0F, 0.0F);
	        GL11.glPushMatrix();
	        GL11.glRotatef(45, 0.0F, 0.0F, 1.0F); 
	        GL11.glPushMatrix();
	        this.modelRotor.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
	        GL11.glPopMatrix();            
	        GL11.glPopMatrix(); 
	        GL11.glPopMatrix();  
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
		}
		if(type == IItemRenderer.ItemRenderType.EQUIPPED_FIRST_PERSON || type == IItemRenderer.ItemRenderType.FIRST_PERSON_MAP){
	    	//Pole
			GL11.glPushMatrix();
			GL11.glTranslatef(0.5F, 1.0F, 0.5F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
	        GL11.glPushMatrix(); 
	        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F);
	        GL11.glPushMatrix();
	        GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
	        GL11.glPushMatrix(); 
	        this.modelPole.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
	        GL11.glPopMatrix();            
	        GL11.glPopMatrix();  
	        GL11.glPopMatrix();
	        GL11.glPopMatrix();
	        
	        //Rotor
	    	GL11.glPushMatrix();
			GL11.glTranslatef(0.5F, 2.025F, 0.5F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
	        GL11.glPushMatrix();         
	        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F); 
	        GL11.glPushMatrix();
	        GL11.glRotatef(90, 0.0F, 1.0F, 0.0F);
	        GL11.glPushMatrix(); 
	        GL11.glRotatef(45, 0.0F, 0.0F, 1.0F); 
	        GL11.glPushMatrix();
	        this.modelRotor.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
	        GL11.glPopMatrix();            
	        GL11.glPopMatrix(); 
	        GL11.glPopMatrix(); 
	        GL11.glPopMatrix();  
	        GL11.glPopMatrix();
		}
		if(type == IItemRenderer.ItemRenderType.INVENTORY){
			//Pole
	    	GL11.glPushMatrix();
			GL11.glTranslatef(-0.5F, -0.77F, -0.5F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
	        GL11.glPushMatrix();         
	        GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F); 
	        GL11.glPushMatrix();
	        this.modelPole.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
	        GL11.glPopMatrix();            
	        GL11.glPopMatrix();  
	        GL11.glPopMatrix();
	        
	        //Rotor
	    	GL11.glPushMatrix();
			GL11.glTranslatef(-0.5F, 0.24F, -0.5F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(textures);
	        GL11.glPushMatrix();         
	        GL11.glRotatef(180, 1.0F, 0.0F, 0.0F); 
	        GL11.glPushMatrix();
	        GL11.glRotatef(45, 0.0F, 0.0F, 1.0F); 
	        GL11.glPushMatrix();
	        this.modelRotor.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.02F);        
	        GL11.glPopMatrix();            
	        GL11.glPopMatrix(); 
	        GL11.glPopMatrix();  
	        GL11.glPopMatrix();
		}
	}
}