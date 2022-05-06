package com.algorithmlx.liaveres.recipe;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;

public class ModRecipe {
    public static void init() {
        registrar("ne_ebu_chto_za_recipe");
    }

    private static void registrar(String name) {
        CraftingHelper.register(new ResourceLocation(LiaVeresLegacy.MOD_ID, name),
                (IRecipeFactory) (c, j)-> CraftingHelper.getRecipe(j, c));
    }
}
