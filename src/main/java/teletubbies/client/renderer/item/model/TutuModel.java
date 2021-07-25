package teletubbies.client.renderer.item.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TutuModel extends HumanoidModel<LivingEntity> {
	
	public static TutuModel model = new TutuModel();
	
	private final ModelPart tutu;
	private final ModelPart segment1;
	private final ModelPart plane0;
	private final ModelPart plane1;
	private final ModelPart segment2;
	private final ModelPart plane2;
	private final ModelPart plane3;
	private final ModelPart segment3;
	private final ModelPart plane4;
	private final ModelPart plane5;
	private final ModelPart segment4;
	private final ModelPart plane6;
	private final ModelPart plane7;
	private final ModelPart segment5;
	private final ModelPart plane8;
	private final ModelPart plane9;
	private final ModelPart segment6;
	private final ModelPart plane10;
	private final ModelPart plane11;
	private final ModelPart segment7;
	private final ModelPart plane12;
	private final ModelPart plane13;
	private final ModelPart segment8;
	private final ModelPart plane14;
	private final ModelPart plane15;

	public TutuModel() {
		super(1.0F);
		texWidth = 32;
		texHeight = 32;

		tutu = new ModelPart(this);
		tutu.setPos(0.0F, 9.0F, 0.0F);

		segment1 = new ModelPart(this);
		segment1.setPos(0.0F, -2.0F, 0.0F);
		setRotationAngle(segment1, -0.3491F, 0.0F, 0.0F);
		tutu.addChild(segment1);

		plane0 = new ModelPart(this);
		plane0.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane0, 0.0F, -0.7854F, 0.0F);
		segment1.addChild(plane0);
		plane0.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 0, 0);

		plane1 = new ModelPart(this);
		plane1.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane1, 0.0F, 0.7854F, 0.0F);
		segment1.addChild(plane1);
		plane1.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 0, 0);

		segment2 = new ModelPart(this);
		segment2.setPos(2.0F, -2.0F, 0.0F);
		setRotationAngle(segment2, -0.3491F, -0.4363F, 0.0F);
		tutu.addChild(segment2);

		plane2 = new ModelPart(this);
		plane2.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane2, 0.0F, -0.7854F, 0.0F);
		segment2.addChild(plane2);
		plane2.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 0, 10);

		plane3 = new ModelPart(this);
		plane3.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane3, 0.0F, 0.7854F, 0.0F);
		segment2.addChild(plane3);
		plane3.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 0, 10);

		segment3 = new ModelPart(this);
		segment3.setPos(-2.0F, -2.0F, 0.0F);
		setRotationAngle(segment3, -0.3491F, 0.4363F, 0.0F);
		tutu.addChild(segment3);

		plane4 = new ModelPart(this);
		plane4.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane4, 0.0F, -0.7854F, 0.0F);
		segment3.addChild(plane4);
		plane4.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 8, 0);

		plane5 = new ModelPart(this);
		plane5.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane5, 0.0F, 0.7854F, 0.0F);
		segment3.addChild(plane5);
		plane5.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 8, 0);

		segment4 = new ModelPart(this);
		segment4.setPos(0.0F, -2.0F, 0.0F);
		setRotationAngle(segment4, -0.3491F, 3.1416F, 0.0F);
		tutu.addChild(segment4);

		plane6 = new ModelPart(this);
		plane6.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane6, 0.0F, -0.7854F, 0.0F);
		segment4.addChild(plane6);
		plane6.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 8, 10);

		plane7 = new ModelPart(this);
		plane7.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane7, 0.0F, 0.7854F, 0.0F);
		segment4.addChild(plane7);
		plane7.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 8, 10);

		segment5 = new ModelPart(this);
		segment5.setPos(-2.0F, -2.0F, 0.0F);
		setRotationAngle(segment5, -0.3491F, 2.7053F, 0.0F);
		tutu.addChild(segment5);

		plane8 = new ModelPart(this);
		plane8.setPos(-2.0F, 17.0F, -2.0F);
		setRotationAngle(plane8, 0.0F, -0.7854F, 0.0F);
		segment5.addChild(plane8);
		plane8.addBox(null, 0.6561F, -14.0603F, -2.1724F, 4, 10, 0, 0.0F, 16, 0);

		plane9 = new ModelPart(this);
		plane9.setPos(-2.0F, 17.0F, -2.0F);
		setRotationAngle(plane9, 0.0F, 0.7854F, 0.0F);
		segment5.addChild(plane9);
		plane9.addBox(null, -1.8276F, -14.0603F, 0.6561F, 4, 10, 0, 0.0F, 16, 0);

		segment6 = new ModelPart(this);
		segment6.setPos(2.0F, -2.0F, 0.0F);
		setRotationAngle(segment6, -0.3491F, -2.7053F, 0.0F);
		tutu.addChild(segment6);

		plane10 = new ModelPart(this);
		plane10.setPos(2.0F, 17.0F, -2.0F);
		setRotationAngle(plane10, 0.0F, -0.7854F, 0.0F);
		segment6.addChild(plane10);
		plane10.addBox(null, -2.1724F, -14.0603F, 0.6561F, 4, 10, 0, 0.0F, 16, 10);

		plane11 = new ModelPart(this);
		plane11.setPos(2.0F, 17.0F, -2.0F);
		setRotationAngle(plane11, 0.0F, 0.7854F, 0.0F);
		segment6.addChild(plane11);
		plane11.addBox(null, -4.6561F, -14.0603F, -2.1724F, 4, 10, 0, 0.0F, 16, 10);

		segment7 = new ModelPart(this);
		segment7.setPos(2.0F, -2.0F, 0.0F);
		setRotationAngle(segment7, 0.0F, -1.5708F, -0.3491F);
		tutu.addChild(segment7);

		plane12 = new ModelPart(this);
		plane12.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane12, 0.0F, -0.7854F, 0.0F);
		segment7.addChild(plane12);
		plane12.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 24, 0);

		plane13 = new ModelPart(this);
		plane13.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane13, 0.0F, 0.7854F, 0.0F);
		segment7.addChild(plane13);
		plane13.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 24, 0);

		segment8 = new ModelPart(this);
		segment8.setPos(-2.0F, -2.0F, 0.0F);
		setRotationAngle(segment8, 0.0F, 1.5708F, 0.3491F);
		tutu.addChild(segment8);

		plane14 = new ModelPart(this);
		plane14.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane14, 0.0F, -0.7854F, 0.0F);
		segment8.addChild(plane14);
		plane14.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 24, 10);

		plane15 = new ModelPart(this);
		plane15.setPos(0.0F, 17.0F, -2.0F);
		setRotationAngle(plane15, 0.0F, 0.7854F, 0.0F);
		segment8.addChild(plane15);
		plane15.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0.0F, 24, 10);
	}
	
	@Override
	public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.getPose() == Pose.CROUCHING) {
			tutu.y = 8.0F;
			tutu.z = 2.0F;
			tutu.xRot = (float) (Math.PI * 0.16667F);
		} else {
			tutu.y = 9.0F;
			tutu.z = 0;
			tutu.xRot = 0;
		}
				
		final float f1 = 0.065F;
		final float f2 = 0.125F;
		segment1.xRot = -0.3491F + f1 * Mth.cos(f2 * ageInTicks);
		segment2.xRot = -0.3491F + f1 * Mth.cos(f2 * ageInTicks);
		segment3.xRot = -0.3491F + f1 * Mth.cos(f2 * ageInTicks);
		segment4.xRot = -0.3491F + f1 * Mth.cos(f2 * ageInTicks);
		segment5.xRot = -0.3491F + f1 * Mth.cos(f2 * ageInTicks);
		segment6.xRot = -0.3491F + f1 * Mth.cos(f2 * ageInTicks);

		segment7.zRot = -0.3491F + f1 * Mth.cos(f2 * ageInTicks);
		segment8.zRot = 0.3491F - f1 * Mth.cos(f2 * ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		tutu.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
	
	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}
}