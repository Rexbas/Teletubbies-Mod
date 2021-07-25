package teletubbies.inventory.container;

import java.util.Objects;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.init.TeletubbiesContainers;
import teletubbies.inventory.container.handler.ToastMachineItemHandler;
import teletubbies.inventory.container.slot.SpecificItemSlot;
import teletubbies.tileentity.ToastMachineTileEntity;

public class ToastMachineContainer extends AbstractContainerMenu {
	
	private final Inventory playerInventory;
	private final ToastMachineTileEntity tileentity;
	
	// Client Constructor
	public ToastMachineContainer(final int id, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(id, playerInventory, getTileEntity(playerInventory, data));
	}

	// Server Constructor
	public ToastMachineContainer(int id, Inventory playerInventory, ToastMachineTileEntity te) {
		super(TeletubbiesContainers.TOAST_MACHINE_CONTAINER.get(), id);
		
		this.playerInventory = playerInventory;
		this.tileentity = te;
		
		ToastMachineItemHandler handler = (ToastMachineItemHandler) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
		
		addMachineSlots(handler);
		addPlayerSlots();
	}
	
	private void addMachineSlots(ToastMachineItemHandler handler) {
		this.addSlot(new SpecificItemSlot(handler, 0, 61, 37, Items.WHEAT));
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
			int slotcount = slots.size() - playerIn.inventory.items.size();
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
	private static ToastMachineTileEntity getTileEntity(final Inventory playerInv, final FriendlyByteBuf data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final BlockEntity tileAtPos = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof ToastMachineTileEntity) {
			return (ToastMachineTileEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}
	
	public ToastMachineTileEntity getTileEntity() {
		return this.tileentity;
	}
}
