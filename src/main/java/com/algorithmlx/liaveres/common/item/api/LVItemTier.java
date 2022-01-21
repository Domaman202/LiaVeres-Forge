package com.algorithmlx.liaveres.common.item.api;

import com.algorithmlx.liaveres.common.setup.Registration;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public enum LVItemTier implements Tier {
    MatterTear(2147483647, -1, 340282356779733661637539395458142568447F,
            340282356779733661637539395458142568447F, 2147483647,
            Ingredient.of(new ItemStack(Registration.MATTER_CRYSTAL.get(), 2147483647))
    );
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairMaterial;
    LVItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Ingredient repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = repairMaterialIn;
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
        return this.repairMaterial;
    }
}