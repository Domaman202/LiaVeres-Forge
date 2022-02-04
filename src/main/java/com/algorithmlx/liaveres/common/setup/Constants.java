package com.algorithmlx.liaveres.common.setup;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

public class Constants {
    // TODO: Creating a Legendary Rarity
    private static final Rarity legendary = Rarity.create("legendary", ChatFormatting.GOLD);
    // TODO: aboba
    public static final Rarity getLegendary = Rarity.valueOf(legendary.name());

    public static final int excavate = 17;
    public static final int fullExcavateRadius = 17 * 2 - 2;
}
