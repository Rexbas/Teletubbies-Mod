package teletubbies.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import teletubbies.Teletubbies;
import teletubbies.common.capabilities.TinkyWinkyBagProvider;
import teletubbies.inventory.container.TinkyWinkyBagContainer;
import teletubbies.inventory.container.handler.TinkyWinkyBagItemHandler;

public class TinkyWinkyBagItem extends Item {
	
	public static final ResourceLocation LOOTTABLE = new ResourceLocation(Teletubbies.MODID, "tinkywinky_bag");
	private static final int MAX_TOOLTIP_ITEMS = 5;
	
	public TinkyWinkyBagItem() {
		super(new Item.Properties()
				.stacksTo(1)
				.tab(Teletubbies.ITEMGROUP));
	}
		
	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand handIn) {
		ItemStack stack = player.getItemInHand(handIn);
		if (!world.isClientSide) {
			player.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return new TranslatableComponent("item.teletubbies.tinkywinky_bag");
				}
				
				@Override
				public AbstractContainerMenu createMenu(int id, Inventory playerInv, Player player) {
					return new TinkyWinkyBagContainer(id, playerInv, stack);
				}
			});
		}
		return super.use(world, player, handIn);
	}
	
	@Nullable
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
		return new TinkyWinkyBagProvider(stack);
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
		int lines = 0;
		if (stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent()) {
			TinkyWinkyBagItemHandler handler = (TinkyWinkyBagItemHandler) stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
			
			int num_items = 0;
			for (int i = 0; i < handler.getSlots(); i++) {				
				if (handler.getStackInSlot(i).getItem() != Items.AIR) {
					num_items++;
					
					if (lines < MAX_TOOLTIP_ITEMS) {
						ItemStack s = handler.getStackInSlot(i);
						tooltip.add(s.getHoverName().plainCopy().append(new TextComponent(" x" + s.getCount())));
						lines++;
					}
				}
			}
			int remainder = num_items - lines;
			if (remainder > 0) {
				tooltip.add(new TextComponent("\u00A7oand " + remainder + " more..."));
			}
		}
	}
}