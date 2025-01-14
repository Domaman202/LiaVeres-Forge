package com.algorithmlx.liaveres.common.item.tool;

import com.algorithmlx.liaveres.common.item.material.LVToolMaterial;
import com.algorithmlx.liaveres.common.setup.Constants;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.common.LiaVeres.ModId;

public class MatterCrystalHoe extends HoeItem {
    public MatterCrystalHoe() {
        super(LVToolMaterial.MATTER_CRYSTAL, Integer.MAX_VALUE, Float.MAX_VALUE, new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB).rarity(Constants.getLegendary));
    }
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TranslatableComponent("msg."+ModId+".matter_crystal_msg").withStyle(ChatFormatting.RED, ChatFormatting.YELLOW, ChatFormatting.GREEN, ChatFormatting.AQUA, ChatFormatting.BLUE, ChatFormatting.LIGHT_PURPLE));
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
