package teletubbies.client.renderer.entity.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.ModelBox;
import net.minecraft.util.math.MathHelper;
import teletubbies.entity.passive.NooNooEntity;

public class NooNooModel extends EntityModel<NooNooEntity> {
	public  RendererModel feet;
	public  RendererModel body;
	public  RendererModel brush;
	public  RendererModel hose;
	public  RendererModel rightEye;
	public  RendererModel leftEye;

	public NooNooModel() {
		textureWidth = 128;
		textureHeight = 64;

		feet = new RendererModel(this);
		feet.setRotationPoint(0.5F, 22.25F, 4.0F);
		feet.cubeList.add(new ModelBox(feet, 66, 43, -4.5F, -1.25F, -10.0F, 9, 1, 20, 0.0F, false));
		feet.cubeList.add(new ModelBox(feet, 46, 7, -5.5F, -0.25F, -11.0F, 11, 2, 22, 0.0F, false));

		body = new RendererModel(this);
		body.setRotationPoint(0.5F, 15.5F, 9.2F);
		body.cubeList.add(new ModelBox(body, 0, 0, -6.5F, -4.5F, -16.2F, 1, 9, 22, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 0, 5.5F, -4.5F, -16.2F, 1, 9, 22, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 31, -5.5F, -5.5F, -16.2F, 11, 11, 22, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 31, -3.5F, -3.5F, 5.8F, 7, 7, 2, 0.0F, false));
		body.cubeList.add(new ModelBox(body, 0, 40, -1.5F, -1.5F, 7.8F, 3, 3, 2, 0.0F, false));

		brush = new RendererModel(this);
		brush.setRotationPoint(0.5F, 10.0F, -2.5F);
		brush.cubeList.add(new ModelBox(brush, 10, 50, -0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F, false));
		brush.cubeList.add(new ModelBox(brush, 10, 46, -1.5F, -3.0F, -1.5F, 3, 1, 3, 0.0F, false));

		hose = new RendererModel(this);
		hose.setRotationPoint(0.5F, 17.0F, -8.0F);
		hose.cubeList.add(new ModelBox(hose, 66, 31, -1.5F, -2.0F, -8.0F, 3, 3, 9, 0.0F, false));
		hose.cubeList.add(new ModelBox(hose, 66, 43, -1.5F, 1.0F, -8.0F, 3, 5, 3, 0.0F, false));
		hose.cubeList.add(new ModelBox(hose, 66, 51, -2.5F, 6.0F, -9.0F, 5, 1, 5, 0.0F, false));

		rightEye = new RendererModel(this);
		rightEye.setRotationPoint(-1.5F, 11.5F, -8.0F);
		rightEye.cubeList.add(new ModelBox(rightEye, 0, 0, 0.5F, -0.5F, -3.0F, 1, 1, 4, 0.0F, false));
		rightEye.cubeList.add(new ModelBox(rightEye, 0, 0, -1.5F, -0.5F, -3.0F, 1, 1, 4, 0.0F, false));
		rightEye.cubeList.add(new ModelBox(rightEye, 0, 5, -0.5F, -1.5F, -3.0F, 1, 3, 4, 0.0F, false));

		leftEye = new RendererModel(this);
		leftEye.setRotationPoint(2.5F, 11.5F, -8.0F);
		leftEye.cubeList.add(new ModelBox(leftEye, 0, 0, 0.5F, -0.5F, -3.0F, 1, 1, 4, 0.0F, false));
		leftEye.cubeList.add(new ModelBox(leftEye, 0, 0, -1.5F, -0.5F, -3.0F, 1, 1, 4, 0.0F, false));
		leftEye.cubeList.add(new ModelBox(leftEye, 0, 5, -0.5F, -1.5F, -3.0F, 1, 3, 4, 0.0F, false));
	}
	
	@Override
	public void render(NooNooEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		feet.render(scale);
		body.render(scale);
		brush.render(scale);
		hose.render(scale);
		rightEye.render(scale);
		leftEye.render(scale);
	}
	
	@Override
	public void setRotationAngles(NooNooEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		this.hose.rotateAngleY = MathHelper.cos(limbSwing * 0.6662F) * limbSwingAmount * 0.7F;

		this.rightEye.rotateAngleX = headPitch * ((float) Math.PI / 180F);
		this.rightEye.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
		
		this.leftEye.rotateAngleX = this.rightEye.rotateAngleX;
		this.leftEye.rotateAngleY = this.rightEye.rotateAngleY;
	}
}
