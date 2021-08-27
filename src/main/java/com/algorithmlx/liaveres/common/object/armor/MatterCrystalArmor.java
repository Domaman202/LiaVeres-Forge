package com.algorithmlx.liaveres.common.object.armor;

import com.algorithmlx.liaveres.common.object.itemtears.MatterArmorTear;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class MatterCrystalArmor extends ArmorItem
{
    public MatterCrystalArmor(EquipmentSlotType slot)
    {
        super(MatterArmorTear.MatterCrystalArm, slot, new Properties());
    }
}
