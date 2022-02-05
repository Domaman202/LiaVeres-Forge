package com.algorithmlx.liaveres.common.setup;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.container.BackpackContainer;
import net.minecraft.ChatFormatting;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Rarity;

public class Constants {
    private static final Rarity legendary = Rarity.create("legendary", ChatFormatting.GOLD);

    public static final Rarity getLegendary = Rarity.valueOf(legendary.name());

    public static MenuType<BackpackContainer> CONTAINER_TYPE;

    public static final int excavate = 17;
    public static final int fullExcavateRadius = 17 * 2 - 2;
    public static final ResourceLocation ID_MENU = id("backpack");
    public static final String IDMenuString = ID_MENU.toString();

    public static ResourceLocation id(String name) {
        return new ResourceLocation(LiaVeres.ModId, name);
    }
}
