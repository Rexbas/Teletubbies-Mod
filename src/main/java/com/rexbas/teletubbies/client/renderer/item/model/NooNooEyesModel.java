package com.rexbas.teletubbies.client.renderer.item.model;

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
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NooNooEyesModel extends HumanoidModel<LivingEntity> {	
	public ModelPart eyes;

	public NooNooEyesModel(ModelPart part) {
		super(part);
		eyes = part.getChild("eyes");
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 1.0f);
		PartDefinition def = mesh.getRoot();
		
		def.addOrReplaceChild("eyes", CubeListBuilder.create()
				.addBox(null, 0.0F, -6.0F, -8.0F, 3, 3, 4, 0, 7)
				.addBox(null, -3.0F, -5.0F, -8.0F, 3, 3, 4, 0, 0),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		
		return LayerDefinition.create(mesh, 16, 16);
	}
	
	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		eyes.copyFrom(head);
		eyes.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}