package com.algorithmlx.liaveres.init;

import com.algorithmlx.liaveres.item.*;
import com.algorithmlx.liaveres.util.block.BlockBase;
import com.algorithmlx.liaveres.util.item.ItemBase;
import com.algorithmlx.liaveres.util.tab.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class RegistryArray {
    private static final CreativeTabs tab = Tabs.LIAVERES;

    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Block
            MATTER_CRYSTAL_BLOCK = new BlockBase("matter_crystal_block", Material.ROCK, tab),
            MATTER_BLOCK = new BlockBase("matter_block", Material.ROCK, tab);

    public static final Item
            MATTER_CRYSTAL = new ItemBase("matter_crystal", tab),
            MATTER = new ItemBase("matter", tab),
            CRYSTALLINE = new ItemBase("crystalline", tab),
            MATTER_CRYSTAL_AXE = new MatterCrystalAxe("matter_crystal_axe"),
            MATTER_CRYSTAL_SWORD = new MatterCrystalSword("matter_crystal_sword"),
            MATTER_CRYSTAL_PICKAXE = new MatterCrystalPickaxe("matter_crystal_pickaxe"),
            MATTER_CRYSTAL_HOE = new MatterCrystalHoe("matter_crystal_hoe"),
            MATTER_CRYSTAL_SHOVEL = new MatterCrystalShovel("matter_crystal_shovel"),
            MATTER_CRYSTAL_HELMET = new MatterCrystalArmor("matter_crystal_helmet", EntityEquipmentSlot.HEAD),
            MATTER_CRYSTAL_CHESTPLATE = new MatterCrystalArmor("matter_crystal_chestplate", EntityEquipmentSlot.CHEST),
            MATTER_CRYSTAL_LEGS = new MatterCrystalArmor("matter_crystal_leggings", EntityEquipmentSlot.LEGS),
            MATTER_CRYSTAL_BOOTS = new MatterCrystalArmor("matter_crystal_boots", EntityEquipmentSlot.FEET),
            EFFECT_CATALYST = new ItemBase("effect_catalyst", tab),
            ENCHANTED_APPLE = new EnchantedApple("enchanted_apple"),
            MATTER_HELMET = new MatterArmor("matter_helmet", EntityEquipmentSlot.HEAD),
            MATTER_CHESTPLATE = new MatterArmor("matter_chestplate", EntityEquipmentSlot.CHEST),
            MATTER_LEGS = new MatterArmor("matter_leggings", EntityEquipmentSlot.LEGS),
            MATTER_BOOTS = new MatterArmor("matter_boots", EntityEquipmentSlot.FEET);
}
