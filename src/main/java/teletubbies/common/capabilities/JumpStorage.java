package teletubbies.common.capabilities;

import net.minecraft.nbt.Tag;
import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class JumpStorage implements IStorage<IJumpCapability> {

	@Override
	public void readNBT(Capability<IJumpCapability> cap, IJumpCapability instance, Direction side, Tag nbt) {
		
	}

	@Override
	public Tag writeNBT(Capability<IJumpCapability> cap, IJumpCapability instance, Direction side) {
		return null;
	}
}
