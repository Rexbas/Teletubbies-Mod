package com.rexbas.teletubbies.item.armor;

import com.rexbas.teletubbies.Teletubbies;
import com.rexbas.teletubbies.client.renderer.RenderHandler;
import com.rexbas.teletubbies.client.renderer.item.model.TutuModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class TutuItem extends ArmorItem {
	
	public TutuItem() {
		super(ArmorMaterials.LEATHER, ArmorItem.Type.LEGGINGS, new Item.Properties());
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/tutu.png";
    }
    
	@OnlyIn(Dist.CLIENT)
	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
		    public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
		    	HumanoidModel<LivingEntity> armorModel = new TutuModel(Minecraft.getInstance().getEntityModels().bakeLayer(RenderHandler.TUTU_LAYER));
		    	armorModel.setupAnim(entityLiving, entityLiving.walkAnimation.position(), entityLiving.walkAnimation.speed(), entityLiving.tickCount, entityLiving.yHeadRot, entityLiving.getXRot());
				return armorModel;
		    }
		});
	}
}