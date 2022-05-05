package com.algorithmlx.liaveres.util;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    public BlockBase(String blockId) {
        super(Material.ROCK);
        this.setRegistryName(blockId);
    }
}
