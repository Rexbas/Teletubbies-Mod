package com.rexbas.teletubbies.client.renderer.entity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.rexbas.bouncingballs.api.client.renderer.SitRenderer;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.LightType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@OnlyIn(Dist.CLIENT)
public class MobSitRenderer<T extends MobEntity, M extends EntityModel<T> & IHasArm> extends SitRenderer<T, M> {

	public MobSitRenderer(EntityRendererManager manager, M model, float shadowRadius, ResourceLocation texture) {
		super(manager, model, shadowRadius, texture);
	}
	
	public MobSitRenderer(LivingRenderer<T, M> livingRenderer, T entity) {
		super(livingRenderer, entity);
	}
	
	@Override
	protected boolean shouldShowName(T entity) {
		return super.shouldShowName(entity) && (entity.shouldShowName() || entity.hasCustomName() && entity == this.entityRenderDispatcher.crosshairPickEntity);
	}

	@Override
	public boolean shouldRender(T entity, ClippingHelper clippingHelper, double p_225626_3_, double p_225626_5_, double p_225626_7_) {
		if (super.shouldRender(entity, clippingHelper, p_225626_3_, p_225626_5_, p_225626_7_)) {
			return true;
		} else {
			Entity entityLeash = entity.getLeashHolder();
			return entityLeash != null ? clippingHelper.isVisible(entityLeash.getBoundingBoxForCulling()) : false;
		}
	}

	@Override
	public void render(T entity, float p_225623_2_, float partialRenderTick, MatrixStack matrixStack, IRenderTypeBuffer buffers, int light) {
		super.render(entity, p_225623_2_, partialRenderTick, matrixStack, buffers, light);
		Entity entityLeash = entity.getLeashHolder();
		if (entityLeash != null) {
			this.renderLeash(entity, partialRenderTick, matrixStack, buffers, entityLeash);
		}
	}

	private <E extends Entity> void renderLeash(T entity, float partialRenderTick, MatrixStack matrixStack, IRenderTypeBuffer buffers, E entityLeash) {
		matrixStack.pushPose();
		Vector3d vector3d = entityLeash.getRopeHoldPosition(partialRenderTick);
		double d0 = (double) (MathHelper.lerp(partialRenderTick, entity.yBodyRot, entity.yBodyRotO) * ((float) Math.PI / 180F)) + (Math.PI / 2D);
		Vector3d vector3d1 = entity.getLeashOffset();
		double d1 = Math.cos(d0) * vector3d1.z + Math.sin(d0) * vector3d1.x;
		double d2 = Math.sin(d0) * vector3d1.z - Math.cos(d0) * vector3d1.x;
		double d3 = MathHelper.lerp((double) partialRenderTick, entity.xo, entity.getX()) + d1;
		double d4 = MathHelper.lerp((double) partialRenderTick, entity.yo, entity.getY()) + vector3d1.y;
		double d5 = MathHelper.lerp((double) partialRenderTick, entity.zo, entity.getZ()) + d2;
		matrixStack.translate(d1, vector3d1.y, d2);
		float f = (float) (vector3d.x - d3);
		float f1 = (float) (vector3d.y - d4);
		float f2 = (float) (vector3d.z - d5);
		IVertexBuilder ivertexbuilder = buffers.getBuffer(RenderType.leash());
		Matrix4f matrix4f = matrixStack.last().pose();
		float f4 = MathHelper.fastInvSqrt(f * f + f2 * f2) * 0.025F / 2.0F;
		float f5 = f2 * f4;
		float f6 = f * f4;
		BlockPos blockpos = new BlockPos(entity.getEyePosition(partialRenderTick));
		BlockPos blockpos1 = new BlockPos(entityLeash.getEyePosition(partialRenderTick));
		int i = this.getBlockLightLevel(entity, blockpos);
		
		Method m = ObfuscationReflectionHelper.findMethod(EntityRenderer.class, "func_225624_a_", Entity.class, BlockPos.class); // getBlockLightLevel(T extends Entity, BlockPos)
		int getBlockLightLevel = 0;
		try {
			getBlockLightLevel = (int) m.invoke(this.entityRenderDispatcher.getRenderer(entityLeash), entityLeash, blockpos1);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		int j = getBlockLightLevel;
		int k = entity.level.getBrightness(LightType.SKY, blockpos);
		int l = entity.level.getBrightness(LightType.SKY, blockpos1);
		MobRenderer.renderSide(ivertexbuilder, matrix4f, f, f1, f2, i, j, k, l, 0.025F, 0.025F, f5, f6);
		MobRenderer.renderSide(ivertexbuilder, matrix4f, f, f1, f2, i, j, k, l, 0.025F, 0.0F, f5, f6);
		matrixStack.popPose();
	}
}