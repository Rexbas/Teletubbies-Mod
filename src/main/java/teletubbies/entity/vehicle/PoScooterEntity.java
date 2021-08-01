package teletubbies.entity.vehicle;

import java.util.List;

import javax.annotation.Nullable;

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
	private float deltaRotation;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpYRot;
	private double lerpXRot;
	private boolean leftInputDown;
	private boolean rightInputDown;
	private boolean forwardInputDown;
	private boolean backInputDown;
	private double lastYd;
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
	
	/*@Override
	protected boolean isMovementNoisy() {
		return false;
	}*/

	@Override
	protected void defineSynchedData() {
		this.entityData.define(TIME_SINCE_HIT, 0);
		this.entityData.define(FORWARD_DIRECTION, 1);
		this.entityData.define(DAMAGE_TAKEN, 0.0F);
	}
	
	@Override
	public boolean canCollideWith(Entity entity) {
		return canPushEntity(this, entity);
	}

	public static boolean canPushEntity(Entity p_242378_0_, Entity p_242378_1_) {
		return (p_242378_1_.canBeCollidedWith() || p_242378_1_.isPushable()) && !p_242378_0_.isPassengerOfSameVehicle(p_242378_1_);
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
				}

				return true;
			}
		} else {
			return true;
		}
	}

	@Override
	public void push(Entity entityIn) {
		if (entityIn instanceof PoScooterEntity) {
			if (entityIn.getBoundingBox().minY < this.getBoundingBox().maxY) {
				super.push(entityIn);
			}
		} else if (entityIn.getBoundingBox().minY <= this.getBoundingBox().minY) {
			super.push(entityIn);
		}

	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateHurt() {
		this.setForwardDirection(-this.getForwardDirection());
		this.setTimeSinceHit(10);
		this.setDamageTaken(this.getDamageTaken() * 11.0F);
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
		if (!this.isInWater()) {
			this.outOfControlTicks = 0.0F;
		} else {
			++this.outOfControlTicks;
		}

		if (!this.level.isClientSide && this.outOfControlTicks >= 60.0F) {
			this.ejectPassengers();
		}

		if (this.getTimeSinceHit() > 0) {
			this.setTimeSinceHit(this.getTimeSinceHit() - 1);
		}

		if (this.getDamageTaken() > 0.0F) {
			this.setDamageTaken(this.getDamageTaken() - 1.0F);
		}

		super.tick();
		this.tickLerp();
		if (this.isControlledByLocalInstance()) {
			this.updateMotion();
			if (this.level.isClientSide) {
				this.controlScooter();
			}

			this.move(MoverType.SELF, this.getDeltaMovement());
		} else {
			this.setDeltaMovement(Vec3.ZERO);
		}
		
		this.checkInsideBlocks();
		List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate((double) 0.2F, (double) -0.01F, (double) 0.2F), EntitySelector.pushableBy(this));
		if (!list.isEmpty()) {
			boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof Player);

			for (int j = 0; j < list.size(); ++j) {
				Entity entity = list.get(j);
				if (!entity.hasPassenger(this)) {
					if (flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth()
							&& entity instanceof LivingEntity && !(entity instanceof WaterAnimal) && !(entity instanceof Player)) {
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
			double d3 = Mth.wrapDegrees(this.lerpYRot - (double) this.getYRot());
			this.setYRot(this.getYRot() + (float) d3 / (float) this.lerpSteps);
			this.setXRot(this.getXRot() + (float) (this.lerpXRot - (double) this.getXRot()) / (float) this.lerpSteps);
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
		float f = 0.15F;
		Vec3 Vector3d = this.getDeltaMovement();
		this.setDeltaMovement(Vector3d.x * f, Vector3d.y + d1, Vector3d.z * f);
		this.deltaRotation *= f;
	}

	private void controlScooter() {
		if (this.isVehicle()) {
			float f = 0.0F;
			if (this.leftInputDown) {
				--this.deltaRotation;
			}

			if (this.rightInputDown) {
				++this.deltaRotation;
			}

			if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown) {
				f += 0.05F;
			}
			
			this.deltaRotation *= 3.33F;
			this.setYRot(this.getYRot()+ this.deltaRotation);
			if (this.forwardInputDown) {
				f += 0.4F; // Base speed
			}

			if (this.backInputDown) {
				f -= 0.05F;
			}

			this.setDeltaMovement(this.getDeltaMovement().add(Math.sin(-this.getYRot() * (Math.PI / 180F)) * f, 0.0D, Math.cos(this.getYRot() * (Math.PI / 180F)) * f));
		}
	}

	@Override
	public void positionRider(Entity passenger) {
		if (this.hasPassenger(passenger)) {
			float f = 0.0F;
			float f1 = (float) ((!this.isAlive() ? (double) 0.01F : this.getPassengersRidingOffset()) + passenger.getMyRidingOffset());
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

			Vec3 Vector3d = (new Vec3((double) f, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			passenger.setPos(this.getX() + Vector3d.x, this.getY() + (double) f1, this.getZ() + Vector3d.z);
			passenger.setYRot(this.getYRot() + this.deltaRotation);
			passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
			this.clampRotation(passenger);
		}
	}

	protected void clampRotation(Entity entityToUpdate) {
		entityToUpdate.setYBodyRot(this.getYRot());
		float f = Mth.wrapDegrees(entityToUpdate.getYRot() - this.getYRot());
		float f1 = Mth.clamp(f, -105.0F, 105.0F);
		entityToUpdate.yRotO += f1 - f;
		entityToUpdate.setYRot(entityToUpdate.getYRot() + f1 - f);
		entityToUpdate.setYHeadRot(entityToUpdate.getYRot());
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void onPassengerTurned(Entity entityToUpdate) {
		this.clampRotation(entityToUpdate);
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compound) {}

	@Override
	protected void readAdditionalSaveData(CompoundTag compound) {}

	@Override
	public InteractionResult interact(Player player, InteractionHand hand) {
		if (player.isShiftKeyDown()) {
			return InteractionResult.FAIL;
		} else {
			if (!this.level.isClientSide && this.outOfControlTicks < 60.0F) {
				if (player.startRiding(this)) return InteractionResult.PASS;
			}
		}
		return InteractionResult.FAIL;
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		this.lastYd = this.getDeltaMovement().y;
		if (!this.isPassenger()) {
			if (onGroundIn) {
				if (this.fallDistance > maxFallDistance) {
					
					this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
					if (!this.level.isClientSide && !this.isRemoved()) {
						this.kill();
						if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
							this.spawnAtLocation(TeletubbiesItems.PO_SCOOTER.get());
						}
					}
				}

				this.fallDistance = 0.0F;
			} else if (!this.level.getFluidState((this.blockPosition()).below()).is(FluidTags.WATER) && y < 0.0D) {
				this.fallDistance = (float) ((double) this.fallDistance - y);
			}

		}
	}

	public void setDamageTaken(float damageTaken) {
		this.entityData.set(DAMAGE_TAKEN, damageTaken);
	}

	public float getDamageTaken() {
		return this.entityData.get(DAMAGE_TAKEN);
	}

	public void setTimeSinceHit(int timeSinceHit) {
		this.entityData.set(TIME_SINCE_HIT, timeSinceHit);
	}

	public int getTimeSinceHit() {
		return this.entityData.get(TIME_SINCE_HIT);
	}

	public void setForwardDirection(int forwardDirection) {
		this.entityData.set(FORWARD_DIRECTION, forwardDirection);
	}

	public int getForwardDirection() {
		return this.entityData.get(FORWARD_DIRECTION);
	}

	@Override
	protected boolean canAddPassenger(Entity passenger) {
		return this.getPassengers().size() < 1 && !this.isEyeInFluid(FluidTags.WATER);
	}

	@Nullable
	@Override
	public Entity getControllingPassenger() {
		List<Entity> list = this.getPassengers();
		return list.isEmpty() ? null : list.get(0);
	}

	@OnlyIn(Dist.CLIENT)
	public void updateInputs(boolean p_184442_1_, boolean p_184442_2_, boolean p_184442_3_, boolean p_184442_4_) {
		this.leftInputDown = p_184442_1_;
		this.rightInputDown = p_184442_2_;
		this.forwardInputDown = p_184442_3_;
		this.backInputDown = p_184442_4_;
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