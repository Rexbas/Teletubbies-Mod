package teletubbies.vehicle;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class EntityPoScooter extends EntityLiving {

	protected static final AxisAlignedBB BOX = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 5.0, 1.0);

	public EntityPoScooter(World worldIn) {
		super(worldIn);
		this.preventEntitySpawning = true;
		this.stepHeight = 1;
		this.setSize(1F, 1.45F);
	}

	public EntityPoScooter(World worldIn, double x, double y, double z) {
		this(worldIn);
		this.setPosition(x, y, z);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = x;
		this.prevPosY = y;
		this.prevPosZ = z;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn) {
		//do nothing
	}

	@Override
	public double getMountedYOffset() {
		return 0.6d;
	}

	@Override
	public boolean shouldRiderSit() {
		return false;
	}

	@Nullable
	public Entity getControllingPassenger() {
		return this.getPassengers().isEmpty() ? null : (Entity) this.getPassengers().get(0);
	}

	public boolean canBeSteered() {
		Entity entity = this.getControllingPassenger();
		return entity instanceof EntityPlayer ? true : false;
	}

	public boolean processInteract(EntityPlayer player, EnumHand hand) {
		if (!super.processInteract(player, hand)) {
			ItemStack itemstack = player.getHeldItem(hand);

			if (!this.isBeingRidden()) {
				player.rotationYaw = this.rotationYaw;
				player.rotationPitch = this.rotationPitch;
				if (!this.world.isRemote) {
					player.startRiding(this);
				}
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return true;
		}
	}

	public void travel(float strafe, float unknown, float forward) {
		if (this.isBeingRidden() && this.canBeSteered()) {
			EntityLivingBase entitylivingbase = (EntityLivingBase) this.getControllingPassenger();
			this.rotationYaw = entitylivingbase.rotationYaw;
			this.prevRotationYaw = this.rotationYaw;
			this.rotationPitch = entitylivingbase.rotationPitch * 0.5F;
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.renderYawOffset = this.rotationYaw;
			this.rotationYawHead = this.renderYawOffset;
			strafe = entitylivingbase.moveStrafing * 0.5F;
			forward = entitylivingbase.moveForward;
			
			if (forward <= 0.0F) {
				forward *= 0.25F;
			}

			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

			if (this.canPassengerSteer()) {
				this.setAIMoveSpeed(0.225f);
				super.travel(strafe, unknown, forward);
			}
			else if (entitylivingbase instanceof EntityPlayer) {
				this.motionX = 0.0D;
				this.motionY = 0.0D;
				this.motionZ = 0.0D;
			}

			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d1 = this.posX - this.prevPosX;
			double d0 = this.posZ - this.prevPosZ;
			float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

			if (f2 > 1.0F) {
				f2 = 1.0F;
			}

			this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		}
		else {
			this.jumpMovementFactor = 0.02F;
			super.travel(strafe, unknown, forward);
		}
	}

	public boolean attackEntityFrom(DamageSource source, float amount) {
		if (this.isEntityInvulnerable(source)) {
			return false;
		}
		else if (!this.world.isRemote && !this.isDead) {
			if (source instanceof EntityDamageSourceIndirect && source.getTrueSource() != null && this.isPassenger(source.getTrueSource())) {
				return false;
			}
			else {
				this.setBeenAttacked();
				boolean flag = source.getTrueSource() instanceof EntityPlayer && ((EntityPlayer) source.getTrueSource()).capabilities.isCreativeMode;

				if (flag || amount > 0.0F) {
					if (!flag && this.world.getGameRules().getBoolean("doEntityDrops")) {
						this.dropItemWithOffset(Teletubbies.poScooter, 1, 0.0F);
					}

					this.setDead();
				}

				return true;
			}
		}
		else {
			return true;
		}
	}
	
	@Override	
    public ItemStack getPickedResult(RayTraceResult target) {
		return new ItemStack(Teletubbies.poScooter);
	}
}