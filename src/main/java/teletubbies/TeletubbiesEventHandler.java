package teletubbies;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import teletubbies.client.audio.PoScooterTickableSound;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpProvider;
import teletubbies.entity.item.PoScooterEntity;
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
	
	/*@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if(event.getEntity() instanceof EntityZombie) {
			EntityZombie zombie = (EntityZombie) event.getEntity();
	        zombie.targetTasks.addTask(3, new EntityAINearestAttackableTarget(zombie, EntityPo.class, true));
	        zombie.targetTasks.addTask(3, new EntityAINearestAttackableTarget(zombie, EntityLaaLaa.class, true));
	        zombie.targetTasks.addTask(3, new EntityAINearestAttackableTarget(zombie, EntityDipsy.class, true));
	        zombie.targetTasks.addTask(3, new EntityAINearestAttackableTarget(zombie, EntityTinkyWinky.class, true));
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onLivingDeathEvent(LivingDeathEvent event) {
		Random rand = new Random();
		int randomNumber = rand.nextInt(5) + 1;
		DamageSource damageSource = (DamageSource) event.getSource();
		World world = event.getEntityLiving().world;
		double posX = event.getEntityLiving().posX;
		double posY = event.getEntityLiving().posY;
		double posZ = event.getEntityLiving().posZ;

		if(!world.isRemote) {
			if(damageSource.getImmediateSource() instanceof EntityZombie) {
				
				if(event.getEntity() instanceof EntityTinkyWinky && randomNumber == 1) {
					EntityZombieTinkyWinky zombieTinkyWinky = new EntityZombieTinkyWinky(world);
					EntityTinkyWinky.transferredToZombie = true;
					zombieTinkyWinky.setLocationAndAngles(posX, posY, posZ, event.getEntityLiving().rotationYaw, event.getEntityLiving().rotationPitch);
					world.spawnEntity(zombieTinkyWinky);
				}
				
				if(event.getEntity() instanceof EntityDipsy && randomNumber == 1) {
					EntityZombieDipsy zombieDipsy = new EntityZombieDipsy(world);
					EntityDipsy.transferredToZombie = true;
					zombieDipsy.setLocationAndAngles(posX, posY, posZ, event.getEntityLiving().rotationYaw, event.getEntityLiving().rotationPitch);
					world.spawnEntity(zombieDipsy);
				}
				
				if(event.getEntity() instanceof EntityLaaLaa && randomNumber == 1) {
					EntityZombieLaaLaa zombieLaaLaa = new EntityZombieLaaLaa(world);
					EntityLaaLaa.transferredToZombie = true;
					zombieLaaLaa.setLocationAndAngles(posX, posY, posZ, event.getEntityLiving().rotationYaw, event.getEntityLiving().rotationPitch);
					world.spawnEntity(zombieLaaLaa);
				}
				
				if(event.getEntity() instanceof EntityPo && randomNumber == 1) {
					EntityZombiePo zombiePo = new EntityZombiePo(world);
					EntityPo.transferredToZombie = true;
					zombiePo.setLocationAndAngles(posX, posY, posZ, event.getEntityLiving().rotationYaw, event.getEntityLiving().rotationPitch);
					world.spawnEntity(zombiePo);
				}
			}
		}
	}*/
}
