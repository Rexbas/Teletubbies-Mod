package teletubbies.entity.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.util.math.MathHelper;

public class ModelPo extends ModelBiped {

	ModelRenderer stick1;
	ModelRenderer stick2;
	ModelRenderer stick3;
	ModelRenderer stick4;
	ModelRenderer ear11;
	ModelRenderer ear12;
	ModelRenderer ear21;
	ModelRenderer ear22;

	private boolean isZombie;
	private float scale;

	public ModelPo(boolean isZombie, float scale) {
		this.isZombie = isZombie;
		this.scale = scale;

		ear11 = new ModelRenderer(this, 54, 27);
  		ear11.addBox(0F, 0F, 0F, 1, 3, 2);
  		ear11.setRotationPoint(4F, -6F, -2F);
  		ear11.setTextureSize(64, 32);
  		ear11.mirror = true;
  		setRotation(ear11, 0F, 0F, 0F);
  		ear12 = new ModelRenderer(this, 55, 26);
  		ear12.addBox(0F, 0F, 0F, 1, 3, 2);
  		ear12.setRotationPoint(4F, -7F, -1F);
  		ear12.setTextureSize(64, 32);
  		ear12.mirror = true;
  		setRotation(ear12, 0F, 0F, 0F);
  		ear21 = new ModelRenderer(this, 58, 27);
  		ear21.addBox(0F, 0F, 0F, 1, 3, 2);
  		ear21.setRotationPoint(-5F, -6F, -2F);
  		ear21.setTextureSize(64, 32);
  		ear21.mirror = true;
  		setRotation(ear21, 0F, 0F, 0F);
  		ear22 = new ModelRenderer(this, 57, 26);
  		ear22.addBox(0F, 0F, 0F, 1, 3, 2);
  		ear22.setRotationPoint(-5F, -7F, -1F);
  		ear22.setTextureSize(64, 32);
  		ear22.mirror = true;
  		setRotation(ear22, 0F, 0F, 0F);
		stick4 = new ModelRenderer(this, 8, 0);
		stick4.addBox(0F, 0F, 0F, 1, 2, 2);
		stick4.setRotationPoint(-2F, -12F, -1F);
		stick4.setTextureSize(64, 32);
		stick4.mirror = true;
		setRotation(stick4, 0F, 0F, 0F);
		stick3 = new ModelRenderer(this, 8, 0);
		stick3.addBox(0F, 0F, 0F, 2, 1, 2);
		stick3.setRotationPoint(-1F, -13F, -1F);
		stick3.setTextureSize(64, 32);
		stick3.mirror = true;
		setRotation(stick3, 0F, 0F, 0F);
		stick2 = new ModelRenderer(this, 8, 0);
		stick2.addBox(0F, 0F, 0F, 1, 2, 2);
		stick2.setRotationPoint(1F, -12F, -1F);
		stick2.setTextureSize(64, 32);
		stick2.mirror = true;
		setRotation(stick2, 0F, 0F, 0F);
		stick1 = new ModelRenderer(this, 8, 0);
		stick1.addBox(0F, 0F, 0F, 2, 2, 2);
		stick1.setRotationPoint(-1F, -10F, -1F);
		stick1.setTextureSize(64, 32);
		stick1.mirror = true;
		setRotation(stick1, 0F, 0F, 0F);
		this.bipedHead.addChild(stick1);
		this.bipedHead.addChild(stick2);
		this.bipedHead.addChild(stick3);
		this.bipedHead.addChild(stick4);
		this.bipedHead.addChild(ear11);
		this.bipedHead.addChild(ear12);
		this.bipedHead.addChild(ear21);
		this.bipedHead.addChild(ear22);
	}

	@Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, this.scale, entityIn);
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0, 1.5 - (this.scale / 0.0625) * 1.5, 0.0);
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, this.scale);
		GlStateManager.popMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		if(this.isZombie) {
	        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	        boolean flag = entityIn instanceof EntityZombie && ((EntityZombie)entityIn).isArmsRaised();
	        float f = MathHelper.sin(this.swingProgress * (float)Math.PI);
	        float f1 = MathHelper.sin((1.0F - (1.0F - this.swingProgress) * (1.0F - this.swingProgress)) * (float)Math.PI);
	        this.bipedRightArm.rotateAngleZ = 0.0F;
	        this.bipedLeftArm.rotateAngleZ = 0.0F;
	        this.bipedRightArm.rotateAngleY = -(0.1F - f * 0.6F);
	        this.bipedLeftArm.rotateAngleY = 0.1F - f * 0.6F;
	        float f2 = -(float)Math.PI / (flag ? 1.5F : 2.25F);
	        this.bipedRightArm.rotateAngleX = f2;
	        this.bipedLeftArm.rotateAngleX = f2;
	        this.bipedRightArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
	        this.bipedLeftArm.rotateAngleX += f * 1.2F - f1 * 0.4F;
	        this.bipedRightArm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
	        this.bipedRightArm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		}
		else {
	        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		}
	}
}