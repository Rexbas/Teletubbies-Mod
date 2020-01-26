package teletubbies.client.renderer.entity.model;

import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.monster.TeletubbyZombieEntity;

@OnlyIn(Dist.CLIENT)
public class TeletubbyZombieModel<T extends TeletubbyZombieEntity> extends TeletubbyModel<T> {

	@Override
	public void render(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		boolean flag = func_212850_a_(entityIn);
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);
		bipedRightArm.rotateAngleZ = 0.0F;
		bipedLeftArm.rotateAngleZ = 0.0F;
		bipedRightArm.rotateAngleY = -(0.1F - f * 0.6F);
		bipedLeftArm.rotateAngleY = 0.1F - f * 0.6F;
		float f2 = -(float) Math.PI / (flag ? 1.5F : 2.25F);
		bipedRightArm.rotateAngleX = f2;
		bipedLeftArm.rotateAngleX = f2;
		bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		bipedLeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
		bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}

	public boolean func_212850_a_(T p_212850_1_) {
		return p_212850_1_.isAggressive();
	}
}
