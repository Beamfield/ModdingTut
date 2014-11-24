package com.beamfield.youtubetut.item;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTutorialPickaxe extends ItemPickaxe{

	boolean ultraMode = false;
	int maxDamage;
	int speedModifier = 50;
	public ItemTutorialPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		maxDamage = this.getMaxDamage();
	}
	/**
	 * Az Item neve alatt, az információk.
	 */
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4){
		if(ultraMode){
			list.add(EnumChatFormatting.GREEN+"Ultra Mode Enabled");
		}else{
			list.add(EnumChatFormatting.RED+"Ultra Mode Disabled");
		}
	}
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
    	//world.isRemote = csak kliensoldalon, ez ha nem lenne itt mindent 2x csinálna(server-client oldalon)
		if(world.isRemote)
				if(Keyboard.isKeyDown(Keyboard.KEY_U)){//Ha nyomsz egy U betüt és az inventory-d ban van akkor ez az if lefut
					ultraMode=true;
					this.setMaxDamage(this.getMaxDamage()/2);
					this.setHarvestLevel("pickaxe", 3);
					System.out.println("Enabled ultra Mode");//Debug miatt :)
				if(Keyboard.isKeyDown(Keyboard.KEY_U) && Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){//Shift+U bill komb
					ultraMode=false;
					this.setMaxDamage(maxDamage);
					this.setHarvestLevel("pickaxe", 2);
					System.out.println("Disabled ultra Mode");//Debug miatt :)
				}
		}
	}
    @Override
    public float getDigSpeed(ItemStack stack, Block block, int meta)
    {
        if (ultraMode)
        {
            return speedModifier;
        }else{
        	return efficiencyOnProperMaterial;
        }
    }
}
