package teletubbies.client.models.armor;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NooNooEyesModel extends BipedModel<LivingEntity> {
	public RendererModel eyes;

	public NooNooEyesModel() {
		textureWidth = 16;
		textureHeight = 16;

		eyes = new RendererModel(this);
		eyes.setRotationPoint(0.0F, 24.0F, 0.0F);
		eyes.cubeList.add(new ModelBox(eyes, 0, 10, 1.0F, -6.0F, -7.0F, 1, 3, 3, 0.0F, false));
		eyes.cubeList.add(new ModelBox(eyes, 0, 0, 0.0F, -5.0F, -7.0F, 3, 1, 3, 0.0F, false));
		eyes.cubeList.add(new ModelBox(eyes, 0, 4, -3.0F, -4.0F, -7.0F, 3, 1, 3, 0.0F, false));
		eyes.cubeList.add(new ModelBox(eyes, 8, 10, -2.0F, -5.0F, -7.0F, 1, 3, 3, 0.0F, false));
	}

	@Override
	public void render(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	    GlStateManager.pushMatrix();
    	if (entity.shouldRenderSneaking()) {
    		GlStateManager.translatef(0.0F, 0.2F, 0.0F);
        }
    	this.eyes.copyModelAngles(this.bipedHead);
    	this.eyes.render(scale);
	    GlStateManager.popMatrix();
	}
}