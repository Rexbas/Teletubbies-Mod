package com.rexbas.teletubbies;

import com.rexbas.bouncingballs.api.BouncingBallsAPI;
import com.rexbas.bouncingballs.api.capability.BounceCapability;
import com.rexbas.teletubbies.client.audio.PoScooterTickableSound;
import com.rexbas.teletubbies.client.renderer.environment.BabyFaceRenderer;
import com.rexbas.teletubbies.config.Config;
import com.rexbas.teletubbies.entity.PoScooterEntity;
import com.rexbas.teletubbies.entity.ai.goal.EatFullGrassGoal;
import com.rexbas.teletubbies.entity.passive.DipsyEntity;
import com.rexbas.teletubbies.entity.passive.LaaLaaEntity;
import com.rexbas.teletubbies.entity.passive.PoEntity;
import com.rexbas.teletubbies.entity.passive.TeletubbyEntity;
import com.rexbas.teletubbies.entity.passive.TinkyWinkyEntity;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.init.TeletubbiesItems;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.world.DimensionRenderInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GrassColors;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
public class TeletubbiesEventHandler {
	
	@SubscribeEvent
	public static void attachtCapability(AttachCapabilitiesEvent<Entity> event) {	
		if (event.getObject() instanceof TeletubbyEntity) {
			event.addCapability(new ResourceLocation(BouncingBallsAPI.MODID, "capability.bounce"), new BounceCapability());
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void setSkyRenderer(EntityJoinWorldEvent event) {
		if (event.getEntity().equals(Minecraft.getInstance().player) && event.getWorld().isClientSide() && event.getWorld().dimension().equals(World.OVERWORLD) && Config.CLIENT.REPLACE_SUN.get()) {
			DimensionRenderInfo di = DimensionRenderInfo.forType(event.getWorld().dimensionType());
			ISkyRenderHandler renderer = new BabyFaceRenderer();
			di.setSkyRenderHandler(renderer);
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void joinClientWorld(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof PoScooterEntity) {
			Minecraft.getInstance().getSoundManager().play(new PoScooterTickableSound((PoScooterEntity) event.getEntity()));
		}
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void updateRidden(PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.player instanceof ClientPlayerEntity) {
			ClientPlayerEntity player = (ClientPlayerEntity) event.player;
			if (player.getVehicle() instanceof PoScooterEntity) {
				PoScooterEntity scooter = (PoScooterEntity) player.getVehicle();
				scooter.updateInputs(player.input.left, player.input.right, player.input.up, player.input.down);
			}
		}
	}
	
	@SubscribeEvent
	public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.getEntity() instanceof ZombieEntity) {
			ZombieEntity zombie = (ZombieEntity) event.getEntity();
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, TinkyWinkyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, DipsyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, LaaLaaEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, PoEntity.class, true));
		}
		
		if (event.getEntity() instanceof SheepEntity) {
			SheepEntity sheep = (SheepEntity) event.getEntity();
			sheep.goalSelector.addGoal(5, new EatFullGrassGoal(sheep));
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public static void onLivingDeathEvent(LivingDeathEvent event) {
		DamageSource damageSource = (DamageSource) event.getSource();
		World world = event.getEntityLiving().level;

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
	                : GrassColors.get(0.5D, 1.0D), TeletubbiesBlocks.FULL_GRASS.get());
			}
	    }
	    
	    @OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void ItemColorHandler(final ColorHandlerEvent.Item event) {
	    	if (TeletubbiesItems.FULL_GRASS.get() != null) {
				final IItemColor colorHandler = (stack, tint) -> {
					final BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
					return event.getBlockColors().getColor(state, null, null, tint);
				};
				event.getItemColors().register(colorHandler, TeletubbiesItems.FULL_GRASS.get());
	    	}
		}
	}
}