package com.rexbas.teletubbies.item;

import java.util.List;
import java.util.function.Predicate;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.entity.PoScooterEntity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class PoScooterItem extends Item {
	private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.NO_SPECTATORS.and(Entity::isPickable);

	public PoScooterItem() {
		super(new Item.Properties().stacksTo(1).tab(Teletubbies.TAB));
	}

	@Override
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		RayTraceResult raytraceresult = getPlayerPOVHitResult(world, player, RayTraceContext.FluidMode.ANY);
		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return new ActionResult<>(ActionResultType.PASS, itemstack);
		} else {
			Vector3d vec3d = player.getViewVector(1.0F);
			List<Entity> list = world.getEntities(player, player.getBoundingBox().expandTowards(vec3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
			if (!list.isEmpty()) {
				Vector3d vec3d1 = player.getEyePosition(1.0F);

				for (Entity entity : list) {
					AxisAlignedBB axisalignedbb = entity.getBoundingBox().inflate((double) entity.getPickRadius());
					if (axisalignedbb.contains(vec3d1)) {
						return new ActionResult<>(ActionResultType.PASS, itemstack);
					}
				}
			}

			if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
				FluidState fluidstate = world.getFluidState(new BlockPos(raytraceresult.getLocation()));
				if (fluidstate.isEmpty()) {
					PoScooterEntity entity = new PoScooterEntity(world, raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z);
					entity.yRot = player.yRot;
					if (!world.noCollision(entity, entity.getBoundingBox().inflate(-0.1D))) {
						return new ActionResult<>(ActionResultType.FAIL, itemstack);
					} else {
						if (!world.isClientSide) {
							world.addFreshEntity(entity);
						}
	
						if (!player.abilities.instabuild) {
							itemstack.shrink(1);
						}
	
						player.awardStat(Stats.ITEM_USED.get(this));
						return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
					}
				}
			}
			return new ActionResult<>(ActionResultType.PASS, itemstack);
		}
	}
}