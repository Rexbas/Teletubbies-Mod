package teletubbies;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GrassColors;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColors;
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
import teletubbies.block.BlockList;
import teletubbies.client.audio.PoScooterTickableSound;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpProvider;
import teletubbies.config.EntityConfig;
import teletubbies.entity.item.PoScooterEntity;
import teletubbies.entity.passive.DipsyEntity;
import teletubbies.entity.passive.LaaLaaEntity;
import teletubbies.entity.passive.PoEntity;
import teletubbies.entity.passive.TeletubbyEntity;
import teletubbies.entity.passive.TinkyWinkyEntity;
import teletubbies.init.ModItems;
import teletubbies.item.LaaLaaBallItem;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
public class TeletubbiesEventHandler {
	
	@SubscribeEvent
	public static void attachtCapabilityEntity(AttachCapabilitiesEvent<Entity> event) {		
		if(event.getObject() instanceof PlayerEntity) {
			event.addCapability(new ResourceLocation(Teletubbies.MODID, "capability.jump"), new JumpProvider());
		}
	}
	
	/*@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void setSkyRenderer(WorldEvent.Load event) {		
		if (event.getWorld().isRemote() && event.getWorld().getDimension().getType() == DimensionType.OVERWORLD) {
			IRenderHandler renderer = new BabyFaceRenderer();
			event.getWorld().getDimension().setSkyRenderer(renderer);
		}
	}*/
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void joinClientWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof PoScooterEntity) {
			Minecraft.getInstance().getSoundHandler().play(new PoScooterTickableSound((PoScooterEntity) event.getEntity()));
		}
	}
	
	@SubscribeEvent
	public static void onLivingUpdate(LivingUpdateEvent event) {
		if(event.getEntityLiving() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
						
			LazyOptional<IJumpCapability> cap = player.getCapability(JumpProvider.JUMP_CAPABILITY, player.getHorizontalFacing());
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
				
				if (player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof LaaLaaBallItem
						|| player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof LaaLaaBallItem) {
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
		if(event.getEntityLiving() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
			if(player.getHeldItemMainhand() != null) {
				if(player.getHeldItemMainhand().getItem() instanceof LaaLaaBallItem) {
					event.setCanceled(true);
				}
			}
			if(player.getHeldItemOffhand() != null) {
				if(player.getHeldItemOffhand().getItem() instanceof LaaLaaBallItem) {
					event.setCanceled(true);
				}
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void updateRidden(PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.player instanceof ClientPlayerEntity) {
			ClientPlayerEntity player = (ClientPlayerEntity) event.player;
			if (player.getRidingEntity() instanceof PoScooterEntity) {
				PoScooterEntity scooter = (PoScooterEntity) player.getRidingEntity();
				scooter.updateInputs(player.movementInput.leftKeyDown, player.movementInput.rightKeyDown,
						player.movementInput.forwardKeyDown, player.movementInput.backKeyDown);
			}
		}
	}
	
	@SubscribeEvent
	public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof ZombieEntity) {
			ZombieEntity zombie = (ZombieEntity) event.getEntity();
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, TinkyWinkyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, DipsyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, LaaLaaEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, PoEntity.class, true));
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public static void onLivingDeathEvent(LivingDeathEvent event) {
		DamageSource damageSource = (DamageSource) event.getSource();
		World world = event.getEntityLiving().world;

		if (!world.isRemote) {
			if (damageSource.getImmediateSource() instanceof ZombieEntity) {
				if (event.getEntity() instanceof TeletubbyEntity && world.rand.nextInt(100) < EntityConfig.TRANSFORMATION_PROBABILITY.get()) {
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
			if (BlockList.FULL_GRASS != null) {
	        event.getBlockColors().register((state, reader, pos, tint) -> reader != null
	                && pos != null ? BiomeColors.getGrassColor(reader, pos)
	                : GrassColors.get(0.5D, 1.0D), BlockList.FULL_GRASS);
			}
	    }
	    
	    @OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void ItemColorHandler(final ColorHandlerEvent.Item event) {
	    	if (ModItems.FULL_GRASS.get() != null) {
				final IItemColor colorHandler = (stack, tint) -> {
					final BlockState state = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
					return event.getBlockColors().getColor(state, null, null, tint);
				};
				event.getItemColors().register(colorHandler, ModItems.FULL_GRASS.get());
	    	}
		}
	}
}
