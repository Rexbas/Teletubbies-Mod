package teletubbies;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
import teletubbies.client.audio.PoScooterTickableSound;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpProvider;
import teletubbies.entity.item.PoScooterEntity;
import teletubbies.entity.passive.DipsyEntity;
import teletubbies.entity.passive.LaaLaaEntity;
import teletubbies.entity.passive.PoEntity;
import teletubbies.entity.passive.TeletubbyEntity;
import teletubbies.entity.passive.TinkyWinkyEntity;
import teletubbies.item.LaaLaaBallItem;

public class TeletubbiesEventHandler {

	@SubscribeEvent
	public void attachtCapabilityEntity (AttachCapabilitiesEvent<Entity> event) {		
		if(event.getObject() instanceof PlayerEntity) {
			event.addCapability(new ResourceLocation(Teletubbies.MODID, "capability.jump"), new JumpProvider());
		}
	}
	
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void joinClientWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof PoScooterEntity) {
			Minecraft.getInstance().getSoundHandler().play(new PoScooterTickableSound((PoScooterEntity) event.getEntity()));
		}
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if(event.getEntityLiving() instanceof PlayerEntity) {
			PlayerEntity player = (PlayerEntity) event.getEntityLiving();
						
			LazyOptional<IJumpCapability> cap = player.getCapability(JumpProvider.JUMP_CAPABILITY, player.getHorizontalFacing());
			cap.ifPresent(c -> {
				float fallDistance = c.fallDistance();
				
				int ticks = c.ticksOnGround();
				
				if(player.onGround && ticks < 50) {
					c.setTicksOnGround(ticks + 1);
				}
				if(!player.onGround && ticks != 0) {
					c.setTicksOnGround(0);
				}
				if(player.fallDistance > fallDistance) {
					c.setFallDistance(player.fallDistance);
				}
				
				LaaLaaBallItem ball = null;
				if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof LaaLaaBallItem &&
						player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof LaaLaaBallItem) {
					ball = (LaaLaaBallItem) player.getHeldItemMainhand().getItem();
				}
				else if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof LaaLaaBallItem) {
					ball = (LaaLaaBallItem) player.getHeldItemMainhand().getItem();
				}
				else if(player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof LaaLaaBallItem) {
					ball = (LaaLaaBallItem) player.getHeldItemOffhand().getItem();
				}
				
				if(ball != null) {
					if(c.canJump(player) && fallDistance >= 10) {
						LaaLaaBallItem.jump(player, true);
					}
				}
				if(player.onGround) {
					c.setFallDistance(0);
				}
				if(player.isInWater() || player.isInLava()) {
					c.setFallDistance(0);
				}
			});
		}
	}
	
	@SubscribeEvent
	public void fallEvent(LivingFallEvent event) {
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
	public void updateRidden(PlayerTickEvent event) {
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
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof ZombieEntity) {
			ZombieEntity zombie = (ZombieEntity) event.getEntity();
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, TinkyWinkyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, DipsyEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, LaaLaaEntity.class, true));
	        zombie.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(zombie, PoEntity.class, true));
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onLivingDeathEvent(LivingDeathEvent event) {
		Random rand = new Random();
		int i = rand.nextInt(4);
		DamageSource damageSource = (DamageSource) event.getSource();
		World world = event.getEntityLiving().world;

		if (!world.isRemote) {
			if (damageSource.getImmediateSource() instanceof ZombieEntity) {
				if (event.getEntity() instanceof TeletubbyEntity && i == 0) {
					TeletubbyEntity teletubby = (TeletubbyEntity) event.getEntityLiving();
					teletubby.transferToZombie();
				}
			}
		}
	}
}
