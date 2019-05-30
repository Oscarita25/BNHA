package com.oscar.items;

import com.oscar.BNHA;
import com.oscar.proxy.ClientProxy;
import com.oscar.util.Reference;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClothArmor extends ItemArmor {
	
	String name;

	public ClothArmor(String name,ArmorMaterial material,int renderindex, EntityEquipmentSlot slot) {
		super(material, renderindex, slot);
		this.setRegistryName(Reference.MOD_ID, name);
		this.name = name;
        this.setCreativeTab(BNHA.BNHA);
        this.setUnlocalizedName(name);
	}
	
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase living, ItemStack stack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel)
	{
		if(!stack.isEmpty())
		{
			if(stack.getItem() instanceof ItemArmor)
			{

				EntityEquipmentSlot type = ((ItemArmor) stack.getItem()).armorType;
				ModelBiped armorModel = null;
				ModelBiped armorUpper = (ModelBiped) ClientProxy.getModel(1);
				ModelBiped armorLower = (ModelBiped) ClientProxy.getModel(0);
				switch (type) {
				case HEAD:
					armorModel = armorUpper;
					break;
				case LEGS:
					armorModel = armorLower;
					break;
				case FEET:
					armorModel = armorLower;
					break;
				case CHEST:
					armorModel = armorUpper;
					break;
				default:
					break;
				}

				armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				armorModel.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
				armorModel.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST)
						|| (armorSlot == EntityEquipmentSlot.CHEST);
				armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
				armorModel.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS)
						|| (armorSlot == EntityEquipmentSlot.FEET);
				armorModel.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS)
						|| (armorSlot == EntityEquipmentSlot.FEET);

				armorModel.isSneak = defaultModel.isSneak;
				armorModel.isRiding = defaultModel.isRiding;
				armorModel.isChild = defaultModel.isChild;
				armorModel.rightArmPose = defaultModel.rightArmPose;
				armorModel.leftArmPose = defaultModel.leftArmPose;

				return armorModel;
			}
		}
		return null;
	}   		
	

}

