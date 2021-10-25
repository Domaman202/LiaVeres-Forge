package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.api.enums.LVItemTiers;
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

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class MatterCrystalAxe extends AxeItem {
    public MatterCrystalAxe()
    {
        super(LVItemTiers.MatterTear, 901239.0F, 300F, new Properties().fireResistant().tab(LIAVERES_ALL));
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack s, @Nullable Level w, List<Component> l, TooltipFlag f) {
        l.add(new TranslatableComponent("msg.matter_crystal_axe"));
    }

}
