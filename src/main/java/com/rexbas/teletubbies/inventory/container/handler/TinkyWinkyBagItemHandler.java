package com.rexbas.teletubbies.inventory.container.handler;

import com.google.common.collect.Lists;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.items.ItemStackHandler;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TinkyWinkyBagItemHandler extends ItemStackHandler {
	
	private final ItemStack stack;
	
	public TinkyWinkyBagItemHandler(ItemStack stack) {
		super(54);
		this.stack = stack;
	}
	
    @Override
    protected void onContentsChanged(int slot) {
        super.onContentsChanged(slot);
        save();
    }
    
    public void save() {
        CompoundTag nbt = stack.getOrCreateTag();
        nbt.put("Inventory", serializeNBT());
    }
    
    public void load() {
        CompoundTag nbt = stack.getOrCreateTag();
        if (nbt.contains("Inventory")) {
            deserializeNBT(nbt.getCompound("Inventory"));
        }
    }

	public void fillInventory(LootTable table, LootParams lootParams) {
		List<ItemStack> list = table.getRandomItems(lootParams);
		List<Integer> list1 = getEmptySlotsRandomized();
		shuffleItems(list, list1.size(), lootParams.getLevel().getRandom());

		for (ItemStack itemstack : list) {
			if (list1.isEmpty()) {
				return;
			}

			if (itemstack.isEmpty()) {
				setStackInSlot(list1.remove(list1.size() - 1), ItemStack.EMPTY);
			}
			else {
				setStackInSlot(list1.remove(list1.size() - 1), itemstack);
			}
		}
	}
	
	private List<Integer> getEmptySlotsRandomized() {
		List<Integer> list = Lists.newArrayList();

		for (int i = 0; i < stacks.size(); ++i) {
			if (getStackInSlot(i).isEmpty()) {
				list.add(i);
			}
		}
		
		Collections.shuffle(list);
		return list;
	}
	
	private void shuffleItems(List<ItemStack> stacks, int size, RandomSource rand) {
		List<ItemStack> list = Lists.newArrayList();
		Iterator<ItemStack> iterator = stacks.iterator();

		while (iterator.hasNext()) {
			ItemStack itemstack = iterator.next();
			if (itemstack.isEmpty()) {
				iterator.remove();
			} else if (itemstack.getCount() > 1) {
				list.add(itemstack);
				iterator.remove();
			}
		}

		while (size - stacks.size() - list.size() > 0 && !list.isEmpty()) {
			ItemStack itemstack2 = list.remove(Mth.nextInt(rand, 0, list.size() - 1));
			int i = Mth.nextInt(rand, 1, itemstack2.getCount() / 2);
			ItemStack itemstack1 = itemstack2.split(i);
			if (itemstack2.getCount() > 1 && rand.nextBoolean()) {
				list.add(itemstack2);
			} else {
				stacks.add(itemstack2);
			}

			if (itemstack1.getCount() > 1 && rand.nextBoolean()) {
				list.add(itemstack1);
			} else {
				stacks.add(itemstack1);
			}
		}

		stacks.addAll(list);
		Collections.shuffle(stacks);
	}
}
