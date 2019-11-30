package teletubbies.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teletubbies.Teletubbies;
import teletubbies.armor.model.ModelDipsyHat;

public class ArmorDipsyHat extends ItemArmor{
	
	private final String name = "DipsyHat";

	public ArmorDipsyHat(ArmorMaterial material, int renderId, int type) {
		super(material, renderId, type);
		
		this.setCreativeTab(Teletubbies.tabTeletubbies);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
	}

	@Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if(stack.getItem() == Teletubbies.dipsyHat)
        {
        	return "teletubbies:textures/armor/DipsyHat.png";
        }
        else
        {
        	return null;
        }
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot){
    	ModelBiped armorModel = new ModelDipsyHat(1.0F);
    	
		if(armorModel != null){
    		armorModel.bipedHead.showModel = armorSlot == 0;
    		armorModel.bipedHeadwear.showModel = false;
    		armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
    		armorModel.bipedRightArm.showModel = armorSlot == 1;
    		armorModel.bipedLeftArm.showModel = armorSlot == 1;
    		armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
    		armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
    		
    		armorModel.isSneak = entityLiving.isSneaking();
    		armorModel.isRiding = entityLiving.isRiding();
    		armorModel.isChild = entityLiving.isChild();
    		
    		armorModel.heldItemRight = 0;
    		armorModel.aimedBow = false;
    		
    		EntityPlayer player = (EntityPlayer)entityLiving;
    		ItemStack held_item = player.getEquipmentInSlot(0);
    		
    		if (held_item != null){
    			armorModel.heldItemRight = 1;
    			
    			if (player.getItemInUseCount() > 0){
    				EnumAction enumaction = held_item.getItemUseAction();
    				if (enumaction == EnumAction.BOW){
    					armorModel.aimedBow = true;
    				}
    				else if (enumaction == EnumAction.BLOCK){
    					armorModel.heldItemRight = 3;
    				}
    			}
    		}
		}	
		return armorModel;
    }
    
    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack){
    	return par2ItemStack.isItemEqual(new ItemStack(Teletubbies.dipsyStick)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}