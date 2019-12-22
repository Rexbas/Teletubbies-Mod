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
import teletubbies.client.renderer.item.model.TutuModel;

public class TutuItem extends ArmorItem {
	
	private static TutuModel model = new TutuModel(1.0F);
	
	public TutuItem() {
		super(ArmorMaterial.LEATHER, EquipmentSlotType.CHEST, new Item.Properties()
				.group(Teletubbies.ITEMGROUP));
		
		this.setRegistryName(new ResourceLocation(Teletubbies.MODID, "tutu"));
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return Teletubbies.MODID + ":textures/models/armor/tutu.png";
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A defaultModel) {
    	BipedModel<LivingEntity> armorModel = model;
		return (A) armorModel;
    }
}