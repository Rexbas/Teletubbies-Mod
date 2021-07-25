package teletubbies.client.renderer.entity.model;

import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.monster.TeletubbyZombieEntity;

@OnlyIn(Dist.CLIENT)
public class TeletubbyZombieModel<T extends TeletubbyZombieEntity> extends TeletubbyModel<T> {

	@Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		boolean flag = isAggressive(entityIn);
		float f = Mth.sin(attackTime * (float) Math.PI);
		float f1 = Mth.sin((1.0F - (1.0F - attackTime) * (1.0F - attackTime)) * (float) Math.PI);
		rightArm.zRot = 0.0F;
		leftArm.zRot = 0.0F;
		rightArm.yRot = -(0.1F - f * 0.6F);
		leftArm.yRot = 0.1F - f * 0.6F;
		float f2 = -(float) Math.PI / (flag ? 1.5F : 2.25F);
		rightArm.xRot = f2;
		leftArm.xRot = f2;
		rightArm.xRot += f * 1.2F - f1 * 0.4F;
		leftArm.xRot += f * 1.2F - f1 * 0.4F;
		rightArm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftArm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightArm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
		leftArm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
	}

	public boolean isAggressive(T p_212850_1_) {
		return p_212850_1_.isAggressive();
	}
}
