package com.rexbas.teletubbies.item.armor;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.item.model.DipsyHatModel;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class DipsyHatItem extends ArmorItem {
		
	public DipsyHatItem() {
		super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Item.Properties()
				.tab(Teletubbies.ITEMGROUP));
	}

	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/dipsy_hat.png";
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A defaultModel) {
    	BipedModel<LivingEntity> armorModel = DipsyHatModel.model;
		return (A) armorModel;
    }
}