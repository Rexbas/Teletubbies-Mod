package teletubbies.item;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.LazyOptional;
import teletubbies.Teletubbies;
import teletubbies.common.capabilities.IJumpCapability;
import teletubbies.common.capabilities.JumpProvider;
import teletubbies.init.TeletubbiesSounds;

public class LaaLaaBallItem extends Item {
		
	public LaaLaaBallItem() {
		super(new Item.Properties()
				.stacksTo(1)
				.tab(Teletubbies.ITEMGROUP));
	}
	
	@Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {	
		ItemStack stack = player.getItemInHand(hand);
		
		if(hand == InteractionHand.OFF_HAND && player.getMainHandItem() != null && player.getMainHandItem().getItem() instanceof LaaLaaBallItem) {
	        return new InteractionResultHolder<ItemStack>(InteractionResult.FAIL, stack);
		}
				
		LazyOptional<IJumpCapability> cap = player.getCapability(JumpProvider.JUMP_CAPABILITY, player.getDirection());
		AtomicReference<InteractionResult> ar = new AtomicReference<>();
		ar.set(InteractionResult.FAIL);
		
		if(!cap.isPresent()) {
	        return new InteractionResultHolder<ItemStack>(InteractionResult.FAIL, stack);
		}
		
		cap.ifPresent(c -> {
			if(c.canJump(player) && c.check()) {
				LaaLaaBallItem.jump(player, false);
				ar.set(InteractionResult.PASS);
			}
		});
		
        return new InteractionResultHolder<ItemStack>(ar.get(), stack);
    }
	
	public static void jump(Player player, boolean fallJump) {
		LazyOptional<IJumpCapability> cap = player.getCapability(JumpProvider.JUMP_CAPABILITY, player.getDirection());

		cap.ifPresent(c -> {
			float fallDistance = c.fallDistance();
			double motionY;
			
			if(fallJump) motionY = 1 + fallDistance / 100;
			else motionY = 1;
			
			float yaw = player.yRot;
			float pitch = player.xRot;
			float movingAmount = 1.0F;
			double motionX = (double)(-Mth.sin(yaw / 180.0F * (float)Math.PI) * Mth.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
			double motionZ = (double)(Mth.cos(yaw / 180.0F * (float)Math.PI) * Mth.cos(pitch / 180.0F * (float)Math.PI) * movingAmount);
			
			player.push(motionX, motionY, motionZ);
		    Random rand = new Random();
		    float pitch1 = (float) (rand.nextFloat() * (1.1 - 0.9) + 0.9);
			player.playSound(TeletubbiesSounds.BALL_BOUNCE.get(), 1, pitch1);
		});
	}
}