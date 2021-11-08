package com.algorithmlx.liaveres.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.LiaVeres.ModId;
import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class EffectCatalyst extends Item {
    public EffectCatalyst() {
        super(new Item.Properties().fireResistant().tab(LIAVERES_ALL));
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> p_77624_3_, ITooltipFlag p_77624_4_) {
        p_77624_3_.add(new TranslationTextComponent("msg."+ModId+".effect_catalyst"));
        super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    }
}
