package teletubbies.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelNooNoo extends ModelBase {
	
	ModelRenderer foot;
	ModelRenderer foot2;
	ModelRenderer body1;
	ModelRenderer body2;
	ModelRenderer back1;
	ModelRenderer back2;
	ModelRenderer brushstick;
	ModelRenderer brush;
	ModelRenderer Piece1;
	ModelRenderer proboscis1;
	ModelRenderer proboscis2;
	ModelRenderer proboscis3;
	ModelRenderer Piece2;
	ModelRenderer eye11;
	ModelRenderer eye12;
	ModelRenderer eye21;
	ModelRenderer eye22;

	public ModelNooNoo() {
		textureWidth = 256;
		textureHeight = 128;
		setTextureOffset("Piece1.probosics", 0, 0);
		setTextureOffset("Piece2.head", 0, 0);

		foot = new ModelRenderer(this, 0, 0);
		foot.addBox(0F, 0F, 0F, 11, 2, 22);
		foot.setRotationPoint(-6F, 22F, -11F);
		foot.setTextureSize(256, 128);
		foot.mirror = true;
		setRotation(foot, 0F, 0F, 0F);
		foot2 = new ModelRenderer(this, 66, 0);
		foot2.addBox(0F, 0F, 0F, 9, 1, 20);
		foot2.setRotationPoint(-5F, 21F, -10F);
		foot2.setTextureSize(256, 128);
		foot2.mirror = true;
		setRotation(foot2, 0F, 0F, 0F);
		body1 = new ModelRenderer(this, 124, 0);
		body1.addBox(0F, 0F, 0F, 11, 11, 22);
		body1.setRotationPoint(-6F, 10F, -11F);
		body1.setTextureSize(256, 128);
		body1.mirror = true;
		setRotation(body1, 0F, 0F, 0F);
		body2 = new ModelRenderer(this, 124, 33);
		body2.addBox(0F, 0F, 0F, 13, 9, 22);
		body2.setRotationPoint(-7F, 11F, -11F);
		body2.setTextureSize(256, 128);
		body2.mirror = true;
		setRotation(body2, 0F, 0F, 0F);
		back1 = new ModelRenderer(this, 0, 24);
		back1.addBox(0F, 0F, 0F, 7, 7, 2);
		back1.setRotationPoint(-4F, 13F, 11F);
		back1.setTextureSize(256, 128);
		back1.mirror = true;
		setRotation(back1, 0F, 0F, 0F);
		back2 = new ModelRenderer(this, 0, 33);
		back2.addBox(0F, 0F, 0F, 3, 3, 2);
		back2.setRotationPoint(-2F, 15F, 13F);
		back2.setTextureSize(256, 128);
		back2.mirror = true;
		setRotation(back2, 0F, 0F, 0F);
		brushstick = new ModelRenderer(this, 23, 28);
		brushstick.addBox(0F, 0F, 0F, 1, 2, 1);
		brushstick.setRotationPoint(-1F, 8F, -7F);
		brushstick.setTextureSize(256, 128);
		brushstick.mirror = true;
		setRotation(brushstick, 0F, 0F, 0F);
		brush = new ModelRenderer(this, 23, 24);
		brush.addBox(0F, 0F, 0F, 3, 1, 3);
		brush.setRotationPoint(-2F, 7F, -8F);
		brush.setTextureSize(256, 128);
		brush.mirror = true;
		setRotation(brush, 0F, 0F, 0F);
		Piece1 = new ModelRenderer(this, "Piece1");
		Piece1.setRotationPoint(0F, 1F, 0F);
		setRotation(Piece1, 0F, 0F, 0F);
		Piece1.mirror = true;
		proboscis1 = new ModelRenderer(this, 40, 24);
		proboscis1.addBox(6F, -8F, 1F, 3, 3, 9);
		proboscis1.setRotationPoint(-8F, 22F, -20F);
		proboscis1.setTextureSize(256, 128);
		proboscis1.mirror = true;
		setRotation(proboscis1, 0F, 0F, 0F);
		proboscis2 = new ModelRenderer(this, 40, 36);
		proboscis2.addBox(6F, -5F, 1F, 3, 5, 3);
		proboscis2.setRotationPoint(-8F, 22F, -20F);
		proboscis2.setTextureSize(256, 128);
		proboscis2.mirror = true;
		setRotation(proboscis2, 0F, 0F, 0F);
		proboscis3 = new ModelRenderer(this, 40, 44);
		proboscis3.addBox(5F, 0F, 0F, 5, 1, 5);
		proboscis3.setRotationPoint(-8F, 22F, -20F);
		proboscis3.setTextureSize(256, 128);
		proboscis3.mirror = true;
		setRotation(proboscis3, 0F, 0F, 0F);
		Piece2 = new ModelRenderer(this, "Piece2");
		Piece2.setRotationPoint(0F, 0F, 0F);
		setRotation(Piece2, 0F, 0F, 0F);
		Piece2.mirror = true;
		eye11 = new ModelRenderer(this, 71, 21);
		eye11.addBox(0F, 0F, 0F, 3, 1, 4);
		eye11.setRotationPoint(-4F, 11F, -14F);
		eye11.setTextureSize(256, 128);
		eye11.mirror = true;
		setRotation(eye11, 0F, 0F, 0F);
		eye12 = new ModelRenderer(this, 71, 26);
		eye12.addBox(0F, 0F, 0F, 1, 3, 4);
		eye12.setRotationPoint(-3F, 10F, -14F);
		eye12.setTextureSize(256, 128);
		eye12.mirror = true;
		setRotation(eye12, 0F, 0F, 0F);
		eye21 = new ModelRenderer(this, 87, 26);
		eye21.addBox(0F, 0F, 0F, 1, 3, 4);
		eye21.setRotationPoint(1F, 10F, -14F);
		eye21.setTextureSize(256, 128);
		eye21.mirror = true;
		setRotation(eye21, 0F, 0F, 0F);
		eye22 = new ModelRenderer(this, 87, 21);
		eye22.addBox(0F, 0F, 0F, 3, 1, 4);
		eye22.setRotationPoint(0F, 11F, -14F);
		eye22.setTextureSize(256, 128);
		eye22.mirror = true;
		setRotation(eye22, 0F, 0F, 0F);
		Piece1.addChild(proboscis1);
		Piece1.addChild(proboscis2);
		Piece1.addChild(proboscis3);
		Piece2.addChild(eye11);
		Piece2.addChild(eye12);
		Piece2.addChild(eye21);
		Piece2.addChild(eye22);
	}

	@Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		foot.render(scale);
		foot2.render(scale);
		body1.render(scale);
		body2.render(scale);
		back1.render(scale);
		back2.render(scale);
		brushstick.render(scale);
		brush.render(scale);
		Piece1.render(scale);
		Piece2.render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

		this.Piece1.rotateAngleY = netHeadYaw / (690F / (float) Math.PI) + MathHelper.cos(limbSwing * 1.0F) * 0.2F * limbSwingAmount;

		this.Piece2.rotateAngleX = headPitch / (650F / (float) Math.PI);
		this.Piece2.rotateAngleY = netHeadYaw / (720F / (float) Math.PI);
		this.Piece2.rotateAngleZ = netHeadYaw / (1000F / (float) Math.PI);
	}
}