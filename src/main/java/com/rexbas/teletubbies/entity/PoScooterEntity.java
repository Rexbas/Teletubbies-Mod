package com.rexbas.teletubbies.entity;

import com.rexbas.teletubbies.entity.passive.TeletubbyEntity;
import com.rexbas.teletubbies.init.TeletubbiesEntityTypes;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

/* This class is based on @Boat */
public class PoScooterEntity extends Entity {
	private static final EntityDataAccessor<Integer> DATA_ID_HURT = SynchedEntityData.defineId(PoScooterEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> DATA_ID_HURTDIR = SynchedEntityData.defineId(PoScooterEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Float> DATA_ID_DAMAGE = SynchedEntityData.defineId(PoScooterEntity.class, EntityDataSerializers.FLOAT);
	private float deltaRotation;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpYRot;
	private double lerpXRot;
	private boolean inputLeft;
	private boolean inputRight;
	private boolean inputUp;
	private boolean inputDown;

	public PoScooterEntity(EntityType<? extends Entity> type, Level world) {
		super(type, world);
		this.blocksBuilding = true;
	}

	public PoScooterEntity(Level world) {
		this(TeletubbiesEntityTypes.PO_SCOOTER.get(), world);
	}

	public PoScooterEntity(Level worldIn, double x, double y, double z) {
		this(worldIn);
		this.setPos(x, y, z);
		this.setDeltaMovement(Vec3.ZERO);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}

	@Override
	public float getStepHeight() {
		return 1;
	}

	@Override
	protected float getEyeHeight(Pose pose, EntityDimensions entitySize) {
		return entitySize.height;
	}

	@Override
	protected Entity.@NotNull MovementEmission getMovementEmission() {
		return Entity.MovementEmission.NONE;
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(DATA_ID_HURT, 0);
		this.entityData.define(DATA_ID_HURTDIR, 1);
		this.entityData.define(DATA_ID_DAMAGE, 0.0F);
	}

	@Override
	public boolean canCollideWith(Entity entity) {
		return canVehicleCollide(this, entity);
	}

	public static boolean canVehicleCollide(Entity scooter, Entity entity) {
		return (entity.canBeCollidedWith() || entity.isPushable()) && !scooter.isPassengerOfSameVehicle(entity);
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	@Override
	public boolean isPushable() {
		return true;
	}

	@Override
	protected @NotNull Vec3 getRelativePortalPosition(Direction.Axis p_241839_1_, BlockUtil.FoundRectangle p_241839_2_) {
		return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(p_241839_1_, p_241839_2_));
	}

	@Override
	public float ridingOffset(Entity entity) {
		if (this.getControllingPassenger() != null) {
			if (this.getControllingPassenger() instanceof TeletubbyEntity) {
				return 0.25F;
			}
		}
		return 0.85F;
	}

	@Override
	public boolean shouldRiderSit() {
		return false;
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else if (!this.level().isClientSide() && this.isAlive()) {
			this.setHurtDir(-this.getHurtDir());
			this.setHurtTime(10);
			this.setDamage(this.getDamage() + amount * 10.0F);
			this.markHurt();
			boolean flag = source.getEntity() instanceof Player && ((Player) source.getEntity()).getAbilities().instabuild;
			if (flag || this.getDamage() > 40.0F) {
				if (!flag && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
					this.spawnAtLocation(TeletubbiesItems.PO_SCOOTER.get());
				}

				this.discard();
			}
			return true;
		} else {
			return true;
		}
	}

	@Override
	public void push(Entity entity) {
		if (entity instanceof PoScooterEntity) {
			if (entity.getBoundingBox().minY < this.getBoundingBox().maxY) {
				super.push(entity);
			}
		} else if (entity.getBoundingBox().minY <= this.getBoundingBox().minY) {
			super.push(entity);
		}
	}

	@Override
	public boolean isPickable() {
		return !this.isRemoved();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void lerpTo(double x, double y, double z, float yaw, float pitch, int posRotationIncrements) {
		this.lerpX = x;
		this.lerpY = y;
		this.lerpZ = z;
		this.lerpYRot = yaw;
		this.lerpXRot = pitch;
		this.lerpSteps = 10;
	}

	@Override
	public @NotNull Direction getMotionDirection() {
		return this.getDirection().getClockWise();
	}

	@Override
	public void tick() {
		if (this.isInWater() && !this.level().isClientSide()) {
			this.ejectPassengers();
			if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
				this.spawnAtLocation(TeletubbiesItems.PO_SCOOTER.get());
			}
			this.discard();
		}

		if (this.getHurtTime() > 0) {
			this.setHurtTime(this.getHurtTime() - 1);
		}

		if (this.getDamage() > 0.0F) {
			this.setDamage(this.getDamage() - 1.0F);
		}

		super.tick();
		this.tickLerp();
		if (this.isControlledByLocalInstance()) {
			// Positive Z is 0 deg
			// Positive X is -90 deg
			// Clockwise for positive angle
			if (this.getControllingPassenger() instanceof TeletubbyEntity passenger) {
				if (passenger.getNavigation().isInProgress()) {
					Vec3 viewVec = this.getViewVector(1);
					double viewAngle = -Math.atan2(viewVec.x(), viewVec.z());
					double relativeWantedX = passenger.getMoveControl().getWantedX() - passenger.position().x();
					double relativeWantedZ = passenger.getMoveControl().getWantedZ() - passenger.position().z();
					double wantedAngle = -Math.atan2(relativeWantedX, relativeWantedZ);
					double rotationError = wantedAngle - viewAngle;
					if (rotationError > Math.PI) {
						rotationError -= 2 * Math.PI;
					}
					if (rotationError < -Math.PI) {
						rotationError += 2 * Math.PI;
					}

					boolean right = rotationError > 0;
					boolean forward = Math.abs(rotationError) < 0.25 * Math.PI;
					this.setInput(!right, right, forward, false);
				}
				else {
					this.setInput(false, false, false, false);
				}
			}
			this.updateMotion();
			this.controlScooter();
			this.move(MoverType.SELF, this.getDeltaMovement());
		} else {
			this.setDeltaMovement(Vec3.ZERO);
		}

		this.checkInsideBlocks();
		List<Entity> list = this.level().getEntities(this, this.getBoundingBox().inflate(0.2F, -0.01F, 0.2F), EntitySelector.pushableBy(this));
		if (!list.isEmpty()) {
			boolean flag = !this.level().isClientSide() && !(this.getControllingPassenger() instanceof Player);

			for (Entity entity : list) {
				if (!entity.hasPassenger(this)) {
					if (flag && this.getPassengers().size() < 1 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player)) {
						entity.startRiding(this);
					}
					else {
						this.push(entity);
					}
				}
			}
		}
	}

	private void tickLerp() {
		if (this.isControlledByLocalInstance()) {
			this.lerpSteps = 0;
			this.syncPacketPositionCodec(this.getX(), this.getY(), this.getZ());
		}

		if (this.lerpSteps > 0) {
			double d0 = this.getX() + (this.lerpX - this.getX()) / (double) this.lerpSteps;
			double d1 = this.getY() + (this.lerpY - this.getY()) / (double) this.lerpSteps;
			double d2 = this.getZ() + (this.lerpZ - this.getZ()) / (double) this.lerpSteps;
			double d3 = Mth.wrapDegrees(this.lerpYRot - (double) this.getYRot());

			this.setYRot(this.getYRot() + (float) d3 / (float) this.lerpSteps);
			this.setXRot(this.getXRot() + (float) (this.lerpXRot - (double) this.getXRot()) / (float) this.lerpSteps);
			--this.lerpSteps;
			this.setPos(d0, d1, d2);
			this.setRot(this.getYRot(), this.getXRot());
		}
	}

	private void updateMotion() {
		double d1 = this.isNoGravity() ? 0.0D : (double) -0.04F;
		double invFriction = 0.05;
		Vec3 vec3 = this.getDeltaMovement();
		this.setDeltaMovement(vec3.x * invFriction, vec3.y + d1, vec3.z * invFriction);
		this.deltaRotation *= invFriction;
	}

	private void controlScooter() {
		if (this.isVehicle()) {
			float f = 0.0F;
			if (this.inputLeft) {
				this.deltaRotation -= 1.5;
			}

			if (this.inputRight) {
				this.deltaRotation += 1.5;
			}

			if (this.inputRight != this.inputLeft && !this.inputUp && !this.inputDown) {
				f += 0.005F;
			}

			this.deltaRotation *= 3.33;
			this.setYRot(this.getYRot() + this.deltaRotation);
			if (this.inputUp) {
				f += 0.6F; // Base speed
			}

			if (this.inputDown) {
				f -= 0.05F;
			}

			if (this.isInWater()) {
				f *= 0.25;
			}

			this.setDeltaMovement(this.getDeltaMovement().add(Math.sin(-this.getYRot() * (Math.PI / 180F)) * f, 0.0D, Math.cos(this.getYRot() * (Math.PI / 180F)) * f));
		}
	}

	@Override
	public void positionRider(Entity passenger, Entity.MoveFunction moveFunction) {
		if (this.hasPassenger(passenger)) {
			float f1 = (float) ((!this.isAlive() ? (double) 0.01F : this.ridingOffset(passenger)) + passenger.getMyRidingOffset(passenger));
			Vec3 vec3 = (new Vec3(0.0D, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			passenger.setPos(this.getX() + vec3.x, this.getY() + (double) f1, this.getZ() + vec3.z);
			passenger.setYRot(passenger.getYRot() + this.deltaRotation);
			passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
			this.clampRotation(passenger);

			double d0 = this.getY() + this.ridingOffset(passenger) + passenger.getMyRidingOffset(passenger);
			moveFunction.accept(passenger, this.getX(), d0, this.getZ());
		}
	}

	protected void clampRotation(Entity entity) {
		entity.setYBodyRot(this.getYRot());
		float f = Mth.wrapDegrees(entity.getYRot() - this.getYRot());
		float f1 = Mth.clamp(f, -105.0F, 105.0F);
		entity.yRotO += f1 - f;
		entity.setYRot(entity.getYRot() + f1 - f);
		entity.setYHeadRot(entity.getYRot());
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void onPassengerTurned(Entity entity) {
		this.clampRotation(entity);
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {}

	@Override
	public @NotNull InteractionResult interact(Player player, InteractionHand hand) {
		if (player.isSecondaryUseActive()) {
			return InteractionResult.PASS;
		} else {
			if (!this.level().isClientSide()) {
				if (this.getControllingPassenger() != null && !(this.getControllingPassenger() instanceof Player)) {
					this.getControllingPassenger().stopRiding();
				}
				return player.startRiding(this) ? InteractionResult.CONSUME : InteractionResult.PASS;
			}
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
		if (!this.isPassenger()) {
			if (onGround) {
				float maxFallDistance = 5;
				if (this.fallDistance > maxFallDistance) {
					this.causeFallDamage(this.fallDistance, 1.0F, this.damageSources().fall());
					if (!this.level().isClientSide() && this.isAlive()) {
						this.discard();
						if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
							this.spawnAtLocation(TeletubbiesItems.PO_SCOOTER.get());
						}
					}
				}
				this.fallDistance = 0.0F;
			} else if (!this.level().getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && y < 0.0D) {
				this.fallDistance = (float) ((double) this.fallDistance - y);
			}
		}
	}

	public void setDamage(float damage) {
		this.entityData.set(DATA_ID_DAMAGE, damage);
	}

	public float getDamage() {
		return this.entityData.get(DATA_ID_DAMAGE);
	}

	public void setHurtTime(int hurtTime) {
		this.entityData.set(DATA_ID_HURT, hurtTime);
	}

	public int getHurtTime() {
		return this.entityData.get(DATA_ID_HURT);
	}

	public void setHurtDir(int p_70269_1_) {
		this.entityData.set(DATA_ID_HURTDIR, p_70269_1_);
	}

	public int getHurtDir() {
		return this.entityData.get(DATA_ID_HURTDIR);
	}

	@Override
	protected boolean canAddPassenger(Entity passenger) {
		if (passenger instanceof Player || passenger instanceof TeletubbyEntity) {
			return this.getPassengers().size() < 1 && !this.isEyeInFluid(FluidTags.WATER);
		}
		return false;
	}

	@Nullable
	@Override
	public LivingEntity getControllingPassenger() {
		List<Entity> passengers = this.getPassengers();
		for (Entity entity : passengers) {
			if (entity instanceof LivingEntity livingEntity) {
				return livingEntity;
			}
		}
		return null;
	}

	public void setInput(boolean left, boolean right, boolean up, boolean down) {
		this.inputLeft = left;
		this.inputRight = right;
		this.inputUp = up;
		this.inputDown = down;
	}

	@Override
	public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void addPassenger(Entity passenger) {
		super.addPassenger(passenger);
		if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
			this.lerpSteps = 0;
			this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float)this.lerpYRot, (float)this.lerpXRot);
		}
	}

	@Override
	public ItemStack getPickedResult(HitResult target) {
		return new ItemStack(TeletubbiesItems.PO_SCOOTER.get());
	}
}