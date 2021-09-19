package com.algorithmlx.liaveres.blocks;

import com.algorithmlx.liaveres.LiaVeres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockBase extends Block {

    public BlockBase(String name, int lvl){
        super(Block.Properties
                .create(Material.ROCK)
                .hardnessAndResistance(1.0f, 1.0f)
                .harvestLevel(lvl)
                .harvestTool(ToolType.PICKAXE)
        );
        setRegistryName(LiaVeres.ModId, name);
    }
}