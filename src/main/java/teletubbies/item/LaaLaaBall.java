package teletubbies.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class LaaLaaBall extends Item{
	
	private final String name = "LaaLaaBall";
	
	public LaaLaaBall() {
		maxStackSize = 1;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
	
	@Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		float yaw = player.rotationYaw;
		float pitch = player.rotationPitch;
		float movingAmount = 1.0F;
		double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
		double motionY = 1.0F;
		double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
		
		if(player.onGround && !player.isInWater()){
			player.addVelocity(motionX, motionY, motionZ);
			if(player instanceof EntityPlayerMP && !player.worldObj.isRemote) {
				((EntityPlayerMP) player).playerNetServerHandler.sendPacket(new S12PacketEntityVelocity(player));
			}
		    player.jump();
			world.playSoundAtEntity(player, "teletubbies:ball.bounce", 1, 1);
		}
		return itemstack;
    }
}