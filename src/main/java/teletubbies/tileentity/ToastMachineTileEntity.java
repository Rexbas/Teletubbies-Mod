package teletubbies.tileentity;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import teletubbies.block.BlockList;
import teletubbies.block.ToastMachineBlock;
import teletubbies.client.audio.SoundList;
import teletubbies.item.ItemList;
import teletubbies.util.Converter;
import teletubbies.util.RandomHelper;

public class ToastMachineTileEntity extends TileEntity implements ITickableTileEntity {

	private static final long DROPTICKS = Converter.SecondsToTicks(1);
	private long ticksSinceLastDrop;
	
	public ToastMachineTileEntity() {
		super(BlockList.TOAST_MACHINE_TILE);
		ticksSinceLastDrop = 0;
	}

	@Override
	public void tick() {
		if (!world.isRemote) {
			if (ticksSinceLastDrop < DROPTICKS) {
				ticksSinceLastDrop++;
			}
			
			if (ticksSinceLastDrop >= DROPTICKS && world.getBlockState(pos).get(ToastMachineBlock.POWERED)) {
				dropToast();
			}
		}
	}
	
	public void dropToast() {
		if (!world.isRemote) {
        	ItemEntity item = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.6, pos.getZ() + 0.5, new ItemStack(ItemList.TOAST));
        	
        	double motionX, motionY, motionZ;
        	
        	PlayerEntity player = world.getClosestPlayer(item.posX, item.posY, item.posZ, 5.5, false);
        	if (player != null) {
        		Vec3d v = new Vec3d(player.posX - item.posX, player.posY - item.posY, player.posZ - item.posZ);
        		v = v.scale(0.05);
        		motionX = v.getX();
        		motionZ = v.getZ();
        	}
        	else {
        		motionX = RandomHelper.getRandomNumber(-0.25, 0.25);
        		motionZ = RandomHelper.getRandomNumber(-0.25, 0.25);
        	}
        	
            motionY = RandomHelper.getRandomNumber(0.45, 0.6);

        	item.setMotion(motionX, motionY, motionZ);
        	world.addEntity(item);

        	float soundPitch = ToastMachineBlock.isUnderwater(world, pos) ? 0.5F : 1F;
			world.playSound(null, pos, SoundList.MACHINE_TOAST, SoundCategory.BLOCKS, 2, soundPitch);

			ticksSinceLastDrop = 0;
    	}
	}
}
