package teletubbies.armor;

import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import teletubbies.Teletubbies;
import teletubbies.armor.model.ModelTubbyTutu;

public class ArmorTubbyTutu extends ArmorItem {
	
	public ArmorTubbyTutu(ArmorMaterial material, EquipmentSlotType slot) {
		super(material, slot, new Item.Properties()
				.maxStackSize(1)
				.group(Teletubbies.itemGroup));
		
		this.setRegistryName(new ResourceLocation(Teletubbies.MODID, "tubbytutu"));
	}

	/*@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        if(stack.getItem() == Teletubbies.tubbyTutu) {
        	return "teletubbies:textures/armor/models/tubbytutu.png";
        }
        else {
        	return null;
        }
    }*/
    
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A defaultModel) {
    	BipedModel<LivingEntity> armorModel = new ModelTubbyTutu(1.0F);
		return (A) armorModel;
    }
    
    @Override
    public boolean getIsRepairable(ItemStack stack1, ItemStack stack2) {
    	return stack2.isItemEqual(new ItemStack(Blocks.PINK_WOOL)) || super.getIsRepairable(stack1, stack2);
    }
}