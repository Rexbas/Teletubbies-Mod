package com.rexbas.teletubbies.client.renderer.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.entity.passive.NooNooEntity;

@OnlyIn(Dist.CLIENT)
public class NooNooModel extends EntityModel<NooNooEntity> {
	public ModelPart feet;
	public ModelPart body;
	public ModelPart brush;
	public ModelPart hose;
	public ModelPart rightEye;
	public ModelPart leftEye;

	public NooNooModel(ModelPart part) {		
		feet = part.getChild("feet");
		body = part.getChild("body");
		brush = part.getChild("brush");
		hose = part.getChild("hose");
		rightEye = part.getChild("rightEye");
		leftEye = part.getChild("leftEye");
	}
	
	public static LayerDefinition createBodyLayer() {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition def = mesh.getRoot();
		
		def.addOrReplaceChild("feet", CubeListBuilder.create()
				.addBox(null, -4.5F, -1.25F, -10.0F, 9, 1, 20, 66, 43)
				.addBox(null, -5.5F, -0.25F, -11.0F, 11, 2, 22, 46, 7),
				PartPose.offset(0.5F, 22.25F, 4.0F));
		
		def.addOrReplaceChild("body", CubeListBuilder.create()
				.addBox(null, -6.5F, -4.5F, -16.2F, 1, 9, 22, 0, 0)
				.addBox(null, 5.5F, -4.5F, -16.2F, 1, 9, 22, 0, 0)
				.addBox(null, -5.5F, -5.5F, -16.2F, 11, 11, 22, 0, 31)
				.addBox(null, -3.5F, -3.5F, 5.8F, 7, 7, 2, 0, 31)
				.addBox(null, -1.5F, -1.5F, 7.8F, 3, 3, 2, 0, 40),
				PartPose.offset(0.5F, 15.5F, 9.2F));
		
		def.addOrReplaceChild("brush", CubeListBuilder.create()
				.addBox(null, -0.5F, -2.0F, -0.5F, 1, 2, 1, 10, 50)
				.addBox(null, -1.5F, -3.0F, -1.5F, 3, 1, 3, 10, 46),
				PartPose.offset(0.5F, 10.0F, -2.5F));
		
		def.addOrReplaceChild("hose", CubeListBuilder.create()
				.addBox(null, -1.5F, -2.0F, -8.0F, 3, 3, 9, 66, 31)
				.addBox(null, -1.5F, 1.0F, -8.0F, 3, 5, 3, 66, 43)
				.addBox(null, -2.5F, 6.0F, -9.0F, 5, 1, 5, 66, 51),
				PartPose.offset(0.5F, 17.0F, -8.0F));
		
		def.addOrReplaceChild("rightEye", CubeListBuilder.create()
				.addBox(null, -1.5F, -1.5F, -3.0F, 3, 3, 4, 0, 0),
				PartPose.offset(-1.5F, 11.5F, -8.0F));
		
		def.addOrReplaceChild("leftEye", CubeListBuilder.create()
				.addBox(null, -1.5F, -1.5F, -3.0F, 3, 3, 4, 0, 7),
				PartPose.offset(2.5F, 11.5F, -8.0F));
		
		return LayerDefinition.create(mesh, 128, 64);
	}

	@Override
	public void setupAnim(NooNooEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		hose.yRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount * 0.7F;

		rightEye.xRot = headPitch * ((float) Math.PI / 180F);
		rightEye.yRot = netHeadYaw * ((float) Math.PI / 180F);

		leftEye.xRot = rightEye.xRot;
		leftEye.yRot = rightEye.yRot;
	}

	@Override
	public void renderToBuffer(PoseStack matrixStackIn, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		feet.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		brush.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		hose.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		rightEye.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
		leftEye.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}
}