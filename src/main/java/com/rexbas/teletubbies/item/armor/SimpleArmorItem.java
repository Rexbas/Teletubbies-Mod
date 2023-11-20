package com.rexbas.teletubbies.item.armor;

import com.rexbas.teletubbies.Teletubbies;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SimpleArmorItem extends ArmorItem {
	
	public SimpleArmorItem(ArmorMaterial material, ArmorItem.Type type) {
		super(material, type, new Item.Properties());
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/" + BuiltInRegistries.ITEM.getKey(this).getPath() + ".png";
    }
}