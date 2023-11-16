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
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DipsyHatModel extends HumanoidModel<LivingEntity> {	
	public final ModelPart hat;

	public DipsyHatModel(ModelPart part) {
		super(part);
		hat = part.getChild("_hat");
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 1.0f);
		PartDefinition def = mesh.getRoot();
		
		def.addOrReplaceChild("_hat", CubeListBuilder.create()
				.addBox(null, -4.0F, -16.0F, -4.0F, 8, 7, 2, 20, 10)
				.addBox(null, -4.0F, -16.0F, 2.0F, 8, 7, 2, 0, 10)
				.addBox(null, -4.0F, -16.0F, -2.0F, 2, 7, 4, 12, 27)
				.addBox(null, 2.0F, -16.0F, -2.0F, 2, 7, 4, 0, 27)
				.addBox(null, -6.0F, -9.0F, 3.0F, 12, 2, 3, 0, 5)
				.addBox(null, -6.0F, -9.0F, -6.0F, 12, 2, 3, 0, 0)
				.addBox(null, -6.0F, -9.0F, -3.0F, 3, 2, 6, 18, 19)
				.addBox(null, 3.0F, -9.0F, -3.0F, 3, 2, 6, 0, 19),
				PartPose.offset(0.0F, 24.0F, 0.0F));
		
		return LayerDefinition.create(mesh, 64, 64);
	}
	
	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		hat.copyFrom(head);
		hat.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}