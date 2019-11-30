package teletubbies;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teletubbies.capability.ITeletubbies_CAP;
import teletubbies.capability.Teletubbies_CAPProvider;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;
import teletubbies.entity.passive.EntityDipsy;
import teletubbies.entity.passive.EntityLaaLaa;
import teletubbies.entity.passive.EntityPo;
import teletubbies.entity.passive.EntityTinkyWinky;
import teletubbies.item.LaaLaaBall;
import teletubbies.vehicle.EntityPoScooter;

public class TeletubbiesEventHandler {

	@SubscribeEvent
	public void attachtCapabilityEntity (AttachCapabilitiesEvent<Entity> event) {		
		if(event.getObject() instanceof EntityPlayer) {
			event.addCapability(new ResourceLocation(Teletubbies.MODID + ":TeletubbiesCap"), new Teletubbies_CAPProvider((EntityPlayer) event.getObject()));
		}
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event) {
		if(event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			World world = player.world;
			ITeletubbies_CAP capability = player.getCapability(Teletubbies.Teletubbies_CAP, player.getHorizontalFacing());
			float fallDistance = capability.fallDistance();
			
			int ticks = capability.ticksOnGround();
			
			if(player.onGround && ticks < 50) {
				capability.setTicksOnGround(ticks + 1);
			}
			if(!player.onGround && ticks != 0) {
				capability.setTicksOnGround(0);
			}
			if(player.fallDistance > fallDistance) {
				capability.setFallDistance(player.fallDistance);
			}
			
			LaaLaaBall ball = null;
			if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof LaaLaaBall &&
					player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof LaaLaaBall) {
				ball = (LaaLaaBall) player.getHeldItemMainhand().getItem();
			}
			else if(player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof LaaLaaBall) {
				ball = (LaaLaaBall) player.getHeldItemMainhand().getItem();
			}
			else if(player.getHeldItemOffhand() != null && player.getHeldItemOffhand().getItem() instanceof LaaLaaBall) {
				ball = (LaaLaaBall) player.getHeldItemOffhand().getItem();
			}
			
			if(ball != null) {
				if(capability.canJump() && fallDistance >= 10) {
					LaaLaaBall.jump(player, true);
				}
			}
			if(player.onGround) {
				capability.setFallDistance(0);
			}
			if(player.isInWater() || player.isInLava()) {
				capability.setFallDistance(0);
			}
		}
	}
	
	@SubscribeEvent
	public void fallEvent(LivingFallEvent event) {
		if(event.getEntityLiving() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			if(player.getHeldItemMainhand() != null) {
				if(player.getHeldItemMainhand().getItem() instanceof LaaLaaBall) {
					event.setCanceled(true);
				}
			}
			if(player.getHeldItemOffhand() != null) {
				if(player.getHeldItemOffhand().getItem() instanceof LaaLaaBall) {
					event.setCanceled(true);
				}
			}
		}
		if(event.getEntity() instanceof EntityPoScooter) {
			EntityPoScooter scooter = (EntityPoScooter) event.getEntity();
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
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
	}
}
