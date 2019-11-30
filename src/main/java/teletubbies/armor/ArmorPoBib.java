package teletubbies.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import teletubbies.Teletubbies;

public class ArmorPoBib extends ItemArmor{
	
	private final String name = "PoBib";

	public ArmorPoBib(ArmorMaterial material, int renderId, int type) {
		super(material, renderId, type);
		
		this.setCreativeTab(Teletubbies.tabTeletubbies);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == Teletubbies.poBib)
        {
        	return "teletubbies:textures/armor/PoBib.png";
        }
        else
        {
        	return null;
        }
    }
	
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
    	return par2ItemStack.isItemEqual(new ItemStack(Teletubbies.poStick)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}