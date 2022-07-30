package com.rexbas.teletubbies.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.model.PoScooterModel;
import com.rexbas.teletubbies.entity.PoScooterEntity;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class PoScooterRenderer extends EntityRenderer<PoScooterEntity> {
	private static final PoScooterModel model = new PoScooterModel();

	public PoScooterRenderer(EntityRendererManager manager) {
		super(manager);
		this.shadowRadius = 0.5F;
	}
	
	@Override
	public void render(PoScooterEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffers, int light) {
		matrixStack.pushPose();
		matrixStack.translate(0.0D, 0.375D, 0.0D);
		matrixStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
		float f = (float) entity.getHurtTime() - partialTicks;
		float f1 = entity.getDamage() - partialTicks;
		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f > 0.0F) {
			matrixStack.mulPose(Vector3f.XP.rotationDegrees(MathHelper.sin(f) * f * f1 / 10.0F * (float) entity.getHurtDir()));
		}

		matrixStack.scale(-1.0F, -1.0F, 1.0F);
		PoScooterRenderer.model.setupAnim(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
		IVertexBuilder ivertexbuilder = buffers.getBuffer(PoScooterRenderer.model.renderType(this.getTextureLocation(entity)));
		PoScooterRenderer.model.renderToBuffer(matrixStack, ivertexbuilder, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		matrixStack.popPose();
		super.render(entity, entityYaw, partialTicks, matrixStack, buffers, light);
	}
	
	@Override
	public ResourceLocation getTextureLocation(PoScooterEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/po_scooter.png");
	}
	
	public static class RenderFactory implements IRenderFactory<PoScooterEntity> {
		
		@Override
		public EntityRenderer<? super PoScooterEntity> createRenderFor(EntityRendererManager manager) {
			return new PoScooterRenderer(manager);
		}
	}
}