package com.algorithmlx.liaveres.common.object.itemtears;

import com.algorithmlx.liaveres.common.registry.ModItems;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum MatterArmorTear implements IArmorMaterial
{
    MatterCrystalArm("matter_crystal_arm", 2147483647, new int[]{2147483647, 2147483647, 2147483647, 2147483647},
            2147483647, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 339999999999999999999999999999999999999F, Ingredient.fromItems(ModItems.MatterCrystal));
    private static final int[] MAX_DAMAGE_ARRAY = new int[]{2147483647, 2147483647, 2147483647, 2147483647};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmount;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Ingredient repairMaterial;

    MatterArmorTear(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountsIn, int enchIn, SoundEvent equipSoundIn, float toughnessIn, Ingredient repairMaterial)
    {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmount = damageReductionAmountsIn;
        this.enchantability = enchIn;
        this.soundEvent = equipSoundIn;
        this.toughness = toughnessIn;
        this.repairMaterial = repairMaterial;
    }

    @Override public int getDurability(EquipmentSlotType slotIn)            { return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor; }
    @Override public int getDamageReductionAmount(EquipmentSlotType slotIn) { return this.damageReductionAmount[slotIn.getIndex()];              }
    @Override public int getEnchantability()                                { return this.enchantability;                                        }
    @Override public SoundEvent getSoundEvent()                             { return this.soundEvent;                                            }
    @Override public Ingredient getRepairMaterial()                         { return this.repairMaterial;                                        }
    @Override public float getToughness()                                   { return this.toughness;                                             }
    @Override public float getKnockbackResistance()                         { return this.getKnockbackResistance();                                   }

    @OnlyIn(Dist.CLIENT)
    @Override public String getName() { return this.name; }
}