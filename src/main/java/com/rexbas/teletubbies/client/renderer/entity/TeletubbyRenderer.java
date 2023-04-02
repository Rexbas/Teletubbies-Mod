package com.rexbas.teletubbies.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.rexbas.bouncingballs.api.client.renderer.BouncingBallItemInHandLayer;
import com.rexbas.teletubbies.client.renderer.model.TeletubbyModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// Originally extended HumanoidMobRenderer but this only added some layers and is now included in this class
@OnlyIn(Dist.CLIENT)
public class TeletubbyRenderer<T extends PathfinderMob, M extends TeletubbyModel<T>> extends MobSitRenderer<T, M> {	
	
	private float scale;
		
	public TeletubbyRenderer(EntityRendererProvider.Context context, float scale, M model, ResourceLocation texture) {
		super(context, model, 0.5F, texture);
		this.scale = scale;
	    this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
	    this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), 1, 1, 1, context.getItemInHandRenderer()));
		this.addLayer(new ElytraLayer<>(this, context.getModelSet()));
		this.addLayer(new BouncingBallItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}
	
	@Override
	protected void scale(T entity, PoseStack poseStack, float partialRenderTick) {
		poseStack.scale(scale, scale, scale);
	}
}