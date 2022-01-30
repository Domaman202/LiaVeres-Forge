package com.algorithmlx.liaveres.common.item.api;

import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum LVToolMaterial implements Tier {
    MATTER_CRYSTAL(
            2147483647,
            -1,
            Float.MAX_VALUE,
            Float.MAX_VALUE,
            2147483647,
            ()-> Ingredient.of(ItemStack.EMPTY)
    ),
    GILDED_NETHERITE(
            5,
            8124,
            36.0F,
            16.0F,
            60,
            ()-> Ingredient.of(new ItemStack(Registration.GILDED_NETHERITE_INGOT.get(), 5))
    );
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    LVToolMaterial(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }
    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @NotNull
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}