package teletubbies.capability;

import net.minecraft.entity.player.PlayerEntity;

public class JumpCapability implements IJumpCapability {

	private float fallDistance;
	private float manualFallDistance;
	private int ticksOnGround;
	
	public JumpCapability() {}

	@Override
	public boolean canJump(PlayerEntity player) {
		if(player.onGround && !player.isInWater() && !player.isInLava()) {
			return true;
		}
		return false;
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
		final float height = 10;
		if(this.ticksOnGround > 2 || manualFallDistance < height) {
			manualFallDistance = 0;
			return true;
		}
		return false;
	}

	@Override
	public int ticksOnGround() {
		return this.ticksOnGround;
	}

	@Override
	public void setTicksOnGround(int ticks) {
		this.ticksOnGround = ticks;		
	}
}
