package com.algorithmlx.liaveres.common.item.tool;

import com.algorithmlx.liaveres.common.item.api.LVToolMaterial;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.common.LiaVeres.ModId;

public class MatterCrystalSword extends SwordItem {
    public MatterCrystalSword()
    {
        super(LVToolMaterial.MATTER_CRYSTAL, Integer.MAX_VALUE, Float.MAX_VALUE, new Properties().fireResistant().tab(ModSetup.CLASSIC_TAB).rarity(Rarity.valueOf("LEGENDARY")));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TranslatableComponent("msg." + ModId + ".matter_crystal_msg"));
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