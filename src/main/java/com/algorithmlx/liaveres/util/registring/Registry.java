package com.algorithmlx.liaveres.util.registring;

import com.algorithmlx.liaveres.item.*;
import com.algorithmlx.liaveres.util.block.BlockBase;
import com.algorithmlx.liaveres.util.item.*;
import com.algorithmlx.liaveres.util.tab.Tabs;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class Registry extends RegistryBase {
    public static Block
            MATTER_CRYSTAL_BLOCK,
            MATTER_BLOCK;
    public static Item
            MATTER,
            CRYSTALLINE,
            MATTER_CRYSTAL_AXE,
            MATTER_CRYSTAL_SWORD,
            MATTER_CRYSTAL;

    public static void init() {
        block(MATTER_CRYSTAL_BLOCK = new BlockBase(Material.ROCK, "matter_crystal_block", Tabs.LIAVERES));
        block(MATTER_BLOCK = new BlockBase(Material.ROCK, "matter_block", Tabs.LIAVERES));
        item(MATTER = new ItemBase("matter", Tabs.LIAVERES));
        item(CRYSTALLINE = new ItemBase("crystalline", Tabs.LIAVERES));
        item(MATTER_CRYSTAL_AXE = new MatterCrystalAxe("matter_crystal_axe"));
        item(MATTER_CRYSTAL = new ItemBase("matter_crystal", Tabs.LIAVERES));
        item(MATTER_CRYSTAL_SWORD = new MatterCrystalSword("matter_crystal_sword"));
    }
}
