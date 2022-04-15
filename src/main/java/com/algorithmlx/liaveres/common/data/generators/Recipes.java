package com.algorithmlx.liaveres.common.data.generators;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
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
        upgradePattern(Items.NETHERITE_INGOT, Items.GILDED_BLACKSTONE, Registration.GILDED_NETHERITE_INGOT.get(), pFinishedRecipeConsumer);

        withGildedNetheriteUpgrade(Items.NETHERITE_HELMET, Registration.GILDED_NETHERITE_HELMET.get(), pFinishedRecipeConsumer);
        withGildedNetheriteUpgrade(Items.NETHERITE_CHESTPLATE, Registration.GILDED_NETHERITE_CHESTPLATE.get(), pFinishedRecipeConsumer);
        withGildedNetheriteUpgrade(Items.NETHERITE_LEGGINGS, Registration.GILDED_NETHERITE_LEGS.get(), pFinishedRecipeConsumer);
        withGildedNetheriteUpgrade(Items.NETHERITE_BOOTS, Registration.GILDED_NETHERITE_BOOTS.get(), pFinishedRecipeConsumer);
        withGildedNetheriteUpgrade(Items.NETHERITE_PICKAXE, Registration.GILDED_NETHERITE_PICKAXE.get(), pFinishedRecipeConsumer);
        withGildedNetheriteUpgrade(Items.NETHERITE_SWORD, Registration.GILDED_NETHERITE_SWORD.get(), pFinishedRecipeConsumer);
        withGildedNetheriteUpgrade(Items.NETHERITE_HOE, Registration.GILDED_NETHERITE_HOE.get(), pFinishedRecipeConsumer);
        withGildedNetheriteUpgrade(Items.NETHERITE_AXE, Registration.GILDED_NETHERITE_AXE.get(), pFinishedRecipeConsumer);
        withGildedNetheriteUpgrade(Items.NETHERITE_SHOVEL, Registration.GILDED_NETHERITE_SHOVEL.get(), pFinishedRecipeConsumer);

        blockCrafting(Registration.GILDED_NETHERITE_INGOT.get(), Registration.GILDED_NETHERITE_BLOCK.get(), pFinishedRecipeConsumer);

        blockUncrafting(Registration.GILDED_NETHERITE_BLOCK.get(), Registration.GILDED_NETHERITE_INGOT.get(), pFinishedRecipeConsumer);

        craftingTable(
                "aaa",
                "a a",
                "aaa",
                'a',
                Items.LEATHER,
                Registration.BASIC_BACKPACK.get(),
                pFinishedRecipeConsumer);
    }

    private void withGildedNetheriteUpgrade(ItemLike ingredient, Item result, @NotNull Consumer<FinishedRecipe> consumer) {
        UpgradeRecipeBuilder.smithing(Ingredient.of(ingredient), Ingredient.of(Registration.GILDED_NETHERITE_INGOT.get()), result).unlocks("crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CRAFTING_TABLE)).save(consumer, new ResourceLocation(LiaVeres.ModId, result.getRegistryName().getPath() + "_smithing"));
    }

    private void blockCrafting(ItemLike ingredient, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result).pattern("aaa").pattern("aaa").pattern("aaa").define('a', ingredient).unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY)).save(consumer);
    }

    private void upgradePattern(ItemLike ingredient, ItemLike addition, Item result, @NotNull Consumer<FinishedRecipe> consumer) {
        UpgradeRecipeBuilder.smithing(Ingredient.of(ingredient), Ingredient.of(addition), result).unlocks("crafting_table", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.CRAFTING_TABLE)).save(consumer, new ResourceLocation(LiaVeres.ModId, result.getRegistryName().getPath() + "_upgrade"));
    }

    private void blockUncrafting(ItemLike ingredient, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(result, 9).requires(ingredient).unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY)).save(consumer, new ResourceLocation(LiaVeres.ModId, ingredient.asItem().getRegistryName().getPath() + "_uncraft"));
    }

    private void craftingTable(String pattern, String pattern1, String pattern2, Character symbol, ItemLike ingredient, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
        .pattern(pattern)
        .pattern(pattern1)
        .pattern(pattern2)
        .define(symbol, ingredient)
        .unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY))
        .save(consumer);
    }

    private void craftingTable(String pattern, String pattern1, String pattern2, Character symbol, Character symbol1, ItemLike ingredient, ItemLike ingredient1, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
               .pattern(pattern)
               .pattern(pattern1)
               .pattern(pattern2)
               .define(symbol, ingredient)
               .define(symbol1, ingredient1)
               .unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY))
               .save(consumer);
    }

    private void craftingTable(String pattern, String pattern1, String pattern2, Character symbol, Character symbol1, Character symbol2, ItemLike ingredient, ItemLike ingredient1, ItemLike ingredient2, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
                .pattern(pattern)
                .pattern(pattern1)
                .pattern(pattern2)
                .define(symbol, ingredient)
                .define(symbol1, ingredient1)
                .define(symbol2, ingredient2)
                .unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY))
                .save(consumer, new ResourceLocation(LiaVeres.ModId, result.asItem().getRegistryName().getPath()));
    }

    private void craftingTable(String pattern, String pattern1, String pattern2, Character symbol, Character symbol1, Character symbol2, Character symbol3, ItemLike ingredient, ItemLike ingredient1, ItemLike ingredient2, ItemLike ingredient3, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
               .pattern(pattern)
               .pattern(pattern1)
               .pattern(pattern2)
               .define(symbol, ingredient)
               .define(symbol1, ingredient1)
               .define(symbol2, ingredient2)
               .define(symbol3, ingredient3)
               .unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY))
               .save(consumer);
    }

    private void craftingTable(String pattern, String pattern1, String pattern2, Character symbol, Character symbol1, Character symbol2, Character symbol3, Character symbol4, ItemLike ingredient, ItemLike ingredient1, ItemLike ingredient2, ItemLike ingredient3, ItemLike ingredient4, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
               .pattern(pattern).pattern(pattern1)
               .pattern(pattern2)
               .define(symbol, ingredient)
               .define(symbol1, ingredient1)
               .define(symbol2, ingredient2)
               .define(symbol3, ingredient3)
               .define(symbol4, ingredient4)
               .unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY))
               .save(consumer);
    }

    private void craftingTable(String pattern, String pattern1, String pattern2, Character symbol, Character symbol1, Character symbol2, Character symbol3, Character symbol4, Character symbol5, ItemLike ingredient, ItemLike ingredient1, ItemLike ingredient2, ItemLike ingredient3, ItemLike ingredient4, ItemLike ingredient5, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
               .pattern(pattern)
               .pattern(pattern1)
               .pattern(pattern2)
               .define(symbol, ingredient)
               .define(symbol1, ingredient1)
               .define(symbol2, ingredient2)
               .define(symbol3, ingredient3)
               .define(symbol4, ingredient4)
               .define(symbol5, ingredient5)
               .unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY))
               .save(consumer);
    }

    private void craftingTable(String pattern, String pattern1, String pattern2, Character symbol, Character symbol1, Character symbol2, Character symbol3, Character symbol4, Character symbol5, Character symbol6, ItemLike ingredient, ItemLike ingredient1, ItemLike ingredient2, ItemLike ingredient3, ItemLike ingredient4, ItemLike ingredient5, ItemLike ingredient6, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
               .pattern(pattern)
               .pattern(pattern1)
               .pattern(pattern2)
               .define(symbol, ingredient)
               .define(symbol1, ingredient1)
               .define(symbol2, ingredient2)
               .define(symbol3, ingredient3)
               .define(symbol4, ingredient4)
               .define(symbol5, ingredient5)
               .define(symbol6, ingredient6)
               .unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY))
               .save(consumer);
    }

    private void craftingTable(String pattern, String pattern1, String pattern2, Character symbol, Character symbol1, Character symbol2, Character symbol3, Character symbol4, Character symbol5, Character symbol6, Character symbol7, ItemLike ingredient, ItemLike ingredient1, ItemLike ingredient2, ItemLike ingredient3, ItemLike ingredient4, ItemLike ingredient5, ItemLike ingredient6, ItemLike ingredient7, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
               .pattern(pattern)
               .pattern(pattern1)
               .pattern(pattern2)
               .define(symbol, ingredient)
               .define(symbol1, ingredient1)
               .define(symbol2, ingredient2)
               .define(symbol3, ingredient3)
               .define(symbol4, ingredient4)
               .define(symbol5, ingredient5)
               .define(symbol6, ingredient6)
               .define(symbol7, ingredient7)
               .unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY))
               .save(consumer);
    }
    private void craftingTable(String pattern, String pattern1, String pattern2, Character symbol, Character symbol1, Character symbol2, Character symbol3, Character symbol4, Character symbol5, Character symbol6, Character symbol7, Character symbol8, ItemLike ingredient, ItemLike ingredient1, ItemLike ingredient2, ItemLike ingredient3, ItemLike ingredient4, ItemLike ingredient5, ItemLike ingredient6, ItemLike ingredient7, ItemLike ingredient8, ItemLike result, @NotNull Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(result)
               .pattern(pattern)
               .pattern(pattern1)
               .pattern(pattern2)
               .define(symbol, ingredient)
               .define(symbol1, ingredient1)
               .define(symbol2, ingredient2)
               .define(symbol3, ingredient3)
               .define(symbol4, ingredient4)
               .define(symbol5, ingredient5)
               .define(symbol6, ingredient6)
               .define(symbol7, ingredient7)
               .define(symbol8, ingredient8)
               .unlockedBy("any", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.ANY))
               .save(consumer);
    }
}
