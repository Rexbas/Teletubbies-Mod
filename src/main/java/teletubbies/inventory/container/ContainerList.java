package teletubbies.inventory.container;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ContainerList {
	
    public static final ContainerType<TinkyWinkyBagContainer> TINKYWINKY_BAG_CONTAINER = (ContainerType<TinkyWinkyBagContainer>) new ContainerType(TinkyWinkyBagContainer::new).setRegistryName("tinkywinky_bag_container");
	
	@SubscribeEvent
	public static void registerEntityEvent(final RegistryEvent.Register<ContainerType<?>> event) {
		event.getRegistry().registerAll(
				TINKYWINKY_BAG_CONTAINER
		);
	}
}
