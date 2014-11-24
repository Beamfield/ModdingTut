package com.beamfield.youtubetut.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemTutorialSword extends ItemSword {

	public ItemTutorialSword(ToolMaterial p_i45356_1_) {
		super(p_i45356_1_);
	}
	public boolean hitEntity(ItemStack stack, EntityLivingBase eLiving1, EntityLivingBase eLiving2)
    {
		eLiving1.addPotionEffect(new PotionEffect(Potion.wither.id, 5000));
        return true;
    }
}
