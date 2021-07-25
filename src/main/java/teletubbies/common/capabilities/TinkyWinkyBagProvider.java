package teletubbies.common.capabilities;

import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;

public class TinkyWinkyBagProvider implements ICapabilityProvider {

	private TinkyWinkyBagItemHandler inventory;
	private LazyOptional<IItemHandler> instance;

	public TinkyWinkyBagProvider(ItemStack stack) {
		inventory = new TinkyWinkyBagItemHandler(stack);
		instance = LazyOptional.of(() -> inventory);
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		inventory.load();
		return cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ? instance.cast() : LazyOptional.empty();
	}
}

