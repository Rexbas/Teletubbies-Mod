package com.rexbas.teletubbies.init;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.inventory.container.ControlPanelContainer;
import com.rexbas.teletubbies.inventory.container.CustardMachineContainer;
import com.rexbas.teletubbies.inventory.container.TinkyWinkyBagContainer;
import com.rexbas.teletubbies.inventory.container.ToastMachineContainer;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesContainers {

	public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Teletubbies.MODID);
	
	public static final RegistryObject<MenuType<TinkyWinkyBagContainer>> TINKYWINKY_BAG_CONTAINER = CONTAINER_TYPES
			.register("tinkywinky_bag_container", () -> IForgeMenuType.create(TinkyWinkyBagContainer::new));
	
	public static final RegistryObject<MenuType<ControlPanelContainer>> CONTROL_PANEL_CONTAINER = CONTAINER_TYPES
			.register("control_panel_container", () -> IForgeMenuType .create(ControlPanelContainer::new));
	
	public static final RegistryObject<MenuType<ToastMachineContainer>> TOAST_MACHINE_CONTAINER = CONTAINER_TYPES
			.register("toast_machine_container", () -> IForgeMenuType .create(ToastMachineContainer::new));	
	
	public static final RegistryObject<MenuType<CustardMachineContainer>> CUSTARD_MACHINE_CONTAINER = CONTAINER_TYPES
			.register("custard_machine_container", () -> IForgeMenuType .create(CustardMachineContainer::new));
}