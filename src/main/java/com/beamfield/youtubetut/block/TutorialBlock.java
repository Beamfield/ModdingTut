package com.beamfield.youtubetut.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TutorialBlock extends Block {

	public TutorialBlock(Material p_i45394_1_) {
		super(p_i45394_1_);
		float px = 1F/16F;
		this.setBlockBounds(0f, 0f, 0f, 1f, 0.2f, 1f);
	}
	public Item getItemDropped(int a, Random rnd, int b){
		return new ItemStack(Blocks.bedrock, rnd.nextInt(10), 0).getItem();
	}
	public void onEntityWalking(World world, int x, int y, int z, Entity entity) {
		if(entity instanceof EntityPlayer){
			entity.motionY += 1D;
		}else{
			entity.setFire(5);
		}
	}
	public boolean isOpaqueCube(){
		return false;
	}
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
