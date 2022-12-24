package com.rexbas.teletubbies.item.armor;

import com.rexbas.teletubbies.Teletubbies;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

public class SimpleArmorItem extends ArmorItem {
	
	public SimpleArmorItem(ArmorMaterial material, EquipmentSlot slot) {
		super(material, slot, new Item.Properties());
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/" + ForgeRegistries.ITEMS.getKey(this).getPath() + ".png";
    }
}