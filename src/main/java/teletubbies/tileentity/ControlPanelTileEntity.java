package teletubbies.tileentity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import teletubbies.init.TeletubbiesBlocks;
import teletubbies.inventory.container.ControlPanelContainer;
import teletubbies.inventory.container.handler.ControlPanelItemHandler;

public class ControlPanelTileEntity extends BlockEntity implements MenuProvider {

	private ControlPanelItemHandler inputHandler = new ControlPanelItemHandler();
	
	public ControlPanelTileEntity() {
		super(TeletubbiesBlocks.CONTROL_PANEL_TILE.get());
	}

	@Override
	public AbstractContainerMenu createMenu(final int windowID, final Inventory playerInv, final Player playerIn) {
		return new ControlPanelContainer(windowID, playerInv, this);
	}
	
	@Override
	public void load(BlockState state, CompoundTag nbt) {
		super.load(state, nbt);
		this.inputHandler.deserializeNBT(nbt.getCompound("InventoryIn"));
	}

	@Override
	public CompoundTag save(CompoundTag nbt) {
		super.save(nbt);
		nbt.put("InventoryIn", this.inputHandler.serializeNBT());
		return nbt;
	}
	
	@Nullable
	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		CompoundTag nbt = new CompoundTag();
		this.save(nbt);
		return new ClientboundBlockEntityDataPacket(this.worldPosition, 0, nbt);
	}

	@Override
	public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
		this.load(level.getBlockState(pkt.getPos()), pkt.getTag());
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag nbt = new CompoundTag();
		this.save(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(BlockState state, CompoundTag nbt) {
		this.load(state, nbt);
	}
	
	@Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			// Can empty any ItemHandlers (Bags)
			if (side == Direction.DOWN) {
				if (inputHandler.getStackInSlot(0).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent()) {
					LazyOptional<IItemHandler> bagHandler = inputHandler.getStackInSlot(0).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
					return bagHandler.cast();
				}
			}
			else {
				LazyOptional<IItemHandler> instance = LazyOptional.of(() -> inputHandler);
				return instance.cast();
			}
		}
		return super.getCapability(cap, side);
	}

	@Override
	public Component getDisplayName() {
		return new TranslatableComponent("block.teletubbies.control_panel");
	}
}
