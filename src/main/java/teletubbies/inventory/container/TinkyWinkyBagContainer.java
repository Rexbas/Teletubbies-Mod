package teletubbies.inventory.container;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;
import teletubbies.inventory.container.slot.TinkyWinkyBagSlot;
import teletubbies.item.TinkyWinkyBagItem;

// https://github.com/Flanks255/simplybackpacks/tree/master/src/main/java/com/flanks255/simplybackpacks

public class TinkyWinkyBagContainer extends Container {
	public final int numRows = 6;
	private final PlayerInventory playerInventory;
	public ItemStack bag;
	
	public TinkyWinkyBagContainer(final int id, final PlayerInventory playerInventory, PacketBuffer data) {
		this(id, playerInventory,
				playerInventory.player.getHeldItemMainhand().getItem() instanceof TinkyWinkyBagItem
						? playerInventory.player.getHeldItemMainhand()
						: playerInventory.player.getHeldItemOffhand());
    }

	public TinkyWinkyBagContainer(int id, PlayerInventory playerInventory, ItemStack bag) {
		super(ContainerList.TINKYWINKY_BAG_CONTAINER.get(), id);
		this.playerInventory = playerInventory;
		this.bag = bag;
		
		TinkyWinkyBagItemHandler handler = (TinkyWinkyBagItemHandler) bag.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
        handler.load();

		addBagSlots(handler);
		addPlayerSlots();
	}
	
	private void addBagSlots(TinkyWinkyBagItemHandler handler) {
		for (int j = 0; j < this.numRows; ++j) {
			for (int k = 0; k < 9; ++k) {
				this.addSlot(new TinkyWinkyBagSlot(handler, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}
	}
	
	private void addPlayerSlots() {
		int i = (this.numRows - 4) * 18;

		for (int l = 0; l < 3; ++l) {
			for (int j1 = 0; j1 < 9; ++j1) {
				this.addSlot(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
			}
		}

		for (int i1 = 0; i1 < 9; ++i1) {
			this.addSlot(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + i));
		}
	}

	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(index);

		if (slot != null && slot.getHasStack()) {
			int bagslotcount = inventorySlots.size() - playerIn.inventory.mainInventory.size();
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();
			if (index < bagslotcount) {
				if (!this.mergeItemStack(itemstack1, bagslotcount, this.inventorySlots.size(), true))
					return ItemStack.EMPTY;
			} else if (!this.mergeItemStack(itemstack1, 0, bagslotcount, false)) {
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
		return !bag.isEmpty();
	}

	@Override
	public ItemStack slotClick(int slot, int dragType, ClickType clickTypeIn, PlayerEntity player) {
		if (slot >= 0) {
			if (getSlot(slot).getStack().getItem() instanceof TinkyWinkyBagItem)
				return ItemStack.EMPTY;
		}
		if (clickTypeIn == ClickType.SWAP)
			return ItemStack.EMPTY;

		if (slot >= 0)
			getSlot(slot).inventory.markDirty();
		return super.slotClick(slot, dragType, clickTypeIn, player);
	}
}
