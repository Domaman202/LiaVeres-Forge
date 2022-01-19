package com.algorithmlx.liaveres.item.tool;

import com.algorithmlx.liaveres.item.api.LVItemTier;
import com.algorithmlx.liaveres.setup.ModSetup;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

public class MatterCrystalAxe extends AxeItem {
    public MatterCrystalAxe() {
        super(LVItemTier.MatterTear, 2147483647, 340282356779733661637539395458142568447F, new Properties().fireResistant().tab(ModSetup.CLASSIC_TAB).rarity(Rarity.valueOf("LEGENDARY")));
    }
    @OnlyIn(Dist.CLIENT)
    @Override
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
