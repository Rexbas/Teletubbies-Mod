package teletubbies.client.renderer.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.baby.TiddlytubbyEntity;

@OnlyIn(Dist.CLIENT)
public class TiddlytubbyModel<T extends TiddlytubbyEntity> extends EntityModel<T> {
	public ModelPart rightArm;
	public ModelPart leftArm;
	public ModelPart rightLeg;
	public ModelPart leftLeg;
	public ModelPart head;
	public ModelPart body;

	public TiddlytubbyModel() {
		texWidth = 32;
		texHeight = 32;

		rightArm = new ModelPart(this);
		rightArm.setPos(-4.0F, 18.0F, 0.0F);
		rightArm.addBox(null, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, 0, 21);

		leftArm = new ModelPart(this);
		leftArm.setPos(4.0F, 18.0F, 0.0F);
		leftArm.addBox(null, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, 0, 21);

		rightLeg = new ModelPart(this);
		rightLeg.setPos(-2.0F, 23.0F, -3.0F);
		rightLeg.addBox(null, -1.0F, -1.0F, -2.0F, 2, 2, 3, 0.0F, 0, 16);

		leftLeg = new ModelPart(this);
		leftLeg.setPos(2.0F, 23.0F, -3.0F);
		leftLeg.addBox(null, -1.0F, -1.0F, -2.0F, 2, 2, 3, 0.0F, 0, 16);

		head = new ModelPart(this);
		head.setPos(0.0F, 17.0F, 0.0F);
		head.addBox(null, -1.0F, -10.0F, -1.0F, 2, 2, 2, 0.0F, 0, 24);
		head.addBox(null, -5.0F, -7.0F, 0.0F, 1, 3, 1, 0.0F, 18, 28);
		head.addBox(null, -5.0F, -6.0F, -2.0F, 1, 3, 2, 0.0F, 22, 27);
		head.addBox(null, -5.0F, -7.0F, -1.0F, 1, 1, 1, 0.0F, 28, 30);
		head.addBox(null, 4.0F, -7.0F, 0.0F, 1, 3, 1, 0.0F, 18, 28);
		head.addBox(null, 4.0F, -6.0F, -2.0F, 1, 3, 2, 0.0F, 22, 27);
		head.addBox(null, 4.0F, -7.0F, -1.0F, 1, 1, 1, 0.0F, 28, 30);
		head.addBox(null, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);

		body = new ModelPart(this);
		body.setPos(0.0F, 17.0F, 0.0F);
		body.addBox(null, -3.0F, 0.0F, -2.0F, 6, 7, 4, 0.0F, 10, 16);
	}
	
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		boolean isMoving = entity.getX() != entity.xo || entity.getY() != entity.yo || entity.getZ() != entity.zo;
		
		head.yRot = netHeadYaw * ((float) Math.PI / 180F);
		head.xRot = headPitch * ((float) Math.PI / 180F);

		if (isMoving) {
			rightArm.setPos(-4.0F, 20.0F, 0.0F);
			leftArm.setPos(4.0F, 20.0F, 0.0F);
			body.setPos(0.0F, 18.0F, -2.0F);
			rightLeg.setPos(-2.0F, 21.0F, 5.0F);
			leftLeg.setPos(2.0F, 21.0F, 5.0F);

			body.xRot = (float) (0.5 * Math.PI);
			rightLeg.xRot = (float) (0.5 * Math.PI);
			leftLeg.xRot = (float) (0.5 * Math.PI);

			rightLeg.xRot = (float) (Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + (0.5 * Math.PI));
			leftLeg.xRot = (float) (Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount + (0.5 * Math.PI));
			rightArm.zRot = 0.0F;
			leftArm.zRot = 0.0F;

			rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
			leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
			rightArm.zRot = 0.0F;
			leftArm.zRot = 0.0F;

		} else {
			rightArm.setPos(-4.0F, 18.0F, 0.0F);
			leftArm.setPos(4.0F, 18.0F, 0.0F);
			body.setPos(0.0F, 17.0F, 0.0F);
			rightLeg.setPos(-2.0F, 23.0F, -3.0F);
			leftLeg.setPos(2.0F, 23.0F, -3.0F);

			body.xRot = 0;
			rightLeg.xRot = 0;
			leftLeg.xRot = 0;

			rightArm.zRot = 0;
			leftArm.zRot = 0;
			rightArm.xRot = 0;
			leftArm.xRot = 0;
			rightArm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			leftArm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			rightArm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
			leftArm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		}
	}
	
	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		rightArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftArm.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftLeg.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		head.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}
