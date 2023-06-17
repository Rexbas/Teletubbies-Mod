package com.rexbas.teletubbies.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.RenderHandler;
import com.rexbas.teletubbies.client.renderer.model.PoScooterModel;
import com.rexbas.teletubbies.entity.PoScooterEntity;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class PoScooterRenderer extends EntityRenderer<PoScooterEntity> {
	private static PoScooterModel model;

	public PoScooterRenderer(EntityRendererProvider.Context context) {
		super(context);
		PoScooterRenderer.model = new PoScooterModel(context.bakeLayer(RenderHandler.PO_SCOOTER_LAYER));
		this.shadowRadius = 0.5F;
	}
	
	@Override
	public void render(PoScooterEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffers, int light) {
		poseStack.pushPose();
		poseStack.translate(0.0D, 0.375D, 0.0D);
		poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
		float f = (float) entity.getHurtTime() - partialTicks;
		float f1 = entity.getDamage() - partialTicks;
		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f > 0.0F) {
			poseStack.mulPose(Axis.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float) entity.getHurtDir()));
		}

		poseStack.scale(-1.0F, -1.0F, 1.0F);
		PoScooterRenderer.model.setupAnim(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		VertexConsumer vertexconsumer = buffers.getBuffer(PoScooterRenderer.model.renderType(this.getTextureLocation(entity)));
		PoScooterRenderer.model.renderToBuffer(poseStack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
		super.render(entity, entityYaw, partialTicks, poseStack, buffers, light);
	}
	
	@Override
	public @NotNull ResourceLocation getTextureLocation(PoScooterEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/item/po_scooter.png");
	}
}