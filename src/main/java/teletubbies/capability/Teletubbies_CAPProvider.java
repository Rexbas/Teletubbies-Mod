package teletubbies.capability;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import teletubbies.Teletubbies;
import teletubbies.entity.passive.EntityNooNoo;
import teletubbies.item.LaaLaaBall;

public class Teletubbies_CAPProvider implements ICapabilityProvider, ITeletubbies_CAP {

	private EntityPlayer player;
	private AttachCapabilitiesEvent.Entity event;
	private float fallDistance;
	private float manualFallDistance;
	private int ticksOnGround;
	EntityNooNoo nooNoo;
	
	public Teletubbies_CAPProvider(AttachCapabilitiesEvent.Entity event) {
		this.player = (EntityPlayer) event.getEntity();
		this.event = event;
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
		if(capability == Teletubbies.Teletubbies_CAP) return true;
		else return false;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
		if(Teletubbies.Teletubbies_CAP != null && capability == Teletubbies.Teletubbies_CAP) {
			return (T) this;
		}
		else return null;
	}

	@Override
	public boolean canJump() {
		if(player.onGround && !player.isInWater() && !player.isInLava()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public float fallDistance() {
		return fallDistance;
	}
	
	@Override
	public void setFallDistance(float newFallDistance) {
		this.fallDistance = newFallDistance;
		if(newFallDistance >= 10) manualFallDistance = newFallDistance;
	}

	@Override
	public boolean check() {
		LaaLaaBall ball = null;
		if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof LaaLaaBall &&
				player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof LaaLaaBall) {
			ball = (LaaLaaBall) player.getHeldItemMainhand().getItem();
		}
		else if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof LaaLaaBall) {
			ball = (LaaLaaBall) player.getHeldItemMainhand().getItem();
		}
		else {
			ball = (LaaLaaBall) player.getHeldItemOffhand().getItem();
		}
		
		float height = 10;
		if(this.ticksOnGround > 2 || manualFallDistance < height) {
			manualFallDistance = 0;
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public int ticksOnGround() {
		return this.ticksOnGround;
	}
	
	@Override
	public void setTicksOnGround(int ticks) {
		this.ticksOnGround = ticks;
	}

	@Override
	public EntityNooNoo interactedNooNoo() {
		return this.nooNoo;
	}

	@Override
	public void setInteractedNooNoo(EntityNooNoo nooNoo) {
		this.nooNoo = nooNoo;
	}
}
