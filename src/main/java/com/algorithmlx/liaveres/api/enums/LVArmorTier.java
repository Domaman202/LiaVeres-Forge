package com.algorithmlx.liaveres.api.enums;

import com.algorithmlx.liaveres.setup.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum LVArmorTier implements IArmorMaterial {
    MatterCrystalTier("matter_crystal_tier", -1, new int[]{2147483647, 2147483647, 2147483647, 2147483647}, 500, SoundEvents.ARMOR_EQUIP_NETHERITE, 2147483647F, 2147483647F,
            () -> {return Ingredient.of(Registration.MATTER_CRYSTAL.get());
    }),
    MatterTier("matter_tier", 6000, new int[]{5000, 15000, 20000, 10000}, 6, SoundEvents.ARMOR_EQUIP_DIAMOND, 20F, 0.5F,
            ()-> {return Ingredient.of(Registration.MATTER.get());
    });

    private static final int[] armorDurability = new int[]{5, 15, 20, 10};
    private final String name;
    private final int maxDamageFactor;
    private final int[] armorDefense;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyValue<Ingredient> repairIngredient;

    LVArmorTier(String name, int maxDamageFactor, int[] armorDefense, int enchantability, SoundEvent soundEvent, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.maxDamageFactor = maxDamageFactor;
        this.armorDefense = armorDefense;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlotType slotIn) {
        return armorDurability[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlotType slotIn) {
        return this.armorDefense[slotIn.getIndex()];
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
        return this.repairIngredient.get();
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