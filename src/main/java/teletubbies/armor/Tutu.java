package teletubbies.armor;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import teletubbies.Teletubbies;
import teletubbies.client.models.armor.TutuModel;

public class Tutu extends ArmorItem {
	
	public Tutu() {
		super(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, new Item.Properties()
				.group(Teletubbies.ITEMGROUP));
		
		this.setRegistryName(new ResourceLocation(Teletubbies.MODID, "tutu"));
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return Teletubbies.MODID + ":textures/models/armor/tutu.png";
    }
    
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A defaultModel) {
    	BipedModel<LivingEntity> armorModel = new TutuModel(1.0F);
		return (A) armorModel;
    }
    
    /*@Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
    	return repair.isItemEqual(new ItemStack(Blocks.PINK_WOOL.mate)) || super.getIsRepairable(toRepair, repair);
    }*/
}