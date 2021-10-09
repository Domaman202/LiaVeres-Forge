package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.itemtears.MatterArmorTear;
import com.algorithmlx.liaveres.registry.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
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
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        super.onArmorTick(stack, world, player);
        if(!player.getPersistentData().contains("wearingFullMatterCrystalArmor"))player.getPersistentData().putBoolean("wearingFullMatterCrystalArmor", false);

        ItemStack head = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        ItemStack chest = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
        ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
        ItemStack feet = player.getItemStackFromSlot(EquipmentSlotType.FEET);

        if(!player.getPersistentData().contains("wearingFullMatterCrystalArmor"))player.getPersistentData().putBoolean("wearingFullMatterCrystalArmor", false);
        boolean iswearingFullMatterCrystalArmor =
                head != null && head.getItem() == ModItems.MATTER_CRYSTAL_HELMET.get() &&
                chest != null && chest.getItem() == ModItems.MATTER_CRYSTAL_CHESTPLATE.get() &&
                legs != null && legs.getItem() == ModItems.MATTER_CRYSTAL_LEGS.get() &&
                feet != null && feet.getItem() == ModItems.MATTER_CRYSTAL_BOOTS.get();

        boolean wasWearingMatterCrystalArmorLastTick = player.getPersistentData().getBoolean("wearingFullMatterCrystalArmor");

        if(!iswearingFullMatterCrystalArmor && wasWearingMatterCrystalArmorLastTick && !player.isCreative())
        {
            player.abilities.allowFlying = false;
            player.abilities.isFlying = false;
        } else if((iswearingFullMatterCrystalArmor) && (world.getDimensionKey().equals(World.OVERWORLD) || world.getDimensionKey().equals(World.THE_NETHER) || world.getDimensionKey().equals(World.THE_END)))
        {
            player.abilities.allowFlying = true;
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
        tooltip.add(new TranslationTextComponent("tooltip.matter_crystal_armor"));
    }
}
