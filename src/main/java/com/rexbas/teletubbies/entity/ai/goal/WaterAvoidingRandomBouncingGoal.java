package com.rexbas.teletubbies.entity.ai.goal;

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
		if (mob.getNavigation().getTargetPos() != null && !mob.getNavigation().getTargetPos().closerToCenterThan(mob.position(), 5)) {
			ItemStack ballStack = null;
			if (mob.getOffhandItem().getItem() instanceof BouncingBall) {
				ballStack = mob.getOffhandItem();
			}
			else if (mob.getMainHandItem().getItem() instanceof BouncingBall) {
				ballStack = mob.getMainHandItem();
			}

			if (ballStack != null && !mob.level().isClientSide()) {
				BouncingBall ball = (BouncingBall) ballStack.getItem();
				if (ball.canBounce(mob)) {
					ball.bounce(mob, 1f);
					ball.damageBall(mob, ballStack);
					ball.playBounceSound(mob.level(), mob);
					mob.getNavigation().stop();
				}
			}
		}
	}
}