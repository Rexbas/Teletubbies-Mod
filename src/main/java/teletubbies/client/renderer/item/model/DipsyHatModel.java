package teletubbies.client.renderer.item.model;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DipsyHatModel extends BipedModel<LivingEntity> {
	public RendererModel hat;

	public DipsyHatModel() {
		textureWidth = 32;
		textureHeight = 32;
	
		hat = new RendererModel(this);
		hat.setRotationPoint(0.0F, 24.0F, 0.0F);
		hat.cubeList.add(new ModelBox(hat, 0, 24, -3.0F, -16.0F, -4.0F, 6, 7, 1, 0.0F, false));
		hat.cubeList.add(new ModelBox(hat, 0, 16, -3.0F, -16.0F, 3.0F, 6, 7, 1, 0.0F, false));
		hat.cubeList.add(new ModelBox(hat, 18, 19, -4.0F, -16.0F, -3.0F, 1, 7, 6, 0.0F, false));
		hat.cubeList.add(new ModelBox(hat, 18, 19, 3.0F, -16.0F, -3.0F, 1, 7, 6, 0.0F, false));
		hat.cubeList.add(new ModelBox(hat, 0, 0, -6.0F, -9.0F, 3.0F, 12, 2, 3, 0.0F, false));
		hat.cubeList.add(new ModelBox(hat, 0, 0, -6.0F, -9.0F, -6.0F, 12, 2, 3, 0.0F, false));
		hat.cubeList.add(new ModelBox(hat, 14, 6, -6.0F, -9.0F, -3.0F, 3, 2, 6, 0.0F, false));
		hat.cubeList.add(new ModelBox(hat, 0, 8, 3.0F, -9.0F, -3.0F, 3, 2, 6, 0.0F, false));
	}
	
	@Override
	public void render(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	    GlStateManager.pushMatrix();
    	if (entity.shouldRenderSneaking()) {
    		GlStateManager.translatef(0.0F, 0.2F, 0.0F);
        }
    	this.hat.copyModelAngles(this.bipedHead);
    	this.hat.render(scale);
	    GlStateManager.popMatrix();
	}
}
