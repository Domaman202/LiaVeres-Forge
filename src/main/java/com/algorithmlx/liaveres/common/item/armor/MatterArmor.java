package com.algorithmlx.liaveres.common.item.armor;

import com.algorithmlx.liaveres.common.item.material.LVArmorMaterial;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import com.algorithmlx.liaveres.common.setup.Registration;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import static com.algorithmlx.liaveres.common.LiaVeres.ModId;

public class MatterArmor extends ArmorItem {
    public MatterArmor(EquipmentSlot pSlot) {
        super(LVArmorMaterial.MATTER, pSlot, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB));
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!player.getPersistentData().contains("wearingFullMatterArmor"))player.getPersistentData().putBoolean("wearingFullMatterArmor", false);

        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        if(!player.getPersistentData().contains("wearingFullMatterArmor"))player
                .getPersistentData().putBoolean("wearingFullMatterArmor", false);
        boolean iswearingFullMatterArmor =
                head != null && head.getItem() == Registration.MATTER_HELMET.get() &&
                        chest != null && chest.getItem() == Registration.MATTER_CHESTPLATE.get() &&
                        legs != null && legs.getItem() == Registration.MATTER_LEGS.get() &&
                        feet != null && feet.getItem() == Registration.MATTER_BOOTS.get();

        boolean wasWearingMatterCrystalArmorLastTick = player.getPersistentData().getBoolean("wearingFullMatterArmor");

        if(iswearingFullMatterArmor && wasWearingMatterCrystalArmorLastTick){
            MobEffectInstance regeneration = new MobEffectInstance(MobEffects.REGENERATION, 1, 1, false, false);
            player.addEffect(regeneration);

            MobEffectInstance nv = new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 1, false, false);
            player.addEffect(nv);
        }

        player.getPersistentData().putBoolean("wearingFullMatterArmor", iswearingFullMatterArmor);
    }
    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot slot, String layer)
    {
        if (slot == EquipmentSlot.LEGS)
        {
            return ModId + ":textures/armor/matter/2.png";
        }
        else
        {
            return ModId + ":textures/armor/matter/1.png";
        }
    }
    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return stack.copy();
    }
}
