package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.itemtears.MatterArmorTear;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MatterCrystalArmor extends ArmorItem {
    public MatterCrystalArmor(EquipmentSlotType slot, Properties builderIn) {
        super(MatterArmorTear.MatterCrystalArm, slot, builderIn);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        player.abilities.allowFlying = true;
    }
}
