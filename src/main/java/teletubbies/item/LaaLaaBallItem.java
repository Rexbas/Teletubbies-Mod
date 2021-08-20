package teletubbies.item;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import teletubbies.Teletubbies;
import teletubbies.capabilities.IJumpCapability;
import teletubbies.capabilities.JumpProvider;
import teletubbies.init.TeletubbiesSounds;

public class LaaLaaBallItem extends Item {
		
	public LaaLaaBallItem() {
		super(new Item.Properties()
				.stacksTo(1)
				.tab(Teletubbies.ITEMGROUP));
	}
	
	@Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {	
		ItemStack stack = player.getItemInHand(hand);
		
		if(hand == Hand.OFF_HAND && player.getMainHandItem() != null && player.getMainHandItem().getItem() instanceof LaaLaaBallItem) {
	        return new ActionResult<ItemStack>(ActionResultType.FAIL, stack);
		}
				
		LazyOptional<IJumpCapability> cap = player.getCapability(JumpProvider.JUMP_CAPABILITY, player.getDirection());
		AtomicReference<ActionResultType> ar = new AtomicReference<>();
		ar.set(ActionResultType.FAIL);
		
		if(!cap.isPresent()) {
	        return new ActionResult<ItemStack>(ActionResultType.FAIL, stack);
		}
		
		cap.ifPresent(c -> {
			if(c.canJump(player) && c.check()) {
				LaaLaaBallItem.jump(player, false);
				ar.set(ActionResultType.PASS);
			}
		});
		
        return new ActionResult<ItemStack>(ar.get(), stack);
    }
	
	public static void jump(PlayerEntity player, boolean fallJump) {
		LazyOptional<IJumpCapability> cap = player.getCapability(JumpProvider.JUMP_CAPABILITY, player.getDirection());

		cap.ifPresent(c -> {
			float fallDistance = c.fallDistance();
			double motionY;
			
			if(fallJump) motionY = 1 + fallDistance / 100;
			else motionY = 1;
			
			float yaw = player.yRot;
			float pitch = player.xRot;
			float movingAmount = 1.0F;
			double motionX = (double)(-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
			double motionZ = (double)(MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
			
			player.push(motionX, motionY, motionZ);
		    Random rand = new Random();
		    float pitch1 = (float) (rand.nextFloat() * (1.1 - 0.9) + 0.9);
			player.playSound(TeletubbiesSounds.BALL_BOUNCE.get(), 1, pitch1);
		});
	}
}