package com.algorithmlx.liaveres.common.setup;

import com.algorithmlx.liaveres.common.LiaVeres;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;

public class Constants {
    private static final Rarity legendary = Rarity.create("legendary_" + LiaVeres.ModId, ChatFormatting.GOLD);

    public static final Rarity getLegendary = Rarity.valueOf(legendary.name());

    public static final int excavate = 17;
    public static final int fullExcavateRadius = 17 * 2 - 2;
}
