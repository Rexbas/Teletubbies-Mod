package com.rexbas.teletubbies.item.armor;

import java.util.function.Consumer;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.RenderHandler;
import com.rexbas.teletubbies.client.renderer.item.model.DipsyHatModel;

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
import net.minecraftforge.client.IItemRenderProperties;

public class DipsyHatItem extends ArmorItem {
		
	public DipsyHatItem() {
		super(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new Item.Properties().tab(Teletubbies.TAB));
	}

	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/dipsy_hat.png";
    }
	
	@OnlyIn(Dist.CLIENT)
	@Override
	public void initializeClient(Consumer<IItemRenderProperties> consumer) {
		consumer.accept(new IItemRenderProperties() {
			@Override
		    public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A _default) {
		    	HumanoidModel<LivingEntity> armorModel = new DipsyHatModel(Minecraft.getInstance().getEntityModels().bakeLayer(RenderHandler.DIPSY_HAT_LAYER));
				return (A) armorModel;
		    }
		});
	}
}