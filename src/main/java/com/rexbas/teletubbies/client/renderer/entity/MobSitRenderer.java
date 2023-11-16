package com.rexbas.teletubbies.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.rexbas.bouncingballs.api.client.renderer.SitRenderer;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.util.ObfuscationReflectionHelper;
import org.joml.Matrix4f;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@OnlyIn(Dist.CLIENT)
public class MobSitRenderer<T extends Mob, M extends EntityModel<T> & ArmedModel> extends SitRenderer<T, M> {

	public MobSitRenderer(EntityRendererProvider.Context context, M model, float shadowRadius, ResourceLocation texture) {
		super(context, model, shadowRadius, texture);
	}
	
	@Override
	protected boolean shouldShowName(T entity) {
		return super.shouldShowName(entity) && (entity.shouldShowName() || entity.hasCustomName() && entity == this.entityRenderDispatcher.crosshairPickEntity);
	}

	@Override
	public boolean shouldRender(T entity, Frustum frustum, double p_225626_3_, double p_225626_5_, double p_225626_7_) {
		if (super.shouldRender(entity, frustum, p_225626_3_, p_225626_5_, p_225626_7_)) {
			return true;
		} else {
			Entity entityLeash = entity.getLeashHolder();
			return entityLeash != null ? frustum.isVisible(entityLeash.getBoundingBoxForCulling()) : false;
		}
	}

	@Override
	public void render(T entity, float p_225623_2_, float partialRenderTick, PoseStack poseStack, MultiBufferSource buffers, int light) {
		super.render(entity, p_225623_2_, partialRenderTick, poseStack, buffers, light);
		Entity entityLeash = entity.getLeashHolder();
		if (entityLeash != null) {
			this.renderLeash(entity, partialRenderTick, poseStack, buffers, entityLeash);
		}
	}

	private <E extends Entity> void renderLeash(T entity, float partialRenderTick, PoseStack poseStack, MultiBufferSource buffers, E entityLeash) {		
		poseStack.pushPose();
		Vec3 vec3 = entityLeash.getRopeHoldPosition(partialRenderTick);
		double d0 = (double) (Mth.lerp(partialRenderTick, entity.yBodyRot, entity.yBodyRotO) * ((float) Math.PI / 180F)) + (Math.PI / 2D);
		Vec3 vec31 = entity.getLeashOffset(partialRenderTick);
		double d1 = Math.cos(d0) * vec31.z + Math.sin(d0) * vec31.x;
		double d2 = Math.sin(d0) * vec31.z - Math.cos(d0) * vec31.x;
		double d3 = Mth.lerp(partialRenderTick, entity.xo, entity.getX()) + d1;
		double d4 = Mth.lerp(partialRenderTick, entity.yo, entity.getY()) + vec31.y;
		double d5 = Mth.lerp(partialRenderTick, entity.zo, entity.getZ()) + d2;
		poseStack.translate(d1, vec31.y, d2);
		float f = (float) (vec3.x - d3);
		float f1 = (float) (vec3.y - d4);
		float f2 = (float) (vec3.z - d5);
		VertexConsumer vertexconsumer = buffers.getBuffer(RenderType.leash());
		Matrix4f matrix4f = poseStack.last().pose();
		float f4 = (float) (Mth.fastInvSqrt(f * f + f2 * f2) * 0.025F / 2.0F);
		float f5 = f2 * f4;
		float f6 = f * f4;
		BlockPos blockpos = BlockPos.containing(entity.getEyePosition(partialRenderTick));
		BlockPos blockpos1 = BlockPos.containing(entityLeash.getEyePosition(partialRenderTick));
		int i = this.getBlockLightLevel(entity, blockpos);
		
		Method m = ObfuscationReflectionHelper.findMethod(EntityRenderer.class, "m_6086_", Entity.class, BlockPos.class); // getBlockLightLevel(T extends Entity, BlockPos)
		int getBlockLightLevel = 0;
		try {
			getBlockLightLevel = (int) m.invoke(this.entityRenderDispatcher.getRenderer(entityLeash), entityLeash, blockpos1);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		int j = getBlockLightLevel;
		int k = entity.level().getBrightness(LightLayer.SKY, blockpos);
		int l = entity.level().getBrightness(LightLayer.SKY, blockpos1);

		for (int i1 = 0; i1 <= 24; ++i1) {
			MobRenderer.addVertexPair(vertexconsumer, matrix4f, f, f1, f2, i, j, k, l, 0.025F, 0.025F, f5, f6, i1, false);
		}

		for (int j1 = 24; j1 >= 0; --j1) {
			MobRenderer.addVertexPair(vertexconsumer, matrix4f, f, f1, f2, i, j, k, l, 0.025F, 0.0F, f5, f6, j1, true);
		}

		poseStack.popPose();
	}
}