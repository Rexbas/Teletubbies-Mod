package teletubbies.inventory.container;

import java.util.Objects;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.inventory.container.handler.CustardMachineItemHandler;
import teletubbies.inventory.container.slot.CustardMachineOutputSlot;
import teletubbies.inventory.container.slot.SpecificItemSlot;
import teletubbies.item.ItemList;
import teletubbies.tileentity.CustardMachineTileEntity;

public class CustardMachineContainer extends Container {
	
	private final PlayerInventory playerInventory;
	private final CustardMachineTileEntity tileentity;
	
	// Client Constructor
	public CustardMachineContainer(final int id, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(id, playerInventory, getTileEntity(playerInventory, data));
	}

	// Server Constructor
	public CustardMachineContainer(int id, PlayerInventory playerInventory, CustardMachineTileEntity te) {
		super(ContainerList.CUSTARD_MACHINE_CONTAINER.get(), id);
		
		this.playerInventory = playerInventory;
		this.tileentity = te;
		
		CustardMachineItemHandler inputHandler = (CustardMachineItemHandler) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
		CustardMachineItemHandler outputHandler = (CustardMachineItemHandler) te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.DOWN).orElse(null);
		
		addMachineSlots(inputHandler, outputHandler);
		addPlayerSlots();
	}
	
	private void addMachineSlots(CustardMachineItemHandler inputHandler, CustardMachineItemHandler outputHandler) {
		for (int i = 0; i < 4; ++i) {
			this.addSlot(new SpecificItemSlot(inputHandler, i, 8, 16 + i * 18, Items.MILK_BUCKET));
			this.addSlot(new CustardMachineOutputSlot(outputHandler, i, 152, 16 + i * 18));
		}
		this.addSlot(new SpecificItemSlot(inputHandler, 4, 32, 25, Items.SUGAR));
		this.addSlot(new SpecificItemSlot(inputHandler, 5, 32, 43, Items.EGG));
		this.addSlot(new SpecificItemSlot(inputHandler, 6, 32, 61, ItemList.BOWL));
		this.addSlot(new CustardMachineOutputSlot(outputHandler, 4, 128, 43));
	}
	
	private void addPlayerSlots() {
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 105 + i * 18));
			}
		}

		for (int k = 0; k < 9; ++k) {
			this.addSlot(new Slot(playerInventory, k, 8 + k * 18, 163));
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
	private static CustardMachineTileEntity getTileEntity(final PlayerInventory playerInv, final PacketBuffer data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final TileEntity tileAtPos = playerInv.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof CustardMachineTileEntity) {
			return (CustardMachineTileEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}
	
	public CustardMachineTileEntity getTileEntity() {
		return this.tileentity;
	}
}
