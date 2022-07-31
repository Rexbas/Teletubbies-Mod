package com.rexbas.teletubbies.client.renderer.model;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelHelper;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.CreatureEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TeletubbyModel<T extends CreatureEntity> extends BipedModel<T> {
	public ModelRenderer leftEar;
	public ModelRenderer rightEar;
	private boolean isZombie;
		
	public TeletubbyModel(boolean isZombie) {
		super(0.0F);
		this.isZombie = isZombie;
		leftEar = new ModelRenderer(this);
		leftEar.setPos(-6.8333F, 19.5F, -0.3333F);
		leftEar.addBox(null, 1.8333F, -26.5F, 0.3333F, 1, 3, 1, 0.0F, 56, 21);
		leftEar.addBox(null, 1.8333F, -25.5F, -1.6667F, 1, 3, 2, 0.0F, 56, 25);
		leftEar.addBox(null, 1.8333F, -26.5F, -0.6667F, 1, 1, 1, 0.0F, 56, 30);

		rightEar = new ModelRenderer(this);
		rightEar.setPos(6.8333F, 19.5F, -0.3333F);
		rightEar.addBox(null, -2.8333F, -26.5F, 0.3333F, 1, 3, 1, 0.0F, 56, 21);
		rightEar.addBox(null, -2.8333F, -25.5F, -1.6667F, 1, 3, 2, 0.0F, 56, 25);
		rightEar.addBox(null, -2.8333F, -26.5F, -0.6667F, 1, 1, 1, 0.0F, 56, 30);
		
		head.addChild(leftEar);
		head.addChild(rightEar);
	}
	
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		if (this.isZombie) {
			ModelHelper.animateZombieArms(this.leftArm, this.rightArm, entity.isAggressive(), this.attackTime, ageInTicks);
		}
	}
}