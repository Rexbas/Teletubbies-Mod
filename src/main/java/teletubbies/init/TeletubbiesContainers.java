package teletubbies.init;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;
import teletubbies.inventory.container.ControlPanelContainer;
import teletubbies.inventory.container.CustardMachineContainer;
import teletubbies.inventory.container.TinkyWinkyBagContainer;
import teletubbies.inventory.container.ToastMachineContainer;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesContainers {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Teletubbies.MODID);
	
	public static final RegistryObject<ContainerType<TinkyWinkyBagContainer>> TINKYWINKY_BAG_CONTAINER = CONTAINER_TYPES
			.register("tinkywinky_bag_container", () -> IForgeContainerType.create(TinkyWinkyBagContainer::new));
	
	public static final RegistryObject<ContainerType<ControlPanelContainer>> CONTROL_PANEL_CONTAINER = CONTAINER_TYPES
			.register("control_panel_container", () -> IForgeContainerType.create(ControlPanelContainer::new));
	
	public static final RegistryObject<ContainerType<ToastMachineContainer>> TOAST_MACHINE_CONTAINER = CONTAINER_TYPES
			.register("toast_machine_container", () -> IForgeContainerType.create(ToastMachineContainer::new));	
	
	public static final RegistryObject<ContainerType<CustardMachineContainer>> CUSTARD_MACHINE_CONTAINER = CONTAINER_TYPES
			.register("custard_machine_container", () -> IForgeContainerType.create(CustardMachineContainer::new));
}

