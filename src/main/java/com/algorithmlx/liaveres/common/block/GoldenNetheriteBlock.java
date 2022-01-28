package com.algorithmlx.liaveres.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;

@Deprecated
public class GoldenNetheriteBlock extends Block {
    public GoldenNetheriteBlock() {
        super(Properties.of(Material.METAL)
                .noOcclusion()
                .strength(5f, 700f)
                .lightLevel(state -> (int) 1.5)
        );
    }
}
