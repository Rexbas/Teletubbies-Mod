package com.rexbas.teletubbies.item.armor;

import java.util.function.Consumer;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.RenderHandler;
import com.rexbas.teletubbies.client.renderer.item.model.NooNooEyesModel;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class NooNooEyesItem extends ArmorItem {
		
	public NooNooEyesItem() {
		super(ArmorMaterials.IRON, EquipmentSlot.HEAD, new Item.Properties().tab(Teletubbies.TAB));
	}

	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/noonoo_eyes.png";
    }
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
		    public HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
		    	HumanoidModel<LivingEntity> armorModel = new NooNooEyesModel(Minecraft.getInstance().getEntityModels().bakeLayer(RenderHandler.NOONOO_EYES_LAYER));
				return armorModel;
		    }
		});
	}
}