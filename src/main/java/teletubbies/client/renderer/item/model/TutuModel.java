package teletubbies.client.renderer.item.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TutuModel extends BipedModel<LivingEntity> {
	
	public static TutuModel model = new TutuModel();
	
	private final ModelRenderer tutu;
	private final ModelRenderer segment1;
	private final ModelRenderer plane0;
	private final ModelRenderer plane1;
	private final ModelRenderer segment2;
	private final ModelRenderer plane2;
	private final ModelRenderer plane3;
	private final ModelRenderer segment3;
	private final ModelRenderer plane4;
	private final ModelRenderer plane5;
	private final ModelRenderer segment4;
	private final ModelRenderer plane6;
	private final ModelRenderer plane7;
	private final ModelRenderer segment5;
	private final ModelRenderer plane8;
	private final ModelRenderer plane9;
	private final ModelRenderer segment6;
	private final ModelRenderer plane10;
	private final ModelRenderer plane11;
	private final ModelRenderer segment7;
	private final ModelRenderer plane12;
	private final ModelRenderer plane13;
	private final ModelRenderer segment8;
	private final ModelRenderer plane14;
	private final ModelRenderer plane15;

	public TutuModel() {
		super(1.0F);
		textureWidth = 32;
		textureHeight = 32;

		tutu = new ModelRenderer(this);
		tutu.setRotationPoint(0.0F, 9.0F, 0.0F);

		segment1 = new ModelRenderer(this);
		segment1.setRotationPoint(0.0F, -2.0F, 0.0F);
		setRotationAngle(segment1, -0.3491F, 0.0F, 0.0F);
		tutu.addChild(segment1);

		plane0 = new ModelRenderer(this);
		plane0.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane0, 0.0F, -0.7854F, 0.0F);
		segment1.addChild(plane0);
		plane0.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 0, 0);

		plane1 = new ModelRenderer(this);
		plane1.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane1, 0.0F, 0.7854F, 0.0F);
		segment1.addChild(plane1);
		plane1.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 0, 0);

		segment2 = new ModelRenderer(this);
		segment2.setRotationPoint(2.0F, -2.0F, 0.0F);
		setRotationAngle(segment2, -0.3491F, -0.4363F, 0.0F);
		tutu.addChild(segment2);

		plane2 = new ModelRenderer(this);
		plane2.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane2, 0.0F, -0.7854F, 0.0F);
		segment2.addChild(plane2);
		plane2.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 0, 10);

		plane3 = new ModelRenderer(this);
		plane3.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane3, 0.0F, 0.7854F, 0.0F);
		segment2.addChild(plane3);
		plane3.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 0, 10);

		segment3 = new ModelRenderer(this);
		segment3.setRotationPoint(-2.0F, -2.0F, 0.0F);
		setRotationAngle(segment3, -0.3491F, 0.4363F, 0.0F);
		tutu.addChild(segment3);

		plane4 = new ModelRenderer(this);
		plane4.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane4, 0.0F, -0.7854F, 0.0F);
		segment3.addChild(plane4);
		plane4.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 8, 0);

		plane5 = new ModelRenderer(this);
		plane5.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane5, 0.0F, 0.7854F, 0.0F);
		segment3.addChild(plane5);
		plane5.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 8, 0);

		segment4 = new ModelRenderer(this);
		segment4.setRotationPoint(0.0F, -2.0F, 0.0F);
		setRotationAngle(segment4, -0.3491F, 3.1416F, 0.0F);
		tutu.addChild(segment4);

		plane6 = new ModelRenderer(this);
		plane6.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane6, 0.0F, -0.7854F, 0.0F);
		segment4.addChild(plane6);
		plane6.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 8, 10);

		plane7 = new ModelRenderer(this);
		plane7.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane7, 0.0F, 0.7854F, 0.0F);
		segment4.addChild(plane7);
		plane7.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 8, 10);

		segment5 = new ModelRenderer(this);
		segment5.setRotationPoint(-2.0F, -2.0F, 0.0F);
		setRotationAngle(segment5, -0.3491F, 2.7053F, 0.0F);
		tutu.addChild(segment5);

		plane8 = new ModelRenderer(this);
		plane8.setRotationPoint(-2.0F, 17.0F, -2.0F);
		setRotationAngle(plane8, 0.0F, -0.7854F, 0.0F);
		segment5.addChild(plane8);
		plane8.addBox(null, 0.6561F, -14.0603F, -2.1724F, 4, 10, 0, 0.0F, 16, 0);

		plane9 = new ModelRenderer(this);
		plane9.setRotationPoint(-2.0F, 17.0F, -2.0F);
		setRotationAngle(plane9, 0.0F, 0.7854F, 0.0F);
		segment5.addChild(plane9);
		plane9.addBox(null, -1.8276F, -14.0603F, 0.6561F, 4, 10, 0, 0.0F, 16, 0);

		segment6 = new ModelRenderer(this);
		segment6.setRotationPoint(2.0F, -2.0F, 0.0F);
		setRotationAngle(segment6, -0.3491F, -2.7053F, 0.0F);
		tutu.addChild(segment6);

		plane10 = new ModelRenderer(this);
		plane10.setRotationPoint(2.0F, 17.0F, -2.0F);
		setRotationAngle(plane10, 0.0F, -0.7854F, 0.0F);
		segment6.addChild(plane10);
		plane10.addBox(null, -2.1724F, -14.0603F, 0.6561F, 4, 10, 0, 0.0F, 16, 10);

		plane11 = new ModelRenderer(this);
		plane11.setRotationPoint(2.0F, 17.0F, -2.0F);
		setRotationAngle(plane11, 0.0F, 0.7854F, 0.0F);
		segment6.addChild(plane11);
		plane11.addBox(null, -4.6561F, -14.0603F, -2.1724F, 4, 10, 0, 0.0F, 16, 10);

		segment7 = new ModelRenderer(this);
		segment7.setRotationPoint(2.0F, -2.0F, 0.0F);
		setRotationAngle(segment7, 0.0F, -1.5708F, -0.3491F);
		tutu.addChild(segment7);

		plane12 = new ModelRenderer(this);
		plane12.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane12, 0.0F, -0.7854F, 0.0F);
		segment7.addChild(plane12);
		plane12.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 24, 0);

		plane13 = new ModelRenderer(this);
		plane13.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane13, 0.0F, 0.7854F, 0.0F);
		segment7.addChild(plane13);
		plane13.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 24, 0);

		segment8 = new ModelRenderer(this);
		segment8.setRotationPoint(-2.0F, -2.0F, 0.0F);
		setRotationAngle(segment8, 0.0F, 1.5708F, 0.3491F);
		tutu.addChild(segment8);

		plane14 = new ModelRenderer(this);
		plane14.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane14, 0.0F, -0.7854F, 0.0F);
		segment8.addChild(plane14);
		plane14.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 24, 10);

		plane15 = new ModelRenderer(this);
		plane15.setRotationPoint(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane15, 0.0F, 0.7854F, 0.0F);
		segment8.addChild(plane15);
		plane15.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 24, 10);
	}
	
	@Override
	public void setRotationAngles(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.getPose() == Pose.CROUCHING) {
			tutu.rotationPointY = 8.0F;
			tutu.rotationPointZ = 2.0F;
			tutu.rotateAngleX = (float) (Math.PI * 0.16667F);
		} else {
			tutu.rotationPointY = 9.0F;
			tutu.rotationPointZ = 0;
			tutu.rotateAngleX = 0;
		}
				
		final float f1 = 0.065F;
		final float f2 = 0.125F;
		segment1.rotateAngleX = -0.3491F + f1 * MathHelper.cos(f2 * ageInTicks);
		segment2.rotateAngleX = -0.3491F + f1 * MathHelper.cos(f2 * ageInTicks);
		segment3.rotateAngleX = -0.3491F + f1 * MathHelper.cos(f2 * ageInTicks);
		segment4.rotateAngleX = -0.3491F + f1 * MathHelper.cos(f2 * ageInTicks);
		segment5.rotateAngleX = -0.3491F + f1 * MathHelper.cos(f2 * ageInTicks);
		segment6.rotateAngleX = -0.3491F + f1 * MathHelper.cos(f2 * ageInTicks);

		segment7.rotateAngleZ = -0.3491F + f1 * MathHelper.cos(f2 * ageInTicks);
		segment8.rotateAngleZ = 0.3491F - f1 * MathHelper.cos(f2 * ageInTicks);
	}

	@Override
	public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		tutu.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}