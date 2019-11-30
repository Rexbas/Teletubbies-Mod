package teletubbies;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import teletubbies.entity.monster.EntityZombieDipsy;
import teletubbies.entity.monster.EntityZombieLaaLaa;
import teletubbies.entity.monster.EntityZombiePo;
import teletubbies.entity.monster.EntityZombieTinkyWinky;
import teletubbies.entity.passive.EntityDipsy;
import teletubbies.entity.passive.EntityLaaLaa;
import teletubbies.entity.passive.EntityPo;
import teletubbies.entity.passive.EntityTinkyWinky;
import teletubbies.gui.config.TeletubbiesConfigurationHandler;
import teletubbies.item.LaaLaaBall;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class TeletubbiesEventHandler {

	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent event){
		if(event.entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			World world = player.worldObj;
			float fallDistance = player.getEntityData().getFloat("LaaLaaBall_fallDistance");
			
			if(!world.isRemote && player.fallDistance >= fallDistance){
				setFallDistance(player, player.fallDistance);
			}		

			if(player.getHeldItem() != null && !world.isRemote){
				String hand = player.getHeldItem().getUnlocalizedName();
				String laaLaaBall = Teletubbies.laaLaaBall.getUnlocalizedName();
				if(hand.equals(laaLaaBall) && player.onGround && !player.isInWater()){
					ItemStack heldItem = player.getHeldItem();
					LaaLaaBall ball = (LaaLaaBall) heldItem.getItem();
					if(fallDistance >= 10){
						float yaw = player.rotationYaw;
						float pitch = player.rotationPitch;
						float movingAmount = 1.0F;
						double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
						double motionY = 1.0 + fallDistance / 90; 
						double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
						
						player.addVelocity(motionX, motionY, motionZ);
						if(player instanceof EntityPlayerMP && !player.worldObj.isRemote) {
							((EntityPlayerMP) player).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(player));
						}
						player.jump();
						setFallDistance(player, 0);
						world.playSoundAtEntity(player, "teletubbies:ball.bounce", 0.8F, 1);
					}
				}
				if(!hand.equals(laaLaaBall) && player.onGround){
					setFallDistance(player, 0);
				}
				if(player.isInWater()){
					setFallDistance(player, 0);
				}
			}
			if(player.getHeldItem() == null){
				setFallDistance(player, 0);
			}
		}
	}
	
	public void setFallDistance(EntityPlayer player, float value){
		player.getEntityData().setFloat("LaaLaaBall_fallDistance", value);
	}
	
	@SubscribeEvent
	public void onPlayerDamage(LivingAttackEvent event){
		if(event.entityLiving instanceof EntityPlayer && event.source == DamageSource.fall){
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			if(player.getHeldItem() != null){
				String hand = player.getHeldItem().getUnlocalizedName();
				String laaLaaBall = Teletubbies.laaLaaBall.getUnlocalizedName();
				if(hand.equals(laaLaaBall)){
					event.setCanceled(true);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event){
		if(event.entity instanceof EntityZombie && TeletubbiesConfigurationHandler.zombiesAttacksTeletubbies == true) {
			EntityZombie Zombie = (EntityZombie) event.entity;
	        Zombie.tasks.addTask(2, new EntityAIAttackOnCollide(Zombie, EntityPo.class, 1.0D, false));
	        Zombie.tasks.addTask(2, new EntityAIAttackOnCollide(Zombie, EntityLaaLaa.class, 1.0D, false));
	        Zombie.tasks.addTask(2, new EntityAIAttackOnCollide(Zombie, EntityDipsy.class, 1.0D, false));
	        Zombie.tasks.addTask(2, new EntityAIAttackOnCollide(Zombie, EntityTinkyWinky.class, 1.0D, false));
	        Zombie.targetTasks.addTask(2, new EntityAINearestAttackableTarget(Zombie, EntityPo.class, 0, true));
	        Zombie.targetTasks.addTask(2, new EntityAINearestAttackableTarget(Zombie, EntityLaaLaa.class, 0, true));
	        Zombie.targetTasks.addTask(2, new EntityAINearestAttackableTarget(Zombie, EntityDipsy.class, 0, true));
	        Zombie.targetTasks.addTask(2, new EntityAINearestAttackableTarget(Zombie, EntityTinkyWinky.class, 0, true));
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onLivingDeathEvent(LivingDeathEvent event){
		Random rand = new Random();
		int randomNumber = rand.nextInt(5) + 1;
		DamageSource damageSource = (DamageSource) event.source;
		World world = event.entityLiving.worldObj;
		double posX = event.entityLiving.posX;
		double posY = event.entityLiving.posY;
		double posZ = event.entityLiving.posZ;

		if(!world.isRemote){
			if(damageSource.getEntity() instanceof EntityZombieTinkyWinky || 
					damageSource.getEntity() instanceof EntityZombieDipsy || 
					damageSource.getEntity() instanceof EntityZombieLaaLaa || 
					damageSource.getEntity() instanceof EntityZombiePo || 
					damageSource.getEntity() instanceof EntityZombie){
				
				if(event.entity instanceof EntityTinkyWinky && randomNumber == 1){
					EntityZombieTinkyWinky zombieTinkyWinky = new EntityZombieTinkyWinky(world);
					EntityTinkyWinky.transferredToZombie = true;
					zombieTinkyWinky.setLocationAndAngles(posX, posY, posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
					world.spawnEntityInWorld(zombieTinkyWinky);
				}
				
				if(event.entity instanceof EntityDipsy && randomNumber == 1){
					EntityZombieDipsy zombieDipsy = new EntityZombieDipsy(world);
					EntityDipsy.transferredToZombie = true;
					zombieDipsy.setLocationAndAngles(posX, posY, posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
					world.spawnEntityInWorld(zombieDipsy);
				}
				
				if(event.entity instanceof EntityLaaLaa && randomNumber == 1){
					EntityZombieLaaLaa zombieLaaLaa = new EntityZombieLaaLaa(world);
					EntityLaaLaa.transferredToZombie = true;
					zombieLaaLaa.setLocationAndAngles(posX, posY, posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
					world.spawnEntityInWorld(zombieLaaLaa);
				}
				
				if(event.entity instanceof EntityPo && randomNumber == 1){
					EntityZombiePo zombiePo = new EntityZombiePo(world);
					EntityPo.transferredToZombie = true;
					zombiePo.setLocationAndAngles(posX, posY, posZ, event.entityLiving.rotationYaw, event.entityLiving.rotationPitch);
					world.spawnEntityInWorld(zombiePo);
				}
			}
		}
	}
	
    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
    	if(event.modID.equals(Teletubbies.MODID)){
    		TeletubbiesConfigurationHandler.syncConfig();
    	}
    }
	    
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(PlayerTickEvent event){
		if(!Teletubbies.haveWarnedVersionOutOfDate && event.player.worldObj.isRemote && !Teletubbies.updateChecker.isLatestVersion() && TeletubbiesConfigurationHandler.showUpdateCheck == true){
			Teletubbies.updateChecker.updateStatus(event.player);
		}
	}
}
