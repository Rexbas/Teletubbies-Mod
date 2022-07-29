package com.rexbas.teletubbies.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.entity.model.PoScooterModel;
import com.rexbas.teletubbies.entity.PoScooterEntity;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
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
	public void render(PoScooterEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
	      matrixStackIn.pushPose();
	      matrixStackIn.translate(0.0D, 0.375D, 0.0D);
	      matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
	      float f = (float)entity.getTimeSinceHit() - partialTicks;
	      float f1 = entity.getDamageTaken() - partialTicks;
	      if (f1 < 0.0F) {
	         f1 = 0.0F;
	      }

	      if (f > 0.0F) {
	         matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(MathHelper.sin(f) * f * f1 / 10.0F * (float)entity.getForwardDirection()));
	      }

	      float f2 = entity.getRockingAngle(partialTicks);
	      if (!MathHelper.equal(f2, 0.0F)) {
	         matrixStackIn.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), entity.getRockingAngle(partialTicks), true));
	      }

	      matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
	      PoScooterRenderer.model.setupAnim(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
	      IVertexBuilder ivertexbuilder = bufferIn.getBuffer(PoScooterRenderer.model.renderType(this.getTextureLocation(entity)));
	      PoScooterRenderer.model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	      matrixStackIn.popPose();
	      super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
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
