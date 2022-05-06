package com.algorithmlx.liaveres.util.item;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import com.algorithmlx.liaveres.util.handler.Model;
import com.algorithmlx.liaveres.init.RegistryArray;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class ArmorBase extends ItemArmor implements Model {
    public static int idRender;

    public ArmorBase(String id, ArmorMaterial materialIn, EntityEquipmentSlot equipmentSlotIn, CreativeTabs tabs) {
        super(materialIn, idRender, equipmentSlotIn);
        if ((equipmentSlotIn == EntityEquipmentSlot.CHEST) || (equipmentSlotIn == EntityEquipmentSlot.HEAD) || (equipmentSlotIn == EntityEquipmentSlot.FEET)) {
            idRender = 1;
        } else if (equipmentSlotIn == EntityEquipmentSlot.LEGS) {
            idRender = 2;
        }

        this.setRegistryName(id);
        this.setUnlocalizedName(LiaVeresLegacy.MOD_ID + "." + id);
        this.setCreativeTab(tabs);
        RegistryArray.ITEMS.add(this);

    }

    @Override
    public void registerModels() {
        LiaVeresLegacy.proxy.getRender(this, 0, "inventory");
    }
}
