package teletubbies.item;

import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import teletubbies.Teletubbies;
import teletubbies.common.capabilities.TinkyWinkyBagProvider;
import teletubbies.inventory.container.TinkyWinkyBagContainer;

public class TinkyWinkyBagItem extends Item {
	
	public TinkyWinkyBagItem() {
		super(new Item.Properties()
				.maxStackSize(1)
				.group(Teletubbies.ITEMGROUP));

		this.setRegistryName(Teletubbies.MODID, "tinkywinky_bag");
	}
		
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand handIn) {
		ItemStack stack = player.getHeldItem(handIn);
		if (!world.isRemote) {
			player.openContainer(new INamedContainerProvider() {
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
		return super.onItemRightClick(world, player, handIn);
	}
	
	@Nullable
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundNBT nbt) {
		return new TinkyWinkyBagProvider(stack);
	}
}