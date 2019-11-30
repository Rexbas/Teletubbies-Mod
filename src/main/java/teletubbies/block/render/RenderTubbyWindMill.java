package teletubbies.block.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import teletubbies.block.model.ModelTubbyWindMillPole;
import teletubbies.block.model.ModelTubbyWindMillRotor;
import teletubbies.block.tileentity.TileEntityTubbyWindMill;

public class RenderTubbyWindMill extends TileEntitySpecialRenderer{
    
	private final ModelTubbyWindMillPole modelPole;
	private final ModelTubbyWindMillRotor modelRotor;
    
    public RenderTubbyWindMill() {  
    	this.modelPole = new ModelTubbyWindMillPole();
    	this.modelRotor = new ModelTubbyWindMillRotor();
    }
    
    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
    	renderModel((TileEntityTubbyWindMill) te, x, y, z, scale);
    }
    
    private void renderModel(TileEntityTubbyWindMill te, double x, double y, double z, float scale) {
    	while(te.isMaster() == null){
    		NBTTagCompound data = new NBTTagCompound();
    		te.readFromNBT(data);
    	}
    	
    	if(te.isMaster()){
    		//Pole
        	GL11.glPushMatrix();
        	GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
            ResourceLocation textures = (new ResourceLocation("teletubbies:textures/blocks/TubbyWindMill.png"));
            Minecraft.getMinecraft().renderEngine.bindTexture(textures);
            GL11.glPushMatrix();         
            GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            GL11.glPushMatrix();           
            GL11.glRotatef(te.getBlockMetadata() * 90, 0.0F, 1.0F, 0.0F);           
            this.modelPole.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);           
            GL11.glPopMatrix();            
            GL11.glPopMatrix();  
            GL11.glPopMatrix();
            
            //Rotor
            GL11.glPushMatrix();
            GL11.glTranslatef((float)x + 0.5F, (float)y + 4.7F, (float)z + 0.5F);
            if(te.getMasterDirection() == 0 || te.getMasterDirection() == 2){
                GL11.glRotatef(te.rotationAngle(), 0, 0, 1);
            }
            if(te.getMasterDirection() == 1 || te.getMasterDirection() == 3){
                GL11.glRotatef(te.rotationAngle(), 1, 0, 0);
            }
            Minecraft.getMinecraft().renderEngine.bindTexture(textures);
            GL11.glPushMatrix();
            GL11.glRotatef(te.getBlockMetadata() * 270, 0.0F, 1.0F, 0.0F);   
            this.modelRotor.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
            GL11.glPopMatrix();
    	}
    }
}
