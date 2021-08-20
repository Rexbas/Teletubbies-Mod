package teletubbies.capabilities;

import net.minecraft.entity.player.PlayerEntity;

public interface IJumpCapability {
	
	public boolean canJump(PlayerEntity player);
	public float fallDistance();
	public void setFallDistance(float newFallDistance);
	public boolean check();
	public int ticksOnGround();
	public void setTicksOnGround(int ticks);
}
