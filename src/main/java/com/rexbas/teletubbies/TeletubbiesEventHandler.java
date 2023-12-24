package com.rexbas.teletubbies;

import com.rexbas.teletubbies.block.entity.ControlPanelBlockEntity;
import com.rexbas.teletubbies.block.entity.CustardMachineBlockEntity;
import com.rexbas.teletubbies.block.entity.CustardMachineSlaveBlockEntity;
import com.rexbas.teletubbies.block.entity.ToastMachineBlockEntity;
import com.rexbas.teletubbies.client.audio.PoScooterTickableSound;
import com.rexbas.teletubbies.client.renderer.environment.BabyFaceRenderer;
import com.rexbas.teletubbies.config.Config;
import com.rexbas.teletubbies.entity.PoScooterEntity;
import com.rexbas.teletubbies.entity.ai.goal.EatFullGrassGoal;
import com.rexbas.teletubbies.entity.passive.*;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import com.rexbas.teletubbies.init.TeletubbiesItems;
import com.rexbas.teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import com.rexbas.teletubbies.item.PoScooterItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterDimensionSpecialEffectsEvent;
import net.neoforged.neoforge.event.TickEvent;
import net.neoforged.neoforge.event.TickEvent.PlayerTickEvent;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@Mod.EventBusSubscriber(modid = Teletubbies.MODID)
public class TeletubbiesEventHandler {

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onJoinClientWorld(EntityJoinLevelEvent event) {
		if (event.getEntity() instanceof PoScooterEntity) {
			Minecraft.getInstance().getSoundManager().play(new PoScooterTickableSound((PoScooterEntity) event.getEntity(), event.getLevel().getRandom()));
		}
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void updateRidden(PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.player instanceof LocalPlayer player) {
			if (player.getVehicle() instanceof PoScooterEntity scooter) {
				scooter.setInput(player.input.left, player.input.right, player.input.up, player.input.down);
			}
		}
	}

	@SubscribeEvent
	public static void onEntityJoinWorld(EntityJoinLevelEvent event) {
		if(event.getEntity() instanceof Zombie zombie) {
			zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, TinkyWinkyEntity.class, true));
			zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, DipsyEntity.class, true));
			zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, LaaLaaEntity.class, true));
			zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, PoEntity.class, true));
		}

		if (event.getEntity() instanceof Sheep sheep) {
			sheep.goalSelector.addGoal(5, new EatFullGrassGoal(sheep));
		}

		if (event.getEntity() instanceof PoEntity po) {
			if (po.getMainHandItem().getItem() instanceof PoScooterItem) {
				PoScooterEntity scooter = new PoScooterEntity(event.getLevel(), po.getX(), po.getY(), po.getZ());
				event.getLevel().addFreshEntity(scooter);
				scooter.setYRot(po.getYRot());
				po.startRiding(scooter);
				po.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
			}
		}
	}

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public static void onLivingDeathEvent(LivingDeathEvent event) {
		DamageSource damageSource = event.getSource();
		Level world = event.getEntity().level();

		if (!world.isClientSide()) {
			if (damageSource.getDirectEntity() instanceof Zombie) {
				if (event.getEntity() instanceof TeletubbyEntity teletubby && world.random.nextInt(100) < Config.COMMON.TRANSFORMATION_PROBABILITY.get()) {
					teletubby.transferToZombie();
				}
			}
		}
	}

	@Mod.EventBusSubscriber(modid = Teletubbies.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class TeletubbiesBus {

		@SubscribeEvent
		public static void registerCapabilities(RegisterCapabilitiesEvent event) {
			event.registerItem(Capabilities.ItemHandler.ITEM,
					(stack, context) -> {
						TinkyWinkyBagItemHandler handler = new TinkyWinkyBagItemHandler(stack);
						handler.load();
						return handler;
					}, TeletubbiesItems.TINKYWINKY_BAG.get());

			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TeletubbiesBlocks.CONTROL_PANEL_BLOCK_ENTITY.get(), (blockEntity, side) ->
					((ControlPanelBlockEntity) blockEntity).getItemHandler(side));

			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TeletubbiesBlocks.TOAST_MACHINE_BLOCK_ENTITY.get(), (blockEntity, side) ->
					((ToastMachineBlockEntity) blockEntity).getItemHandler(side));

			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TeletubbiesBlocks.CUSTARD_MACHINE_BLOCK_ENTITY.get(), (blockEntity, side) ->
					((CustardMachineBlockEntity) blockEntity).getItemHandler(side));

			event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TeletubbiesBlocks.CUSTARD_MACHINE_SLAVE_BLOCK_ENTITY.get(), (blockEntity, side) ->
					((CustardMachineSlaveBlockEntity) blockEntity).getItemHandler(side));
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void BlockColorHandler(RegisterColorHandlersEvent.Block event) {
			TeletubbiesBlocks.FULL_GRASS.get();
			event.register((state, reader, pos, tint) -> reader != null
					&& pos != null ? BiomeColors.getAverageGrassColor(reader, pos)
					: GrassColor.get(0.5D, 1.0D), TeletubbiesBlocks.FULL_GRASS.get());
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void ItemColorHandler(final RegisterColorHandlersEvent.Item event) {
			TeletubbiesItems.FULL_GRASS.get();
			final ItemColor colorHandler = (stack, tint) -> {
				final BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
				return event.getBlockColors().getColor(state, null, null, tint);
			};
			event.register(colorHandler, TeletubbiesItems.FULL_GRASS.get());
		}

		@OnlyIn(Dist.CLIENT)
		@SubscribeEvent
		public static void setSkyRenderer(RegisterDimensionSpecialEffectsEvent event) {
			if (Config.CLIENT.REPLACE_SUN.get()) {
				event.register(BuiltinDimensionTypes.OVERWORLD_EFFECTS, new BabyFaceRenderer());
			}
		}
	}
}