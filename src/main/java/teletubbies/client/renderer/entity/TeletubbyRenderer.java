package teletubbies.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fmlclient.registry.IRenderFactory;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.entity.model.TeletubbyModel;

@OnlyIn(Dist.CLIENT)
public class TeletubbyRenderer<T extends PathfinderMob, M extends TeletubbyModel<T>> extends HumanoidMobRenderer<T, M> {	
	private final String name;
	private float scale;
	
	public TeletubbyRenderer(EntityRenderDispatcher manager, String name, float scale, M model) {
		super(manager, null, 0.5F);
		this.name = name;
		this.scale = scale;
		this.model = model;
		this.addLayer(new HumanoidArmorLayer<T, M, HumanoidModel<T>>(this, new HumanoidModel<>(0.5F), new HumanoidModel<>(1.0F)));
	}

	@Override
	public ResourceLocation getTextureLocation(T entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/" + name + ".png");
	}
	
	@Override
	public void render(T entityIn, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {
		if (MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Pre<T, M>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn)))
			return;
		matrixStackIn.pushPose();
		this.model.attackTime = this.getAttackAnim(entityIn, partialTicks);

		boolean shouldSit = entityIn.isPassenger() && (entityIn.getVehicle() != null && entityIn.getVehicle().shouldRiderSit());
		this.model.riding = shouldSit;
		this.model.young = entityIn.isBaby();
		float f = Mth.rotLerp(partialTicks, entityIn.yBodyRotO, entityIn.yBodyRot);
		float f1 = Mth.rotLerp(partialTicks, entityIn.yHeadRotO, entityIn.yHeadRot);
		float f2 = f1 - f;
		if (shouldSit && entityIn.getVehicle() instanceof LivingEntity) {
			LivingEntity livingentity = (LivingEntity) entityIn.getVehicle();
			f = Mth.rotLerp(partialTicks, livingentity.yBodyRotO, livingentity.yBodyRot);
			f2 = f1 - f;
			float f3 = Mth.wrapDegrees(f2);
			if (f3 < -85.0F) {
				f3 = -85.0F;
			}

			if (f3 >= 85.0F) {
				f3 = 85.0F;
			}

			f = f1 - f3;
			if (f3 * f3 > 2500.0F) {
				f += f3 * 0.2F;
			}

			f2 = f1 - f;
		}

		float f6 = Mth.lerp(partialTicks, entityIn.xRotO, entityIn.xRot);
		if (entityIn.getPose() == Pose.SLEEPING) {
			Direction direction = entityIn.getBedOrientation();
			if (direction != null) {
				float f4 = entityIn.getEyeHeight(Pose.STANDING) - 0.1F;
				matrixStackIn.translate((double) ((float) (-direction.getStepX()) * f4), 0.0D, (double) ((float) (-direction.getStepZ()) * f4));
			}
		}

		float f7 = this.getBob(entityIn, partialTicks);
		this.setupRotations(entityIn, matrixStackIn, f7, f, partialTicks);
		matrixStackIn.scale(-scale, -scale, scale);
		this.scale(entityIn, matrixStackIn, partialTicks);
		matrixStackIn.translate(0.0D, (double) -1.501F, 0.0D);
		float f8 = 0.0F;
		float f5 = 0.0F;
		if (!shouldSit && entityIn.isAlive()) {
			f8 = Mth.lerp(partialTicks, entityIn.animationSpeedOld, entityIn.animationSpeed);
			f5 = entityIn.animationPosition - entityIn.animationSpeed * (1.0F - partialTicks);
			if (entityIn.isBaby()) {
				f5 *= 3.0F;
			}

			if (f8 > 1.0F) {
				f8 = 1.0F;
			}
		}

		this.model.prepareMobModel(entityIn, f5, f8, partialTicks);
		this.model.setupAnim(entityIn, f5, f8, f7, f2, f6);
	    Minecraft minecraft = Minecraft.getInstance();
		boolean flag = this.isBodyVisible(entityIn);
		boolean flag1 = !flag && !entityIn.isInvisibleTo(Minecraft.getInstance().player);
	    boolean flag2 = minecraft.shouldEntityAppearGlowing(entityIn);
		RenderType rendertype = this.getRenderType(entityIn, flag, flag1, flag2);
		if (rendertype != null) {
			VertexConsumer ivertexbuilder = bufferIn.getBuffer(rendertype);
			int i = getOverlayCoords(entityIn, this.getWhiteOverlayProgress(entityIn, partialTicks));
			this.model.renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, i, 1.0F, 1.0F, 1.0F, flag1 ? 0.15F : 1.0F);
		}

		if (!entityIn.isSpectator()) {
			for (RenderLayer<T, M> layerrenderer : this.layers) {
				layerrenderer.render(matrixStackIn, bufferIn, packedLightIn, entityIn, f5, f8, partialTicks, f7, f2, f6);
			}
		}

		matrixStackIn.popPose();
		MinecraftForge.EVENT_BUS.post(new RenderLivingEvent.Post<T, M>(entityIn, this, partialTicks, matrixStackIn, bufferIn, packedLightIn));
	}

	public static class RenderFactory<T extends PathfinderMob, M extends TeletubbyModel<T>> implements IRenderFactory<T> {
		private final String name;
		private final float scale;
		private final M model;
		
		public RenderFactory(String name, float scale, M model) {
			this.name = name;
			this.scale = scale;
			this.model = model;
		}
		
		@Override
		public EntityRenderer<? super T> createRenderFor(EntityRenderDispatcher manager) {
			return new TeletubbyRenderer<>(manager, name, scale, model);
		}
	}
}
