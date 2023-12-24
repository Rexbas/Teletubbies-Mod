package com.rexbas.teletubbies.block.entity;

import com.rexbas.teletubbies.block.CustardMachineBlock;
import com.rexbas.teletubbies.init.TeletubbiesBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;

import javax.annotation.Nullable;

public class CustardMachineSlaveBlockEntity extends BlockEntity {

	public CustardMachineSlaveBlockEntity(BlockPos pos, BlockState state) {
		super(TeletubbiesBlocks.CUSTARD_MACHINE_SLAVE_BLOCK_ENTITY.get(), pos, state);
	}

	public IItemHandler getItemHandler(@Nullable Direction side) {
		BlockPos masterPos = CustardMachineBlock.getBasePos(worldPosition, this.getBlockState().getValue(CustardMachineBlock.PART), this.getBlockState().getValue(CustardMachineBlock.FACING));

		if (level.getBlockEntity(masterPos) instanceof CustardMachineBlockEntity master) {
			return master.getItemHandler(side);
		}

		return null;
	}
}