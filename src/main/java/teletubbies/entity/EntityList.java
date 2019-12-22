package teletubbies.entity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.Teletubbies;
import teletubbies.entity.item.PoScooterEntity;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityList {
	public static final EntityType<?> TINKYWINKY = EntityType.Builder.create(TinkyWinkyEntity::new, EntityClassification.CREATURE).build(Teletubbies.MODID + ":tinkywinky").setRegistryName(Teletubbies.MODID, "tinkywinky");
	public static final EntityType<?> DIPSY = EntityType.Builder.create(DipsyEntity::new, EntityClassification.CREATURE).build(Teletubbies.MODID + ":dipsy").setRegistryName(Teletubbies.MODID, "dipsy");
	public static final EntityType<?> LAALAA = EntityType.Builder.create(LaaLaaEntity::new, EntityClassification.CREATURE).build(Teletubbies.MODID + ":laalaa").setRegistryName(Teletubbies.MODID, "laalaa");	
	public static final EntityType<?> PO = EntityType.Builder.create(PoEntity::new, EntityClassification.CREATURE).build(Teletubbies.MODID + ":po").setRegistryName(Teletubbies.MODID, "po");
	
	public static final EntityType<?> PO_SCOOTER = EntityType.Builder.create(PoScooterEntity::new, EntityClassification.MISC).setCustomClientFactory((entity, world) -> new PoScooterEntity(world)).build(Teletubbies.MODID + ":po_scooter").setRegistryName(Teletubbies.MODID, "po_scooter");
	
	@SubscribeEvent
	public static void registerEntityEvent(final RegistryEvent.Register<EntityType<?>> event) {
		event.getRegistry().registerAll(
				TINKYWINKY, DIPSY, LAALAA, PO,
				PO_SCOOTER
		);
	}
}
