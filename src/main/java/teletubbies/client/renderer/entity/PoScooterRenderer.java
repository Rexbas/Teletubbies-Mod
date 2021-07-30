package teletubbies.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;

import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.RenderHandler;
import teletubbies.client.renderer.entity.model.PoScooterModel;
import teletubbies.entity.item.PoScooterEntity;

@OnlyIn(Dist.CLIENT)
public class PoScooterRenderer extends EntityRenderer<PoScooterEntity> {
	private static PoScooterModel model;

	public PoScooterRenderer(Context ctx) {
		super(ctx);
		PoScooterRenderer.model = new PoScooterModel(ctx.bakeLayer(RenderHandler.PO_SCOOTER_LAYER));
		this.shadowRadius = 0.5F;
	}
	
	@Override
	public void render(PoScooterEntity entity, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
	      matrixStackIn.pushPose();
	      matrixStackIn.translate(0.0D, 0.375D, 0.0D);
	      matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
	      float f = (float)entity.getTimeSinceHit() - partialTicks;
	      float f1 = entity.getDamageTaken() - partialTicks;
	      if (f1 < 0.0F) {
	         f1 = 0.0F;
	      }

	      if (f > 0.0F) {
	         matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(Mth.sin(f) * f * f1 / 10.0F * (float)entity.getForwardDirection()));
	      }

	      float f2 = entity.getBubbleAngle(partialTicks);
	      if (!Mth.equal(f2, 0.0F)) {
	         matrixStackIn.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), entity.getBubbleAngle(partialTicks), true));
	      }

	      matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
	      PoScooterRenderer.model.setupAnim(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F);
	      VertexConsumer ivertexbuilder = bufferIn.getBuffer(PoScooterRenderer.model.renderType(this.getTextureLocation(entity)));
	      PoScooterRenderer.model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	      matrixStackIn.popPose();
	      super.render(entity, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
	
	@Override
	public ResourceLocation getTextureLocation(PoScooterEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/po_scooter.png");
	}
}
