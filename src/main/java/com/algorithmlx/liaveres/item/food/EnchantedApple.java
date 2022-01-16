package com.algorithmlx.liaveres.item.food;

import com.algorithmlx.liaveres.setup.ModSetup;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

public class EnchantedApple extends Item {
    public EnchantedApple() {
        super(new Properties().rarity(Rarity.EPIC).tab(ModSetup.CLASSIC_TAB).food(new FoodProperties.Builder()
                .saturationMod(10)
                .nutrition(10)
                .build()
        ));
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        p_41423_.add(new TranslatableComponent("msg."+ModId+".enchanted_apple").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return true;
    }
}
