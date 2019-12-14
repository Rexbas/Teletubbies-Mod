package teletubbies.lists;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.entities.Dipsy;
import teletubbies.entities.TinkyWinky;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityList {
	public static final EntityType<?> TINKYWINKY = EntityType.Builder.create(TinkyWinky::new, EntityClassification.CREATURE).build(Teletubbies.MODID + ":tinkywinky").setRegistryName(Teletubbies.MODID, "tinkywinky");
	public static final EntityType<?> DIPSY = EntityType.Builder.create(Dipsy::new, EntityClassification.CREATURE).build(Teletubbies.MODID + ":dipsy").setRegistryName(Teletubbies.MODID, "dipsy");
	
	@SubscribeEvent
	public static void registerEntityEvent(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(
				TINKYWINKY, DIPSY
		);
	}
}
