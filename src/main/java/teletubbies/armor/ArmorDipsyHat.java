package teletubbies.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teletubbies.Teletubbies;
import teletubbies.armor.model.ModelDipsyHat;

public class ArmorDipsyHat extends ItemArmor {
	
	private final String name = "DipsyHat";

	public ArmorDipsyHat(ArmorMaterial material, int renderId, EntityEquipmentSlot slot) {
		super(material, renderId, slot);
		this.setCreativeTab(Teletubbies.tabTeletubbies);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}

	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if(stack.getItem() == Teletubbies.dipsyHat) {
        	return "teletubbies:textures/armor/DipsyHat.png";
        }
        else {
        	return null;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default) {
    	ModelBiped armorModel = new ModelDipsyHat(1.0F);
		return armorModel;
    }
    
    @Override
    public boolean getIsRepairable(ItemStack stack1, ItemStack stack2) {
    	return stack2.isItemEqual(new ItemStack(Teletubbies.dipsyStick)) || super.getIsRepairable(stack1, stack2);
    }
}