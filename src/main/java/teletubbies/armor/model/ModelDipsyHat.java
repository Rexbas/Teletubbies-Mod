package teletubbies.armor.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDipsyHat extends ModelBiped {
	ModelRenderer Piece1;
	ModelRenderer hat1;
	ModelRenderer hat2;
	ModelRenderer hat3;
	ModelRenderer hat4;
	ModelRenderer hat5;

	public ModelDipsyHat(float f) {
		super(f);

		textureWidth = 64;
		textureHeight = 64;
		setTextureOffset("Piece1.hat", 0, 0);

		Piece1 = new ModelRenderer(this, "Piece1");
		Piece1.setRotationPoint(0F, 0F, 0F);
		setRotation(Piece1, 0F, 0F, 0F);
		Piece1.mirror = true;
		hat1 = new ModelRenderer(this, 0, 33);
		hat1.addBox(-5F, -9F, -5F, 10, 2, 10);
		hat1.setRotationPoint(0F, 0F, 0F);
		hat1.setTextureSize(64, 64);
		hat1.mirror = true;
		setRotation(hat1, 0F, 0F, 0F);
		hat2 = new ModelRenderer(this, 0, 45);
		hat2.addBox(-3F, -14F, -3.5F, 6, 5, 1);
		hat2.setRotationPoint(0F, 0F, 0F);
		hat2.setTextureSize(64, 64);
		hat2.mirror = true;
		setRotation(hat2, 0.0523599F, 0F, 0F);
		hat3 = new ModelRenderer(this, 14, 45);
		hat3.addBox(-3F, -14F, 2.5F, 6, 5, 1);
		hat3.setRotationPoint(0F, 0F, 0F);
		hat3.setTextureSize(64, 64);
		hat3.mirror = true;
		setRotation(hat3, -0.0523599F, 0F, 0F);
		hat4 = new ModelRenderer(this, 0, 51);
		hat4.addBox(2.5F, -14F, -3F, 1, 5, 6);
		hat4.setRotationPoint(0F, 0F, 0F);
		hat4.setTextureSize(64, 64);
		hat4.mirror = true;
		setRotation(hat4, 0F, 0F, 0.0523599F);
		hat5 = new ModelRenderer(this, 14, 51);
		hat5.addBox(-3.5F, -14F, -3F, 1, 5, 6);
		hat5.setRotationPoint(0F, 0F, 0F);
		hat5.setTextureSize(64, 64);
		hat5.mirror = true;
		setRotation(hat5, 0F, 0F, -0.0523599F);

		this.bipedHead.addChild(hat1);
		this.bipedHead.addChild(hat2);
		this.bipedHead.addChild(hat3);
		this.bipedHead.addChild(hat4);
		this.bipedHead.addChild(hat5);

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