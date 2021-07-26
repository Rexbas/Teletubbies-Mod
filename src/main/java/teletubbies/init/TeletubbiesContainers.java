package teletubbies.init;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import teletubbies.Teletubbies;
import teletubbies.inventory.container.TinkyWinkyBagContainer;
import teletubbies.inventory.container.ToastMachineContainer;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeletubbiesContainers {

	public static final DeferredRegister<MenuType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Teletubbies.MODID);
	
	public static final RegistryObject<MenuType<TinkyWinkyBagContainer>> TINKYWINKY_BAG_CONTAINER = CONTAINER_TYPES
			.register("tinkywinky_bag_container", () -> IForgeContainerType.create(TinkyWinkyBagContainer::new));
	
	/*public static final RegistryObject<MenuType<ControlPanelContainer>> CONTROL_PANEL_CONTAINER = CONTAINER_TYPES
			.register("control_panel_container", () -> IForgeContainerType.create(ControlPanelContainer::new));*/
	
	public static final RegistryObject<MenuType<ToastMachineContainer>> TOAST_MACHINE_CONTAINER = CONTAINER_TYPES
			.register("toast_machine_container", () -> IForgeContainerType.create(ToastMachineContainer::new));	
	
	/*public static final RegistryObject<MenuType<CustardMachineContainer>> CUSTARD_MACHINE_CONTAINER = CONTAINER_TYPES
			.register("custard_machine_container", () -> IForgeContainerType.create(CustardMachineContainer::new));*/
}

