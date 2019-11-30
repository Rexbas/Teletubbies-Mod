package teletubbies.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.util.Constants;
import teletubbies.item.TinkyWinkyBag;

public class InventoryTinkyWinkyBag implements IInventory {
		
	public ItemStack[] content;
	public int size;
	public ItemStack stackInHand;

	public InventoryTinkyWinkyBag(int size, ItemStack stackInHand) {
		this.size = size;
		this.content = new ItemStack[size];
		this.stackInHand = stackInHand;
		if(!stackInHand.hasTagCompound()) stackInHand.setTagCompound(new NBTTagCompound());
		//this.readFromNBT(stackInHand.getTagCompound());
	}

	public void readFromNBT(NBTTagCompound comp) {
		NBTTagList nbtlist = comp.getTagList("Inventory", Constants.NBT.TAG_COMPOUND);
		for (int i = 0; i < nbtlist.tagCount(); i++) {
			NBTTagCompound comp1 = nbtlist.getCompoundTagAt(i);
			int slot = comp1.getInteger("Slot");
			this.content[slot] = ItemStack.loadItemStackFromNBT(comp1);
		}
	}

	public void writeToNBT(NBTTagCompound comp) {
		NBTTagList nbtlist = new NBTTagList();
		for (int i = 0; i < this.size; i++) {
			if (this.content[i] != null) {
				NBTTagCompound comp1 = new NBTTagCompound();
				comp1.setInteger("Slot", i);
				this.content[i].writeToNBT(comp1);
				nbtlist.appendTag(comp1);
			}
		}
		comp.setTag("Inventory", nbtlist);
	}

	@Override
	public int getSizeInventory() {
		return this.size;

	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return this.content[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int amount) {
		ItemStack stack = getStackInSlot(index);
		if (stack != null) {
			if (stack.stackSize > amount) {
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0) this.content[index] = null;
			} 
			else {
				this.content[index] = null;
			}
		}
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		this.content[index] = stack;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return !(stack.getItem() instanceof TinkyWinkyBag);
	}

	@Override
	public String getName() {
		return "container.TinkyWinkyBag";
	}

	@Override
	public boolean hasCustomName() {
		return true;
	}

	@Override
	public ITextComponent getDisplayName() {
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack stack = getStackInSlot(index);
		if (stack != null) this.content[index] = null;
		return stack;
	}

	@Override
	public void openInventory(EntityPlayer player) {
		
	}

	@Override
	public void closeInventory(EntityPlayer player) {
		
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {
		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {
		
	}
}