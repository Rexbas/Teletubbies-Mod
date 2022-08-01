package com.rexbas.teletubbies;

import com.rexbas.bouncingballs.api.BouncingBallsAPI;
import com.rexbas.bouncingballs.api.capability.BounceCapability;
import com.rexbas.teletubbies.client.audio.PoScooterTickableSound;
import com.rexbas.teletubbies.client.renderer.environment.BabyFaceRenderer;
import com.rexbas.teletubbies.config.Config;
import com.rexbas.teletubbies.entity.PoScooterEntity;
import com.rexbas.teletubbies.entity.ai.goal.EatFullGrassGoal;
import com.rexbas.teletubbies.entity.monster.TeletubbyZombieEntity;
import com.rexbas.teletubbies.entity.passive.DipsyEntity;
import com.rexbas.teletubbies.entity.passive.LaaLaaEntity;
import com.rexbas.teletubbies.entity.passive.PoEntity;
import com.rexbas.teletubbies.entity.passive.TeletubbyEntity;
import com.rexbas.teletubbies.entity.passive.TinkyWinkyEntity;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import com.rexbas.teletubbies.item.PoScooterItem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.eventbus.api.Event.Result;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import teletubbies.capabilities.IJumpCapability;
import teletubbies.capabilities.JumpProvider;
import teletubbies.client.audio.PoScooterTickableSound;
import teletubbies.client.renderer.environment.BabyFaceRenderer;
import teletubbies.config.Config;
import teletubbies.entity.ai.goal.EatFullGrassGoal;
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
	
	
	// Temporary until ToolActions.HOE_TILL works
	@SubscribeEvent
	public static void hoeEvent(UseHoeEvent event) {
		Level level = event.getContext().getLevel();
		BlockPos pos = event.getContext().getClickedPos();
		
		if (level.getBlockState(pos).is(TeletubbiesBlocks.FULL_GRASS.get()) ) {
			level.setBlock(pos, Blocks.FARMLAND.defaultBlockState(), 0);
			event.setResult(Result.ALLOW);
		}
	}

	@SubscribeEvent
	public static void attachtCapability(AttachCapabilitiesEvent<Entity> event) {	
		if (event.getObject() instanceof TeletubbyEntity || event.getObject() instanceof TeletubbyZombieEntity) {
			event.addCapability(new ResourceLocation(BouncingBallsAPI.MODID, "capability.bounce"), new BounceCapability());
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void setSkyRenderer(EntityJoinWorldEvent event) {
		if (event.getEntity().equals(Minecraft.getInstance().player) && event.getWorld().isClientSide() && event.getWorld().dimension().equals(Level.OVERWORLD) && Config.CLIENT.REPLACE_SUN.get()) {
			DimensionSpecialEffects de = DimensionSpecialEffects.forType(event.getWorld().dimensionType());
			ISkyRenderHandler renderer = new BabyFaceRenderer();
			de.setSkyRenderHandler(renderer);
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onJoinClientWorld(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof PoScooterEntity) {
			Minecraft.getInstance().getSoundManager().play(new PoScooterTickableSound((PoScooterEntity) event.getEntity()));
		}
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void updateRidden(PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.player instanceof LocalPlayer) {
			LocalPlayer player = (LocalPlayer) event.player;
			if (player.getVehicle() instanceof PoScooterEntity) {
				PoScooterEntity scooter = (PoScooterEntity) player.getVehicle();
				scooter.setInput(player.input.left, player.input.right, player.input.up, player.input.down);
			}
		}
	}
	
	@SubscribeEvent
	public static void onJoinWorld(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof Zombie) {
			Zombie zombie = (Zombie) event.getEntity();
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, TinkyWinkyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, DipsyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, LaaLaaEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, PoEntity.class, true));
		}
		
		if (event.getEntity() instanceof Sheep) {
			Sheep sheep = (Sheep) event.getEntity();
			sheep.goalSelector.addGoal(5, new EatFullGrassGoal(sheep));
		}
		
		if (event.getEntity() instanceof PoEntity) {
			PoEntity po = (PoEntity) event.getEntity();
			if (po.getMainHandItem().getItem() instanceof PoScooterItem) {
				PoScooterEntity scooter = new PoScooterEntity(event.getWorld(), po.getX(), po.getY(), po.getZ());
				event.getWorld().addFreshEntity(scooter);
				scooter.yRot = po.yRot;
				po.startRiding(scooter);
				po.setItemSlot(EquipmentSlotType.MAINHAND, ItemStack.EMPTY);
			}
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public static void onLivingDeathEvent(LivingDeathEvent event) {
		DamageSource damageSource = (DamageSource) event.getSource();
		Level world = event.getEntityLiving().level;

		if (!world.isClientSide()) {
			if (damageSource.getDirectEntity() instanceof ZombieEntity) {
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