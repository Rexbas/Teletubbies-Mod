package teletubbies.item.armor;

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
import teletubbies.Teletubbies;
import teletubbies.client.renderer.item.model.DipsyHatModel;

public class DipsyHatItem extends ArmorItem {
		
	public DipsyHatItem() {
		super(ArmorMaterials.LEATHER, EquipmentSlot.HEAD, new Item.Properties()
				.tab(Teletubbies.ITEMGROUP));
	}

	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/dipsy_hat.png";
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A defaultModel) {
    	HumanoidModel<LivingEntity> armorModel = DipsyHatModel.model;
		return (A) armorModel;
    }
}