package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.api.enums.LVToolTier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.LiaVeres.ModId;
import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class MatterCrystalShovel extends ShovelItem {
    public MatterCrystalShovel()
    {
        super(LVToolTier.MatterCrystalTier, 340282356779733661637539395458142568447F,340282356779733661637539395458142568447F, new Properties().fireResistant().tab(LIAVERES_ALL));
    }
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> p_77624_3_, ITooltipFlag p_77624_4_) {
        p_77624_3_.add(new TranslationTextComponent("msg."+ModId+".matter_crystal_shovel"));
        super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    }
}
