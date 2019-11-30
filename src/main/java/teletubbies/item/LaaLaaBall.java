package teletubbies.item;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.capability.ITeletubbies_CAP;

public class LaaLaaBall extends Item {
	
	private final String name = "LaaLaaBall";
	
	public LaaLaaBall() {
		maxStackSize = 1;
		setUnlocalizedName(name);
		setCreativeTab(Teletubbies.tabTeletubbies);
	}
	
	@Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {	
		if(hand == EnumHand.OFF_HAND && player.getHeldItemMainhand() != null && player.getHeldItemMainhand().getItem() instanceof LaaLaaBall) {
	        return new ActionResult(EnumActionResult.FAIL, stack);
		}
		
		LaaLaaBall ball = (LaaLaaBall) stack.getItem();
		ITeletubbies_CAP capability = player.getCapability(Teletubbies.Teletubbies_CAP, player.getHorizontalFacing());
		if(capability.canJump() && capability.check()) {
			this.jump(player, false);
	        return new ActionResult(EnumActionResult.SUCCESS, stack);
		}
        return new ActionResult(EnumActionResult.FAIL, stack);
    }
	
	public static void jump(EntityPlayer player, boolean fallJump) {
		ITeletubbies_CAP capability = player.getCapability(Teletubbies.Teletubbies_CAP, player.getHorizontalFacing());
		float fallDistance = capability.fallDistance();
		double motionY;
		
		if(fallJump) motionY = 1 + fallDistance / 100;
		else motionY = 1;
		
		float yaw = player.rotationYaw;
		float pitch = player.rotationPitch;
		float movingAmount = 1.0F;
		double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
		double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
		
		player.addVelocity(motionX, motionY, motionZ);
	    Random rand = new Random();
	    float pitch1 = (float) (rand.nextFloat() * (1.1 - 0.9) + 0.9);
		player.playSound(Teletubbies.sound_Ball_Bounce, 1, pitch1);
	}
}