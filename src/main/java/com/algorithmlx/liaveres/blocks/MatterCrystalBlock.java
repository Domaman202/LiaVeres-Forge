package com.algorithmlx.liaveres.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class MatterCrystalBlock extends Block {

    public MatterCrystalBlock() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(9999999f)
                .sound(SoundType.METAL)
        );
    }
}
