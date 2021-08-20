package teletubbies.capabilities;

import net.minecraft.world.entity.player.Player;

public interface IJumpCapability {
	
	public boolean canJump(Player player);
	public float fallDistance();
	public void setFallDistance(float newFallDistance);
	public boolean check();
	public int ticksOnGround();
	public void setTicksOnGround(int ticks);
}
