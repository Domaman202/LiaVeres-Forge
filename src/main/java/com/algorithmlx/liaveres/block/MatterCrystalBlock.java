package com.algorithmlx.liaveres.block;

import com.algorithmlx.liaveres.setup.Registration;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.List;

public class MatterCrystalBlock extends Block {
    public MatterCrystalBlock() {
        super(Properties.of(Material.STONE)
                .strength(340282356779733661637539395458142568447F,340282356779733661637539395458142568447F)
                .sound(SoundType.METAL)
        );
    }
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder)
    {
        return ImmutableList.of(new ItemStack(Registration.MATTER_CRYSTAL_BLOCK_ITEM.get(), 1));
    }
}
