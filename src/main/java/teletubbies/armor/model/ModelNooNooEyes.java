package teletubbies.armor.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelNooNooEyes extends ModelBiped {
	ModelRenderer eye11;
	ModelRenderer eye12;
	ModelRenderer eye21;
	ModelRenderer eye22;
	ModelRenderer Piece1;

	public ModelNooNooEyes(float f) {
		super(f);

		textureWidth = 64;
		textureHeight = 64;
		setTextureOffset("Piece1.rightEye", 0, 0);
		setTextureOffset("Piece1.leftEye", 0, 0);

		Piece1 = new ModelRenderer(this, "Piece1");
		Piece1.setRotationPoint(0F, 0F, 0F);
		setRotation(Piece1, 0F, 0F, 0F);
		Piece1.mirror = true;
		eye11 = new ModelRenderer(this, 0, 33);
		eye11.addBox(-2F, -5F, -7F, 1, 3, 3);
		eye11.setRotationPoint(0F, 0F, 0F);
		eye11.setTextureSize(64, 64);
		eye11.mirror = true;
		setRotation(eye11, 0F, 0F, 0F);
		eye12 = new ModelRenderer(this, 0, 40);
		eye12.addBox(-3F, -4F, -7F, 3, 1, 3);
		eye12.setRotationPoint(0F, 0F, 0F);
		eye12.setTextureSize(64, 64);
		eye12.mirror = true;
		setRotation(eye12, 0F, 0F, 0F);
		eye21 = new ModelRenderer(this, 13, 33);
		eye21.addBox(1F, -6F, -7F, 1, 3, 3);
		eye21.setRotationPoint(0F, 0F, 0F);
		eye21.setTextureSize(64, 64);
		eye21.mirror = true;
		setRotation(eye21, 0F, 0F, 0F);
		eye22 = new ModelRenderer(this, 13, 40);
		eye22.addBox(0F, -5F, -7F, 3, 1, 3);
		eye22.setRotationPoint(0F, 0F, 0F);
		eye22.setTextureSize(64, 64);
		eye22.mirror = true;
		setRotation(eye22, 0F, 0F, 0F);
		
		this.bipedHead.addChild(eye11);
		this.bipedHead.addChild(eye12);
		this.bipedHead.addChild(eye21);
		this.bipedHead.addChild(eye22);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
}