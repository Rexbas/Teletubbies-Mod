package teletubbies.item.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import teletubbies.Teletubbies;

public class SimpleArmorItem extends ArmorItem {
	
	public SimpleArmorItem(ArmorMaterial material, EquipmentSlot slot) {
		super(material, slot, new Item.Properties()
				.tab(Teletubbies.ITEMGROUP));
	}
	
	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
		return Teletubbies.MODID + ":textures/model/armor/" + this.getRegistryName().getPath() + ".png";
    }
}
