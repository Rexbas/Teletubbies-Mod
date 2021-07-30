package teletubbies.client.renderer.entity.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TeletubbyModel<T extends PathfinderMob> extends HumanoidModel<T> {
	public ModelPart leftEar;
	public ModelPart rightEar;
	boolean isZombie;
		
	public TeletubbyModel(ModelPart part, boolean isZombie) {
		super(part);
		this.isZombie = isZombie;
		leftEar = part.getChild("head").getChild("leftEar");
		rightEar = part.getChild("head").getChild("rightEar");
	}
	
	public static MeshDefinition createMesh() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 1.0f);
		PartDefinition def = mesh.getRoot();
		
		def.getChild("head").addOrReplaceChild("leftEar", CubeListBuilder.create()
				.addBox(null, 1.8333F, -26.5F, 0.3333F, 1, 3, 1, 56, 21)
				.addBox(null, 1.8333F, -25.5F, -1.6667F, 1, 3, 2, 56, 25)
				.addBox(null, 1.8333F, -26.5F, -0.6667F, 1, 1, 1, 56, 30),
				PartPose.offset(-6.8333F, 19.5F, -0.3333F));
		
		def.getChild("head").addOrReplaceChild("rightEar", CubeListBuilder.create()
				.addBox(null, -2.8333F, -26.5F, 0.3333F, 1, 3, 1, 56, 21)
				.addBox(null, -2.8333F, -25.5F, -1.6667F, 1, 3, 2, 56, 25)
				.addBox(null, -2.8333F, -26.5F, -0.6667F, 1, 1, 1, 56, 30),
				PartPose.offset(6.8333F, 19.5F, -0.3333F));
		
		return mesh;
	}
	
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		if (isZombie) {
			boolean flag = entity.isAggressive();
			float f = Mth.sin(attackTime * (float) Math.PI);
			float f1 = Mth.sin((1.0F - (1.0F - attackTime) * (1.0F - attackTime)) * (float) Math.PI);
			rightArm.zRot = 0.0F;
			leftArm.zRot = 0.0F;
			rightArm.yRot = -(0.1F - f * 0.6F);
			leftArm.yRot = 0.1F - f * 0.6F;
			float f2 = -(float) Math.PI / (flag ? 1.5F : 2.25F);
			rightArm.xRot = f2;
			leftArm.xRot = f2;
			rightArm.xRot += f * 1.2F - f1 * 0.4F;
			leftArm.xRot += f * 1.2F - f1 * 0.4F;
			rightArm.zRot += Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			leftArm.zRot -= Mth.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
			rightArm.xRot += Mth.sin(ageInTicks * 0.067F) * 0.05F;
			leftArm.xRot -= Mth.sin(ageInTicks * 0.067F) * 0.05F;
		}
	}
}
