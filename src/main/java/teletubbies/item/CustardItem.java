package teletubbies.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;
import teletubbies.Teletubbies;

public class CustardItem extends Item {
	
	public CustardItem() {
		super(new Item.Properties()
				.food(Teletubbies.CUSTARD_FOOD)
				.maxStackSize(1)
				.group(Teletubbies.ITEMGROUP));

		this.setRegistryName(Teletubbies.MODID, "custard");
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
		super.onItemUseFinish(stack, world, entity);
		return new ItemStack(ItemList.BOWL);
	}
}
