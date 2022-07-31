package com.rexbas.teletubbies.item.armor;

import com.rexbas.teletubbies.Teletubbies;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SimpleArmorItem extends ArmorItem {
	
	public SimpleArmorItem(IArmorMaterial material, EquipmentSlotType slot) {
		super(material, slot, new Item.Properties().tab(Teletubbies.TAB));
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/" + this.getRegistryName().getPath() + ".png";
    }
}
