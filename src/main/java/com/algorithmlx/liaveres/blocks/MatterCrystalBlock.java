package com.algorithmlx.liaveres.blocks;

import com.algorithmlx.liaveres.registry.ModItems;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;

import java.util.List;

public class MatterCrystalBlock extends MatterBlockBase {
    public MatterCrystalBlock(String name, int lvl){
        super(name, lvl);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder)
    {
        return ImmutableList.of(new ItemStack(ModItems.MatterCrystal, 9));
    }
}