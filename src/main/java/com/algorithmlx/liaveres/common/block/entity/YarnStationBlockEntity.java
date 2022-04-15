package com.algorithmlx.liaveres.common.block.entity;

import com.algorithmlx.liaveres.common.recipe.YarnRecipe;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
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
    private final NonNullList<ItemStack> nonNullList = NonNullList.withSize(4, ItemStack.EMPTY);
    private static int yarnTag = 0;
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();

    public YarnStationBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(Registration.YARN_STATION_BLOCK_ENTITY.get(), pWorldPosition, pBlockState, YarnRecipe.RECIPE_TYPE);
    }

    @Override
    public void readTag(CompoundTag compoundTag, boolean b) {
        yarnTag = compoundTag.getInt("yarnTag");
        ContainerHelper.loadAllItems(compoundTag, nonNullList);
    }

    @Override
    public void saveTag(CompoundTag compoundTag, boolean b) {
        compoundTag.putInt("yarnTag", yarnTag);
        ContainerHelper.saveAllItems(compoundTag, nonNullList);
    }

    @Override
    public void setRecipeUsed(@Nullable Recipe<?> pRecipe) {
        if (pRecipe != null) {
            ResourceLocation rLocation = pRecipe.getId();
            recipesUsed.addTo(rLocation, 1);
        }
    }

    @Nullable
    @Override
    public Recipe<?> getRecipeUsed() {
        return null;
    }
}
