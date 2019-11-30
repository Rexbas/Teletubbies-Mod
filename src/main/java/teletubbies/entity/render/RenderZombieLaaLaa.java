package teletubbies.entity.render;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import teletubbies.entity.model.ModelLaaLaa;
import teletubbies.entity.monster.EntityZombieLaaLaa;

import com.google.common.collect.Lists;

public class RenderZombieLaaLaa extends RenderBiped<EntityZombieLaaLaa> {
    private final ModelBiped defaultModel;
    private final List<LayerRenderer<EntityZombieLaaLaa>> defaultLayers;
	
	public RenderZombieLaaLaa(RenderManager rendermanager, boolean isZombie, final float scale, float shadowsize) {
		super(rendermanager, new ModelLaaLaa(isZombie, scale), shadowsize);
        LayerRenderer<?> layerrenderer = (LayerRenderer)this.layerRenderers.get(0);
        this.defaultModel = this.modelBipedMain;
        for(int i = 0; i < this.layerRenderers.size(); i++) {
        	LayerRenderer layer = this.layerRenderers.get(i);
        	if(layer instanceof LayerHeldItem) {
        		this.layerRenderers.remove(i);
        	}
        }
        
       LayerHeldItem heldItem = new LayerHeldItem(this) {
        	@Override
            public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale0) {
        		GlStateManager.pushMatrix();
        		GlStateManager.translate(0.0, 0.11, 0.05);
        		super.doRenderLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
        		GlStateManager.popMatrix();
        	}

        };
        this.addLayer(heldItem);
        LayerBipedArmor layerbipedarmor = new LayerBipedArmor(this) {
        	protected void initArmor() {
        		this.modelLeggings = new ModelZombie(0.5F, true);
        		this.modelArmor = new ModelZombie(1.0F, true);
        	}
        	
        	@Override
            public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale0) {
        		GlStateManager.pushMatrix();
        		GlStateManager.translate(0.0, 1.5 - (scale / 0.0625) * 1.5, 0.0);
        		super.doRenderLayer(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
        		GlStateManager.popMatrix();
        	}
        };
        this.addLayer(layerbipedarmor);
        this.defaultLayers = Lists.newArrayList(this.layerRenderers);
	}
	
	@Override
    public void doRender(EntityZombieLaaLaa entity, double x, double y, double z, float entityYaw, float partialTicks) {
    	this.swapArmor(entity);
    	super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}
	
	private void swapArmor(EntityZombieLaaLaa entity) {
		this.mainModel = this.defaultModel;
		this.layerRenderers = this.defaultLayers;
		this.modelBipedMain = (ModelBiped) this.mainModel;
	}
	
    protected void rotateCorpse(EntityZombieLaaLaa entityLiving, float f0, float f1, float partialTicks) {
        if(entityLiving.isConverting()) {
            f1 += (float)(Math.cos((double)entityLiving.ticksExisted * 3.25D) * Math.PI * 0.25D);
        }
        super.rotateCorpse((EntityZombieLaaLaa) entityLiving, f0, f1, partialTicks);
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityZombieLaaLaa entity) {
		return new ResourceLocation("teletubbies:textures/entity/ZombieLaaLaa.png");
	}
}