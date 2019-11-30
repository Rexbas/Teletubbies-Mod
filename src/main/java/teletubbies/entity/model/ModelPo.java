package teletubbies.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModelPo extends ModelBase {
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer Piece1;
	ModelRenderer stick1;
	ModelRenderer stick2;
	ModelRenderer stick3;
	ModelRenderer stick4;
	ModelRenderer ear11;
	ModelRenderer ear12;
	ModelRenderer ear21;
	ModelRenderer ear22;
	ModelRenderer head;

	boolean isZombie;

	public ModelPo(boolean isZombie) {
		this.isZombie = isZombie;

		textureWidth = 128;
		textureHeight = 64;
		setTextureOffset("Piece1.head", 0, 0);

	      body = new ModelRenderer(this, 32, 16);
	      body.addBox(-4F, 0F, -2F, 8, 9, 4);
	      body.setRotationPoint(0F, 6F, 0F);
	      body.setTextureSize(64, 32);
	      body.mirror = true;
	      setRotation(body, 0F, 0F, 0F);
	      rightarm = new ModelRenderer(this, 56, 16);
	      rightarm.addBox(-3F, -2F, -2F, 4, 9, 4);
	      rightarm.setRotationPoint(-5F, 8F, 0F);
	      rightarm.setTextureSize(64, 32);
	      rightarm.mirror = true;
	      setRotation(rightarm, 0F, 0F, 0F);
	      leftarm = new ModelRenderer(this, 16, 16);
	      leftarm.addBox(-1F, -2F, -2F, 4, 9, 4);
	      leftarm.setRotationPoint(5F, 8F, 0F);
	      leftarm.setTextureSize(64, 32);
	      leftarm.mirror = true;
	      setRotation(leftarm, 0F, 0F, 0F);
	      rightleg = new ModelRenderer(this, 72, 16);
	      rightleg.addBox(-2F, 0F, -2F, 4, 9, 4);
	      rightleg.setRotationPoint(-2F, 15F, 0F);
	      rightleg.setTextureSize(64, 32);
	      rightleg.mirror = true;
	      setRotation(rightleg, 0F, 0F, 0F);
	      leftleg = new ModelRenderer(this, 0, 16);
	      leftleg.addBox(-2F, 0F, -2F, 4, 9, 4);
	      leftleg.setRotationPoint(2F, 15F, 0F);
	      leftleg.setTextureSize(64, 32);
	      leftleg.mirror = true;
	      setRotation(leftleg, 0F, 0F, 0F);
	    Piece1 = new ModelRenderer(this, "Piece1");
	    Piece1.setRotationPoint(0F, 0F, 0F);
	    setRotation(Piece1, 0F, 0F, 0F);
	    Piece1.mirror = true;
	      ear11 = new ModelRenderer(this, 0, 33);
	      ear11.addBox(0F, 0F, 0F, 1, 3, 2);
	      ear11.setRotationPoint(4F, 1F, -2F);
	      ear11.setTextureSize(64, 32);
	      ear11.mirror = true;
	      setRotation(ear11, 0F, 0F, 0F);
	      ear12 = new ModelRenderer(this, 0, 38);
	      ear12.addBox(0F, 0F, 0F, 1, 3, 2);
	      ear12.setRotationPoint(4F, 0F, -1F);
	      ear12.setTextureSize(64, 32);
	      ear12.mirror = true;
	      setRotation(ear12, 0F, 0F, 0F);
	      ear21 = new ModelRenderer(this, 7, 33);
	      ear21.addBox(0F, 0F, 0F, 1, 3, 2);
	      ear21.setRotationPoint(-5F, 1F, -2F);
	      ear21.setTextureSize(64, 32);
	      ear21.mirror = true;
	      setRotation(ear21, 0F, 0F, 0F);
	      ear22 = new ModelRenderer(this, 7, 38);
	      ear22.addBox(0F, 0F, 0F, 1, 3, 2);
	      ear22.setRotationPoint(-5F, 0F, -1F);
	      ear22.setTextureSize(64, 32);
	      ear22.mirror = true;
	      setRotation(ear22, 0F, 0F, 0F);
	      head = new ModelRenderer(this, 0, 0);
	      head.addBox(-4F, -8F, -4F, 8, 8, 8);
	      head.setRotationPoint(0F, 6F, 0F);
	      head.setTextureSize(64, 32);
	      head.mirror = true;
	      setRotation(head, 0F, 0F, 0F);
	      stick4 = new ModelRenderer(this, 22, 29);
	      stick4.addBox(0F, 0F, 0F, 1, 2, 2);
	      stick4.setRotationPoint(-2F, -6F, -1F);
	      stick4.setTextureSize(64, 32);
	      stick4.mirror = true;
	      setRotation(stick4, 0F, 0F, 0F);
	      stick3 = new ModelRenderer(this, 14, 29);
	      stick3.addBox(0F, 0F, 0F, 2, 1, 2);
	      stick3.setRotationPoint(-1F, -7F, -1F);
	      stick3.setTextureSize(64, 32);
	      stick3.mirror = true;
	      setRotation(stick3, 0F, 0F, 0F);
	      stick2 = new ModelRenderer(this, 8, 29);
	      stick2.addBox(0F, 0F, 0F, 1, 2, 2);
	      stick2.setRotationPoint(1F, -6F, -1F);
	      stick2.setTextureSize(64, 32);
	      stick2.mirror = true;
	      setRotation(stick2, 0F, 0F, 0F);
	      stick1 = new ModelRenderer(this, 0, 29);
	      stick1.addBox(0F, 0F, 0F, 2, 2, 2);
	      stick1.setRotationPoint(-1F, -4F, -1F);
	      stick1.setTextureSize(64, 32);
	      stick1.mirror = true;
	      setRotation(stick1, 0F, 0F, 0F);
		Piece1.addChild(stick1);
		Piece1.addChild(stick2);
		Piece1.addChild(stick3);
		Piece1.addChild(stick4);
		Piece1.addChild(ear11);
		Piece1.addChild(ear12);
		Piece1.addChild(ear21);
		Piece1.addChild(ear22);
		Piece1.addChild(head);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		Piece1.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);

		if (this.isZombie == true) {
			float f6 = MathHelper.sin(this.swingProgress * (float) Math.PI);
			float f7 = MathHelper.sin((1.0F - (1.0F - this.swingProgress)
					* (1.0F - this.swingProgress))
					* (float) Math.PI);
			this.rightarm.rotateAngleZ = 0.0F;
			this.leftarm.rotateAngleZ = 0.0F;
			this.rightarm.rotateAngleY = -(0.1F - f6 * 0.6F);
			this.leftarm.rotateAngleY = 0.1F - f6 * 0.6F;
			this.rightarm.rotateAngleX = -((float) Math.PI / 2F);
			this.leftarm.rotateAngleX = -((float) Math.PI / 2F);
			this.rightarm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			this.leftarm.rotateAngleX -= f6 * 1.2F - f7 * 0.4F;
			this.rightarm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			this.leftarm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			this.rightarm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
			this.leftarm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
			this.Piece1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Piece1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F
					* f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F
					+ (float) Math.PI)
					* 1.4F * f1;
		} else if (this.isZombie == false) {
			this.Piece1.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.Piece1.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F
					+ (float) Math.PI)
					* 2.0F * f1 * 0.5F;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1
					* 0.5F;
			this.rightarm.rotateAngleZ = 0.0F;
			this.leftarm.rotateAngleZ = 0.0F;
			this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F
					* f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F
					+ (float) Math.PI)
					* 1.4F * f1;
			this.rightleg.rotateAngleY = 0.0F;
			this.leftleg.rotateAngleY = 0.0F;
			this.rightarm.rotateAngleZ += MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			this.leftarm.rotateAngleZ -= MathHelper.cos(f2 * 0.09F) * 0.05F + 0.05F;
			this.rightarm.rotateAngleX += MathHelper.sin(f2 * 0.067F) * 0.05F;
			this.leftarm.rotateAngleX -= MathHelper.sin(f2 * 0.067F) * 0.05F;
		}
	}
}