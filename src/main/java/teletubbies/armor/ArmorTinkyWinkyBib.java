package teletubbies.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import teletubbies.Teletubbies;

public class ArmorTinkyWinkyBib extends ItemArmor {

	private final String name = "TinkyWinkyBib";
	
	public ArmorTinkyWinkyBib(ArmorMaterial material, int renderId, EntityEquipmentSlot slot) {
		super(material, renderId, slot);
		this.setCreativeTab(Teletubbies.tabTeletubbies);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if(stack.getItem() == Teletubbies.tinkyWinkyBib) {
        	return "teletubbies:textures/armor/TinkyWinkyBib.png";
        }
        else {
        	return null;
        }
    }
	
    @Override
    public boolean getIsRepairable(ItemStack stack1, ItemStack stack2) {
    	return stack2.isItemEqual(new ItemStack(Teletubbies.tinkyWinkyStick)) || super.getIsRepairable(stack1, stack2);
    }
}