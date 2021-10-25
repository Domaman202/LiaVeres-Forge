package com.algorithmlx.liaveres.items;

/*import com.algorithmlx.liaveres.api.enums.LVItemTiers;
import com.algorithmlx.liaveres.registry.Registration;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.LiaVeres.ModId;
*/

//I'm sorry, fix this a hard, but to be honest, the armor will appear soon!

public class MatterCrystalArmor /*extends ArmorItem */ {
    /*public MatterCrystalArmor(Slot slot, Properties builderIn) {
        super(MatterArmorTear.MatterCrystalArm, slot, builderIn);
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        if(!player.getPersistentData().contains("wearingFullMatterCrystalArmor"))player.getPersistentData()
                .putBoolean("wearingFullMatterCrystalArmor", false);

        ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
        ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);

        if(!player.getPersistentData().contains("wearingFullMatterCrystalArmor"))player
                .getPersistentData().putBoolean("wearingFullMatterCrystalArmor", false);
        boolean iswearingFullMatterCrystalArmor =
                head != null && head.getItem() == Registration.MATTER_CRYSTAL_HELMET.get() &&
                chest != null && chest.getItem() == Registration.MATTER_CRYSTAL_CHESTPLATE.get() &&
                legs != null && legs.getItem() == Registration.MATTER_CRYSTAL_LEGS.get() &&
                feet != null && feet.getItem() == Registration.MATTER_CRYSTAL_BOOTS.get();

        boolean wasWearingMatterCrystalArmorLastTick = player.getPersistentData()
                .getBoolean("wearingFullMatterCrystalArmor");

        if(!iswearingFullMatterCrystalArmor && wasWearingMatterCrystalArmorLastTick && !player.isCreative())
        {
            player.abilities.allowFlying = false;
            player.abilities.isFlying = false;
        } else if((iswearingFullMatterCrystalArmor) && (world.getDimensionKey()
                .equals(World.OVERWORLD) || world.getDimensionKey().equals(World.THE_NETHER)
                || world.getDimensionKey().equals(World.THE_END)))
        {
            player.abilities.allowFlying = true;
        }
        if(iswearingFullMatterCrystalArmor) {
            //bad effect remove
            if(player.getActivePotionEffect(Effects.BLINDNESS) != null)
            {
                player.removePotionEffect(Effects.BLINDNESS);
            }

            if(player.getActivePotionEffect(Effects.SLOWNESS) != null)
            {
                player.removePotionEffect(Effects.SLOWNESS);
            }

            if(player.getActivePotionEffect(Effects.MINING_FATIGUE) != null)
            {
                player.removePotionEffect(Effects.MINING_FATIGUE);
            }

            if(player.getActivePotionEffect(Effects.INSTANT_DAMAGE) != null)
            {
                player.removePotionEffect(Effects.INSTANT_DAMAGE);
            }

            if(player.getActivePotionEffect(Effects.NAUSEA) != null)
            {
                player.removePotionEffect(Effects.NAUSEA);
            }

            if(player.getActivePotionEffect(Effects.HUNGER) != null)
            {
                player.removePotionEffect(Effects.HUNGER);
            }

            if(player.getActivePotionEffect(Effects.POISON) != null)
            {
                player.removePotionEffect(Effects.POISON);
            }

            if(player.getActivePotionEffect(Effects.WITHER) != null)
            {
                player.removePotionEffect(Effects.WITHER);
            }

            if(player.getActivePotionEffect(Effects.LEVITATION) != null)
            {
                player.removePotionEffect(Effects.LEVITATION);
            }

            if(player.getActivePotionEffect(Effects.UNLUCK) != null)
            {
                player.removePotionEffect(Effects.UNLUCK);
            }

            if(player.getActivePotionEffect(Effects.WEAKNESS) != null)
            {
                player.removePotionEffect(Effects.WEAKNESS);
            }
            //good effect add
            EffectInstance nv = new EffectInstance
                    (Effects.NIGHT_VISION, 300, 0, false, false);
                    player.addPotionEffect(nv);
            EffectInstance regen = new EffectInstance
                    (Effects.REGENERATION, 300, 2147483647, false, false);
                    player.addPotionEffect(regen);
            EffectInstance underWater = new
                    EffectInstance
                    (Effects.WATER_BREATHING, 300, 0, false, false);
                    player.addPotionEffect(underWater);
            EffectInstance haste = new EffectInstance
                    (Effects.HASTE, 300, 20, false, false);
                    player.addPotionEffect(haste);
            EffectInstance saturation = new EffectInstance
                    (Effects.SATURATION, 300, 50, false, false);
                    player.addPotionEffect(saturation);
            EffectInstance strength = new EffectInstance
                    (Effects.STRENGTH, 300, 20, false, false);
                    player.addPotionEffect(strength);
            EffectInstance fr = new EffectInstance
                    (Effects.FIRE_RESISTANCE, 300, 2147483647, false, false);
                    player.addPotionEffect(fr);
            EffectInstance luck = new EffectInstance
                    (Effects.LUCK, 300, 10, false, false);
                    player.addPotionEffect(luck);
        }
        player.getPersistentData().putBoolean("wearingFullMatterCrystalArmor", iswearingFullMatterCrystalArmor);
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlotType slot, String layer)
    {
        if (slot == EquipmentSlotType.LEGS)
        {
            return ModId + ":textures/armor/matter_crystal_2.png";
        }
        else
        {
            return ModId + ":textures/armor/matter_crystal_1.png";
        }
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.matter_crystal_armor1"));
        tooltip.add(new TranslationTextComponent("tooltip.matter_crystal_armor2"));
    }*/
}
