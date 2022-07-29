package com.rexbas.teletubbies.client.renderer.entity;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.entity.model.TiddlytubbyModel;
import com.rexbas.teletubbies.entity.baby.TiddlytubbyEntity;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class TiddlytubbyRenderer extends MobRenderer<TiddlytubbyEntity, TiddlytubbyModel<TiddlytubbyEntity>> {
	private final String name;

	public TiddlytubbyRenderer(EntityRendererManager manager, String name) {
		super(manager, new TiddlytubbyModel<>(), 0.3F);
		this.name = name;
	}

	@Override
	public ResourceLocation getTextureLocation(TiddlytubbyEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/" + name + ".png");
	}
	
	public static class RenderFactory implements IRenderFactory<TiddlytubbyEntity> {
		private final String name;
		
		public RenderFactory(String name) {
			this.name = name;
		}
		
		@Override
		public EntityRenderer<? super TiddlytubbyEntity> createRenderFor(EntityRendererManager manager) {
			return new TiddlytubbyRenderer(manager, name);
		}
	}
}
