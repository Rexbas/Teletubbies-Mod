package teletubbies.inventory.container;

import java.util.Objects;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.inventory.container.handler.ControlPanelItemHandler;
import teletubbies.inventory.container.slot.ItemHandlerSlot;
import teletubbies.tileentity.ControlPanelTileEntity;

public class ControlPanelContainer extends Container {

	private final PlayerInventory playerInventory;
	private final ControlPanelTileEntity tileentity;
	
	// Client Constructor
	public ControlPanelContainer(final int id, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(id, playerInventory, getTileEntity(playerInventory, data));
	}

	// Server Constructor
	public ControlPanelContainer(int id, PlayerInventory playerInventory, ControlPanelTileEntity te) {
		super(ContainerList.CONTROL_PANEL_CONTAINER.get(), id);
		
		this.playerInventory = playerInventory;
		this.tileentity = te;
		
		ControlPanelItemHandler inputHandler = (ControlPanelItemHandler) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
		
		addMachineSlots(inputHandler);
		addPlayerSlots();
	}
	
	private void addMachineSlots(ControlPanelItemHandler inputHandler) {
		this.addSlot(new ItemHandlerSlot(inputHandler, 0, 80, 37));
	}
	
	private void addPlayerSlots() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 142));
		}
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			int slotcount = inventorySlots.size() - playerIn.inventory.mainInventory.size();
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < slotcount) {
				if (!this.mergeItemStack(itemstack1, slotcount, this.inventorySlots.size(), true))
					return ItemStack.EMPTY;
			} else if (!this.mergeItemStack(itemstack1, 0, slotcount, false)) {
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty())
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();
		}
		return itemstack;
	}

	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return true;
	}
	
	// https://github.com/DaRealTurtyWurty/1.15-Tut-Mod/blob/master/src/main/java/com/turtywurty/tutorialmod/container/ExampleFurnaceContainer.java
	private static ControlPanelTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof ControlPanelTileEntity) {
			return (ControlPanelTileEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}
	
	public ControlPanelTileEntity getTileEntity() {
		return this.tileentity;
	}
}
