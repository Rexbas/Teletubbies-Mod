package teletubbies.vehicle;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPoScooter extends ModelBase {

	ModelRenderer frontwheel;
	ModelRenderer frontwheelstick;
	ModelRenderer steer;
	ModelRenderer boardstick0;
	ModelRenderer boardstick1;
	ModelRenderer board;
	ModelRenderer backwheel0;
	ModelRenderer backwheel1;

	public ModelPoScooter() {
		this.textureHeight = 64;
		this.textureWidth = 64;
		frontwheel = new ModelRenderer(this, 40, 0);
		frontwheel.addBox(0F, 0F, 0F, 3, 5, 5);
		frontwheel.setRotationPoint(-1F, 19F, -14F);
		frontwheel.setTextureSize(64, 64);
		frontwheel.mirror = true;
		setRotation(frontwheel, 0F, 0F, 0F);
		frontwheelstick = new ModelRenderer(this, 56, 0);
		frontwheelstick.addBox(0F, 0F, 0F, 1, 18, 1);
		frontwheelstick.setRotationPoint(0F, 1F, -10F);
		frontwheelstick.setTextureSize(64, 64);
		frontwheelstick.mirror = true;
		setRotation(frontwheelstick, 0F, 0F, 0F);
		steer = new ModelRenderer(this, 0, 16);
		steer.addBox(0F, 0F, 0F, 7, 1, 1);
		steer.setRotationPoint(-3F, 1, -10F);
		steer.setTextureSize(64, 64);
		steer.mirror = true;
		setRotation(steer, 0F, 0F, 0F);
		boardstick0 = new ModelRenderer(this, 0, 23);
		boardstick0.addBox(0F, 0F, 0F, 1, 1, 4);
		boardstick0.setRotationPoint(0F, 18F, -10F);
		boardstick0.setTextureSize(64, 64);
		boardstick0.mirror = true;
		setRotation(boardstick0, 0F, 0F, 0F);
		boardstick1 = new ModelRenderer(this, 0, 18);
		boardstick1.addBox(0F, 0F, 0F, 1, 2, 1);
		boardstick1.setRotationPoint(0F, 19F, -7F);
		boardstick1.setTextureSize(64, 64);
		boardstick1.mirror = true;
		setRotation(boardstick1, 0F, 0F, 0F);
		board = new ModelRenderer(this, 0, 0);
		board.addBox(0F, 0F, 0F, 5, 1, 15);
		board.setRotationPoint(-2F, 20F, -6F);
		board.setTextureSize(64, 64);
		board.mirror = true;
		setRotation(board, 0F, 0F, 0F);
		backwheel0 = new ModelRenderer(this, 40, 10);
		backwheel0.addBox(0F, 0F, 0F, 3, 5, 5);
		backwheel0.setRotationPoint(2F, 19F, 6F);
		backwheel0.setTextureSize(64, 64);
		backwheel0.mirror = true;
		setRotation(backwheel0, 0F, 0F, 0F);
		backwheel1 = new ModelRenderer(this, 40, 10);
		backwheel1.addBox(0F, 0F, 0F, 3, 5, 5);
		backwheel1.setRotationPoint(-4F, 19F, 6F);
		backwheel1.setTextureSize(64, 64);
		backwheel1.mirror = true;
		setRotation(backwheel1, 0F, 0F, 0F);
	}

	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		frontwheel.render(scale);
		frontwheelstick.render(scale);
		steer.render(scale);
		boardstick0.render(scale);
		boardstick1.render(scale);
		board.render(scale);
		backwheel0.render(scale);
		backwheel1.render(scale);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}
}
