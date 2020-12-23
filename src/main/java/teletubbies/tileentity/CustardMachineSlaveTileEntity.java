package teletubbies.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.block.BlockList;
import teletubbies.block.CustardMachineBlock;

public class CustardMachineSlaveTileEntity extends TileEntity{

	public CustardMachineSlaveTileEntity() {
		super(BlockList.CUSTARD_MACHINE_SLAVE_TILE);
	}
	
	@Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {		
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			BlockPos masterPos = CustardMachineBlock.getBasePos(pos, this.getBlockState().get(CustardMachineBlock.PART), this.getBlockState().get(CustardMachineBlock.FACING));
			
			if (world.getTileEntity(masterPos) instanceof CustardMachineTileEntity) {
				CustardMachineTileEntity master = (CustardMachineTileEntity) world.getTileEntity(masterPos);
				return master.getCapability(cap, side);
			}
		}
		return super.getCapability(cap, side);
	}
}
