package com.algorithmlx.liaveres.common.gata.generators;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class Recipes extends RecipeProvider {
    public Recipes(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
        upgradePattern(Items.NETHERITE_INGOT, Items.GILDED_BLACKSTONE, Registration.GOLDEN_NETHERITE_INGOT.get(), pFinishedRecipeConsumer);

        withGoldenNetheriteUpgrade(Items.NETHERITE_HELMET, Registration.GOLDEN_NETHERITE_HELMET.get(), pFinishedRecipeConsumer);
        withGoldenNetheriteUpgrade(Items.NETHERITE_CHESTPLATE, Registration.GOLDEN_NETHERITE_CHESTPLATE.get(), pFinishedRecipeConsumer);
        withGoldenNetheriteUpgrade(Items.NETHERITE_LEGGINGS, Registration.GOLDEN_NETHERITE_LEGS.get(), pFinishedRecipeConsumer);
        withGoldenNetheriteUpgrade(Items.NETHERITE_BOOTS, Registration.GOLDEN_NETHERITE_BOOTS.get(), pFinishedRecipeConsumer);

        blockCrafting(Registration.GOLDEN_NETHERITE_INGOT.get(), Registration.GOLDEN_NETHERITE_BLOCK.get(), pFinishedRecipeConsumer);

        blockUncrafting(Registration.GOLDEN_NETHERITE_BLOCK.get(), Registration.GOLDEN_NETHERITE_INGOT.get(), pFinishedRecipeConsumer);
    }

    private void withGoldenNetheriteUpgrade(ItemLike ingredient, Item result, @NotNull Consumer<FinishedRecipe> consumer) {
        UpgradeRecipeBuilder.smithing(Ingredient.of(ingredient), Ingredient.of(Registration.GOLDEN_NETHERITE_INGOT.get()), result)
                .unlocks("crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CRAFTING_TABLE))
                .save(consumer, new ResourceLocation(LiaVeres.ModId, result.getRegistryName().getPath() + "_smithing"));
    }

    private void blockCrafting(ItemLike ingredient, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
                .pattern("aaa")
                .pattern("aaa")
                .pattern("aaa")
                .define('a', ingredient)
                .unlockedBy("crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CRAFTING_TABLE))
                .save(consumer);
    }

    private void upgradePattern(ItemLike ingredient, ItemLike addition, Item result, @NotNull Consumer<FinishedRecipe> consumer) {
        UpgradeRecipeBuilder.smithing(Ingredient.of(ingredient), Ingredient.of(addition), result)
                .unlocks("crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CRAFTING_TABLE))
                .save(consumer, new ResourceLocation(LiaVeres.ModId, result.getRegistryName().getPath() + "_upgrade"));
    }

    private void blockUncrafting(ItemLike ingredient, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result, 9)
                .requires(ingredient)
                .unlockedBy("crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CRAFTING_TABLE))
                .save(consumer, new ResourceLocation(LiaVeres.ModId, ingredient.asItem().getRegistryName().getPath() + "_uncraft"));
    }
}
