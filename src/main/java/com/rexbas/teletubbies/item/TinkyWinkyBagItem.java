package com.rexbas.teletubbies.item;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.inventory.container.TinkyWinkyBagContainer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public class TinkyWinkyBagItem extends Item {
	
	public static final ResourceLocation LOOTTABLE = new ResourceLocation(Teletubbies.MODID, "tinkywinky_bag");
	private static final int MAX_TOOLTIP_ITEMS = 5;
	
	public TinkyWinkyBagItem() {
		super(new Item.Properties().stacksTo(1));
	}
		
	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand handIn) {
		ItemStack stack = player.getItemInHand(handIn);
		if (!world.isClientSide) {
			player.openMenu(new MenuProvider() {
				@Override
				public @NotNull Component getDisplayName() {
					return Component.translatable("item.teletubbies.tinkywinky_bag");
				}
				
				@Override
				public AbstractContainerMenu createMenu(int id, Inventory playerInv, Player player) {
					return new TinkyWinkyBagContainer(id, playerInv, stack);
				}
			});
		}
		return super.use(world, player, handIn);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
		int lines = 0;
		IItemHandler handler = stack.getCapability(Capabilities.ItemHandler.ITEM);
		if (handler != null) {

			int num_items = 0;
			for (int i = 0; i < handler.getSlots(); i++) {
				if (handler.getStackInSlot(i).getItem() != Items.AIR) {
					num_items++;
					
					if (lines < MAX_TOOLTIP_ITEMS) {
						ItemStack s = handler.getStackInSlot(i);
						tooltip.add(s.getHoverName().plainCopy().append(Component.literal(" x" + s.getCount())));
						lines++;
					}
				}
			}
			int remainder = num_items - lines;
			if (remainder > 0) {
				tooltip.add(Component.literal("§oand " + remainder + " more..."));
			}
		}
	}
}