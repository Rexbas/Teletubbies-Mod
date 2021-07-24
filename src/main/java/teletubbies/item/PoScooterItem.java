package teletubbies.item;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.entity.item.PoScooterEntity;

public class PoScooterItem extends Item {
	private static final Predicate<Entity> ENTITY_PREDICATE = EntityPredicates.NO_SPECTATORS.and(Entity::isPickable);

	public PoScooterItem() {
		super(new Item.Properties()
				.stacksTo(1)
				.tab(Teletubbies.ITEMGROUP));
	}

	@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		RayTraceResult raytraceresult = getPlayerPOVHitResult(worldIn, playerIn, RayTraceContext.FluidMode.ANY);
		if (raytraceresult.getType() == RayTraceResult.Type.MISS) {
			return new ActionResult<>(ActionResultType.PASS, itemstack);
		} else {
			Vector3d vec3d = playerIn.getViewVector(1.0F);
			List<Entity> list = worldIn.getEntities(playerIn,
					playerIn.getBoundingBox().expandTowards(vec3d.scale(5.0D)).inflate(1.0D), ENTITY_PREDICATE);
			if (!list.isEmpty()) {
				Vector3d vec3d1 = playerIn.getEyePosition(1.0F);

				for (Entity entity : list) {
					AxisAlignedBB axisalignedbb = entity.getBoundingBox()
							.inflate((double) entity.getPickRadius());
					if (axisalignedbb.contains(vec3d1)) {
						return new ActionResult<>(ActionResultType.PASS, itemstack);
					}
				}
			}

			if (raytraceresult.getType() == RayTraceResult.Type.BLOCK) {
				PoScooterEntity entity = new PoScooterEntity(worldIn, raytraceresult.getLocation().x,
						raytraceresult.getLocation().y, raytraceresult.getLocation().z);
				entity.yRot = playerIn.yRot;
				if (!worldIn.noCollision(entity, entity.getBoundingBox().inflate(-0.1D))) {
					return new ActionResult<>(ActionResultType.FAIL, itemstack);
				} else {
					if (!worldIn.isClientSide) {
						worldIn.addFreshEntity(entity);
					}

					if (!playerIn.abilities.instabuild) {
						itemstack.shrink(1);
					}

					playerIn.awardStat(Stats.ITEM_USED.get(this));
					return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
				}
			} else {
				return new ActionResult<>(ActionResultType.PASS, itemstack);
			}
		}
	}
}
