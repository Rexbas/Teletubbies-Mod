package com.rexbas.teletubbies.entity.ai.goal;

import com.rexbas.bouncingballs.api.capability.BounceCapability;
import com.rexbas.bouncingballs.api.item.BouncingBall;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.item.ItemStack;

public class WaterAvoidingRandomBouncingGoal extends WaterAvoidingRandomStrollGoal {

	public WaterAvoidingRandomBouncingGoal(PathfinderMob entity, double speed) {
		super(entity, speed);
	}
	
	@Override
	public void tick() {
		super.tick();
		if (this.mob.getNavigation().getTargetPos() != null && !this.mob.getNavigation().getTargetPos().closerToCenterThan(this.mob.position(), 5)) {
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