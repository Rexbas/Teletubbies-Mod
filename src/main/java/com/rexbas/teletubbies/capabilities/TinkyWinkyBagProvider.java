package com.rexbas.teletubbies.capabilities;

import com.rexbas.teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
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
		return cap == ForgeCapabilities.ITEM_HANDLER ? instance.cast() : LazyOptional.empty();
	}
}