package com.rexbas.teletubbies.block;

import com.rexbas.teletubbies.block.entity.ControlPanelBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ControlPanelBlock extends Block implements EntityBlock {

	public ControlPanelBlock() {
		super(Properties.of()
				.mapColor(MapColor.METAL)
				.strength(3.0f, 5.0f));
	}
	
	@Override
    @Nullable
	public BlockPathTypes getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, @Nullable Mob entity) {
        return BlockPathTypes.BLOCKED;
    }
	
	@Override
	public @NotNull InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
		ControlPanelBlockEntity te = (ControlPanelBlockEntity) world.getBlockEntity(pos);

		if (!world.isClientSide && player instanceof ServerPlayer) {
			NetworkHooks.openScreen((ServerPlayer) player, te, pos);
		}
		return InteractionResult.SUCCESS;
	}
	
	@Nullable
	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new ControlPanelBlockEntity(pos, state);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.hasBlockEntity() && state.getBlock() != newState.getBlock()) {
			IItemHandler handler = world.getCapability(Capabilities.ItemHandler.BLOCK, pos, state, world.getBlockEntity(pos), null);
			if (handler != null) {
				for (int i = 0; i < handler.getSlots(); i++) {
					popResource(world, pos, handler.getStackInSlot(i));
				}
			}
			world.removeBlockEntity(pos);
		}
	}
}