package com.algorithmlx.liaveres.common.item.basic;

import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

import java.util.Optional;

@Deprecated
public class GoldenNetherite extends Item {
    public GoldenNetherite() {
        super(new Properties().tab(ModSetup.CLASSIC_TAB).rarity(Rarity.valueOf("LEGENDARY")));
    }
}
