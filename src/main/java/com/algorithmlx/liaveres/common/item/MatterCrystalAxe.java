package com.algorithmlx.liaveres.common.item;

import com.algorithmlx.liaveres.common.api.enums.LVItemTiers;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.common.LiaVeres.ModId;
import static com.algorithmlx.liaveres.common.setup.ModSetup.LIAVERES_ALL;

public class MatterCrystalAxe extends AxeItem {
    public MatterCrystalAxe()
    {
        super(LVItemTiers.MatterTear, 2147483647, 2147483647, new Properties().fireResistant().tab(LIAVERES_ALL));
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TranslatableComponent("msg."+ModId+".matter_crystal_axe"));
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
