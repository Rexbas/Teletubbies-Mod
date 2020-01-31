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
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;
import teletubbies.entity.EntityList;
import teletubbies.item.ItemList;

/* This class is based on @BoatEntity */
public class PoScooterEntity extends Entity {
	private static final DataParameter<Integer> TIME_SINCE_HIT = EntityDataManager.createKey(PoScooterEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> FORWARD_DIRECTION = EntityDataManager.createKey(PoScooterEntity.class, DataSerializers.VARINT);
	private static final DataParameter<Float> DAMAGE_TAKEN = EntityDataManager.createKey(PoScooterEntity.class, DataSerializers.FLOAT);
	private static final DataParameter<Integer> ROCKING_TICKS = EntityDataManager.createKey(PoScooterEntity.class, DataSerializers.VARINT);
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
		this.preventEntitySpawning = true;
		stepHeight = 1.0F;
		maxFallDistance = 5;
	}

	public PoScooterEntity(World world) {
		this(EntityList.PO_SCOOTER, world);
	}

	public PoScooterEntity(World worldIn, double x, double y, double z) {
		this(worldIn);
		this.setPosition(x, y, z);
		this.setMotion(Vec3d.ZERO);
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
	}

	@Override
	protected boolean canTriggerWalking() {
		return false;
	}

