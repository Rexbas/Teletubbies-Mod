package com.rexbas.teletubbies.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.rexbas.bouncingballs.api.client.renderer.BouncingBallHeldItemLayer;
import com.rexbas.teletubbies.client.renderer.model.TeletubbyModel;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.HeadLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

// Originally extended BipedRenderer but this only added some layers and is now included in this class
@OnlyIn(Dist.CLIENT)
public class TeletubbyRenderer<T extends CreatureEntity, M extends TeletubbyModel<T>> extends MobSitRenderer<T, M> {	
	
	private float scale;
		
	public TeletubbyRenderer(EntityRendererManager manager, float scale, M model, ResourceLocation texture) {
		super(manager, model, 0.5F, texture);
		this.scale = scale;
		this.addLayer(new BipedArmorLayer<T, M, BipedModel<T>>(this, new BipedModel<>(0.5F), new BipedModel<>(1.0F)));
		this.addLayer(new HeadLayer<>(this, 1, 1, 1));
		this.addLayer(new ElytraLayer<>(this));
		this.addLayer(new BouncingBallHeldItemLayer<>(this));
	}
	
	@Override
	protected void scale(T entity, MatrixStack matrixStack, float partialRenderTick) {
		matrixStack.scale(scale, scale, scale);
	}

	public static class RenderFactory<T extends CreatureEntity, M extends TeletubbyModel<T>> implements IRenderFactory<T> {
		private final float scale;
		private final M model;
		private final ResourceLocation texture;
		
		public RenderFactory(float scale, M model, ResourceLocation texture) {
			this.scale = scale;
			this.model = model;
			this.texture = texture;
		}
		
		@Override
		public EntityRenderer<? super T> createRenderFor(EntityRendererManager manager) {
			return new TeletubbyRenderer<>(manager, scale, model, texture);
		}
	}
}