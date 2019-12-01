package teletubbies.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.world.World;
import teletubbies.Teletubbies;
import teletubbies.TeletubbiesItems;

public class Custard extends Item {
	
	public Custard() {
		super(new Item.Properties()
				.food(Teletubbies.foodCustard)
				.maxStackSize(1)
				.group(Teletubbies.itemGroup));

		this.setRegistryName(Teletubbies.MODID, "custard");
	}
	
	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.DRINK;
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity) {
		super.onItemUseFinish(stack, world, entity);
		return new ItemStack(TeletubbiesItems.bowl);
	}
}
