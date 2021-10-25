package com.algorithmlx.liaveres.common.items;

import com.algorithmlx.liaveres.common.api.enums.LVArmorTier;
import com.algorithmlx.liaveres.common.registry.Registration;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.common.LiaVeres.ModId;


//I'm sorry, fix this a hard, but to be honest, the armor will appear soon!

public class MatterCrystalArmor extends ArmorItem  {
    public MatterCrystalArmor(EquipmentSlot slot, Properties builderIn) {
        super(LVArmorTier.MatterCrystal, slot, builderIn);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        super.onArmorTick(stack, world, player);
        if(!player.getPersistentData().contains("wearingFullMatterCrystalArmor"))player.getPersistentData()
                .putBoolean("wearingFullMatterCrystalArmor", false);

        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

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
            player.getAbilities().mayfly = false;
            player.getAbilities().flying = false;
        } else if((iswearingFullMatterCrystalArmor) && (world.dimension()
                .equals(Level.OVERWORLD) || world.dimension().equals(Level.NETHER)
                || world.dimension().equals(Level.END)))
        {
            player.getAbilities().mayfly = true;
        }
        if(iswearingFullMatterCrystalArmor) {
            //bad effect remove
            if(player.getEffect(MobEffects.BLINDNESS) != null)
            {
                player.removeEffect(MobEffects.BLINDNESS);
            }

            if(player.getEffect(MobEffects.MOVEMENT_SLOWDOWN) != null)
            {
                player.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }

            if(player.getEffect(MobEffects.DIG_SLOWDOWN) != null)
            {
                player.removeEffect(MobEffects.DIG_SLOWDOWN);
            }

            if(player.getEffect(MobEffects.HARM) != null)
            {
                player.removeEffect(MobEffects.HARM);
            }

            if(player.getEffect(MobEffects.CONFUSION) != null)
            {
                player.removeEffect(MobEffects.CONFUSION);
            }

            if(player.getEffect(MobEffects.HUNGER) != null)
            {
                player.removeEffect(MobEffects.HUNGER);
            }

            if(player.getEffect(MobEffects.POISON) != null)
            {
                player.removeEffect(MobEffects.POISON);
            }

            if(player.getEffect(MobEffects.WITHER) != null)
            {
                player.removeEffect(MobEffects.WITHER);
            }

            if(player.getEffect(MobEffects.LEVITATION) != null)
            {
                player.removeEffect(MobEffects.LEVITATION);
            }

            if(player.getEffect(MobEffects.UNLUCK) != null)
            {
                player.removeEffect(MobEffects.UNLUCK);
            }

            if(player.getEffect(MobEffects.WEAKNESS) != null)
            {
                player.removeEffect(MobEffects.WEAKNESS);
            }
            //good effect add
            MobEffectInstance nv = new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0, false, false);
                    player.addEffect(nv);

            MobEffectInstance regen = new MobEffectInstance(MobEffects.REGENERATION, 300, 2147483647, false, false);
                    player.addEffect(regen);

            MobEffectInstance underWater = new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0, false, false);
                    player.addEffect(underWater);

            MobEffectInstance haste = new MobEffectInstance(MobEffects.DIG_SPEED, 300, 20, false, false);
                    player.addEffect(haste);

            MobEffectInstance saturation = new MobEffectInstance(MobEffects.SATURATION, 300, 50, false, false);
                    player.addEffect(saturation);

            MobEffectInstance strength = new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 20, false, false);
                    player.addEffect(strength);

            MobEffectInstance fr = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 2147483647, false, false);
                    player.addEffect(fr);

            MobEffectInstance luck = new MobEffectInstance(MobEffects.LUCK, 300, 10, false, false);
                    player.addEffect(luck);
        }
        player.getPersistentData().putBoolean("wearingFullMatterCrystalArmor", iswearingFullMatterCrystalArmor);
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot slot, String layer)
    {
        if (slot == EquipmentSlot.LEGS)
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
    public void appendHoverText(ItemStack s, @Nullable Level w, List<Component> l, TooltipFlag f) {
        l.add(new TranslatableComponent("msg.matter_crystal_armor"));
        l.add(new TranslatableComponent("msg.matter_crystal_armor2"));
    }
}
