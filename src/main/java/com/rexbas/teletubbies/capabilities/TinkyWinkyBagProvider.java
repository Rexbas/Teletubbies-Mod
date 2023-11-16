package com.rexbas.teletubbies.capabilities;

import com.rexbas.teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.capabilities.Capabilities;
import net.neoforged.neoforge.common.capabilities.Capability;
import net.neoforged.neoforge.common.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

public class TinkyWinkyBagProvider implements ICapabilityProvider {

	private final TinkyWinkyBagItemHandler inventory;
	private final LazyOptional<IItemHandler> instance;

	public TinkyWinkyBagProvider(ItemStack stack) {
		inventory = new TinkyWinkyBagItemHandler(stack);
		instance = LazyOptional.of(() -> inventory);
	}

	@Override
	public <T> @NotNull LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		inventory.load();
		return cap == Capabilities.ITEM_HANDLER ? instance.cast() : LazyOptional.empty();
	}
}