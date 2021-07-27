package teletubbies.inventory.container;

import java.util.Objects;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.init.TeletubbiesContainers;
import teletubbies.inventory.container.handler.ControlPanelItemHandler;
import teletubbies.inventory.container.slot.ItemHandlerSlot;
import teletubbies.tileentity.ControlPanelBlockEntity;

public class ControlPanelContainer extends AbstractContainerMenu {

	private final Inventory playerInventory;
	private final ControlPanelBlockEntity tileentity;
	
	// Client Constructor
	public ControlPanelContainer(final int id, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(id, playerInventory, getTileEntity(playerInventory, data));
	}

	// Server Constructor
	public ControlPanelContainer(int id, Inventory playerInventory, ControlPanelBlockEntity te) {
		super(TeletubbiesContainers.CONTROL_PANEL_CONTAINER.get(), id);
		
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
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);

		if (slot != null && slot.hasItem()) {
			int slotcount = slots.size() - playerIn.getInventory().getContainerSize();
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < slotcount) {
				if (!this.moveItemStackTo(itemstack1, slotcount, this.slots.size(), true))
					return ItemStack.EMPTY;
			} else if (!this.moveItemStackTo(itemstack1, 0, slotcount, false)) {
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty())
				slot.set(ItemStack.EMPTY);
			else
				slot.setChanged();
		}
		return itemstack;
	}

	@Override
	public boolean stillValid(Player playerIn) {
		return true;
	}
	
	// https://github.com/DaRealTurtyWurty/1.15-Tut-Mod/blob/master/src/main/java/com/turtywurty/tutorialmod/container/ExampleFurnaceContainer.java
	private static ControlPanelBlockEntity getTileEntity(final Inventory playerInv, final FriendlyByteBuf data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final BlockEntity tileAtPos = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof ControlPanelBlockEntity) {
			return (ControlPanelBlockEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}
	
	public ControlPanelBlockEntity getTileEntity() {
		return this.tileentity;
	}
}
