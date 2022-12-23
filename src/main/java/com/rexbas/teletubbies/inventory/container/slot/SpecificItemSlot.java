package com.rexbas.teletubbies.inventory.container.slot;

import javax.annotation.Nonnull;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SpecificItemSlot extends SlotItemHandler {

	public static final TagKey<Item> GRAIN = ItemTags.create(new ResourceLocation("forge", "grain"));
	public static final TagKey<Item> MILK = ItemTags.create(new ResourceLocation("forge", "milk"));
	public static final TagKey<Item> EGG = ItemTags.create(new ResourceLocation("forge", "egg"));
	public static final TagKey<Item> SUGAR = ItemTags.create(new ResourceLocation("forge", "sugar"));
	public static final TagKey<Item> BOWL = ItemTags.create(new ResourceLocation("teletubbies", "bowl"));

	private final TagKey<Item> item;
	
	public SpecificItemSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition, TagKey<Item> item) {
		super(itemHandler, index, xPosition, yPosition);
		this.item = item;
	}
	
    @Override
	public boolean mayPlace(@Nonnull ItemStack stack) {
    	return stack.is(item);
    }
}
