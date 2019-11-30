package teletubbies.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import teletubbies.entity.baby.EntityTiddlytubby;

public class ModelTiddlytubby extends ModelBase {

	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer head;
	ModelRenderer stick;
	ModelRenderer ear11;
	ModelRenderer ear12;
	ModelRenderer ear21;
	ModelRenderer ear22;

	public ModelTiddlytubby() {		
		body = new ModelRenderer(this, 10, 16);
		body.addBox(-3F, 0F, -2F, 6, 7, 4);
		body.setRotationPoint(0F, 17F, 0F);
		body.setTextureSize(64, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 30, 16);
		rightarm.addBox(-2F, -1F, -1F, 2, 5, 2);
		rightarm.setRotationPoint(-3F, 18F, 0F);
		rightarm.setTextureSize(64, 32);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 30, 16);
		leftarm.addBox(0F, -1F, -1F, 2, 5, 2);
		leftarm.setRotationPoint(3F, 18F, 0F);
		leftarm.setTextureSize(64, 32);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-1F, -1F, -3F, 2, 2, 3);
		rightleg.setRotationPoint(-2F, 23F, -2F);
		rightleg.setTextureSize(64, 32);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-1F, -1F, -3F, 2, 2, 3);
		leftleg.setRotationPoint(2F, 23F, -2F);
		leftleg.setTextureSize(64, 32);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 17F, 0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		ear11 = new ModelRenderer(this, 38, 17);
		ear11.addBox(0F, 0F, 0F, 1, 3, 2);
		ear11.setRotationPoint(4F, -6F, -2F);//11
		ear11.setTextureSize(64, 32);
		ear11.mirror = true;
		setRotation(ear11, 0F, 0F, 0F);
		ear12 = new ModelRenderer(this, 39, 16);
		ear12.addBox(0F, 0F, 0F, 1, 3, 2);
		ear12.setRotationPoint(4F, -7F, -1F);
		ear12.setTextureSize(64, 32);
		ear12.mirror = true;
		setRotation(ear12, 0F, 0F, 0F);
		ear21 = new ModelRenderer(this, 42, 17);
		ear21.addBox(0F, 0F, 0F, 1, 3, 2);
		ear21.setRotationPoint(-5F, -6F, -2F);
		ear21.setTextureSize(64, 32);
		ear21.mirror = true;
		setRotation(ear21, 0F, 0F, 0F);
		ear22 = new ModelRenderer(this, 41, 16);
		ear22.addBox(0F, 0F, 0F, 1, 3, 2);
		ear22.setRotationPoint(-5F, -7F, -1F);
		ear22.setTextureSize(64, 32);
		ear22.mirror = true;
		setRotation(ear22, 0F, 0F, 0F);
		stick = new ModelRenderer(this, 30, 18);
		stick.addBox(0F, 0F, 0F, 2, 2, 2);
		stick.setRotationPoint(-1F, -10F, -1F);
		stick.setTextureSize(64, 32);
		stick.mirror = true;
		setRotation(stick, 0F, 0F, 0F);
		this.head.addChild(stick);
		this.head.addChild(ear11);
		this.head.addChild(ear12);
		this.head.addChild(ear21);
		this.head.addChild(ear22);
	}

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
    	super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		body.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
		head.render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    	EntityTiddlytubby entity = (EntityTiddlytubby) entityIn;
		if(entity.isMoving) {
			this.body.rotateAngleX = (float) Math.toRadians(90f);
			this.rightleg.rotateAngleX = (float) Math.toRadians(90f);
			this.leftleg.rotateAngleX = (float) Math.toRadians(90f);
			this.body.setRotationPoint(0F, 19F, 0F);
			this.head.setRotationPoint(0F, 19F, 0F);
			this.rightarm.setRotationPoint(-3F, 20F, 0F);
			this.leftarm.setRotationPoint(3F, 20F, 0F);
			this.rightleg.setRotationPoint(-2F, 21F, 6F);
			this.leftleg.setRotationPoint(2F, 21F, 6F);
			
			this.rightleg.rotateAngleX = (float) (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount + Math.toRadians(90f));
			this.leftleg.rotateAngleX = (float) (MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount + Math.toRadians(90f));
			this.rightleg.rotateAngleZ = 0.0F;
			this.leftleg.rotateAngleZ = 0.0F;
		}
		else {
			this.body.rotateAngleX = 0f;
			this.rightleg.rotateAngleX = 0f;
			this.leftleg.rotateAngleX = 0f;
			this.body.setRotationPoint(0F, 17F, 0F);
			this.head.setRotationPoint(0F, 17F, 0F);
			this.rightarm.setRotationPoint(-3F, 18F, 0F);
			this.leftarm.setRotationPoint(3F, 18F, 0F);
			this.rightleg.setRotationPoint(-2F, 23F, -2F);
			this.leftleg.setRotationPoint(2F, 23F, -2F);
		}
    	
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
		this.rightarm.rotateAngleZ = 0.0F;
		this.leftarm.rotateAngleZ = 0.0F;
		this.rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		this.rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		
		this.head.rotateAngleX = headPitch / (180F / (float) Math.PI);
		this.head.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);
	}
}
