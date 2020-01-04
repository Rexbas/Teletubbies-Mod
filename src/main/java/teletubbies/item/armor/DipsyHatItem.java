package teletubbies.item.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import teletubbies.Teletubbies;
import teletubbies.client.renderer.item.model.DipsyHatModel;

public class DipsyHatItem extends ArmorItem {
		
	public DipsyHatItem() {
		super(ArmorMaterial.LEATHER, EquipmentSlotType.HEAD, new Item.Properties()
				.group(Teletubbies.ITEMGROUP));
		
		this.setRegistryName(new ResourceLocation(Teletubbies.MODID, "dipsy_hat"));
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