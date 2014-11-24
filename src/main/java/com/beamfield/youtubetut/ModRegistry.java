package com.beamfield.youtubetut;

import static com.beamfield.youtubetut.Main.*;
import static com.beamfield.youtubetut.Reference.texturePrefix;

import java.util.Random;

import com.beamfield.youtubetut.block.TutorialBlock;
import com.beamfield.youtubetut.item.ItemTutorialAxe;
import com.beamfield.youtubetut.item.ItemTutorialHoe;
import com.beamfield.youtubetut.item.ItemTutorialPickaxe;
import com.beamfield.youtubetut.item.ItemTutorialShovel;
import com.beamfield.youtubetut.item.ItemTutorialSword;
import com.beamfield.youtubetut.item.ItemUbersword;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModRegistry {
	public static void preInit(){
		System.out.println(Reference.MODNAME + "pre betoltodott!");
		tutorialItem = new Item().setTextureName(texturePrefix+"tutorialItem").setCreativeTab(tabTutorial).setUnlocalizedName("tutorialItem").setMaxStackSize(13);
		tutorialBlock = new TutorialBlock(Material.rock).setBlockTextureName(texturePrefix+"tutorialBlock").setBlockName("tutorialBlock").setLightLevel(14f).setCreativeTab(tabTutorial).setHardness(6f).setResistance(6f);
		GameRegistry.registerItem(tutorialItem, "tutorialItem");
		GameRegistry.registerBlock(tutorialBlock, "tutorialBlock");
		GameRegistry.addShapelessRecipe(new ItemStack(Main.tutorialItem, 7), Items.diamond, Blocks.bedrock);
		Random rnd = new Random();
		GameRegistry.addShapedRecipe(new ItemStack(Main.tutorialItem, rnd.nextInt(64)), new Object[]{
											"DDD",
											"DCD",
											"DDD", 'D', Items.diamond, 'C', Items.coal});
		LanguageRegistry.addName(tutorialItem, "Tutorial Item");
		
		tutorialSword = new ItemTutorialSword(TutorialMaterial).setUnlocalizedName("tutorialSword").setCreativeTab(tabTutorial).setTextureName(texturePrefix+"tutorialSword");
		tutorialPickaxe = new ItemTutorialPickaxe(TutorialMaterial).setUnlocalizedName("tutorialPickaxe").setCreativeTab(tabTutorial).setTextureName(texturePrefix+"tutorialPickaxe");
		tutorialShovel = new ItemTutorialShovel(TutorialMaterial).setUnlocalizedName("tutorialShovel").setCreativeTab(tabTutorial).setTextureName(texturePrefix+"tutorialShovel");
		tutorialAxe = new ItemTutorialAxe(TutorialMaterial).setUnlocalizedName("tutorialAxe").setCreativeTab(tabTutorial).setTextureName(texturePrefix+"tutorialAxe");
		tutorialHoe = new ItemTutorialHoe(TutorialMaterial).setUnlocalizedName("tutorialHoe").setCreativeTab(tabTutorial).setTextureName(texturePrefix+"tutorialHoe");
		GameRegistry.registerItem(tutorialSword, "tutorialSword");
		GameRegistry.registerItem(tutorialPickaxe, "tutorialPickaxe");
		GameRegistry.registerItem(tutorialShovel, "tutorialShovel");
		GameRegistry.registerItem(tutorialAxe, "tutorialAxe");
		GameRegistry.registerItem(tutorialHoe, "tutorialHoe");
	}
	public static void init(){
		System.out.println(Reference.MODNAME + " betoltodott!");
	}
}
