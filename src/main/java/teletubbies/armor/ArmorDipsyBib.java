package teletubbies.armor;

import teletubbies.Teletubbies;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ArmorDipsyBib extends ItemArmor{

	public ArmorDipsyBib(ArmorMaterial material, int renderId, int type) {
		super(material, renderId, type);
		
		this.setCreativeTab(Teletubbies.tabTeletubbies);
		this.setUnlocalizedName("DipsyBib");
		this.setTextureName("teletubbies:DipsyBib_icon");
		this.setMaxStackSize(1);
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == Teletubbies.dipsyBib)
        {
        	return "teletubbies:textures/armor/DipsyBib.png";
        }
        else
        {
        	return null;
        }
    }
	
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
    	return par2ItemStack.isItemEqual(new ItemStack(Teletubbies.dipsyStick)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
