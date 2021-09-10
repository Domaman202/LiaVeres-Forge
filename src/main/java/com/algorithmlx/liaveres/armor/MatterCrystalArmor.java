package com.algorithmlx.liaveres.armor;

import com.algorithmlx.liaveres.itemtears.MatterArmorTear;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class MatterCrystalArmor extends ArmorItem
{
    public MatterCrystalArmor(EquipmentSlotType slot)
    {
        super(MatterArmorTear.MatterCrystalArm, slot, new Properties());
    }
}
