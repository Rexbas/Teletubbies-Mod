package teletubbies.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class Teletubbies_CAPStorage implements IStorage<ITeletubbies_CAP> {

	@Override
	public NBTBase writeNBT(Capability<ITeletubbies_CAP> capability, ITeletubbies_CAP instance, EnumFacing side) {
		return null;
	}

	@Override
	public void readNBT(Capability<ITeletubbies_CAP> capability, ITeletubbies_CAP instance, EnumFacing side, NBTBase nbt) {
		
	}
}
