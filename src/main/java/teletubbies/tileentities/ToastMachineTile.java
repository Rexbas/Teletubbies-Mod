package teletubbies.tileentities;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import teletubbies.lists.BlockList;
import teletubbies.util.Converter;

public class ToastMachineTile extends TileEntity implements ITickableTileEntity {

	private static final int DROPTICKS = Converter.SecondsToTicks(1);
	
	private int ticksSinceLastDrop;
	
	public ToastMachineTile() {
		super(BlockList.toastMachineTile);
		ticksSinceLastDrop = DROPTICKS;
	}

	@Override
	public void tick() {
		if (ticksSinceLastDrop < DROPTICKS) {
			ticksSinceLastDrop++;
		}
	}
	
	public boolean canDrop() {
		return ticksSinceLastDrop >= DROPTICKS;
	}
	
	public void reset() {
		ticksSinceLastDrop = 0;
	}
	
	public void dropToast(ItemStack stack, PlayerEntity player) {
		if (!world.isRemote) {
        	ItemEntity item = new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 1.6, pos.getZ() + 0.5, stack);
            
        	double d2 = 0.3;
        	double motionX = Math.sin(player.rotationYaw / 180.0 * Math.PI) * Math.cos(player.rotationPitch / 180.0 * Math.PI) * d2;
        	double motionY = -Math.sin(player.rotationPitch / 180.0 * Math.PI) * d2 + 0.1 + 0.2;
        	double motionZ = -Math.cos(player.rotationYaw / 180.0 * Math.PI) * Math.cos(player.rotationPitch / 180.0 * Math.PI) * d2;
        	double d3 = world.rand.nextDouble() * Math.PI * 2.0;
            d2 = 0.02 * world.rand.nextDouble();
            motionX += Math.cos(d3) * d2;
            motionY += (world.rand.nextDouble() - world.rand.nextDouble()) * 0.1 + 0.1;
            motionZ += Math.sin(d3) * d2;
            
        	item.setMotion(motionX, motionY, motionZ);

        	world.addEntity(item);
    	}
	}
}
