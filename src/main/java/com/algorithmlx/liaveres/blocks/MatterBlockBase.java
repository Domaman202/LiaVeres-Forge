package com.algorithmlx.liaveres.blocks;

import com.algorithmlx.liaveres.LiaVeres;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;


public class MatterBlockBase extends Block {

    public MatterBlockBase(String name, int lvl){
        super(Block.Properties
                .create(Material.ROCK)
                .hardnessAndResistance(500f, 500f)
                .harvestLevel(lvl)
                .harvestTool(ToolType.PICKAXE)
        );
        setRegistryName(LiaVeres.ModId, name);
    }

}