package com.algorithmlx.liaveres.item.armor;

import com.algorithmlx.liaveres.api.enums.LVArmorTier;
import com.algorithmlx.liaveres.setup.Registration;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

import static com.algorithmlx.liaveres.LiaVeres.ModId;
import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class MatterArmor extends ArmorItem {
    public MatterArmor(EquipmentSlotType p_i48534_2_, Properties p_i48534_3_) {
        super(LVArmorTier.MatterTier, p_i48534_2_, p_i48534_3_.tab(LIAVERES_ALL));
    }
    @Override
    public void onArmorTick(ItemStack stack, World level, PlayerEntity player) {
        super.onArmorTick(stack, level, player);
        if(!player.getPersistentData().contains("wearingFullMatterArmor"))player.getPersistentData()
                .putBoolean("wearingFullMatterArmor", false);

        ItemStack head = player.getItemBySlot(EquipmentSlotType.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlotType.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlotType.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlotType.FEET);

        if(!player.getPersistentData().contains("wearingFullMatterCrystalArmor"))player
                .getPersistentData().putBoolean("wearingFullMatterCrystalArmor", false);
        boolean iswearingFullMatterArmor =
                head != null && head.getItem() == Registration.MATTER_HELMET.get() &&
                        chest != null && chest.getItem() == Registration.MATTER_CHESTPLATE.get() &&
                        legs != null && legs.getItem() == Registration.MATTER_LEGS.get() &&
                        feet != null && feet.getItem() == Registration.MATTER_BOOTS.get();

        boolean wasWearingMatterArmorLastTick = player.getPersistentData()
                .getBoolean("wearingFullMatterArmor");

        if(iswearingFullMatterArmor && wasWearingMatterArmorLastTick) {
            //good effect add
            EffectInstance nv = new EffectInstance
                    (Effects.NIGHT_VISION, 1, 1, false, false);
            player.addEffect(nv);
            EffectInstance regen = new EffectInstance
                    (Effects.REGENERATION, 1, 1, false, false);
            player.addEffect(regen);
        }
        player.getPersistentData().putBoolean("wearingFullMatterArmor", iswearingFullMatterArmor);
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlotType slot, String layer)
    {
        if (slot == EquipmentSlotType.LEGS)
        {
            return ModId + ":textures/armor/matter/2.png";
        }
        else
        {
            return ModId + ":textures/armor/matter/1.png";
        }
    }
}
