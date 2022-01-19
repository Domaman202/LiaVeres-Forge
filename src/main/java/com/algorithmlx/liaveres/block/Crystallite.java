package com.algorithmlx.liaveres.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class Crystallite extends BushBlock {
    public Crystallite() {
        super(Properties.of(Material.METAL).requiresCorrectToolForDrops().noOcclusion().lightLevel((p_235435_0_) -> 10).strength(5f, 340282356779733661637539395458142568447F));
    }

    @Override
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter getter, BlockPos pos) {
        BlockState state = getter.getBlockState(pos);
        BlockState state1 = getter.getBlockState(pos.above());
        return (state.getBlock() == Blocks.STONE || blockState.getMaterial() == Material.STONE) && state1.getBlock() == Blocks.AIR;
    }
}
