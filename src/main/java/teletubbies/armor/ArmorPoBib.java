package teletubbies.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import teletubbies.Teletubbies;
import teletubbies.configuration.ConfigurationHandler;

public class ArmorPoBib extends ItemArmor {
	
	private final String name = "pobib";

	public ArmorPoBib(ArmorMaterial material, int renderId, EntityEquipmentSlot slot) {
		super(material, renderId, slot);
		this.setCreativeTab(Teletubbies.tabTeletubbies);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setMaxStackSize(1);
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if(stack.getItem() == Teletubbies.poBib) {
        	if(ConfigurationHandler.use2015) {
            	return "teletubbies:textures/armor/pobib2015.png";
        	}
        	else return "teletubbies:textures/armor/pobib.png";
        }
        else {
        	return null;
        }
    }
	
    @Override
    public boolean getIsRepairable(ItemStack stack1, ItemStack stack2) {
    	return stack2.isItemEqual(new ItemStack(Teletubbies.poStick)) || super.getIsRepairable(stack1, stack2);
    }
}