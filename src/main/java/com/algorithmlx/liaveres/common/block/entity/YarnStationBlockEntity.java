package com.algorithmlx.liaveres.common.block.entity;

import com.algorithmlx.liaveres.common.recipe.RecipeTypes;
import com.algorithmlx.liaveres.common.setup.Registration;
import core.liquid.objects.block.entity.AbstractRecipedBlockEntity;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class YarnStationBlockEntity extends AbstractRecipedBlockEntity {
    private final NonNullList<ItemStack> items;
    private static int yarnTag = 0;
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

    public YarnStationBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(Registration.YARN_STATION_BLOCK_ENTITY.get(), pWorldPosition, pBlockState, RecipeTypes.YARN_RECIPE_TYPE);
        this.items = NonNullList.withSize(3, ItemStack.EMPTY);
    }

    @Override
    public void readTag(CompoundTag compoundTag, boolean b) {
        yarnTag = compoundTag.getInt("yarnTag");
        ContainerHelper.saveAllItems(compoundTag, items);
    }

    @Override
    public void saveTag(CompoundTag compoundTag, boolean b) {
        compoundTag.putInt("yarnTag", yarnTag);
        ContainerHelper.saveAllItems(compoundTag, items);
    }

    @Override
    public void setRecipeUsed(@Nullable Recipe<?> pRecipe) {
        if (pRecipe != null) {
            ResourceLocation rLocation = pRecipe.getId();
            recipesUsed.addTo(rLocation, 1);
        }
    }

    @Override
    public @Nullable Recipe<?> getRecipeUsed() {
        return super.getRecipeUsed();
    }
}
