package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.setup.ModSetup;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

public class EnchantedApple extends Item {
    public EnchantedApple() {
        super(new Properties().rarity(Rarity.EPIC).tab(ModSetup.LIAVERES_ALL).food(new Food.Builder()
                .saturationMod(10)
                .nutrition(10)
                .build()
        ));
    }
    @OnlyIn(Dist.CLIENT)
    @Override
    public void appendHoverText(ItemStack p_77624_1_, @Nullable World p_77624_2_, List<ITextComponent> p_77624_3_, ITooltipFlag p_77624_4_) {
        p_77624_3_.add(new TranslationTextComponent("msg."+ModId+".enchanted_apple"));
        super.appendHoverText(p_77624_1_, p_77624_2_, p_77624_3_, p_77624_4_);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }
}
