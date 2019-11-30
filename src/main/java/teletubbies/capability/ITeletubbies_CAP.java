package teletubbies.capability;

import teletubbies.entity.passive.EntityNooNoo;

public interface ITeletubbies_CAP {
	
	public boolean canJump();
	public float fallDistance();
	public void setFallDistance(float newFallDistance);
	public boolean check();
	public int ticksOnGround();
	public void setTicksOnGround(int ticks);
	EntityNooNoo interactedNooNoo();
	void setInteractedNooNoo(EntityNooNoo nooNoo);
}
