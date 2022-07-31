package com.rexbas.teletubbies.client.renderer.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PoModel<T extends CreatureEntity> extends TeletubbyModel<T> {
	public ModelRenderer stick;

	public PoModel(boolean isZombie) {
		super(isZombie);
		stick = new ModelRenderer(this);
		stick.setPos(0.0F, 24.0F, 0.0F);
		stick.addBox(null, -1.0F, -34.0F, -1.0F, 2, 2, 2, 0.0F, 27, 20);
		stick.addBox(null, -2.0F, -35.0F, -1.0F, 4, 1, 2, 0.0F, 27, 24);
		stick.addBox(null, 1.0F, -37.0F, -1.0F, 1, 2, 2, 0.0F, 27, 27);
		stick.addBox(null, -2.0F, -37.0F, -1.0F, 1, 2, 2, 0.0F, 35, 20);
		stick.addBox(null, -2.0F, -38.0F, -1.0F, 4, 1, 2, 0.0F, 27, 26);
		
		head.addChild(stick);
	}
}
