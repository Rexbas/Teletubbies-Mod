package com.rexbas.teletubbies.client.renderer.entity;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.RenderHandler;
import com.rexbas.teletubbies.client.renderer.model.NooNooModel;
import com.rexbas.teletubbies.entity.passive.NooNooEntity;

import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class NooNooRenderer extends MobRenderer<NooNooEntity, NooNooModel> {

	public NooNooRenderer(Context ctx) {
		super(ctx, new NooNooModel(ctx.bakeLayer(RenderHandler.NOONOO_LAYER)), 0.5F);
	}

	@Override
	public ResourceLocation getTextureLocation(NooNooEntity entity) {
		return new ResourceLocation(Teletubbies.MODID, "textures/entity/noonoo.png");
	}
}