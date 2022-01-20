package com.algorithmlx.liaveres.item.armor;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.item.api.LVArmorTier;
import com.algorithmlx.liaveres.setup.ModSetup;
import com.algorithmlx.liaveres.setup.Registration;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class MatterCrystalArmor extends ArmorItem {
    public MatterCrystalArmor(EquipmentSlot slot) {
        super(LVArmorTier.MatterCrystalTier, slot, new Properties().tab(ModSetup.CLASSIC_TAB).rarity(Rarity.create("LEGENDARY", ChatFormatting.GOLD)));
        MinecraftForge.EVENT_BUS.addListener(this::updatePlayerData);
        MinecraftForge.EVENT_BUS.addListener(this::cancelDamage);
    }

    public void updatePlayerData(LivingEvent.LivingUpdateEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();

        ItemStack head = livingEntity.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = livingEntity.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = livingEntity.getItemBySlot(EquipmentSlot.FEET);

        boolean iswearingFullMatterCrystalArmor =
                head != null && head.getItem() == Registration.MATTER_CRYSTAL_HELMET.get() &&
                        chest != null && chest.getItem() == Registration.MATTER_CRYSTAL_CHESTPLATE.get() &&
                        legs != null && legs.getItem() == Registration.MATTER_CRYSTAL_LEGS.get() &&
                        feet != null && feet.getItem() == Registration.MATTER_CRYSTAL_BOOTS.get();


        if (livingEntity.level.isClientSide && event.equals(Minecraft.getInstance().player)) {
            if (iswearingFullMatterCrystalArmor && livingEntity.isOnGround() && livingEntity.zza > 0F) {
                livingEntity.moveRelative(1.4F, new Vec3( 0, 0, 1));
            }
        }
    }

    public void cancelDamage(LivingDamageEvent event) {
        LivingEntity entity = event.getEntityLiving();
        Random random = new Random();

        ItemStack head = entity.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = entity.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = entity.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = entity.getItemBySlot(EquipmentSlot.FEET);

        boolean iswearingFullMatterCrystalArmor =
                head != null && head.getItem() == Registration.MATTER_CRYSTAL_HELMET.get() &&
                        chest != null && chest.getItem() == Registration.MATTER_CRYSTAL_CHESTPLATE.get() &&
                        legs != null && legs.getItem() == Registration.MATTER_CRYSTAL_LEGS.get() &&
                        feet != null && feet.getItem() == Registration.MATTER_CRYSTAL_BOOTS.get();
        if (event.isCanceled() || event.getAmount() <= 0 || event.getEntityLiving().level.isClientSide) {
            return;
        }

        if (!iswearingFullMatterCrystalArmor) return;


        if (random.nextInt(Integer.MAX_VALUE) > 0) {
            event.setCanceled(true);
        }
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
        if(iswearingFullMatterCrystalArmor && wasWearingMatterCrystalArmorLastTick) {
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

            MobEffectInstance regen = new MobEffectInstance(MobEffects.REGENERATION, 1, 2147483647, false, false);
            player.addEffect(regen);

            MobEffectInstance underWater = new MobEffectInstance(MobEffects.WATER_BREATHING, 1, 0, false, false);
            player.addEffect(underWater);

            MobEffectInstance haste = new MobEffectInstance(MobEffects.DIG_SPEED, 1, 20, false, false);
            player.addEffect(haste);

            MobEffectInstance saturation = new MobEffectInstance(MobEffects.SATURATION, 1, 50, false, false);
            player.addEffect(saturation);

            MobEffectInstance strength = new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1, 20, false, false);
            player.addEffect(strength);

            MobEffectInstance fr = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1, 2147483647, false, false);
            player.addEffect(fr);

            MobEffectInstance luck = new MobEffectInstance(MobEffects.LUCK, 1, 10, false, false);
            player.addEffect(luck);
        }
        player.getPersistentData().putBoolean("wearingFullMatterCrystalArmor", iswearingFullMatterCrystalArmor);
    }

    @Override
    public String getArmorTexture(ItemStack itemstack, Entity entity, EquipmentSlot slot, String layer) {
        if (slot == EquipmentSlot.LEGS) {
            return LiaVeres.ModId + ":textures/armor/matter_crystal/2.png";
        } else {
            return LiaVeres.ModId + ":textures/armor/matter_crystal/1.png";
        }
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TranslatableComponent("msg."+LiaVeres.ModId+".matter_crystal_armor"));
        p_41423_.add(new TranslatableComponent("msg."+LiaVeres.ModId+".matter_crystal_msg"));
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
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
