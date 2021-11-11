package com.algorithmlx.liaveres.common.block;

import com.algorithmlx.liaveres.common.setup.Registration;
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
                .strength(2147483647f, 5000f)
                .lightLevel(s -> 16)
                .sound(SoundType.METAL)
        );
    }

    @Override
    public List<ItemStack> getDrops(BlockState p_60537_, LootContext.Builder p_60538_) {
        return List.of(new ItemStack(Registration.MATTER_CRYSTAL.get()));
    }
}
