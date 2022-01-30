package com.algorithmlx.liaveres.common.item.api;

import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum LVArmorMaterial implements ArmorMaterial {
    MATTER_CRYSTAL(
            "matter_crystal",
            -1,
            new int[]{
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE
        },
            Integer.MAX_VALUE,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            Float.MAX_VALUE,
            Float.MAX_VALUE,
            ()-> Ingredient.of(Registration.MATTER_CRYSTAL.get())
    ),
    MATTER(
            "matter",
            6000,
            new int[]{
                    5000,
                    15000,
                    20000,
                    10000
            },
            6,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            20F,
            0.5F,
            ()-> Ingredient.of(Registration.MATTER.get())
    ),
   GILDED_NETHERITE(
            "gilded_netherite",
            65,
            new int[] {
                    12,
                    24,
                    32,
                    12
            },
            50,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0f,
            1f,
            ()-> Ingredient.of(Registration.GILDED_NETHERITE_INGOT.get())
    );

    private static final int[] armorDurability =  new int[]{13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairMaterial;

    LVArmorMaterial(String name, int maxDamageFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairMaterial = repairMaterial;

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
    public @NotNull SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    public @NotNull String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
