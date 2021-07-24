package teletubbies.entity.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.passive.AnimalEntity;
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
import net.minecraft.util.IndirectEntityDamageSource;
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
import teletubbies.init.TeletubbiesEntityTypes;
import teletubbies.init.TeletubbiesItems;

/* This class is based on @BoatEntity */
public class PoScooterEntity extends Entity {
	private static final DataParameter<Integer> TIME_SINCE_HIT = EntityDataManager.defineId(PoScooterEntity.class, DataSerializers.INT);
	private static final DataParameter<Integer> FORWARD_DIRECTION = EntityDataManager.defineId(PoScooterEntity.class, DataSerializers.INT);
	private static final DataParameter<Float> DAMAGE_TAKEN = EntityDataManager.defineId(PoScooterEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Integer> ROCKING_TICKS = EntityDataManager.defineId(PoScooterEntity.class, DataSerializers.INT);
	private float outOfControlTicks;
	private float deltaRotation;
	private int lerpSteps;
	private double lerpX;
	private double lerpY;
	private double lerpZ;
	private double lerpYaw;
	private double lerpPitch;
	private boolean leftInputDown;
	private boolean rightInputDown;
	private boolean forwardInputDown;
	private boolean backInputDown;
	private double lastYd;
	private boolean rocking;
	private float rockingIntensity;
	private float rockingAngle;
	private float prevRockingAngle;
	private float maxFallDistance;
	
	public PoScooterEntity(EntityType<? extends Entity> type, World world) {
		super(type, world);
		this.blocksBuilding = true;
		maxUpStep = 1.0F;
		maxFallDistance = 5;
	}

	public PoScooterEntity(World world) {
		this(TeletubbiesEntityTypes.PO_SCOOTER.get(), world);
	}

	public PoScooterEntity(World worldIn, double x, double y, double z) {
		this(worldIn);
		this.setPos(x, y, z);
		this.setDeltaMovement(Vector3d.ZERO);
		this.xo = x;
		this.yo = y;
		this.zo = z;
	}
	
	@Override
	protected boolean isMovementNoisy() {
		return false;
	}

	@Override
	protected void defineSynchedData() {
		this.entityData.define(TIME_SINCE_HIT, 0);
		this.entityData.define(FORWARD_DIRECTION, 1);
		this.entityData.define(DAMAGE_TAKEN, 0.0F);
		this.entityData.define(ROCKING_TICKS, 0);
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
	protected Vector3d getRelativePortalPosition(Direction.Axis p_241839_1_, TeleportationRepositioner.Result p_241839_2_) {
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
				boolean flag = source.getEntity() instanceof PlayerEntity && ((PlayerEntity) source.getEntity()).abilities.instabuild;
				if (flag || this.getDamageTaken() > 40.0F) {
					if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
						this.spawnAtLocation(TeletubbiesItems.PO_SCOOTER.get());
					}

					this.remove();
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
		return this.isAlive();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void lerpTo(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
		this.lerpX = x;
		this.lerpY = y;
		this.lerpZ = z;
		this.lerpYaw = (double) yaw;
		this.lerpPitch = (double) pitch;
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
			this.setDeltaMovement(Vector3d.ZERO);
		}

		this.updateRocking();

		this.checkInsideBlocks();
		List<Entity> list = this.level.getEntities(this, this.getBoundingBox().inflate((double) 0.2F, (double) -0.01F, (double) 0.2F), EntityPredicates.pushableBy(this));
		if (!list.isEmpty()) {
			boolean flag = !this.level.isClientSide && !(this.getControllingPassenger() instanceof PlayerEntity);

			for (int j = 0; j < list.size(); ++j) {
				Entity entity = list.get(j);
				if (!entity.hasPassenger(this)) {
					if (flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getBbWidth() < this.getBbWidth()
							&& entity instanceof LivingEntity && !(entity instanceof WaterMobEntity) && !(entity instanceof PlayerEntity)) {
						entity.startRiding(this);
					} else {
						this.push(entity);
					}
				}
			}
		}

	}

	private void updateRocking() {
		if (this.level.isClientSide) {
			int i = this.getRockingTicks();
			if (i > 0) {
				this.rockingIntensity += 0.05F;
			} else {
				this.rockingIntensity -= 0.1F;
			}

			this.rockingIntensity = MathHelper.clamp(this.rockingIntensity, 0.0F, 1.0F);
			this.prevRockingAngle = this.rockingAngle;
			this.rockingAngle = 10.0F * (float) Math.sin((double) (0.5F * (float) this.level.getGameTime())) * this.rockingIntensity;
		} else {
			if (!this.rocking) {
				this.setRockingTicks(0);
			}

			int k = this.getRockingTicks();
			if (k > 0) {
				--k;
				this.setRockingTicks(k);
				int j = 60 - k - 1;
				if (j > 0 && k == 0) {
					this.setRockingTicks(0);
					Vector3d Vector3d = this.getDeltaMovement();
					this.setDeltaMovement(Vector3d.x, this.hasPassenger(PlayerEntity.class) ? 2.7D : 0.6D, Vector3d.z);
				}
				this.rocking = false;
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
			double d3 = MathHelper.wrapDegrees(this.lerpYaw - (double) this.yRot);
			this.yRot = (float) ((double) this.yRot + d3 / (double) this.lerpSteps);
			this.xRot = (float) ((double) this.xRot + (this.lerpPitch - (double) this.xRot) / (double) this.lerpSteps);
			--this.lerpSteps;
			this.setPos(d0, d1, d2);
			this.setRot(this.yRot, this.xRot);
		}
	}

	public float getWaterLevelAbove() {
		AxisAlignedBB axisalignedbb = this.getBoundingBox();
		int i = MathHelper.floor(axisalignedbb.minX);
		int j = MathHelper.ceil(axisalignedbb.maxX);
		int k = MathHelper.floor(axisalignedbb.maxY);
		int l = MathHelper.ceil(axisalignedbb.maxY - this.lastYd);
		int i1 = MathHelper.floor(axisalignedbb.minZ);
		int j1 = MathHelper.ceil(axisalignedbb.maxZ);
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

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
		Vector3d Vector3d = this.getDeltaMovement();
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
			this.yRot += this.deltaRotation;
			if (this.forwardInputDown) {
				f += 0.4F; // Base speed
			}

			if (this.backInputDown) {
				f -= 0.05F;
			}

			this.setDeltaMovement(this.getDeltaMovement().add(Math.sin(-this.yRot * (Math.PI / 180F)) * f, 0.0D, Math.cos(this.yRot * (Math.PI / 180F)) * f));
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
				
				if (passenger instanceof AnimalEntity) {
					f = (float) ((double) f + 0.2D);
				}
			}

			Vector3d Vector3d = (new Vector3d((double) f, 0.0D, 0.0D)).yRot(-this.yRot * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			passenger.setPos(this.getX() + Vector3d.x, this.getY() + (double) f1, this.getZ() + Vector3d.z);
			passenger.yRot += this.deltaRotation;
			passenger.setYHeadRot(passenger.getYHeadRot() + this.deltaRotation);
			this.applyYawToEntity(passenger);
		}
	}

	protected void applyYawToEntity(Entity entityToUpdate) {
		entityToUpdate.setYBodyRot(this.yRot);
		float f = MathHelper.wrapDegrees(entityToUpdate.yRot - this.yRot);
		float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
		entityToUpdate.yRotO += f1 - f;
		entityToUpdate.yRot += f1 - f;
		entityToUpdate.setYHeadRot(entityToUpdate.yRot);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void onPassengerTurned(Entity entityToUpdate) {
		this.applyYawToEntity(entityToUpdate);
	}

	@Override
	protected void addAdditionalSaveData(CompoundNBT compound) {}

	@Override
	protected void readAdditionalSaveData(CompoundNBT compound) {}

	@Override
	public ActionResultType interact(PlayerEntity player, Hand hand) {
		if (player.isShiftKeyDown()) {
			return ActionResultType.FAIL;
		} else {
			if (!this.level.isClientSide && this.outOfControlTicks < 60.0F) {
				if (player.startRiding(this)) return ActionResultType.PASS;
			}
		}
		return ActionResultType.FAIL;
	}

	@Override
	protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		this.lastYd = this.getDeltaMovement().y;
		if (!this.isPassenger()) {
			if (onGroundIn) {
				if (this.fallDistance > maxFallDistance) {
					this.causeFallDamage(this.fallDistance, 1.0F);
					if (!this.level.isClientSide && this.isAlive()) {
						this.remove();
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

	private void setRockingTicks(int p_203055_1_) {
		this.entityData.set(ROCKING_TICKS, p_203055_1_);
	}

	private int getRockingTicks() {
		return this.entityData.get(ROCKING_TICKS);
	}

	@OnlyIn(Dist.CLIENT)
	public float getRockingAngle(float partialTicks) {
		return MathHelper.lerp(partialTicks, this.prevRockingAngle, this.rockingAngle);
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
	public IPacket<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void addPassenger(Entity passenger) {
		super.addPassenger(passenger);
		if (this.isControlledByLocalInstance() && this.lerpSteps > 0) {
			this.lerpSteps = 0;
	         this.absMoveTo(this.lerpX, this.lerpY, this.lerpZ, (float)this.lerpYaw, (float)this.lerpPitch);
		}
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(TeletubbiesItems.PO_SCOOTER.get());
	}
}