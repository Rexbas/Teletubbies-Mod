package com.rexbas.teletubbies.item;

import com.rexbas.teletubbies.entity.PoScooterEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Predicate;

public class PoScooterItem extends Item {
	private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);

	public PoScooterItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
		ItemStack itemstack = player.getItemInHand(hand);
		HitResult raytraceresult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.ANY);
		if (raytraceresult.getType() != HitResult.Type.MISS) {
			Vec3 vec3d = player.getViewVector(1.0F);
			List<Entity> list = level.getEntities(player, player.getBoundingBox().expandTowards(vec3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
			if (!list.isEmpty()) {
				Vec3 vec3d1 = player.getEyePosition(1.0F);

				for (Entity entity : list) {
					AABB axisalignedbb = entity.getBoundingBox().inflate(entity.getPickRadius());
					if (axisalignedbb.contains(vec3d1)) {
						return InteractionResultHolder.pass(itemstack);
					}
				}
			}

			if (raytraceresult.getType() == HitResult.Type.BLOCK) {
				FluidState fluidstate = level.getFluidState(BlockPos.containing(raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z));
				if (fluidstate.isEmpty()) {
					PoScooterEntity entity = new PoScooterEntity(level, raytraceresult.getLocation().x, raytraceresult.getLocation().y, raytraceresult.getLocation().z);
					entity.setYRot(player.getYRot());
					if (!level.noCollision(entity, entity.getBoundingBox().inflate(-0.1D))) {
						return InteractionResultHolder.fail(itemstack);
					}
					else {
						if (!level.isClientSide()) {
							level.addFreshEntity(entity);
						}

						if (!player.getAbilities().instabuild) {
							itemstack.shrink(1);
						}

						player.awardStat(Stats.ITEM_USED.get(this));
						return InteractionResultHolder.success(itemstack);
					}
				}
			}
		}
		return InteractionResultHolder.pass(itemstack);
	}
}