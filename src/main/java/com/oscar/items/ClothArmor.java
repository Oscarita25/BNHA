package com.oscar.items;

import com.oscar.BNHA;
import com.oscar.init.ModItems;
import com.oscar.util.IHasModel;
import com.oscar.util.Reference;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClothArmor extends ItemArmor implements IHasModel{
	
	String name;

	public ClothArmor(String name,ArmorMaterial material,int renderindex, EntityEquipmentSlot slot) {
		super(material, renderindex, slot);
		this.setRegistryName(Reference.MOD_ID, name);
		this.name = name;
        this.setCreativeTab(BNHA.BNHA);
        this.setUnlocalizedName(name);
        ModItems.ITEMS.add(this);
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
				switch (type) {
				case HEAD:
					armorModel = (ModelBiped) BNHA.proxy.getModel(1);
					break;
				case LEGS:
					armorModel = (ModelBiped) BNHA.proxy.getModel(0);
					break;
				case FEET:
					armorModel = (ModelBiped) BNHA.proxy.getModel(0);
					break;
				case CHEST:
					armorModel = (ModelBiped) BNHA.proxy.getModel(1);
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
	
	@Override
	public void registerModels() {
		BNHA.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}

