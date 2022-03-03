package teletubbies.inventory.container;

import java.util.Objects;

import net.minecraft.core.Direction;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import teletubbies.blockentity.CustardMachineBlockEntity;
import teletubbies.init.TeletubbiesContainers;
import teletubbies.init.TeletubbiesItems;
import teletubbies.inventory.container.handler.CustardMachineItemHandler;
import teletubbies.inventory.container.slot.CustardMachineOutputSlot;
import teletubbies.inventory.container.slot.SpecificItemSlot;

public class CustardMachineContainer extends AbstractContainerMenu {
	
	private final Inventory playerInventory;
	private final CustardMachineBlockEntity blockentity;
	
	// Client Constructor
	public CustardMachineContainer(final int id, final Inventory playerInventory, final FriendlyByteBuf data) {
		this(id, playerInventory, getBlockEntity(playerInventory, data));
	}

	// Server Constructor
	public CustardMachineContainer(int id, Inventory playerInventory, CustardMachineBlockEntity be) {
		super(TeletubbiesContainers.CUSTARD_MACHINE_CONTAINER.get(), id);
		
		this.playerInventory = playerInventory;
		this.blockentity = be;
		
		CustardMachineItemHandler inputHandler = (CustardMachineItemHandler) be.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
		CustardMachineItemHandler outputHandler = (CustardMachineItemHandler) be.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.DOWN).orElse(null);
		
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
		this.addSlot(new SpecificItemSlot(inputHandler, 6, 32, 61, TeletubbiesItems.BOWL.get()));
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
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);

		if (slot != null && slot.hasItem()) {
			
			IItemHandler inputHandler = this.blockentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
			IItemHandler outputHandler = this.blockentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, Direction.DOWN).orElse(null);
			int numSlots = inputHandler.getSlots() + outputHandler.getSlots();
			
            ItemStack slotStack = slot.getItem();
			itemstack = slotStack.copy();
			if (index < numSlots) {
				if (!this.moveItemStackTo(slotStack, numSlots, this.slots.size(), true)) {
					return ItemStack.EMPTY;
				}
			} else if (!this.moveItemStackTo(slotStack, 0, numSlots, false)) {
				return ItemStack.EMPTY;
			}
			
			if (slotStack.isEmpty())
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
	private static CustardMachineBlockEntity getBlockEntity(final Inventory playerInv, final FriendlyByteBuf data) {
		Objects.requireNonNull(playerInv, "playerInv cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		final BlockEntity tileAtPos = playerInv.player.level.getBlockEntity(data.readBlockPos());
		if (tileAtPos instanceof CustardMachineBlockEntity) {
			return (CustardMachineBlockEntity) tileAtPos;
		}
		throw new IllegalStateException("TileEntity is not correct " + tileAtPos);
	}
	
	public CustardMachineBlockEntity getBlockEntity() {
		return this.blockentity;
	}
}
