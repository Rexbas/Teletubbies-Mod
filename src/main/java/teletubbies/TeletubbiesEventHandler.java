package teletubbies;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.client.audio.PoScooterTickableSound;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpProvider;
import teletubbies.config.Config;
import teletubbies.entity.passive.DipsyEntity;
import teletubbies.entity.passive.LaaLaaEntity;
import teletubbies.entity.passive.PoEntity;
import teletubbies.entity.passive.TeletubbyEntity;
import teletubbies.entity.passive.TinkyWinkyEntity;
import teletubbies.entity.vehicle.PoScooterEntity;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.init.TeletubbiesItems;
import teletubbies.item.LaaLaaBallItem;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
public class TeletubbiesEventHandler {
	
	@SubscribeEvent
	public static void attachtCapabilityEntity(AttachCapabilitiesEvent<Entity> event) {		
		if(event.getObject() instanceof Player) {
			event.addCapability(new ResourceLocation(Teletubbies.MODID, "capability.jump"), new JumpProvider());
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void joinClientWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof PoScooterEntity) {
			Minecraft.getInstance().getSoundManager().play(new PoScooterTickableSound((PoScooterEntity) event.getEntity()));
		}
	}
	
	@SubscribeEvent
	public static void onLivingUpdate(LivingUpdateEvent event) {
		if(event.getEntityLiving() instanceof Player) {
			Player player = (Player) event.getEntityLiving();
						
			LazyOptional<IJumpCapability> cap = player.getCapability(JumpProvider.JUMP_CAPABILITY, player.getDirection());
			cap.ifPresent(c -> {
				float fallDistance = c.fallDistance();
				
				int ticks = c.ticksOnGround();
				
				if(player.isOnGround() && ticks < 50) {
					c.setTicksOnGround(ticks + 1);
				}
				if(!player.isOnGround() && ticks != 0) {
					c.setTicksOnGround(0);
				}
				if(player.fallDistance > fallDistance) {
					c.setFallDistance(player.fallDistance);
				}
				
				if (player.getMainHandItem() != null && player.getMainHandItem().getItem() instanceof LaaLaaBallItem
						|| player.getOffhandItem() != null && player.getOffhandItem().getItem() instanceof LaaLaaBallItem) {
					if (c.canJump(player) && fallDistance >= 10) {
						LaaLaaBallItem.jump(player, true);
					}
				}

				if(player.isOnGround()) {
					c.setFallDistance(0);
				}
				if(player.isInWater() || player.isInLava()) {
					c.setFallDistance(0);
				}
			});
		}
	}
	
	@SubscribeEvent
	public static void fallEvent(LivingFallEvent event) {
		if(event.getEntityLiving() instanceof Player) {
			Player player = (Player) event.getEntityLiving();
			if(player.getMainHandItem() != null) {
				if(player.getMainHandItem().getItem() instanceof LaaLaaBallItem) {
					event.setCanceled(true);
				}
			}
			if(player.getOffhandItem() != null) {
				if(player.getOffhandItem().getItem() instanceof LaaLaaBallItem) {
					event.setCanceled(true);
				}
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void updateRidden(PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.player instanceof LocalPlayer) {
			LocalPlayer player = (LocalPlayer) event.player;
			if (player.getVehicle() instanceof PoScooterEntity) {
				PoScooterEntity scooter = (PoScooterEntity) player.getVehicle();
				scooter.updateInputs(player.input.left, player.input.right, player.input.up, player.input.down);
			}
		}
	}
	
	@SubscribeEvent
	public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, TinkyWinkyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, DipsyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, LaaLaaEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, PoEntity.class, true));
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public static void onLivingDeathEvent(LivingDeathEvent event) {
		DamageSource damageSource = (DamageSource) event.getSource();
		Level world = event.getEntityLiving().level;

		if (!world.isClientSide) {
			if (damageSource.getDirectEntity() instanceof Zombie) {
				if (event.getEntity() instanceof TeletubbyEntity && world.random.nextInt(100) < Config.COMMON.TRANSFORMATION_PROBABILITY.get()) {
					TeletubbyEntity teletubby = (TeletubbyEntity) event.getEntityLiving();
					teletubby.transferToZombie();
				}
			}
		}
	}
	
	@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class TeletubbiesBus {
		@OnlyIn(Dist.CLIENT)
	    @SubscribeEvent
	    public static void BlockColorHandler(final ColorHandlerEvent.Block event) {
			if (TeletubbiesBlocks.FULL_GRASS.get() != null) {
	        event.getBlockColors().register((state, reader, pos, tint) -> reader != null
	                && pos != null ? BiomeColors.getAverageGrassColor(reader, pos)
	                : GrassColor.get(0.5D, 1.0D), TeletubbiesBlocks.FULL_GRASS.get());
			}
	    }
	    
	    @OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void ItemColorHandler(final ColorHandlerEvent.Item event) {
	    	if (TeletubbiesItems.FULL_GRASS.get() != null) {
				final ItemColor colorHandler = (stack, tint) -> {
					final BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
					return event.getBlockColors().getColor(state, null, null, tint);
				};
				event.getItemColors().register(colorHandler, TeletubbiesItems.FULL_GRASS.get());
	    	}
		}
	}
}
