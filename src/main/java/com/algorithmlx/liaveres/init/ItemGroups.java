package com.algorithmlx.liaveres.init;

import com.algorithmlx.liaveres.items.MatterCrystal;
import com.algorithmlx.liaveres.registry.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

import static com.algorithmlx.liaveres.registry.ModItems.MATTER_CRYSTAL;

public class ItemGroups extends ItemGroup {

    public ItemGroups(String name)
    {
        super(name);
    }

    @Nonnull
    public ItemStack createIcon()
    {
        return new ItemStack(MATTER_CRYSTAL.get());
    }

    @Override
    public boolean hasSearchBar()
    {
        return false;
    }
}