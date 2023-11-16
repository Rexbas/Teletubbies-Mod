package com.rexbas.teletubbies.client.renderer.model;

import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.PathfinderMob;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TeletubbyModel<T extends PathfinderMob> extends HumanoidModel<T> {

	private final boolean isZombie;
		
	public TeletubbyModel(ModelPart part, boolean isZombie) {
		super(part);
		this.isZombie = isZombie;
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
		if (this.isZombie) {
		    AnimationUtils.animateZombieArms(this.leftArm, this.rightArm, entity.isAggressive(), this.attackTime, ageInTicks);
		}
	}
}