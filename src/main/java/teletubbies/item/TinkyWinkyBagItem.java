package teletubbies.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
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
	public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand handIn) {
		ItemStack stack = player.getItemInHand(handIn);
		if (!world.isClientSide) {
			player.openMenu(new INamedContainerProvider() {
				@Override
				public ITextComponent getDisplayName() {
					return new TranslationTextComponent("item.teletubbies.tinkywinky_bag");
				}
				
				@Override
				public Container createMenu(int id, PlayerInventory playerInv, PlayerEntity player) {
					return new TinkyWinkyBagContainer(id, playerInv, stack);
				}
			});
		}
		return super.use(world, player, handIn);
	}
	
	@Nullable
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
		return new TinkyWinkyBagProvider(stack);
	}
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> tooltip, ITooltipFlag flag) {
		int lines = 0;
		if (stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).isPresent()) {
			TinkyWinkyBagItemHandler handler = (TinkyWinkyBagItemHandler) stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).orElse(null);
			
			int num_items = 0;
			for (int i = 0; i < handler.getSlots(); i++) {				
				if (handler.getStackInSlot(i).getItem() != Items.AIR) {
					num_items++;
					
					if (lines < MAX_TOOLTIP_ITEMS) {
						ItemStack s = handler.getStackInSlot(i);
						tooltip.add(s.getHoverName().plainCopy().append(new StringTextComponent(" x" + s.getCount())));
						lines++;
					}
				}
			}
			int remainder = num_items - lines;
			if (remainder > 0) {
				tooltip.add(new StringTextComponent("\u00A7oand " + remainder + " more..."));
			}
		}
	}
}