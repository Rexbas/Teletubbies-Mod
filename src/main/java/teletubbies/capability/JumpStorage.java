package teletubbies.capability;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class JumpStorage implements IStorage<IJumpCapability> {

	@Override
	public void readNBT(Capability<IJumpCapability> cap, IJumpCapability instance, Direction side, INBT nbt) {
		
	}

	@Override
	public INBT writeNBT(Capability<IJumpCapability> cap, IJumpCapability instance, Direction side) {
		return null;
	}
}
