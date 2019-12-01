package teletubbies.armor;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import teletubbies.Teletubbies;

public class ArmorSimple extends ArmorItem {
	
	public ArmorSimple(IArmorMaterial material, EquipmentSlotType slot, String name) {
		super(material, slot, new Item.Properties()
				.group(Teletubbies.itemGroup));
		
		this.setRegistryName(Teletubbies.MODID, name);
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
		return Teletubbies.MODID + ":textures/models/armor/" + this.getRegistryName().getPath() + ".png";
    }
}
