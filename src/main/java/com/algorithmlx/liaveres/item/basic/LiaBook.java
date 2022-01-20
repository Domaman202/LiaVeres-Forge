package com.algorithmlx.liaveres.item.basic;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.client.screen.book.LiaBookScreen;
import com.algorithmlx.liaveres.setup.ModSetup;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LiaBook extends Item {
    public LiaBook() {
        super(new Item.Properties().tab(ModSetup.CLASSIC_TAB).fireResistant().stacksTo(1));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pLevel.isClientSide) {
            Minecraft.getInstance().setScreen(new LiaBookScreen());
            return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(new TranslatableComponent("msg." + LiaVeres.ModId + ".liaBook"));
        pTooltipComponents.add(new TranslatableComponent("msg." + LiaVeres.ModId + ".liaBook.edition"));
        pTooltipComponents.add(new TranslatableComponent("msg." + LiaVeres.ModId + ".liaBook.author"));
    }
}
