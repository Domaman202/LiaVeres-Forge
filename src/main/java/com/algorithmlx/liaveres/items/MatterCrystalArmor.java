package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.itemtears.MatterArmorTear;
import com.algorithmlx.liaveres.registry.Registration;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

public class MatterCrystalArmor extends ArmorItem {
    public MatterCrystalArmor(EquipmentSlotType slot, Properties builderIn) {
        super(MatterArmorTear.MatterCrystalArm, slot, builderIn);
    }

    @Override
    public void onArmorTick(ItemStack stack, World level, PlayerEntity player) {
        super.onArmorTick(stack, level, player);
        if(!player.getPersistentData().contains("wearingFullMatterCrystalArmor"))player.getPersistentData()
                .putBoolean("wearingFullMatterCrystalArmor", false);

        ItemStack head = player.getItemBySlot(EquipmentSlotType.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlotType.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlotType.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlotType.FEET);

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
            player.abilities.flying = false;
            player.abilities.mayfly = false;
        } else if((iswearingFullMatterCrystalArmor) && (level.dimension()
                .equals(World.OVERWORLD) || level.dimension().equals(World.NETHER)
                || level.dimension().equals(World.END)))
        {
            player.abilities.mayfly = true;
        }
        if(iswearingFullMatterCrystalArmor) {
            //bad effect remove
            if(player.getEffect(Effects.BLINDNESS) != null)
            {
                player.removeEffect(Effects.BLINDNESS);
            }

            if(player.getEffect(Effects.MOVEMENT_SLOWDOWN) != null)
            {
                player.removeEffect(Effects.MOVEMENT_SLOWDOWN);
            }

            if(player.getEffect(Effects.DIG_SLOWDOWN) != null)
            {
                player.removeEffect(Effects.DIG_SLOWDOWN);
            }

            if(player.getEffect(Effects.HARM) != null)
            {
                player.removeEffect(Effects.HARM);
            }

            if(player.getEffect(Effects.CONFUSION) != null)
            {
                player.removeEffect(Effects.CONFUSION);
            }

            if(player.getEffect(Effects.HUNGER) != null)
            {
                player.removeEffect(Effects.HUNGER);
            }

            if(player.getEffect(Effects.POISON) != null)
            {
                player.removeEffect(Effects.POISON);
            }

            if(player.getEffect(Effects.WITHER) != null)
            {
                player.removeEffect(Effects.WITHER);
            }

            if(player.getEffect(Effects.LEVITATION) != null)
            {
                player.removeEffect(Effects.LEVITATION);
            }

            if(player.getEffect(Effects.UNLUCK) != null)
            {
                player.removeEffect(Effects.UNLUCK);
            }

            if(player.getEffect(Effects.WEAKNESS) != null)
            {
                player.removeEffect(Effects.WEAKNESS);
            }
            //good effect add
            EffectInstance nv = new EffectInstance
                    (Effects.NIGHT_VISION, 300, 0, false, false);
                    player.addEffect(nv);
            EffectInstance regen = new EffectInstance
                    (Effects.REGENERATION, 300, 2147483647, false, false);
                    player.addEffect(regen);
            EffectInstance underWater = new EffectInstance
                    (Effects.WATER_BREATHING, 300, 0, false, false);
                    player.addEffect(underWater);
            EffectInstance haste = new EffectInstance
                    (Effects.DIG_SPEED, 300, 20, false, false);
                    player.addEffect(haste);
            EffectInstance saturation = new EffectInstance
                    (Effects.SATURATION, 300, 50, false, false);
                    player.addEffect(saturation);
            EffectInstance strength = new EffectInstance
                    (Effects.DAMAGE_BOOST, 300, 20, false, false);
                    player.addEffect(strength);
            EffectInstance fr = new EffectInstance
                    (Effects.FIRE_RESISTANCE, 300, 2147483647, false, false);
                    player.addEffect(fr);
            EffectInstance luck = new EffectInstance
                    (Effects.LUCK, 300, 10, false, false);
                    player.addEffect(luck);
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
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(new TranslationTextComponent("tooltip.matter_crystal_armor1"));
        tooltip.add(new TranslationTextComponent("tooltip.matter_crystal_armor2"));
    }
}
