package teletubbies.client.renderer.entity.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.baby.TiddlytubbyEntity;

@OnlyIn(Dist.CLIENT)
public class TiddlytubbyModel<T extends TiddlytubbyEntity> extends EntityModel<T> {
	public RendererModel rightArm;
	public RendererModel leftArm;
	public  RendererModel rightLeg;
	public  RendererModel leftLeg;
	public  RendererModel head;
	public  RendererModel body;

	public TiddlytubbyModel() {
		textureWidth = 32;
		textureHeight = 32;

		rightArm = new RendererModel(this);
		rightArm.setRotationPoint(-4.0F, 18.0F, 0.0F);
		rightArm.cubeList.add(new ModelBox(rightArm, 0, 21, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, false));

		leftArm = new RendererModel(this);
		leftArm.setRotationPoint(4.0F, 18.0F, 0.0F);
		leftArm.cubeList.add(new ModelBox(leftArm, 0, 21, -1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F, false));

		rightLeg = new RendererModel(this);
		rightLeg.setRotationPoint(-2.0F, 23.0F, -3.0F);
		rightLeg.cubeList.add(new ModelBox(rightLeg, 0, 16, -1.0F, -1.0F, -2.0F, 2, 2, 3, 0.0F, false));

		leftLeg = new RendererModel(this);
		leftLeg.setRotationPoint(2.0F, 23.0F, -3.0F);
		leftLeg.cubeList.add(new ModelBox(leftLeg, 0, 16, -1.0F, -1.0F, -2.0F, 2, 2, 3, 0.0F, false));

		head = new RendererModel(this);
		head.setRotationPoint(0.0F, 17.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 0, 24, -1.0F, -10.0F, -1.0F, 2, 2, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 18, 28, -5.0F, -7.0F, 0.0F, 1, 3, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 22, 27, -5.0F, -6.0F, -2.0F, 1, 3, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 28, 30, -5.0F, -7.0F, -1.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 18, 28, 4.0F, -7.0F, 0.0F, 1, 3, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 22, 27, 4.0F, -6.0F, -2.0F, 1, 3, 2, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 28, 30, 4.0F, -7.0F, -1.0F, 1, 1, 1, 0.0F, false));
		head.cubeList.add(new ModelBox(head, 0, 0, -4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F, false));

		body = new RendererModel(this);
		body.setRotationPoint(0.0F, 17.0F, 0.0F);
		body.cubeList.add(new ModelBox(body, 10, 16, -3.0F, 0.0F, -2.0F, 6, 7, 4, 0.0F, false));
	}
	
	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		rightArm.render(scale);
		leftArm.render(scale);
		rightLeg.render(scale);
		leftLeg.render(scale);
		head.render(scale);
		body.render(scale);
	}
	
	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		boolean isMoving = entity.posX != entity.prevPosX || entity.posY != entity.prevPosY || entity.posZ != entity.prevPosZ;
		
		this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		
		if (isMoving) {
			this.rightArm.setRotationPoint(-4.0F, 20.0F, 0.0F);
			this.leftArm.setRotationPoint(4.0F, 20.0F, 0.0F);
			this.body.setRotationPoint(0.0F, 18.0F, -2.0F);
			this.rightLeg.setRotationPoint(-2.0F, 21.0F, 5.0F);
			this.leftLeg.setRotationPoint(2.0F, 21.0F, 5.0F);

			this.body.rotateAngleX = (float) (0.5 * Math.PI);
			this.rightLeg.rotateAngleX = (float) (0.5 * Math.PI);
			this.leftLeg.rotateAngleX = (float) (0.5 * Math.PI);
			
			this.rightLeg.rotateAngleX = (float) (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + (0.5 * Math.PI));
			this.leftLeg.rotateAngleX = (float) (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount + (0.5 * Math.PI));
			this.rightArm.rotateAngleZ = 0.0F;
			this.leftArm.rotateAngleZ = 0.0F;
			
			this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
			this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
			this.rightArm.rotateAngleZ = 0.0F;
			this.leftArm.rotateAngleZ = 0.0F;
			
		} else {
			this.rightArm.setRotationPoint(-4.0F, 18.0F, 0.0F);
			this.leftArm.setRotationPoint(4.0F, 18.0F, 0.0F);
			this.body.setRotationPoint(0.0F, 17.0F, 0.0F);
			this.rightLeg.setRotationPoint(-2.0F, 23.0F, -3.0F);
			this.leftLeg.setRotationPoint(2.0F, 23.0F, -3.0F);
			
			this.body.rotateAngleX = 0;
			this.rightLeg.rotateAngleX = 0;
			this.leftLeg.rotateAngleX = 0;			

			this.rightArm.rotateAngleZ = 0;
			this.leftArm.rotateAngleZ = 0;
			this.rightArm.rotateAngleX = 0;
			this.leftArm.rotateAngleX = 0;
			this.rightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			this.leftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			this.rightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
			this.leftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		}
	}
}
