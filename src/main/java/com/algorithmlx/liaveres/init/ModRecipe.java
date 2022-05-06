package com.algorithmlx.liaveres.init;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;

public class ModRecipe {
    public static void init() {
        recipe("crystalline");
        recipe("effect_catalyst");
        recipe("matter");
        recipe("matter_crystal");

        recipe("enchanted_apple");
        recipe("enchanted_golden_apple");

        recipe("matter_boots");
        recipe("matter_chestplate");
        recipe("matter_helmet");
        recipe("matter_leggings");
        recipe("matter_crystal_helmet");
        recipe("matter_crystal_chestplate");
        recipe("matter_crystal_leggings");
        recipe("matter_crystal_boots");


        recipe("matter_crystal_axe");
        recipe("matter_crystal_hoe");
        recipe("matter_crystal_pickaxe");
        recipe("matter_crystal_shovel");
        recipe("matter_crystal_sword");

        recipe("matter_crystal_block");
        recipe("matter_crystal_block_uncraft");
        recipe("matter_block");
        recipe("matter_block_uncraft");
    }

    private static void recipe(String name) {
        CraftingHelper.register(new ResourceLocation(LiaVeresLegacy.MOD_ID, name),
                (IRecipeFactory) (c, j)-> CraftingHelper.getRecipe(j, c));
        LiaVeresLegacy.LOGGER.debug("Registration next recipes: {}", name);
    }
}
