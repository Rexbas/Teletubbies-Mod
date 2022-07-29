package com.rexbas.teletubbies.itemgroup;

import com.rexbas.teletubbies.init.TeletubbiesItems;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupTeletubbies extends ItemGroup {

	public ItemGroupTeletubbies(String name) {
		super(name);
	}

	@Override
	public ItemStack makeIcon() {
		return new ItemStack(TeletubbiesItems.PO_STICK.get());
	}
}
