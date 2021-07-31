package teletubbies.client.renderer.item.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TutuModel extends HumanoidModel<LivingEntity> {	
	private final ModelPart tutu;
	private final ModelPart segment1;
	private final ModelPart segment2;
	private final ModelPart segment3;
	private final ModelPart segment4;
	private final ModelPart segment5;
	private final ModelPart segment6;
	private final ModelPart segment7;
	private final ModelPart segment8;

	public TutuModel(ModelPart part) {
		super(part);
		tutu = part.getChild("tutu");
		segment1 = part.getChild("tutu").getChild("segment1");
		segment2 = part.getChild("tutu").getChild("segment2");
		segment3 = part.getChild("tutu").getChild("segment3");
		segment4 = part.getChild("tutu").getChild("segment4");
		segment5 = part.getChild("tutu").getChild("segment5");
		segment6 = part.getChild("tutu").getChild("segment6");
		segment7 = part.getChild("tutu").getChild("segment7");
		segment8 = part.getChild("tutu").getChild("segment8");
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 1.0f);
		PartDefinition def = mesh.getRoot();
		
		def.addOrReplaceChild("tutu", CubeListBuilder.create(),
				PartPose.offset(0.0F, 9.0F, 0.0F));
		
		
		
		def.getChild("tutu").addOrReplaceChild("segment1", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
		
		def.getChild("tutu").getChild("segment1").addOrReplaceChild("plane0", CubeListBuilder.create()
				.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0, 0),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, -0.7854F, 0.0F));

		def.getChild("tutu").getChild("segment1").addOrReplaceChild("plane1", CubeListBuilder.create()
				.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0, 0),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, 0.7854F, 0.0F));
		
		
		
		def.getChild("tutu").addOrReplaceChild("segment2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.0F, -2.0F, 0.0F, -0.3491F, -0.4363F, 0.0F));
		
		def.getChild("tutu").getChild("segment2").addOrReplaceChild("plane2", CubeListBuilder.create()
				.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, -0.7854F, 0.0F));
		
		def.getChild("tutu").getChild("segment2").addOrReplaceChild("plane3", CubeListBuilder.create()
				.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, 0.7854F, 0.0F));
		
		
		
		def.getChild("tutu").addOrReplaceChild("segment3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.0F, -2.0F, 0.0F, -0.3491F, 0.4363F, 0.0F));
		
		def.getChild("tutu").getChild("segment3").addOrReplaceChild("plane4", CubeListBuilder.create()
				.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, -0.7854F, 0.0F));
		
		def.getChild("tutu").getChild("segment3").addOrReplaceChild("plane5", CubeListBuilder.create()
				.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, 0.7854F, 0.0F));
		
		
		
		def.getChild("tutu").addOrReplaceChild("segment4", CubeListBuilder.create(),
				PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3491F, 3.1416F, 0.0F));
		
		def.getChild("tutu").getChild("segment4").addOrReplaceChild("plane6", CubeListBuilder.create()
				.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, -0.7854F, 0.0F));
		
		def.getChild("tutu").getChild("segment4").addOrReplaceChild("plane7", CubeListBuilder.create()
				.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, 0.7854F, 0.0F));
		
		
		
		def.getChild("tutu").addOrReplaceChild("segment5", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.0F, -2.0F, 0.0F, -0.3491F, 2.7053F, 0.0F));
		
		def.getChild("tutu").getChild("segment5").addOrReplaceChild("plane8", CubeListBuilder.create()
				.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, -0.7854F, 0.0F));
		
		def.getChild("tutu").getChild("segment5").addOrReplaceChild("plane9", CubeListBuilder.create()
				.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, 0.7854F, 0.0F));
		
		
		
		def.getChild("tutu").addOrReplaceChild("segment6", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.0F, -2.0F, 0.0F, -0.3491F, -2.7053F, 0.0F));
		
		def.getChild("tutu").getChild("segment6").addOrReplaceChild("plane10", CubeListBuilder.create()
				.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, -0.7854F, 0.0F));
		
		def.getChild("tutu").getChild("segment6").addOrReplaceChild("plane11", CubeListBuilder.create()
				.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, 0.7854F, 0.0F));
		
		
		
		def.getChild("tutu").addOrReplaceChild("segment7", CubeListBuilder.create(),
				PartPose.offsetAndRotation(2.0F, -2.0F, 0.0F, 0.0F, -1.5708F, -0.3491F));
		
		def.getChild("tutu").getChild("segment7").addOrReplaceChild("plane12", CubeListBuilder.create()
				.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, -0.7854F, 0.0F));
		
		def.getChild("tutu").getChild("segment7").addOrReplaceChild("plane13", CubeListBuilder.create()
				.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, 0.7854F, 0.0F));
		
		
		
		def.getChild("tutu").addOrReplaceChild("segment8", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.3491F));
		
		def.getChild("tutu").getChild("segment8").addOrReplaceChild("plane14", CubeListBuilder.create()
				.addBox(null, -0.7582F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, -0.7854F, 0.0F));
		
		def.getChild("tutu").getChild("segment8").addOrReplaceChild("plane15", CubeListBuilder.create()
				.addBox(null, -3.2418F, -14.0603F, -0.7582F, 4, 10, 0, 0, 10),
				PartPose.offsetAndRotation(0.0F, 17.0F, -2.0F, 0.0F, 0.7854F, 0.0F));
		
		return LayerDefinition.create(mesh, 32, 32);
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
}