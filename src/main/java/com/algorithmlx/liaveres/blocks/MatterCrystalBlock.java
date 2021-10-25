package com.algorithmlx.liaveres.blocks;

import com.algorithmlx.liaveres.registry.Registration;
import com.google.common.collect.ImmutableList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.storage.loot.LootContext;

import java.util.List;

public class MatterCrystalBlock extends Block {
    public MatterCrystalBlock() {
        super(Block.Properties.of(Material.METAL)
                .explosionResistance(2147483647f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
        );
    }
    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder)
    {
        return ImmutableList.of(new ItemStack(Registration.MATTER_CRYSTAL_BLOCK_ITEM.get(), 1));
    }
}
