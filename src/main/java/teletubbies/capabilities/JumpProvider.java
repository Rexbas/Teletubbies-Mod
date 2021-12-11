package teletubbies.capabilities;

import net.minecraft.core.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

public class JumpProvider implements ICapabilityProvider {
	
	public static final Capability<IJumpCapability> JUMP_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
	
	private LazyOptional<IJumpCapability> instance = LazyOptional.of(JumpCapability::new);

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return cap == JUMP_CAPABILITY ? instance.cast() : LazyOptional.empty();
	}
}
