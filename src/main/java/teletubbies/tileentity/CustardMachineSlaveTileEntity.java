package teletubbies.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.block.CustardMachineBlock;
import teletubbies.init.TeletubbiesBlocks;

public class CustardMachineSlaveTileEntity extends BlockEntity{

	public CustardMachineSlaveTileEntity() {
		super(TeletubbiesBlocks.CUSTARD_MACHINE_SLAVE_TILE.get());
	}
	
	@Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {		
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			BlockPos masterPos = CustardMachineBlock.getBasePos(worldPosition, this.getBlockState().getValue(CustardMachineBlock.PART), this.getBlockState().getValue(CustardMachineBlock.FACING));
			
			if (level.getBlockEntity(masterPos) instanceof CustardMachineTileEntity) {
				CustardMachineTileEntity master = (CustardMachineTileEntity) level.getBlockEntity(masterPos);
				return master.getCapability(cap, side);
			}
		}
		return super.getCapability(cap, side);
	}
}
