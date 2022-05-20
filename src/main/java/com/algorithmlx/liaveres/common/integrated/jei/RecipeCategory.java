package com.algorithmlx.liaveres.common.integrated.jei;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.recipe.YarnRecipe;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

@SuppressWarnings("all")
public class RecipeCategory implements IRecipeCategory<YarnRecipe> {
    private final IDrawableStatic drawableStatic;

    public RecipeCategory(IGuiHelper helper) {
        drawableStatic = helper.createDrawable(new ResourceLocation(LiaVeres.ModId, "textures/gui/jei_yarn.png"), 0, 0, 166, 128);
    }

    @Override
    public Component getTitle() {
        return new TranslatableComponent("jei." + LiaVeres.ModId + ".yarn_recipe_jei");
    }

    @Override
    public IDrawable getBackground() {
        return drawableStatic;
    }

    @Override
    public IDrawable getIcon() {
        return null;
    }

    @Override
    public ResourceLocation getUid() {
        return new ResourceLocation(LiaVeres.ModId, "jei_yarn");
    }

    @Override
    public Class getRecipeClass() {
        return YarnRecipe.class;
    }
}
