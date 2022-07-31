<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
package teletubbies.entity.vehicle;
========
package com.rexbas.teletubbies.entity;
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java

import java.util.List;

import javax.annotation.Nullable;

<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
import net.minecraft.BlockUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fmllegacy.network.NetworkHooks;
import teletubbies.init.TeletubbiesEntityTypes;
import teletubbies.init.TeletubbiesItems;

/* This class is based on @BoatEntity */
public class PoScooterEntity extends Entity {
	private static final EntityDataAccessor<Integer> TIME_SINCE_HIT = SynchedEntityData.defineId(PoScooterEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Integer> FORWARD_DIRECTION = SynchedEntityData.defineId(PoScooterEntity.class, EntityDataSerializers.INT);
	private static final EntityDataAccessor<Float> DAMAGE_TAKEN = SynchedEntityData.defineId(PoScooterEntity.class, EntityDataSerializers.FLOAT);
	private float outOfControlTicks;
========
import com.rexbas.teletubbies.entity.passive.TeletubbyEntity;
import com.rexbas.teletubbies.init.TeletubbiesEntityTypes;
import com.rexbas.teletubbies.init.TeletubbiesItems;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

/* This class is based on @BoatEntity */
public class PoScooterEntity extends Entity {
	private static final DataParameter<Integer> DATA_ID_HURT = EntityDataManager.defineId(PoScooterEntity.class, DataSerializers.INT);
	private static final DataParameter<Integer> DATA_ID_HURTDIR = EntityDataManager.defineId(PoScooterEntity.class, DataSerializers.INT);
	private static final DataParameter<Float> DATA_ID_DAMAGE = EntityDataManager.defineId(PoScooterEntity.class, DataSerializers.FLOAT);
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
	private float deltaRotation;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpYRot;
	private double lerpXRot;
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
	private boolean leftInputDown;
	private boolean rightInputDown;
	private boolean forwardInputDown;
	private boolean backInputDown;
	private double lastYd;
========
	private boolean inputLeft;
	private boolean inputRight;
	private boolean inputUp;
	private boolean inputDown;
	private double lastYd;
	
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
	private float maxFallDistance;
	
	public PoScooterEntity(EntityType<? extends Entity> type, Level world) {
		super(type, world);
		this.blocksBuilding = true;
		maxUpStep = 1.0F;
		maxFallDistance = 5;
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
	
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
	/*@Override
========
	@Override
	protected float getEyeHeight(Pose pose, EntitySize entitySize) {
		return entitySize.height;
	}
	
	@Override
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
	protected boolean isMovementNoisy() {
		return false;
	}*/

	@Override
	protected void defineSynchedData() {
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
		this.entityData.define(TIME_SINCE_HIT, 0);
		this.entityData.define(FORWARD_DIRECTION, 1);
		this.entityData.define(DAMAGE_TAKEN, 0.0F);
========
		this.entityData.define(DATA_ID_HURT, 0);
		this.entityData.define(DATA_ID_HURTDIR, 1);
		this.entityData.define(DATA_ID_DAMAGE, 0.0F);
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
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
	protected Vec3 getRelativePortalPosition(Direction.Axis p_241839_1_, BlockUtil.FoundRectangle p_241839_2_) {
		return LivingEntity.resetForwardDirectionOfRelativePortalPosition(super.getRelativePortalPosition(p_241839_1_, p_241839_2_));
	}

	@Override
	public double getPassengersRidingOffset() {
		if (this.getControllingPassenger() != null) {
			if (this.getControllingPassenger() instanceof TeletubbyEntity) {
				return 0.25D;
			}
		}
		return 0.6D;
	}

	@Override
	public boolean shouldRiderSit() {
		return false;
	}
	
	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
		} else if (!this.level.isClientSide && this.isAlive()) {
			if (source instanceof IndirectEntityDamageSource && source.getEntity() != null && this.hasPassenger(source.getEntity())) {
				return false;
			} else {
				this.setForwardDirection(-this.getForwardDirection());
				this.setTimeSinceHit(10);
				this.setDamageTaken(this.getDamageTaken() + amount * 10.0F);
				this.markHurt();
				boolean flag = source.getEntity() instanceof Player && ((Player) source.getEntity()).getAbilities().instabuild;
				if (flag || this.getDamageTaken() > 40.0F) {
					if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
						this.spawnAtLocation(TeletubbiesItems.PO_SCOOTER.get());
					}

					this.discard();
========
		} else if (!this.level.isClientSide() && this.isAlive()) {
			this.setHurtDir(-this.getHurtDir());
			this.setHurtTime(10);
			this.setDamage(this.getDamage() + amount * 10.0F);
			this.markHurt();
			boolean flag = source.getEntity() instanceof PlayerEntity && ((PlayerEntity) source.getEntity()).abilities.instabuild;
			if (flag || this.getDamage() > 40.0F) {
				if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
					this.spawnAtLocation(TeletubbiesItems.PO_SCOOTER.get());
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
				}

				this.remove();
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

	@OnlyIn(Dist.CLIENT)
	public void animateHurt() {
		this.setHurtDir(-this.getHurtDir());
		this.setHurtTime(10);
		this.setDamage(this.getDamage() * 11.0F);
	}

	@Override
	public boolean isPickable() {
		return !this.isRemoved();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void lerpTo(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
		this.lerpX = x;
		this.lerpY = y;
		this.lerpZ = z;
		this.lerpYRot = (double) yaw;
		this.lerpXRot = (double) pitch;
		this.lerpSteps = 10;
	}

	@Override
	public Direction getMotionDirection() {
		return this.getDirection().getClockWise();
	}

	@Override
	public void tick() {
		if (this.isInWater() && !this.level.isClientSide()) {
			this.ejectPassengers();
			if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
				this.spawnAtLocation(TeletubbiesItems.PO_SCOOTER.get());
			}
			this.remove();
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
			if (this.getControllingPassenger() instanceof TeletubbyEntity) {
				TeletubbyEntity passenger = (TeletubbyEntity) this.getControllingPassenger();
				if (passenger.getNavigation().isInProgress()) {
					Vector3d viewVec = this.getViewVector(1);
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
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
		
========
	    
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
		this.checkInsideBlocks();
		List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate((double) 0.2F, (double) -0.01F, (double) 0.2F), EntitySelector.pushableBy(this));
		if (!list.isEmpty()) {
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
			boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof Player);
========
			boolean flag = !this.level.isClientSide() && !(this.getControllingPassenger() instanceof PlayerEntity);
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java

			for (int j = 0; j < list.size(); ++j) {
				Entity entity = list.get(j);
				if (!entity.hasPassenger(this)) {
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
					if (flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth()
							&& entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player)) {
========
					if (flag && this.getPassengers().size() < 1 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth() && entity instanceof LivingEntity && !(entity instanceof WaterMobEntity) && !(entity instanceof PlayerEntity)) {
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
						entity.startRiding(this);
					} else {
						this.push(entity);
					}
				}
			}
		}
	}

	private void tickLerp() {
		if (this.isControlledByLocalInstance()) {
			this.lerpSteps = 0;
			this.setPacketCoordinates(this.getX(), this.getY(), this.getZ());
		}

		if (this.lerpSteps > 0) {
			double d0 = this.getX() + (this.lerpX - this.getX()) / (double) this.lerpSteps;
			double d1 = this.getY() + (this.lerpY - this.getY()) / (double) this.lerpSteps;
			double d2 = this.getZ() + (this.lerpZ - this.getZ()) / (double) this.lerpSteps;
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
			double d3 = Mth.wrapDegrees(this.lerpYRot - (double) this.getYRot());
			this.setYRot(this.getYRot() + (float) d3 / (float) this.lerpSteps);
			this.setXRot(this.getXRot() + (float) (this.lerpXRot - (double) this.getXRot()) / (float) this.lerpSteps);
========
			double d3 = MathHelper.wrapDegrees(this.lerpYRot - (double) this.yRot);
			this.yRot = (float) ((double) this.yRot + d3 / (double) this.lerpSteps);
			this.xRot = (float) ((double) this.xRot + (this.lerpXRot - (double) this.xRot) / (double) this.lerpSteps);
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
			--this.lerpSteps;
			this.setPos(d0, d1, d2);
			this.setRot(this.getYRot(), this.getXRot());
		}
	}

	public float getWaterLevelAbove() {
		AABB axisalignedbb = this.getBoundingBox();
		int i = Mth.floor(axisalignedbb.minX);
		int j = Mth.ceil(axisalignedbb.maxX);
		int k = Mth.floor(axisalignedbb.maxY);
		int l = Mth.ceil(axisalignedbb.maxY - this.lastYd);
		int i1 = Mth.floor(axisalignedbb.minZ);
		int j1 = Mth.ceil(axisalignedbb.maxZ);
		BlockPos.MutableBlockPos blockpos$mutable = new BlockPos.MutableBlockPos();

		label39: for (int k1 = k; k1 < l; ++k1) {
			float f = 0.0F;

			for (int l1 = i; l1 < j; ++l1) {
				for (int i2 = i1; i2 < j1; ++i2) {
					blockpos$mutable.set(l1, k1, i2);
					FluidState fluidstate = this.level.getFluidState(blockpos$mutable);
					if (fluidstate.is(FluidTags.WATER)) {
						f = Math.max(f, fluidstate.getHeight(this.level, blockpos$mutable));
					}

					if (f >= 1.0F) {
						continue label39;
					}
				}
			}

			if (f < 1.0F) {
				return (float) blockpos$mutable.getY() + f;
			}
		}

		return (float) (l + 1);
	}

	private void updateMotion() {
		double d1 = this.isNoGravity() ? 0.0D : (double) -0.04F;
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
		float f = 0.15F;
		Vec3 Vector3d = this.getDeltaMovement();
		this.setDeltaMovement(Vector3d.x * f, Vector3d.y + d1, Vector3d.z * f);
		this.deltaRotation *= f;
========
		double invFriction = 0.05;
		Vector3d Vector3d = this.getDeltaMovement();
		this.setDeltaMovement(Vector3d.x * invFriction, Vector3d.y + d1, Vector3d.z * invFriction);
		this.deltaRotation *= invFriction;
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
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
			
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
			this.deltaRotation *= 3.33F;
			this.setYRot(this.getYRot() + this.deltaRotation);
			if (this.forwardInputDown) {
				f += 0.4F; // Base speed
========
			this.deltaRotation *= 3.33;
			this.yRot += this.deltaRotation;
			if (this.inputUp) {
				f += 0.6F; // Base speed
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
			}

			if (this.inputDown) {
				f -= 0.05F;
			}
			
			if (this.isInWater()) {
				f *= 0.25;
			}

<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
			this.setDeltaMovement(this.getDeltaMovement().add(Math.sin(-this.getYRot() * (Math.PI / 180F)) * f, 0.0D, Math.cos(this.getYRot() * (Math.PI / 180F)) * f));
========
			this.setDeltaMovement(this.getDeltaMovement().add(MathHelper.sin(-this.yRot * ((float) Math.PI / 180F)) * f, 0.0D, MathHelper.cos(this.yRot * ((float) Math.PI / 180F)) * f));
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
		}
	}

	@Override
	public void positionRider(Entity passenger) {
		if (this.hasPassenger(passenger)) {
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
			float f = 0.0F;
			float f1 = (float) ((this.isRemoved() ? (double) 0.01F : this.getPassengersRidingOffset()) + passenger.getMyRidingOffset());
			if (this.getPassengers().size() > 1) {
				int i = this.getPassengers().indexOf(passenger);
				if (i == 0) {
					f = 0.2F;
				} else {
					f = -0.6F;
				}

				if (passenger instanceof Animal) {
					f = (float) ((double) f + 0.2D);
				}
			}

			Vec3 vec3 = (new Vec3((double) f, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			passenger.setPos(this.getX() + vec3.x, this.getY() + (double) f1, this.getZ() + vec3.z);
			passenger.setYRot(passenger.getYRot() + this.deltaRotation);
			passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
			this.clampRotation(passenger);
			if (passenger instanceof Animal && this.getPassengers().size() > 1) {
				int j = passenger.getId() % 2 == 0 ? 90 : 270;
				passenger.setYBodyRot(((Animal) passenger).yBodyRot + (float) j);
				passenger.setYHeadRot(passenger.getYHeadRot() + (float) j);
			}
		}
	}

	protected void clampRotation(Entity entityToUpdate) {
		entityToUpdate.setYBodyRot(this.getYRot());
		float f = Mth.wrapDegrees(entityToUpdate.getYRot() - this.getYRot());
		float f1 = Mth.clamp(f, -105.0F, 105.0F);
		entityToUpdate.yRotO += f1 - f;
		entityToUpdate.setYRot(entityToUpdate.getYRot() + f1 - f);
		entityToUpdate.setYHeadRot(entityToUpdate.getYRot());
========
			float f1 = (float) ((!this.isAlive() ? (double) 0.01F : this.getPassengersRidingOffset()) + passenger.getMyRidingOffset());
			Vector3d vector3d = (new Vector3d(0.0D, 0.0D, 0.0D)).yRot(-this.yRot * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			passenger.setPos(this.getX() + vector3d.x, this.getY() + (double) f1, this.getZ() + vector3d.z);
			passenger.yRot += this.deltaRotation;
			passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
			this.clampRotation(passenger);
		}
	}

	protected void clampRotation(Entity entity) {
		entity.setYBodyRot(this.yRot);
		float f = MathHelper.wrapDegrees(entity.yRot - this.yRot);
		float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
		entity.yRotO += f1 - f;
		entity.yRot += f1 - f;
		entity.setYHeadRot(entity.yRot);
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
	}

	@OnlyIn(Dist.CLIENT)
	@Override
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
	public void onPassengerTurned(Entity entityToUpdate) {
		this.clampRotation(entityToUpdate);
========
	public void onPassengerTurned(Entity entity) {
		this.clampRotation(entity);
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {}

	@Override
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
	public InteractionResult interact(Player player, InteractionHand hand) {
		if (player.isShiftKeyDown()) {
			return InteractionResult.FAIL;
		} else {
			if (!this.level.isClientSide && this.outOfControlTicks < 60.0F) {
				if (player.startRiding(this)) return InteractionResult.PASS;
			}
		}
		return InteractionResult.FAIL;
========
	public ActionResultType interact(PlayerEntity player, Hand hand) {
		if (player.isSecondaryUseActive()) {
			return ActionResultType.PASS;
		} else {
			if (!this.level.isClientSide()) {
				if (this.getControllingPassenger() != null && !(this.getControllingPassenger() instanceof PlayerEntity)) {
					this.getControllingPassenger().stopRiding();
				}
				return player.startRiding(this) ? ActionResultType.CONSUME : ActionResultType.PASS;
			}
		}
		return ActionResultType.SUCCESS;
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
	}

	@Override
	protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {
		this.lastYd = this.getDeltaMovement().y;
		if (!this.isPassenger()) {
<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
			if (onGroundIn) {
				if (this.fallDistance > maxFallDistance) {
					
					this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
					if (!this.level.isClientSide && !this.isRemoved()) {
						this.kill();
========
			if (onGround) {
				if (this.fallDistance > this.maxFallDistance) {
					this.causeFallDamage(this.fallDistance, 1.0F);
					if (!this.level.isClientSide() && this.isAlive()) {
						this.remove();
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
						if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
							this.spawnAtLocation(TeletubbiesItems.PO_SCOOTER.get());
						}
					}
				}
				this.fallDistance = 0.0F;
			} else if (!this.level.getFluidState(this.blockPosition().below()).is(FluidTags.WATER) && y < 0.0D) {
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

<<<<<<<< HEAD:src/main/java/teletubbies/entity/vehicle/PoScooterEntity.java
	public void setForwardDirection(int forwardDirection) {
		this.entityData.set(FORWARD_DIRECTION, forwardDirection);
	}

	public int getForwardDirection() {
		return this.entityData.get(FORWARD_DIRECTION);
========
	public void setHurtDir(int p_70269_1_) {
		this.entityData.set(DATA_ID_HURTDIR, p_70269_1_);
	}

	public int getHurtDir() {
		return this.entityData.get(DATA_ID_HURTDIR);
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/entity/PoScooterEntity.java
	}

	@Override
	protected boolean canAddPassenger(Entity passenger) {
		if (passenger instanceof PlayerEntity || passenger instanceof TeletubbyEntity) {
			return this.getPassengers().size() < 1 && !this.isEyeInFluid(FluidTags.WATER);
		}
		return false;
	}

	@Nullable
	@Override
	public Entity getControllingPassenger() {
		List<Entity> list = this.getPassengers();
		return list.isEmpty() ? null : list.get(0);
	}

	public void setInput(boolean left, boolean right, boolean up, boolean down) {
		this.inputLeft = left;
		this.inputRight = right;
		this.inputUp = up;
		this.inputDown = down;
	}

	@Override
	public Packet<?> getAddEntityPacket() {
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