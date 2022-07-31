package com.rexbas.teletubbies.entity.ai.goal;

import com.rexbas.teletubbies.init.TeletubbiesBlocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.EatBlockGoal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import teletubbies.init.TeletubbiesBlocks;

public class EatFullGrassGoal extends EatBlockGoal {

	public EatFullGrassGoal(Mob entity) {
		super(entity);
	}

	@Override
	public boolean canUse() {
		if (this.mob.getRandom().nextInt(this.mob.isBaby() ? 50 : 1000) != 0) {
			return false;
		} else {
			BlockPos blockpos = this.mob.blockPosition();
			if (IS_TALL_GRASS.test(this.level.getBlockState(blockpos))) {
				return true;
			} else {
				return this.level.getBlockState(blockpos.below()).is(TeletubbiesBlocks.FULL_GRASS.get());
			}
		}
	}

	@Override
	public void tick() {
		this.eatAnimationTick = Math.max(0, this.eatAnimationTick - 1);
		if (this.eatAnimationTick == 4) {
			BlockPos blockpos = this.mob.blockPosition();
			if (IS_TALL_GRASS.test(this.level.getBlockState(blockpos))) {
				if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.mob)) {
					this.level.destroyBlock(blockpos, false);
				}

				this.mob.ate();
			} else {
				BlockPos blockpos1 = blockpos.below();
				if (this.level.getBlockState(blockpos1).is(TeletubbiesBlocks.FULL_GRASS.get())) {
					if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level, this.mob)) {
						this.level.levelEvent(2001, blockpos1, Block.getId(TeletubbiesBlocks.FULL_GRASS.get().defaultBlockState()));
						this.level.setBlock(blockpos1, Blocks.DIRT.defaultBlockState(), 2);
					}

					this.mob.ate();
				}
			}
		}
	}
}