	@Override
	protected void registerData() {
		this.dataManager.register(TIME_SINCE_HIT, 0);
		this.dataManager.register(FORWARD_DIRECTION, 1);
		this.dataManager.register(DAMAGE_TAKEN, 0.0F);
		this.dataManager.register(ROCKING_TICKS, 0);
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBox(Entity entityIn) {
		return entityIn.canBePushed() ? entityIn.getBoundingBox() : null;
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox() {
		return this.getBoundingBox();
	}

	@Override
	public boolean canBePushed() {
		return true;
	}

	@Override
	public double getMountedYOffset() {
		return 0.6D;
	}

	@Override
	public boolean shouldRiderSit() {
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isInvulnerableTo(source)) {
			return false;
		} else if (!this.world.isRemote && this.isAlive()) {
			if (source instanceof IndirectEntityDamageSource && source.getTrueSource() != null && this.isPassenger(source.getTrueSource())) {
				return false;
			} else {
				this.setForwardDirection(-this.getForwardDirection());
				this.setTimeSinceHit(10);
				this.setDamageTaken(this.getDamageTaken() + amount * 10.0F);
				this.markVelocityChanged();
				boolean flag = source.getTrueSource() instanceof PlayerEntity && ((PlayerEntity) source.getTrueSource()).abilities.isCreativeMode;
				if (flag || this.getDamageTaken() > 40.0F) {
					if (!flag && this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
						this.entityDropItem(ItemList.PO_SCOOTER);
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
	public void applyEntityCollision(Entity entityIn) {
		if (entityIn instanceof PoScooterEntity) {
			if (entityIn.getBoundingBox().minY < this.getBoundingBox().maxY) {
				super.applyEntityCollision(entityIn);
			}
		} else if (entityIn.getBoundingBox().minY <= this.getBoundingBox().minY) {
			super.applyEntityCollision(entityIn);
		}

	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void performHurtAnimation() {
		this.setForwardDirection(-this.getForwardDirection());
		this.setTimeSinceHit(10);
		this.setDamageTaken(this.getDamageTaken() * 11.0F);
	}

	@Override
	public boolean canBeCollidedWith() {
		return this.isAlive();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
		this.lerpX = x;
		this.lerpY = y;
		this.lerpZ = z;
		this.lerpYaw = (double) yaw;
		this.lerpPitch = (double) pitch;
		this.lerpSteps = 10;
	}

	@Override
	public Direction getAdjustedHorizontalFacing() {
		return this.getHorizontalFacing().rotateY();
	}

	@Override
	public void tick() {
		if (!this.isInWater()) {
			this.outOfControlTicks = 0.0F;
		} else {
			++this.outOfControlTicks;
		}

		if (!this.world.isRemote && this.outOfControlTicks >= 60.0F) {
			this.removePassengers();
		}

		if (this.getTimeSinceHit() > 0) {
			this.setTimeSinceHit(this.getTimeSinceHit() - 1);
		}

		if (this.getDamageTaken() > 0.0F) {
			this.setDamageTaken(this.getDamageTaken() - 1.0F);
		}

		super.tick();
		this.tickLerp();
		if (this.canPassengerSteer()) {
			this.updateMotion();
			if (this.world.isRemote) {
				this.controlScooter();
			}

			this.move(MoverType.SELF, this.getMotion());
		} else {
			this.setMotion(Vec3d.ZERO);
		}

		this.updateRocking();

		this.doBlockCollisions();
		List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getBoundingBox().grow((double) 0.2F, (double) -0.01F, (double) 0.2F), EntityPredicates.pushableBy(this));
		if (!list.isEmpty()) {
			boolean flag = !this.world.isRemote && !(this.getControllingPassenger() instanceof PlayerEntity);

			for (int j = 0; j < list.size(); ++j) {
				Entity entity = list.get(j);
				if (!entity.isPassenger(this)) {
					if (flag && this.getPassengers().size() < 2 && !entity.isPassenger() && entity.getWidth() < this.getWidth()
							&& entity instanceof LivingEntity && !(entity instanceof WaterMobEntity) && !(entity instanceof PlayerEntity)) {
						entity.startRiding(this);
					} else {
						this.applyEntityCollision(entity);
					}
				}
			}
		}

	}

	private void updateRocking() {
		if (this.world.isRemote) {
			int i = this.getRockingTicks();
			if (i > 0) {
				this.rockingIntensity += 0.05F;
			} else {
				this.rockingIntensity -= 0.1F;
			}

			this.rockingIntensity = MathHelper.clamp(this.rockingIntensity, 0.0F, 1.0F);
			this.prevRockingAngle = this.rockingAngle;
			this.rockingAngle = 10.0F * (float) Math.sin((double) (0.5F * (float) this.world.getGameTime())) * this.rockingIntensity;
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
					Vec3d vec3d = this.getMotion();
					this.setMotion(vec3d.x, this.isPassenger(PlayerEntity.class) ? 2.7D : 0.6D, vec3d.z);
				}
				this.rocking = false;
			}
		}

	}

	private void tickLerp() {
		if (this.canPassengerSteer()) {
			this.lerpSteps = 0;
			this.setPacketCoordinates(this.getPosX(), this.getPosY(), this.getPosZ());
		}

		if (this.lerpSteps > 0) {
			double d0 = this.getPosX() + (this.lerpX - this.getPosX()) / (double) this.lerpSteps;
			double d1 = this.getPosY() + (this.lerpY - this.getPosY()) / (double) this.lerpSteps;
			double d2 = this.getPosZ() + (this.lerpZ - this.getPosZ()) / (double) this.lerpSteps;
			double d3 = MathHelper.wrapDegrees(this.lerpYaw - (double) this.rotationYaw);
			this.rotationYaw = (float) ((double) this.rotationYaw + d3 / (double) this.lerpSteps);
			this.rotationPitch = (float) ((double) this.rotationPitch + (this.lerpPitch - (double) this.rotationPitch) / (double) this.lerpSteps);
			--this.lerpSteps;
			this.setPosition(d0, d1, d2);
			this.setRotation(this.rotationYaw, this.rotationPitch);
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

		try (BlockPos.PooledMutable blockpos$pooledmutableblockpos = BlockPos.PooledMutable.retain()) {
			label161: for (int k1 = k; k1 < l; ++k1) {
				float f = 0.0F;

				for (int l1 = i; l1 < j; ++l1) {
					for (int i2 = i1; i2 < j1; ++i2) {
						blockpos$pooledmutableblockpos.setPos(l1, k1, i2);
						IFluidState ifluidstate = this.world.getFluidState(blockpos$pooledmutableblockpos);
						if (ifluidstate.isTagged(FluidTags.WATER)) {
							f = Math.max(f, ifluidstate.getActualHeight(this.world, blockpos$pooledmutableblockpos));
						}

						if (f >= 1.0F) {
							continue label161;
						}
					}
				}

				if (f < 1.0F) {
					float f2 = (float) blockpos$pooledmutableblockpos.getY() + f;
					return f2;
				}
			}

			float f1 = (float) (l + 1);
			return f1;
		}
	}

	private void updateMotion() {
		double d1 = this.hasNoGravity() ? 0.0D : (double) -0.04F;
		float f = 0.15F;
		Vec3d vec3d = this.getMotion();
		this.setMotion(vec3d.x * f, vec3d.y + d1, vec3d.z * f);
		this.deltaRotation *= f;
	}

	private void controlScooter() {
		if (this.isBeingRidden()) {
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
			this.rotationYaw += this.deltaRotation;
			if (this.forwardInputDown) {
				f += 0.4F; // Base speed
			}

			if (this.backInputDown) {
				f -= 0.05F;
			}

			this.setMotion(this.getMotion().add(Math.sin(-this.rotationYaw * (Math.PI / 180F)) * f, 0.0D, Math.cos(this.rotationYaw * (Math.PI / 180F)) * f));
		}
	}

	@Override
	public void updatePassenger(Entity passenger) {
		if (this.isPassenger(passenger)) {
			float f = 0.0F;
			float f1 = (float) ((!this.isAlive() ? (double) 0.01F : this.getMountedYOffset()) + passenger.getYOffset());
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

			Vec3d vec3d = (new Vec3d((double) f, 0.0D, 0.0D)).rotateYaw(-this.rotationYaw * ((float) Math.PI / 180F) - ((float) Math.PI / 2F));
			passenger.setPosition(this.getPosX() + vec3d.x, this.getPosY() + (double) f1, this.getPosZ() + vec3d.z);
			passenger.rotationYaw += this.deltaRotation;
			passenger.setRotationYawHead(passenger.getRotationYawHead() + this.deltaRotation);
			this.applyYawToEntity(passenger);
		}
	}

	protected void applyYawToEntity(Entity entityToUpdate) {
		entityToUpdate.setRenderYawOffset(this.rotationYaw);
		float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - this.rotationYaw);
		float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
		entityToUpdate.prevRotationYaw += f1 - f;
		entityToUpdate.rotationYaw += f1 - f;
		entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void applyOrientationToEntity(Entity entityToUpdate) {
		this.applyYawToEntity(entityToUpdate);
	}

	@Override
	protected void writeAdditional(CompoundNBT compound) {}

	@Override
	protected void readAdditional(CompoundNBT compound) {}

	@Override
	public boolean processInitialInteract(PlayerEntity player, Hand hand) {
		if (player.func_226563_dT_()) {
			return false;
		} else {
			return !this.world.isRemote && this.outOfControlTicks < 60.0F ? player.startRiding(this) : false;
		}
	}

	@Override
	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		this.lastYd = this.getMotion().y;
		if (!this.isPassenger()) {
			if (onGroundIn) {
				if (this.fallDistance > maxFallDistance) {
					this.onLivingFall(this.fallDistance, 1.0F);
					if (!this.world.isRemote && this.isAlive()) {
						this.remove();
						if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
							this.entityDropItem(ItemList.PO_SCOOTER);
						}
					}
				}

				this.fallDistance = 0.0F;
			} else if (!this.world.getFluidState((new BlockPos(this)).down()).isTagged(FluidTags.WATER) && y < 0.0D) {
				this.fallDistance = (float) ((double) this.fallDistance - y);
			}

		}
	}

	public void setDamageTaken(float damageTaken) {
		this.dataManager.set(DAMAGE_TAKEN, damageTaken);
	}

	public float getDamageTaken() {
		return this.dataManager.get(DAMAGE_TAKEN);
	}

	public void setTimeSinceHit(int timeSinceHit) {
		this.dataManager.set(TIME_SINCE_HIT, timeSinceHit);
	}

	public int getTimeSinceHit() {
		return this.dataManager.get(TIME_SINCE_HIT);
	}

	private void setRockingTicks(int p_203055_1_) {
		this.dataManager.set(ROCKING_TICKS, p_203055_1_);
	}

	private int getRockingTicks() {
		return this.dataManager.get(ROCKING_TICKS);
	}

	@OnlyIn(Dist.CLIENT)
	public float getRockingAngle(float partialTicks) {
		return MathHelper.lerp(partialTicks, this.prevRockingAngle, this.rockingAngle);
	}

	public void setForwardDirection(int forwardDirection) {
		this.dataManager.set(FORWARD_DIRECTION, forwardDirection);
	}

	public int getForwardDirection() {
		return this.dataManager.get(FORWARD_DIRECTION);
	}

	@Override
	protected boolean canFitPassenger(Entity passenger) {
		return this.getPassengers().size() < 1 && !this.areEyesInFluid(FluidTags.WATER);
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
	public IPacket<?> createSpawnPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void addPassenger(Entity passenger) {
		super.addPassenger(passenger);
		if (this.canPassengerSteer() && this.lerpSteps > 0) {
			this.lerpSteps = 0;
	         this.setPositionAndRotation(this.lerpX, this.lerpY, this.lerpZ, (float)this.lerpYaw, (float)this.lerpPitch);
		}
	}

	@Override
	public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(ItemList.PO_SCOOTER);
	}
}