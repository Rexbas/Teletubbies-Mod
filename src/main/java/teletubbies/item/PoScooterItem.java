package teletubbies.item;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import teletubbies.Teletubbies;
import teletubbies.entity.item.PoScooterEntity;

public class PoScooterItem extends Item {
	private static final Predicate<Entity> ENTITY_PREDICATE = EntitySelector.NO_SPECTATORS.and(Entity::isPickable);

	public PoScooterItem() {
		super(new Item.Properties()
				.stacksTo(1)
				.tab(Teletubbies.ITEMGROUP));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		HitResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, ClipContext.Fluid.ANY);
		if (raytraceresult.getType() == HitResult.Type.MISS) {
			return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
		} else {
			Vec3 vec3d = playerIn.getViewVector(1.0F);
			List<Entity> list = worldIn.getEntities(playerIn,
					playerIn.getBoundingBox().expandTowards(vec3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
			if (!list.isEmpty()) {
				Vec3 vec3d1 = playerIn.getEyePosition(1.0F);

				for (Entity entity : list) {
					AABB axisalignedbb = entity.getBoundingBox()
							.inflate((double) entity.getPickRadius());
					if (axisalignedbb.contains(vec3d1)) {
						return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
					}
				}
			}

			if (raytraceresult.getType() == HitResult.Type.BLOCK) {
				PoScooterEntity entity = new PoScooterEntity(worldIn, raytraceresult.getLocation().x,
						raytraceresult.getLocation().y, raytraceresult.getLocation().z);
				entity.yRot = playerIn.yRot;
				if (!worldIn.noCollision(entity, entity.getBoundingBox().inflate(-0.1D))) {
					return new InteractionResultHolder<>(InteractionResult.FAIL, itemstack);
				} else {
					if (!worldIn.isClientSide) {
						worldIn.addFreshEntity(entity);
					}

					if (!playerIn.abilities.instabuild) {
						itemstack.shrink(1);
					}

					playerIn.awardStat(Stats.ITEM_USED.get(this));
					return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);
				}
			} else {
				return new InteractionResultHolder<>(InteractionResult.PASS, itemstack);
			}
		}
	}
}
