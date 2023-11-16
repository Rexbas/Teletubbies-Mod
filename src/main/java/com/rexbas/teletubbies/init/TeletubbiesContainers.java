package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.inventory.container.ControlPanelContainer;
import com.rexbas.teletubbies.inventory.container.CustardMachineContainer;
import com.rexbas.teletubbies.inventory.container.TinkyWinkyBagContainer;
import com.rexbas.teletubbies.inventory.container.ToastMachineContainer;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;

public class TeletubbiesContainers {

	public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Teletubbies.MODID);
	
	public static final RegistryObject<MenuType<TinkyWinkyBagContainer>> TINKYWINKY_BAG_CONTAINER = CONTAINER_TYPES
			.register("tinkywinky_bag_container", () -> IMenuTypeExtension.create(TinkyWinkyBagContainer::new));
	
	public static final RegistryObject<MenuType<ControlPanelContainer>> CONTROL_PANEL_CONTAINER = CONTAINER_TYPES
			.register("control_panel_container", () -> IMenuTypeExtension .create(ControlPanelContainer::new));
	
	public static final RegistryObject<MenuType<ToastMachineContainer>> TOAST_MACHINE_CONTAINER = CONTAINER_TYPES
			.register("toast_machine_container", () -> IMenuTypeExtension .create(ToastMachineContainer::new));	
	
	public static final RegistryObject<MenuType<CustardMachineContainer>> CUSTARD_MACHINE_CONTAINER = CONTAINER_TYPES
			.register("custard_machine_container", () -> IMenuTypeExtension .create(CustardMachineContainer::new));
}