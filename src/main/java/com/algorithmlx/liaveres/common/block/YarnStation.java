package com.algorithmlx.liaveres.common.block;

import com.algorithmlx.liaveres.common.block.entity.YarnStationBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import org.jetbrains.annotations.Nullable;

public class YarnStation extends Block implements EntityBlock {
    public YarnStation() {
        super(BlockBehaviour.Properties.of(Material.WOOD)
                .strength(5f, 5f)
                .noOcclusion()
        );
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new YarnStationBlockEntity(pPos, pState);
    }
}
