package teletubbies.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import teletubbies.Teletubbies;

public class ArmorTinkyWinkyBib extends ItemArmor{

	public ArmorTinkyWinkyBib(ArmorMaterial material, int renderId, int type) {
		super(material, renderId, type);
		
		this.setCreativeTab(Teletubbies.tabTeletubbies);
		this.setUnlocalizedName("TinkyWinkyBib");
		this.setTextureName("teletubbies:TinkyWinkyBib_icon");
		this.setMaxStackSize(1);
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == Teletubbies.tinkyWinkyBib)
        {
        	return "teletubbies:textures/armor/TinkyWinkyBib.png";
        }
        else
        {
        	return null;
        }
    }
	
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
    	return par2ItemStack.isItemEqual(new ItemStack(Teletubbies.tinkyWinkyStick)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}