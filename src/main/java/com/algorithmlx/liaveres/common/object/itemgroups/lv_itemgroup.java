package com.algorithmlx.liaveres.common.object.itemgroups;

import com.algorithmlx.liaveres.common.registry.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class lv_itemgroup extends ItemGroup {
    public lv_itemgroup(String name)
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