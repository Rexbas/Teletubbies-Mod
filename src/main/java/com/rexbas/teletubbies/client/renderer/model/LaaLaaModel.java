package com.rexbas.teletubbies.client.renderer.model;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LaaLaaModel<T extends CreatureEntity> extends TeletubbyModel<T> {
	public ModelRenderer stick;

	public LaaLaaModel(boolean isZombie) {
		super(isZombie);
		stick = new ModelRenderer(this);
		stick.setPos(0.0F, 24.0F, 0.0F);
		stick.addBox(null, -1.0F, -35.0F, -1.0F, 2, 3, 2, 0.0F, 27, 20);
		stick.addBox(null, 0.0F, -38.0F, 0.0F, 2, 4, 2, 0.0F, 27, 25);
		
		head.addChild(stick);
	}
}