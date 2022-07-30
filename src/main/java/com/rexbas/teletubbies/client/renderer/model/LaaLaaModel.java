package com.rexbas.teletubbies.client.renderer.model;

import com.rexbas.teletubbies.entity.passive.LaaLaaEntity;

import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LaaLaaModel extends TeletubbyModel<LaaLaaEntity> {
	public ModelRenderer stick;

	public LaaLaaModel() {
		stick = new ModelRenderer(this);
		stick.setPos(0.0F, 24.0F, 0.0F);
		stick.addBox(null, -1.0F, -35.0F, -1.0F, 2, 3, 2, 0.0F, 27, 20);
		stick.addBox(null, 0.0F, -38.0F, 0.0F, 2, 4, 2, 0.0F, 27, 25);
		
		head.addChild(stick);
	}
}
