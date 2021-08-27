package com.algorithmlx.liaveres.common.object.itemtears;

import com.algorithmlx.liaveres.common.registry.ModItems;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public enum MatterTear implements IItemTier {

        MatterTear(2147483647, -1, 340282356779733661637539395458142568447F, 340282356779733661637539395458142568447F, 2147483647, Ingredient.fromStacks(new ItemStack(ModItems.MatterCrystal, 2147483647)));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

    MatterTear(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Ingredient repairMaterialIn) {
        this.harvestLevel = harvestLevelIn;
        this.maxUses = maxUsesIn;
        this.efficiency = efficiencyIn;
        this.attackDamage = attackDamageIn;
        this.enchantability = enchantabilityIn;
        this.repairMaterial = repairMaterialIn;
    }
        @Override public int getMaxUses()               {  return this.maxUses;        }
        @Override public float getEfficiency()          {  return this.efficiency;     }
        @Override public float getAttackDamage()        {  return this.attackDamage;   }
        @Override public int getHarvestLevel()          {  return this.harvestLevel;   }
        @Override public int getEnchantability()        {  return this.enchantability; }
        @Override public Ingredient getRepairMaterial() {  return this.repairMaterial; }
}
