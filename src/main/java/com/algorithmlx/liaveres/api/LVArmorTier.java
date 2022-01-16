package com.algorithmlx.liaveres.api;

import com.algorithmlx.liaveres.setup.Registration;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum LVArmorTier implements ArmorMaterial {
    MatterCrystalTier("matter_crystal_tier", -1, new int[]{2147483647, 2147483647, 2147483647, 2147483647}, 2147483647, SoundEvents.ARMOR_EQUIP_NETHERITE, 2147483647F, 2147483647F, () -> {
        return Ingredient.of(Registration.MATTER_CRYSTAL.get());
    }),
    MatterTier("matter_tier", 6000, new int[]{5000, 15000, 20000, 10000}, 6, SoundEvents.ARMOR_EQUIP_DIAMOND, 20F, 0.5F, ()-> {
        return Ingredient.of(Registration.MATTER.get());
    });

    private static final int[] armorDurability = new int[]{5, 15, 20, 10};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairMaterial;

    LVArmorTier(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = new LazyLoadedValue<>(repairMaterial);

    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return armorDurability[slot.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.damageReductionAmountArray[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
