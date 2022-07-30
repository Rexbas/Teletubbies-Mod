package com.rexbas.teletubbies.entity.ai.goal;

import com.rexbas.bouncingballs.api.capability.BounceCapability;
import com.rexbas.bouncingballs.api.item.BouncingBall;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.item.ItemStack;

public class WaterAvoidingRandomBouncingGoal extends WaterAvoidingRandomWalkingGoal {

	public WaterAvoidingRandomBouncingGoal(CreatureEntity entity, double speed) {
		super(entity, speed);
	}
	
	@Override
	public void tick() {
		super.tick();
		if (!this.mob.getNavigation().getTargetPos().closerThan(this.mob.position(), 5)) {
			if (this.mob.getCapability(BounceCapability.BOUNCE_CAPABILITY).isPresent()) {
				ItemStack ballStack = null;
				if (this.mob.getOffhandItem().getItem() instanceof BouncingBall) {
					ballStack = this.mob.getOffhandItem();
				}
				else if (this.mob.getMainHandItem().getItem() instanceof BouncingBall) {
					ballStack = this.mob.getMainHandItem();
				}
	
		    	if (ballStack != null && !this.mob.level.isClientSide()) {
		    		BouncingBall ball = (BouncingBall) ballStack.getItem();
		    			if (ball.canBounce(this.mob)) {
				    		ball.bounce(this.mob, 1f);
				    		ball.damageBall(this.mob, ballStack);
							ball.playBounceSound(this.mob.level, this.mob);
							this.mob.getNavigation().stop();
			    	}
		    	}
			}
		}
	}
}