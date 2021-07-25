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
import teletubbies.client.renderer.item.model.TutuModel;

public class TutuItem extends ArmorItem {
		
	public TutuItem() {
		super(ArmorMaterials.LEATHER, EquipmentSlot.LEGS, new Item.Properties()
				.tab(Teletubbies.ITEMGROUP));
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/tutu.png";
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public <A extends HumanoidModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, A defaultModel) {
    	HumanoidModel<LivingEntity> armorModel = TutuModel.model;
    	armorModel.setupAnim(entityLiving, entityLiving.animationPosition, entityLiving.animationSpeed, entityLiving.tickCount, entityLiving.yHeadRot, entityLiving.xRot);
		return (A) armorModel;
    }
}