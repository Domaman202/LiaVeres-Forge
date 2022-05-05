package com.algorithmlx.liaveres.setup;

import com.algorithmlx.liaveres.util.BlockBase;
import com.algorithmlx.liaveres.util.ItemBase;
import com.algorithmlx.liaveres.util.RegistryBase;

public class Registry extends RegistryBase {
    public static BlockBase MATTER_CRYSTAL_BLOCK, MATTER_BLOCK;
    public static ItemBase MATTER, CRYSTALLINE;

    public static void init() {
        block(MATTER_CRYSTAL_BLOCK = new BlockBase("matter_crystal_block"));
        block(MATTER_BLOCK = new BlockBase("matter_block"));
        item(MATTER = new ItemBase("matter"));
        item(CRYSTALLINE = new ItemBase("crystalline"));
    }
}
