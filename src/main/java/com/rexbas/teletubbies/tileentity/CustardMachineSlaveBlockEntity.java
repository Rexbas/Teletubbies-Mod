package com.rexbas.teletubbies.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

<<<<<<<< HEAD:src/main/java/com/rexbas/teletubbies/tileentity/CustardMachineSlaveBlockEntity.java
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
========
import com.rexbas.teletubbies.block.CustardMachineBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
>>>>>>>> origin/1.16:src/main/java/com/rexbas/teletubbies/tileentity/CustardMachineSlaveTileEntity.java
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;

public class CustardMachineSlaveBlockEntity extends BlockEntity {

	public CustardMachineSlaveBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.CUSTARD_MACHINE_SLAVE_BLOCK_ENTITY.get(), pos, state);
	}
	
	@Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {		
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			BlockPos masterPos = CustardMachineBlock.getBasePos(worldPosition, this.getBlockState().getValue(CustardMachineBlock.PART), this.getBlockState().getValue(CustardMachineBlock.FACING));
			
			if (level.getBlockEntity(masterPos) instanceof CustardMachineBlockEntity) {
				CustardMachineBlockEntity master = (CustardMachineBlockEntity) level.getBlockEntity(masterPos);
				return master.getCapability(cap, side);
			}
		}
		return super.getCapability(cap, side);
	}
}
