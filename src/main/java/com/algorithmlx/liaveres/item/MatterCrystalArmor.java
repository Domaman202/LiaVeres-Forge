package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.init.RegistryArray;
import com.algorithmlx.liaveres.util.item.ArmorBase;
import com.algorithmlx.liaveres.util.material.LiaMaterials;
import com.algorithmlx.liaveres.util.tab.Tabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDamageEvent;

import java.util.Random;

@SuppressWarnings("all")
public class MatterCrystalArmor extends ArmorBase {
    public MatterCrystalArmor(String id, EntityEquipmentSlot equipmentSlotIn) {
        super(id, LiaMaterials.MATTER_CRYSTAL_ARMOR, equipmentSlotIn, Tabs.LIAVERES);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        ItemStack head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        ItemStack chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        ItemStack legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
        ItemStack boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);

        boolean fullArmorInPlayer =
                (head != null && head.getItem() == RegistryArray.MATTER_CRYSTAL_HELMET) &&
                (chest != null && chest.getItem() == RegistryArray.MATTER_CRYSTAL_CHESTPLATE) &&
                (legs != null && legs.getItem() == RegistryArray.MATTER_CRYSTAL_LEGS) &&
                (boots != null && boots.getItem() == RegistryArray.MATTER_CRYSTAL_BOOTS);

        if (!fullArmorInPlayer && !player.isCreative()) {
            player.capabilities.allowFlying = false;
            player.capabilities.isFlying = false;
        } else if (fullArmorInPlayer) {
            player.capabilities.allowFlying = true;
        }

        if (fullArmorInPlayer) {
            if(player.getActivePotionEffect(MobEffects.BLINDNESS) != null) {
                player.removeActivePotionEffect(MobEffects.BLINDNESS);
            }

            if(player.getActivePotionEffect(MobEffects.SLOWNESS) != null) {
                player.removeActivePotionEffect(MobEffects.SLOWNESS);
            }

            if(player.getActivePotionEffect(MobEffects.MINING_FATIGUE) != null) {
                player.removeActivePotionEffect(MobEffects.MINING_FATIGUE);
            }

            if(player.getActivePotionEffect(MobEffects.INSTANT_DAMAGE) != null) {
                player.removeActivePotionEffect(MobEffects.INSTANT_DAMAGE);
            }

            if(player.getActivePotionEffect(MobEffects.NAUSEA) != null) {
                player.removeActivePotionEffect(MobEffects.NAUSEA);
            }

            if(player.getActivePotionEffect(MobEffects.HUNGER) != null) {
                player.removeActivePotionEffect(MobEffects.HUNGER);
            }

            if(player.getActivePotionEffect(MobEffects.POISON) != null) {
                player.removeActivePotionEffect(MobEffects.POISON);
            }

            if(player.getActivePotionEffect(MobEffects.WITHER) != null) {
                player.removeActivePotionEffect(MobEffects.WITHER);
            }

            if(player.getActivePotionEffect(MobEffects.LEVITATION) != null) {
                player.removeActivePotionEffect(MobEffects.LEVITATION);
            }

            if(player.getActivePotionEffect(MobEffects.UNLUCK) != null) {
                player.removeActivePotionEffect(MobEffects.UNLUCK);
            }

            if(player.getActivePotionEffect(MobEffects.WEAKNESS) != null) {
                player.removeActivePotionEffect(MobEffects.WEAKNESS);
            }

            PotionEffect nightVision = new PotionEffect(MobEffects.NIGHT_VISION, 300, 0, false, false);
            PotionEffect regen = new PotionEffect(MobEffects.REGENERATION, 300, 2147483647, false, false);
            PotionEffect underWater = new PotionEffect(MobEffects.WATER_BREATHING, 300, 0, false, false);
            PotionEffect haste = new PotionEffect(MobEffects.HASTE, 300, 20, false, false);
            PotionEffect saturation = new PotionEffect(MobEffects.SATURATION, 300, 50, false, false);
            PotionEffect strength = new PotionEffect(MobEffects.STRENGTH, 300, 20, false, false);
            PotionEffect fireResistance = new PotionEffect(MobEffects.FIRE_RESISTANCE, 300, 2147483647, false, false);
            PotionEffect luck = new PotionEffect(MobEffects.LUCK, 300, 10, false, false);

            player.addPotionEffect(nightVision);
            player.addPotionEffect(regen);
            player.addPotionEffect(underWater);
            player.addPotionEffect(haste);
            player.addPotionEffect(saturation);
            player.addPotionEffect(strength);
            player.addPotionEffect(fireResistance);
            player.addPotionEffect(luck);
        }
    }

    public static void cancelDamage(LivingDamageEvent event) {
        EntityLivingBase entity = event.getEntityLiving();
        Random random = new Random();

        ItemStack head = entity.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        ItemStack chest = entity.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        ItemStack legs = entity.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
        ItemStack boots = entity.getItemStackFromSlot(EntityEquipmentSlot.FEET);

        boolean fullArmorInPlayer =
                (head != null && head.getItem() == RegistryArray.MATTER_CRYSTAL_HELMET) &&
                        (chest != null && chest.getItem() == RegistryArray.MATTER_CRYSTAL_CHESTPLATE) &&
                        (legs != null && legs.getItem() == RegistryArray.MATTER_CRYSTAL_LEGS) &&
                        (boots != null && boots.getItem() == RegistryArray.MATTER_CRYSTAL_BOOTS);

        if (event.isCanceled() || event.getAmount() <= 0 || event.getEntityLiving().world.isRemote) {
            return;
        }

        if (!fullArmorInPlayer) return;


        if (random.nextInt(Integer.MAX_VALUE) > 0) {
            event.setCanceled(true);
        }
    }
}
