package com.algorithmlx.liaveres.init;

import com.algorithmlx.liaveres.registry.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ItemGroups extends ItemGroup {
    public ItemGroups(String name)
    {
        super(name);
    }

    @Nonnull
    public ItemStack createIcon()
    {
        return new ItemStack(ModItems.MatterCrystal);
    }

    @Override
    public boolean hasSearchBar()
    {
        return false;
    }
}