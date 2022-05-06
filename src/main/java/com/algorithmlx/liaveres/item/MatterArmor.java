package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.init.RegistryArray;
import com.algorithmlx.liaveres.util.item.ArmorBase;
import com.algorithmlx.liaveres.util.material.LiaMaterials;
import com.algorithmlx.liaveres.util.tab.Tabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MatterArmor extends ArmorBase {
    public MatterArmor(String id, EntityEquipmentSlot equipmentSlotIn) {
        super(id, LiaMaterials.MATTER_ARMOR, equipmentSlotIn, Tabs.LIAVERES);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        ItemStack legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
        ItemStack boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);

        boolean fullArmorInPlayer =
                (head != null && head.getItem() == RegistryArray.MATTER_HELMET) &&
                        (chest != null && chest.getItem() == RegistryArray.MATTER_CHESTPLATE) &&
                        (legs != null && legs.getItem() == RegistryArray.MATTER_LEGS) &&
                        (boots != null && boots.getItem() == RegistryArray.MATTER_BOOTS);
    }
}
