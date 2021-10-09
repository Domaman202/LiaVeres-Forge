package com.algorithmlx.liaveres.blocks;

import com.algorithmlx.liaveres.itemtears.MatterTear;
import com.algorithmlx.liaveres.registry.ModBlocks;
import com.algorithmlx.liaveres.registry.ModItems;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.List;

public class MatterCrystalBlock extends Block {
    public MatterCrystalBlock() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(2147483647f, 2147483647f)
                .sound(SoundType.METAL)
        );
    }
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder)
    {
        return ImmutableList.of(new ItemStack(ModBlocks.MATTER_CRYSTAL_BLOCK_ITEM.get(), 1));
    }
}
