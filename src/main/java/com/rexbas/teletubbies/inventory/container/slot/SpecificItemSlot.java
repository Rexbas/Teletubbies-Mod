package com.rexbas.teletubbies.inventory.container.slot;

import javax.annotation.Nonnull;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SpecificItemSlot extends SlotItemHandler {

	public static final Tag<Item> GRAIN = ItemTags.createOptional(new ResourceLocation("forge", "grain"));
	public static final Tag<Item> MILK = ItemTags.createOptional(new ResourceLocation("forge", "milk"));
	public static final Tag<Item> EGG = ItemTags.createOptional(new ResourceLocation("forge", "egg"));
	public static final Tag<Item> SUGAR = ItemTags.createOptional(new ResourceLocation("forge", "sugar"));
	public static final Tag<Item> BOWL = ItemTags.createOptional(new ResourceLocation("teletubbies", "bowl"));

	private final Tag<Item> item;
	
	public SpecificItemSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, Tag<Item> item) {
		super(itemHandler, index, xPosition, yPosition);
		this.item = item;
	}
	
    @Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
    	return stack.is(item);
    }
}